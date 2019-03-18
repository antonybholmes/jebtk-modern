package org.jebtk.modern.button;

import org.jebtk.modern.css.CSSAltFillAnimation;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

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
