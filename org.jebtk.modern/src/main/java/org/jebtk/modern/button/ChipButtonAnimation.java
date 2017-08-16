package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.UIService;
import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.graphics.icons.ChipCloseIcon;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.widget.ModernTwoStateWidget;
import org.jebtk.modern.widget.ModernWidget;

public class ChipButtonAnimation extends WidgetAnimation {

	private static final int SIZE = 12;

	private static final ModernIcon ICON =
			UIService.getInstance().loadIcon(ChipCloseIcon.class, SIZE);

	private ModernTwoStateWidget mButton;

	public ChipButtonAnimation(ModernWidget widget) {
		super(widget);

		mButton = (ModernTwoStateWidget)widget;
	}

	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		if (mButton.isSelected()) {
			int y = (widget.getHeight() - SIZE) / 2;
			int x = widget.getWidth() - widget.getInsets().right - SIZE - y;

			ICON.drawIcon(g2, x, y, SIZE);
		}
	}
}
