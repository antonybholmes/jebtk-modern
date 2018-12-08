package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.FadeAnimation;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class CheckSwitchAnimation extends WidgetAnimation {

  private static final int HEIGHT = ModernCheckSwitch.SLIDER_HEIGHT; // ModernCheckSwitch.SLIDER_HEIGHT;
  private ModernCheckSwitch mButton;
  private FadeAnimation mFade;

  public CheckSwitchAnimation(ModernWidget widget) {
    this(widget, widget.getFromKeyFrame().getColor("background-color"),
        widget.getToKeyFrame().getColor("background-color"));
  }

  public CheckSwitchAnimation(ModernWidget widget, Color color1, Color color2) {
    super(widget);

    mButton = (ModernCheckSwitch) widget;

    mFade = new FadeAnimation(widget).setFadeColor("fill", color1, color2);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int y2 = (widget.getHeight() - HEIGHT) / 2;

    if (mButton.isSelected()) {
      g2.setColor(mFade.getToColor("fill"));
    } else {
      g2.setColor(mFade.getFromColor("fill")); // Color.WHITE);
    }

    g2.fillRoundRect(
        widget.getInsets().left + ModernCheckSwitch.SWITCH_ICON_OFFSET,
        y2,
        ModernCheckSwitch.SLIDER_WIDTH
            - 2 * ModernCheckSwitch.SWITCH_ICON_OFFSET,
        HEIGHT,
        HEIGHT,
        HEIGHT);

    /*
     * 
     * g2.setColor(ModernWidget.LINE_COLOR);
     * g2.drawRoundRect(ModernCheckSwitch.SLIDER_OFFSET, y2,
     * ModernCheckSwitch.SLIDER_WIDTH - 1, HEIGHT - 1, HEIGHT, HEIGHT);
     */
  }
}
