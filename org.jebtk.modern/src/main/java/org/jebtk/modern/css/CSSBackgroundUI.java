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
package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.theme.ColorGradient;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class CSSBackgroundUI extends CSSBaseUI {

  @Override
  public String getName() {
    return "css-background";
  }

  @Override
  public void draw(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    if (props != null && props.getColor("color") != null) {
      g2.setColor(props.getColor("color"));
    } else {
      if (c != null) {
        ColorGradient lp = c.getCSSProps().getColorGradient("background");

        if (lp != null) {
          lp.paint(g2, c);
        } else {
          System.err.println("css back " + c.getCSSProps().getColor("background-color"));
          
          g2.setColor(c.getCSSProps().getColor("background-color"));
        }
      } else {
        System.err.println("css back 2 " + CSSKeyFramesService.getInstance().getToStyleClass("widget").getColor("background-color"));
        g2.setColor(CSSKeyFramesService.getInstance().getToStyleClass("widget").getColor("background-color"));

        // System.err.println("key " +
        // CSSKeyFramesService.getInstance().getToStyleClass("widget")
        // .getColor("background-color"));
      }
    }

    fill(c, g2, rect, props);
  }
}
