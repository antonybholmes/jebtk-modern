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

import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class MousePressedStepAnimation extends MousePressedAnimation {

  private int mStep = -1;

  /**
   * Instantiates a new hover fade animation.
   *
   * @param widget
   *          the widget
   */
  public MousePressedStepAnimation(ModernWidget widget) {
    super(widget);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.MouseAnimation#animateMouseEntered()
   */
  @Override
  public void animateMousePressed() {
    getWidget().repaint();

    if (mStep == TimerAnimation.MAX_STEP_INDEX) {
      stopTimer();
    } else {
      ++mStep;
    }
  }

  public int getStep() {
    return mStep;
  }

  @Override
  public void startTimer() {
    mStep = 0;

    super.startTimer();
  }

  @Override
  public void reset() {
    mStep = -1;

    super.reset();
  }
}
