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
package org.jebtk.modern.animation;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class MouseAnimation extends WidgetAnimation {

	/** The m mouse over timer. */
	private Timer mMouseOverTimer;
	
	/** The m mouse clicked timer. */
	//private Timer mMouseClickedTimer;
	

	/** The m entry mode. */
	private boolean mEntryMode = true;
	
	/** The m pressed. */
	protected boolean mPressed = false;
	
	/**
	 * The Class MouseEvents.
	 */
	private class MouseEvents extends MouseAdapter {


		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			mEntryMode = true;
			
			startMouseOverTimer();
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			//System.err.println("mouse exit " + e.getSource());
			
			mEntryMode = false;
			
			//if (!mPressed) {
			pseudoMouseExited();
			//}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				mPressed = true;
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			mPressed = false;
			
			if (!mEntryMode) {
				pseudoMouseExited();
			}
		}
		
	}
	
	/**
	 * The Class HoverEvents.
	 */
	private class HoverEvents implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (mEntryMode) {
				animateMouseEntered();
			} else {
				animateMouseExited();
			}
		}
	}
	
	/**
	 * Instantiates a new mouse animation.
	 *
	 * @param widget the widget
	 */
	public MouseAnimation(ModernWidget widget) {
		super(widget);
		
		mMouseOverTimer = new Timer(0, new HoverEvents());
		mMouseOverTimer.setDelay(TimerAnimation.DELAY_MS);
		//mMouseClickedTimer = new Timer(0, new ClickedEvents());
		//mMouseClickedTimer.setDelay(DELAY_MS);
		
		bind(widget);
	}
	
	/**
	 * Bind the widget so it can respond with an animation. This widget can
	 * be auxiliary to the primary widget whose animation is being controlled.
	 * 
	 * @param widget
	 * @return 
	 */
	public MouseAnimation bind(Component c) {
		c.addMouseListener(new MouseEvents());
		
		return this;
	}
	
	public void startMouseOverTimer() {
		if (!mMouseOverTimer.isRunning()) {
			mMouseOverTimer.start();
		}
	}
	
	/**
	 * Stop mouse over timer.
	 */
	public void stopMouseOverTimer() {
		mMouseOverTimer.stop();
	}
	
	
	
	/**
	 * Animate mouse entered.
	 */
	public void animateMouseEntered() {
		
	}
	
	/**
	 * Animate mouse exited.
	 */
	public void animateMouseExited() {
		
	}
	
	/**
	 * Animate mouse clicked.
	 */
	public void animateMouseClicked() {
		
	}
	
	/**
	 * Gets the pressed.
	 *
	 * @return the pressed
	 */
	public boolean getPressed() {
		return mPressed;
	}
	
	/**
	 * Triggers the events an animation that a mouse exit event would, but
	 * without requiring an actual mouse event
	 */
	public void pseudoMouseExited() {
		mEntryMode = false;
		
		startMouseOverTimer();
	}
}
