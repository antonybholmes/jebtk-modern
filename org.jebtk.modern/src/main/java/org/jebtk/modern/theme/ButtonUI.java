package org.jebtk.modern.theme;

import java.awt.Color;

public abstract class ButtonUI extends RoundedUI {
  public static final Color HIGHLIGHTED_FILL_COLOR = MaterialService
      .getInstance().color("gray-highlight");

  public static final Color SELECTED_FILL_COLOR = MaterialService.getInstance()
      .color("gray-selected");
}
