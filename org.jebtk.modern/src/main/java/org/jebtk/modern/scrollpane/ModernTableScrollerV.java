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

import java.awt.Component;

import org.jebtk.modern.dataview.ModernDataSelection;
import org.jebtk.modern.table.ModernTable;

/**
 * The Class ModernTableScrollerV offers row based scrolling in a table.
 */
public class ModernTableScrollerV extends ModernTableScroller {

  /**
   * Instantiates a new modern table scroller V.
   *
   * @param table the table
   */
  public ModernTableScrollerV(ModernTable table) {
    super(table);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.scrollpane.ComponentScroller#wheelScroll(int,
   * org.abh.common.ui.graphics.ModernCanvas,
   * org.abh.common.ui.scrollpane.ModernScrollBar)
   */
  @Override
  public void wheelScroll(int notches, Component c, ModernScrollBar scrollBar) {

    ModernDataSelection range = mTable.calculateVisibleCells();

    // int row = range.getStartRow() + notches;

    // Move the table by the width of the first row on display
    int width = mTable.getRowModel().getWidth(range.getStartRow());

    double p = scrollBar.normalize(width, notches); // * notches;

    // System.err.println("Row " + range.getStartRow() + " " + notches + " " +
    // width
    // + " " + p);

    scrollBar.incrementNormalizedScrollPosition(p); // .setNormalizedScrollPosition(p);
  }
}
