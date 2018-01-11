package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonOutlineAnimation extends HoverFadeAnimation {
  private ModernClickWidget mButton;

  public ButtonOutlineAnimation(ModernClickWidget button) {
    super(button);

    mButton = button;

    setFadeColor("outline", ModernWidgetRenderer.SELECTED_OUTLINE_COLOR);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled()) {
      IntRect rect = widget.getInternalRect();

      drawButtonOutline(g2,
          rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH(),
          mButton.getRenderMode(),
          false);
    }
  }

  public void drawButtonOutline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    g2.setColor(getFadeColor("outline"));

    outline(g2, x, y, w, h);
  }

  public void outline(Graphics2D g2, int x, int y, int w, int h) {
    getWidget().getWidgetRenderer().outline(g2, x, y, w, h);
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
