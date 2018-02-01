package org.jebtk.modern.theme;

import java.awt.Graphics2D;

import org.jebtk.core.NameProperty;
import org.jebtk.core.geom.IntRect;

public abstract class UIRenderer implements NameProperty {
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    fill(g2, x, y, w, h, params);
    outline(g2, x, y, w, h, params);
  }

  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    // Do nothing
  }

  public void outline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    // Do nothing
  }

  public final void draw(Graphics2D g2, IntRect rect, Object... params) {
    draw(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH(), params);
  }
}
