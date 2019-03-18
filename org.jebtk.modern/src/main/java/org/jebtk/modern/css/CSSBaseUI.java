/**
 * Copyright 2018 Antony Holmes
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

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.theme.DrawUI;

/**
 * The Class DrawUI provides reusable drawing routines that can be shared by
 * multiple widgets. For example a button renderer can be used by a button or to
 * highlight the items in a list view for example.
 */
public abstract class CSSBaseUI extends DrawUI {

  @Override
  public void fill(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }
    
    int rounding = rounding(c, h);
    
    //System.err.println("round " + rounding + " " + g2.getColor());
     
    if (rounding > 0) {
      if (w == h && rounding >= h / 2) {
        g2.fillOval(x, y, h - 1, h - 1);
      } else {
        int d = rounding * 2;
        g2.fillRoundRect(x, y, w, h, d, d);
      }
    } else {
      g2.fillRect(x, y, w, h);
    }
  }
  
  @Override
  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }
    
    int rounding = rounding(c, h);

    if (rounding > 0) {
      if (w == h && rounding >= h / 2) {
        g2.drawOval(x + 1, y + 1, w - 2, w - 2);
      } else {
        // radius to diamter
        int d = rounding * 2;
        g2.drawRoundRect(x, y, w - 1, h - 1, d, d);
      }
    } else {
      g2.drawRect(x, y, w - 1, h - 1);
    }
  }
  
  public int rounding(ModernComponent c, int h) {
    Object o = getStyle(c).getValue("border-radius");

    int rounding;
    
    if (o instanceof Number) {
      rounding = ((Number)o).intValue();
    } else if (o instanceof CSSPercentProp) {
      rounding = Math.min(h, (int)Math.round(((CSSPercentProp)o).getDouble() / 100 * h));
    } else {
      rounding = 0;
    }
    
    //Rounding cannot exceed
    
    return rounding;
  }

  /**
   * Gets the style class of the component or defaults to the widget style class
   * if the component is null.
   *
   * @param c the c
   * @return the style
   */
  public static CSSProps getStyle(ModernComponent c) {
    if (c != null) {
      return c.getCSSProps(); //getFromKeyFrame();
    } else {
      // Return the reference style class if all else fails
      return CSSKeyFramesService.getInstance().getStyleClass("widget");
    }
  }
}
