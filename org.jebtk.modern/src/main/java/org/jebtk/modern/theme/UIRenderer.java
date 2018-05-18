package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.NameProperty;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernComponent;

public abstract class UIRenderer implements NameProperty {
  public static final Color LINE_COLOR = ThemeService.getInstance().colors()
      .getLineColor();


  public final void draw(Graphics2D g2, IntRect rect, Object... params) {
    draw(g2, null, rect, params);
  }

  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    draw(g2, null, x, y, w, h, params);
  }

  public final void draw(Graphics2D g2, ModernComponent c, IntRect rect, Object... params) {
    draw(g2, c, rect.getX(), rect.getY(), rect.getW(), rect.getH(), params);
  }

  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    fill(g2, c, x, y, w, h, params);
    outline(g2, c, x, y, w, h, params);
  }

  public void fill(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    int rounding = style(c).getInt("border-radius");

    if (rounding > 0) {
      g2.fillRoundRect(x, y, w, h, rounding, rounding);
    } else {
      g2.fillRect(x, y, w, h);
    }
  }

  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    int rounding = style(c).getInt("border-radius");

    if (rounding > 0) {
      g2.drawRoundRect(x, y, w - 1, h - 1, rounding, rounding);
    } else {
      g2.drawRect(x, y, w - 1, h - 1);
    }
  }

  public static StyleProperties style(ModernComponent c) {
    if (c != null) {
      return c.getStyleClasses();
    } else {
      // Return the reference style class if all else fails
      return KeyFramesService.instance().getStyleClass("widget");
    }
  }
}
