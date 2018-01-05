package org.jebtk.modern.dialog;

import java.awt.Color;

import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;

public class DialogButtonHighlightAnimation extends ButtonHighlightAnimation {
  public static final Color OUTLINE_COLOR_1 = ThemeService.getInstance().colors().getHighlight32(8);

  public static final Color OUTLINE_COLOR_2 = ThemeService.getInstance().colors().getHighlight32(12);

  public static final Color FILL_1 = ThemeService.getInstance().colors().getHighlight32(5);

  public static final Color FILL_2 = ThemeService.getInstance().colors().getHighlight32(10);

  public DialogButtonHighlightAnimation(ModernWidget button) {
    super(button);

    setFadeColor("outline", OUTLINE_COLOR_1, OUTLINE_COLOR_2);
    setFadeColor("fill", FILL_1, FILL_2);
  }
}
