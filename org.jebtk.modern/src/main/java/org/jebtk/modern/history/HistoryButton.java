package org.jebtk.modern.history;

import org.jebtk.modern.button.CircleButtonHighlightAnimation;
import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.graphics.icons.ModernIcon;

public class HistoryButton extends ModernButton {
  
  private static final long serialVersionUID = 1L;

  public HistoryButton(ModernIcon icon) {
    super(icon);
    
    setBackgroundAnimation(new CircleButtonHighlightAnimation(this));
  }

}
