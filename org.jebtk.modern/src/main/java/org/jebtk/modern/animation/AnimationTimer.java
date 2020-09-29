package org.jebtk.modern.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jebtk.core.Mathematics;

public class AnimationTimer extends javax.swing.Timer {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final int DELAY_MS = 30;
  public static final int STEPS = 8;
  public static final int MAX_STEP_INDEX = STEPS - 1;

  private static class AnimationTimerEvents implements ActionListener {
    private int mCounter = 0;
    private ActionListener mL;
    private int mSteps;
    private int mMaxIndex;

    public AnimationTimerEvents(ActionListener l, int steps) {
      mL = l;
      mSteps = steps;
      mMaxIndex = mSteps - 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      mL.actionPerformed(e);

      // Auto stop after mSteps
      if (mCounter == mMaxIndex) {
        ((Timer) e.getSource()).stop();
        // mCounter = 0;
      } else {
        // ++mCounter;

        setCounter(mCounter + 1);
      }
    }

    public void reset() {
      setCounter(0);
    }

    public void setCounter(int counter) {
      mCounter = Mathematics.bound(counter, 0, mMaxIndex);
    }

    public int getCounter() {
      return mCounter;
    }
  }

  private AnimationTimerEvents mE;

  public AnimationTimer(ActionListener l) {
    this(l, STEPS);
  }

  public AnimationTimer(ActionListener l, int steps) {
    this(new AnimationTimerEvents(l, steps));
  }

  public AnimationTimer(AnimationTimerEvents e) {
    super(0, e);
    this.mE = e;
    setDelay(DELAY_MS);
  }

  public void reset() {
    setCounter(0);
  }

  public void setCounter(int counter) {
    mE.setCounter(counter);
  }

  public int getCounter() {
    return mE.getCounter();
  }

  @Override
  public void start() {
    super.start();
  }

  public void restart() {
    reset();
    start();
  }
}
