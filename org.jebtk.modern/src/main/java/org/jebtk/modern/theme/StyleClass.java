package org.jebtk.modern.theme;

import org.jebtk.core.NameProperty;

public class StyleClass extends AbstractStyleProperties implements NameProperty {
  
  private static final long serialVersionUID = 1L;
  
  private String mName;

  public StyleClass(String name) {
    mName = name;
  }

  @Override
  public String getName() {
    return mName;
  }
}
