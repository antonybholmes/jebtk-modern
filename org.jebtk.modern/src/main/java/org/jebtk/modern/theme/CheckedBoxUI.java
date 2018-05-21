package org.jebtk.modern.theme;

import java.awt.Graphics2D;

public class CheckedBoxUI extends DrawUI {

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "checkbox.checked";
  }

  @Override
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    DrawUIService.getInstance().getRenderer("color.button.selected")
        .draw(g2, x, y, w, h, params);

    super.draw(g2, x, y, w, h, params);
  }
}
