package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import org.jebtk.core.settings.SettingsService;

public class CheckedUI extends RoundedUI {
  public static final double CHECK_SCALE = SettingsService.getInstance()
      .getAsDouble("theme.icons.check-icon.width-scale");

  /**
   * The constant TICK_SCALE.
   */
  public static final double TICK_SCALE = SettingsService.getInstance()
      .getAsDouble("theme.icons.check-icon.tick-scale");
  
  @Override
  public String getName() {
    return "check.checked";
  }
  
  @Override
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      g2.setColor(Color.WHITE);
    }

    g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);

    double wf = w * CHECK_SCALE;
    double t = wf * TICK_SCALE;

    double xf = x + (w - wf) / 2;
    double yf = y + (h - wf) / 2;

    GeneralPath gp = new GeneralPath();

    gp.moveTo(xf, yf + wf - t);
    gp.lineTo(xf + t, yf + wf);
    gp.lineTo(xf + wf, yf);

    g2.draw(gp);
  }
}
