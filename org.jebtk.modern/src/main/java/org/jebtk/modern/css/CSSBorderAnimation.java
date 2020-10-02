package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.HoverFadeAnimation;

public class CSSBorderAnimation extends HoverFadeAnimation {
  public CSSBorderAnimation(ModernWidget w) {
    super(w);

    if (w.getFromKeyFrame().contains("border-color")) {
      setFadeColor("border", w.getFromKeyFrame().getColor("border-color"), w.getToKeyFrame().getColor("border-color"));
    } else {
      setFadeColor("border", w.getToKeyFrame().getColor("border-color"));
    }
  }

  @Override
  public String getName() {
    return "css-border";
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (c.isEnabled()) {
      // update so that we don't keep triggering repaints()

      if (c.isSelected()) {
        c.getCSSProps().update("border-color", getToColor("border"));
      } else {
        c.getCSSProps().update("border-color", getFadeColor("border"));
      }

      // IntRect rect = widget.getRect();
      // fill(g2, widget, rect.getX(), rect.getY(), rect.getW(), rect.getH());
    }
  }

//  public void fill(ModernWidget c, Graphics2D g2, int x, int y, int w, int h) {
//    DrawUIService.getInstance().getRenderer(NAME)
//        .draw(g2, x, y, w, h, getFadeColor("fill"));
//
//  }
}
