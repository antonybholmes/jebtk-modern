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

import org.jebtk.modern.MaterialService;
import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * The Class RibbonMenuAnimation.
 */
public class RibbonMenuHighlightAnimation extends HoverFadeAnimation {
	
	/** The m button. */
	private RibbonMenuItem mButton;

	/**
	 * Instantiates a new ribbon menu animation.
	 *
	 * @param button the button
	 */
	public RibbonMenuHighlightAnimation(ModernWidget button) {
		super((RibbonMenuItem)button);
		
		mButton = (RibbonMenuItem)button;
		
		//setFadeColor("selected", MaterialService.getInstance().color("ribbon-theme-selected"));
		setFadeColor("highlight", 
				MaterialService.getInstance().color("gray-highlighted"));
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.Graphics2D)
	 */
	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		if (mButton.isSelected()) {
			ModernWidget.fill(g2, 
					MaterialService.getInstance().color("gray-selected"),
					getWidget().getRect());
		} else {
			ModernWidget.fill(g2, 
					getFadeColor("highlight"), 
					getWidget().getRect());
		}
	}
}