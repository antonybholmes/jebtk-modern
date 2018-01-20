package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

public class TextBorderUI extends RoundedUI {
  public static final Color SELECTED_FILL_COLOR = ThemeService.getInstance()
      .colors().getColorHighlight32(10);
  
  @Override
  public String getName() {
    return "text.border.highlight";
  }
  
  @Override
  public void draw(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    //super.draw(g2, x, y, w, h, params);
    UIDrawService.getInstance().get("content-box").draw(g2, x,  y, w, h, params);
    
    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      g2.setColor(SELECTED_FILL_COLOR);
    }
    
    outline(g2, x, y, w, h, params);
  }
}
