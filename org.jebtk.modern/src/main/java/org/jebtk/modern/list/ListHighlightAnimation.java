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
package org.jebtk.modern.list;

import java.awt.Graphics2D;

import org.jebtk.modern.MaterialService;
import org.jebtk.modern.animation.HighlightAnimation;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class ListHighlightAnimation extends HighlightAnimation {

  private ModernList<?> mList;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public ListHighlightAnimation(ModernWidget list) {
    super((ModernList<?>) list);

    mList = (ModernList<?>) list;

    getFade().setFadeColor("highlight",
        MaterialService.getInstance().color("gray-highlighted"));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {

    if (mList.mListModel == null) {
      return;
    }

    if (mList.mListModel.getItemCount() == 0) {
      return;
    }

    createImage(g2);
  }

  protected void createImage(Graphics2D g2) {
    Graphics2D g2Table = (Graphics2D) g2.create();

    double maxY = mList.getViewRect().getY() + mList.getInternalRect().getH();

    int y = 0; // mRowHeight * mVisibleCells.getStartRow();

    try {
      for (int i = 0; i < mList.getItemCount(); ++i) {
        if (y > maxY) {
          break;
        }

        if (y + mList.mRowHeight >= mList.getViewRect().getY()) {
          boolean highlighted = i == mList.mHighlightCellIndex;

          if (highlighted) {
            g2Table.setColor(getFade().getFadeColor("highlight"));
            g2Table.fillRect(0, 0, mList.getWidth(), mList.mRowHeight);
            // getWidgetRenderer().drawButton(g2, getRect(),
            // RenderMode.SELECTED);
          } else {
            // Do nothing
          }
        }

        // Move to the next cell location.
        g2Table.translate(0, mList.mRowHeight);

        y += mList.mRowHeight;
      }
    } finally {
      g2Table.dispose();
    }
  }
}
