package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

public class ContentUI extends RoundedUI {
  @Override
  public String getName() {
    return "content";
  }

  @Override
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    g2.setColor(Color.WHITE);
    fill(g2, x, y, w, h);
  }
}
