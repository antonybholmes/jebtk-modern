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
package org.jebtk.modern.dialog;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.jebtk.modern.button.ModernOptionalDropDownMenuButton2;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.menu.ModernPopupMenu2;

// TODO: Auto-generated Javadoc
/**
 * Replacement ModernButton with a common skin.
 *
 * @author Antony Holmes
 *
 */
public class ModernDialogOptionalDropDownMenuButton2
    extends ModernOptionalDropDownMenuButton2 {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern dialog optional drop down menu button.
   *
   * @param text1 the text1
   * @param icon the icon
   * @param menu the menu
   */
  public ModernDialogOptionalDropDownMenuButton2(String text1, ModernIcon icon,
      ModernPopupMenu2 menu) {
    super(text1, icon, menu);
  }

  /**
   * Instantiates a new modern dialog optional drop down menu button.
   *
   * @param icon the icon
   * @param menu the menu
   */
  public ModernDialogOptionalDropDownMenuButton2(ModernIcon icon,
      ModernPopupMenu2 menu) {
    super(icon, menu);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.button.ModernOptionalDropDownMenuButton#
   * drawBackground( java.awt.Graphics2D)
   */
  @Override
  public void drawBackground(Graphics2D g2) {
    Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());

    Rectangle subRect = new Rectangle();

    subRect.y = mRect.getY();
    subRect.height = mRect.getH();
    subRect.x = mDividerLocation;
    subRect.width = mRect.getW() - mDividerLocation;

    if (isSelected() || mPopupShown) {
      // UiGraphics.paintBorder(g2, rect);
      paintHighlightedOutlined(g2, rect);
    } else if (mHighlight) {
      paintHighlightedOutlined(g2, rect);
      paintHighlightedOutlined(g2, subRect);
    } else {
      paintDialogButton(g2, rect);
    }
  }
}
