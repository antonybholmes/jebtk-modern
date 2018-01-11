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
package org.jebtk.modern.zoom;

import java.text.ParseException;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.text.TextUtils;
import org.jebtk.modern.UI;
import org.jebtk.modern.combobox.ModernComboBox;
import org.jebtk.modern.event.ModernClickEvent;
import org.jebtk.modern.event.ModernClickListener;
import org.jebtk.modern.panel.HBox;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Standardized ribbon menu section for providing basic cut, copy and paste
 * functionality to the currently highlighted control that supports clipboard
 * operations.
 *
 * @author Antony Holmes Holmes
 *
 */
public class ZoomRibbonPanel extends HBox
    implements Zoom, ModernClickListener, ChangeListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member zoom combo.
   */
  private ModernComboBox mZoomCombo = new ZoomComboBox();

  /**
   * The member zoom.
   */
  private double mZoom = 1.0;

  /**
   * The member min zoom.
   */
  private double mMinZoom = 0.1;

  /**
   * The member max zoom.
   */
  private double mMaxZoom = 4;

  /**
   * The member model.
   */
  private ZoomModel mModel;

  /**
   * Instantiates a new zoom ribbon panel2.
   *
   * @param model the model
   */
  public ZoomRibbonPanel(ZoomModel model) {
    mModel = model;

    model.addChangeListener(this);

    UI.setSize(mZoomCombo, ModernWidget.SMALL_SIZE);

    // add(mZoomOutButton, BorderLayout.LINE_START);
    add(mZoomCombo);
    // add(mZoomInButton, BorderLayout.LINE_END);

    mZoomCombo.addClickListener(this);

    updateZoom();
  }

  /**
   * Enabled or disable all the controls on the panel.
   *
   * @param enabled the enabled
   */
  public final void enableControls(boolean enabled) {
    mZoomCombo.setEnabled(enabled);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  public void clicked(ModernClickEvent e) {
    try {
      parseZoom();
    } catch (ParseException e1) {
      e1.printStackTrace();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.event.ChangeListener#changed(org.abh.lib.event.ChangeEvent)
   */
  @Override
  public void changed(ChangeEvent e) {
    updateZoom();
  }

  /**
   * Update zoom.
   */
  public void updateZoom() {
    mZoom = mModel.getZoom();

    mZoomCombo.setText(Integer.toString((int) (mZoom * 100)) + "%");
  }

  /**
   * Parses the zoom.
   *
   * @throws ParseException the parse exception
   */
  private void parseZoom() throws ParseException {
    setZoom(TextUtils.parseDouble(mZoomCombo.getText()) / 100.0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#setZoom(double)
   */
  public void setZoom(double zoom) {
    mModel.setZoom(zoom);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#getZoom()
   */
  public double getZoom() {
    return mZoom;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#getMinZoom()
   */
  public double getMinZoom() {
    return mMinZoom;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#setMinZoom(double)
   */
  public void setMinZoom(double zoom) {
    mMinZoom = zoom;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#getMaxZoom()
   */
  public double getMaxZoom() {
    return mMaxZoom;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.zoom.Zoom#setMaxZoom(double)
   */
  public void setMaxZoom(double zoom) {
    mMaxZoom = zoom;
  }
}
