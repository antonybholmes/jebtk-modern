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

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class ButtonFillUI extends ButtonUI {

  @Override
  public String getName() {
    return "button-fill";
  }

  @Override
  public void draw(Graphics2D g2, 
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      if (c != null) {
        ColorGradient lp = c.getToKeyFrame().getColorGradient("background");
        
        if (lp != null) {
          lp.paint(g2, c);
        } else {
          g2.setColor(c.getToKeyFrame().getColor("background-color"));
        }
      } else {
        g2.setColor(KeyFramesService.getInstance().getToStyleClass("widget").getColor("background-color"));
      }
    }
    
    

    fill(g2, c, x, y, w, h);
  }
}