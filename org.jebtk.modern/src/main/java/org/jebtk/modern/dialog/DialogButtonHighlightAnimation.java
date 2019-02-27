package org.jebtk.modern.dialog;

import java.awt.Color;

import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.widget.ModernWidget;

public class DialogButtonHighlightAnimation extends ButtonFillAnimation {
  public static final Color OUTLINE_COLOR_1 = MaterialService.instance()
      .getColor("dialog.button.outline");

  public static final Color OUTLINE_COLOR_2 = MaterialService.instance()
      .getColor("dialog.button.highlight");

  public DialogButtonHighlightAnimation(ModernWidget button) {
    super(button);

    setFadeColor("fill", OUTLINE_COLOR_1, OUTLINE_COLOR_2);
  }

  /*
   * @Override public void draw(Graphics2D g2, ModernWidget widget, Object...
   * params) { UIDrawService.getInstance().get("button-outline") .draw(g2,
   * widget.getInternalRect(), getFadeColor("outline")); }
   */
}
