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
package org.jebtk.modern.css;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.Resources;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.HashMapCreator;
import org.jebtk.core.collections.IterMap;
import org.jebtk.core.io.FileUtils;
import org.jebtk.core.io.PathUtils;
import org.jebtk.core.text.TextUtils;
import org.jebtk.modern.theme.MaterialService;
import org.jebtk.modern.theme.ThemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CSSKeyFramesService {

  private static class KeyFramesServiceLoader {

    /** The Constant INSTANCE. */
    private static final CSSKeyFramesService INSTANCE = new CSSKeyFramesService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static CSSKeyFramesService getInstance() {
    return KeyFramesServiceLoader.INSTANCE;
  }

  private class StyleClassXmlHandler extends DefaultHandler {
    private String mClass;
    private int mKeyFrame = 0;

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

      if (qName.equals("keyframe")) {
        String index = attributes.getValue("index");

        if (index.equals("from")) {
          mKeyFrame = CSSKeyFrames.FROM;
        } else if (index.equals("to")) {
          mKeyFrame = CSSKeyFrames.TO;
        } else {
          mKeyFrame = Integer.parseInt(attributes.getValue("index"));
        }
      } else if (qName.equals("inherits")) {
        // Copy Props from one class to another
        getStyleClass(mKeyFrame, mClass).update(getStyleClass(mKeyFrame, attributes.getValue("class")));
      } else if (qName.equals("class")) {
        mClass = attributes.getValue("name");

        // String inherits = attributes.getValue("inherits");
        // if (inherits != null) {
        // getStyleClass(mClass).inherits(getStyleClass(inherits));
        // }
      } else if (qName.equals("property")) {
        String name = attributes.getValue("name");

        String value = attributes.getValue("value");

        String v = value.toLowerCase();

        CSSClass cls = getStyleClass(mKeyFrame, mClass);

        if (TextUtils.isInt(v)) {
          cls.set(name, Integer.parseInt(v));
        } else if (TextUtils.isDouble(v)) {
          cls.set(name, Double.parseDouble(v));
        } else if (v.endsWith("%")) {
          cls.set(name, new CSSPercentProp(Integer.parseInt(v.substring(0, v.length() - 1))));
        } else if (v.endsWith("px")) {
          cls.set(name, new CSSUnitProp(Integer.parseInt(v.substring(0, v.length() - 2)), CSSUnit.PX));
        } else if (v.equals("true")) {
          // cls.set(name, true);
        } else if (v.equals("false")) {
          // cls.set(name, false);
        } else {
          if (v.startsWith("#")) {
            cls.set(name, ColorUtils.decodeHtmlColor(v));
          } else if (v.startsWith("colors.theme-32")) {
            int i = Integer.parseInt(v.substring(v.lastIndexOf("-") + 1));
            cls.set(name, ThemeService.getInstance().getColors().getTheme32(i));
          } else if (v.startsWith("colors.gray-32")) {
            int i = Integer.parseInt(v.substring(v.lastIndexOf("-") + 1));
            cls.set(name, ThemeService.getInstance().getColors().getGray32(i));
          } else if (v.startsWith("colors.material")) {
            cls.set(name, MaterialService.instance().getColor(v.replace("colors.material.", TextUtils.EMPTY_STRING)));
          } else if (v.equals("white")) {
            cls.set(name, Color.WHITE);
          } else if (v.equals("black")) {
            cls.set(name, Color.BLACK);
          } else if (v.equals("red")) {
            cls.set(name, Color.RED);
          } else if (v.equals("blue")) {
            cls.set(name, Color.BLUE);
          } else if (v.equals("green")) {
            cls.set(name, Color.GREEN);
          } else {

          }
        }
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
      if (qName.equals("keyframe")) {
        // reset to default
        mKeyFrame = CSSKeyFrames.FROM;
      }
    }
  }

  public static final String COMPONENT = "component";

  private static final Logger LOG = LoggerFactory.getLogger(CSSKeyFramesService.class);

  private static final Path DEFAULT_XML_FILE = PathUtils.getPath("res/style.xml");

  private Map<Integer, IterMap<String, CSSClass>> mStyleMap = DefaultHashMap
      .create(new HashMapCreator<String, CSSClass>());

  private boolean mAutoLoad = true;

  private CSSKeyFramesService() {
    // mStyleMap.put(COMPONENT, COMPONENT_STYLE);

    // set("border-radius", 6);

    // getStyleClass("quick-access-button").set("background-color",
    // ColorUtils.getTransparentColor75(Color.WHITE));

    /*
     * get("primary-dialog-button-f0") .set("border-color",
     * ThemeService.getInstance().getColors().getTheme32(24))
     * .set("background-color",
     * ThemeService.getInstance().getColors().getTheme32(20));
     * 
     * get("primary-dialog-button-f100") .set("border-color",
     * ThemeService.getInstance().getColors().getTheme32(28))
     * .set("background-color",
     * ThemeService.getInstance().getColors().getTheme32(24));
     */
  }

  private synchronized void autoLoad() {
    if (mAutoLoad) {
      // Set this here to stop infinite recursive calling
      // of this method.
      mAutoLoad = false;

      try {
        autoLoadXml();
      } catch (IOException | URISyntaxException | SAXException | ParserConfigurationException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Auto load xml.
   *
   * @throws IOException                  Signals that an I/O exception has
   *                                      occurred.
   * @throws URISyntaxException           the URI syntax exception
   * @throws SAXException                 the SAX exception
   * @throws ParserConfigurationException the parser configuration exception
   */
  private synchronized void autoLoadXml()
      throws IOException, URISyntaxException, SAXException, ParserConfigurationException {
    LOG.info("Auto loading styles...");

    for (String res : Resources.getInstance()) {
      if (!res.contains("style.xml")) {
        continue;
      }

      LOG.info("Loading styles from {}...", res);

      InputStream is = Resources.getResInputStream(res);

      try {
        loadXml(is);
      } finally {
        is.close();
      }
    }

    // Load local settings that may overwrite internal settings.
    loadXml(DEFAULT_XML_FILE);

    // Load any per user settings. We flag these as being updated so
    // that on the next write cycle, they will be written back to the
    // settings file.
    // loadXml(SettingsReaderUserXml.USER_XML_FILE, true);

    LOG.info("Finished loading styles.");
  }

  private synchronized boolean loadXml(Path file) throws SAXException, IOException, ParserConfigurationException {
    if (FileUtils.exists(file)) {
      InputStream is = FileUtils.newBufferedInputStream(file);

      try {
        loadXml(is);
      } finally {
        is.close();
      }

      return true;
    } else {
      return false;
    }
  }

  private synchronized boolean loadXml(InputStream is) throws SAXException, IOException, ParserConfigurationException {
    if (is == null) {
      return false;
    }

    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    StyleClassXmlHandler handler = new StyleClassXmlHandler();

    saxParser.parse(is, handler);

    return true;
  }

  /**
   * Return the style class from the default <code>KeyFrames.FROM</code> key
   * frame.
   * 
   * @param name
   * @return
   */
  public CSSClass getStyleClass(String name) {
    return getStyleClass(CSSKeyFrames.FROM, name);
  }

  public CSSClass getToStyleClass(String name) {
    return getStyleClass(CSSKeyFrames.TO, name);
  }

  public CSSClass getStyleClass(int frame, String name) {
    if (!contains(frame, name)) {
      getStyleClass(frame).put(name, new CSSClass(name));
    }

    return getStyleClass(frame).get(name);
  }

  /**
   * Returns true if the given keyframe contains a given style class.
   * 
   * @param frame The keyframe (between 0 and 100 inclusive).
   * @param name  The name of the style class.
   * @return
   */
  public boolean contains(int frame, String name) {
    return getStyleClass(frame).containsKey(name);
  }

  public Map<String, CSSClass> getStyleClass(int frame) {
    autoLoad();

    return mStyleMap.get(frame);
  }

  public void set(String name, CSSProp p) {
    getStyleClass(COMPONENT).set(name, p);
  }

  public CSSClass getCompStyleClass() {
    return getStyleClass(COMPONENT);
  }

  /*
   * private static final String getName(Collection<String> styles) {
   * Iterator<String> iter = styles.iterator();
   * 
   * StringBuilder buffer = new StringBuilder(iter.next());
   * 
   * while (iter.hasNext()) { buffer.append("-").append(iter.next()); }
   * 
   * return buffer.toString(); }
   */
}
