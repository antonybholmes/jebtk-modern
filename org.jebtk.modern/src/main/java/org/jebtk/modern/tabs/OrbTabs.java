/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jebtk.modern.tabs;

import java.awt.Color;

import org.jebtk.modern.theme.ThemeService;

// TODO: Auto-generated Javadoc
/**
 * Mac Style tabs.
 *
 * @author Antony Holmes Holmes
 */
public class OrbTabs extends TabsPanel {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The Constant TEXT_TAB_SELECTED_COLOR_1. */
  public static final Color TEXT_TAB_SELECTED_COLOR_1 = ThemeService
      .getInstance().colors().getTheme(3);

  /** The Constant TEXT_TAB_SELECTED_COLOR_2. */
  protected static final Color TEXT_TAB_SELECTED_COLOR_2 = ThemeService
      .getInstance().colors().getTheme(4);

  /** The Constant TEXT_TAB_SELECTED_OUTLINE_COLOR. */
  protected static final Color TEXT_TAB_SELECTED_OUTLINE_COLOR = ThemeService
      .getInstance().colors().getTheme(5);

  /** The m tab size. */
  protected int mTabSize = -1;

  /**
   * Instantiates a new segment tabs.
   *
   * @param model the model
   * @param tabSize the tab size
   * @param centered the centered
   */
  public OrbTabs(TabsModel model, int tabSize) {
    super(model);

    mTabSize = tabSize;

    createTabs();

    addToStyleClass("primary-dialog-button");
    setAnimations("orb-tabs");
  }

  private void createTabs() {
    mTabWidths.clear();

    for (int i = 0; i < getTabsModel().getTabCount(); ++i) {
      mTabWidths.add(mTabSize);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.tabs.TextTabs#changeTab(int, int)
   */
  @Override
  protected void changeTab(int x, int y) {
    getTabsModel().changeTab(getTab(x, y));
  }

  /**
   * Gets the tab.
   *
   * @param x the x
   * @param y the y
   * @return the tab
   */
  protected int getTab(int x, int y) {
    int offset = (getWidth() - mTabSize * getTabsModel().getTabCount()) / 2;
    return (x - offset) / mTabSize;
  }
}
