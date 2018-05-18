package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonFillAnimation extends HoverFadeAnimation {
  private ModernClickWidget mButton;

  public ButtonFillAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;

    if (button.getToKeyFrame().contains("background-color")) {
      if (button.getKeyFrame(0).contains("background-color")) {
        setFadeColor("fill", 
            button.getKeyFrame(0).getColor("background-color"),
            button.getToKeyFrame().getColor("background-color"));
      } else {
        setFadeColor("fill", 
            button.getToKeyFrame().getColor("background-color"));
      }
    } else {
      setFadeColor("fill", MaterialService.instance().color("theme-highlight"));
    }
  }
  
  @Override
  public String getName() {
    return "button-fill";
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    if (widget.isEnabled()) {
      IntRect rect = widget.getInternalRect();

      fill(g2,
          rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH(),
          mButton.getRenderMode(),
          false);
    }
  }

  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    UIDrawService.getInstance().get("button-fill").draw(g2, x, y, w, h, getFadeColor("fill"));

    
    //g2.setColor(getFadeColor("fill"));

    //fill(g2, x, y, w, h);
  }

  //public void fill(Graphics2D g2, int x, int y, int w, int h) {
  //  getWidget().getWidgetRenderer().fill(g2, x, y, w, h);
  //}

  public ModernClickWidget getButton() {
    return mButton;
  }
}
