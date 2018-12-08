package org.jebtk.modern.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import org.jebtk.modern.UI;
import org.jebtk.modern.animation.PillBorderAnimation;
import org.jebtk.modern.theme.DrawUIService;
import org.jebtk.modern.widget.ModernWidget;

// TODO: Auto-generated Javadoc
/**
 * Create a panel with a pill shaped border
 *
 * @author Antony Holmes Holmes
 *
 */
public class ModernPillBorderPanel extends ModernWidget {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern line border panel.
   */
  public ModernPillBorderPanel() {
    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param color the color
   */
  public ModernPillBorderPanel(Color color) {
    setBackground(color);

    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param layout the layout
   */
  public ModernPillBorderPanel(LayoutManager layout) {
    super(layout);

    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param component the component
   */
  public ModernPillBorderPanel(Component component) {
    add(component, BorderLayout.CENTER);

    init();
  }

  /**
   * Instantiates a new modern line border panel.
   *
   * @param component the component
   * @param dimension the dimension
   */
  public ModernPillBorderPanel(Component component, Dimension dimension) {
    this(component);

    UI.setSize(this, dimension);

    init();
  }

  /**
   * Inits the.
   */
  private void init() {
    setBorder(ModernWidget.TWO_PIXEL_BORDER); // BorderService.getInstance().createBorder(2));

    addStyleClass("content", "content-outline");
    // addStyleClass("content-outline");

    setAnimations(new PillBorderAnimation(this));
  }

  @Override
  public void drawAnimatedBackground(Graphics2D g2) {
    DrawUIService.getInstance().getRenderer("pill-outline").draw(g2, mRect);

    super.drawAnimatedBackground(g2);
  }
}
