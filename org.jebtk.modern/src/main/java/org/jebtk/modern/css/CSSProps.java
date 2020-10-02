package org.jebtk.modern.css;

import java.awt.Color;
import java.awt.Font;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.theme.ColorGradient;

public class CSSProps extends Props {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public CSSProps() {
    // set("background-color", ColorUtils.TRANS_COLOR);
  }

  public Font getFont(String name) {
    return getFont(name, ModernWidget.FONT);
  }

  public Font getFont(String name, Font font) {
    return (Font) get(name, font);
  }

  // public Border getBorder(String name) {
  // return (Border) get(name);
  // }

  public ColorGradient getColorGradient(String name) {
    return (ColorGradient) get(name);
  }

  @Override
  public Color getColor(String name) {
    return super.getColor(name, ColorUtils.TRANS_COLOR);
  }

  public CSSProp getProp(String name) {
    return (CSSProp) get(name);
  }
}
