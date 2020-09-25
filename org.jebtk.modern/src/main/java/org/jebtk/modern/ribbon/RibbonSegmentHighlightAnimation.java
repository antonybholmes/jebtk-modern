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

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import org.jebtk.modern.ModernWidget;
import org.jebtk.modern.animation.HighlightAnimation;
import org.jebtk.modern.theme.DrawUIService;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class RibbonSegmentHighlightAnimation extends HighlightAnimation {

  private RibbonSegmentVertTabs mSegments;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public RibbonSegmentHighlightAnimation(ModernWidget segments) {
    super((RibbonSegmentVertTabs) segments);

    mSegments = (RibbonSegmentVertTabs) segments;

    setFadeColor("highlight", RibbonHighlightTextAnimation.HIGHLIGHT_COLOR);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {

    int x = mSegments.getInsets().left;
    int y = mSegments.getInsets().top;

    int n = mSegments.getTabsModel().getTabCount();

    int y1;

    int w = mSegments.getInternalRect().getW();

    int highlighted = mSegments.mHighlight;

    //
    // Draw if highlighted
    //

    if (highlighted > -1 && highlighted < n) { // highlighted != selectedIndex
                                               // &&
      y1 = y + mSegments.mHighlight * RibbonSegmentVertTabs.TAB_SIZE;

      // g2.setColor(getFade().getFadeColor("highlight"));
      // g2.fillRect(x, y1, w, RibbonSegmentVertTabs.TAB_SIZE);

      DrawUIService.getInstance().getRenderer("button-fill").draw(g2,
          new IntRect(x, y1, w, RibbonSegmentVertTabs.TAB_SIZE),
          getFadeColor("highlight"));
    }
  }
}
