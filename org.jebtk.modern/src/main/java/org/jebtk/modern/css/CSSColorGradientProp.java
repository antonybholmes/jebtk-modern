package org.jebtk.modern.css;

import org.jebtk.modern.theme.ColorGradient;

public class CSSColorGradientProp extends CSSProp {

  protected final ColorGradient mV;

  public CSSColorGradientProp(ColorGradient v) {
    mV = v;
  }

  @Override
  public ColorGradient getGradient() {
    return mV;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.COLOR_GRADIENT;
  }

}
