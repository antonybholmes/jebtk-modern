/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jebtk.modern.dataview;

import java.util.List;

import org.jebtk.core.collections.CollectionUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ModernDataRowFilterModel.
 */
public class ModernDataRowFilterModel extends ModernDataModel {
	
	/** The m model. */
	private ModernDataModel mModel;
	
	/** The m rows. */
	private List<Integer> mRows;


	/**
	 * Instantiates a new modern data row filter model.
	 *
	 * @param model the model
	 * @param rows the rows
	 */
	public ModernDataRowFilterModel(ModernDataModel model, List<Integer> rows) {
		mModel = model;
		mRows = rows;
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return mRows.size();
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return mModel.getColumnCount();
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int column) {
		return mModel.getValueAt(mRows.get(row), column);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getIsCellEditable(int, int)
	 */
	@Override
	public boolean getIsCellEditable(int row, int column) {
		return mModel.getIsCellEditable(mRows.get(row), column);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getRowAnnotationText(int)
	 */
	@Override
	public List<String> getRowAnnotationText(int row) {
		return mModel.getRowAnnotationText(mRows.get(row));
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getRowAnnotationValues(int)
	 */
	@Override
	public List<Double> getRowAnnotationValues(int row) {
		return mModel.getRowAnnotationValues(mRows.get(row));
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.math.matrix.MatrixAnnotations#getRowAnnotationNames()
	 */
	@Override
	public List<String> getRowAnnotationNames() {
		return CollectionUtils.subList(mModel.getRowAnnotationNames(), mRows);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getColumnAnnotationText(int)
	 */
	@Override
	public List<String> getColumnAnnotationText(int column) {
		return mModel.getColumnAnnotationText(column);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getColumnAnnotationValues(int)
	 */
	@Override
	public List<Double> getColumnAnnotationValues(int column) {
		return mModel.getColumnAnnotationValues(column);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.dataview.ModernDataModel#getColumnAnnotationNames()
	 */
	@Override
	public List<String> getColumnAnnotationNames() {
		return mModel.getColumnAnnotationNames();
	}
}
