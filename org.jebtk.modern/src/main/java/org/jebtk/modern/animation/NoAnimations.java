package org.jebtk.modern.animation;

public class NoAnimations extends Animations {

	private static final long serialVersionUID = 1L;

	public static final Animations NO_ANIMATIONS = new NoAnimations();
	
	@Override
	public void update(Animation animation) {
		// Do nothing
	}

}
