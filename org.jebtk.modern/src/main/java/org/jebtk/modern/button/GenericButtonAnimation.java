package org.jebtk.modern.button;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

public class GenericButtonAnimation extends HoverFadeAnimation {
	//private ModernClickWidget mButton;

	public GenericButtonAnimation(ModernWidget button) {
		super(button);
		
		//mButton = (ModernClickWidget)button;

		setFadeColor("outline", ModernWidgetRenderer.SELECTED_OUTLINE_COLOR);
		setFadeColor("fill", ModernWidgetRenderer.SELECTED_FILL_COLOR);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.Graphics2D)
	 */
	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		
	}
	
	public void drawButton(Graphics2D g2, 
			int x,
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		drawButtonFill(g2, 
				x,
				y,
				w,
				h,
				mode,
				hasFocus);
		
		drawButtonOutline(g2, 
				x,
				y,
				w,
				h,
				mode,
				hasFocus);
	}
	
	public void drawButtonOutline(Graphics2D g2, 
			int x,
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		//g2.setColor(getFadeColor("outline"));
		//outline(g2, x, y, w, h);
	}
	
	public void outline(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h) {
		getWidget().getWidgetRenderer().outline(g2, x, y, w, h);
	}
	
	public void drawButtonFill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		
		ModernWidget wt = getWidget();
		
		if (wt instanceof ModernClickWidget) {
			if (((ModernClickWidget)wt).isSelected()) {
				g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR);
			} else {
				g2.setColor(getFadeColor("fill"));
			}
		} else {
			g2.setColor(getFadeColor("fill"));
		}
		
		fill(g2, x, y, w, h);
	}
	
	public void fill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h) {
		getWidget().getWidgetRenderer().fill(g2, x, y, w, h);
	}
}