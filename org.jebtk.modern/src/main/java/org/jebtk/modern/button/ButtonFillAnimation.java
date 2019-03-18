package org.jebtk.modern.button;

import org.jebtk.modern.css.CSSFillAnimation;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

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
