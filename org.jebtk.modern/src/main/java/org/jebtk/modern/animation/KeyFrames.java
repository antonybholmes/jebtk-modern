package org.jebtk.modern.animation;

import org.jebtk.core.collections.IterMap;
import org.jebtk.core.collections.IterTreeMap;
import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.event.ChangeListeners;

public class KeyFrames extends ChangeListeners
    implements ChangeListener {
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
  private IterMap<Integer, KeyFrame> mFrameMap = new IterTreeMap<Integer, KeyFrame>();

  /*
   * private String mName;
   * 
   * public KeyFrames(String name) { mName = name; }
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
      KeyFrame styles = new KeyFrame(frame);

      styles.addChangeListener(this);

      mFrameMap.put(frame, styles);
    }

    return mFrameMap.get(frame);
  }

  public KeyFrame getKeyFrame() {
    return getFromFrame();
  }
  
  public KeyFrame getFromFrame() {
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
  public void changed(ChangeEvent e) {
    fireChanged();
  }
}
