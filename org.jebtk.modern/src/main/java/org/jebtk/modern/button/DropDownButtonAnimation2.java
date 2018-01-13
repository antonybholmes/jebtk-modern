package org.jebtk.modern.button;

import org.jebtk.modern.widget.ModernWidget;

public class DropDownButtonAnimation2 extends ButtonHighlightAnimation {
  public DropDownButtonAnimation2(ModernWidget button) {
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
