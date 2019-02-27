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

import org.jebtk.modern.theme.DrawUI;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Draws the DrawUI elements registered with the component
 */
public class DrawUIAnimation extends WidgetAnimation {

  public DrawUIAnimation(ModernWidget c) {
    super(c);
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(Graphics2D g2, ModernWidget widget, Object... params) {
    for (DrawUI d : widget.getDrawStates()) {
      d.draw(g2, widget, widget.getRect(), params);
    }
  }

  @Override
  public String getName() {
    return "draw-ui";
  }
}
