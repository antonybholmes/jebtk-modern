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
package org.jebtk.modern.widget.tooltip;

import java.awt.Point;

import org.jebtk.modern.ModernComponent;


// TODO: Auto-generated Javadoc
/**
 * Provides a model for notifying the ribbon that it should
 * display a tooltip.
 * 
 * @author Antony Holmes Holmes
 *
 */
public interface ModernToolTipModel {
	
	/**
	 * Show tool tip.
	 *
	 * @param source the source
	 * @param toolTipPanel the tool tip panel
	 */
	public void showToolTip(ModernComponent source, 
			ModernToolTipPanel toolTipPanel);
	
	/**
	 * Show tool tip.
	 *
	 * @param source the source
	 * @param tooltipPanel the tooltip panel
	 * @param location the location
	 */
	void showToolTip(ModernComponent source, 
			ModernToolTipPanel tooltipPanel, 
			Point location);

	/**
	 * Hide tool tips.
	 *
	 * @param source the source
	 */
	void hideToolTips(ModernComponent source);
}
