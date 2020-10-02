package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernWidget;

public class CheckBoxHighlightAnimation extends ButtonOutlineAnimation {
  public CheckBoxHighlightAnimation(ModernWidget button) {
    super((ModernClickWidget) button);

    setFadeColor("fill", button.getToKeyFrame().getColor("background-color"));
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (mWidget.isEnabled()) {
      int x = mWidget.getInsets().left;
      int y = (mWidget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

      /*
       * drawButtonFill(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE,
       * getButton().getRenderMode(), false);
       */

      outline(mWidget, g2, new IntRect(x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE));

      // DrawUIService.getInstance().getRenderer("button-outline").draw(g2,
      // x,
      // y,
      // ModernCheckBox.ICON_SIZE,
      // ModernCheckBox.ICON_SIZE,
      // getFadeColor("fill"));
    }
  }
}
