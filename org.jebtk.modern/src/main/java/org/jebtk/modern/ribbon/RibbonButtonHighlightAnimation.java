/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jebtk.modern.ribbon;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * The Class RibbonButtonAnimation.
 */
public class RibbonButtonHighlightAnimation extends HoverFadeAnimation {
	
	/** The m button. */
	private ModernClickWidget mButton;

	/**
	 * Instantiates a new ribbon button animation.
	 *
	 * @param button the button
	 */
	public RibbonButtonHighlightAnimation(ModernWidget button) {
		super(button);
		
		mButton = (ModernClickWidget)button;
		
		setFadeColor("outline", 
				ModernWidgetRenderer.RIBBON_SELECTED_OUTLINE_COLOR);
		
		setFadeColor("highlight", 
				ModernWidgetRenderer.RIBBON_HIGHLIGHT_FILL_COLOR);
		
		setFadeColor("fill", 
				ModernWidgetRenderer.RIBBON_SELECTED_FILL_COLOR);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.Graphics2D)
	 */
	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		if (getWidget().isEnabled()) { // && (getButton().getHightlighted() || getButton().getPopupShown())) {
			IntRect rect = getWidget().getInternalRect();
			
			drawRibbonButtonFill(g2, 
					rect.getX(),
					rect.getY(),
					rect.getW(),
					rect.getH(),
					mButton.getRenderMode(),
					false);
			
			/*
			drawRibbonButtonOutline(g2, 
					rect.getX(),
					rect.getY(),
					rect.getW(),
					rect.getH(),
					mButton.getRenderMode(),
					false);
			*/
		}
		
		//Color c = ColorUtils.getTransparentColor(Color.RED, mTrans);
		
		//int y = getHeight() / 2;
		//
		//g2.setColor(c);
		//g2.drawLine(0, 0, getWidth(), y);
	}
	
	/**
	 * Draw ribbon button outline.
	public void drawRibbonButtonOutline(Graphics2D g2, 
			int x,
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		//if (mode == RenderMode.NONE && !hasFocus) {
		//	return;
		//}

		getWidget().getWidgetRenderer().outline(g2, getFadeColor("outline"), x, y, w, h);
	}
	*/
	
	/**
	 * Draw ribbon button fill.
	 *
	 * @param g2 the g 2
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 * @param mode the mode
	 * @param hasFocus the has focus
	 */
	public void drawRibbonButtonFill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		//if (mode == RenderMode.NONE) {
		//	return;
		//}

		//GradientPaint paint = new GradientPaint(0, 
		//		y, 
		//		getFadeColor("highlight"), 
		//		0, 
		//		y + h, 
		//		getFadeColor("fill"));
		
		//g2.setPaint(paint);	

		if (mode == RenderMode.SELECTED) {
			g2.setColor(ModernWidgetRenderer.RIBBON_SELECTED_FILL_COLOR);
			
			//getWidgetRenderer().drawRibbonButton(g2, mRect, RenderMode.SELECTED);
			
		} else {
			//System.err.println("fade " + getFadeColor("fill"));
			
			g2.setColor(getFadeColor("highlight"));
		}
		
		//g2.fillRect(x, y, w, h);
		getWidget().getWidgetRenderer().fill(g2, x, y, w, h);
	}
	
	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	public ModernClickWidget getButton() {
		return mButton;
	}
}