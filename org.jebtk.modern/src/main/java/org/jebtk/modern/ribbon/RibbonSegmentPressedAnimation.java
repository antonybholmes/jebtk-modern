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
package org.jebtk.modern.ribbon;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.TranslateAnimation;
import org.jebtk.modern.button.ButtonPressedAnimation;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * The Class RibbonMenuAnimation.
 */
public class RibbonSegmentPressedAnimation extends ButtonPressedAnimation {

  private RibbonSegmentVertTabs mTabs;
  private int mHighlight;

  /**
   * Instantiates a new ribbon menu animation.
   *
   * @param button the button
   */
  public RibbonSegmentPressedAnimation(ModernWidget w) {
    super(w, MaterialService.getInstance().color("ribbon-theme-pressed"));

    mTabs = (RibbonSegmentVertTabs) w;
  }

  @Override
  public void startTimer() {
    // We only want the tab highlighted at the time the mouse is pressed
    // to be animated.
    mHighlight = mTabs.mHighlight;

    super.startTimer();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    // System.err.println("hmm " + isRunning() + " " + isPressed());

    if (getStep() == -1) {
      return;
    }

    int x = mTabs.getInsets().left; // + widget.getWidth() -
                                    // SegmentChangeAnimation.HEIGHT;
    int y = mTabs.getInsets().top;
    int tabWidth = mTabs.getInternalRect().getW();

    if (mHighlight != -1) {

      g2.setColor(mColor);

      double r = TranslateAnimation.BEZ_T[getStep()]; // /
                                                      // (double)TimerAnimation.STEPS;

      int d = (int) (tabWidth * r);

      x += (tabWidth - d) / 2;

      //g2.setColor(mColor);
      //g2.fillRect(x,
      //    y + mHighlight * RibbonSegmentVertTabs.TAB_SIZE,
      ///    d,
      //    RibbonSegmentVertTabs.TAB_SIZE);
      
      UIDrawService.getInstance().get("menu.highlight").draw(g2, 
          x,
          y + mHighlight * RibbonSegmentVertTabs.TAB_SIZE,
          d,
          RibbonSegmentVertTabs.TAB_SIZE,
          mColor);
    }
  }
}
