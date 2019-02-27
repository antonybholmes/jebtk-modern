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
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

import org.jebtk.modern.graphics.ImageUtils;

import javafx.scene.image.Image;

/**
 * The class ModernImageIcon.
 */
public class ModernImageIcon extends ModernIcon {

  /**
   * The member buffered image.
   */
  private BufferedImage mBufferedImage;
  private URL mUrl;
  private int mSize;
  private Image mImage;

  public ModernImageIcon(URL url, int size) {
    mUrl = url;
    mSize = size;
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
    x = x + (w - mSize) / 2;
    y = y + (h - mSize) / 2;

    g2.drawImage(getImage(mSize, params), x, y, null);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getWidth()
   */
  @Override
  public int getWidth() {
    return mSize;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getHeight()
   */
  @Override
  public int getHeight() {
    return mSize;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getImage()
   */
  @Override
  public BufferedImage getImage(int w, Object... params) {
    if (mBufferedImage == null) {
      mBufferedImage = ImageUtils.createImage(mSize, mSize);

      Graphics2D g2 = (Graphics2D) mBufferedImage.createGraphics();

      Graphics2D g2Temp = ImageUtils.createAATextGraphics(g2);

      try {

        java.awt.Image image = new ImageIcon(mUrl).getImage();

        w = image.getWidth(null);
        
        if (w == mSize) {
          g2Temp.drawImage(image, 0, 0, null);
        } else {
          // scale
          ImageUtils.setQualityHints(g2Temp);
         

     
          /*
          g2Temp.drawImage(image,
              0,
              0,
              mSize,
              mSize,
              0,
              0,
              w,
              image.getHeight(null),
              null);
          */
          
          g2Temp.drawImage(image,
              0,
              0,
              mSize,
              mSize,
              null);
        }

      } finally {
        g2Temp.dispose();
      }
    }

    return mBufferedImage;
  }

  @Override
  public javafx.scene.image.Image getFxImage(int w) {
    if (mImage == null) {
      mImage = new javafx.scene.image.Image(mUrl.toString(), mSize, mSize, true,
          true);
    }

    return mImage;
  }
}
