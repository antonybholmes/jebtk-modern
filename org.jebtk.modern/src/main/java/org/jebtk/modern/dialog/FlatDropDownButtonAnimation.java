package org.jebtk.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.modern.button.DropDownButtonAnimation;
import org.jebtk.modern.button.ModernDropDownWidget;
import org.jebtk.modern.widget.ModernWidget;

public class FlatDropDownButtonAnimation extends DropDownButtonAnimation {
  public FlatDropDownButtonAnimation(ModernDropDownWidget button) {
    super(button);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    widget.getWidgetRenderer().drawContentBox(g2, widget.getInternalRect());

    super.draw(widget, g2, params);
  }
}
