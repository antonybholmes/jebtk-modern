package org.jebtk.modern.css;

public enum CSSUnit {
  NONE, CM, MM, IN, PX, EM, REM, PC;

  public static CSSUnit parse(String unit) {
    switch (unit.toLowerCase()) {
    case "cm":
      return CM;
    case "in":
      return IN;
    case "mm":
      return MM;
    case "px":
      return PX;
    case "pc":
      return PC;
    default:
      return NONE;
    }
  }
}
