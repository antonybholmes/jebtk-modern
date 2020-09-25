package org.jebtk.modern.css;

import java.awt.Font;

public class CSSFontProp extends CSSProp {

  protected final Font mV;

  public CSSFontProp(Font v) {
    mV = v;
  }

  @Override
  public Font getFont() {
    return mV;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.FONT;
  }

}
