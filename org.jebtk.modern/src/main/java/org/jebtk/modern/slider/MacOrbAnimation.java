package org.jebtk.modern.slider;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;

public class MacOrbAnimation extends HoverFadeAnimation {
  private MacOrbSlider mButton;

  protected static final Color HIGHLIGHT_2 = ThemeService.getInstance()
      .getColors().getTheme32(24);

  public MacOrbAnimation(MacOrbSlider button) {
    super(button);

    mButton = button;

    setFadeColor("highlight", MacOrbSlider.HIGHLIGHT, HIGHLIGHT_2);
    setFadeColor("line", ModernWidget.LINE_COLOR, ModernWidget.DARK_LINE_COLOR);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int p = (int) (widget.getInsets().left + mButton.mSliderDiameter % 2
        + mButton.mPc * mButton.mGap);

    drawBar(g2, p);
    drawOrb(g2, p);
  }

  private void drawBar(Graphics2D g2, int p) {
    mButton.drawBarBase(g2, p);

    int x = mButton.getInsets().left + mButton.mSliderRadius;
    int y = (mButton.getHeight() - mButton.mBarHeight) / 2;

    g2.setColor(getFadeColor("highlight"));

    g2.fillRoundRect(x,
        y,
        p - x + mButton.mSliderRadius,
        mButton.mBarHeight,
        mButton.mBarHeight,
        mButton.mBarHeight);
  }

  private void drawOrb(Graphics2D g2, int p) {
    int y = mButton.getHeight() / 2;

    g2.setColor(Color.WHITE);
    g2.fillOval(p,
        y - mButton.mSliderRadius,
        mButton.mSliderDiameter,
        mButton.mSliderDiameter);

    g2.setColor(getFadeColor("line"));
    g2.drawOval(p,
        y - mButton.mSliderRadius,
        mButton.mSliderDiameter,
        mButton.mSliderDiameter);
  }
}
