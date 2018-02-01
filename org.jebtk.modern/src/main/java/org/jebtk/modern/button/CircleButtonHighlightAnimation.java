package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

public class CircleButtonHighlightAnimation extends ButtonHighlightAnimation {
  public CircleButtonHighlightAnimation(ModernWidget button) {
    super(button);

    setFadeColor("fill",
        MaterialService.getInstance().color("gray-highlight"));
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) {

      UIDrawService.getInstance().get("circle.highlight")
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
