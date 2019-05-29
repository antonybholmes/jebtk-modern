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

import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.menu.ModernPopupMenu2;

// TODO: Auto-generated Javadoc
/**
 * @deprecated use {@link #ModernOutlinedDialogButton2()} instead.  
 *
 * @author Antony Holmes
 *
 */
@Deprecated
public class ModernDialogFlatDropDownButton2 extends ModernOutlinedDialogButton2 {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param text1 the text1
   */
  public ModernDialogFlatDropDownButton2(String text1) {
    super(text1);
  }

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param icon the icon
   */
  public ModernDialogFlatDropDownButton2(ModernIcon icon) {
    super(icon);
  }

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param text1 the text1
   * @param icon the icon
   */
  public ModernDialogFlatDropDownButton2(String text1, ModernIcon icon) {
    super(text1, icon);
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param icon the icon
   * @param menu the menu
   */
  public ModernDialogFlatDropDownButton2(ModernIcon icon,
      ModernPopupMenu2 menu) {
    super(icon, menu);
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param text1 the text 1
   * @param icon the icon
   * @param menu the menu
   */
  public ModernDialogFlatDropDownButton2(String text1, ModernIcon icon,
      ModernPopupMenu2 menu) {
    super(text1, icon, menu);
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param text1 the text 1
   * @param menu the menu
   */
  public ModernDialogFlatDropDownButton2(String text1, ModernPopupMenu2 menu) {
    super(text1, menu);
  }
}
