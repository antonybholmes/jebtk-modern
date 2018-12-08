package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonOutlineAnimation extends HoverFadeAnimation {
  public ButtonOutlineAnimation(ModernWidget button) {
    super(button);

    if (button.getFromKeyFrame().contains("border-color")) {
      setFadeColor("outline",
          button.getFromKeyFrame().getColor("border-color"),
          button.getToKeyFrame().getColor("border-color"));
    } else {
      setFadeColor("outline", button.getToKeyFrame().getColor("border-color"));
    }
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
      IntRect rect = widget.getRect(); // getInternalRect();

      outline(g2, widget, rect.getX(), rect.getY(), rect.getW(), rect.getH());
    }
  }

  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    DrawUIService.getInstance().getRenderer("button-outline")
        .draw(g2, c, x, y, w, h, getFadeColor("outline"));

    // g2.setColor(getFadeColor("outline"));

    // outline(g2, x, y, w, h);
  }

  // public void outline(Graphics2D g2, int x, int y, int w, int h) {
  // getWidget().getWidgetRenderer().outline(g2, x, y, w, h);
  //
  // UIDrawService.getInstance().get("button-outline").draw(g2, x, y, w, h,
  // getFadeColor("outline"));
  // }
}
