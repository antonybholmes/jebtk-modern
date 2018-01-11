package org.jebtk.modern.menu;

import java.awt.Graphics2D;

import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.widget.ModernWidget;

public class MenuItemColorHighlightAnimation
    extends MenuItemHighlightAnimation {
  public MenuItemColorHighlightAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (mButton.isEnabled() && mButton.getHightlighted()) {
      ModernWidget
          .fill(g2, ModernWidgetRenderer.SELECTED_FILL_COLOR, widget.getRect());
    }
  }

  /*
   * @Override public void outline(Graphics2D g2, int x, int y, int w, int h) {
   * g2.drawRect(x, y, w - 1, h - 1); }
   * 
   * @Override public void fill(Graphics2D g2, int x, int y, int w, int h) {
   * g2.fillRect(x, y, w, h); }
   */

}
