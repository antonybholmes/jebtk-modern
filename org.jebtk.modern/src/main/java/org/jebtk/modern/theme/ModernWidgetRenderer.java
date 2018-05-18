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
import java.awt.geom.GeneralPath;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.tree.ModernTreeBranchNodeRenderer;
import org.jebtk.modern.widget.ModernWidget;

/**
 * The Class ModernWidgetRenderer.
 */
public class ModernWidgetRenderer extends WidgetRenderer {

  /** The Constant HIGHLIGHTED_FILL_COLOR. */
  public static final Color HIGHLIGHTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getTheme32(10);

  /** The Constant SELECTED_FILL_COLOR. */
  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getTheme32(16);

  // public static final Color MENU_FILL_COLOR =
  // ThemeService.getInstance().colors().getHighlight32(4);

  /** The Constant HIGHLIGHTED_OUTLINE_COLOR. */
  public static final Color HIGHLIGHTED_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getTheme32(14);

  /** The Constant SELECTED_OUTLINE_COLOR. */
  public static final Color SELECTED_OUTLINE_COLOR = ThemeService.getInstance()
      .colors().getTheme32(16);

  /** The Constant DISABLED_OUTLINE_COLOR. */
  public static final Color DISABLED_OUTLINE_COLOR = ThemeService.getInstance()
      .colors().getGray32(8);

  /** The Constant PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR. */
  public static final Color PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getTheme32(22);

  /** The Constant FOCUSED_PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR. */
  public static final Color FOCUSED_PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getTheme32(30);

  /** The Constant LINE_COLOR. */
  public static final Color LINE_COLOR = ThemeService.getInstance().colors()
      .getLineColor();

  /** The Constant LIGHT_LINE_COLOR. */
  public static final Color LIGHT_LINE_COLOR = ThemeService.getInstance()
      .colors().getLightLineColor();

  /** The Constant BACKGROUND_COLOR. */
  public static final Color BACKGROUND_COLOR = Color.WHITE;

  /** The Constant DIALOG_CONTENT_COLOR. */
  private static final Color DIALOG_CONTENT_COLOR = ThemeService.getInstance()
      .colors().getGray32(1);

  /** The Constant DIALOG_BUTTON_FILL_COLOR. */
  public static final Color DIALOG_BUTTON_FILL_COLOR = ThemeService
      .getInstance().colors().getGray32(1);

  /** The Constant DIALOG_BUTTON_OUTLINE_COLOR. */
  public static final Color DIALOG_BUTTON_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getGray32(8);

  /** The Constant FOCUSED_DIALOG_BUTTON_OUTLINE_COLOR. */
  public static final Color FOCUSED_DIALOG_BUTTON_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getGray32(14);

  public static final Color RIBBON_BACKGROUND = ThemeService.getInstance()
      .colors().getTheme32(24);

  public static final Color RIBBON_SELECTED_COLOR = ThemeService.getInstance()
      .colors().getGray32(31);

  /** The Constant RIBBON_SELECTED_FILL_COLOR. */
  public static final Color RIBBON_SELECTED_FILL_COLOR = ColorUtils
      .getTransparentColor80(RIBBON_SELECTED_COLOR);

  /** The Constant RIBBON_SELECTED_HIGHLIGHT_COLOR. */
  public static final Color RIBBON_HIGHLIGHT_FILL_COLOR = ColorUtils
      .getTransparentColor85(RIBBON_SELECTED_COLOR); // RIBBON_SELECTED_FILL_COLOR;

  // ThemeService.getInstance().colors().getHighlight32(6);

  /** The Constant RIBBON_HIGHLIGHTED_OUTLINE_COLOR. */
  public static final Color RIBBON_HIGHLIGHTED_OUTLINE_COLOR = RIBBON_SELECTED_FILL_COLOR; // ThemeService.getInstance().colors().getHighlight32(6);

