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
package org.jebtk.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import org.jebtk.modern.animation.TranslateXAnimation;
import org.jebtk.modern.event.ModernStateEvent;
import org.jebtk.modern.event.ModernStateListener;
import org.jebtk.modern.theme.ModernWidgetRenderer;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class CheckSwitchChangeAnimation extends TranslateXAnimation {

	private ModernCheckSwitch mButton;

	private Color mColor;

	/**
	 * Pick a color a few shades lighter than the background
	 */
	public static final Color SELECTED_COLOR =
			ModernWidgetRenderer.SELECTED_FILL_COLOR; //ThemeService.getInstance().colors().getColorHighlight32(ThemeService.getInstance().colors().getColorHighlightIndex(ModernWidgetRenderer.SELECTED_FILL_COLOR) / 2);

	//public static final Color LINE_COLOR =
	//		ThemeService.getInstance().colors().getHighlight32(ThemeService.getInstance().colors().getHighlightIndex(ModernWidget.LINE_COLOR) / 2);


	public CheckSwitchChangeAnimation(ModernWidget button) {
		this(button, SELECTED_COLOR);
	}
	/**
	 * Instantiates a new state animation.
	 *
	 * @param ribbon the ribbon
	 */
	public CheckSwitchChangeAnimation(ModernWidget button, Color color) {
		super(button);

		mButton = (ModernCheckSwitch)button;
		mColor = color;

		/*
		mButton.addClickListener(new ModernClickListener() {
			@Override
			public void clicked(ModernClickEvent e) {
				restart();
			}
		});
		 */

		// Animation should be triggered on a state change and not a click
		// event since we want the button to respond to setSelected events.
		mButton.addStateListener(new ModernStateListener() {
			@Override
			public void stateChanged(ModernStateEvent e) {
				restart();
			}
		});

		mButton.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent arg0) {
				restart();
			}});
	}

	public void restart() {
		int x1;
		int x2;

		int x = 0; //getWidget().getInsets().left;

		if (mButton.isSelected()) {
			// Off to on

			x1 = x + ModernCheckSwitch.SWITCH_ICON_OFFSET;
			x2 = x + ModernCheckSwitch.SWITCH_ON_OFFSET;
		} else {
			// On to Off
			x1 = x + ModernCheckSwitch.SWITCH_ON_OFFSET;
			x2 = x + ModernCheckSwitch.SWITCH_ICON_OFFSET;
		}

		restart(x1, x2);
	}
	
	public void setSelectedColor(Graphics2D g2) {
		g2.setColor(mColor);
	}

	@Override
	public void drawTranslation(ModernWidget widget, Graphics2D g2, Object... params) {
		int s = ModernCheckSwitch.ORB_HEIGHT;

		int y1 = (widget.getInternalRect().getH() - s) / 2;

		//Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

		//try {

		if (mButton.isSelected()) {
			/*
			widget.getWidgetRenderer().buttonFillPaint(g2, 
					0, 
					0, 
					s, 
					s, 
					RenderMode.SELECTED, 
					false);
			 */

			setSelectedColor(g2);
			
		} else {
			g2.setColor(ModernWidget.LINE_COLOR); //Color.WHITE);
		}

		//g2.setColor(Color.WHITE);
		g2.fillOval(0, y1, s, s);

		g2.setColor(Color.WHITE);
		s -= 2;
		g2.fillOval(1, y1 + 1, s, s);
		//} finally {
		//g2Temp.dispose();
		//}

		//if (!mButton.isSelected()) {
		//	g2.setColor(ModernWidget.LINE_COLOR);
		///
		//	g2.drawOval(0, y1, s - 1, s - 1);
		//}
	}	
}
