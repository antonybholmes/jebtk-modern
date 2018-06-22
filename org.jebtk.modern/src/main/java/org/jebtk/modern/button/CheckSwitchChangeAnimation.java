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

import org.jebtk.modern.animation.FadeAnimation;
import org.jebtk.modern.animation.TranslateXAnimation;
import org.jebtk.modern.event.ModernStateEvent;
import org.jebtk.modern.event.ModernStateListener;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class CheckSwitchChangeAnimation extends TranslateXAnimation {
  private ModernCheckSwitch mButton;

  private FadeAnimation mFade;

  
  public CheckSwitchChangeAnimation(ModernWidget button) {
    this(button, button.getToKeyFrame().getColor("background-color"));
  }

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public CheckSwitchChangeAnimation(ModernWidget button, Color color) {
    super(button);

    mButton = (ModernCheckSwitch) button;

    mFade = new FadeAnimation(button).setFadeColor("fill",
        button.getToKeyFrame().getColor("background-color"),
        color);
 
    // Animation should be triggered on a state change and not a click
    // event since we want the button to respond to setSelected events.
    mButton.addStateListener(new ModernStateListener() {
      @Override
      public void stateChanged(ModernStateEvent e) {
        restart();
      }
    });
    
    restart();
  }

  @Override
  public void restart() {
    int x1;
    int x2;

    if (mButton.isSelected()) {
      // Off to on

      x1 = ModernCheckSwitch.SWITCH_ICON_OFFSET;
      x2 = ModernCheckSwitch.SWITCH_ON_OFFSET;
    } else {
      // On to Off
      x1 = ModernCheckSwitch.SWITCH_ON_OFFSET;
      x2 = ModernCheckSwitch.SWITCH_ICON_OFFSET;
    }

    restart(x1, x2);
  }

  @Override
  public void drawTranslation(ModernWidget widget,
      Graphics2D g2,
      Object... params) {
    int s = ModernCheckSwitch.ORB_HEIGHT;

    int h = widget.getHeight();
    int y1 = (h - s) / 2;
   
    if (mButton.isSelected()) {
      g2.setColor(mFade.getToColor("fill"));
    } else {
      g2.setColor(mFade.getFromColor("fill")); // Color.WHITE);
    }

    // g2.setColor(Color.WHITE);
    g2.fillOval(0, y1, s, s);

    //g2.setColor(Color.WHITE);
    //s -= 2;
    //g2.fillOval(1, y1 + 1, s, s);
  }
}
