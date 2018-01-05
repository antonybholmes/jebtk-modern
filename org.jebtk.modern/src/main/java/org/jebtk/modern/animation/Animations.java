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

import org.jebtk.core.event.ChangeListeners;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * The Class Animations.
 */
public class Animations extends ChangeListeners implements Animation, Iterable<Animation> {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The m animations. */
  private List<Animation> mAnimations = new ArrayList<Animation>();

  /**
   * Adds the.
   *
   * @param animation
   *          the animation
   * @return
   */
  public Animations add(Animation animation) {
    update(animation);

    fireChanged();

    return this;
  }

  public Animations add(Animations animations) {
    update(animations);

    fireChanged();

    return this;
  }

  /**
   * Update.
   *
   * @param animation
   *          the animation
   */
  public void update(Animation animation) {
    mAnimations.add(animation);
  }

  /**
   * Adds the.
   *
   * @param animation
   *          the animation
   * @param animations
   *          the animations
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
   * @param animation
   *          the animation
   * @param animations
   *          the animations
   */
  public void update(Animation animation, Animation... animations) {
    update(animation);

    for (Animation a : animations) {
      update(a);
    }
  }

  public void update(Animations animations) {
    for (Animation a : animations) {
      update(a);
    }
  }

  /**
   * Sets the.
   *
   * @param animation
   *          the animation
   * @param animations
   *          the animations
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

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    for (Animation a : mAnimations) {
      a.draw(widget, g2, params);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<Animation> iterator() {
    return mAnimations.iterator();
  }

  /**
   * Get a particular animation by index.
   * 
   * @param index
   * @return
   */
  public Animation get(int index) {
    return mAnimations.get(index);
  }

}
