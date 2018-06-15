package org.jebtk.modern.text;

import org.jebtk.modern.button.ButtonOutlineAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class TextBorderAnimation extends ButtonOutlineAnimation {
  public TextBorderAnimation(ModernWidget widget) {
    super(widget);

    bindChildren();
  }
}
