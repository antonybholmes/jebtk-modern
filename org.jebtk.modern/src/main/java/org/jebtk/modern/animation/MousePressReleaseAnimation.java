package org.jebtk.modern.animation;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class MousePressReleaseAnimation extends WidgetAnimation {

  /** The m mouse over timer. */
  private Timer mTimer;

  protected boolean mPressed = false;

  /**
   * The Class MouseEvents.
   */
  private class MouseEvents extends MouseAdapter {
    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e) {
      mPressed = true;

      startTimer();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      mPressed = false;

      startTimer();
    }

    @Override
    public void mouseExited(MouseEvent e) {
      reset();
    }
  }

  /**
   * The Class HoverEvents.
   */
  private class PressedEvents implements ActionListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      animateMousePressed();
    }
  }

  /**
   * Instantiates a new mouse animation.
   *
   * @param widget the widget
   */
  public MousePressReleaseAnimation(ModernWidget widget) {
    super(widget);

    mTimer = new Timer(0, new PressedEvents());
    mTimer.setDelay(TimerAnimation.DELAY_MS);
    // mMouseClickedTimer = new Timer(0, new ClickedEvents());
    // mMouseClickedTimer.setDelay(DELAY_MS);

    bind(widget);
  }

  /**
   * Bind the widget so it can respond with an animation. This widget can be
   * auxiliary to the primary widget whose animation is being controlled.
   * 
   * @param widget
   * @return
   */
  public MousePressReleaseAnimation bind(Component c) {
    c.addMouseListener(new MouseEvents());

    return this;
  }

  public void startTimer() {
    if (!mTimer.isRunning()) {
      mTimer.start();
    }
  }

  /**
   * Stop mouse over timer.
   */
  public void stopTimer() {
    mTimer.stop();

    getWidget().repaint();
  }

  public void reset() {
    stopTimer();
  }

  /**
   * Returns true if the timer is running.
   * 
   * @return
   */
  public boolean isRunning() {
    return mTimer.isRunning();
  }

  public boolean isPressed() {
    return mPressed;
  }

  /**
   * Animate mouse entered.
   */
  public void animateMousePressed() {

  }
}