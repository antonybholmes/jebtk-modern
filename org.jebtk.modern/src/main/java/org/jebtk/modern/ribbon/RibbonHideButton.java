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
package org.jebtk.modern.ribbon;

import org.jebtk.modern.UI;
import org.jebtk.modern.UIService;
import org.jebtk.modern.graphics.icons.CheveronUpVectorIcon;

// TODO: Auto-generated Javadoc
/**
 * Button to allow users to hide the ribbon.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class RibbonHideButton extends RibbonButton {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new ribbon hide button.
   */
  public RibbonHideButton() {
    super(UIService.getInstance().loadIcon(CheveronUpVectorIcon.class, 12));

    setBackgroundAnimation(new RibbonButtonHighlightAnimation(this, "circle"));

    UI.setSize(this, 24);
  }

}
