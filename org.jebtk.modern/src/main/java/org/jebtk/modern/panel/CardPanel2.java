package org.jebtk.modern.panel;

import java.awt.Component;

import org.jebtk.modern.ModernComponent;

public class CardPanel2 extends CardPanel {

  private static final long serialVersionUID = 1L;

  public CardPanel2(Component content) {
    super(new ModernComponent(content, QUAD_BORDER));
  }

}
