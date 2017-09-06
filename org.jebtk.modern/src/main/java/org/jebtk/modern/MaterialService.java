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
package org.jebtk.modern;
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


import java.awt.Color;
import java.awt.Font;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.model.KeyStore;
import org.jebtk.modern.theme.ThemeService;
import org.jebtk.modern.widget.ModernWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
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

	/** The Constant LOG. */
	private final static Logger LOG = 
			LoggerFactory.getLogger(MaterialService.class);

	
	/**
	 * The Class MaterialFonts represents standard material fonts that
	 * are cached for use across a UI.
	 */
	public static class MaterialFonts extends KeyStore<String, Font> {
		
		/**
		 * Instantiates a new material fonts.
		 */
		public MaterialFonts() {
			put("text", ThemeService.loadFont("theme.material.fonts.text"));
			put("title", ThemeService.loadFont("theme.material.fonts.title"));
			put("subtext", ThemeService.loadFont("theme.material.fonts.subtext"));
			put("widget", ThemeService.loadFont("theme.material.fonts.widget"));
		}
		
		/**
		 * Returns the default material text font.
		 *
		 * @return the font
		 */
		public Font text() {
			return get("text");
		}
		
		/**
		 * Subtext.
		 *
		 * @return the font
		 */
		public Font subtext() {
			return get("subtext");
		}
		
		/**
		 * Widget.
		 *
		 * @return the font
		 */
		public Font widget() {
			return get("widget");
		}
	}
	
	/**
	 * The Class MaterialColors represents material colors that are 
	 * derived from the current theme and cached so they can be used across
	 * a material UI.
	 */
	public static class MaterialColors extends KeyStore<String, Color> {

		/**
		 * Instantiates a new material colors.
		 */
		public MaterialColors() {
			put("ribbon-theme", ThemeService.getInstance().colors().getColorHighlight32(28));
			put("ribbon-theme-highlighted", ColorUtils.getTransparentColor(get("ribbon-theme"), 0.92));
			put("ribbon-theme-selected", ColorUtils.getTransparentColor(get("ribbon-theme"), 0.87));
			put("ribbon-theme-pressed", ColorUtils.getTransparentColor(get("ribbon-theme"), 0.82));
			
			//ColorUtils.getTransparentColor75(Ribbon.BAR_BACKGROUND);
			
			put("button", ColorUtils.getTransparentColor(get("ribbon-theme"), 0.75));
			
			
			put("gray", ThemeService.getInstance().colors().getHighlight32(28));
			put("gray-highlighted", ColorUtils.getTransparentColor(get("gray"), 0.92));
			put("gray-selected", ColorUtils.getTransparentColor(get("gray"), 0.87));
			put("gray-pressed", ColorUtils.getTransparentColor(get("gray"), 0.82));
			
			put("ribbon-menu-font", ThemeService.getInstance().colors().getHighlight32(20));
			put("ribbon-menu-font-highlighted", ThemeService.getInstance().colors().getHighlight32(25));
			put("ribbon-menu-font-selected", ModernWidget.TEXT_COLOR);
			
			put("card-border", ColorUtils.getTransparentColor25(ModernWidget.LIGHT_LINE_COLOR));
		}
		
	}
	
	/** The m fonts. */
	private MaterialFonts mFonts = new MaterialFonts();
	
	/** The m colors. */
	private MaterialColors mColors = new MaterialColors();
		
	/**
	 * Fonts.
	 *
	 * @return the material fonts
	 */
	public MaterialFonts fonts() {
		return mFonts;
	}
		
	/**
	 * Colors.
	 *
	 * @return the material colors
	 */
	public MaterialColors colors() {
		return mColors;
	}

	/**
	 * Color.
	 *
	 * @param name the name
	 * @return the color
	 */
	public Color color(String name) {
		return colors().get(name);
	}

	/**
	 * Font.
	 *
	 * @param name the name
	 * @return the font
	 */
	public Font font(String name) {
		return fonts().get(name);
	}
}