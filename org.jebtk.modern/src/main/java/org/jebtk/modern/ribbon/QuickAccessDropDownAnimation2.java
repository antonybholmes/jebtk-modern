package org.jebtk.modern.ribbon;

import org.jebtk.modern.button.ModernDropDownWidget2;

public class QuickAccessDropDownAnimation2 extends QuickAccessAnimation {
  public QuickAccessDropDownAnimation2(ModernDropDownWidget2 button) {
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