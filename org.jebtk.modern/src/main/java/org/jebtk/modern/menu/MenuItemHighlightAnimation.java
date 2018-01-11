package org.jebtk.modern.menu;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernWidget;

public class MenuItemHighlightAnimation extends WidgetAnimation {

  protected ModernMenuItem mButton;

  public MenuItemHighlightAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernMenuItem) button;
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (mButton.isEnabled() && mButton.getHightlighted()) {
      widget.getWidgetRenderer()
          .drawMenu(g2, widget.getRect(), RenderMode.HIGHLIGHT);
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
