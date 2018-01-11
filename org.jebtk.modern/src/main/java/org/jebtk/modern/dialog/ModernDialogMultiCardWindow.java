/**
 * Copyright 2016 Antony Holmes
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
package org.jebtk.modern.dialog;

import java.awt.Component;

import javax.swing.JComponent;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.UI;
import org.jebtk.modern.panel.Card;
import org.jebtk.modern.tabs.BlockVertTabs;
import org.jebtk.modern.tabs.TabsModel;
import org.jebtk.modern.tabs.TabsViewPanel;
import org.jebtk.modern.widget.ModernWidget;
import org.jebtk.modern.window.ModernWindow;
import org.jebtk.modern.window.WindowWidgetFocusEvents;

// TODO: Auto-generated Javadoc
/**
 * The class TTestDialog.
 */
public class ModernDialogMultiCardWindow extends ModernDialogHelpWindow {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member tabs model.
   */
  protected TabsModel mTabsModel = new TabsModel();

  /** The m view panel. */
  protected TabsViewPanel mViewPanel = new TabsViewPanel(mTabsModel);

  private ModernComponent mTabsPanel = new ModernComponent();

  /**
   * Instantiates a new t test dialog.
   *
   * @param parent the parent
   * @param title the title
   * @param help the help
   */
  public ModernDialogMultiCardWindow(ModernWindow parent, String title,
      String help) {
    this(parent, title, help, ModernDialogTaskType.CLOSE);
  }

  /**
   * Instantiates a new modern dialog multi option window.
   *
   * @param parent the parent
   * @param title the title
   * @param help the help
   * @param type the type
   */
  public ModernDialogMultiCardWindow(ModernWindow parent, String title,
      String help, ModernDialogTaskType type) {
    super(parent, help, type);

    init(title, type);
  }

  /**
   * Instantiates a new modern dialog multi option window.
   *
   * @param parent the parent
   * @param title the title
   */
  public ModernDialogMultiCardWindow(ModernWindow parent, String title) {
    this(parent, title, ModernDialogTaskType.CLOSE);
  }

  /**
   * Instantiates a new modern dialog multi option window.
   *
   * @param parent the parent
   * @param title the title
   * @param type the type
   */
  public ModernDialogMultiCardWindow(ModernWindow parent, String title,
      ModernDialogTaskType type) {
    super(parent, ModernDialogTaskType.CLOSE);

    init(title, type);
  }

  /**
   * Inits the.
   *
   * @param title the title
   * @param type the type
   */
  private void init(String title, ModernDialogTaskType type) {
    setTitle(title);

    setDarkBackground();

    createUi(type);

    addWindowListener(new WindowWidgetFocusEvents(mOkButton));

    setSize(640, 480);

    UI.centerWindowToScreen(this);
  }

  /**
   * Adds the tab.
   *
   * @param name the name
   * @param c the c
   */
  public void addTab(String name, JComponent c) {
    // mTabsModel.addTab(name, new ModernDialogPanel(c));
    mTabsModel.addTab(name, c); // new ModernDialogMutliOptionPanel(c,
                                // ModernWidget.QUAD_PADDING));
  }

  /**
   * Gets the tabs model.
   *
   * @return the tabs model
   */
  public TabsModel getTabsModel() {
    return mTabsModel;
  }

  /**
   * Creates the ui.
   *
   * @param type the type
   */
  private final void createUi(ModernDialogTaskType type) {
    // this.getContentPane().add(new JLabel("Change " +
    // getProductDetails().getProductName() + " settings", JLabel.LEFT),
    // BorderLayout.PAGE_START);

    // VBox();

    // Left Panel

    BlockVertTabs tabs = new BlockVertTabs(mTabsModel, 40);

    // ModernComponent leftPanel = new RightLineBorderComponent(tabs,
    // ModernWidget.LIGHT_LINE_COLOR);

    // ModernComponent leftPanel = new ModernComponent(tabs);

    // LeftShadowPanel

    // if (mHelpButton != null) {
    // leftPanel.setFooter(new ModernComponent(mHelpButton,
    // ModernWidget.DOUBLE_PADDING));
    // }

    UI.setSize(tabs, 160, Short.MAX_VALUE);

    ModernComponent panel = new ModernComponent();

    mTabsPanel.setBody(tabs);

    panel.setLeft(mTabsPanel);

    // getButtonBar().addLeft(mHelpButton);

    // ModernComponent content = new ModernPanel();

    ModernComponent tabsPanel = new ModernComponent(
        new Card(new ModernComponent(mViewPanel, ModernWidget.QUAD_BORDER)),
        ModernWidget.DOUBLE_BORDER);

    // content.setBody(tabsPanel);

    panel.setBody(tabsPanel);

    setInternalContent(panel);

    // setup(type);
  }

  public void setLeftSecondary(Component c) {
    mTabsPanel.setFooter(c);
  }
}
