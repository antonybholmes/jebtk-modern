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

import org.jebtk.core.geom.IntRect;

/**
 * The Class WidgetRenderer.
 */
public abstract class WidgetRenderer {

  /**
   * Draw button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   */
  public void drawButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode) {
    drawButton(g2, x, y, w, h, mode, false);
  }

  /**
   * Draw button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawButtonFill(g2, x, y, w, h, mode, hasFocus);
    drawButtonOutline(g2, x, y, w, h, mode, hasFocus);
  }

  /**
   * Draw pill button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   */
  public void drawPillButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode) {
    drawPillButton(g2, x, y, w, h, mode, false);
  }

  /**
   * Draw a pill shaped button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawPillButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw button outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    buttonOutlinePaint(g2, x, y, w, h, mode, hasFocus);

    outline(g2, x, y, w, h);
  }

  /**
   * Draw button fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.NONE) {
      return;
    }

    buttonFillPaint(g2, x, y, w, h, mode, hasFocus);

    fill(g2, x, y, w, h);
  }

  /**
   * Should set the paint or color used to fill a selected button or object.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void buttonFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Button outline paint.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void buttonOutlinePaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw content box.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void drawContentBox(Graphics2D g2, int x, int y, int w, int h) {
    drawContentBoxFill(g2, x, y, w, h);
    drawContentBoxOutline(g2, x, y, w, h);
  }

  /**
   * Draw content box fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawContentBoxFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  /**
   * Draw content box outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawContentBoxOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  //
  // Dialog button
  //

  /**
   * Draw dialog button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawDialogButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawDialogButtonFill(g2, x, y, w, h, mode, hasFocus);
    drawDialogButtonOutline(g2, x, y, w, h, mode, hasFocus);
  }

  /**
   * Draw dialog button fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawDialogButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw dialog button outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawDialogButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  //
  // Primary Dialog button
  //

  /**
   * Draw primary dialog button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawPrimaryDialogButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawPrimaryDialogButtonFill(g2, x, y, w, h, mode, hasFocus);
    drawPrimaryDialogButtonOutline(g2, x, y, w, h, mode, hasFocus);
  }

  /**
   * Draw primary dialog button fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawPrimaryDialogButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.NONE) {
      return;
    }

    primaryDialogButtonFillPaint(g2, x, y, w, h, mode, hasFocus);

    fill(g2, x, y, w, h);
  }

  /**
   * Primary dialog button fill paint.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void primaryDialogButtonFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw primary dialog button outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawPrimaryDialogButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  //
  // Dialog content
  //

  /**
   * Draw dialog content box.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawDialogContentBox(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  /**
   * Draw dialog fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawDialogFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  //
  // Ribbon
  //

  /**
   * Draw ribbon button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   */
  public void drawRibbonButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode) {
    drawRibbonButton(g2, x, y, w, h, mode, false);
  }

  /**
   * Draw ribbon button.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawRibbonButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawRibbonButtonFill(g2, x, y, w, h, mode, hasFocus);
    drawRibbonButtonOutline(g2, x, y, w, h, mode, hasFocus);
  }

  /**
   * Draw ribbon button fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawRibbonButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw ribbon button outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public abstract void drawRibbonButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  //
  // Menu
  //

  /**
   * Draw menu.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawMenu(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawMenuFill(g2, x, y, w, h, mode, hasFocus);
    drawMenuOutline(g2, x, y, w, h, mode, hasFocus);
  }

  public abstract void menuFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus);

  /**
   * Draw menu fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawMenuFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.NONE) {
      return;
    }

    menuFillPaint(g2, x, y, w, h, mode, hasFocus);

    g2.fillRect(x, y, w, h);
  }

  /**
   * Draw menu outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawMenuOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    // drawButtonOutline(g2, x, y, w, h, mode, hasFocus);
  }

  //
  // General purpose
  //

  /**
   * Draw outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawOutline(Graphics2D g2, int x, int y, int w, int h);

  /**
   * Draw background.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawBackground(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  /**
   * Outline.
   *
   * @param g2 the g 2
   * @param color the color
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void outline(Graphics2D g2, Color color, int x, int y, int w, int h) {
    g2.setColor(color);

    outline(g2, x, y, w, h);
  }

  /**
   * Outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void outline(Graphics2D g2, int x, int y, int w, int h);

  /**
   * Fill.
   *
   * @param g2 the g 2
   * @param color the color
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void fill(Graphics2D g2, Color color, int x, int y, int w, int h) {
    g2.setColor(color);
    fill(g2, x, y, w, h);
  }

  /**
   * Fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void fill(Graphics2D g2, int x, int y, int w, int h);

  /**
   * Gets the selected fill color.
   *
   * @return the selected fill color
   */
  public abstract Color getSelectedFillColor();

  /**
   * Gets the highlight fill color.
   *
   * @return the highlight fill color
   */
  public abstract Color getHighlightFillColor();

  /**
   * Gets the outline color.
   *
   * @return the outline color
   */
  public abstract Color getOutlineColor();

  /**
   * Draw checked.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   * @param mode the mode
   */
  public abstract void drawChecked(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode);

  public void drawCheck(Graphics2D g2, int x, int y, int w, int h) {
    drawCheck(g2, Color.WHITE, x, y, w, h);
  }

  /**
   * Draw check.
   *
   * @param g2 the g 2
   * @param color the color
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawCheck(Graphics2D g2,
      Color color,
      int x,
      int y,
      int w,
      int h);

  /**
   * Draw check box.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void drawCheckBox(Graphics2D g2, int x, int y, int w, int h) {
    // Graphics2D g2Temp = ImageUtils.clone(g2);

    // try {
    // g2.setStroke(ThemeService.DOUBLE_LINE_STROKE);

    drawContentBox(g2, x, y, w, h);
    // } finally {
    // g2Temp.dispose();
    // }
  }

  /**
   * Draw radio.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawRadio(Graphics2D g2, int x, int y, int w, int h);

  /**
   * Draw radio selected.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawRadioSelected(Graphics2D g2,
      int x,
      int y,
      int w,
      int h);

  /**
   * Draw collapse bar.
   *
   * @param g2 the g 2
   * @param name the name
   * @param expanded the expanded
   * @param rect the rect
   */
  public void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      IntRect rect) {
    int w = rect.getW(); // - 1;
    int h = rect.getH(); // - 1;

    drawCollapseBar(g2, name, expanded, rect.getX(), rect.getY(), w, h);
  }

  /**
   * Draw collapse bar.
   *
   * @param g2 the g 2
   * @param name the name
   * @param expanded the expanded
   * @param w the w
   */
  public void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      int w) {
    drawCollapseBar(g2, name, expanded, w, w);
  }

  /**
   * Draw collapse bar.
   *
   * @param g2 the g 2
   * @param name the name
   * @param expanded the expanded
   * @param w the w
   * @param h the h
   */
  public void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      int w,
      int h) {
    drawCollapseBar(g2, name, expanded, 0, 0, w, h);
  }

  /**
   * Draw collapse bar.
   *
   * @param g2 the g 2
   * @param name the name
   * @param expanded the expanded
   * @param x the x
   * @param y the y
   * @param w the w
   */
  public void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      int x,
      int y,
      int w) {
    drawCollapseBar(g2, name, expanded, x, y, w, w);
  }

  /**
   * Draw collapse bar.
   *
   * @param g2 the g 2
   * @param name the name
   * @param expanded the expanded
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public abstract void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      int x,
      int y,
      int w,
      int h);

  //
  // Convenience methods
  //

  /**
   * Draw button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawButton(Graphics2D g2, IntRect rect, RenderMode mode) {
    drawButton(g2, rect, mode, false);
  }

  /**
   * Draw button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawButton(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawButton(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw pill button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawPillButton(Graphics2D g2, IntRect rect, RenderMode mode) {
    drawPillButton(g2, rect, mode, false);
  }

  /**
   * Draw a pill shaped button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawPillButton(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawPillButton(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw button outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawButtonOutline(Graphics2D g2, IntRect rect, RenderMode mode) {
    drawButtonOutline(g2, rect, mode, false);
  }

  /**
   * Draw button outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawButtonOutline(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawButtonOutline(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Button fill paint.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void buttonFillPaint(Graphics2D g2, IntRect rect, RenderMode mode) {
    buttonFillPaint(g2, rect, mode, false);
  }

  /**
   * Set the paint in the current graphics context for filling a button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void buttonFillPaint(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    buttonFillPaint(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw dialog fill.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawDialogFill(Graphics2D g2, IntRect rect) {
    drawDialogFill(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw dialog content box.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawDialogContentBox(Graphics2D g2, IntRect rect) {
    drawDialogContentBox(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH());
  }

  /**
   * Draw ribbon button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawRibbonButton(Graphics2D g2, IntRect rect, RenderMode mode) {
    drawRibbonButton(g2, rect, mode, false);
  }

  /**
   * Draw ribbon button selected.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawRibbonButton(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawRibbonButton(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw ribbon button outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawRibbonButtonOutline(Graphics2D g2,
      IntRect rect,
      RenderMode mode) {
    drawRibbonButtonOutline(g2, rect, mode, false);
  }

  /**
   * Draw ribbon button selected outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawRibbonButtonOutline(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawRibbonButtonOutline(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw menu.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   */
  public void drawMenu(Graphics2D g2, IntRect rect, RenderMode mode) {
    drawMenu(g2, rect, mode, false);
  }

  /**
   * Draw menu.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawMenu(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawMenu(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw primary dialog button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawPrimaryDialogButton(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawPrimaryDialogButton(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw dialog button.
   *
   * @param g2 the g 2
   * @param rect the rect
   * @param mode the mode
   * @param hasFocus the has focus
   */
  public void drawDialogButton(Graphics2D g2,
      IntRect rect,
      RenderMode mode,
      boolean hasFocus) {
    drawDialogButton(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH(),
        mode,
        hasFocus);
  }

  /**
   * Draw background.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawBackground(Graphics2D g2, IntRect rect) {
    drawBackground(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw content box.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawContentBox(Graphics2D g2, IntRect rect) {
    drawContentBox(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawOutline(Graphics2D g2, IntRect rect) {
    drawOutline(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Fill.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void fill(Graphics2D g2, IntRect rect) {
    fill(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Fill.
   *
   * @param g2 the g 2
   * @param color the color
   * @param rect the rect
   */
  public void fill(Graphics2D g2, Color color, IntRect rect) {
    fill(g2, color, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw a pill shaped button fill.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawPillButtonFill(Graphics2D g2, IntRect rect) {
    drawPillButtonFill(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw a pill shaped button fill.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void drawPillButtonFill(Graphics2D g2, int x, int y, int w, int h) {
    g2.fillRoundRect(x, y, w, h, h, h);
  }

  /**
   * Draw a pill button outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawPillButtonOutline(Graphics2D g2, IntRect rect) {
    drawPillButtonOutline(g2,
        rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH());
  }

  /**
   * Draw a pill button outline.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void drawPillButtonOutline(Graphics2D g2, int x, int y, int w, int h) {
    g2.drawRoundRect(x, y, w - 1, h - 1, h, h);
  }

  /**
   * Outline.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void outline(Graphics2D g2, IntRect rect) {
    outline(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

}
