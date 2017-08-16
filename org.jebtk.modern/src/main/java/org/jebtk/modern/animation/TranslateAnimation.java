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

import java.awt.Graphics2D;

import org.jebtk.math.CubicBezier;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for graphics to transition between two fixed points linearly.
 *
 * @author Antony Holmes
 */
public abstract class TranslateAnimation extends TimerAnimation {

	// Lets define a material design bezier curve to animate transitions
	public final static CubicBezier BEZIER = 
			CubicBezier.normCubicBezier(0.4, 0.0, 0.2, 1);
	
	
	
	private int[] mXPos = new int[STEPS];
	private int mStep = 0;
	public static final double[] BEZ_T = new double[STEPS];

	
	static {
		BEZ_T[0] = 0; //BEZIER.eval(0).getY();
		BEZ_T[MAX_STEP_INDEX] = 1; //BEZIER.eval(1).getY();
		
		for (int i = 1; i < MAX_STEP_INDEX; ++i) {
			BEZ_T[i] = BEZIER.eval((double)i / MAX_STEP_INDEX).getY();
		}
	}

	/**
	 * Instantiates a new state animation.
	 *
	 * @param ribbon the ribbon
	 */
	public TranslateAnimation(ModernWidget widget) {
		super(widget);
	}
	
	public synchronized void restart(int x1, int x2) {
		int mD = (x2 - x1); // / MAX_INDEX;
		
		mStep = 0;
		
		mXPos[0] = x1;
		mXPos[mXPos.length - 1] = x2;
		
		for (int i = 1; i < MAX_STEP_INDEX; ++i) {
			mXPos[i] = x1 + (int)(BEZ_T[i] * mD); //BEZIER.eval(t)   mXPos[i - 1] + mD;
		}
		
		startTimer();
	}
	
	@Override
	public synchronized void animate() {
		super.animate();
		
		//System.err.println("translate " + mStep);

		if (++mStep == MAX_STEP_INDEX) {
			stopTimer();
		}
	}
	
	public int getX() {
		return mXPos[mStep];
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.ModernWidget, java.awt.Graphics2D, java.lang.Object[])
	 */
	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {

		Graphics2D g2Temp = ImageUtils.clone(g2);
		
		try {
			translate(g2Temp);
			
			drawTranslation(widget, g2Temp, params);
		} finally {
			g2Temp.dispose();
		}
	}
	
	public abstract void translate(Graphics2D g2);
	
	public abstract void drawTranslation(ModernWidget widget, 
			Graphics2D g2, 
			Object... params);
}
