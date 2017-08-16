package org.jebtk.modern.collapsepane;

import java.awt.Component;
import java.awt.Graphics2D;

import org.jebtk.core.event.ChangeEventProducer;
import org.jebtk.modern.animation.ChangeAnimation;
import org.jebtk.modern.widget.ModernWidget;

public class CompResizeAnimation extends ChangeAnimation {

	protected static final int STEPS = 3;
	protected int[] mSizes = new int[STEPS];
	private Component mC;
	private int mStep;
	private int mDir = 1;
	
	public <T extends ModernWidget & ChangeEventProducer> CompResizeAnimation(T widget) {
		super(widget, 50);
	}

	@Override
	public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
		// Do nothing
	}
	
	public void restart(Component c, int min, int max, boolean fdir) {
		stopTimer();
		
		mC = c;
		
		mStep = fdir ? 0 : STEPS - 1;
		mDir = fdir ? 1 : -1;
		
		int inc = (max - min) / (STEPS - 1);
		mSizes[0] = min;
		mSizes[mSizes.length - 1] = max;
		
		for (int i = 1; i < mSizes.length - 1; ++i) {
			mSizes[i] = mSizes[i - 1] + inc;
		}
		
		startTimer();
	}

	@Override
	public void animate() {
		if (end()) {
			stopTimer();
		} else {
			animateExpand();
			
			mStep += mDir;
		}
	}
	
	public int getDim() {
		return mSizes[mStep];
	}
	
	public void animateExpand() {
		// TODO Auto-generated method stub
		
	}

	public boolean end() {
		return (mDir == 1 && mStep == STEPS) || (mDir == -1 && mStep == -1);
	}
	
	public Component getC() {
		return mC;
	}
}
