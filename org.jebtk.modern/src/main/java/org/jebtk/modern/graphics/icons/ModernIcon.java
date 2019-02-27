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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import org.jebtk.core.geom.IntDim;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.graphics.ImageUtils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

// TODO: Auto-generated Javadoc
/**
 * Abstraction for icon rendering so icons can either be bitmaps or vectors.
 *
 * @author Antony Holmes
 *
 */
public abstract class ModernIcon {

  /**
   * The member disabled icon.
   */
  private ModernIcon mDisabledIcon;

  /**
   * Draw icon.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawIcon(Graphics2D g2, IntRect rect) {
    drawIcon(g2, rect.getX(), rect.getY(), rect.getW(), rect.getH());
  }

  /**
   * Draw icon.
   *
   * @param g2 the g 2
   * @param rect the rect
   */
  public void drawIcon(Graphics2D g2, Rectangle rect) {
    drawIcon(g2, rect.x, rect.y, rect.width, rect.height);
  }

  /**
   * Draw the icon in a space wxw at (0, 0).
   *
   * @param g2 the g 2
   * @param w the w
   */
  public void drawIcon(Graphics2D g2, int w) {
    drawIcon(g2, 0, 0, w, w);
  }

  /**
   * Draw icon.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param w the w
   */
  public void drawIcon(Graphics2D g2, int x, int y, int w) {
    drawIcon(g2, x, y, w, w);
  }

  /**
   * Draw icon.
   *
   * @param g2 the g 2
   * @param dim the dim
   */
  public void drawIcon(Graphics2D g2, IntDim dim) {
    drawIcon(g2, 0, 0, dim);
  }

  /**
   * Draw the icon at position x, y in a space dim.
   *
   * @param g2 the g 2
   * @param x the x
   * @param y the y
   * @param dim the dim
   */
  public void drawIcon(Graphics2D g2, int x, int y, IntDim dim) {
    drawIcon(g2, x, y, dim.getW(), dim.getH());
  }

  /**
   * Draw the icon on the graphics context at the position and size specified by
   * the rectangle.
   *
   * @param g2 the g2
   * @param x the x
   * @param y the y
   * @param w the w
   * @param h the h
   */
  public void drawIcon(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    g2.drawImage(getImage(w, params), x, y, null);
  }

  /**
   * Returns the width of the icon.
   *
   * @return The width.
   */
  public int getWidth() {
    return -1;
  }

  /**
   * Returns the height of the icon.
   *
   * @return The height.
   */
  public int getHeight() {
    return -1;
  }

  
  //public BufferedImage getImage() {
  //  return getImage(getWidth());
  //}
  
  /**
   * Should return a buffered image of the icon. Note that vector icons will
   * return null, unless they have been rastorized.
   *
   * @return the image
   */
  public BufferedImage getImage(int w, Object... params) {
    return getImage(this, w, params);
  }
  
  /**
   * Draws icon onto a buffered image.
   * 
   * @param icon
   * @param w
   * @param params
   * @return
   */
  public static BufferedImage getImage(ModernIcon icon, 
      int w, 
      Object... params) {
    BufferedImage img = ImageUtils.createImage(w, w);

    Graphics2D g2Temp = ImageUtils.createAATextGraphics(img);
    
    g2Temp.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    try {
      icon.drawIcon(g2Temp, 0, 0, w, w, params);
    } finally {
      g2Temp.dispose();
    }
    
    return img;
  }
  
  public Image getFxImage(int w) {
    return getFxImage(this, w);
  }
  
  public Image getFxImage(ModernIcon icon, int w) {
    return SwingFXUtils.toFXImage(icon.getImage(w), null);
  }

  /**
   * Returns a disabled form of the icon. This is stored along with the regular
   * icon so that the disabled icon is cached for use on other widgets.
   *
   * @return the disabled icon
   */
  public ModernIcon getDisabledIcon() {
    if (mDisabledIcon == null) {
      mDisabledIcon = GrayScaleIcon.convert(this);
    }

    return mDisabledIcon;
  }

}
