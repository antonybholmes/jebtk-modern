package org.jebtk.modern.theme;

import java.awt.Graphics2D;

import org.jebtk.core.NameProperty;
import org.jebtk.core.geom.IntRect;

public abstract class UIRenderer implements NameProperty {
  public void draw(Graphics2D g2,
      int w,
      int h,
      boolean hasFocus,
      Object... varargs) {
    draw(g2, 0, 0, w, h, hasFocus, varargs);
  }
  
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      boolean hasFocus,
      Object... varargs) {
    fill(g2, x, y, w, h, hasFocus, varargs);
    outline(g2, x, y, w, h, hasFocus, varargs);
  }
  
  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      boolean hasFocus,
      Object... varargs) {
    // Do nothing
  }
  
  public void outline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      boolean hasFocus,
      Object... varargs) {
    // Do nothing
  }

  public void draw(Graphics2D g2, IntRect rect, boolean hasFocus, Object... varargs) {
    draw(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH(), hasFocus, varargs);
  }
}
