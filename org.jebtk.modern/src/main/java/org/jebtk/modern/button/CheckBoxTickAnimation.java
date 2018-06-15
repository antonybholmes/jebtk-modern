package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CheckBoxTickAnimation extends WidgetAnimation {
  private static final int TICK_SIZE = 16;
  
  private static final int OFFSET = (ModernCheckBox.ICON_SIZE - TICK_SIZE) / 2;
  
  public CheckBoxTickAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left + OFFSET;
    int y = (widget.getHeight() - TICK_SIZE) / 2;

    if (widget.isEnabled()) {
      if (((ModernClickWidget) getWidget()).isSelected()) {
        // Only draw the tick if the button is selected
        // ModernCheckBox.CHECK_ICON.drawIcon(g2, x, y,
        // ModernCheckBox.ICON_SIZE);

        DrawUIService.getInstance().getRenderer("check")
            .draw(g2, x, y, TICK_SIZE, TICK_SIZE, Color.WHITE);
      }
    }
  }
}
