package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CheckBoxSelectedTickAnimation extends WidgetAnimation {
  public CheckBoxSelectedTickAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left;
    int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

    if (widget.isEnabled()) {
      if (((ModernClickWidget) getWidget()).isSelected()) {
        // Only draw the tick if the button is selected
        //ModernCheckBox.CHECK_ICON.drawIcon(g2, x, y, ModernCheckBox.ICON_SIZE);
        
        UIDrawService.getInstance().get("checked.check").draw(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);
      }
    } else {
      if (((ModernClickWidget) getWidget()).isSelected()) {
        ModernCheckBox.DISABLED_CHECKED_ICON
            .drawIcon(g2, x, y, ModernCheckBox.ICON_SIZE);
      }
    }
  }
}
