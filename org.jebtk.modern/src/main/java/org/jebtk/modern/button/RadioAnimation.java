package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.widget.ModernWidget;

public class RadioAnimation extends WidgetAnimation {

  public static int RADIO_SIZE = ModernCheckSwitch.SLIDER_HEIGHT + 2;
  private int w2;

  public RadioAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left;
    int y = (widget.getHeight() - RadioAnimation.RADIO_SIZE) / 2;

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    try {
      drawOutline(g2Temp,
          x,
          y,
          RadioAnimation.RADIO_SIZE,
          RadioAnimation.RADIO_SIZE);
    } finally {
      g2Temp.dispose();
    }
  }

  public void drawOutline(Graphics2D g2, int x, int y, int w, int h) {
    // Do nothing

    // x += (w - wf) / 2;
    // y += (h - wf) / 2;

    g2.setColor(Color.WHITE);
    g2.fillOval(x, y, w, w);

    g2.setColor(ModernWidget.LINE_COLOR);

    w2 = w - 2;

    // g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);
    g2.drawOval(x + 1, y + 1, w2, w2);
  }
}
