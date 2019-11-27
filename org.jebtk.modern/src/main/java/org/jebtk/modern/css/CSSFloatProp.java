package org.jebtk.modern.css;

public class CSSFloatProp implements CSSNumProp {

  protected final double mV;

  public CSSFloatProp(double v) {
    mV = v;
  }

  @Override
  public Object getValue() {
    return mV;
  }

  @Override
  public int getInt() {
    return (int) mV;
  }

  @Override
  public double getFloat() {
    return mV;
  }

}
