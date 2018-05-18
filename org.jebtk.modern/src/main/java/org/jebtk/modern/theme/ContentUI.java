package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;

public class ContentUI extends UIRenderer {
  @Override
  public String getName() {
    return "content";
  }

  @Override
  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    g2.setColor(Color.WHITE);
    fill(g2, c, x, y, w, h);
  }
}
