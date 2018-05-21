package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.Font;
import java.util.Comparator;
import java.util.Map.Entry;

import javax.swing.border.Border;

import org.jebtk.core.Properties;
import org.jebtk.core.collections.DefaultTreeMap;
import org.jebtk.core.collections.EntryCreator;
import org.jebtk.core.collections.IterMap;
import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.event.ChangeListeners;

public class KeyFrames extends ChangeListeners implements StyleProperties, ChangeListener {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final int FROM = 0;
  public static final int TO = 100;

  /**
   * Keep track of keyframes. Use a reverse order comparator since later
   * keyframes override earlier ones if no preference is given.
   */
  private IterMap<Integer, KeyFrame> mFrameMap = new DefaultTreeMap<Integer, KeyFrame>(
      new Comparator<Integer>() {
        @Override public int compare(Integer i1, Integer i2) {
          return i2.compareTo(i1);
        }           
      },
      new EntryCreator<KeyFrame>() {
        @Override
        public KeyFrame newEntry() {
          return new KeyFrame();
        }
      });

  /*
  private String mName;

  public KeyFrames(String name) {
    mName = name;
  }
   */

  /**
   * Return a keyframe. If the frame does not exist, it is automatically
   * created.
   * 
   * @param frame
   * @return
   */
  public KeyFrame getKeyFrame(int frame) {
    if (!mFrameMap.containsKey(frame)) {
      KeyFrame styles = new KeyFrame();

      styles.addChangeListener(this);

      mFrameMap.put(frame, styles);
    }

    return mFrameMap.get(frame);
  }

  public KeyFrame getKeyFrame() {
    return getKeyFrame(FROM);
  }

  /**
   * Return the last keyframe in an animation. Equivalent to calling
   * <code>getKeyFrame(100)</code>
   * 
   * @return
   */
  public KeyFrame getToKeyFrame() {
    return getKeyFrame(TO);
  }

  @Override
  public int getInt(String name) {
    return getKeyFrame().getInt(name);
  }

  @Override
  public double getDouble(String name) {
    return getKeyFrame().getDouble(name);
  }

  @Override
  public Color getColor(String name) {
    return getKeyFrame().getColor(name);
  }

  @Override
  public Border getBorder(String name) {
    return getKeyFrame().getBorder(name);
  }

  @Override
  public Font getFont(String name) {
    return getKeyFrame().getFont(name);
  }

  @Override
  public String toString(String name) {
    return getKeyFrame().toString(name);
  }

  @Override
  public Properties set(String name, Object value) {
    return getKeyFrame().set(name, value);
  }

  @Override
  public Object getValue(String name) {
    for (Entry<Integer, KeyFrame> entry : mFrameMap.entrySet()) {
      if (entry.getValue().contains(name)) {
        return entry.getValue().getValue(name);
      }
    }
    
    return null;
  }

  @Override
  public boolean contains(String name) {
    for (Entry<Integer, KeyFrame> entry : mFrameMap.entrySet()) {
      if (entry.getValue().contains(name)) {
        return true;
      }
    }
    
    return false;
  }

  @Override
  public void changed(ChangeEvent e) {
    fireChanged();
  }
}
