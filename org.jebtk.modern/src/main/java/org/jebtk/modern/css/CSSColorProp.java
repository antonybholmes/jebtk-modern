package org.jebtk.modern.css;

public class CSSColorProp extends CSSProp {

  protected final CSSColor mV;

  public CSSColorProp(CSSColor v) {
    mV = v;
  }

  @Override
  public CSSColor getColor() {
    return mV;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.COLOR;
  }

}
