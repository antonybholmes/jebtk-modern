package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernTwoStateWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ChipButtonHighlightAnimation extends ButtonHighlightAnimation {
  public static final Color HIGHLIGHT = ThemeService.getInstance().colors()
      .getHighlight32(4);

  public static final Color SELECTED = ThemeService.getInstance().colors()
      .getHighlight32(6);

  private ModernTwoStateWidget mButton;

  public ChipButtonHighlightAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernTwoStateWidget) button;

    setFadeColor("fill", HIGHLIGHT);
  }

  @Override
  public void fill(Graphics2D g2, int x, int y, int w, int h) {
    if (mButton.isSelected()) {
      g2.setColor(SELECTED);
    } else {
      g2.setColor(getFadeColor("fill"));
    }

    mButton.getWidgetRenderer().drawPillButtonFill(g2, x, y, w, h);
  }
}
