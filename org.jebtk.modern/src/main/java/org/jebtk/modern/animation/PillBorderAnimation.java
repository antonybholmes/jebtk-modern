package org.jebtk.modern.animation;

import org.jebtk.modern.button.PillOutlineAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class PillBorderAnimation extends PillOutlineAnimation {
  public PillBorderAnimation(ModernWidget widget) {
    super(widget);

    bindChildren();
  }
}
