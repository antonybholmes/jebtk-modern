package org.jebtk.modern.css;

public class CSSMeasurementProp extends CSSFloatProp {
  
  
  private CSSUnit mUnit = CSSUnit.MM;
  
  public CSSMeasurementProp(double v, CSSUnit unit) {
    super(v);
    
    mUnit = unit;
  }
  
  public CSSUnit getUnit() {
    return mUnit;
  }
}
