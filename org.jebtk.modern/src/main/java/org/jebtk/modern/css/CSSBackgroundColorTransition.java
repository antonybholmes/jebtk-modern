package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.ColorTransition;
import org.jebtk.modern.theme.DrawUIService;

public class CSSBackgroundColorTransition extends ColorTransition {

  public CSSBackgroundColorTransition(int steps, ModernWidget button) {
    super(steps);

    if (button.getFromKeyFrame().contains("background-color")) {
      setFadeColor("fill", button.getFromKeyFrame().getColor("background-color"),
          button.getToKeyFrame().getColor("background-color"));
    } else {
      setFadeColor("fill", button.getToKeyFrame().getColor("background-color"));
    }
  }

  @Override
  public String getName() {
    return "css-fill-transition";
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
        c.getCSSProps().update("background-color", getColor("fill"));
      }

      // IntRect rect = widget.getRect();
      // fill(g2, widget, rect.getX(), rect.getY(), rect.getW(), rect.getH());
    }
  }

  public void fill(ModernWidget c, Graphics2D g2, IntRect rect) {
    DrawUIService.getInstance().getRenderer("css-background").draw(g2, rect, getColor("fill"));

  }
}
