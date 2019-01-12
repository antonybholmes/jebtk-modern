package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;

public class ContentOutlineUI extends DrawUI {
  @Override
  public String getName() {
    return "content.outline";
  }

  @Override
  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      //g2.setColor(LINE_COLOR);
      g2.setColor(getStyle(c).getColor("border-color"));
    }

    outline(g2, c, x, y, w, h);
  }
}
