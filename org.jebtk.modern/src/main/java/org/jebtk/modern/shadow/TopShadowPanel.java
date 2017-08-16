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
package org.jebtk.modern.shadow;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;

import org.jebtk.modern.MaterialUtils;
import org.jebtk.modern.graphics.ImageUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TopShadowPanel.
 */
public class TopShadowPanel extends ShadowPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The Class TopShadow.
	 */
	private static class TopShadow extends RibbonShadow {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/* (non-Javadoc)
		 * @see org.abh.common.ui.ModernComponent#drawBackground(java.awt.Graphics2D)
		 */
		@Override
		public void drawBackground(Graphics2D g2) {
			Graphics2D g2Temp = ImageUtils.createAAGraphics(g2);
			
			try {
				MaterialUtils.drawDropShadow(g2Temp, 0, 0, getWidth(), 0);
			} finally {
				g2Temp.dispose();
			}
		}
	}
	
	/**
	 * Instantiates a new top shadow panel.
	 *
	 * @param c the c
	 */
	public TopShadowPanel(Component c) {
		super(c, new TopShadow());
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.shadow.ShadowPanel#componentResized(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		mShadow.setBounds(0, 0, getWidth(), MaterialUtils.SHADOW_HEIGHT);
		
		super.componentResized(e);
	}
}
