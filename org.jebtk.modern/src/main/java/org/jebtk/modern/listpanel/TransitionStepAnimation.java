package org.jebtk.modern.listpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jebtk.modern.animation.TranslateAnimation;

public abstract class TransitionStepAnimation implements ActionListener {

	/** The m pos. */
	private double[] mPos = new double[TranslateAnimation.STEPS];

	/** The m step. */
	private int mStep;

	/**
	 * Instantiates a new animate movement.
	 *
	 * @param index the index
	 * @param y2 the y 2
	 */
	public void setup(double y1, double y2) {
		double mD = y2 - y1;

		mStep = 0;

		mPos[0] = y1;
		mPos[mPos.length - 1] = y2;

		for (int i = 1; i < TranslateAnimation.MAX_STEP_INDEX; ++i) {
			mPos[i] = y1 + TranslateAnimation.BEZ_T[i] * mD;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		actionPerformed(e, mStep, mPos[mStep]);

		if (++mStep == TranslateAnimation.STEPS) {
			// Auto stop timer once we run out of steps
			((Timer)e.getSource()).stop();
		}

	}

	public abstract void actionPerformed(ActionEvent e, int step, double x);
}
