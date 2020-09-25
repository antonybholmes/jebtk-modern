package org.jebtk.modern.css;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.Map.Entry;

import org.jebtk.core.collections.IterHashMap;
import org.jebtk.core.collections.IterMap;
import org.jebtk.core.event.ChangeListeners;
import org.jebtk.modern.theme.ColorGradient;

public class CSSProps extends ChangeListeners implements Iterable<Entry<String, CSSProp>> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  protected IterMap<String, CSSProp> mPropertyMap = new IterHashMap<String, CSSProp>();

  public int getInt(String name) {
    CSSProp p = getProp(name);
    
    if (p != null) {
      return p.getInt();
    } else {
      return Integer.MIN_VALUE;
    }
  }
  
  public double getFloat(String name) {
    CSSProp p = getProp(name);
    
    if (p != null) {
      return p.getFloat();
    } else {
      return Double.MIN_VALUE;
    }
  }
  
  public Color getColor(String name) {
    return getColor(name, Color.BLACK);
  }
  
  public Color getColor(String name, Color c) {
    return getColor(name, CSSColor.create(c));
  }
  
  public Color getColor(String name, CSSColor c) {
    CSSProp p = getProp(name);
    
    if (p != null && p.getType() == CSSPropType.COLOR) {
      return p.getColor();
    } else {
      return null;
    }
  }
  
  public Font getFont(String name) {
    CSSProp p = getProp(name);
    
    if (p != null && p.getType() == CSSPropType.FONT) {
      return p.getFont();
    } else {
      return null;
    }
  }

  //public Border getBorder(String name) {
  //  return (Border) get(name);
  //}

  public ColorGradient getColorGradient(String name) {
    CSSProp p = getProp(name);
    
    if (p != null && p.getType() == CSSPropType.COLOR_GRADIENT) {
      return p.getGradient();
    } else {
      return null;
    }
  }
  
  public CSSProps set(String name, int p) {
    return set(name, new CSSNumProp(p));
  }
  
  public CSSProps set(String name, double p) {
    return set(name, new CSSNumProp(p));
  }
  
  public CSSProps set(String name, Color p) {
    return set(name, CSSColor.create(p));
  }
  
  public CSSProps set(String name, CSSColor p) {
    return set(name, new CSSColorProp(p));
  }
  
  public CSSProps set(String name, CSSProp p) {
    update(name, p);
    
    return this;
  }
  
  public CSSProps update(String name, int p) {
    return update(name, new CSSNumProp(p));
  }
  
  public CSSProps update(String name, double p) {
    return update(name, new CSSNumProp(p));
  }
  
  public CSSProps update(String name, Color p) {
    return update(name, CSSColor.create(p));
  }
  
  public CSSProps update(String name, CSSColor p) {
    return update(name, new CSSColorProp(p));
  }
  
  public CSSProps update(String name, CSSProp p) {
    mPropertyMap.put(name, p);

    return this;
  }
  
  public CSSProp getProp(String name) {
    return mPropertyMap.get(name);
  }
  
  public CSSProps set(CSSProps props) {
    update(props);
    
    return this;
  }
  
  public CSSProps update(CSSProps props) {
    for (Entry<String, CSSProp> item : props) {
      mPropertyMap.put(item.getKey(), item.getValue());
    }

    return this;
  }
  
  public boolean contains(String name) {
    return mPropertyMap.containsKey(name);
  }

  @Override
  public Iterator<Entry<String, CSSProp>> iterator() {
    return mPropertyMap.iterator();
  }
}
