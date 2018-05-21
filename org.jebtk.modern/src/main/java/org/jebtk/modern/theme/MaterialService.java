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
package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Font;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.model.KeyStore;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.modern.widget.ModernWidget;

/**
 * The Class ThemeService.
 */
public class MaterialService {

  /**
   * The Class ThemeServiceLoader.
   */
  private static class MaterialServiceLoader {

    /** The Constant INSTANCE. */
    private static final MaterialService INSTANCE = new MaterialService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static MaterialService getInstance() {
    return MaterialServiceLoader.INSTANCE;
  }

  public static final Color TEXT_COLOR = ThemeService.getInstance().getColors()
      .getTextColor();

  /**
   * The Class MaterialFonts represents standard material fonts that are cached
   * for use across a UI.
   */
  public static class MaterialFonts extends KeyStore<String, Font> {

    /**
     * Instantiates a new material fonts.
     */
    public MaterialFonts() {
      put("text", ThemeService.loadFont("theme.material.fonts.text"));
      put("bold", ThemeService.loadFont("theme.material.fonts.bold"));
      put("title", ThemeService.loadFont("theme.material.fonts.title"));
      put("subtext", ThemeService.loadFont("theme.material.fonts.subtext"));
      put("sub-heading",
          ThemeService.loadFont("theme.material.fonts.sub-heading"));
    }

    /**
     * Returns the default material text font.
     *
     * @return the font
     */
    public Font text() {
      return get("text");
    }

    public Font bold() {
      return get("bold");
    }

    /**
     * Subtext.
     *
     * @return the font
     */
    public Font subtext() {
      return get("subtext");
    }

    public Font subHeading() {
      return get("sub-heading");
    }
  }

  /**
   * The Class MaterialColors represents material colors that are derived from
   * the current theme and cached so they can be used across a material UI.
   */
  public static class MaterialColors extends KeyStore<String, Color> {

    /**
     * Instantiates a new material colors.
     */
    public MaterialColors() {
      put("ribbon",
          ThemeService.getInstance().getColors().getTheme32(28));
      put("ribbon-highlight",
          ColorUtils.getTransparentColor(get("ribbon"), 0.92));
      put("ribbon-selected",
          ColorUtils.getTransparentColor(get("ribbon"), 0.87));
      put("ribbon-pressed",
          ColorUtils.getTransparentColor(get("ribbon"), 0.82));

      // ColorUtils.getTransparentColor75(Ribbon.BAR_BACKGROUND);

      // put("button", ColorUtils.getTransparentColor(get("ribbon"), 0.75));

      put("ribbon-menu-font",
          ThemeService.getInstance().getColors().getGray32(20));
      put("ribbon-menu-font-highlight",
          ThemeService.getInstance().getColors().getGray32(25));
      put("ribbon-menu-font-selected", ModernWidget.TEXT_COLOR);

      put("card-border",
          ColorUtils.getTransparentColor25(ModernWidget.LIGHT_LINE_COLOR));

      put("theme-highlight",
          ThemeService.getInstance().getColors().getTheme32(14));

      put("theme-selected",
          ThemeService.getInstance().getColors().getTheme32(16));

      put("theme-outline",
          ThemeService.getInstance().getColors().getTheme32(18));

      put("gray-highlight",
          ThemeService.getInstance().getColors().getGray32(4));

      put("gray-selected",
          ThemeService.getInstance().getColors().getGray32(8));

      put("gray-outline",
          ThemeService.getInstance().getColors().getGray32(15));

      put("dialog.button.fill", Color.WHITE);

      put("dialog.button.gradient.start",
          ThemeService.getInstance().getColors().getGray32(2));

      put("dialog.button.gradient.end",
          ThemeService.getInstance().getColors().getGray32(3));

      put("dialog.button.outline",
          ThemeService.getInstance().getColors().getGray32(5));

      put("dialog.button.highlight",
          ThemeService.getInstance().getColors().getGray32(10));

      put("color.dialog.button.gradient.start",
          ThemeService.getInstance().getColors().getTheme32(16));

      put("color.dialog.button.gradient.end",
          ThemeService.getInstance().getColors().getTheme32(18));

      put("color.dialog.button.outline",
          ThemeService.getInstance().getColors().getTheme32(20));

      put("color.dialog.button.highlight",
          ThemeService.getInstance().getColors().getTheme32(27));

      put("window.background",
          ThemeService.getInstance().getColors().getGray32(0));

      put("window.background.gradient.start", get("window.background"));

      put("window.background.gradient.end",
          ThemeService.getInstance().getColors().getGray32(1));

      put("line", ThemeService.getInstance().getColors().getGray32(7));

      put("alt.text", ThemeService.getInstance().getColors().getGray32(20));
    }

    public Color altText() {
      return get("alt.txt");
    }
  }
  
  public static class IntConstants extends KeyStore<String, Integer> {

    /**
     * Instantiates a new material colors.
     */
    public IntConstants() {
      put("corner-radius",
          SettingsService.getInstance().getInt("theme.constants.corner-radius"));
    }

    public int cornerRadius() {
      return get("corner-radius");
    }
  }

  /** The m fonts. */
  private MaterialFonts mFonts = new MaterialFonts();

  /** The m colors. */
  private MaterialColors mColors = new MaterialColors();
  
  private IntConstants mIntConsts = new IntConstants();

  /**
   * Fonts.
   *
   * @return the material fonts
   */
  public MaterialFonts getFonts() {
    return mFonts;
  }

  /**
   * Colors.
   *
   * @return the material colors
   */
  public MaterialColors getColors() {
    return mColors;
  }
  
  public IntConstants getInts() {
    return mIntConsts;
  }

  /**
   * Color.
   *
   * @param name the name
   * @return the color
   */
  public Color getColor(String name) {
    return getColors().get(name);
  }

  /**
   * Font.
   *
   * @param name the name
   * @return the font
   */
  public Font getFont(String name) {
    return getFonts().get(name);
  }
}
