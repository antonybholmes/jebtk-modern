/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jebtk.modern.animation;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.jebtk.core.Props;
import org.jebtk.core.event.ChangeListeners;
import org.jebtk.modern.ModernWidget;

/**
 * The Class Animations.
 */
public class Animations extends ChangeListeners implements Animation, Iterable<Animation> {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  private class AnimationIterator implements Iterator<Animation>, Iterable<Animation> {
    private ListIterator<Object> mIt;

    public AnimationIterator() {
      mIt = mAnimations.listIterator(mAnimations.size());
    }

    @Override
    public boolean hasNext() {
      return mIt.hasNext();
    }

    @Override
    public Animation next() {
      return (Animation) mIt.next();
    }

    @Override
    public Iterator<Animation> iterator() {
      return this;
    }

    @Override
    public void remove() {
      // TODO Auto-generated method stub

    }
  }

  /** The m animations. */
  private List<Object> mAnimations = new ArrayList<Object>();

  private ModernWidget mWidget = null;
  private boolean mAutoLoad = false;

  public Animations(ModernWidget widget) {
    mWidget = widget;
  }

  public Animations add(Animations animations) {
    update(animations);

    fireChanged();

    return this;
  }

  /**
   * Adds the.
   *
   * @param animation  the animation
   * @param animations the animations
   * @return
   */
  public Animations add(Animation animation, Animation... animations) {
    update(animation, animations);

    fireChanged();

    return this;
  }

  /**
   * Update.
   *
   * @param animation  the animation
   * @param animations the animations
   */
  public void update(Animation animation, Animation... animations) {
    mAnimations.add(animation);

    for (Animation a : animations) {
      mAnimations.add(a);
    }
  }

  public void update(Animations animations) {
    for (Object a : animations.mAnimations) {
      mAnimations.add(a);
    }
  }

  public Animations set(String animation, String... animations) {
    clear();

    add(animation, animations);

    return this;
  }

  public Animations update(String animation, String... animations) {
    /*
     * List<Animation> al = AnimationService.getInstance().create(animation,
     * mWidget);
     * 
     * for (Animation an : al) { mAnimations.add(an); }
     * 
     * for (String a : animations) { al = AnimationService.getInstance().create(a,
     * mWidget);
     * 
     * for (Animation an : al) { mAnimations.add(an); } }
     */

    mAnimations.add(animation);

    for (String a : animations) {
      mAnimations.add(a);
    }

    mAutoLoad = true;

    return this;
  }

  public Animations add(String animation, String... animations) {
    update(animation, animations);

    fireChanged();

    return this;
  }

  /**
   * Sets the animations to use. TODO: should initialize named animations in a
   * lazy fasion
   *
   * @param animation  the animation
   * @param animations the animations
   * @return
   */
  public Animations set(Animation animation, Animation... animations) {
    clear();

    add(animation, animations);

    return this;
  }

  public Animations set(Animations animations) {
    clear();

    add(animations);

    return this;
  }

  /**
   * Clear.
   * 
   * @return
   */
  public Animations clear() {
    mAnimations.clear();

    return this;
  }

  private void autoLoad() {
    if (mAutoLoad) {
      // If there are string names in the list, we lazy load the corresponding
      // animations as requested.
      List<Object> newAnimations = new ArrayList<Object>(mAnimations.size());

      for (int i = 0; i < mAnimations.size(); ++i) {
        Object o = mAnimations.get(i);

        if (o instanceof String) {
          List<Animation> animations = AnimationService.getInstance().create((String) o, mWidget);

          for (Animation animation : animations) {
            newAnimations.add(animation);
          }
        } else {
          newAnimations.add(o);
        }
      }

      // Destroy the original to save memory and garbage collect
      mAnimations.clear();
      // Swap references
      mAnimations = newAnimations;
      mAutoLoad = false;
    }
  }

  public void draw(ModernWidget c, Graphics2D g2) {
    draw(c, g2, null);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    autoLoad();

    for (Object a : mAnimations) {
      ((Animation) a).draw(c, g2, props);
    }
  }

  /**
   * Get a particular animation by index.
   * 
   * @param index
   * @return
   */
  public Animation get(int index) {
    autoLoad();

    return (Animation) mAnimations.get(index);
  }

  @Override
  public Iterator<Animation> iterator() {
    autoLoad();

    return new AnimationIterator();
  }

  @Override
  public String getName() {
    return "animations";
  }
}
