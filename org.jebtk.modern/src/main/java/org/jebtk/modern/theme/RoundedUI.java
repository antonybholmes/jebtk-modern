package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class RoundedUI extends UIRenderer {
  public static final int ROUNDING = 6;

  public static final Color LINE_COLOR = ThemeService.getInstance().colors()
      .getLineColor();

  public static void outline(Graphics2D g2, int x, int y, int w, int h) {
    g2.drawRoundRect(x, y, w - 1, h - 1, ROUNDING, ROUNDING);
  }

  public static void fill(Graphics2D g2, int x, int y, int w, int h) {
    g2.fillRoundRect(x, y, w, h, ROUNDING, ROUNDING);
  }
}
