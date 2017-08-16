/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jebtk.modern.graphics.icons;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.Mathematics;
import org.jebtk.modern.button.ChipButtonHighlightAnimation;
import org.jebtk.modern.theme.ThemeService;


// TODO: Auto-generated Javadoc
/**
 * The class RoundelVectorIcon.
 */
public class ChipCloseIcon extends ModernVectorIcon {
	
	/**
	 * The constant WIDTH_SCALE.
	 */
	private static final double WIDTH_SCALE = 0.5;
	
	private static final Color LINE_COLOR = 
			ChipButtonHighlightAnimation.HIGHLIGHT;
	
	private static final Color FILL_COLOR = 
			ThemeService.getInstance().colors().getHighlight32(16);
	
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D, java.awt.Rectangle)
	 */
	@Override
	public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Object... params) {
			
		int wf = (int)Mathematics.makeMult2(w * WIDTH_SCALE);
	
		int xf = x + (w - wf) / 2;
		int yf = y + (h - wf) / 2;
		
		g2.setColor(FILL_COLOR);
		g2.fillOval(x, y, w, w);
		
		g2.setColor(LINE_COLOR);	
		g2.drawLine(xf, yf, xf + wf- 1, yf + wf - 1);
		g2.drawLine(xf, yf + wf - 1, xf + wf - 1, yf);
		
	}
}
