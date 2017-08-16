package org.jebtk.modern.dialog;

import org.jebtk.modern.MaterialUtils;
import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class DialogMaterialButtonHighlightAnimation extends ButtonHighlightAnimation {
	public DialogMaterialButtonHighlightAnimation(ModernWidget button) {
		super(button);
		
		setFadeColor("fill", MaterialUtils.BUTTON_COLOR);
	}
}
