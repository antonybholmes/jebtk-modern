package org.jebtk.modern.theme;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.WidgetAnimation;



public class PillContentAnimation extends WidgetAnimation {
  public PillContentAnimation(ModernWidget widget) {
    super(widget);
  }
  
  @Override
  public String getName() {
    return "pill-content";
  }
  
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    DrawUIService.getInstance().getRenderer("pill-content").draw(g2, widget, widget.getRect());

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
