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

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.theme.DrawUI;

/**
 * The Class DrawUI provides reusable drawing routines that can be shared by
 * multiple widgets. For example a button renderer can be used by a button or to
 * highlight the items in a list view for example.
 */
public abstract class CSSBaseUI extends DrawUI {

  @Override
  public void fill(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {

    cssFill(c, g2, rect, props);
  }

  public static void cssFill(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = cssRounding(c, Math.min(rect.w, rect.h));

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
  public void outline(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    cssOutline(c, g2, rect, props);
  }

  public void cssOutline(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    if (g2.getColor() == null || g2.getColor().getAlpha() == 0) {
      return;
    }

    int rounding = rounding(c, Math.min(rect.w, rect.h));

    if (rounding > 0) {
      if (rect.w == rect.h && rounding >= rect.h / 2) {
        g2.drawOval(rect.x + 1, rect.y + 1, rect.w - 2, rect.w - 2);
      } else {
        // radius to diameter
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
    Object p = getStyle(c).get("border-radius");

    System.err.println(p.getClass().getSimpleName());

    int rounding = 0;

    switch (p.getClass().getSimpleName()) {
    case "Integer":
      rounding = (int) p;
      break;
    case "CSSProp":
      CSSProp prop = (CSSProp) p;

      switch (prop.getType()) {
      case PERCENT:
        rounding = Math.min(h, (int) Math.round(prop.getFloat() / 100 * h));
        break;
      default:
        rounding = 0;
        break;
      }
      break;
    default:
      rounding = 0;
      break;
    }

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
