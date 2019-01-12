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
package org.jebtk.modern.panel;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.border.Border;

import org.jebtk.modern.ModernComponent;

/**
 * Lay components out in a vertical box and auto size their width so they are
 * always the same width as the box itself.
 */
public class VBoxAutoWidth extends ModernComponent {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new v box auto width panel.
   */
  public VBoxAutoWidth() {
    setLayout(new VBoxAutoWidthLayout()); // new BoxLayout(this,
                                          // BoxLayout.PAGE_AXIS));

    // addComponentListener(new ComponentEvents());
  }
  
  public VBoxAutoWidth(Border border) {
    this();
    
    setBorder(border);
  }

  public VBoxAutoWidth(Component c) {
    this(); // new BoxLayout(this, BoxLayout.PAGE_AXIS));

    setBody(c);

    //c.addComponentListener(new ComponentEvents());

    c.addPropertyChangeListener("preferredSize", new PropertyChangeListener() {

      @Override
      public void propertyChange(PropertyChangeEvent e) {
        refresh();
      }
    });
  }

  private void refresh() {
    revalidate();
    repaint();
  }

  public static ModernComponent create() {
    return new VBoxAutoWidth();
  }
  
  /*
  @Override
  public void drawBackground(Graphics2D g2) {
    g2.setColor(Color.RED);
    
    g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
  }
  */
}
