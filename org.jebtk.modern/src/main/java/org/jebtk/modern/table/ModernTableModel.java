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
package org.jebtk.modern.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.core.text.TextUtils;
import org.jebtk.modern.dataview.ModernDataGridModel;

// TODO: Auto-generated Javadoc
/**
 * Extended table model.
 *
 * @author Antony Holmes Holmes
 */
public abstract class ModernTableModel extends ModernDataGridModel {

  /** The m header map. */
  private Map<Integer, List<String>> mHeaderMap = new HashMap<Integer, List<String>>();

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.dataview.ModernDataModel#getRowAnnotationText(int)
   */
  @Override
  public List<String> getRowAnnotationText(int row) {
    return CollectionUtils.toList(Integer.toString(row + 1));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.dataview.ModernDataModel#getColumnAnnotationText(int)
   */
  @Override
  public List<String> getColumnAnnotationText(int column) {
    // Use the auto names A,B,C... etc
    return getAutoColumnName(column);
  }

  /**
   * Convert a header array into a column annotation list.
   * 
   * @param header
   * @param column
   * @return
   */
  public List<String> getColumnAnnotationText(String[] header, int column) {
    if (column < header.length) {
      return CollectionUtils.toList(header[column]);
    } else {
      return Collections.emptyList();
    }
  }

  /**
   * Gets the auto header name.
   *
   * @param column
   *          the column
   * @return the auto header name
   */
  public List<String> getAutoColumnName(int column) {

    if (!mHeaderMap.containsKey(column)) {
      mHeaderMap.put(column, CollectionUtils.toList(getAutoColumnHeading(column)));
    }

    return mHeaderMap.get(column);
  }

  /**
   * Generates a column heading where the first 26 columns are A-Z followed by
   * AA-AZ etc.
   *
   * @param column
   *          the column
   * @return the auto column heading
   */
  public static String getAutoColumnHeading(int column) {

    StringBuilder buffer = new StringBuilder();

    while (column >= 0) {
      buffer.append(TextUtils.CAPITAL_ALPHABET_CHARS[column % 26]);

      column = (column / 26) - 1;
    }

    return buffer.reverse().toString();
  }
}
