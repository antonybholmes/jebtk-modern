package org.jebtk.modern.css;

import java.awt.Graphics2D;
import java.awt.LayoutManager;

import org.jebtk.modern.theme.DrawUI;
import org.jebtk.modern.tooltip.ModernToolTipWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a panel with a pill shaped border
 *
 * @author Antony Holmes
 *
 */
public abstract class CSSWidget extends ModernToolTipWidget {

  private static final long serialVersionUID = 1L;
  
  public static final DrawUI CSS_DRAW = new CSSDrawUI();
  
  private boolean mCSSMode = true;

  public CSSWidget() {
    init();
  }

  public CSSWidget(LayoutManager layout) {
    super(layout);

    init();
  }

  private void init() {
    // getAnimations().add("draw-ui");
    //getDrawStates().add(DrawUIService.getInstance().getRenderer("css-draw"));
  }

  @Override
  public void drawAnimatedBackground(Graphics2D g2) {
    // Run animation updates
    super.drawAnimatedBackground(g2);
    
    if (mCSSMode) {
      CSS_DRAW.draw(this, g2);
    }
    
    // Run any drawing components that may have changed from animations
    for (DrawUI d : getDrawStates()) {
      d.draw(this, g2);
    }
  }
  
  /**
   * Set whether to use the CSS renderer. For certain custom components it is
   * necessary to disable this so that the CSS style does not conflict with
   * the custom style.
   * 
   * @param cssMode
   */
  public void setCSSMode(boolean cssMode) {
    mCSSMode = cssMode;
    repaint();
  }
}
