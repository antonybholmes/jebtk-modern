package org.jebtk.modern.button;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.css.CSSAltFillAnimation;

public class ButtonAltFillAnimation extends CSSAltFillAnimation {
  private ModernClickWidget mButton;

  public ButtonAltFillAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;
  }

  @Override
  public String getName() {
    return "button-alt-fill";
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
