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

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.jebtk.core.geom.IntDim;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.graphics.ImageUtils;

// TODO: Auto-generated Javadoc
/**
 * Rastorizes an icon (for example a vector based on) to reduce
 * drawing overhead.
 * 
 * @author Antony Holmes Holmes
 */
public class RasterIcon extends ModernIcon {

	/**
	 * The buffered image.
	 */
	private BufferedImage mBufferedImage;

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 */
	public RasterIcon(ModernIcon icon) {
		this(icon, new IntDim(icon.getWidth(), icon.getHeight()));
	}

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 * @param size the size
	 */
	public RasterIcon(ModernIcon icon, int size) {
		this(icon, new IntDim(size, size));
	}

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 * @param size the size
	 */
	public RasterIcon(ModernIcon icon, IntDim size) {
		this(icon, new IntRect(0, 0, size.getW(), size.getH()));
	}

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 * @param rect the rect
	 */
	public RasterIcon(ModernIcon icon, IntRect rect) {
		this(icon, rect, new IntDim(rect.getW(), rect.getH()));
	}

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 * @param iconSize the icon size
	 * @param imageSize the image size
	 */
	public RasterIcon(ModernIcon icon, int iconSize, int imageSize) {
		this(icon, 
				new IntRect((imageSize - iconSize) / 2, (imageSize - iconSize) / 2, iconSize, iconSize), 
				new IntDim(imageSize, imageSize));
	}

	/**
	 * Instantiates a new raster icon.
	 *
	 * @param icon the icon
	 * @param iconRect the icon rect
	 * @param imageSize the image size
	 */
	public RasterIcon(ModernIcon icon, IntRect iconRect, int imageSize) {
		this(icon, iconRect, new IntDim(imageSize, imageSize));
	}

	/**
	 * Creates a rastorized version of the icon of a given size in
	 * an image of a given size. This allows the icon to be scaled inside
	 * the image if necessary.
	 *
	 * @param icon the icon
	 * @param iconRect 	the dimensions of the icon
	 * @param imageSize 	the size of this image (which will become an icon).
	 */
	public RasterIcon(ModernIcon icon, 
			IntRect iconRect, 
			IntDim imageSize) {
		cache(icon, iconRect, imageSize);
	}

	/**
	 * Cache the image.
	 *
	 * @param icon the icon
	 * @param iconRect the icon rect
	 * @param imageSize the image size
	 */
	private void cache(ModernIcon icon, 
			IntRect iconRect, 
			IntDim imageSize) {
		mBufferedImage = ImageUtils.createImage(imageSize);
		
		Graphics2D g2Temp = ImageUtils.createAAGraphics(mBufferedImage);

		try {
			icon.drawIcon(g2Temp, iconRect);
		} finally {
			g2Temp.dispose();
		}
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D, java.awt.Rectangle)
	 */
	@Override
	public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Object... params) {
		g2.drawImage(mBufferedImage, x, y, null);
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.icons.ModernIcon#getImage()
	 */
	@Override
	public BufferedImage getImage() {
		return mBufferedImage;
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.graphics.icons.ModernIcon#getWidth()
	 */
	@Override
	public int getWidth() {
		return mBufferedImage.getWidth();
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.graphics.icons.ModernIcon#getHeight()
	 */
	@Override
	public int getHeight() {
		return mBufferedImage.getHeight();
	}
}
