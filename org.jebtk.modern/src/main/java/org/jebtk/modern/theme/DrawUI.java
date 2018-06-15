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
package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.NameProperty;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;

/**
 * The Class DrawUI provides reusable drawing routines that can be shared by
 * multiple widgets. For example a button renderer can be used by a button or 
 * to highlight the items in a list view for example.
 */
public abstract class DrawUI implements NameProperty {

  /** The Constant LINE_COLOR. */
  public static final Color LINE_COLOR = ThemeService.getInstance().getColors()
      .getLineColor();

  /**
   * Draw a portion of the widget UI.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param params the params
   */
  public final void draw(Graphics2D g2, IntRect rect, Object... params) {
    draw(g2, null, rect, params);
  }

  /**
   * Draw a portion of the widget UI.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param params the params
   */
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    draw(g2, null, x, y, w, h, params);
  }

  /**
   * Draw a portion of the widget UI.
   *
   * @param g2 the g 2
   * @param c the c
   * @param rect the rect
   * @param params the params
   */
  public final void draw(Graphics2D g2,
      ModernComponent c,
      IntRect rect,
      Object... params) {
    draw(g2, c, rect.getX(), rect.getY(), rect.getW(), rect.getH(), params);
  }

  /**
   * Draw a portion of the widget UI.
   *
   * @param g2 the g 2
   * @param c the c
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param params the params
   */
  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    fill(g2, c, x, y, w, h, params);
    outline(g2, c, x, y, w, h, params);
  }

  /**
   * Fill the widget UI.
   *
   * @param g2 the g 2
   * @param c the c
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param params the params
   */
  public void fill(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    int rounding = getStyle(c).getInt("border-radius");

    if (rounding > 0) {
      g2.fillRoundRect(x, y, w, h, rounding, rounding);
    } else {
      g2.fillRect(x, y, w, h);
    }
  }

  /**
   * Draw an outline around the widget.
   *
   * @param g2 the g 2
   * @param c the c
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param params the params
   */
  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    int rounding = getStyle(c).getInt("border-radius");

    if (rounding > 0) {
      g2.drawRoundRect(x, y, w - 1, h - 1, rounding, rounding);
    } else {
      g2.drawRect(x, y, w - 1, h - 1);
    }
  }

  /**
   * Gets the style class of the component or defaults to the widget style
   * class if the component is null.
   *
   * @param c the c
   * @return the style
   */
  public static StyleProperties getStyle(ModernComponent c) {
    if (c != null) {
      return c.getKeyFrame();
    } else {
      // Return the reference style class if all else fails
      return KeyFramesService.getInstance().getStyleClass("widget");
    }
  }
}
