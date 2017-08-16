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
package org.jebtk.modern.widget.tooltip;

import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import org.jebtk.modern.widget.ModernFocusableWidget;
import org.jebtk.modern.widget.ModernWidget;
import org.jebtk.modern.window.ModernWindow;



// TODO: Auto-generated Javadoc
/**
 * Provides the ability for a widget to display tool tips. By default
 * the control will look for an underlying window that supports tool tips
 * and send tooltip events to this; however, this can be easily overridden
 * if necessary.
 * 
 * @author Antony Holmes Holmes
 *
 */
public abstract class ModernToolTipWidget extends ModernFocusableWidget {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The member tool tip model.
	 */
	protected ModernToolTipModel mToolTipModel = null;

	/**
	 * The member tool tip panel.
	 */
	protected ModernBasicToolTipPanel mToolTipPanel = null;

	/**
	 * The delay in ms after which a tooltip is shown.
	 */
	private static final int DELAY = 800;

	/**
	 * The member timer.
	 */
	private Timer mTimer = new Timer(0, new ToolTipEvents());

	/**
	 * The class ToolTipEvents.
	 */
	private class ToolTipEvents implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			displayToolTip();
		}
	}
	
	/**
	 * The class MouseEvents.
	 */
	private class MouseEvents extends MouseAdapter {
		
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			showToolTip();
		}
			
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			hideToolTips();
		}
			
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			hideToolTips();
		}
	}
	
	/**
	 * Instantiates a new modern tool tip widget.
	 */
	public ModernToolTipWidget() {
		setup();
	}
	
	/**
	 * Instantiates a new modern tool tip widget.
	 *
	 * @param manager the manager
	 */
	public ModernToolTipWidget(LayoutManager manager) {
		super(manager);
		
		setup();
	}

	/**
	 * Setup.
	 */
	private void setup() {
		mTimer.setInitialDelay(DELAY);
		
		addMouseListener(new MouseEvents());

		/*
		TreeNode<String> setting = 
				Settings.getInstance().getChild("help/ribbon/tooltips/delay");
		
		if (setting != null) {
			delay = ((KeyNode)setting).asInt();
		} else {
			delay = 1000;
		}
		*/
	}

	/**
	 * Sets the tool tip.
	 *
	 * @param tooltip the tooltip
	 * @param tooltipModel the tooltip model
	 */
	public void setToolTip(ModernToolTip tooltip, 
			ModernToolTipModel tooltipModel) {
		setToolTip(new ModernToolTipSuggestHelpPanel(tooltip), tooltipModel);
	}
	
	/**
	 * Sets the tool tip.
	 *
	 * @param tooltipPanel the tooltip panel
	 * @param tooltipModel the tooltip model
	 */
	public void setToolTip(ModernBasicToolTipPanel tooltipPanel, 
			ModernToolTipModel tooltipModel) {
		setToolTip(tooltipPanel);
		
		setToolTipModel(tooltipModel);
	}
	
	/**
	 * Sets the tool tip.
	 *
	 * @param title the title
	 * @param help the help
	 * @return 
	 */
	public ModernToolTipWidget setToolTip(String title, String help) {
		return setToolTip(new ModernToolTip(title, help));
	}
	
	/**
	 * Set the tooltip along with the model to display the tool tip.
	 *
	 * @param title the title
	 * @param help the help
	 * @param tooltipModel the tooltip model
	 */
	public void setToolTip(String title, 
			String help, 
			ModernToolTipModel tooltipModel) {
		setToolTip(title, help);
		
		setToolTipModel(tooltipModel);
	}
	
	/**
	 * Sets the tool tip.
	 *
	 * @param tooltip the new tool tip
	 * @return 
	 */
	public ModernToolTipWidget setToolTip(ModernToolTip tooltip) {
		return setToolTip(new ModernToolTipSuggestHelpPanel(tooltip));
	}
	
	/**
	 * Sets the tool tip.
	 *
	 * @param tooltipPanel the new tool tip
	 * @return 
	 */
	public ModernToolTipWidget setToolTip(ModernBasicToolTipPanel tooltipPanel) {
		mToolTipPanel = tooltipPanel;
		
		return this;
	}
	
	/**
	 * Sets the tool tip model.
	 *
	 * @param tooltipModel the new tool tip model
	 */
	public void setToolTipModel(ModernToolTipModel tooltipModel) {
		mToolTipModel = tooltipModel;
	}
	
	/**
	 * Gets the tool tip model.
	 *
	 * @return the tool tip model
	 */
	public ModernToolTipModel getToolTipModel() {
		
		if (mToolTipModel == null) {
			mToolTipModel = getToolTipDisplay(this);
		}
		
		return mToolTipModel;
	}
	
	/**
	 * Show tool tip.
	 */
	protected void showToolTip() {
		if (mToolTipPanel == null) {
			return;
		}
		
		mTimer.start(); 

	}
	
	/**
	 * Hide tool tips.
	 */
	protected void hideToolTips() {
		if (mToolTipPanel == null) {
			return;
		}
		
		mTimer.stop();
		
		//mShow = false;
		
		getToolTipModel().hideToolTips(this);
	}
	
	/**
	 * Display tool tip.
	 */
	private void displayToolTip() {
		//if (!mShow) {
		//	return;
		//}
		
		getToolTipModel().showToolTip(this, mToolTipPanel);
	}
	
	/**
	 * Gets the tool tip display.
	 *
	 * @param source the source
	 * @return the tool tip display
	 */
	public static ModernToolTipModel getToolTipDisplay(ModernWidget source) {
		Window w = ModernWindow.getParentWindow(source);
		
		if (w instanceof ModernToolTipModel) {
			return (ModernToolTipModel)w;
		} else {
			return null;
		}
	}
}