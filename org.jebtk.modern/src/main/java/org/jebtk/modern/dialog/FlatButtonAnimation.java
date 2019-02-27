package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class FlatButtonAnimation extends ButtonFillAnimation {
  public FlatButtonAnimation(ModernWidget button) {
    super(button);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(Graphics2D g2, ModernWidget widget, Object... params) {
    DrawUIService.getInstance().getRenderer("content-box").draw(g2,
        widget.getInternalRect());

    super.draw(g2, widget, params);
  }
}
