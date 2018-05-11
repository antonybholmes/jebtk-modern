package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.theme.UIDrawService;
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
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) { // && (getButton().getHightlighted() ||
      // getButton().getPopupShown())) {
      IntRect rect = getWidget().getInternalRect();
      
      if (mButton.isSelected()) {
        g2.setColor(SELECTED);
      } else {
        g2.setColor(getFadeColor("fill"));
      }

      //mButton.getWidgetRenderer().drawPillButtonFill(g2, x, y, w, h);

      UIDrawService.getInstance().get("pill.highlight").draw(g2, rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH(),
          mButton.isSelected() ? SELECTED : getFadeColor("fill"));
    }
  }
}
