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
package org.jebtk.modern.font;

import java.awt.Font;
import java.util.Map;

import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.DefaultHashMapCreator;
import org.jebtk.core.collections.HashMapCreator;
import org.jebtk.core.collections.IterMap;
import org.jebtk.core.path.Path;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.modern.theme.ModernTheme;

// TODO: Auto-generated Javadoc
/**
 * The Class FontService caches fonts.
 */
public class FontService extends ModernTheme {

	/**
	 * The Class ThemeServiceLoader.
	 */
	private static class FontServiceLoader {

		/** The Constant INSTANCE. */
		private static final FontService INSTANCE = new FontService();
	}

	/**
	 * Gets the single instance of SettingsService.
	 *
	 * @return single instance of SettingsService
	 */
	public static FontService getInstance() {
		return FontServiceLoader.INSTANCE;
	}
	
	/** The m font map. */
	private Map<String, IterMap<Integer, IterMap<Integer, IterMap<Boolean, IterMap<Boolean, Font>>>>> mFontMap =
			DefaultHashMap.create(
					new DefaultHashMapCreator<Integer, IterMap<Integer, IterMap<Boolean, IterMap<Boolean, Font>>>>(
							new DefaultHashMapCreator<Integer, IterMap<Boolean, IterMap<Boolean, Font>>>(
									new DefaultHashMapCreator<Boolean, IterMap<Boolean, Font>>(
											new HashMapCreator<Boolean, Font>()))));

	/**
	 * Load a font from the settings.
	 * 
	 * @param path
	 * @return
	 */
	public Font loadFont(String path) {
		return loadFont(new Path(path));
	}
	
	/**
	 * Load a font from the settings.
	 * 
	 * @param path		A path to a setting.
	 * @return
	 */
	public Font loadFont(Path path) {
		Path p = path.append("family");

		String family = SettingsService.getInstance().getAsString(p);

		p = path.append("size");

		int size = SettingsService.getInstance().getAsInt(p);
		
		p = path.append("style");

		boolean bold = SettingsService.getInstance()
				.getAsString(p)
				.contains("bold");
		
		// Second way of specifying bold
		p = path.append("bold");
		bold |= SettingsService.getInstance().getAsBool(p);
		
		
		boolean italic = SettingsService.getInstance()
				.getAsString(p)
				.contains("italic");
		
		// Second way of specifying italic
		p = path.append("italic");
		italic |= SettingsService.getInstance().getAsBool(p);

		return loadFont(family, 
				size, 
				bold,
				italic);
	}
	
	/**
	 * Load font.
	 *
	 * @param size the size
	 * @return the font
	 */
	public Font loadFont(int size) {
		return loadFont(SettingsService.getInstance().getAsString("theme.widget.fonts.text.family"), size);
	}
	
	/**
	 * Load a font.
	 *
	 * @param family	The font family, e.g. Roboto.
	 * @param size 		The font size.
	 * @return 			The font.
	 */
	public Font loadFont(String family, int size) {
		return loadFont(family, size, false);
	}
	
	/**
	 * Load a font.
	 *
	 * @param family 	The font family.
	 * @param size 		The font size.
	 * @param bold 		Whether the font should be bold.
	 * @return 			The font.
	 */
	public Font loadFont(String family, int size, boolean bold) {
		return loadFont(family, size, bold, false);
	}
	
	/**
	 * Load a font by name.
	 * 
	 * @param family	The font family, e.g. Roboto.
	 * @param size		The font size.
	 * @param bold		Whether font should be bold.
	 * @param italic	Whether font should be italic.
	 * @return			The font.
	 */
	public Font loadFont(String family,
			int size,
			boolean bold,
			boolean italic) {
		return loadFont(family, size, bold, italic, false);
	}
	
	/**
	 * Load font.
	 *
	 * @param family the family
	 * @param size the size
	 * @param bold the bold
	 * @param italic the italic
	 * @param underline the underline
	 * @return the font
	 */
	public Font loadFont(String family,
			int size,
			boolean bold,
			boolean italic,
			boolean underline) {
		return loadFont(family, size, bold, italic, underline, false);
	}
	
	/**
	 * Load font.
	 *
	 * @param family the family
	 * @param size the size
	 * @param bold the bold
	 * @param italic the italic
	 * @param underline the underline
	 * @param stikethrough the stikethrough
	 * @return the font
	 */
	public Font loadFont(String family,
			int size,
			boolean bold,
			boolean italic,
			boolean underline,
			boolean stikethrough) {
		int style;

		if (bold) {
			style = Font.BOLD;
		} else {
			style = Font.PLAIN;
		}

		if (italic) {
			style = style | Font.ITALIC;
		}

		return loadFont(family, style, size, underline, stikethrough);
	}
	
	/**
	 * Load font.
	 *
	 * @param family the family
	 * @param style the style
	 * @param size the size
	 * @return the font
	 */
	public Font loadFont(String family,
			int style,
			int size) {
		return loadFont(family, style, size, false);
	}
	
	/**
	 * Load font.
	 *
	 * @param family the family
	 * @param style the style
	 * @param size the size
	 * @param underline the underline
	 * @return the font
	 */
	public Font loadFont(String family,
			int style,
			int size,
			boolean underline) {
		return loadFont(family, style, size, underline, false);
	}
	
	/**
	 * Load font.
	 *
	 * @param family The font family, e.g. Roboto.
	 * @param style 	The font style.
	 * @param size 	The font size.
	 * @param underline the underline
	 * @param strikethrough the strikethrough
	 * @return 		The font.
	 */
	public Font loadFont(String family,
			int style,
			int size,
			boolean underline,
			boolean strikethrough) {
		if (!mFontMap
				.get(family)
				.get(style)
				.get(size)
				.get(underline)
				.containsKey(strikethrough)) {
			
			Font f = new Font(family, style, size);
			
			if (underline) {
				f = FontUtils.underline(f);
			}
			
			if (strikethrough) {
				f = FontUtils.strikethrough(f);
			}
			
			mFontMap.get(family).get(style).get(size).get(underline).put(strikethrough, f);
		}

		return mFontMap.get(family).get(style).get(size).get(underline).get(strikethrough);
	}

}
