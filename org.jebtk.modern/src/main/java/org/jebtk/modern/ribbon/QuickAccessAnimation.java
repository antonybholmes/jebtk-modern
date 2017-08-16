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

import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.theme.RenderMode;
import org.jebtk.modern.widget.ModernClickWidget;

/**
 * Provides the fade animation for quick access buttons
 */
public class QuickAccessAnimation extends ButtonHighlightAnimation {
	
	/**
	 * Instantiates a new quick access animation.
	 *
	 * @param button the button
	 */
	public QuickAccessAnimation(ModernClickWidget button) {
		super(button);
		
		setFadeColor("fill", RibbonHighlightTextAnimation.HIGHLIGHT_COLOR); //MaterialUtils.HIGHLIGHT_COLOR);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.widget.ButtonAnimation#drawButtonOutline(java.awt.Graphics2D, int, int, int, int, org.abh.common.ui.theme.RenderMode, boolean)
	 */
	@Override
	public void drawButtonOutline(Graphics2D g2, 
			int x,
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		// Do nothing
	}
	
	@Override
	public void fill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h) {
		g2.fillRect(x, y, w, h);
	}
}
