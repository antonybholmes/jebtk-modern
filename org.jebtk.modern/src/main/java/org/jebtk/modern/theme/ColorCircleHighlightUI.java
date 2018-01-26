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
package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

// TODO: Auto-generated Javadoc
/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class ColorCircleHighlightUI extends ColorButtonUI {
  
  @Override
  public String getName() {
    return "color.circle.highlight";
  }

  @Override
  public void fill(Graphics2D g2,
      int x,
      int y,
      int w,
      int h,
      Object... params) {
    
    if (params.length > 0) {
      g2.setColor((Color) params[0]);
    } else {
      g2.setColor(HIGHLIGHTED_FILL_COLOR);
    }
    
    w = Math.max(w - 1, h - 1);
    
    g2.fillOval(x, y, w, w);
  }
}