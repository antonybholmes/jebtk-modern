package org.jebtk.modern.button;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.css.CSSHoverAnimation;

public class ButtonFillAnimation extends CSSHoverAnimation {
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
