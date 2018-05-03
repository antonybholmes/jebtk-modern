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

import org.jebtk.modern.event.ModernSelectedEvent;
import org.jebtk.modern.event.ModernSelectedListener;
import org.jebtk.modern.widget.ModernClickWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public abstract class SelectedAnimation extends TimerAnimation {

  /**
   * The listener interface for receiving click events. The class that is
   * interested in processing a click event implements this interface, and the
   * object created with that class is registered with a component using the
   * component's <code>addClickListener<code> method. When the click event
   * occurs, that object's appropriate method is invoked.
   *
   * @see ClickEvent
   */
  private class SelectedListener implements ModernSelectedListener {

    @Override
    public void selected(ModernSelectedEvent e) {
      animateSelected();
    }
  }

  /**
   * Instantiates a new click animation.
   *
   * @param widget the widget
   */
  public SelectedAnimation(ModernClickWidget widget) {
    super(widget);

    widget.addSelectedListener(new SelectedListener());
  }

  public void animateSelected() {
    start();
  }
}
