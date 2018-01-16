package org.jebtk.modern.theme.renderers;

import java.awt.Color;

import org.jebtk.modern.theme.ThemeService;

public abstract class ButtonUI extends RoundedUI {
  public static final Color HIGHLIGHTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getHighlight32(8);
  
  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getHighlight32(10);
}
