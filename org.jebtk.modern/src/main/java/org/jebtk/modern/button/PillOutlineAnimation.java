package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class PillOutlineAnimation extends ButtonOutlineAnimation {
  public PillOutlineAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    DrawUIService.getInstance().getRenderer("pill-outline")
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
