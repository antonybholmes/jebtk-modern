package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class CheckSwitchAnimation extends WidgetAnimation {

  private static final int HEIGHT = ModernCheckSwitch.SLIDER_HEIGHT; // ModernCheckSwitch.SLIDER_HEIGHT;
  private ModernCheckSwitch mButton;
  private Color mColor;

  public CheckSwitchAnimation(ModernWidget widget) {
    this(widget, ModernWidget.LINE_COLOR);
  }

  public CheckSwitchAnimation(ModernWidget widget, Color color) {
    super(widget);

    mButton = (ModernCheckSwitch) widget;

    mColor = color;
  }

  public void setSelectedColor(Graphics2D g2) {
    g2.setColor(mColor);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int y2 = (widget.getHeight() - HEIGHT) / 2;

    if (mButton.isSelected()) {
      setSelectedColor(g2);
    } else {
      g2.setColor(ModernWidget.LINE_COLOR);
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
