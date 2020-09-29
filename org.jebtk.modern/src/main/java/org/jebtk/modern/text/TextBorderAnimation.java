package org.jebtk.modern.text;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.button.ButtonOutlineAnimation;

public class TextBorderAnimation extends ButtonOutlineAnimation {
  public TextBorderAnimation(ModernWidget widget) {
    super(widget);

    bindChildren();
  }
}
