package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

public class FlatButtonAnimation extends ButtonHighlightAnimation {
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
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    UIDrawService.getInstance().get("content-box").draw(g2, widget.getInternalRect());

    super.draw(widget, g2, params);
  }
}
