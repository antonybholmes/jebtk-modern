package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class RadioSelectedAnimation extends ButtonFillAnimation {

  private ModernClickWidget mRadio;

  public RadioSelectedAnimation(ModernWidget widget) {
    super(widget);

    mRadio = (ModernClickWidget) widget;
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled() && mRadio.isSelected()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - RadioAnimation.RADIO_SIZE) / 2;

      Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

      try {
        fill(g2Temp,
            x,
            y,
            RadioAnimation.RADIO_SIZE,
            RadioAnimation.RADIO_SIZE);
      } finally {
        g2Temp.dispose();
      }
    }
  }

  @Override
  public void fill(Graphics2D g2, int x, int y, int w, int h) {
    // Do nothing

    // int wf = (int)(w * ModernWidgetRenderer.RADIO_SCALE / 2) * 2;
    // int i = Math.max(2, (int)(w * ModernWidgetRenderer.RADIO_BUTTON_SCALE));
    int w2 = w - 8;

    // x += (w - wf) / 2;
    // y += (h - wf) / 2;

    // g2.setColor(Color.WHITE);
    // g2.fillOval(x, y, w, w);

    g2.setColor(getFromColor("fill"));

    // g2.drawOval(x, y, wf, wf);

    // g2.setColor(Color.WHITE);
    g2.fillOval(x + 4, y + 4, w2, w2);
    // g2.drawOval(x, y, w2, wf);

    w2 = w - 2;
    // g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);
    g2.drawOval(x + 1, y + 1, w2, w2);
  }
}
