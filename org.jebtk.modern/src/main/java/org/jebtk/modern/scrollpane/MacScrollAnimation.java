package org.jebtk.modern.scrollpane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.jebtk.core.ColorUtils;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class MacScrollAnimation extends HoverFadeAnimation {
  protected static final Color ROUNDED_SCROLLBAR_COLOR_1 = ColorUtils
      .getTransparentColor80(ModernScrollBar.BASE_ROUNDED_COLOR);

  public MacScrollAnimation(ModernScrollBar scrollbar) {
    super(scrollbar);

    setFadeColor("highlight",
        ROUNDED_SCROLLBAR_COLOR_1,
        ModernVScrollBarMac.ROUNDED_SCROLLBAR_COLOR);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    Rectangle r = (Rectangle) params[0];
    int rounding = (Integer) params[1];

    g2.setColor(getFadeColorMap().get("highlight"));

    g2.fillRoundRect(r.x, r.y, r.width, r.height, rounding, rounding);
  }
}
