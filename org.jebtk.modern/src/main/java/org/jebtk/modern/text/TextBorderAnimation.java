package org.jebtk.modern.text;

import java.awt.Graphics2D;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.widget.ModernWidget;

public class TextBorderAnimation extends HoverFadeAnimation {
	public TextBorderAnimation(ModernWidget widget) {
		super(widget);
		
		setFadeColor("outline", 
				ModernWidget.LINE_COLOR, 
				ModernWidgetRenderer.SELECTED_FILL_COLOR);
		
		widget.addContainerListener(new ContainerListener() {

			@Override
			public void componentAdded(ContainerEvent arg0) {
				bind();
			}

			@Override
			public void componentRemoved(ContainerEvent arg0) {
				//bind();
			}});
		
		bind();
	}
	
	private void bind() {
		for (int i = 0; i < getWidget().getComponentCount(); ++i) {
			bind(getWidget().getComponent(i));
		}
	}

	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		if (widget.isEnabled()) {
			int x = 0; //widget.getInsets().left;
			int y = 0; //widget.getInsets().top;
			
			IntRect r = widget.getRect();
			
			int w = r.getW(); 
			int h = r.getH();
			
			//widget.getWidgetRenderer().drawContentBoxFill(g2, x, y, w, h);
			
			widget.getWidgetRenderer().outline(g2, 
					getFadeColor("outline"), 
					x, 
					y, 
					w, 
					h);
		}
	}
}
