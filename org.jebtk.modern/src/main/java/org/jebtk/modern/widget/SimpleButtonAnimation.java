package org.jebtk.modern.widget;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.Animation;
import org.jebtk.modern.theme.UIDrawService;

public class SimpleButtonAnimation implements Animation {

  public static final Animation BUTTON_ANIMATION = new SimpleButtonAnimation();

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {

    ModernClickWidget button = (ModernClickWidget) widget;

    if (button.isEnabled()) {
      UIDrawService.getInstance().get("button.highlight")
      .draw(g2, button.getInternalRect());
    }
  }
}
