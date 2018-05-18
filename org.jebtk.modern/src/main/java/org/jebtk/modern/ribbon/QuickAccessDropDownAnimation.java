package org.jebtk.modern.ribbon;

import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.button.ModernDropDownWidget;

public class QuickAccessDropDownAnimation extends ButtonFillAnimation {
  public QuickAccessDropDownAnimation(ModernDropDownWidget button) {
    super(button);
  }

  @Override
  public void animateMouseExited() {
    // If the popup is show, force the animation to display the button
    // by making it opaque and stopping the timer
    if (getButton().getPopupShown()) {
      opaque();
      stopMouseOverTimer();
    } else {
      super.animateMouseExited();
    }
  }
}
