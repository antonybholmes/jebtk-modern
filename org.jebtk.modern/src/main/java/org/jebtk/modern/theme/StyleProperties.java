package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;

import org.jebtk.core.Properties;

/**
 * All style property objects and contains must implement these methods.
 * 
 * @author antony
 *
 */
public interface StyleProperties {
  public int getInt(String name);
  
  public double getDouble(String name);
  
  public Color getColor(String name);
  
  public ColorGradient getColorGradient(String name);
  
  public Border getBorder(String name);
  
  public Font getFont(String name);
  
  public String toString(String name);

  public Properties set(String name, Object value);
  
  /**
   * Returns the property with a given name as its original object.
   * 
   * @param name
   * @return
   */
  public Object getValue(String name);
  
  public boolean contains(String name);
}
