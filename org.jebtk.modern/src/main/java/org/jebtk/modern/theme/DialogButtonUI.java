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

import org.jebtk.modern.ModernComponent;

/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class DialogButtonUI extends ButtonUI {

  private static final Color FILL = MaterialService.instance()
      .getColor("dialog.button.fill");

  public static final Color C1 = MaterialService.instance()
      .getColor("dialog.button.gradient.start");

  public static final Color C2 = MaterialService.instance()
      .getColor("dialog.button.gradient.end");

  private static final Color BORDER = MaterialService.instance()
      .getColor("dialog.button.outline");

  @Override
  public String getName() {
    return "dialog.button";
  }

  @Override
  public void draw(Graphics2D g2,
      ModernComponent c,
      int x,
      int y,
      int w,
      int h,
      Object... params) {

    // GradientPaint gradient = ColorUtils.getVGradient(0, h, C1, C2);

    // g2.setPaint(gradient);

    g2.setColor(FILL);

    fill(g2, c, x, y, w, h);

    g2.setColor(BORDER);
    outline(g2, c, x, y, w, h);
  }
}
