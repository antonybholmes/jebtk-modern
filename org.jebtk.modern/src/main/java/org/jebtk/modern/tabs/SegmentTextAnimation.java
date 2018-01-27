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
package org.jebtk.modern.tabs;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class SegmentTextAnimation extends WidgetAnimation {

  private SegmentTabs mSegments;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public SegmentTextAnimation(ModernWidget w) {
    super(w);

    mSegments = (SegmentTabs) w;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {

    int x = mSegments.mLeftOffset;
    int n = mSegments.getTabsModel().getTabCount();
    int selectedIndex = mSegments.getTabsModel().getSelectedIndex();

    //
    // Draw the labels
    //

    x = mSegments.mLeftOffset;

    g2.setColor(ModernWidget.TEXT_COLOR);
    g2.setFont(TextTabs.TEXT_TABS_FONT);

    for (int i = 0; i < n; ++i) {
      boolean selected = i == selectedIndex;

      g2.setColor(selected ? Ribbon.BAR_BACKGROUND : ModernWidget.TEXT_COLOR);

      // g2.setFont(selected ? ModernWidget.BOLD_FONT : ModernWidget.FONT);

      int textY = ModernWidget.getTextYPosCenter(g2, mSegments.getHeight());

      String s = mSegments.getTabsModel().getTab(i).getName(); // .toUpperCase();

      g2.drawString(s,
          x + (mSegments.mTabSize - g2.getFontMetrics().stringWidth(s)) / 2,
          textY);

      x += mSegments.mTabSize;
    }
  }
}
