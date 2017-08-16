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
package org.jebtk.modern.input;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.Box;

import org.jebtk.core.text.Join;
import org.jebtk.modern.UIService;
import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.event.ModernClickEvent;
import org.jebtk.modern.event.ModernClickListener;
import org.jebtk.modern.graphics.icons.PlusVectorIcon;
import org.jebtk.modern.panel.HBox;
import org.jebtk.modern.panel.ModernLineBorderPanel;
import org.jebtk.modern.text.ModernClipboardTextField;
import org.jebtk.modern.text.ModernTextField;
import org.jebtk.modern.text.TextProperty;
import org.jebtk.modern.window.ModernWindow;

// TODO: Auto-generated Javadoc
/**
 * The class ModernSearchPanel.
 */
public class ModernInputExtPanel extends ModernLineBorderPanel implements TextProperty {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The m ext button. */
	private ModernButton mExtButton =
			new ModernButton(UIService.getInstance().loadIcon(PlusVectorIcon.class, 16)); //UIResources.getInstance().loadIcon("binoculars", 16));

	/**
	 * The member search field.
	 */
	private ModernTextField mTextField = new ModernClipboardTextField();

	/** The m delimiter. */
	private String mDelimiter;


	/** The m window. */
	private ModernWindow mWindow;
	
	/**
	 * Instantiates a new modern search panel.
	 *
	 * @param window the window
	 * @param text the text
	 * @param delimiter the delimiter
	 */
	public ModernInputExtPanel(ModernWindow window, 
			String text,
			String delimiter) {
		mWindow = window;
		mDelimiter = delimiter;
		
		mTextField.setBorder(LEFT_BORDER);
		add(mTextField);
		
		Box box = HBox.create();
		
		box.add(mExtButton);
		
		add(box, BorderLayout.LINE_END);

		mExtButton.addClickListener(new ModernClickListener() {

			@Override
			public void clicked(ModernClickEvent e) {
				inputExt();
			}});
		
		mTextField.setText(text);
	}
	
	/**
	 * Input ext.
	 */
	private void inputExt() {
		InputExtDialog dialog = new InputExtDialog(mWindow, mTextField.getText(), mDelimiter);
		
		dialog.setVisible(true);
		
		if (dialog.isCancelled()) {
			return;
		}
		
		inputExt(dialog.getLines());
	}
	
	/**
	 * Input ext.
	 *
	 * @param items the items
	 */
	public void inputExt(Collection<String> items) {
		mTextField.setText(Join.on(mDelimiter).values(items).toString());
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.text.TextProperty#getText()
	 */
	public String getText() {
		return mTextField.getText();
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.text.TextProperty#setText(java.lang.String)
	 */
	@Override
	public void setText(String text) {
		mTextField.setText(text);
	}
}
