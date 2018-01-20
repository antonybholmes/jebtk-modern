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
package org.jebtk.modern.theme;

import java.util.Iterator;

import org.jebtk.core.collections.IterHashMap;
import org.jebtk.core.collections.IterMap;

// TODO: Auto-generated Javadoc
/**
 * Provides the shared renderer to components. This is the default way to
 * control component look and feel and to ensure they share renderers as much as
 * possible.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class UIDrawService implements Iterable<String> {

  /**
   * The Class WidgetRendererServiceLoader.
   */
  private static class UIRendererServiceLoader {

    /** The Constant INSTANCE. */
    private static final UIDrawService INSTANCE = new UIDrawService();
  }

  /**
   * Gets the single instance of SettingsService.
   *
   * @return single instance of SettingsService
   */
  public static UIDrawService getInstance() {
    return UIRendererServiceLoader.INSTANCE;
  }

  private IterMap<String, UIRenderer> mRenderMap = 
      new IterHashMap<String, UIRenderer>();

  private UIDrawService() {
    // Do nothing
    
    add(new ContentBoxUI());
    add(new TextBorderUI());
    add(new ButtonHighlightUI());
    add(new ButtonSelectedUI());
    add(new CircleHighlightUI());
    add(new MenuHighlightUI());
    add(new PillHighlightUI());
    //add(new CheckedUI());
    add(new CheckedBoxUI());
    
    add("checkbox", get("content-box"));
    
    add(new ColorButtonHighlightUI());
    add(new ColorButtonSelectedUI());
  }
  
  public void add(UIRenderer renderer) {
    add(renderer.getName(), renderer);
  }
  
  public void add(String name, UIRenderer renderer) {
    mRenderMap.put(name, renderer);
  }
  
  /**
   * Return a named UI rendering component.
   * 
   * @param name
   * @return
   */
  public UIRenderer get(String name) {
    return mRenderMap.get(name);
  }

  @Override
  public Iterator<String> iterator() {
    return mRenderMap.keySet().iterator();
  }
}
