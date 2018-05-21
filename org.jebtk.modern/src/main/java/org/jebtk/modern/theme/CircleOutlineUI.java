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

import java.awt.Graphics2D;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.graphics.ImageUtils;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class CircleOutlineUI extends ButtonOutlineUI {

  @Override
  public String getName() {
    return "circle-outline";
  }

  @Override
  public void outline(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    w = Math.max(w, h) - 1;

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    try {
      g2Temp.drawOval(x, y, w, w);
    } finally {
      g2Temp.dispose();
    }
  }
}
