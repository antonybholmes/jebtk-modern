package org.jebtk.modern.css;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jebtk.core.IdProperty;
import org.jebtk.core.Properties;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.UniqueArrayListCreator;

public class CSSKeyFrame extends CSSClass implements IdProperty {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  // private List<StyleClass> mStyles = new ArrayList<StyleClass>();
  // private Map<String, Integer> mIndexMap = new HashMap<String, Integer>();

  private Map<String, List<Properties>> mClassHierarchyMap = DefaultHashMap
      .create(new UniqueArrayListCreator<Properties>());

  private int mId;

  public CSSKeyFrame(int id) {
    super(Integer.toString(id));

    mId = id;
  }

  /**
   * Inherit properties from a parent style.
   * 
   * @param parent
   * @return
   */
  @Override
  public CSSKeyFrame update(Properties style) {
    super.update(style);

    for (Entry<String, Object> item : style) {
      // Map styles to properties in order they are applied
      mClassHierarchyMap.get(item.getKey()).add(style);
    }

    return this;
  }

  /**
   * Return the classes associated with a property to understand the hierarchy.
   * 
   * @param name Name of property, e.g "background-color".
   * @return
   */
  public Iterable<Properties> getStyles(String name) {
    return mClassHierarchyMap.get(name);
  }

  /*
   * private void clear(StyleClass style) { for (Entry<String, Object> f :
   * style) { mPropertyMap.remove(f.getKey()); } }
   */

  /*
   * public KeyFrame removeStyleClass(String name) { if
   * (mIndexMap.containsKey(name)) { mStyles.remove((int) mIndexMap.get(name));
   * mIndexMap.remove(name);
   * 
   * fireChanged(); }
   * 
   * return this; }
   */

  /*
   * @Override public boolean contains(String name) { if (super.contains(name))
   * { return true; }
   * 
   * ReverseIterator<StyleClass> iter = new
   * ReverseIterator<StyleClass>(mStyles);
   * 
   * while (iter.hasNext()) { StyleClass s = iter.next();
   * 
   * if (s.contains(name)) { return true; } }
   * 
   * return false; }
   */

  /*
   * @Override public Object getValue(String name) { // First check if we
   * created a custom property return that
   * 
   * if (super.contains(name)) { return super.getValue(name); }
   * 
   * // Look backwards to find the most recent style class with the property //
   * of interest. ReverseIterator<StyleClass> iter = new
   * ReverseIterator<StyleClass>(mStyles);
   * 
   * while (iter.hasNext()) { StyleClass s = iter.next();
   * 
   * if (s.contains(name)) { System.err.println("Found " + name + " in " +
   * s.getName() + " in keyframe " + getId()); return s.getValue(name); } }
   * 
   * return null; }
   */

  @Override
  public int getId() {
    return mId;
  }
}
