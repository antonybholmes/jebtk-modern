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
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.jebtk.modern.graphics.ImageUtils;

/**
 * The class ModernScaleIcon.
 */
public class ModernScaleIcon extends ModernIcon {

  /**
   * The member buffered image.
   */
  private BufferedImage mBufferedImage;

  /**
   * Instantiates a new modern scale icon.
   *
   * @param icon the icon
   * @param w the w
   */
  public ModernScaleIcon(ModernIcon icon, int w) {
    this(icon, w, w);
  }

  /**
   * Instantiates a new modern scale icon.
   *
   * @param icon the icon
   * @param w the w
   * @param h the h
   */
  public ModernScaleIcon(ModernIcon icon, int w, int h) {
    this(icon.getImage(), w, h);
  }

  /**
   * Instantiates a new modern scale icon.
   *
   * @param image the image
   * @param w the w
   * @param h the h
   */
  public ModernScaleIcon(Image image, int w, int h) {
    cache(image, w, h);
  }

  /**
   * Cache.
   *
   * @param image the image
   * @param w the w
   * @param h the h
   */
  private void cache(Image image, int w, int h) {
    mBufferedImage = scale(image, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getWidth()
   */
  @Override
  public int getWidth() {
    return mBufferedImage.getWidth();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getHeight()
   */
  @Override
  public int getHeight() {
    return mBufferedImage.getHeight();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawIcon(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    x = x + (w - getWidth()) / 2;
    y = y + (h - getHeight()) / 2;

    g2.drawImage(mBufferedImage, x, y, null);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getImage()
   */
  @Override
  public BufferedImage getImage() {
    return mBufferedImage;
  }

  /**
   * Scale.
   *
   * @param image the image
   * @param w the w
   * @param h the h
   * @return the buffered image
   */
  public static BufferedImage scale(Image image, int w, int h) {
    BufferedImage resizedImage = ImageUtils.createImage(w, h); // new
                                                               // BufferedImage(w,
                                                               // h,
                                                               // BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2 = resizedImage.createGraphics();

    Graphics2D g2Temp = ImageUtils.createAATextGraphics(g2);

    try {
      g2Temp.drawImage(image, 0, 0, w, h, null);
    } finally {
      g2Temp.dispose();
      g2.dispose();
    }

    return resizedImage;
  }
}
