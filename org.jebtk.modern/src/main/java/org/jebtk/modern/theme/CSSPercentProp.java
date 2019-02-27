package org.jebtk.modern.theme;

import org.jebtk.core.Mathematics;

public class CSSPercentProp extends CSSIntProp {
  public CSSPercentProp(int v) {
    super(Mathematics.bound(v, 0, 100));
  }
  
  @Override
  public String toString() {
    return mV + "%";
  }
}
