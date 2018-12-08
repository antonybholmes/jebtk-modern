/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jebtk.modern.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jebtk.core.Mathematics;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class TimerAnimation extends WidgetAnimation {

  /**
   * Default delay between animation steps
   */
  public static final int DELAY_MS = 30;

  public static final int STEPS = 8;
  public static final int MAX_STEP_INDEX = STEPS - 1;

  /** The m timer. */
  private Timer mTimer;

  protected int mStep = 0;

  /**
   * The Class StateEvents.
   */
  private class TimerEvents implements ActionListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      animate();
    }
  }

  /**
   * Instantiates a new state animation.
   *
   * @param widget the widget
   */
  public TimerAnimation(ModernWidget w) {
    this(w, DELAY_MS);
  }

  public TimerAnimation(ModernWidget w, int delay) {
    super(w);

    mTimer = new Timer(0, new TimerEvents());
    mTimer.setDelay(delay);
  }

  /**
   * Stop timer.
   */
  public void stop() {
    mTimer.stop();
  }

  public void start() {
    if (!mTimer.isRunning()) {
      mTimer.start();
    }
  }

  /**
   * Animate state.
   */
  public void animate() {
    getWidget().repaint();

    if (++mStep == MAX_STEP_INDEX) {
      stop();
    }
  }

  public void setStep(int step) {
    mStep = Mathematics.bound(step, 0, MAX_STEP_INDEX);
  }

  public void reset() {
    mStep = 0;
  }

  public int getStep() {
    return mStep;
  }

  public boolean stopped() {
    return mStep == MAX_STEP_INDEX;
  }
}
