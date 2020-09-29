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
package org.jebtk.modern.ribbon;

import java.awt.Graphics2D;

import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.UI;
import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.theme.MaterialUtils;

// TODO: Auto-generated Javadoc
/**
 * The class RibbonBackMenuItem.
 */
public class RibbonBackButton extends ModernButton {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new ribbon back menu item.
   */
  public RibbonBackButton() {
    super(UI.MENU_BACK);

    setup();
  }

  /**
   * Setup.
   */
  private void setup() {
    UI.setSize(this, RibbonBackAnimation.HEIGHT * 3, RibbonBackAnimation.HEIGHT);

    setAnimations("ribbon-back-button");
  }

  /*
   * @Override public void drawBackground(Graphics2D g2) {
   * 
   * }
   */

  @Override
  public void drawForegroundAA(Graphics2D g2) {

    int x = RibbonBackAnimation.HEIGHT + ModernWidget.QUAD_PADDING;

    g2.setFont(MaterialUtils.FONT);

    int y = getTextYPosCenter(g2, getHeight());

    g2.setColor(TEXT_COLOR); // Color.WHITE);

    g2.drawString("Back", x, y);

    /*
     * Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);
     * 
     * try { g2Temp.setStroke(new BasicStroke(2));
     * 
     * if (mHighlight) { g2Temp.setColor(Color.WHITE); } else {
     * g2Temp.setPaint(BASE_COLOR); }
     * 
     * int x = (mRect.getW() - HEIGHT) / 2; int y = (mRect.getH() - HEIGHT) / 2;
     * 
     * drawIcon(g2Temp, x, y); } finally { g2Temp.dispose(); }
     */
  }
}