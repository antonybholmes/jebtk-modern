package org.jebtk.modern.panel;

import java.awt.Component;
import java.awt.Graphics2D;

import javax.swing.border.Border;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.theme.DrawUIService;

public class CardPanel2 extends ModernComponent {

  private static final long serialVersionUID = 1L;

  public CardPanel2(Component c) {
    this(c, DOUBLE_BORDER);
  }

  public CardPanel2(Component c, Border border) {
    super(new ModernComponent(c, border));
    
    addStyleClass("card");
  }

  @Override
  public void drawBackground(Graphics2D g2) {
    Graphics2D g2Temp = ImageUtils.createAAGraphics(g2);
    
    try {
      DrawUIService.getInstance().getRenderer("card").draw(g2Temp, this, getRect());
    } finally {
      g2Temp.dispose();
    }
  }
}
