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

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public class RibbonAnimation extends WidgetAnimation {

  private Ribbon mRibbon;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public RibbonAnimation(ModernWidget ribbon) {
    super(ribbon);

    mRibbon = (Ribbon) ribbon;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    drawBackground(g2);
  }

  /**
   * Draw background.
   *
   * @param g2 the g 2
   */
  public void drawBackground(Graphics2D g2) {
    /*
     * GradientPaint paint = new GradientPaint(0, 0, BAR_BACKGROUND, 0,
     * TAB_BODY_Y, BAR_BACKGROUND_1); g2.setPaint(paint);
     */

    g2.setColor(Color.WHITE); // Ribbon.BAR_BACKGROUND);

    g2.fillRect(0, 0, mRibbon.getWidth(), mRibbon.getHeight()); // Ribbon.TAB_BODY_Y);

    // g2.setColor(Ribbon.TAB_COLOR);

    // g2.fillRect(0, Ribbon.TAB_BODY_Y, mRibbon.getWidth(),
    // mRibbon.mToolbarHeight);

  }
}
