package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonHighlightAnimation extends GenericButtonAnimation {
  private ModernClickWidget mButton;

  public ButtonHighlightAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) { // && (getButton().getHightlighted() ||
                                   // getButton().getPopupShown())) {
      IntRect rect = getWidget().getInternalRect();

      drawButton(g2,
          rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH(),
          mButton.getRenderMode(),
          false);
    }

    // Color c = ColorUtils.getTransparentColor(Color.RED, mTrans);

    // int y = getHeight() / 2;
    //
    // g2.setColor(c);
    // g2.drawLine(0, 0, getWidth(), y);
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
