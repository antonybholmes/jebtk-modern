package org.jebtk.modern.graphics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jebtk.core.event.ChangeListeners;

public class AAModes extends ChangeListeners implements Iterable<AAMode> {
  
  private static final long serialVersionUID = 1L;
  
  private Set<AAMode> mTypes = new HashSet<AAMode>();
  
  @Override
  public Iterator<AAMode> iterator() {
    return mTypes.iterator();
  }
  
  public void clear() {
    mTypes.clear();
  }

  public AAModes add(AAMode type) {
    mTypes.add(type);
    
    fireChanged();
    
    return this;
  }

  public int size() {
    return mTypes.size();
  }
}
