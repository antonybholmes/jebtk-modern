package org.jebtk.modern.button;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.css.CSSFillAnimation;

public class ButtonFillAnimation extends CSSFillAnimation {
  private ModernClickWidget mButton;

  public ButtonFillAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;
  }

  @Override
  public String getName() {
    return "button-fill";
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
