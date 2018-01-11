package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.MaterialUtils;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CircularButtonHighlightAnimation extends ButtonHighlightAnimation {
  public CircularButtonHighlightAnimation(ModernWidget button) {
    super(button);

    setFadeColor("fill", MaterialUtils.BUTTON_COLOR);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) {

      Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

      try {
        if (widget instanceof ModernClickWidget) {
          if (((ModernClickWidget) widget).isSelected()) {
            g2Temp.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR);
          } else {
            g2Temp.setColor(getFadeColor("fill"));
          }
        } else {
          g2Temp.setColor(getFadeColor("fill"));
        }

        IntRect rect = getWidget().getInternalRect();

        g2Temp.fillOval(rect.getX(), rect.getY(), rect.getW(), rect.getH());
      } finally {
        g2Temp.dispose();
      }
    }
  }
}
