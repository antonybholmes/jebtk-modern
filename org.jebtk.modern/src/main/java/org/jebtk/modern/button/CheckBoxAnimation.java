package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;

public class CheckBoxAnimation extends WidgetAnimation {
  public CheckBoxAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left;
    int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

    // if (((ModernClickWidget)widget).isSelected()) {
    // if (widget.isEnabled()) {
    // ModernCheckBox.CHECKED_ICON.drawIcon(g2, x, y, ModernCheckBox.ICON_SIZE);
    // } else {
    // ModernCheckBox.DISABLED_CHECKED_ICON.drawIcon(g2, x, y,
    // ModernCheckBox.ICON_SIZE);
    // }
    // } else {

    // If there is nothing to be done, draw the unselected version of the
    // checkbox
    // ModernCheckBox.UNCHECKED_ICON.drawIcon(g2, x, y,
    // ModernCheckBox.ICON_SIZE);

    DrawUIService.getInstance().getRenderer("content-box").draw(g2,
        widget,
        x,
        y,
        ModernCheckBox.ICON_SIZE,
        ModernCheckBox.ICON_SIZE);
    // }
  }
}
