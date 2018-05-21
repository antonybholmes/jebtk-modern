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

import org.jebtk.modern.animation.FadeAnimation;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 * @param <T>
 */
public class IconTabsChangeAnimation extends FadeAnimation {
  private IconTabs mTabs;

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public IconTabsChangeAnimation(ModernWidget tabs) {
    super((IconTabs) tabs);

    mTabs = (IconTabs) tabs;

    mTabs.getTabsModel().addTabListener(new TabEventAdapter() {
      @Override
      public void tabChanged(TabEvent e) {
        restart();
      }
    });

    setFadeColor("fill",
        IconTabsIconAnimation.ICON_COLOR,
        Ribbon.BAR_BACKGROUND);
  }

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    int x = mTabs.getInsets().left;

    int selectedIndex = mTabs.getTabsModel().getSelectedIndex();

    if (selectedIndex == -1) {
      return;
    }

    ModernIcon icon = mTabs.getTabsModel().getSelectedTab().getIcon();

    int offset = (mTabs.mTabSize - mTabs.mIconSize) / 2;
    int yoffset = (mTabs.getInternalRect().getH() - mTabs.mIconSize) / 2;

    Color color = getFadeColor("fill");

    icon.drawIcon(g2,
        x + mTabs.mTabSize * selectedIndex + offset,
        yoffset,
        mTabs.mIconSize,
        mTabs.mIconSize,
        color);
  }
}
