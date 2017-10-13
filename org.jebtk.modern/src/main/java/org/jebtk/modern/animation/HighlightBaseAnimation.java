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

import java.awt.Color;

import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Base animation for highlighting animations.
 *
 * @author Antony Holmes
 * @param <T>
 */
public abstract class HighlightBaseAnimation extends TimerAnimation {

	/** The m fade. */
	protected FadeAnimation mFade;


	/**
	 * Instantiates a new state animation.
	 * @param <T>
	 *
	 * @param ribbon the ribbon
	 */
	public HighlightBaseAnimation(ModernWidget widget) {
		super(widget);

		mFade = new FadeAnimation(widget);

		//mFade.setFadeColor("highlight", Ribbon.TAB_HIGHLIGHT_COLOR);
	}

	/**
	 * Restart.
	 */
	public void restart() {
		mFade.reset();
		start();
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.animation.TimerAnimation#animate()
	 */
	@Override
	public void animate() {
		getWidget().repaint();

		if (mFade.getTrans() <= 0) {
			stop();
		} else {
			mFade.fadeIn();
		}
	}
	
	public FadeAnimation getFade() {
		return mFade;
	}
	
	public Color getFadeColor(String name) {
		return getFade().getFadeColor(name);
	}
	
	public void setFadeColor(String name, Color c1, Color c2) {
		getFade().setFadeColor(name, c1, c2);
	}
	
	public double getTrans() {
		return mFade.getTrans();
	}
	
	public int getCurrentStep() {
		return mFade.getCurrentStep();
	}
}
