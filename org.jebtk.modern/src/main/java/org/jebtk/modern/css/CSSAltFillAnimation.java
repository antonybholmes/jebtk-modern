package org.jebtk.modern.css;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class CSSAltFillAnimation extends HoverFadeAnimation {

  public CSSAltFillAnimation(ModernWidget button) {
    super(button);

    if (button.getFromKeyFrame().contains("alt-background-color")) {
      setFadeColor("fill",
          button.getFromKeyFrame().getColor("alt-background-color"),
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
  public void draw(Graphics2D g2, ModernWidget c, Object... params) {
    if (c.isEnabled()) {
      // update so that we don't keep triggering repaints()
      
      if (c.isSelected()) {
        //c.getToKeyFrame().update("background-color", getToColor("fill"));
        
        c.getCSSProps().update("background-color", getToColor("fill"));
      } else {
        //c.getToKeyFrame().update("background-color", getFadeColor("fill"));
        c.getCSSProps().update("background-color", getFadeColor("fill"));
      }
      
      //IntRect rect = widget.getRect();
      //fill(g2, widget, rect.getX(), rect.getY(), rect.getW(), rect.getH());
    }
  }

  public void fill(Graphics2D g2,
      ModernWidget c,
      int x,
      int y,
      int w,
      int h) {
    DrawUIService.getInstance().getRenderer("css-background")
    .draw(g2, x, y, w, h, getFadeColor("fill"));
    
  }
}
