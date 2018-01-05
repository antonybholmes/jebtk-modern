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
package org.jebtk.modern.panel;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.UI;
import org.jebtk.modern.text.ModernAutoSizeLabel;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a hbox containing two components, one aligned left, the other aligned
 * right that expands to fill horizontal space.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class HExpandBox extends ModernComponent implements ComponentListener {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  public HExpandBox() {
    setLayout(null);

    UI.setSize(this, ModernWidget.MAX_SIZE_24);

    addComponentListener(this);
  }

  /**
   * Instantiates a new h expand box.
   *
   * @param name
   *          the name
   * @param c2
   *          the c 2
   * @param others
   *          the others
   */
  public HExpandBox(String name, Component c2, Component... others) {
    this(new ModernAutoSizeLabel(name), c2, others);
  }

  /**
   * Instantiates a new h expand box.
   *
   * @param c1
   *          the c 1
   * @param c2
   *          the c 2
   * @param others
   *          the others
   */
  public HExpandBox(Component c1, Component c2, Component... others) {
    this();

    add(c1, c2, others);
  }

  public Component add(String name, Component c2) {
    add(new ModernAutoSizeLabel(name), c2);

    return this;
  }

  public void add(String name, Component c2, Component... others) {
    add(new ModernAutoSizeLabel(name), c2, others);
  }

  public void add(Component c1, Component c2) {
    add(c1);
    add(c2);
  }

  public void add(Component c1, Component c2, Component... others) {
    add(c1);
    add(c2);

    for (Component c : others) {
      add(c);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.
   * ComponentEvent)
   */
  @Override
  public void componentHidden(ComponentEvent arg0) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.
   * ComponentEvent)
   */
  @Override
  public void componentMoved(ComponentEvent e) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.ComponentListener#componentResized(java.awt.event.
   * ComponentEvent)
   */
  @Override
  public void componentResized(ComponentEvent e) {

    int h = mInternalRect.getH();

    Component c;

    c = getComponent(0);
    c.setBounds(getInsets().left, getInsets().top, c.getPreferredSize().width, h);

    // Determine the offset of the right components
    int w = 0;

    for (int i = 1; i < getComponentCount(); ++i) {
      c = getComponent(i);

      w += c.getPreferredSize().width;
    }

    int x = mRect.getW() - getInsets().right - w;

    for (int i = 1; i < getComponentCount(); ++i) {
      c = getComponent(i);

      w = c.getPreferredSize().width;

      c.setBounds(x, getInsets().top, w, h);

      x += w;
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.ComponentListener#componentShown(java.awt.event.
   * ComponentEvent)
   */
  @Override
  public void componentShown(ComponentEvent e) {
    // TODO Auto-generated method stub

  }
}
