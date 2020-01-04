package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.ModernWidget;

public class RadioUI extends ButtonUI {

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "radio";
  }

  @Override
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    g2.setColor(Color.WHITE);
    g2.fillOval(x, y, w, w);

    g2.setColor(ModernWidget.LINE_COLOR);

    int w2 = w - 2;

    // g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);
    g2.drawOval(x + 1, y + 1, w2, w2);
  }
}
