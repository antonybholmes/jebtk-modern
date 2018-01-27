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
package org.jebtk.modern.window;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.jebtk.modern.BorderService;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.contentpane.ModernHContentPane;
import org.jebtk.modern.dialog.ModernDialogConstructor;
import org.jebtk.modern.dialog.ModernDialogWindow;
import org.jebtk.modern.event.ModernClickEvent;
import org.jebtk.modern.event.ModernClickListener;
import org.jebtk.modern.graphics.icons.Raster32Icon;
import org.jebtk.modern.help.GuiAppInfo;
import org.jebtk.modern.panel.ModernPanel;
import org.jebtk.modern.ribbon.RibbonFileMenu;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.tooltip.ModernToolTipEvent;
import org.jebtk.modern.tooltip.ModernToolTipListener;
import org.jebtk.modern.tooltip.ToolTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * All windowed apps should inherit from this.
 *
 * @author Antony Holmes Holmes
 */
public class ModernWindow extends JFrame
implements ModernDialogConstructor, ModernToolTipListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant WINDOW_BORDER.
   */
  public static final Border WINDOW_BORDER = BorderService.getInstance()
      .createLineBorder(ThemeService.getInstance().colors().getHighlight(6));

  /**
   * The member layered pane.
   */
  // p//rivate JLayeredPane mLayeredPane;

  /**
   * The member tooltips.
   */
  private List<Component> mTooltips = new ArrayList<Component>();

  /**
   * The member app info.
   */
  protected GuiAppInfo mAppInfo;

  /**
   * The member cards.
   */
  protected ModernPanel mCards = new ModernPanel(new CardLayout());

  /**
   * The constant MENU_CARD.
   */
  private static final String MENU_CARD = "menu_card";

  /**
   * The constant CONTENT_CARD.
   */
  private static final String CONTENT_CARD = "content_card";

  /**
   * The member title bar panel.
   */
  // private ModernPanel mHeaderPanel = new ModernPanel();

  /**
   * The member content panel.
   */
  protected ModernPanel mWindowContentPanel = new ModernWindowContentPanel(); // ModernGradientPanel();

  private ModernComponent mContentPanel = new ModernComponent();

  private ModernHContentPane mTabsPane = new ModernHContentPane();

  /**
   * The member cl.
   */
  private CardLayout mCl;

  /**
   * The member ribbon menu.
   */
  protected RibbonFileMenu mRibbonMenu;

  /**
   * The member sub title.
   */
  private String mSubTitle;

  /** The m center. */
  private Component mCenter = null;

  /**
   * Allows multiple items such as toolbars and ribbons to be added to the top
   * of the window within the {@code CONTENT} context.
   */
  // protected VBoxAutoWidth mHeaderContainer;

  /**
   * The constant LOG.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ModernWindow.class);

  /**
   * The class MenuActions.
   */
  private class MenuActions implements ModernClickListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
     * modern .event.ModernClickEvent)
     */
    @Override
    public void clicked(ModernClickEvent e) {
      showContent();
    }

  }

  /**
   * The class WindowEvents.
   */
  private class WindowEvents extends WindowAdapter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosing(WindowEvent e) {
      close();
    }
  }

  private class AllMouseEvents implements AWTEventListener {
    private Component mContentPane;

    public AllMouseEvents(Container contentPane) {
      mContentPane = contentPane;
    }

    @Override
    public void eventDispatched(AWTEvent e) {
      if (e.getID() == MouseEvent.MOUSE_PRESSED) {
        //Point l = MouseInfo.getPointerInfo().getLocation();

        //SwingUtilities.convertPointFromScreen(l, mContentPane);

        //Component component =
        //    SwingUtilities.getDeepestComponentAt(
        //        mContentPane,
        //        l.x,
        //        l.y);

        // If there is nothing underneath, or the component is different
        // to the one that generated the mouse event, assume that means we
        // are clicking outside the bounds of the tooltip so we can hide
        // all the tooltips to replicate a loss of focus event
        //if (component == null || !component.equals(e.getSource())) {
          // Hide all tooltips
          doHideTooltips();
        //}
      }
    }
  }

  /**
   * Instantiates a new modern window.
   *
   * @param appInfo the app info
   */
  public ModernWindow(GuiAppInfo appInfo) {
    setAppInfo(appInfo);

    mRibbonMenu = new RibbonFileMenu(this);

    mCards.add(mRibbonMenu, MENU_CARD);
    mRibbonMenu.addClickListener(new MenuActions());
    mCards.add(mWindowContentPanel, CONTENT_CARD);

    // Window uses card layout
    getContentPane().add(mCards, BorderLayout.CENTER);

    mCl = (CardLayout) mCards.getLayout();
    mCl.show(mCards, CONTENT_CARD);

    mContentPanel.setBody(mTabsPane);
    setBody(mContentPanel);

    // mHeaderContainer = new WindowVBoxAutoWidth(this);
    // getWindowContentPanel().add(mHeaderContainer, BorderLayout.PAGE_START);

    addWindowListener(new WindowEvents());

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // setHeader(mHeaderPanel);

    // register existence
    WindowService.getInstance().register(this);

    // Register to receive tooltips
    ToolTipService.getInstance().addToolTipListener(this);

    //
    // Listen for clicking anywhere on the window to get rid of the tool tip
    //

    /*
    Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
      public void eventDispatched(AWTEvent e) {
        // System.out.println("get source" + e.getSource());

        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
          // System.err.println("pressed");

          // Point l = MouseInfo.getPointerInfo().getLocation();

          // System.out.println("(" + l.x + ", " + l.y + ")");

          // Hide all tooltips
          doHideTooltips();
        }
      }
    }, AWTEvent.MOUSE_EVENT_MASK);
     */
    
    Toolkit.getDefaultToolkit().addAWTEventListener(new AllMouseEvents(getContentPane()), AWTEvent.MOUSE_EVENT_MASK);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.dialog.ModernDialogConstructor#init()
   */
  public void init() {
    // Do nothing
  }

  /**
   * Gets the app info.
   *
   * @return the app info
   */
  public GuiAppInfo getAppInfo() {
    return mAppInfo;
  }

  /**
   * Sets the app info.
   *
   * @param appInfo the new app info
   */
  public void setAppInfo(GuiAppInfo appInfo) {
    mAppInfo = appInfo;
    setIconImage(new Raster32Icon(getAppInfo().getIcon()).getImage());
    setTitle(getAppInfo().getName());
  }

  /**
   * Set the window title but include the main app title.
   *
   * @param subTitle the new sub title
   */
  public void setSubTitle(String subTitle) {
    setTitle(subTitle + " - " + getAppInfo().getName());

    mSubTitle = subTitle;
  }

  /**
   * Gets the sub title.
   *
   * @return the sub title
   */
  public String getSubTitle() {
    return mSubTitle;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.Frame#setTitle(java.lang.String)
   */
  @Override
  public void setTitle(String title) {
    mSubTitle = title;

    super.setTitle(title);
  }

  /*
   * public void setRibbonMenu(RibbonFileMenu ribbonMenu) { mRibbonMenu =
   * ribbonMenu;
   * 
   * //mMenuPanel.setBody(ribbonMenu); mCards.add(ribbonMenu, MENU_CARD);
   * 
   * ribbonMenu.addClickListener(new MenuActions()); }
   */

  /**
   * Gets the ribbon menu.
   *
   * @return the ribbon menu
   */
  public RibbonFileMenu getRibbonMenu() {
    return mRibbonMenu;
  }

  /**
   * Show ribbon menu.
   */
  public void showRibbonMenu() {
    mCl.show(mCards, MENU_CARD);

    mRibbonMenu.setActiveMenuItem();
  }

  /**
   * Sets the header.
   *
   * @param c the new header
   */
  protected void setHeader(Component c) {
    // mHeaderContainer.add(c);
    getWindowContentPanel().add(c, BorderLayout.PAGE_START);
  }

  protected void setContentHeader(Component c) {
    getContentPanel().setHeader(c);
  }

  /**
   * Sets the body.
   *
   * @param c the new body
   */
  public void setBody(Component c) {
    if (mCenter != null) {
      getWindowContentPanel().remove(mCenter);
    }

    mCenter = c;

    getWindowContentPanel().add(c, BorderLayout.CENTER);
    getWindowContentPanel().validate();
    getWindowContentPanel().repaint();
  }

  public void setContentBody(Component c) {
    getContentPanel().setBody(c);
  }

  /**
   * Sets the footer.
   *
   * @param c the new footer
   */
  public void setFooter(Component c) {
    getWindowContentPanel().add(c, BorderLayout.PAGE_END);
  }

  public void setContentFooter(Component c) {
    getContentPanel().setFooter(c);
  }

  /**
   * Show the content view.
   */
  public void showContent() {
    mCl.show(mCards, CONTENT_CARD);
  }

  /**
   * Returns the panel that should have the main window content added to it.
   *
   * @return the content panel
   */
  public ModernPanel getWindowContentPanel() {
    return mWindowContentPanel;
  }

  /**
   * Returns the panel within the window content panel where the main ui
   * controls go. This panel typically appears below any tool bars.
   * 
   * @return
   */
  public ModernComponent getContentPanel() {
    return mContentPanel;
  }

  /**
   * Returns the default tabs within the content panel. For multi-column
   * interfaces such as UIs with a sidebar and main panel, use this to create
   * the columns.
   * 
   * @return
   */
  public ModernHContentPane getTabsPane() {
    return mTabsPane;
  }
  
  public void setCenterTab(JComponent c) {
    getTabsPane().getModel().setCenterTab(c);
  }

  /**
   * Sets the title bar.
   */
  // public void setTitleBar(ModernTitleBar titlebar) {
  // mHeaderPanel.setHeader(titlebar);
  // }

  /**
   * Sets the ribbon.
   *
   * @param ribbon the new ribbon
   */
  // public void setRibbon(Component ribbon) {
  // mHeaderPanel.setBody(ribbon);
  // }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.window.ModernDialogConstructor#createUi()
   */
  @Override
  public void createUi() {
    //Do nothing
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.window.ModernDialogConstructor#createMenus()
   */
  @Override
  public void createMenus() {
    //Do nothing
  }

  @Override
  public void tooltipShown(ModernToolTipEvent e) {
    if (e.getP() != null) {
      showToolTip(e.getSource(), e.getTooltip(), e.getP());
    } else {
      showToolTip(e.getSource(), e.getTooltip());
    }
  }
  
  @Override
  public void tooltipAdded(ModernToolTipEvent e) {
    if (e.getP() != null) {
      addToolTip(e.getSource(), e.getTooltip(), e.getP());
    } else {
      addToolTip(e.getSource(), e.getTooltip());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.tooltip.ModernToolTipModel#showToolTip(org.abh.lib.
   * ui. modern.ModernComponent,
   * org.abh.lib.ui.modern.tooltip.ModernToolTipPanel)
   */
  private synchronized void showToolTip(Component source, Component tooltip) {
    showToolTip(source, tooltip, toolTipP(source, tooltip));
  }
  
  private synchronized void addToolTip(Component source, Component tooltip) {
    addToolTip(source, tooltip, toolTipP(source, tooltip));
  }
  
  /**
   * Where to position the tooltip on screen.
   * 
   * @param source
   * @param tooltip
   * @return
   */
  private synchronized Point toolTipP(Component source, Component tooltip) {
    Point p = source.getLocationOnScreen();

    // Put in the context of the window
    SwingUtilities.convertPointFromScreen(p, getLayeredPane());

    Rectangle wb = getBounds();

    Dimension ps = tooltip.getPreferredSize();
    
    int w = ps.width;
    int h = ps.height;

    if (p.x + w > wb.width) {
      p.x += source.getWidth() - w;
    }

    int sh = source.getHeight();
    
    // Always show below the component
    p.y += sh;

    if (p.y + h > wb.height) {
      p.y -= sh + h;
    }

    return p;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.tooltip.ModernToolTipModel#showToolTip(org.abh.lib.
   * ui. modern.ModernComponent,
   * org.abh.lib.ui.modern.tooltip.ModernToolTipPanel, java.awt.Point)
   */
  private synchronized void showToolTip(Component source,
      Component tooltip,
      Point p) {
    
    //System.err.println("show");
    
    // Hide any current tips
    hideToolTips();

    addToolTip(source, tooltip, p);
  }
  
  private synchronized void addToolTip(Component source,
      Component tooltip,
      Point p) {
    mTooltips.add(tooltip);

    Dimension ps = tooltip.getPreferredSize();
    
    tooltip.setBounds(p.x,
        p.y,
        ps.width,
        ps.height);

    getLayeredPane().add(tooltip, JLayeredPane.POPUP_LAYER);

    revalidate();
    repaint();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.tooltip.ModernToolTipModel#hideToolTips(org.abh.lib.
   * ui. modern.ModernComponent)
   */
  private synchronized void hideToolTips() {
    //System.err.println("hide");
    
    if (mTooltips.size() > 0) {
      for (Component c : mTooltips) {
        getLayeredPane().remove(c);
      }

      mTooltips.clear();
    }
  }

  @Override
  public void tooltipHidden(ModernToolTipEvent e) {
    Component c = e.getTooltip();

    getLayeredPane().remove(c);
    mTooltips.remove(c);

    revalidate();
    repaint();
  }

  /**
   * Hide tool tips.
   */
  @Override
  public synchronized void tooltipsHidden(ModernToolTipEvent e) {
    hideToolTips();

    validate();
    repaint();
  }

  /**
   * Fire events to hide all tooltips. This method sends the hide event rather
   * than simply destroying any tooltips, hence this is the preferred way to
   * communicate to other components if the tooltips are hidden.
   */
  protected void doHideTooltips() {
    ToolTipService.getInstance().hideToolTips(new ModernToolTipEvent(this, this));
  }

  /**
   * Clear popups.
   */
  /*
   * public void clearPopups() { for (Component c :
   * getLayeredPane().getComponentsInLayer(JLayeredPane.POPUP_LAYER)) {
   * getLayeredPane().remove(c); }
   * 
   * validate(); repaint(); }
   */

  /**
   * Set the current popup.
   *
   * @param component the new popup
   */
  /*
   * public void setPopup(Component component) { for (Component c :
   * getLayeredPane().getComponentsInLayer(JLayeredPane.POPUP_LAYER)) {
   * getLayeredPane().remove(c); }
   * 
   * getLayeredPane().add(component, JLayeredPane.POPUP_LAYER);
   * 
   * validate(); repaint(); }
   */

  /**
   * Terminates the application normally.
   */
  public void exit() {
    exit(0);
  }

  /**
   * Terminate application with a given status code (non zero implies error).
   *
   * @param status the status
   */
  public void exit(int status) {
    System.exit(status);
  }

  /**
   * Close the window. If this is the last windows, it causes the VM to stop as
   * well.
   */
  public void close() {
    close(true);
  }

  /**
   * Close the window and exit application if this is the only window and auto
   * exit is true.
   *
   * @param autoExit the auto exit
   */
  public void close(boolean autoExit) {
    WindowService.getInstance().remove(this);

    setVisible(false);
    dispose();

    if (!autoExit) {
      return;
    }

    if (WindowService.getInstance().size() == 0) {
      LOG.info("Auto exit application; window count 0.");

      exit();
    }
  }

  /**
   * Restart.
   */
  public void restart() {
    close();
  }

  /**
   * Determine the underlying JFrame of a component.
   *
   * @param c the c
   * @return the modern window parent
   */
  public static ModernWindow getModernWindowParent(Container c) {
    Component w = c;

    while (w != null) {
      if (w instanceof ModernWindow) {
        return (ModernWindow) w;
      }

      w = w.getParent();
    }

    return null;
  }

  /**
   * Gets the modern dialog parent.
   *
   * @param c the c
   * @return the modern dialog parent
   */
  public static ModernDialogWindow getModernDialogParent(Container c) {
    Component w = c;

    while (w != null) {
      if (w instanceof ModernDialogWindow) {
        return (ModernDialogWindow) w;
      }

      w = w.getParent();
    }

    return null;
  }

  /**
   * Returns the ModernWindow or ModernDialog the component is a child of.
   *
   * @param c the c
   * @return the parent window
   */
  public static Window getParentWindow(Component c) {

    Component w = c.getParent();

    while (w != null) {
      if (w instanceof JFrame) {
        return (JFrame) w;
      }

      if (w instanceof JDialog) {
        return (JDialog) w;
      }

      if (w instanceof JWindow) {
        return (JWindow) w;
      }

      w = w.getParent();
    }

    return null;

    // return SwingUtilities.getWindowAncestor(c);
  }

  /**
   * Gets the layered pane.
   *
   * @param c the c
   * @return the layered pane
   */
  public static JLayeredPane getLayeredPane(Component c) {
    return getLayeredPane(getParentWindow(c));
  }

  /**
   * Returns the layer pane for a given window,.
   *
   * @param window the window
   * @return the layered pane
   */
  public static JLayeredPane getLayeredPane(Window window) {
    if (window instanceof JDialog) {
      return ((JDialog) window).getLayeredPane();
    } else if (window instanceof JFrame) {
      return ((JFrame) window).getLayeredPane();
    } else if (window instanceof JWindow) {
      return ((JWindow) window).getLayeredPane();
    } else {
      return null;
    }
  }

  /**
   * Finds the glass pane of the container window of a component.
   * 
   * @param c
   * @return
   */
  public static Component getGlassPane(Component c) {
    return getGlassPane(getParentWindow(c));
  }

  /**
   * Returns the layer pane for a given window,.
   *
   * @param window the window
   * @return the layered pane
   */
  public static Component getGlassPane(Window window) {
    if (window instanceof JDialog) {
      return ((JDialog) window).getGlassPane();
    } else if (window instanceof JFrame) {
      return ((JFrame) window).getGlassPane();
    } else if (window instanceof JWindow) {
      return ((JWindow) window).getGlassPane();
    } else {
      return null;
    }
  }

  /**
   * Trigger the window closing events.
   *
   * @param window the window
   */
  public static void close(ModernWindow window) {
    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
  }

}
