/**
 * Copyright (c) 2016, Antony Holmes
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
package org.jebtk.modern.scrollpane;

import org.jebtk.core.geom.IntRect;

/**
 * Determines what happens when the component requests a scrollto action.
 *
 * @see ModernTableSelectionScrollEvent
 */
public class ModernTableScrollTo {

  private ModernScrollPane mScrollPane;

  /**
   * Instantiates a new modern table selection scroll listener.
   *
   * @param table the table
   * @param vScrollbar the v scrollbar
   * @param hScrollbar the h scrollbar
   */
  public ModernTableScrollTo(ModernScrollPane scrollPane) {
    mScrollPane = scrollPane;
  }

  public void scrollTo(IntRect rect) {
    ModernScrollBar vscroll = mScrollPane.getVScrollBar();
    ModernScrollBar hscroll = mScrollPane.getHScrollBar();

    vscroll.setScrollPosition(normY(vscroll, rect.mY + 2 * rect.mH));
    hscroll.setScrollPosition(normX(hscroll, rect.mX + 2 * rect.mW));
  }
  
  private int normX(ModernScrollBar scrollbar, int d) {
    return Math.max(0, d - mScrollPane.mViewport.getWidth()); //.getScrollDistance());
  }
  
  private int normY(ModernScrollBar scrollbar, int d) {
    System.err.println(" normY " + mScrollPane.mViewport.getHeight());
    return Math.max(0, d - mScrollPane.mViewport.getHeight()); //.getScrollDistance());
  }
}
