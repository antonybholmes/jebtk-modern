package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CheckBoxSelectedAnimation extends ButtonFillAnimation {
  public CheckBoxSelectedAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);

    //setFadeColor("fill", widget.getFromKeyFrame().getColor("background-color"));
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled() && ((ModernClickWidget) getWidget()).isSelected()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;


      // g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); //
      // getFadeColor("fill"));
      // getWidget().getWidgetRenderer()
      // .fill(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);

      DrawUIService.getInstance().getRenderer("button-fill")
      .draw(g2, widget, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE, 
          widget.getKeyFrame().getColor("background-color"));

      //fill(g2, 
      //    x,
      //     y,
      //    ModernCheckBox.ICON_SIZE,
      //    ModernCheckBox.ICON_SIZE);
    }
  }
}
