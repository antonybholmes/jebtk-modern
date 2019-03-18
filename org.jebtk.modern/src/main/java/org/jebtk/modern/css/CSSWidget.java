package org.jebtk.modern.css;

import java.awt.Graphics2D;
import java.awt.LayoutManager;

import org.jebtk.modern.theme.DrawUI;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a panel with a pill shaped border
 *
 * @author Antony Holmes
 *
 */
public class CSSWidget extends ModernWidget {

  private static final long serialVersionUID = 1L;

  public CSSWidget() {
    init();
  }
  
  public CSSWidget(LayoutManager layout) {
    super(layout);
    
    init();
  }
  
  private void init() {
    //getAnimations().add("draw-ui");
    //getDrawStates().add(DrawUIService.getInstance().getRenderer("css-draw"));
    
    getDrawStates().add(DrawUIService.getInstance().getRenderer("css-draw"));
  }
  
  
  @Override
  public void drawAnimatedBackground(Graphics2D g2) {
    // Run animation updates
    super.drawAnimatedBackground(g2);
    
    // Run any drawing components that may have changed from animations
    for (DrawUI d : getDrawStates()) {
      d.draw(g2, this, getRect());
    }
  }
}
