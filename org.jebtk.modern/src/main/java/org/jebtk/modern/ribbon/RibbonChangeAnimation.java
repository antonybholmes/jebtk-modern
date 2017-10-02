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
package org.jebtk.modern.ribbon;

import java.awt.Graphics2D;

import org.jebtk.core.Mathematics;
import org.jebtk.modern.animation.TranslateXAnimation;
import org.jebtk.modern.tabs.TabEvent;
import org.jebtk.modern.tabs.TabEventAdapter;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class RibbonChangeAnimation extends TranslateXAnimation {

	public static final int BAR_HEIGHT = 2;
	private Ribbon mTabs;
		
	/**
	 * Instantiates a new state animation.
	 *
	 * @param ribbon the ribbon
	 */
	public RibbonChangeAnimation(ModernWidget tabs) {
		super(tabs);

		mTabs = (Ribbon)tabs;
		
		mTabs.getTabsModel().addTabListener(new TabEventAdapter() {
			@Override
			public void tabChanged(TabEvent e) {
				restart();
			}
		});
	}
	
	public void restart() {
		int selectedIndex = mTabs.getTabsModel().getSelectedIndex();
		int previousIndex = mTabs.getTabsModel().getPreviousIndex();
		
		
		
		// Lets fix the animation so it only moves one tab regardless of
		// the number of tabs skipped, so set the previous to either the
		// one before or the one after depending on where the previous
		// tab was
		
		if (previousIndex > selectedIndex) {
			previousIndex = selectedIndex + 1;
		} else if (previousIndex < selectedIndex) {
			previousIndex = selectedIndex - 1;
		} else {
			previousIndex = selectedIndex;
		}
		
		if (previousIndex == selectedIndex) {
			return;
		}
		
		previousIndex = 
				Mathematics.bound(previousIndex, 0, mTabs.mTabStarts.size() - 1);

		int x1 = mTabs.mTabStartX + mTabs.mTabStarts.get(previousIndex); 
		int x2 = mTabs.mTabStartX + mTabs.mTabStarts.get(selectedIndex); 
		
		restart(x1, x2);
	}
	
	@Override
	public void drawTranslation(ModernWidget widget, 
			Graphics2D g2, 
			Object... params) {
		g2.setColor(Ribbon.BAR_BACKGROUND);
		g2.fillRect(0, 
				Ribbon.Y_OFFSET + Ribbon.TAB_HEIGHT - BAR_HEIGHT, 
				mTabs.mTabWidths.get(mTabs.getTabsModel().getSelectedIndex()), 
				BAR_HEIGHT);
	}	
}
