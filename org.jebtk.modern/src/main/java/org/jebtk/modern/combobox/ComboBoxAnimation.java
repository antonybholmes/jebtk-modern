package org.jebtk.modern.combobox;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

public class ComboBoxAnimation extends WidgetAnimation {

  public ComboBoxAnimation(ModernWidget combo) {
    super(combo);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    IntRect rect = widget.getInternalRect();

    UIDrawService.getInstance().get("content").draw(g2, rect);
  }
}
