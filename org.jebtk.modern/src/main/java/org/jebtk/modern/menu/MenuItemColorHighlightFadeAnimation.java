package org.jebtk.modern.menu;

import java.awt.Graphics2D;

import org.jebtk.modern.widget.ModernWidget;

public class MenuItemColorHighlightFadeAnimation
    extends MenuItemHighlightFadeAnimation {
  public MenuItemColorHighlightFadeAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void fill(Graphics2D g2, int x, int y, int w, int h) {
    g2.fillRect(x, y, w, h);
  }
}
