package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.Properties;

public class AbstractStyleProperties extends Properties
    implements StyleProperties {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  public Color getColor(String name) {
    Color color = super.getColor(name);
    
    if (color == null) {
      // Assume we want to go from tranparent to opaque if color is missing
      color = ColorUtils.TRANS_COLOR;
    }
    
    return color;
  }
  
  @Override
  public Border getBorder(String name) {
    return (Border) getValue(name);
  }

  @Override
  public Font getFont(String name) {
    return (Font) getValue(name);
  }

  @Override
  public void clear() {
    // Do nothing
  }

  @Override
  public ColorGradient getColorGradient(String name) {
    return (ColorGradient) getValue(name);
  }
}
