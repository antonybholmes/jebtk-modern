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
import java.awt.Rectangle;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.theme.DrawUI;

/**
 * The Class DrawUI provides reusable drawing routines that can be shared by
 * multiple widgets. For example a button renderer can be used by a button or to
 * highlight the items in a list view for example.
 */
public abstract class CSSBaseUI extends DrawUI {

  @Override
  public void fill(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Object... params) {

    cssFill(c, g2, rect);
  }

  public static void cssFill(ModernWidget c,
      Graphics2D g2,
      Rectangle rect,
      Object... params) {
    cssFill(c, g2, rect);
  }

  public static void cssFill(ModernComponent c, Graphics2D g2, IntRect rect) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = cssRounding(c, rect.h);

    // System.err.println("round " + rounding + " " + w + " " + h);

    if (rounding > 0) {
      if (rect.w == rect.h && rounding >= rect.h / 2) {
        g2.fillOval(rect.x, rect.y, rect.w - 1, rect.w - 1);
      } else {
        int d = rounding * 2;
        g2.fillRoundRect(rect.x, rect.y, rect.w, rect.h, d, d);
      }
    } else {
      g2.fillRect(rect.x, rect.y, rect.w, rect.h);
    }
  }

  @Override
  public void outline(ModernComponent c,
      Graphics2D g2,
      IntRect rect,
      Object... params) {
    cssOutline(c, g2, rect);
  }

  public void cssOutline(ModernComponent c, Graphics2D g2, IntRect rect) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = rounding(c, rect.h);

    if (rounding > 0) {
      if (rect.w == rect.h && rounding >= rect.h / 2) {
        g2.drawOval(rect.x + 1, rect.y + 1, rect.w - 2, rect.w - 2);
      } else {
        // radius to diamter
        int d = rounding * 2;
        g2.drawRoundRect(rect.x, rect.y, rect.w - 1, rect.h - 1, d, d);
      }
    } else {
      g2.drawRect(rect.x, rect.y, rect.w - 1, rect.h - 1);
    }
  }

  public int rounding(ModernComponent c, int h) {
    return cssRounding(c, h);
  }

  public static int cssRounding(ModernComponent c, int h) {
    Object o = getStyle(c).getValue("border-radius");

    int rounding;

    if (o instanceof Number) {
      rounding = ((Number) o).intValue();
    } else if (o instanceof CSSPercentProp) {
      rounding = Math.min(h,
          (int) Math.round(((CSSPercentProp) o).getFloat() / 100 * h));
    } else {
      rounding = 0;
    }

    // Rounding cannot exceed

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
      return c.getCSSProps(); // getFromKeyFrame();
    } else {
      // Return the reference style class if all else fails
      return CSSKeyFramesService.getInstance().getStyleClass("widget");
    }
  }

}
