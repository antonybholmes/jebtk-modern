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
import java.util.Map;

import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class ClickFadeAnimation extends ClickAnimation {

	

	private FadeAnimation mFade;

	
	
	
	/**
	 * Instantiates a new state fade animation.
	 *
	 * @param widget the widget
	 */
	public ClickFadeAnimation(ModernWidget widget) {
		super(widget);
		
		mFade = new FadeAnimation(widget);
		
		if (((ModernClickWidget)widget).isSelected()) {
			opaque();
		} else {
			reset();
		}
	}
	
	@Override
	public void animateClick() {
		mFade.reset();
		startTimer();
	}
	
	@Override
	public void animate() {
		getWidget().repaint();

		if (mFade.getTrans() <= 0) {
			stopTimer();
		} else {
			mFade.fadeIn();
		}
	}
	
	
	public void opaque() {
		mFade.opaque();
	}
	
	public void reset() {
		mFade.reset();
	}

	/**
	 * Adds the fade color.
	 *
	 * @param name the name
	 * @param color the color
	 */
	public void setFadeColor(String name, Color color) {
		mFade.setFadeColor(name, color);
	}
	
	public void setFadeColor(String name, Color color1, Color color2) {
		mFade.setFadeColor(name, color1, color2);
	}
	
	public Color getFadeColor(String name) {
		return mFade.getFadeColor(name);
	}
	
	/**
	 * Gets the fade color map.
	 *
	 * @return the fade color map
	 */
	public Map<String, Color> getFadeColorMap() {
		return mFade.getFadeColorMap();
	}
	
	/**
	 * Gets the fade color map.
	 *
	 * @param step the step
	 * @return the fade color map
	 */
	public Map<String, Color> getFadeColorMap(int step) {
		return mFade.getFadeColorMap(step);
	}
}
