package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class CircleOutlineAnimation extends ButtonFillAnimation {
  public CircleOutlineAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public String getName() {
    return "circle-outline";
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) {

      DrawUIService.getInstance().getRenderer("circle-outline")
          .draw(g2, getWidget().getInternalRect(), getFadeColor("fill"));

      /*
       * Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);
       * 
       * try { if (widget instanceof ModernClickWidget) { if
       * (((ModernClickWidget) widget).isSelected()) {
       * g2Temp.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); } else {
       * g2Temp.setColor(getFadeColor("fill")); } } else {
       * g2Temp.setColor(getFadeColor("fill")); }
       * 
       * IntRect rect = getWidget().getInternalRect();
       * 
       * g2Temp.fillOval(rect.getX(), rect.getY(), rect.getW(), rect.getH()); }
       * finally { g2Temp.dispose(); }
       */
    }
  }
}
