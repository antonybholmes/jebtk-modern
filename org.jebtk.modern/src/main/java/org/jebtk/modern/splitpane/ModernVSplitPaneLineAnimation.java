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
package org.jebtk.modern.splitpane;

import java.awt.Graphics2D;

import org.jebtk.modern.animation.HoverFadeAnimation;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Provides the fade animation for quick access buttons
 */
public class ModernVSplitPaneLineAnimation extends HoverFadeAnimation {

  private ModernVSplitPaneLine mPane;

  /**
   * Instantiates a new quick access animation.
   *
   * @param button
   *          the button
   */
  public ModernVSplitPaneLineAnimation(ModernWidget pane) {
    super(pane);

    mPane = (ModernVSplitPaneLine) pane;

    setFadeColor("highlight", ModernWidget.LINE_COLOR);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = widget.getInsets().left;
    int h = widget.getInternalRect().getH();
    int y = 0;
    int x2 = widget.getWidth() - widget.getInsets().right;

    g2.setColor(getFadeColor("highlight"));

    for (int i = 0; i < mPane.mDividerLocations.size() - 1; ++i) {
      y = mPane.getInsets().top + (int) (h * mPane.mDividerLocations.get(i));

      g2.drawLine(x, y, x2, y);
    }
  }

}
