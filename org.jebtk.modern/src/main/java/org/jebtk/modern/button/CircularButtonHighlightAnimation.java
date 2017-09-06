package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.MaterialUtils;
import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class CircularButtonHighlightAnimation extends ButtonHighlightAnimation {
	public CircularButtonHighlightAnimation(ModernWidget button) {
		super(button);

		setFadeColor("fill", MaterialUtils.BUTTON_COLOR);
	}

	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		if (getWidget().isEnabled()) { 
			if (widget instanceof ModernClickWidget) {
				if (((ModernClickWidget)widget).isSelected()) {
					g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR);
				} else {
					g2.setColor(getFadeColor("fill"));
				}
			} else {
				g2.setColor(getFadeColor("fill"));
			}

			IntRect rect = getWidget().getInternalRect();

			g2.fillOval(rect.getX(),
					rect.getY(),
					rect.getW(),
					rect.getH());
		}
	}
}
