package org.jebtk.modern.combobox;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

public class ComboBoxHighlightAnimation2 extends ButtonHighlightAnimation
    implements ChangeListener {
  private ModernComboBox2 mCombo;

  public ComboBoxHighlightAnimation2(ModernWidget combo) {
    super(combo);

    mCombo = (ModernComboBox2) combo;

    //mCombo.addPopupClosedListener(this);

    setFadeColor("fill",
        Color.WHITE,
        MaterialService.instance().color("dialog.button.outline"));
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

      drawButtonFill(g2,
          buttonRect.getX(),
          buttonRect.getY(),
          buttonRect.getW(),
          buttonRect.getH(),
          RenderMode.SELECTED,
          widget.hasFocus());
    }

    // Color c = ColorUtils.getTransparentColor(Color.RED, mTrans);

    // int y = getHeight() / 2;
    //
    // g2.setColor(c);
    // g2.drawLine(0, 0, getWidth(), y);
  }

  @Override
  public void drawButtonFill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    UIDrawService.getInstance().get("button.highlight")
        .draw(g2, x, y, w, h, getFadeColor("fill"));
  }

  @Override
  public void changed(ChangeEvent e) {
    pseudoMouseExited();
  }
}
