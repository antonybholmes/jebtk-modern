package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class ColorDialogButtonAnimation extends WidgetAnimation {
  public ColorDialogButtonAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(Graphics2D g2, ModernWidget widget, Object... params) {
    DrawUIService.getInstance().getRenderer("color.dialog.button").draw(g2,
        widget.getInternalRect());
  }
}
