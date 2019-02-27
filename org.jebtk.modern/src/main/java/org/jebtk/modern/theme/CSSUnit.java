package org.jebtk.modern.theme;

public enum CSSUnit {
  CM,
  MM,
  IN,
  PX;
  
  public static CSSUnit parse(String unit) {
    unit = unit.toLowerCase();
    
    if (unit.contains("cm")) {
      return CM;
    } else if (unit.contains("in")) {
      return IN;
    } else if (unit.contains("mm")) {
      return MM;
    } else {
      return PX;
    }
  }
}
