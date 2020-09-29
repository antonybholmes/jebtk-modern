package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.HoverFadeAnimation;

public class CSSFillAnimation extends HoverFadeAnimation {
  private static final String NAME = "css-background";

  public CSSFillAnimation(ModernWidget button) {
    super(button);

    if (button.getFromKeyFrame().contains("background-color")) {
      System.err.println("fggf " + button.getFromKeyFrame().getColor("background-color") + " "
          + button.getToKeyFrame().getColor("background-color"));
      setFadeColor("fill", button.getFromKeyFrame().getColor("background-color"),
          button.getToKeyFrame().getColor("background-color"));
    } else {
      setFadeColor("fill", button.getToKeyFrame().getColor("background-color"));
    }
  }

  @Override
  public String getName() {
    return NAME;
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
