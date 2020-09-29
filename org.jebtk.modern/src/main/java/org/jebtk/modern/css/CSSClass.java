package org.jebtk.modern.css;

import org.jebtk.core.NameGetter;

public class CSSClass extends CSSProps implements NameGetter {

  private static final long serialVersionUID = 1L;

  private String mName;

  public CSSClass(String name) {
    mName = name;
  }

  @Override
  public String getName() {
    return mName;
  }

  @Override
  public String toString() {
    return getName();
  }

}
