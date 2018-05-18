package org.jebtk.modern.theme;

import java.awt.Color;

public abstract class ColorButtonUI extends UIRenderer {
  public static final Color HIGHLIGHTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getTheme32(6);

  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getTheme32(8);
}
