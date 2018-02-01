package org.jebtk.modern.button;

import org.jebtk.modern.button.CircleButtonHighlightAnimation;
import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.graphics.icons.ModernIcon;

public class ModernCircleButton extends ModernButton {

  private static final long serialVersionUID = 1L;

  public ModernCircleButton(ModernIcon icon) {
    super(icon);

    setBackgroundAnimation(new CircleButtonHighlightAnimation(this));
  }

  public ModernCircleButton(ModernIcon icon, String toolTipTitle,
      String toolTipText) {
    this(icon);

    setToolTip(toolTipTitle, toolTipText);
  }
}
