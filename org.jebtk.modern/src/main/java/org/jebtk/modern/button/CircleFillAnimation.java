package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.theme.DrawUIService;

public class CircleFillAnimation extends ButtonFillAnimation {
  public CircleFillAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public String getName() {
    return "circle-fill";
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (widget.isEnabled()) {

      DrawUIService.getInstance().getRenderer("circle-fill").draw(widget, g2, getFadeColor("fill"));

      /*
       * Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);
       * 
       * try { if (widget instanceof ModernClickWidget) { if (((ModernClickWidget)
       * widget).isSelected()) {
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
