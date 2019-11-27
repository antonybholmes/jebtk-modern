package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.button.ModernDropDownWidget;
import org.jebtk.modern.css.CSSFillAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class FlatDropDownButtonAnimation extends CSSFillAnimation {
  public FlatDropDownButtonAnimation(ModernDropDownWidget button) {
    super(button);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    // widget.getWidgetRenderer().drawContentBox(g2, widget.getInternalRect());

    DrawUIService.getInstance().getRenderer("content-box").draw(g2,
        widget.getInternalRect());

    super.draw(widget, g2, params);
  }
}
