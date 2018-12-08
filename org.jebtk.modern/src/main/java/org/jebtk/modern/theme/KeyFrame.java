package org.jebtk.modern.theme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jebtk.core.collections.ReverseIterator;

public class KeyFrame extends AbstractStyleProperties {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private List<StyleClass> mStyles = new ArrayList<StyleClass>();
  private Map<String, Integer> mIndexMap = new HashMap<String, Integer>();

  /**
   * Inherit properties from a parent style.
   * 
   * @param parent
   * @return
   */
  public KeyFrame addStyleClass(StyleClass style) {
    mIndexMap.put(style.getName(), mStyles.size());
    mStyles.add(style);
    style.addChangeListener(this);

    clear(style);

    return this;
  }

  /**
   * Remove existing custom settings and replace with inherited style.
   * 
   * @param style
   */
  private void clear(StyleClass style) {
    for (Entry<String, Object> f : style) {
      mPropertyMap.remove(f.getKey());
    }
  }

  public KeyFrame removeStyleClass(String name) {
    if (mIndexMap.containsKey(name)) {
      mStyles.remove((int) mIndexMap.get(name));
      mIndexMap.remove(name);

      fireChanged();
    }

    return this;
  }

  @Override
  public boolean contains(String name) {
    if (super.contains(name)) {
      return true;
    }

    ReverseIterator<StyleClass> iter = new ReverseIterator<StyleClass>(mStyles);

    while (iter.hasNext()) {
      StyleClass s = iter.next();

      if (s.contains(name)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Returns the most uptodate property value. If a custom property was added,
   * return that, else work backwards through the style list until a style
   * containing the property of interest is found. Styles are added in order so
   * the last style added is considered the latest.
   * 
   * @param name
   * @return
   */
  @Override
  public Object getValue(String name) {
    // First check if we created a custom property return that

    if (super.contains(name)) {
      return super.getValue(name);
    }

    // Look backwards to find the most recent style class with the property
    // of interest.
    ReverseIterator<StyleClass> iter = new ReverseIterator<StyleClass>(mStyles);

    while (iter.hasNext()) {
      StyleClass s = iter.next();

      if (s.contains(name)) {
        return s.getValue(name);
      }
    }

    return null;
  }
}
