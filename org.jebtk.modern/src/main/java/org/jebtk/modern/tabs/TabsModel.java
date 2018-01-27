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

import java.awt.Component;
import java.util.Iterator;

import javax.swing.JComponent;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.modern.contentpane.CenterTab;
import org.jebtk.modern.contentpane.SizableContentPane;
import org.jebtk.modern.graphics.icons.ModernIcon;

// TODO: Auto-generated Javadoc
/**
 * Provides a centralized model for controlling tabs on a multi-tab display.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class TabsModel extends TabEventListeners implements Iterable<Tab> {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant CENTER_PANE.
   */
  public static final String CENTER_PANE = "center_pane";

  /**
   * The member left tabs.
   */
  private Tabs mLeftTabs = new Tabs();

  /**
   * The member right tabs.
   */
  private Tabs mRightTabs = new Tabs();

  /**
   * The member center tab.
   */
  private Tab mCenterTab = null;

  // private Map<String, Integer> mNameIndexMap = new HashMap<String,
  // Integer>();

  /**
   * The selected tab.
   */
  private Tab selectedTab;

  /**
   * The member selected index.
   */
  private int mSelectedIndex = -1;

  private int mPreviousIndex = -1;

  /**
   * The class TabEvents.
   */
  private class TabEvents implements TabEventListener {

    /*
     * (non-Javadoc)
     * 
     * @see org.abh.lib.ui.modern.tabs.TabEventListener#tabAdded(org.abh.lib.ui.
     * modern. tabs.TabEvent)
     */
    @Override
    public void tabAdded(TabEvent e) {
      fireTabAdded(new TabEvent(this, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabRemoved(org.abh.lib.ui.
     * modern. tabs.TabEvent)
     */
    @Override
    public void tabRemoved(TabEvent e) {
      fireTabRemoved(new TabEvent(this, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabResized(org.abh.lib.ui.
     * modern. tabs.TabEvent)
     */
    @Override
    public void tabResized(TabEvent e) {
      fireTabResized(new TabEvent(this, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabChanged(org.abh.lib.ui.
     * modern. tabs.TabEvent)
     */
    @Override
    public void tabChanged(TabEvent e) {
      fireTabChanged(new TabEvent(this, e.getTab()));
    }

    @Override
    public void tabHighlighted(TabEvent e) {
      fireTabHighlighted(new TabEvent(this, e.getTab()));
    }
  }

  /**
   * Instantiates a new tabs model.
   */
  public TabsModel() {
    TabEvents te = new TabEvents();

    mLeftTabs.addTabListener(te);
    mRightTabs.addTabListener(te);
  }

  /**
   * Gets the tab.
   *
   * @param i the i
   * @return the tab
   */
  public Tab getTab(int i) {
    if (i == mLeftTabs.size()) {
      return mCenterTab;
    } else if (i > mLeftTabs.size()) {
      return mRightTabs.getTab(i - mLeftTabs.size() - 1);
    } else {
      return mLeftTabs.getTab(i);
    }
  }

  /**
   * Gets the tab.
   *
   * @param name the name
   * @return the tab
   */
  public Tab getTab(String name) {
    return getTab(getIndexOf(name));
  }

  /**
   * Adds the tab.
   *
   * @param name the name
   * @param c the c
   */
  public void addTab(String name, JComponent c) {
    addTab(name, c, false);
  }

  /**
   * Adds the tab.
   *
   * @param name the name
   * @param icon the icon
   * @param c the c
   */
  public void addTab(String name, ModernIcon icon, JComponent c) {
    addTab(name, icon, c, false);
  }

  /**
   * Adds the tab.
   *
   * @param name the name
   * @param c the c
   * @param closeable the closeable
   */
  public void addTab(String name, JComponent c, boolean closeable) {
    addTab(name, null, c, closeable);
  }

  /**
   * Adds the tab.
   *
   * @param name the name
   * @param icon the icon
   * @param c the c
   * @param closeable the closeable
   */
  public void addTab(String name,
      ModernIcon icon,
      JComponent c,
      boolean closeable) {
    addTab(new Tab(name, icon, c, closeable));
  }

  /**
   * Adds the tab.
   *
   * @param tab the tab
   */
  public void addTab(Tab tab) {
    if (tab.getName().equals(TabsModel.CENTER_PANE)) {
      setCenterTab(tab);
    } else {
      addLeftTab(tab);
    }
  }

  /**
   * Sets the center tab.
   *
   * @param c the new center tab
   */
  public void setCenterTab(JComponent c) {
    setCenterTab(new CenterTab(c));
  }

  /**
   * Sets the center tab.
   *
   * @param tab the new center tab
   */
  public void setCenterTab(Tab tab) {
    mCenterTab = tab;

    tab.addTabListener(new TabEvents());

    fireTabAdded(new TabEvent(this, tab));
  }

  public void addLeftTab(String name, JComponent c, int width) {
    addLeftTab(name, c, width, width, width);
  }

  /**
   * Add a resizable left tab.
   * 
   * @param name
   * @param c
   * @param width
   * @param minWidth
   * @param maxWidth
   */
  public void addLeftTab(String name,
      JComponent c,
      int width,
      int minWidth,
      int maxWidth) {
    addLeftTab(new SizableContentPane(name, c, width, minWidth, maxWidth));
  }

  /**
   * Adds the left.
   *
   * @param tab the tab
   */
  public void addLeftTab(Tab tab) {
    getLeftTabs().addTab(tab);

    fireTabAdded(new TabEvent(this, tab));

  }

  public void addRightTab(String name, JComponent c, int width) {
    addRightTab(name, c, width, width, width);
  }

  /**
   * Add a resizable right tab.
   * 
   * @param name
   * @param c
   * @param width
   * @param minWidth
   * @param maxWidth
   */
  public void addRightTab(String name,
      JComponent c,
      int width,
      int minWidth,
      int maxWidth) {
    addRightTab(new SizableContentPane(name, c, width, minWidth, maxWidth));
  }

  /**
   * Adds a right tab.
   *
   * @param tab the tab
   */
  public void addRightTab(Tab tab) {
    getRightTabs().addTab(tab);

    fireTabAdded(new TabEvent(this, tab));
  }

  /**
   * Gets the index of.
   *
   * @param name the name
   * @return the index of
   */
  public int getIndexOf(String name) {
    return mLeftTabs.indexOf(name);
  }

  /**
   * Change tab.
   *
   * @param tab the tab
   */
  public void changeTab(String tab) {
    changeTab(getIndexOf(tab));
  }

  /**
   * Change tab.
   *
   * @param index the index
   */
  public void changeTab(int index) {
    index = CollectionUtils.cyclicIndex(index, mLeftTabs.size());

    // System.err.println("change tab " + index + " " + mSelectedIndex);

    if (index != mSelectedIndex) {
      selectedTab = getTab(index);
      mPreviousIndex = mSelectedIndex;
      mSelectedIndex = index;

      fireTabChanged(new TabEvent(this, selectedTab));
    }
  }

  /**
   * Clear.
   */
  public void clear() {

    // mLeftTabs.clear();

    // firePaneRemoved(new ModernContentEvent(this, pane));

    removeAllTabs();
  }

  /**
   * Returns true if the model contains a tab with this name.
   *
   * @param tab the tab
   * @return true, if successful
   */
  public boolean containsTab(String tab) {
    return getIndexOf(tab) != -1;
  }

  /**
   * Gets the selected tab.
   *
   * @return the selected tab
   */
  public Tab getSelectedTab() {
    return selectedTab;
  }

  /**
   * Gets the selected index.
   *
   * @return the selected index
   */
  public int getSelectedIndex() {
    return mSelectedIndex;
  }

  public int getPreviousIndex() {
    return mPreviousIndex;
  }

  /**
   * Gets the tab count.
   *
   * @return the tab count
   */
  public int getTabCount() {
    return mLeftTabs.size();
  }

  /**
   * Removes the tab.
   *
   * @param tab the tab
   */
  public void removeTab(String tab) {
    mLeftTabs.removeTab(tab);
    mRightTabs.removeTab(tab);
  }

  /**
   * Removes the all tabs.
   */
  public void removeAllTabs() {
    mLeftTabs.clear();
    mRightTabs.clear();
    mCenterTab = null;

    selectedTab = null;
    mSelectedIndex = -1;

    fireTabRemoved(new TabEvent(this, null));
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<Tab> iterator() {
    return mLeftTabs.iterator();
  }

  /**
   * Gets the left tabs.
   *
   * @return the left tabs
   */
  public Tabs getLeftTabs() {
    return mLeftTabs;
  }

  /**
   * Gets the right tabs.
   *
   * @return the right tabs
   */
  public Tabs getRightTabs() {
    return mRightTabs;
  }

  /**
   * Gets the center tab.
   *
   * @return the center tab
   */
  public Tab getCenterTab() {
    return mCenterTab;
  }

  /**
   * Replace tab.
   *
   * @param name the name
   * @param c the c
   */
  public void replaceTab(String name, JComponent c) {
    getLeftTabs().replaceTab(name, c);
  }
}
