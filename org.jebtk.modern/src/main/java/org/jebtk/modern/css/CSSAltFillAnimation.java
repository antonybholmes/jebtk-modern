package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.DrawUIService;

public class CSSAltFillAnimation extends HoverFadeAnimation {

  public CSSAltFillAnimation(ModernWidget button) {
    super(button);

    if (button.getFromKeyFrame().contains("alt-background-color")) {
      setFadeColor("fill", button.getFromKeyFrame().getColor("alt-background-color"),
          button.getToKeyFrame().getColor("alt-background-color"));
    } else {
      setFadeColor("fill", button.getToKeyFrame().getColor("alt-background-color"));
    }
  }

  @Override
  public String getName() {
    return "css-alt-fill";
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
        // c.getToKeyFrame().update("background-color", getToColor("fill"));

        c.getCSSProps().update("background-color", getToColor("fill"));
      } else {
        // c.getToKeyFrame().update("background-color", getFadeColor("fill"));
        c.getCSSProps().update("background-color", getFadeColor("fill"));
      }

      // IntRect rect = widget.getRect();
      // fill(g2, widget, rect.getX(), rect.getY(), rect.getW(), rect.getH());
    }
  }

  public void fill(ModernWidget c, Graphics2D g2, IntRect rect) {
    DrawUIService.getInstance().getRenderer("css-background").draw(g2, rect, getFadeColor("fill"));

  }
}
