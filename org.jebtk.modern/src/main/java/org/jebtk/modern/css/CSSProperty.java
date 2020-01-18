package org.jebtk.modern.css;

import java.awt.Color;

public class CSSProperty {
  public final int mInt;
  public final double mFloat;
  public final String mString;
  public final Color mColor;
  public final CSSUnit mUnit;
  
  public CSSProperty(int v) {
    this(v, CSSUnit.PX);
  }
  
  public CSSProperty(int v, CSSUnit unit) {
    mFloat = v;
    mInt = v;
    mString = null;
    mColor = null;
    mUnit = unit;
  }
  
  public CSSProperty(double v) {
    this(v, CSSUnit.PX);
  }
  
  public CSSProperty(double v, CSSUnit unit) {
    mFloat = v;
    mInt = (int)v;
    mString = null;
    mColor = null;
    mUnit = unit;
  }
  
  public CSSProperty(String v) {
    mFloat = Double.MIN_VALUE;
    mInt = Integer.MIN_VALUE;
    mString = v;
    mColor = null;
    mUnit = CSSUnit.NONE;
  }
}
