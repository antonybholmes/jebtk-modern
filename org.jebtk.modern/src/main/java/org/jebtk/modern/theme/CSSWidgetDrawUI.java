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
package org.jebtk.modern.theme;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.animation.KeyFramesService;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class CSSWidgetDrawUI extends ButtonOutlineUI {

  @Override
  public String getName() {
    return "css-widget-draw";
  }

  @Override
  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    
    if (c != null) {
      ColorGradient lp = c.getCSSProps().getColorGradient("background");

      if (lp != null) {
        lp.paint(g2, c);
      } else {
        g2.setColor(c.getCSSProps().getColor("background-color"));
      }
    } else {
      g2.setColor(KeyFramesService.getInstance().getToStyleClass("widget")
          .getColor("background-color"));
    }

    fill(g2, c, x, y, w, h);
    
    /*
    if (c != null) {
      ColorGradient lp = c.getCSSProps().getColorGradient("fill");

      if (lp != null) {
        lp.paint(g2, c);
      } else {
        g2.setColor(c.getCSSProps().getColor("fill-color"));
      }
    } else {
      g2.setColor(KeyFramesService.getInstance().getToStyleClass("widget")
          .getColor("fill-color"));
    }
    
    fill(g2, c, x, y, w, h);
    */
    
    // outline
    super.draw(g2, c, x, y, w, h, params);
  }
}
