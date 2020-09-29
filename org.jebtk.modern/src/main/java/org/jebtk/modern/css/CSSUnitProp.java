package org.jebtk.modern.css;

public class CSSUnitProp extends CSSNumProp {

  private CSSUnit mUnit = CSSUnit.MM;

  public CSSUnitProp(double v, CSSUnit unit) {
    super(v);

    mUnit = unit;
  }

  public CSSUnit getUnit() {
    return mUnit;
  }

  @Override
  public CSSPropType getType() {
    return CSSPropType.MEASUREMENT;
  }
}
