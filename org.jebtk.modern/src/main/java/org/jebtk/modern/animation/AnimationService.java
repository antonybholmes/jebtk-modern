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
package org.jebtk.modern.animation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.EntryCreator;
import org.jebtk.modern.button.CheckBoxAnimation;
import org.jebtk.modern.button.CheckBoxHighlightAnimation;
import org.jebtk.modern.button.CheckBoxSelectedAnimation;
import org.jebtk.modern.button.CheckBoxSelectedTickAnimation;
import org.jebtk.modern.button.CheckSwitchAnimation;
import org.jebtk.modern.button.CheckSwitchChangeAnimation;
import org.jebtk.modern.button.ChipButtonAnimation;
import org.jebtk.modern.button.ChipButtonHighlightAnimation;
import org.jebtk.modern.button.CircleButtonHighlightAnimation;
import org.jebtk.modern.button.DropDownButtonAnimation;
import org.jebtk.modern.button.DropDownButtonAnimation2;
import org.jebtk.modern.button.RadioAnimation;
import org.jebtk.modern.button.RadioOutlineAnimation;
import org.jebtk.modern.button.RadioSelectedAnimation;
import org.jebtk.modern.button.UrlTextLinkHighlightAnimation;
import org.jebtk.modern.collapsepane.CollapsePaneCardAnimation;
import org.jebtk.modern.collapsepane.CollapsePaneDividerAnimation;
import org.jebtk.modern.collapsepane.CollapsePaneExpandAnimation;
import org.jebtk.modern.collapsepane.CollapsePaneHighlightAnimation;
import org.jebtk.modern.combobox.ComboBoxAnimation;
import org.jebtk.modern.combobox.ComboBoxArrowAnimation;
import org.jebtk.modern.combobox.ComboBoxHighlightAnimation;
import org.jebtk.modern.contentpane.ModernHContentPaneAnimation;
import org.jebtk.modern.dialog.ColorDialogButtonAnimation;
import org.jebtk.modern.dialog.ColorDialogButtonHighlightAnimation;
import org.jebtk.modern.dialog.DialogButtonAnimation;
import org.jebtk.modern.dialog.DialogButtonHighlightAnimation;
import org.jebtk.modern.dialog.DialogMaterialButtonHighlightAnimation;
import org.jebtk.modern.dialog.FlatButtonAnimation;
import org.jebtk.modern.help.HelpButtonHighlightAnimation;
import org.jebtk.modern.list.ListAnimation;
import org.jebtk.modern.list.ListChangeAnimation;
import org.jebtk.modern.list.ListHighlightAnimation;
import org.jebtk.modern.listpanel.ListPanelItemAnimation;
import org.jebtk.modern.listpanel.ListPanelItemPressedAnimation;
import org.jebtk.modern.menu.MenuItemColorHighlightAnimation;
import org.jebtk.modern.menu.MenuItemColorHighlightFadeAnimation;
import org.jebtk.modern.menu.MenuItemHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonAnimation;
import org.jebtk.modern.ribbon.RibbonBackAnimation;
import org.jebtk.modern.ribbon.RibbonBackHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonButtonHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonChangeAnimation;
import org.jebtk.modern.ribbon.RibbonDropDownButtonAnimation;
import org.jebtk.modern.ribbon.RibbonDropDownButtonAnimation2;
import org.jebtk.modern.ribbon.RibbonHighlightTextAnimation;
import org.jebtk.modern.ribbon.RibbonLargeOptionalDropDownHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonLargeOptionalDropDownHighlightAnimation2;
import org.jebtk.modern.ribbon.RibbonMenuHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonMenuPressedAnimation;
import org.jebtk.modern.ribbon.RibbonSegmentAnimation;
import org.jebtk.modern.ribbon.RibbonSegmentHighlightAnimation;
import org.jebtk.modern.ribbon.RibbonSegmentPressedAnimation;
import org.jebtk.modern.ribbon.RibbonSegmentSelectedAnimation;
import org.jebtk.modern.slider.ContinuousMacOrbAnimation;
import org.jebtk.modern.spinner.SpinnerAnimation;
import org.jebtk.modern.spinner.SpinnerHighlightAnimation;
import org.jebtk.modern.splitpane.ModernHSplitPaneLineAnimation;
import org.jebtk.modern.splitpane.ModernVSplitPaneLineAnimation;
import org.jebtk.modern.tabs.BlockVertHighlightAnimation;
import org.jebtk.modern.tabs.BlockVertPressedAnimation;
import org.jebtk.modern.tabs.BlockVertSelectedAnimation;
import org.jebtk.modern.tabs.IconTabsChangeAnimation;
import org.jebtk.modern.tabs.IconTabsHighlightAnimation;
import org.jebtk.modern.tabs.IconTabsIconAnimation;
import org.jebtk.modern.tabs.OrbTabsAnimation;
import org.jebtk.modern.tabs.OrbTabsChangeAnimation;
import org.jebtk.modern.tabs.OrbTabsHighlightAnimation;
import org.jebtk.modern.tabs.SegmentAnimation;
import org.jebtk.modern.tabs.SegmentChangeAnimation;
import org.jebtk.modern.tabs.SegmentTextAnimation;
import org.jebtk.modern.text.TextBorderAnimation;
import org.jebtk.modern.tree.TreeHighlightAnimation;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Represents a vector icon that uses graphics primitives to create a scalable
 * image. Since vector icons require more computation, the RastorIcon class can
 * cache the vector icon as a bitmapped image at a particular size so it can be
 * used repeated on a GUI for greater efficiency.
 * 
 * This class contains multiple static icon constants that can be shared amongst
 * multiple classes.
 * 
 * @author Antony Holmes Holmes
 * @param <T>
 *
 */
