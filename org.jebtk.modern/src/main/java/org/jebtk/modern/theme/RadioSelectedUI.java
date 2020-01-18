package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;

public class RadioSelectedUI extends RadioUI {

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "radio.selected";
  }

  @Override
  public void draw(Graphics2D g2,
      IntRect rect,
      Object... params) {

    super.draw(g2, rect, params);

    int w2 = rect.w - 8;

    // x += (w - wf) / 2;
    // y += (h - wf) / 2;

    // g2.setColor(Color.WHITE);
    // g2.fillOval(x, y, w, w);

    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      g2.setColor(HIGHLIGHTED_FILL_COLOR);
    }

    // g2.drawOval(x, y, wf, wf);

    // g2.setColor(Color.WHITE);
    g2.fillOval(rect.x + 4, rect.y + 4, w2, w2);
    // g2.drawOval(x, y, w2, wf);

    w2 = rect.w - 2;
    // g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);
    g2.drawOval(rect.x + 1, rect.y + 1, w2, w2);
  }
}
