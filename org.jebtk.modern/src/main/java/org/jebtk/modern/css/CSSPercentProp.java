package org.jebtk.modern.css;

import org.jebtk.core.Mathematics;

public class CSSPercentProp extends CSSNumProp {
  public CSSPercentProp(int v) {
    super(Mathematics.bound(v, 0, 100));
  }

  @Override
  public String toString() {
    return mV + "%";
  }

  @Override
  public CSSUnit getUnit() {
    return CSSUnit.PERCENT;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.PERCENT;
  }
}
