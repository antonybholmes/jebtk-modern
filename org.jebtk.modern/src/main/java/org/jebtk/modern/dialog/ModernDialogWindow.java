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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.jebtk.modern.BorderService;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.UI;
import org.jebtk.modern.button.ButtonsBox;
import org.jebtk.modern.help.GuiAppInfo;
import org.jebtk.modern.panel.BorderlessCardPanel;
import org.jebtk.modern.panel.CardPanel2;
import org.jebtk.modern.panel.ModernLineBottomBorderPanel;
import org.jebtk.modern.panel.ModernPanel;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;
import org.jebtk.modern.widget.tooltip.ModernToolTipModel;
import org.jebtk.modern.widget.tooltip.ModernToolTipPanel;
import org.jebtk.modern.window.ModernWindow;


// TODO: Auto-generated Javadoc
/**
 * Standardized modern dialog window.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class ModernDialogWindow extends JDialog implements ModernToolTipModel {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The constant STANDARD_LABEL_SIZE.
	 */
	public static final Dimension STANDARD_LABEL_SIZE = 
			new Dimension(200, ModernWidget.getWidgetHeight());
	
	/**
	 * The constant STANDARD_INPUT_SIZE.
	 */
	public static final Dimension STANDARD_INPUT_SIZE = 
			new Dimension(80, ModernWidget.getWidgetHeight());

	
	/** The Constant DIALOG_BACKGROUND_1. */
	public static final Color DIALOG_BACKGROUND =
			ThemeService.getInstance().colors().getHighlight32(1);
	
	public static final Border FLAT_BORDER =
			BorderService.getInstance().createBottomBorder(ModernWidget.DOUBLE_PADDING);
	
	/**
	 * The member status.
	 */
	protected ModernDialogStatus mStatus = ModernDialogStatus.CANCEL;

	/**
	 * The member content panel.
	 */
	private ModernComponent mContentPanel = 
			new ModernPanel(ModernDialogWindow.DIALOG_BACKGROUND); //new ModernDialogWindowContentPanel();
	
	/**
	 * The member product details.
	 */
	protected GuiAppInfo mAppInfo;

	/**
	 * The member parent.
	 */
	protected ModernWindow mParent;

	/** The m center. */
	private Component mCenter;

	/** The m auto dispose. */
	private boolean mAutoDispose = true;
	

	
	/**
	 * Instantiates a new modern dialog window.
	 *
	 * @param parent the parent
	 */
	public ModernDialogWindow(ModernWindow parent) {
		this(parent, true);
	}
	
	/**
	 * Instantiates a new modern dialog window.
	 *
	 * @param parent the parent
	 * @param modal the modal
	 */
	public ModernDialogWindow(ModernWindow parent, boolean modal) {
		super(parent, modal);
		
		mParent = parent;
		
		mAppInfo = parent.getAppInfo();
		
		setup();
	}
	
	/**
	 * Instantiates a new modern dialog window.
	 *
	 * @param productDetails the product details
	 */
	public ModernDialogWindow(GuiAppInfo productDetails) {
		mAppInfo = productDetails;
		
		setup();
	}
	
	/**
	 * Instantiates a new modern dialog window.
	 *
	 * @param parent the parent
	 * @param productDetails the product details
	 */
	public ModernDialogWindow(ModernWindow parent, GuiAppInfo productDetails) {
		this(parent);
		
		mAppInfo = productDetails;
		
		setup();
	}
	
	/**
	 * Gets the app info.
	 *
	 * @return the app info
	 */
	public GuiAppInfo getAppInfo() {
		return mAppInfo;
	}
	
	/**
	 * Gets the parent window.
	 *
	 * @return the parent window
	 */
	public ModernWindow getParentWindow() {
		return mParent;
	}
	
	@Override
	public void setBackground(Color color) {
		//Set the background color of the dialog
		
		Container c = getContentPane();
		
		if (c != null) {
			c.setBackground(color);
		}
	}
	
	/**
	 * Set the border around the content pane
	 * @param border
	 */
	public void setBorder(Border border) {
		((ModernComponent)getContentPane()).setBorder(border);
	}
	
	/**
	 * Set the window title but include the main app title.
	 *
	 * @param subTitle the new sub title
	 */
	public void setSubTitle(String subTitle) {
		setTitle(subTitle + " - " + getAppInfo().getName());
	}
	
	/**
	 * Setup.
	 */
	private void setup() {
		//setModalityType(ModalityType.APPLICATION_MODAL);
		
		//setUndecorated(true);
		
		//getRootPane ().setOpaque (false);
		//getContentPane().setBackground (new Color(0, 0, 0, 0));
		//setBackground (new Color(0, 0, 0, 0));
		
		setIconImage(getAppInfo().getIcon().getImage());
		
		super.getContentPane().add(mContentPanel, BorderLayout.CENTER);
		
		setResizable(false);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		UI.centerWindowToScreen(this);
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the title
	 * @param subTitle the sub title
	 */
	public void setTitle(String title, String subTitle) {
		setTitle(subTitle + " - " + title);
	}
	
	/**
	 * Controls whether the dialog will dispose of itself once closed
	 * (free resources) or be allowed to persist in memory. By default
	 * dialogs auto dispose.
	 *
	 * @param autoDispose the new auto dispose
	 */
	public void setAutoDispose(boolean autoDispose) {
		mAutoDispose = autoDispose;
	}
	
	/**
	 * Sets the header.
	 *
	 * @param c the new header
	 */
	protected void setHeader(Component c) {
		getContentPane().add(c, BorderLayout.PAGE_START);
	}
	
	/**
	 * Sets the body.
	 *
	 * @param c the new body
	 */
	public void setBody(Component c) {
		if (mCenter != null) {
			getContentPane().remove(mCenter);
		}
		
		mCenter = c;
		getContentPane().add(c, BorderLayout.CENTER);
		getContentPane().validate();
		getContentPane().repaint();
	}
	
	/**
	 * Sets the left.
	 *
	 * @param c the new left
	 */
	public void setLeft(Component c) {
		getContentPane().add(c, BorderLayout.LINE_START);
	}
	
	/**
	 * Sets the footer.
	 *
	 * @param c the new footer
	 */
	public void setFooter(Component c) {
		getContentPane().add(c, BorderLayout.PAGE_END);
	}
	
	/**
	 * Dialogs default to a white background. This changes it to the gray
	 * background.
	 */
	public void setDarkBackground() {
		setBackground(DIALOG_BACKGROUND);
	}
	
	/**
	 * Set the background to the default white color.
	 */
	public void setLightBackground() {
		setBackground(Color.WHITE);
	}
	
	/**
	 * Set the dialog to contain a card panel.
	 * 
	 * @param c
	 */
	public void setCardContent(JComponent c) {
		setInternalContent(new ModernComponent(new CardPanel2(c), ModernWidget.QUAD_BORDER));
		
		// Auto set the background to dark so that the card contrasts.
		setDarkBackground();
	}
	
	public void setDialogCardContent(JComponent c) {
		setInternalContent(new ModernComponent(new CardPanel2(c), ModernWidget.DOUBLE_BORDER));
		
		// Auto set the background to dark so that the card contrasts.
		setDarkBackground();
	}
	
	public void setBorderlessCardContent(JComponent c) {
		setInternalContent(new BorderlessCardPanel(c));
		
		// Auto set the background to dark so that the card contrasts.
		setDarkBackground();
	}
	
	/**
	 * Set the content of the the dia
	 * @param c
	 */
	public void setFlatCardContent(JComponent c) {
		setInternalContent(new ModernComponent(new ModernLineBottomBorderPanel(new ModernPanel(c, ModernWidget.QUAD_BORDER), 
				ModernWidget.LIGHT_LINE_COLOR), 
				FLAT_BORDER));
		
		// Auto set the background to dark so that the card contrasts.
		setDarkBackground();
	}
	
	/**
	 * Adds the component as the central content of the dialog inside a
	 * bordered box with appropriate spacing.
	 *
	 * @param c the new content
	 */
	public void setContent(JComponent c) {
		setInternalContent(new ModernComponent(c, ModernWidget.QUAD_BORDER)); //c); //new ModernDialogContentPanel(c));
	}
	
	/**
	 * Sets the content of the dialog with an appropriate amount of space
	 * around the edge.
	 *
	 * @param c the new internal content
	 */
	public void setInternalContent(JComponent c) {
		setBody(c); //new ModernDialogMutliOptionPanel(c)); //new ModernComponent(c, ModernWidget.QUAD_BORDER));
	}
	
	/**
	 * Sets the buttons.
	 *
	 * @param c the new buttons
	 */
	public void setButtons(ButtonsBox c) {
		setFooter(c);
	}
	
	/**
	 * Sets the buttons.
	 *
	 * @param c the new buttons
	 */
	public void setButtons(JComponent c) {
		setFooter(c); //new ModernDialogButtonBox(c));
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JDialog#getContentPane()
	 */
	@Override
	public Container getContentPane() {
		return getContentPanel();
	}
	
	/**
	 * Gets the content panel.
	 *
	 * @return the content panel
	 */
	public ModernComponent getContentPanel() {
		return mContentPanel;
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.tooltip.ModernToolTipModel#showToolTip(org.abh.lib.ui.modern.ModernComponent, org.abh.lib.ui.modern.tooltip.ModernToolTipPanel)
	 */
	@Override
	public void showToolTip(ModernComponent source, 
			ModernToolTipPanel tooltip) {
		Point p = source.getLocationOnScreen();

		Rectangle wb = this.getBounds();

		if (p.x + tooltip.getToolTipSize().width > wb.x + wb.width) {
			p.x += source.getWidth() - tooltip.getToolTipSize().width;
		}
		
		p.y += source.getHeight();
		
		if (p.y + tooltip.getToolTipSize().height > wb.y + wb.height) {
			p.y -= source.getHeight() + tooltip.getToolTipSize().height;
		}
		
		showToolTip(source, tooltip, p);
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.tooltip.ModernToolTipModel#showToolTip(org.abh.lib.ui.modern.ModernComponent, org.abh.lib.ui.modern.tooltip.ModernToolTipPanel, java.awt.Point)
	 */
	@Override
	public synchronized void showToolTip(ModernComponent source,
			ModernToolTipPanel tooltip, 
			Point p) {
		
		// Hide any current ones
		
		JLayeredPane layeredPane = getLayeredPane();
		
		if (layeredPane == null) {
			return;
		}
		
		for (Component c : layeredPane.getComponentsInLayer(JLayeredPane.POPUP_LAYER)) {
			layeredPane.remove(c);
		}
		
		SwingUtilities.convertPointFromScreen(p, layeredPane);
		
		tooltip.setBounds(p.x,
				p.y, 
				tooltip.getToolTipSize().width, 
				tooltip.getToolTipSize().height);
		
		layeredPane.add(tooltip, JLayeredPane.POPUP_LAYER);
		
		validate();
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.abh.lib.ui.modern.tooltip.ModernToolTipModel#hideToolTips(org.abh.lib.ui.modern.ModernComponent)
	 */
	@Override
	public synchronized void hideToolTips(ModernComponent source) {
		for (Component c : getLayeredPane().getComponentsInLayer(JLayeredPane.POPUP_LAYER)) {
			getLayeredPane().remove(c);
		}
		
		validate();
		repaint();
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public final void setStatus(ModernDialogStatus status) {
		mStatus = status;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public final ModernDialogStatus getStatus() {
		return mStatus;
	}
	
	/**
	 * Returns true if the dialog was cancelled.
	 *
	 * @return true, if is cancelled
	 */
	public boolean isCancelled() {
		return mStatus == ModernDialogStatus.CANCEL;
	}
	
	/**
	 * Close.
	 */
	protected void close() {
		setVisible(false);
		
		if (mAutoDispose) {
			dispose();
		}
	}
}
