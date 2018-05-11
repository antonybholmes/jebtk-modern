package org.jebtk.modern.menu;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.widget.ModernWidget;

public class MenuItemColorHighlightFadeAnimation
    extends MenuItemHighlightFadeAnimation {
  public MenuItemColorHighlightFadeAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    IntRect rect = getWidget().getInternalRect();
    
    g2.fillRect(rect.getX(),
        rect.getY(),
        rect.getW(),
        rect.getH());
  }
}
