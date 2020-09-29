package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.theme.DrawUIService;

public class CheckBoxSelectedAnimation extends ButtonFillAnimation {
  public CheckBoxSelectedAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);

    // setFadeColor("fill",
    // widget.getFromKeyFrame().getColor("background-color"));
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (widget.isEnabled() && ((ModernClickWidget) getWidget()).isSelected()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

      // g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); //
      // getFadeColor("fill"));
      // getWidget().getWidgetRenderer()
      // .fill(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);

      DrawUIService.getInstance().getRenderer("button-fill").draw(widget, g2,
          new IntRect(x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE),
          widget.getToKeyFrame().getColor("background-color"));

      // fill(g2,
      // x,
      // y,
      // ModernCheckBox.ICON_SIZE,
      // ModernCheckBox.ICON_SIZE);
    }
  }
}
