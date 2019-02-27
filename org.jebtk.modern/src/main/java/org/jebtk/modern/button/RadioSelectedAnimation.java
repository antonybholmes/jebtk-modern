package org.jebtk.modern.button;

import java.awt.Color;
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
  public void draw(Graphics2D g2, ModernWidget widget, Object... params) {
    if (widget.isEnabled() && mRadio.isSelected()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - RadioAnimation.RADIO_SIZE) / 2;

      Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

      try {
        fill(g2Temp,
            widget,
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
  public void fill(Graphics2D g2,
      ModernWidget c,
      int x,
      int y,
      int w,
      int h) {
    // Do nothing

    /*
     * int w2 = w - 8;
     * 
     * g2.setColor(getToColor("fill")); g2.fillOval(x + 4, y + 4, w2, w2);
     * 
     * w2 = w - 2; g2.drawOval(x + 1, y + 1, w2, w2);
     */

    g2.setColor(getToColor("fill"));
    g2.fillOval(x, y, w, w);

    int w2 = w - 10;
    g2.setColor(Color.WHITE);
    g2.fillOval(x + 5, y + 5, w2, w2);

  }
}
