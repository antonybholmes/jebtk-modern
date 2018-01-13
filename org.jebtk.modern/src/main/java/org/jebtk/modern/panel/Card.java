package org.jebtk.modern.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.border.Border;

import org.jebtk.core.ColorUtils;
import org.jebtk.modern.BorderService;
import org.jebtk.modern.ModernComponent;
import org.jebtk.modern.graphics.GaussianFilter;
import org.jebtk.modern.graphics.ImageUtils;

public class Card extends ModernComponent {

  private static final long serialVersionUID = 1L;

  public static final int ROUNDING = 6;
  
  private static final int V_SPACE = ROUNDING * 2;

  public static final int SHADOW_SIZE = 8;
  
  public static final int HALF_SHADOW_SIZE = SHADOW_SIZE / 2;

  public static final double ALPHA = 0.85;

  private static final Insets OFFSETS = 
      new Insets(HALF_SHADOW_SIZE, HALF_SHADOW_SIZE, HALF_SHADOW_SIZE, HALF_SHADOW_SIZE);
  
  /**
   * Allow for space at the top so that items appear just below the rounded
   * corners rather than running into them.
   */
  private static final Border CARD_BORDER = 
      BorderService.getInstance().createBorder(HALF_SHADOW_SIZE + ROUNDING, HALF_SHADOW_SIZE, HALF_SHADOW_SIZE + ROUNDING, HALF_SHADOW_SIZE);

  public static final Color COLOR = 
      ColorUtils.getTransparentColor(Color.BLACK, Card.ALPHA);

  private BufferedImage mShadow;

  private class ComponentEvents extends ComponentAdapter {
    @Override
    public void componentResized(ComponentEvent e) {
      mShadow = null;
      //mBackground = null;
    } 
  }

  public Card() {
    addComponentListener(new ComponentEvents());
    
    setBorder(CARD_BORDER);
  }

  public Card(Component c) {
    this();

    setBody(c);
  }
  
  @Override
  public void setBody(Component c) {
    super.setBody(c);
    
    Dimension s = c.getPreferredSize();
    
    setPreferredSize(new Dimension(s.width + SHADOW_SIZE, s.height + SHADOW_SIZE + V_SPACE));
  }
  
  @Override
  public void drawBackground(Graphics2D g2) {
    int width = getWidth() - 1;
    int height = getHeight() - 1;

    if (mShadow == null) {
      // Cache shadow as expensive operation to create
      mShadow = shadow(width, height);

      // Add the shadow
      background(mShadow);
    }

    g2.drawImage(mShadow, 0, 0, this);
    //g2.drawImage(mBackground, 0, 0, this);
  }

  /*
  public static GraphicsConfiguration getGraphicsConfiguration() {
    return GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getDefaultScreenDevice().getDefaultConfiguration();

  }
   */

  public static BufferedImage createCompatibleImage(int width, int height) {
    return createCompatibleImage(width, height, Transparency.TRANSLUCENT);
  }

  public static BufferedImage createCompatibleImage(int width,
      int height,
      int transparency) {

    return ImageUtils.createImage(width, height);

    /*
    BufferedImage image = GraphicsEnvironment
        .getLocalGraphicsEnvironment()
        .getDefaultScreenDevice()
        .getDefaultConfiguration()
        .createCompatibleImage(width, height, transparency);
    image.coerceData(true);
    return image;
     */

  }

  public static void background(BufferedImage img) {
    int width = img.getWidth();
    int height = img.getHeight();

    Rectangle bounds = new Rectangle();
    bounds.x = OFFSETS.left;
    bounds.y = OFFSETS.top;
    bounds.width = width - (OFFSETS.left + OFFSETS.right);
    bounds.height = height - (OFFSETS.top + OFFSETS.bottom);

    RoundRectangle2D shape = new RoundRectangle2D.Double(bounds.x, 
        bounds.y,
        bounds.width, 
        bounds.height, 
        ROUNDING, 
        ROUNDING);

    Graphics2D g2 = img.createGraphics();

    try {
      ImageUtils.setQualityHints(g2);
      
      //g2.setColor(Color.RED);
      //g2.draw(shape);
      g2.setColor(Color.WHITE);
      g2.fill(shape);
    } finally {
      g2.dispose();
    }
  }

  public static BufferedImage shadow(int width, int height) {
    BufferedImage img = createCompatibleImage(width, height);
    
    width -= OFFSETS.right + HALF_SHADOW_SIZE;
    height -= OFFSETS.bottom + HALF_SHADOW_SIZE;

    RoundRectangle2D shape = new RoundRectangle2D.Double(HALF_SHADOW_SIZE, 
        HALF_SHADOW_SIZE,
        width, 
        height, 
        ROUNDING, 
        ROUNDING);

    Graphics2D g2 = img.createGraphics();

    try {
      ImageUtils.setQualityHints(g2);
      g2.setColor(COLOR);
      //tg2.translate(-bounds.x, -bounds.y);
      g2.fill(shape);
    } finally {
      g2.dispose();
    }

    /*
    //int border = size * 2;

    int imgWidth = imgSource.getWidth(); // + border;
    int imgHeight = imgSource.getHeight(); // + border;

    BufferedImage imgMask = createCompatibleImage(imgWidth, imgHeight);
    Graphics2D g2 = imgMask.createGraphics();

    try {
      ImageUtils.setQualityHints(g2);

      g2.drawImage(imgSource, 0, 0, null);
    } finally {
      g2.dispose();
    }
     */

    return blur(img, SHADOW_SIZE); //imgMask; //blur(imgMask, size);
  }

  /**
   * Apply Gaussian blur to image to simulate diffuse shadow border.
   * 
   * @param img
   * @param size
   * @return
   */
  public static BufferedImage blur(BufferedImage img, int size) {
    /*
    GaussianFilter filter = new GaussianFilter(size);

    int imgWidth = imgSource.getWidth();
    int imgHeight = imgSource.getHeight();

    BufferedImage imgBlur = createCompatibleImage(imgWidth, imgHeight);
    Graphics2D g2d = imgBlur.createGraphics();

    try {
      ImageUtils.setQualityHints(g2d);

      g2d.drawImage(imgSource, 0, 0, null);
      g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, (float)alpha));
      g2d.setColor(color);

      g2d.fillRect(0, 0, imgSource.getWidth(), imgSource.getHeight());
    } finally {
      g2d.dispose();
    }
     */

    return new GaussianFilter(size).filter(img, null);
  }
}