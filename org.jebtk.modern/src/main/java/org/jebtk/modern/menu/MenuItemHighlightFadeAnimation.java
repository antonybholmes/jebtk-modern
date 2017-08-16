package org.jebtk.modern.menu;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import org.jebtk.modern.button.ButtonHighlightAnimation;
import org.jebtk.modern.widget.ModernWidget;

public abstract class MenuItemHighlightFadeAnimation extends ButtonHighlightAnimation {
	public MenuItemHighlightFadeAnimation(ModernWidget button) {
		super(button);
		
		// This is so when the menu item is pressed and is causes a popup
		// to disappear as part of its action, the menu is reset to the off
		// state so that it does not appear highlighted if the popup is 
		// reused and shown again
		button.addHierarchyListener(new HierarchyListener(){

			@Override
			public void hierarchyChanged(HierarchyEvent e) {
				pseudoMouseExited();
			}});
	}
}