  /** The Constant RIBBON_SELECTED_OUTLINE_COLOR. */
  public static final Color RIBBON_SELECTED_OUTLINE_COLOR = ColorUtils
      .getTransparentColor75(RIBBON_SELECTED_COLOR); // ThemeService.getInstance().colors().getHighlight32(8);

  /** The Constant RADIO_COLOR. */
  public static final Color RADIO_COLOR = ThemeService.getInstance().colors()
      .getTheme32(14);

  /** The Constant COLLAPSE_FILL_COLOR_1. */
  public static final Color COLLAPSE_FILL_COLOR_1 = ThemeService.getInstance()
      .colors().getGray32(1);

  /** The Constant COLLAPSE_FILL_COLOR_2. */
  public static final Color COLLAPSE_FILL_COLOR_2 = ThemeService.getInstance()
      .colors().getGray32(4);

  /** The Constant PILL_BUTTON_HIGHLIGHT_FILL. */
  private static final Color PILL_BUTTON_HIGHLIGHT_FILL = ThemeService
      .getInstance().colors().getGray32(2);

  /** The Constant PILL_BUTTON_SELECTED_FILL. */
  private static final Color PILL_BUTTON_SELECTED_FILL = ThemeService
      .getInstance().colors().getGray32(4);

  /** The Constant PILL_BUTTON_OUTLINE. */
  private static final Color PILL_BUTTON_OUTLINE = ThemeService.getInstance()
      .colors().getGray32(8);

  /**
   * The constant SCALE.
   */
  public static final double CHECK_SCALE = SettingsService.getInstance()
      .getAsDouble("theme.icons.check-icon.width-scale");

  /**
   * The constant TICK_SCALE.
   */
  public static final double TICK_SCALE = SettingsService.getInstance()
      .getAsDouble("theme.icons.check-icon.tick-scale");

  /** Defines the size of the radio button relative to the rendering space. */
  public static final double RADIO_SCALE = SettingsService.getInstance()
      .getAsDouble("theme.icons.radio-icon.scale");

