package org.jebtk.modern.css;

public class CSSNumProp extends CSSProp {

  protected final double mV;

  public CSSNumProp(double v) {
    mV = v;
  }

  @Override
  public int getInt() {
    return (int) mV;
  }

  @Override
  public double getFloat() {
    return mV;
  }

  @Override
  public String toString() {
    return Double.toString(mV);
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.NUM;
  }
}
