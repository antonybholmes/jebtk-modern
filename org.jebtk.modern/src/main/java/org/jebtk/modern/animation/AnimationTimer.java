package org.jebtk.modern.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
    
    public AnimationTimerEvents(ActionListener l, int steps) {
      mL = l;
      mSteps = steps;
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
      
      ++mCounter;
      
      // Auto stop after mSteps
      if (mCounter == mSteps) {
          ((Timer)e.getSource()).stop();
          mCounter = 0;
      }
    }
    
    public void reset() {
      setCounter(0);
    }

    public void setCounter(int counter) {
      mCounter = counter;
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
  
  @Override
  public void start() {
    mE.reset();
    super.start();
  }
}
