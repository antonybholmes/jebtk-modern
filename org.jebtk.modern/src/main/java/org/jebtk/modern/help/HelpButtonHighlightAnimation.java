package org.jebtk.modern.help;

import java.awt.Graphics2D;

import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.graphics.icons.ModernMessageIcon;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.ribbon.RibbonHighlightTextAnimation;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernWidget;

public class HelpButtonHighlightAnimation extends ButtonFillAnimation {

  public HelpButtonHighlightAnimation(ModernWidget widget) {
    super(widget);

    setFadeColor("highlight", RibbonHighlightTextAnimation.HIGHLIGHT_COLOR);
  }

  @Override
  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {

    int size = 20; // h - 2;

    int xf = ModernWidget.PADDING;
    int yf = y + (h - size) / 2;

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    try {
      /*
       * GradientPaint paint = new GradientPaint(0, yf, mColor1, 0, yf + size,
       * mColor2);
       * 
       * //g2Temp.setPaint(paint);
       */

      g2Temp.setColor(getFadeColor("highlight"));
      g2Temp.fillOval(xf, yf, size, size);
      g2Temp.setColor(Ribbon.BAR_BACKGROUND);
      g2Temp.drawOval(xf, yf, size, size);

      ModernMessageIcon.drawScaledText(g2Temp,
          size,
          xf,
          yf,
          size,
          size,
          "?",
          Ribbon.BAR_BACKGROUND);
    } finally {
      g2Temp.dispose();
    }
  }
}
