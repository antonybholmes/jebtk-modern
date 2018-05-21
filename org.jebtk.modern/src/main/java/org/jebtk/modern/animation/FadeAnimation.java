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

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Map;

import org.jebtk.core.ColorUtils;
import org.jebtk.core.collections.DefaultHashMap;
import org.jebtk.core.collections.HashMapCreator;
import org.jebtk.core.collections.IterMap;
import org.jebtk.modern.graphics.colormap.ColorMap;
import org.jebtk.modern.graphics.colormap.ColorMapColor;
import org.jebtk.modern.widget.ModernWidget;

/**
 * Allows for fade in/out animation on an element.
 *
 * @author Antony Holmes
 */
public class FadeAnimation extends EasingAnimation {

  /** The Constant MD. */
  protected static final double MD = 1.0 / STEPS;

  /** The m fade color map. */
  private Map<Integer, IterMap<String, Color>> mFadeColorMap = DefaultHashMap
      .create(new HashMapCreator<String, Color>());

  /** Map step to transparency level */
  //private Map<Integer, Double> mStepMap = new HashMap<Integer, Double>();

  /**
   * Instantiates a new hover fade animation.
   *
   * @param widget the widget
   */
  public FadeAnimation(ModernWidget widget) {
    super(widget);

    // double t = 0;
    
    setStep(MAX_STEP_INDEX);

    //mStepMap.put(0, 0.0);
    //mStepMap.put(MAX_STEP_INDEX, 1.0);

    //for (int i = 1; i < MAX_STEP_INDEX; ++i) {
    //  mStepMap.put(i, BEZ_T[i]);
    //}
  }
  
  public void restart() {
    reset();
    start();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.TimerAnimation#animate()
   */
  @Override
  public void animate() {
    getWidget().repaint();

    if (getCurrentStep() == 0) {
      stop();
    } else {
      fadeIn();
    }
  }

  /**
   * Set a fade in color that can transition linearly between transparent and
   * opaque.
   *
   * @param name the name
   * @param color the color
   */
  public void setFadeColor(String name, Color color) {
    double t = ColorUtils.getTrans(color);

    double d = (1.0 - t); // / STEPS;

    for (int i = 0; i < STEPS; ++i) {
      Color c = ColorUtils.getTransparentColor(color,
          t + d * BEZ_T[i]);

      mFadeColorMap.get(i).put(name, c);

      // t += d;
    }
  }

  public void setFadeColor(String name, Color color1, Color color2) {
    // We need to reverse the color map because we are using the
    // transparent fade logic. This means that the default is to start
    // in the transparent state (the last step) and work backwards to
    // opaque once the animation begins. Therefore with a a color map,
    // the last color needs to be the starting color.
    List<ColorMapColor> colorMap = ColorMap
        .createTwoColorMap(color1, color2, STEPS, true);

    for (int i = 0; i < STEPS; ++i) {
      mFadeColorMap.get(i).put(name, colorMap.get(i));
    }
  }

  public Color getFadeColor(String name) {
    return getFadeColorMap().get(name);
  }

  /**
   * Gets the fade color map.
   *
   * @return the fade color map
   */
  public Map<String, Color> getFadeColorMap() {
    return getFadeColorMap(mStep);
  }

  /**
   * Gets the fade color map.
   *
   * @param step the step
   * @return the fade color map
   */
  public Map<String, Color> getFadeColorMap(int step) {
    return mFadeColorMap.get(step);
  }
  
  public Map<String, Color> getToFadeColorMap() {
    return getFadeColorMap(MAX_STEP_INDEX);
  }
  
  public Map<String, Color> getFromFadeColorMap() {
    return getFadeColorMap(0);
  }
  
  /**
   * Get the end color.
   * 
   * @param name    The color gradient name.
   * @return
   */
  public Color getToColor(String name) {
    return getToFadeColorMap().get(name);
  }
  
  public Color getFromColor(String name) {
    return getFromFadeColorMap().get(name);
  }

  /**
   * Cause the color to fade in (get more opaque/darker) by one step.
   */
  public void fadeIn() {
    // mTrans = Mathematics.bound(mTrans - MD, 0, 1);
    // mCurrentStep = Mathematics.bound(mCurrentStep - 1, 0, STEPS);

    setStep(mStep - 1);
  }

  public void fadeOut() {
    // mTrans = Mathematics.bound(mTrans + MD, 0, 1);
    // mCurrentStep = Mathematics.bound(mCurrentStep + 1, 0, STEPS);

    setStep(mStep + 1);
  }

  /**
   * Gets the trans.
   *
   * @return the trans
   */
  //ublic double getTrans() {
  //  return mStepMap.get(mStep);
  //}

  @Override
  public void draw(ModernWidget widget, Graphics2D g2, Object... params) {
    // TODO Auto-generated method stub

  }

  @Override
  public void reset() {
    mStep = MAX_STEP_INDEX;
  }

  public void opaque() {
    mStep = 0;
  }
}
