package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;

public class CheckedBoxUI extends CheckUI {

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "checkbox.checked";
  }

  @Override
  public void draw(Graphics2D g2,
      IntRect rect,
      Object... params) {

    DrawUIService.getInstance().getRenderer("button-fill")
        .draw(g2, rect, params);

    super.draw(g2, rect, Color.WHITE); // params);
  }
}
