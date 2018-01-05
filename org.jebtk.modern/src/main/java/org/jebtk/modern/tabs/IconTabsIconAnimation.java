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
package org.jebtk.modern.tabs;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.modern.animation.WidgetAnimation;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Draw all the icons except the selected.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class IconTabsIconAnimation extends WidgetAnimation {

  public static final Color ICON_COLOR = ThemeService.getInstance().colors().getHighlight(5);

  private IconTabs mTabs;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon
   *          the ribbon
   */
  public IconTabsIconAnimation(ModernWidget w) {
    super(w);

    mTabs = (IconTabs) w;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {

    int x = mTabs.getInsets().left;
    int n = mTabs.getTabsModel().getTabCount();

    int selectedIndex = mTabs.getTabsModel().getSelectedIndex();

    ModernIcon icon;

    int offset = (mTabs.mTabSize - mTabs.mIconSize) / 2;
    int yoffset = (mTabs.getHeight() - mTabs.mIconSize) / 2;

    for (int i = 0; i < n; ++i) {
      if (i != selectedIndex) {
        icon = mTabs.getTabsModel().getTab(i).getIcon();

        int x1 = x + offset;

        Color color = ICON_COLOR;

        icon.drawIcon(g2, x1, yoffset, mTabs.mIconSize, mTabs.mIconSize, color);
      }

      x += mTabs.mTabSize;
    }
  }
}
