package org.jebtk.modern.collapsepane;

import java.awt.Dimension;
import java.awt.Graphics2D;

import org.jebtk.modern.MaterialUtils;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class CollapsePaneCardAnimation extends WidgetAnimation {

	public CollapsePaneCardAnimation(ModernWidget widget) {
		super(widget);
	}

	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		Dimension s = widget.getPreferredSize();
		//Insets insets = widget.getInsets();

		MaterialUtils.drawCard(g2,
				0, 
				0, 
				widget.getWidth(), 
				s.height - MaterialUtils.SHADOW_HEIGHT);
	}

}
