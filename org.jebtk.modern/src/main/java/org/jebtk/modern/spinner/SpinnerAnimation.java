package org.jebtk.modern.spinner;

import java.awt.Graphics2D;

import org.jebtk.modern.UIService;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.graphics.icons.TriangleDownVectorIcon;
import org.jebtk.modern.graphics.icons.TriangleUpVectorIcon;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.widget.ModernWidget;

public class SpinnerAnimation extends WidgetAnimation {
  private ModernCompactSpinner mSpinner;

  private static final ModernIcon TRIANGLE_UP = UIService.getInstance().loadIcon(TriangleUpVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_UP_HIGH = UIService.getInstance().loadIcon(TriangleUpVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  private static final ModernIcon TRIANGLE_DOWN = UIService.getInstance().loadIcon(TriangleDownVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_DOWN_HIGH = UIService.getInstance().loadIcon(TriangleDownVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  public SpinnerAnimation(ModernWidget widget) {
    super(widget);

    mSpinner = (ModernCompactSpinner) widget;
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = mSpinner.getWidth() - 16;
    int y = (mSpinner.mButtonYDivider - 16) / 2;

    if (mSpinner.mButtonZone && mSpinner.mUpperButton) {
      TRIANGLE_UP_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_UP.drawIcon(g2, x, y, 16);
    }

    y += mSpinner.mButtonYDivider;

    if (mSpinner.mButtonZone && !mSpinner.mUpperButton) {
      TRIANGLE_DOWN_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_DOWN.drawIcon(g2, x, y, 16);
    }
  }
}
