package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.widget.ModernWidget;

public class RadioOutlineAnimation extends ButtonOutlineAnimation {
  public RadioOutlineAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - RadioAnimation.RADIO_SIZE) / 2;

      Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

      try {
        outline(g2Temp,
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
  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h) {
    // Do nothing

    int wf = (int) (w * RadioAnimation.RADIO_SCALE / 2) * 2;

    x += (w - wf) / 2;
    y += (h - wf) / 2;

    g2.setColor(getFadeColor("outline")); // SELECTED_OUTLINE_COLOR);
    g2.drawOval(x, y, wf, wf);
  }
}
