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

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class SegmentAnimation extends WidgetAnimation {

  private static final Color BG = ThemeService.getInstance().colors()
      .getHighlight(2);

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public SegmentAnimation(ModernWidget w) {
    super(w);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    UIDrawService.getInstance().get("button.highlight")
        .draw(g2, widget.getRect(), BG);
  }
}
