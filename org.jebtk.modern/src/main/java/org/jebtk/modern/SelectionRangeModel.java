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
package org.jebtk.modern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jebtk.core.event.ChangeEvent;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.core.text.TextUtils;
import org.jebtk.modern.event.ModernSelectionListeners;


// TODO: Auto-generated Javadoc
/**
 * ModernSelection model to determine which rows are selected in a list, table, tree etc.
 *
 * @author Antony Holmes Holmes
 *
 */
public class SelectionRangeModel extends ModernSelectionListeners implements Iterable<Integer> {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The constant SELECTION_CHANGED.
	 */
	public static final String SELECTION_CHANGED = "selection_changed";
	//public static final String SELECTION_CLEARED = "selection_cleared";
	//public static final String SELECTION_ADDED = "selection_added";
	
	/**
	 * The member selection set.
	 */
	private Set<Integer> mSelectionSet = new HashSet<Integer>(100);
	
	/**
	 * The member selection.
	 */
	private List<Integer> mSelection = new ArrayList<Integer>(100);

	/**
	 * The member fire.
	 */
	private boolean mFire = true;

	/** The m enabled. */
	private boolean mEnabled = true;

	/** The m current. */
	private int mCurrent = -1;

	private int mPrevious = -1;

	/**
	 * Sets the selection interval.
	 *
	 * @param s the s
	 * @param e the e
	 */
	public void setSelectionInterval(int s, int e) {
		int min = Math.min(s, e);
		
		int max = Math.max(s, e);
		
		removeAll();
		
		addSelectionInterval(min, max);
	}
	
	/**
	 * Adds the selection interval.
	 *
	 * @param s the s
	 * @param e the e
	 */
	public void addSelectionInterval(int s, int e) {
		if (!mEnabled) {
			return;
		}
		
		for (int i = s; i <= e; ++i) {
			mSelectionSet.add(i);
		}
		
		mCurrent = e;

		update();
	}
	
	/**
	 * Remove a selected node.
	 *
	 * @param index the index
	 */
	public void remove(int index) {
		if (mCurrent == index) {
			mCurrent = -1;
		}
		
		mSelectionSet.remove(index);
		
		update();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		removeAll();

		update();
	}
	
	/**
	 * Removes the all.
	 */
	public void removeAll() {
		//mPrevious = -1;
		//mCurrent = -1;
		mSelectionSet.clear();
	}
	
	/**
	 * Update.
	 */
	public void update() {
		mSelection = CollectionUtils.sort(mSelectionSet);
		
		if (mFire) {
			//System.err.println("ModernSelection changed " + selection.toString());
			
			fireSelectionChanged();
		}
	}


	/**
	 * Fire selection changed.
	 */
	public void fireSelectionChanged() {
		fireSelectionChanged(new ChangeEvent(this));
	}

	/**
	 * Add a row to the selection.
	 *
	 * @param index the row
	 */
	public void add(int index) {
		update(index);

		update();
	}
	
	/**
	 * Add a new item to the selection model.
	 *
	 * @param index the index
	 */
	public void update(int index) {
		if (!mEnabled) {
			return;
		}
		
		mSelectionSet.add(index);
		
		mPrevious = mCurrent;
		mCurrent = index;
	}
	
	/**
	 * Returns true if an index exists in the selection.
	 *
	 * @param i the i
	 * @return Returns true if an i exists in the selection, false otherwise.
	 */
	public boolean contains(int i) {
		return mSelectionSet.contains(i);
	}
	
	/**
	 * Return the first selectable index.
	 *
	 * @return the int
	 */
	public int first() {
		if (mSelection.size() == 0) {
			return -1;
		}
		
		return mSelection.get(0);
	}
	
	/**
	 * Return the currently selected item (the last item that was added
	 * even if the sorted order of items means this index appears in the
	 * middle).
	 *
	 * @return the current
	 */
	public int getCurrent() {
		return mCurrent;
	}
	
	/**
	 * Return the last previously selected item or -1 otherwise.
	 *
	 * @return the current
	 */
	public int getPrevious() {
		return mPrevious;
	}
	

	/**
	 * Last.
	 *
	 * @return the int
	 */
	public int last() {
		if (mSelection.size() == 0) {
			return -1;
		}
		
		return mSelection.get(mSelection.size() - 1);
	}
	
	/**
	 * Gets the.
	 *
	 * @param index the index
	 * @return the int
	 */
	public int get(int index) {
		if (index < 0 || index >= mSelection.size()) {
			return -1;
		}
		
		return mSelection.get(index);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return mSelectionSet.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Integer> iterator() {
		return mSelection.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return TextUtils.join(mSelection, TextUtils.COMMA_DELIMITER);
	}

	/**
	 * Sets the selection.
	 *
	 * @param indices the new selection
	 */
	public void setSelection(List<Integer> indices) {
		removeAll();
		
		addSelection(indices);
	}
	
	/**
	 * Sets the selection.
	 *
	 * @param i the new selection
	 */
	public void setSelection(int i) {
		removeAll();
			
		add(i);
	}

	/**
	 * Add multiple indices to the selection.
	 *
	 * @param indices the indices
	 */
	public void addSelection(List<Integer> indices) {
		if (!mEnabled) {
			return;
		}
		
		for (int i : indices) {
			mSelectionSet.add(i);
		}

		update();
	}

	/**
	 * Sets whether the selection model reports changes
	 * or not.
	 *
	 * @param fire the new fire changes
	 */
	public void setFireChanges(boolean fire) {
		mFire = fire;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		mEnabled = enabled;
	}

	/**
	 * Returns a list of the indices.
	 *
	 * @return the selected indices
	 */
	public List<Integer> getSelectedIndices() {
		List<Integer> ret = new ArrayList<Integer>(mSelection);

		Collections.sort(ret);

		return ret;
	}
}
