package org.jebtk.modern.dialog;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.button.ButtonFillAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.widget.ModernWidget;

public class ColorDialogButtonHighlightAnimation extends ButtonFillAnimation {
  public static final Color OUTLINE_COLOR_1 = MaterialService.instance()
      .getColor("color.dialog.button.outline");

  public static final Color OUTLINE_COLOR_2 = MaterialService.instance()
      .getColor("color.dialog.button.highlight");

  public ColorDialogButtonHighlightAnimation(ModernWidget button) {
    super(button);

    // setFadeColor("outline", OUTLINE_COLOR_1, OUTLINE_COLOR_2);
    setFadeColor("outline", OUTLINE_COLOR_2);
  }

  @Override
  public void fill(ModernWidget c,
      Graphics2D g2,
      int x,
      int y,
      int w,
      int h) {

    /*
     * ModernWidget wt = getWidget();
     * 
     * if (wt instanceof ModernClickWidget) { if (((ModernClickWidget)
     * wt).isSelected()) {
     * g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); } else {
     * g2.setColor(getFadeColor("fill")); } } else {
     * g2.setColor(getFadeColor("fill")); }
     * 
     * if (mode != RenderMode.NONE) { fill(g2, x, y, w, h); }
     */

    // if (mode == RenderMode.HIGHLIGHT) {
    DrawUIService.getInstance().getRenderer("button-outline")
        .draw(g2, x, y, w, h, getFadeColor("outline"));
    // }
  }
}
