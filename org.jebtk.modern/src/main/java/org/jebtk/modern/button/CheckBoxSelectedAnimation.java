package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CheckBoxSelectedAnimation extends WidgetAnimation {
  public CheckBoxSelectedAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);

    // setFadeColor("fill", ModernWidgetRenderer.SELECTED_FILL_COLOR);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left;
    int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

    if (widget.isEnabled() && ((ModernClickWidget) getWidget()).isSelected()) {
      // g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); //
      // getFadeColor("fill"));
      // getWidget().getWidgetRenderer()
      // .fill(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);

      DrawUIService.getInstance().getRenderer("color.button.selected")
          .draw(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);
    }
  }
}
