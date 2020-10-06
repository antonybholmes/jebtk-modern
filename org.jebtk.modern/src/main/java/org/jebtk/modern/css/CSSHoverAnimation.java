package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;

public class CSSHoverAnimation extends CSSBorderAnimation {
  public CSSHoverAnimation(ModernWidget w) {
    super(w);

    if (w.getFromKeyFrame().contains("background-color")) {
      setFadeColor("fill", w.getFromKeyFrame().getColor("background-color"),
          w.getToKeyFrame().getColor("background-color"));
    } else {
      setFadeColor("fill", w.getToKeyFrame().getColor("background-color"));
    }
  }

  @Override
  public String getName() {
    return "css-hover";
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    super.draw(c, g2, props);

    if (c.isEnabled()) {
      // update so that we don't keep triggering repaints()

      if (c.isSelected()) {
        c.getCSSProps().update("background-color", getToColor("fill"));
      } else {
        c.getCSSProps().update("background-color", getFadeColor("fill"));
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
