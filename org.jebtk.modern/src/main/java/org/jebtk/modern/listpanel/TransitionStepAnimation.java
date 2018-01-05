package org.jebtk.modern.listpanel;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.TimerAnimation;
import org.jebtk.modern.animation.TranslateAnimation;
import org.jebtk.modern.widget.ModernWidget;

public abstract class TransitionStepAnimation extends TimerAnimation {
  /** The m pos. */
  private double[] mPos = new double[TranslateAnimation.STEPS];

  /** The m step. */
  private int mStep;

  public TransitionStepAnimation(ModernWidget w) {
    super(w);
  }

  public void start(double y1, double y2) {
    setup(y1, y2);

    start();
  }

  /**
   * Instantiates a new animate movement.
   *
   * @param index
   *          the index
   * @param y2
   *          the y 2
   */
  public void setup(double y1, double y2) {
    double mD = y2 - y1;

    mStep = 0;

    mPos[0] = y1;
    mPos[mPos.length - 1] = y2;

    for (int i = 1; i < TranslateAnimation.MAX_STEP_INDEX; ++i) {
      mPos[i] = y1 + TranslateAnimation.BEZ_T[i] * mD;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  @Override
  public synchronized void animate() {
    animate(mStep, mPos[mStep]);

    if (++mStep == TranslateAnimation.STEPS) {
      // Auto stop timer once we run out of steps
      stop();
    }

  }

  public abstract void animate(int step, double x);

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    // Do nothing
  }
}