public class AnimationService {

  /**
   * The Class UIServiceLoader.
   */
  private static class AnimationServiceLoader {

    /** The Constant INSTANCE. */
    private static final AnimationService INSTANCE = new AnimationService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static AnimationService getInstance() {
    return AnimationServiceLoader.INSTANCE;
  }

  private Map<String, AnimationCreator> mCreatorMap = 
      DefaultHashMap.create(new EntryCreator<AnimationCreator>() {
        @Override
        public AnimationCreator newEntry() {
          return new AnimationCreator();
        }
      });

  private AnimationService() {

    //
    // Load the default animations
    //

    get("button").add(DialogMaterialButtonHighlightAnimation.class);

    get("circular-button").add(CircleButtonHighlightAnimation.class);

    get("dropdown-button").add(DropDownButtonAnimation.class);
    get("dropdown-button-2").add(DropDownButtonAnimation2.class);

    get("chip-button").add(ChipButtonHighlightAnimation.class)
        .add(ChipButtonAnimation.class);

    get("dialog-flat-button").add(FlatButtonAnimation.class);

    get("ribbon").add(RibbonAnimation.class)
        // .add(RibbonPressedAnimation.class)
        .add(RibbonChangeAnimation.class)
        .add(RibbonHighlightTextAnimation.class);

    get("segment-tabs")
        // .add(SegmentHighlightAnimation.class)
        // .add(SegmentPressedAnimation.class)
        .add(SegmentChangeAnimation.class)
        .add(SegmentTextAnimation.class);
    
    get("bottom-tabs")
    .add(SegmentAnimation.class)
    .add(SegmentTextAnimation.class);

    get("orb-tabs").add(OrbTabsHighlightAnimation.class)
        .add(OrbTabsChangeAnimation.class)
        .add(OrbTabsAnimation.class);

    get("icon-tabs")
        // .add(IconTabsAnimation.class)
        .add(IconTabsHighlightAnimation.class)
        .add(IconTabsIconAnimation.class)
        .add(IconTabsChangeAnimation.class);

    get("block-vert-tabs").add(BlockVertHighlightAnimation.class)
        .add(BlockVertSelectedAnimation.class)
        .add(BlockVertPressedAnimation.class); // .add(BlockVertChangeAnimation.class);

    get("spinner").add(SpinnerAnimation.class)
        .add(SpinnerHighlightAnimation.class);

    get("help-button").add(HelpButtonHighlightAnimation.class);

    get("dialog-button")
      .add(DialogButtonAnimation.class)
      .add(DialogButtonHighlightAnimation.class);

    get("dialog-material-button")
        .add(DialogMaterialButtonHighlightAnimation.class);

    get("primary-dialog-button")
      .add(ColorDialogButtonAnimation.class)
      .add(ColorDialogButtonHighlightAnimation.class);

    get("checkbox").add(CheckBoxAnimation.class)
        .add(CheckBoxSelectedAnimation.class)
        .add(CheckBoxHighlightAnimation.class)
        .add(CheckBoxSelectedTickAnimation.class);

    get("continuous-orb-slider").add(ContinuousMacOrbAnimation.class);

    get("radio-button").add(RadioAnimation.class)
        .add(RadioSelectedAnimation.class).add(RadioOutlineAnimation.class);

    get("menu").add(MenuItemHighlightAnimation.class);

    get("color-menu").add(MenuItemColorHighlightAnimation.class);
    get("color-menu-fade")
        .add(MenuItemColorHighlightFadeAnimation.class);

    get("sub-collapse-pane").add(CollapsePaneHighlightAnimation.class)
        .add(CollapsePaneExpandAnimation.class);

    get("collapse-pane").add(CollapsePaneCardAnimation.class)
        .add(CollapsePaneHighlightAnimation.class)
        .add(CollapsePaneDividerAnimation.class)
        .add(CollapsePaneExpandAnimation.class);

    get("ribbon-button").add(RibbonButtonHighlightAnimation.class);

    get("ribbon-dropdown-button")
        .add(RibbonDropDownButtonAnimation.class);

    get("ribbon-dropdown-button-2")
        .add(RibbonDropDownButtonAnimation2.class);

    get("ribbon-optional-dropdown-button")
        .add(RibbonLargeOptionalDropDownHighlightAnimation.class);

    get("ribbon-optional-dropdown-button-2")
        .add(RibbonLargeOptionalDropDownHighlightAnimation2.class);

    get("ribbon-segments").add(RibbonSegmentHighlightAnimation.class)
        .add(RibbonSegmentSelectedAnimation.class)
        .add(RibbonSegmentPressedAnimation.class)
        .add(RibbonSegmentAnimation.class);

    get("tree").add(TreeHighlightAnimation.class);

    get("list").add(ListHighlightAnimation.class)
        .add(ListChangeAnimation.class).add(ListAnimation.class);

    get("combobox").add(ComboBoxAnimation.class)
      .add(ComboBoxAnimation.class)
      .add(ComboBoxHighlightAnimation.class)
      .add(ComboBoxArrowAnimation.class)
      .add(DialogButtonHighlightAnimation.class);

    get("text-border").add(TextBorderAnimation.class);

    get("ribbon-menu").add(RibbonMenuHighlightAnimation.class)
        .add(RibbonMenuPressedAnimation.class);

    get("ribbon-back-button").add(RibbonBackHighlightAnimation.class)
        .add(RibbonBackAnimation.class);

    get("hoz-content-pane").add(ModernHContentPaneAnimation.class);

    get("url-text-button").add(UrlTextLinkHighlightAnimation.class);

    get("splitpane-vert-line").add(ModernVSplitPaneLineAnimation.class);
    get("splitpane-hoz-line").add(ModernHSplitPaneLineAnimation.class);

    get("check-switch").add(CheckSwitchAnimation.class)
        .add(CheckSwitchChangeAnimation.class);

    get("listpanel").add(ListPanelItemPressedAnimation.class)
        .add(ListPanelItemAnimation.class);

  }

  /**
   * Returned a named creator for generating animations from classes.
   * 
   * @param name
   * @return
   */
  public AnimationCreator get(String name) {
    return mCreatorMap.get(name);
  }

  /**
   * Create the animations and bind then to a specific widget.
   * 
   * @param name The name of the animation block.
   * @param widget The widget to bind the animations to.
   * @return The animations so that they can either be assigned to a widget's
   *         foreground or background.
   */
  public Animations create(String name, ModernWidget widget) {

    AnimationCreator creator = mCreatorMap.get(name);

    if (creator == null) {
      return NoAnimations.NO_ANIMATIONS;
    }

    WidgetAnimation animation = null;

    Animations ret = new Animations();

    for (Class<?> c : creator) {
      try {
        Constructor<?> cons = c.getConstructor(ModernWidget.class);

        animation = (WidgetAnimation) cons.newInstance(widget);

        ret.add(animation);
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (SecurityException e) {
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    return ret;
  }

  /**
   * Return a list of the available animations.
   * 
   * @return The available animations by name.
   */
  public List<String> listAnimations() {
    return CollectionUtils.sort(mCreatorMap.keySet());
  }
}
