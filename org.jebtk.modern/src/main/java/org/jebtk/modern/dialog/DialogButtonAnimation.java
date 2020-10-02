package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;

public class DialogButtonAnimation extends WidgetAnimation {
  public DialogButtonAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    DrawUIService.getInstance().getRenderer("dialog.button").draw(g2, mWidget.getInternalRect());
  }
}
