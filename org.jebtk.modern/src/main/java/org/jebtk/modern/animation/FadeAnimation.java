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
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.Mathematics;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.HashMapCreator;
import org.jebtk.modern.graphics.colormap.ColorMap;
import org.jebtk.modern.graphics.colormap.ColorMapColor;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public class FadeAnimation extends WidgetAnimation {


	private static final int MAX_INDEX = TimerAnimation.STEPS - 1;
	
	/** The Constant MD. */
	protected static final double MD = 1.0 / TimerAnimation.STEPS;
	
	/** The m trans. */
	//private double mTrans = 1;
	
	/** The m current step. */
	private int mCurrentStep = MAX_INDEX;
	
	/** The m fade color map. */
	private Map<Integer, Map<String, Color>> mFadeColorMap =
			DefaultHashMap.create(new HashMapCreator<String, Color>());
	
	/** Map step to transparency level */
	private Map<Integer, Double> mStepMap = new HashMap<Integer, Double>();
	
	
	/**
	 * Instantiates a new hover fade animation.
	 *
	 * @param widget the widget
	 */
	public FadeAnimation(ModernWidget widget) {
		super(widget);
		
		//double t = 0;
		
		mStepMap.put(0, 0.0);
		mStepMap.put(MAX_INDEX, 1.0);
		
		for (int i = 1; i < MAX_INDEX; ++i) {
			mStepMap.put(i, TranslateAnimation.BEZ_T[i]);
			
			//mStepMap.put(i, t);
			//t += MD;
		}
	}
	
	/**
	 * Set a fade in color that can transition linearly between transparent
	 * and opaque.
	 *
	 * @param name the name
	 * @param color the color
	 */
	public void setFadeColor(String name, Color color) {
		double t = ColorUtils.getTrans(color);
		
		double d = (1.0 - t); // / STEPS;
		
		for (int i = 0; i < TimerAnimation.STEPS; ++i) {
			Color c = ColorUtils.getTransparentColor(color, 
					t + d * TranslateAnimation.BEZ_T[i]);
			
			mFadeColorMap.get(i).put(name, c);
			
			//t += d;
		}
	}
	
	public void setFadeColor(String name, Color color1, Color color2) {
		// We need to reverse the color map because we are using the
		// transparent fade logic. This means that the default is to start
		// in the transparent state (the last step) and work backwards to
		// opaque once the animation begins. Therefore with a a color map,
		// the last color needs to be the starting color.
		List<ColorMapColor> colorMap = ColorMap.createTwoColorMap(color1, 
				color2, 
				TimerAnimation.STEPS, 
				true);
		
		for (int i = 0; i < TimerAnimation.STEPS; ++i) {
			mFadeColorMap.get(i).put(name, colorMap.get(i));
		}
	}
	
	public Color getFadeColor(String name) {
		return getFadeColorMap().get(name);
	}
	
	/**
	 * Gets the fade color map.
	 *
	 * @return the fade color map
	 */
	public Map<String, Color> getFadeColorMap() {
		return getFadeColorMap(mCurrentStep);
	}
	
	/**
	 * Gets the fade color map.
	 *
	 * @param step the step
	 * @return the fade color map
	 */
	public Map<String, Color> getFadeColorMap(int step) {
		return mFadeColorMap.get(step);
	}
	
	public void fadeIn() {
		//mTrans = Mathematics.bound(mTrans - MD, 0, 1);
		//mCurrentStep = Mathematics.bound(mCurrentStep - 1, 0, STEPS);
		
		setStep(mCurrentStep - 1);
	}
	
	public void fadeOut() {
		//mTrans = Mathematics.bound(mTrans + MD, 0, 1);
		//mCurrentStep = Mathematics.bound(mCurrentStep + 1, 0, STEPS);
		
		setStep(mCurrentStep + 1);
	}
	
	/**
	 * Gets the trans.
	 *
	 * @return the trans
	 */
	public double getTrans() {
		return mStepMap.get(mCurrentStep);
	}
	
	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		mCurrentStep = MAX_INDEX;
	}

	public int getCurrentStep() {
		return mCurrentStep;
	}

	public void setStep(int step) {
		mCurrentStep = Mathematics.bound(step, 0, MAX_INDEX);
	}

	public void opaque() {
		mCurrentStep = 0;
	}
}
