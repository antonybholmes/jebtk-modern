package org.jebtk.modern.dialog;

import java.awt.Color;

import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;

public class PrimaryDialogButtonAnimation extends ButtonHighlightAnimation {
	public static final Color OUTLINE_COLOR_1 =
			ThemeService.getInstance().colors().getColorHighlight32(24);
	
	public static final Color OUTLINE_COLOR_2 =
			ThemeService.getInstance().colors().getColorHighlight32(28);
	
	public static final Color FILL_1 = 
			ThemeService.getInstance().colors().getColorHighlight32(20);
	
	public static final Color FILL_2 = 
			ThemeService.getInstance().colors().getColorHighlight32(24);
	
	public PrimaryDialogButtonAnimation(ModernWidget button) {
		super(button);
		
		setFadeColor("outline", OUTLINE_COLOR_1, OUTLINE_COLOR_2);
		setFadeColor("fill", ModernWidgetRenderer.SELECTED_FILL_COLOR, Ribbon.BAR_BACKGROUND);
	}
}
