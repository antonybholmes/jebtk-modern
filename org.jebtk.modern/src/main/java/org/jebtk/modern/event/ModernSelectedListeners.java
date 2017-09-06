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
package org.jebtk.modern.event;

import org.jebtk.core.event.EventProducer;

// TODO: Auto-generated Javadoc
/**
 * The basis for model controls in a model view controller setup.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class ModernSelectedListeners extends EventProducer<ModernSelectedListener> implements ModernSelectedEventProducer {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.event.ModernSelectedEventProducer#addSelectedListener(org.abh.lib.ui.modern.event.ModernSelectedListener)
	 */
	public void addSelectedListener(ModernSelectedListener l) {
		mListeners.add(l);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.event.ModernSelectedEventProducer#removeSelectedListener(org.abh.lib.ui.modern.event.ModernSelectedListener)
	 */
	public void removeSelectedListener(ModernSelectedListener l) {
		mListeners.remove(l);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.event.ModernSelectedEventProducer#fireSelectedChanged(org.abh.lib.ui.modern.event.ModernSelectedEvent)
	 */
	public void fireSelected(ModernSelectedEvent e) {
		for (ModernSelectedListener l : mListeners) {
			l.selected(e);
		}
	}
}