package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ButtonOutlineAnimation extends HoverFadeAnimation {
  private ModernClickWidget mButton;

  public ButtonOutlineAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;

    if (button.getToKeyFrame().contains("border-color")) {
      if (button.getKeyFrame(0).contains("border-color")) {
        setFadeColor("outline", 
            button.getKeyFrame(0).getColor("border-color"),
            button.getToKeyFrame().getColor("border-color"));
      } else {
        setFadeColor("outline", 
            button.getToKeyFrame().getColor("background-color"));
      }
    } else {
      setFadeColor("outline", ModernWidgetRenderer.SELECTED_OUTLINE_COLOR);
    }
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

      outline(g2,
          rect.getX(),
          rect.getY(),
          rect.getW(),
          rect.getH(),
          mButton.getRenderMode(),
          false);
    }
  }

  public void outline(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      RenderMode mode,
      boolean hasFocus) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }
    
    UIDrawService.getInstance().get("button-outline").draw(g2, x, y, w, h, getFadeColor("outline"));

    //g2.setColor(getFadeColor("outline"));

    //outline(g2, x, y, w, h);
  }

  //public void outline(Graphics2D g2, int x, int y, int w, int h) {
  //  getWidget().getWidgetRenderer().outline(g2, x, y, w, h);
  //  
  //  UIDrawService.getInstance().get("button-outline").draw(g2, x, y, w, h, getFadeColor("outline"));
  //}

  public ModernClickWidget getButton() {
    return mButton;
  }
}
