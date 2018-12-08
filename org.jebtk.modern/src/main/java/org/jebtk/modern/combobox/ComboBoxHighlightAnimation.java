package org.jebtk.modern.combobox;

import java.awt.Graphics2D;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class ComboBoxHighlightAnimation extends ButtonFillAnimation
    implements ChangeListener {
  private ModernComboBox mCombo;

  public ComboBoxHighlightAnimation(ModernWidget combo) {
    super(combo);

    mCombo = (ModernComboBox) combo;

    mCombo.addPopupClosedListener(this);

    // setFadeColor("fill",
    // MaterialService.getInstance().getColor("dialog.button.outline"));
  }

  @Override
  public void animateMouseExited() {
    // If the popup is show, force the animation to display the button
    // by making it opaque and stopping the timer
    if (getButton().getPopupShown()) {
      opaque();
      stopMouseOverTimer();
    } else {
      super.animateMouseExited();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (getWidget().isEnabled()) {
      IntRect rect = widget.getInternalRect();

      // widget.getWidgetRenderer().drawOutline(g2, rect);

      // if (getButton().getHightlighted() || getButton().getPopupShown()) {
      IntRect buttonRect = new IntRect(mCombo.mButtonX, widget.getInsets().top,
          ModernComboBox.BUTTON_WIDTH, rect.getH());

      fill(g2,
          widget,
          buttonRect.getX(),
          buttonRect.getY(),
          buttonRect.getW(),
          buttonRect.getH());
    }

    // Color c = ColorUtils.getTransparentColor(Color.RED, mTrans);

    // int y = getHeight() / 2;
    //
    // g2.setColor(c);
    // g2.drawLine(0, 0, getWidth(), y);
  }

  @Override
  public void changed(ChangeEvent e) {
    pseudoMouseExited();
  }
}
