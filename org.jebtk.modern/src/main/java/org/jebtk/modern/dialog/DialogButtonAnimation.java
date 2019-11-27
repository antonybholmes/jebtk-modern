package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

public class DialogButtonAnimation extends WidgetAnimation {
  public DialogButtonAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    DrawUIService.getInstance().getRenderer("dialog.button").draw(g2,
        widget.getInternalRect());
  }
}
