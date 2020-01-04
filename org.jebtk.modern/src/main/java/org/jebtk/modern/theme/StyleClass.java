package org.jebtk.modern.theme;

import org.jebtk.core.NameGetter;
import org.jebtk.modern.css.CSSProps;

public class StyleClass extends CSSProps
    implements NameGetter {

  private static final long serialVersionUID = 1L;

  private String mName;

  public StyleClass(String name) {
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
