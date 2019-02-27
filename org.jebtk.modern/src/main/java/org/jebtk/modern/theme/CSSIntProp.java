package org.jebtk.modern.theme;

public class CSSIntProp implements CSSNumProp {
  
  protected final int mV;

  public CSSIntProp(int v) {
    mV = v;
  }
  
  @Override
  public Object getValue() {
    return mV;
  }

  @Override
  public int getInt() {
    return mV;
  }

  @Override
  public double getDouble() {
    return mV;
  }

}
