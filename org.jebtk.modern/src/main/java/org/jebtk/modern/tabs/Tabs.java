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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

// TODO: Auto-generated Javadoc
/**
 * Stores content panes.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class Tabs extends TabEventListeners implements Iterable<Tab> {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member tabs.
   */
  private List<Tab> mTabs = new ArrayList<Tab>();

  /**
   * The member name index map.
   */
  private Map<String, Integer> mNameIndexMap = new HashMap<String, Integer>();

  /** The m te. */
  private TabEvents mTe;

  /**
   * The class TabEvents.
   */
  private class TabEvents implements TabEventListener {

    /** The m tabs. */
    private Tabs mTabs;

    /**
     * Instantiates a new tab events.
     *
     * @param tabs
     *          the tabs
     */
    public TabEvents(Tabs tabs) {
      mTabs = tabs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabAdded(org.abh.lib.ui.modern.
     * tabs.TabEvent)
     */
    @Override
    public void tabAdded(TabEvent e) {
      fireTabAdded(new TabEvent(mTabs, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabRemoved(org.abh.lib.ui.modern.
     * tabs.TabEvent)
     */
    @Override
    public void tabRemoved(TabEvent e) {
      fireTabRemoved(new TabEvent(mTabs, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabResized(org.abh.lib.ui.modern.
     * tabs.TabEvent)
     */
    @Override
    public void tabResized(TabEvent e) {
      fireTabResized(new TabEvent(mTabs, e.getTab()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.tabs.TabEventListener#tabChanged(org.abh.lib.ui.modern.
     * tabs.TabEvent)
     */
    @Override
    public void tabChanged(TabEvent e) {
      fireTabChanged(new TabEvent(mTabs, e.getTab()));
    }

    @Override
    public void tabHighlighted(TabEvent e) {
      fireTabHighlighted(new TabEvent(mTabs, e.getTab()));
    }
  }

  /**
   * Instantiates a new tabs.
   */
  public Tabs() {
    mTe = new TabEvents(this);
  }

  /**
   * Adds the tab.
   *
   * @param name
   *          the name
   * @param c
   *          the c
   */
  public void addTab(String name, JComponent c) {
    addTab(new Tab(name, c));
  }

  /**
   * Adds the tab.
   *
   * @param pane
   *          the pane
   */
  public void addTab(Tab pane) {
    mNameIndexMap.put(pane.getName(), mTabs.size());
    mTabs.add(pane);

    pane.addTabListener(mTe);

    fireTabAdded(new TabEvent(this, pane));
    // fireTabChanged(new TabEvent(this, pane));
  }

  /**
   * Replace tab.
   *
   * @param name
   *          the name
   * @param c
   *          the c
   */
  public void replaceTab(String name, JComponent c) {
    replaceTab(new Tab(name, c));
  }

  /**
   * Replace an existing tab with a new one of the same name.
   *
   * @param tab
   *          the tab
   */
  public void replaceTab(Tab tab) {
    int index = indexOf(tab);

    if (index != -1) {
      // If tab exists (by name), replace it
      set(index, tab);
    } else {
      // Tab does not exist so add it
      addTab(tab);
    }
  }

  /**
   * Removes the tab.
   *
   * @param index
   *          the index
   */
  private void removeTab(int index) {
    if (index < 0 || index >= mTabs.size()) {
      return;
    }

    mTabs.remove(index);
  }

  // public void removeTab(Tab pane) {
  // removeTab(mTabs.indexOf(pane));
  // }

  /**
   * Contains tab.
   *
   * @param name
   *          the name
   * @return true, if successful
   */
  public boolean containsTab(String name) {
    return mNameIndexMap.containsKey(name);
  }

  /**
   * Index of.
   *
   * @param tab
   *          the tab
   * @return the int
   */
  public int indexOf(Tab tab) {
    return indexOf(tab.getName());
  }

  /**
   * Index of.
   *
   * @param name
   *          the name
   * @return the int
   */
  public int indexOf(String name) {
    if (mNameIndexMap.containsKey(name)) {
      return mNameIndexMap.get(name);
    } else {
      return -1;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<Tab> iterator() {
    return mTabs.iterator();
  }

  /**
   * Gets the tab.
   *
   * @param i
   *          the i
   * @return the tab
   */
  public Tab getTab(int i) {
    if (mTabs.size() == 0 || i < 0 || i >= mTabs.size()) {
      return null;
    }

    return mTabs.get(i);
  }

  /**
   * Size.
   *
   * @return the integer
   */
  public Integer size() {
    return mTabs.size();
  }

  /**
   * Sets the.
   *
   * @param index
   *          the index
   * @param pane
   *          the pane
   */
  public void set(int index, Tab pane) {
    mNameIndexMap.remove(mTabs.get(index).getName());
    mTabs.set(index, pane);
    mNameIndexMap.put(pane.getName(), index);

    pane.addTabListener(mTe);

    fireTabAdded(new TabEvent(this, pane));
  }

  /**
   * Remove all tabs.
   */
  public void clear() {
    removeAllTabs();
  }

  /**
   * Removes the all tabs.
   */
  public void removeAllTabs() {
    mNameIndexMap.clear();
    mTabs.clear();

    fireTabRemoved(new TabEvent(this, null));
  }

  /**
   * Remove an existing tab.
   *
   * @param tab
   *          the tab
   */
  public void removeTab(Tab tab) {
    removeTab(tab.getName());
  }

  /**
   * Removes the tab.
   *
   * @param name
   *          the name
   */
  public void removeTab(String name) {
    int index = indexOf(name);

    if (index != -1) {
      Tab pane = mTabs.get(index);

      removeTab(index);

      mNameIndexMap.remove(name);

      fireTabRemoved(new TabEvent(this, pane));
    }
  }

}
