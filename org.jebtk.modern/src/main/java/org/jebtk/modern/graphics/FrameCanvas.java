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
package org.jebtk.modern.graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.widget.ModernWidget;


// TODO: Auto-generated Javadoc
/**
 * Drawing panel that allows frames a drawing.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class FrameCanvas extends ContainerCanvas {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The m color. */
	private Color mColor;

	/**
	 * Instantiates a new frame canvas.
	 *
	 * @param canvas the canvas
	 */
	public FrameCanvas(ModernCanvas canvas) {
		this(canvas, Color.WHITE, ModernWidget.DARK_LINE_COLOR);
	}
	
	
	/**
	 * Instantiates a new frame canvas.
	 *
	 * @param canvas the canvas
	 * @param background the background
	 * @param color the color
	 */
	public FrameCanvas(ModernCanvas canvas, Color background, Color color) {
		super(canvas);
		
		mColor = color;
		
		setBackground(background);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.ModernWidget#drawBackground(java.awt.Graphics2D)
	 */
	@Override
	public void drawBackground(Graphics2D g2) {
		g2.setColor(getBackground());
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.graphics.ContainerCanvas#drawCanvasForeground(java.awt.Graphics2D)
	 */
	@Override
	public void drawForegroundAAText(Graphics2D g2) {
		g2.setColor(mColor);
		
		g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		
		super.drawForegroundAAText(g2);
	}
}