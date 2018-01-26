package org.jebtk.modern.dialog;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.UIDrawService;
import org.jebtk.modern.widget.ModernWidget;

public class DialogButtonHighlightAnimation extends HoverFadeAnimation {
  public static final Color OUTLINE_COLOR_1 = 
      MaterialService.getInstance().color("dialog.button.outline");

  public static final Color OUTLINE_COLOR_2 = 
      MaterialService.getInstance().color("dialog.button.highlight");


  public DialogButtonHighlightAnimation(ModernWidget button) {
    super(button);

    setFadeColor("outline", OUTLINE_COLOR_1, OUTLINE_COLOR_2);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    UIDrawService.getInstance().get("button.outline").draw(g2, widget.getInternalRect(), getFadeColor("outline"));
  }
}
