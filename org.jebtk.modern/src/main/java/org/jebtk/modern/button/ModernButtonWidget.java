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
package org.jebtk.modern.button;

import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.text.TextProperty;
import org.jebtk.modern.widget.ModernClickWidget;


// TODO: Auto-generated Javadoc
/**
 * Provides the basic functionality of a button and
 * some rendering, but does not provide a concrete
 * implementation of the button.
 *
 * @author Antony Holmes Holmes
 *
 */
public abstract class ModernButtonWidget extends ModernClickWidget implements TextProperty {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	


	/**
	 * The member text1.
	 */
	//protected JLabel label1 = new JLabel();
	protected String mText1 = null;

	/**
	 * The member icon.
	 */
	protected ModernIcon mIcon = null;

	//protected Image buttonImage = null;
	//protected Image disabledButtonImage = null;
	//protected Image backgroundButtonImage = null;



	

	/**
	 * Instantiates a new modern button widget.
	 */
	public ModernButtonWidget() {
		// Do nothing
	}

	/**
	 * Instantiates a new modern button widget.
	 *
	 * @param text1 the text1
	 */
	public ModernButtonWidget(String text1) {
		setText(text1);

		//Ui.setSize(this, ModernTheme.getInstance().getClass("button").getDimension("default"));
	}

	/**
	 * Instantiates a new modern button widget.
	 *
	 * @param icon the icon
	 */
	public ModernButtonWidget(ModernIcon icon) {
		setIcon(icon);

		//Ui.setSize(this, ModernTheme.getInstance().getClass("button").getDimension("icon-only"));
	}
	
	/**
	 * Instantiates a new modern button widget.
	 *
	 * @param text1 the text1
	 * @param icon the icon
	 */
	public ModernButtonWidget(String text1, ModernIcon icon) {
		setText(text1);
		setIcon(icon);

		//Ui.setSize(this, ModernTheme.getInstance().getClass("button").getDimension("icon-text"));
	}
	
	/**
	 * Sets the icon.
	 *
	 * @param icon the new icon
	 */
	public void setIcon(ModernIcon icon) {
		mIcon = icon;
		
		autoSize();
	}
	
	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public ModernIcon getIcon() {
		return mIcon;
	}
	
	/**
	 * Gets the disabled icon.
	 *
	 * @return the disabled icon
	 */
	public ModernIcon getDisabledIcon() {
		return mIcon.getDisabledIcon();
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.text.TextProperty#getText()
	 */
	public String getText() {
		return mText1;
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.text.TextProperty#setText(java.lang.String)
	 */
	public void setText(String text) {
		mText1 = text;
		
		setClickMessage(text);
		
		autoSize();
	}
	
	/**
	 * Sets whether the button text is visible or not.
	 * 
	 * @param show
	 */
	public void setShowText(boolean show) {
		// Do nothing
	}

	/**
	 * Returns whether the button text should be visible or not.
	 *
	 * @return the show text
	 */
	public boolean getShowText() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.ModernClickWidget#setHighlighted(boolean)
	 */
	@Override
	public void setHighlighted(boolean highlight) {
		if (isEnabled()) {
			mHighlight = highlight;

			repaint();
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);

		setForeground(isEnabled() ? TEXT_COLOR : ALT_TEXT_COLOR);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.ModernWidget#drawBackground(java.awt.Graphics2D)
	 */
	
}
