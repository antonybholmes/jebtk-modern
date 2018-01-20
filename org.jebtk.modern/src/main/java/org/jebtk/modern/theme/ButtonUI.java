package org.jebtk.modern.theme;

import java.awt.Color;

public abstract class ButtonUI extends RoundedUI {
  public static final Color HIGHLIGHTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getHighlight32(6);
  
  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getHighlight32(8);
}
