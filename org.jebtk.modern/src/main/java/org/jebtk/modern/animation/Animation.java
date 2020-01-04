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

import org.jebtk.core.NameGetter;
import org.jebtk.modern.ModernWidget;

/**
 * An animation is a series of one or more widget drawings to indicate a sense
 * of flow or movement.
 */
public interface Animation extends NameGetter {

  /**
   * The animation becomes responsible handling the drawing for the widget. 
   * This method is called on each repaint.
   *
   * @param widget the widget
   * @param g2 the g 2
   * @param params the params
   */
  public void draw(ModernWidget c, Graphics2D g2, Object... params);
}
