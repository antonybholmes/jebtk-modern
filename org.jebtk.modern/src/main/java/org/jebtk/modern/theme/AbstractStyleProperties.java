package org.jebtk.modern.theme;

import java.awt.Font;

import javax.swing.border.Border;

import org.jebtk.core.Properties;

public class AbstractStyleProperties extends Properties implements StyleProperties {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

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
}
