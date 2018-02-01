package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CheckBoxHighlightAnimation extends ButtonFillAnimation {
  public CheckBoxHighlightAnimation(ModernWidget button) {
    super((ModernClickWidget) button);

    setFadeColor("fill", Ribbon.BAR_BACKGROUND);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled()) {
      int x = widget.getInsets().left;
      int y = (widget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

      /*
       * drawButtonFill(g2, x, y, ModernCheckBox.ICON_SIZE,
       * ModernCheckBox.ICON_SIZE, getButton().getRenderMode(), false);
       */

      UIDrawService.getInstance().get("button.highlight").draw(g2,
          x,
          y,
          ModernCheckBox.ICON_SIZE,
          ModernCheckBox.ICON_SIZE,
          getFadeColor("fill"));
    }
  }
}
