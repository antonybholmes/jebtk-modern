package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.SelectedAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonSelectedAnimation extends SelectedAnimation {
  private Color mColor;

  public ButtonSelectedAnimation(ModernWidget button) {
    super((ModernClickWidget) button);

    mColor = button.getToKeyFrame().getColor("background-color");
  }

  @Override
  public String getName() {
    return "button-selected";
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isSelected()) {
      IntRect rect = widget.getRect(); //getInternalRect();

      fill(g2,
          rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH());
    }
  }

  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    DrawUIService.getInstance().getRenderer("button-fill").draw(g2, x, y, w, h, mColor);


    //g2.setColor(getFadeColor("fill"));

    //fill(g2, x, y, w, h);
  }
}