  /** The Constant RADIO_BUTTON_SCALE. */
  public static final double RADIO_BUTTON_SCALE = 0.1;

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawButtonOutline(java.awt.
   * Graphics2D, int, int, int, int, org.abh.common.ui.theme.RenderMode,
   * boolean)
   */
  @Override
  public void drawButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.NONE && !hasFocus) {
      return;
    }

    buttonOutlinePaint(g2, x, y, w, h, mode, hasFocus);

    outline(g2, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#buttonHighlightedOutlinePaint(java.
   * awt .Graphics2D, int, int, int, int)
   */
  @Override
  public void buttonOutlinePaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.DISABLED) {
      g2.setColor(DISABLED_OUTLINE_COLOR);
    } else {
      g2.setColor(SELECTED_OUTLINE_COLOR);
    }

    /*
     * if (mode == RenderMode.SELECTED) { g2.setColor(SELECTED_OUTLINE_COLOR); }
     * else { g2.setColor(HIGHLIGHTED_OUTLINE_COLOR); }
     */
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#buttonHighlightedFillPaint(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void buttonFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {

    if (mode == RenderMode.NONE) {
      return;
    }

    if (mode == RenderMode.SELECTED) {
      g2.setColor(SELECTED_FILL_COLOR);
    } else {
      g2.setColor(HIGHLIGHTED_FILL_COLOR);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#primaryDialogButtonFillPaint(java.
   * awt. Graphics2D, int, int, int, int, org.abh.common.ui.theme.RenderMode,
   * boolean)
   */
  @Override
  public void primaryDialogButtonFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    drawButtonFill(g2, x, y, w, h, mode, hasFocus);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawPrimaryDialogButtonOutline(java.
   * awt.Graphics2D, int, int, int, int)
   */
  @Override
  public void drawPrimaryDialogButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (hasFocus) {
      outline(g2, FOCUSED_PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR, x, y, w, h);
    } else {
      outline(g2, PRIMARY_DIALOG_BUTTON_OUTLINE_COLOR, x, y, w, h);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawDialogButtonFill(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawDialogButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    fill(g2, DIALOG_BUTTON_FILL_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawDialogButtonOutline(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawDialogButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (hasFocus) {
      outline(g2, FOCUSED_DIALOG_BUTTON_OUTLINE_COLOR, x, y, w, h);
    } else {
      outline(g2, DIALOG_BUTTON_OUTLINE_COLOR, x, y, w, h);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawRibbonButtonFill(java.awt.
   * Graphics2D, int, int, int, int, org.abh.common.ui.theme.RenderMode,
   * boolean)
   */
  @Override
  public void drawRibbonButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.NONE) {
      return;
    }

    fill(g2, RIBBON_SELECTED_FILL_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawRibbonButtonSelectedFill(java.
   * awt. Graphics2D, int, int, int, int)
   */
  @Override
  public void drawRibbonButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    // outline(g2, RIBBON_SELECTED_OUTLINE_COLOR, x, y, w, h);
  }

  @Override
  public void menuFillPaint(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {

    if (mode == RenderMode.SELECTED) {
      g2.setColor(MaterialService.instance().color("gray-selected"));
    } else {
      g2.setColor(MaterialService.instance().color("gray-highlight"));
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawChecked(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void drawChecked(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode) {
    drawButtonFill(g2, x, y, w, h, mode, false);
    drawCheck(g2, Color.WHITE, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawCheck(Graphics2D g2,
      Color color,
      int x,
      int y,
      int w,
      int h) {
    g2.setColor(color);

    g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);

    double wf = w * CHECK_SCALE;
    double t = wf * TICK_SCALE;

    double xf = x + (w - wf) / 2;
    double yf = y + (h - wf) / 2;

    GeneralPath gp = new GeneralPath();

    gp.moveTo(xf, yf + wf - t);
    gp.lineTo(xf + t, yf + wf);
    gp.lineTo(xf + wf, yf);

    g2.draw(gp);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawRadio(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void drawRadio(Graphics2D g2, int x, int y, int w, int h) {
    // Do nothing

    int wf = (int) (w * RADIO_SCALE / 2) * 2;

    x += (w - wf) / 2;
    y += (h - wf) / 2;

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    try {
      g2Temp.setColor(Color.WHITE);
      g2Temp.fillOval(x, y, wf, wf);
      g2Temp.setColor(LINE_COLOR);
      g2Temp.drawOval(x, y, wf, wf);
    } finally {
      g2Temp.dispose();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawRadioSelected(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawRadioSelected(Graphics2D g2, int x, int y, int w, int h) {
    // Do nothing

    int wf = (int) (w * RADIO_SCALE / 2) * 2;
    int i = Math.max(2, (int) (w * RADIO_BUTTON_SCALE));
    int wf2 = wf - 2 * i;

    x += (w - wf) / 2;
    y += (h - wf) / 2;

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    try {
      g2Temp.setColor(Color.WHITE);
      g2Temp.fillOval(x, y, wf, wf);
      g2Temp.setColor(SELECTED_FILL_COLOR);
      g2Temp.fillOval(x + i, y + i, wf2, wf2);
      g2Temp.setColor(SELECTED_OUTLINE_COLOR);
      g2Temp.drawOval(x, y, wf, wf);
    } finally {
      g2Temp.dispose();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawDialogFill(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void drawDialogFill(Graphics2D g2, int x, int y, int w, int h) {
    fill(g2, DIALOG_CONTENT_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawDialogContentBox(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawDialogContentBox(Graphics2D g2, int x, int y, int w, int h) {
    drawDialogFill(g2, x, y, w, h);

    outline(g2, LINE_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawCollapseBar(java.awt.Graphics2D,
   * java.lang.String, boolean, int, int, int, int)
   */
  @Override
  public void drawCollapseBar(Graphics2D g2,
      String name,
      boolean expanded,
      int x,
      int y,
      int w,
      int h) {
    // if (mIsHighlighted) {
    // paintThemeHighlighted(g2, getRect());
    // }

    // if (mIsExpanded) {

    /*
     * GradientPaint gradColor = new GradientPaint(0, 0, COLLAPSE_FILL_COLOR_1,
     * 0, h, COLLAPSE_FILL_COLOR_2);
     * 
     * g2.setPaint(gradColor);
     */

    g2.setColor(COLLAPSE_FILL_COLOR_2);

    g2.fillRect(x, y, w, h);
    // }

    g2.setColor(LINE_COLOR);

    // if (mIsExpanded) {
    // g2.drawLine(x, y, x + w - 1, y);
    // }

    int yt = y + h - 1;

    // g2.drawLine(x, yt, x + w - 1, yt);

    yt = y + (h - 16) / 2;

    if (expanded) {
      ModernTreeBranchNodeRenderer.BRANCH_OPEN_ICON.drawIcon(g2, 0, yt, 16);
    } else {
      ModernTreeBranchNodeRenderer.BRANCH_CLOSED_ICON.drawIcon(g2, 0, yt, 16);
    }

    int xt = x + 16; // +
                     // ModernTheme.getInstance().getClass("widget").getInt("padding");

    yt = ModernWidget.getTextYPosCenter(g2, h);

    g2.setColor(ModernWidget.TEXT_COLOR);

    g2.setFont(ModernWidget.FONT); // SUB_SUB_HEADING_FONT);

    g2.drawString(ModernWidget.getTruncatedText(g2, name, x, w), xt, yt);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawPillButton(java.awt.Graphics2D,
   * int, int, int, int, org.abh.common.ui.theme.RenderMode, boolean)
   */
  @Override
  public void drawPillButton(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    if (mode == RenderMode.SELECTED) {
      g2.setColor(PILL_BUTTON_SELECTED_FILL);
      drawPillButtonFill(g2, x, y, w, h);
    }

    if (mode == RenderMode.HIGHLIGHT) {
      g2.setColor(PILL_BUTTON_HIGHLIGHT_FILL);
      drawPillButtonFill(g2, x, y, w, h);
    }

    g2.setColor(PILL_BUTTON_OUTLINE);
    drawPillButtonOutline(g2, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawOutline(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void drawOutline(Graphics2D g2, int x, int y, int w, int h) {
    outline(g2, LINE_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawContentBoxFill(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawContentBoxFill(Graphics2D g2, int x, int y, int w, int h) {
    fill(g2, BACKGROUND_COLOR, x, y, w, h);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#drawContentBoxOutline(java.awt.
   * Graphics2D, int, int, int, int)
   */
  @Override
  public void drawContentBoxOutline(Graphics2D g2, int x, int y, int w, int h) {
    drawOutline(g2, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.common.ui.theme.WidgetRenderer#drawBackground(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void drawBackground(Graphics2D g2, int x, int y, int w, int h) {
    fill(g2, BACKGROUND_COLOR, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#fill(java.awt.Graphics2D, int,
   * int, int, int)
   */
  @Override
  public void fill(Graphics2D g2, int x, int y, int w, int h) {
    g2.fillRect(x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#outline(java.awt.Graphics2D,
   * int, int, int, int)
   */
  @Override
  public void outline(Graphics2D g2, int x, int y, int w, int h) {
    g2.drawRect(x, y, w - 1, h - 1);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#getSelectedFillColor()
   */
  @Override
  public Color getSelectedFillColor() {
    return SELECTED_FILL_COLOR;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#getHighlightFillColor()
   */
  @Override
  public Color getHighlightFillColor() {
    return HIGHLIGHTED_FILL_COLOR;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.theme.WidgetRenderer#getOutlineColor()
   */
  @Override
  public Color getOutlineColor() {
    return SELECTED_OUTLINE_COLOR;
  }

}
