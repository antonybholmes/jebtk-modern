package org.jebtk.modern.combobox;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class ComboBoxArrowAnimation extends WidgetAnimation {
  private ModernComboBox mCombo;

  public ComboBoxArrowAnimation(ModernWidget combo) {
    super(combo);

    mCombo = (ModernComboBox) combo;
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

    IntRect buttonRect = new IntRect(mCombo.mButtonX, widget.getInsets().top,
        ModernComboBox.BUTTON_WIDTH, rect.getH());

    ModernComboBox.DOWN_ARROW_ICON.drawIcon(g2,
        buttonRect.getX(),
        buttonRect.getY() + (buttonRect.getH() - 16) / 2,
        16);
  }
}
