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

import java.util.ArrayList;
import java.util.List;

import org.jebtk.core.collections.CollectionUtils;

// TODO: Auto-generated Javadoc
/**
 * The class PropertyValueTableModel.
 */
public class PropertyValueTableModel extends ModernColumnHeaderTableModel {

  /**
   * The constant HEADER.
   */
  private static final String[] HEADER = { "Property", "Value" };

  /**
   * The values.
   */
  private List<PropertyValuePair> values = new ArrayList<PropertyValuePair>();

  /**
   * The editable.
   */
  private List<PropertyValueEditType> editable = new ArrayList<PropertyValueEditType>();

  // private Experiment experiment;

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.dataview.ModernDataModel#getColumnCount()
   */
  public final int getColumnCount() {
    return HEADER.length;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.dataview.ModernDataModel#getRowCount()
   */
  public final int getRowCount() {
    // System.out.println("row count" + dataSection.getRows().size());

    return values.size();
  }

  /**
   * Gets the column annotation.
   *
   * @param col the col
   * @return the column annotation
   */
  public final List<String> getColumnAnnotation(int col) {
    // System.out.println("cname:" + columnNames.get(col));

    return CollectionUtils.asList(HEADER[col]);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.dataview.ModernDataModel#getValueAt(int, int)
   */
  public final Object getValueAt(int row, int col) {
    return col == 0 ? values.get(row).property : values.get(row).value;
  }

  /**
   * Adds the.
   *
   * @param property the property
   * @param value the value
   * @param editable the editable
   */
  public final void add(String property,
      String value,
      PropertyValueEditType editable) {

    PropertyValuePair pair = new PropertyValuePair(property, value);

    add(pair, editable);
  }

  /**
   * Adds the.
   *
   * @param pair the pair
   * @param editable the editable
   */
  public final void add(PropertyValuePair pair,
      PropertyValueEditType editable) {

    values.add(pair);

    this.editable.add(editable);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.dataview.ModernDataGridModel#getIsCellEditable(int,
   * int)
   */
  @Override
  public final boolean getIsCellEditable(int row, int col) {
    // Note that the data/cell address is constant,
    // no matter where the cell appears onscreen.

    return col == 1 && (editable.get(row) == PropertyValueEditType.EDITABLE
        || editable.get(row) == PropertyValueEditType.SELECTABLE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.dataview.ModernDataModel#setValueAt(int, int,
   * java.lang.Object)
   */
  @Override
  public final void setValueAt(int row, int col, Object value) {
    if (editable.get(row) == PropertyValueEditType.EDITABLE) {
      values.get(row).value = value.toString();
    }
  }
}
