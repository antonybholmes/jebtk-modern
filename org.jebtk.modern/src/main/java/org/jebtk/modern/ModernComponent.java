/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jebtk.modern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;
import javax.swing.border.Border;

import org.jebtk.core.geom.IntRect;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.modern.theme.ModernTheme;
import org.jebtk.modern.theme.ThemeService;

// TODO: Auto-generated Javadoc
/**
 * Standardized panel component.
 * 
 * @author Antony Holmes Holmes
 *
 */
public class ModernComponent extends JComponent {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The member internal rect.
	 */
	public IntRect mInternalRect = new IntRect(0, 0, 0, 0);
	
	/**
	 * The member rect.
	 */
	protected IntRect mRect = new IntRect(0, 0, 0, 0);
	
	/**
	 * The constant BACKGROUND_COLOR.
	 */
	public static final Color BACKGROUND_COLOR = 
			SettingsService.getInstance().getAsColor("theme.background");
	
	/**
	 * The constant OUTLINE_BASE_COLOR.
	 */
	public static final Color OUTLINE_BASE_COLOR = 
			ThemeService.getInstance().colors().getHighlight(1);
	
	/**
	 * The constant OUTLINE_COLOR.
	 */
	public static final Color OUTLINE_COLOR = 
			ThemeService.getInstance().colors().getHighlight(6);
	
	/**
	 * The constant LINE_COLOR.
	 */
	public static final Color LINE_COLOR = 
			ThemeService.getInstance().colors().getLineColor();

	/** The Constant LIGHT_LINE_COLOR. */
	public static final Color LIGHT_LINE_COLOR = 
			ThemeService.getInstance().colors().getLightLineColor();

	/**
	 * The constant DARK_LINE_COLOR.
	 */
	public static final Color DARK_LINE_COLOR = 
			ThemeService.getInstance().colors().getDarkLineColor();

	/**
	 * The constant PADDING.
	 */
	public static final int PADDING = 
			SettingsService.getInstance().getAsInt("theme.widget.padding");
	
	/**
	 * The constant OUTLINE_LINE_BORDER.
	 */
	public static final Border OUTLINE_LINE_BORDER = 
			BorderService.getInstance().createLineBorder(OUTLINE_COLOR);
	
	/**
	 * The constant DOUBLE_PADDING.
	 */
	public static final int DOUBLE_PADDING = 2 * PADDING;
	
	/**
	 * The constant TRIPLE_PADDING.
	 */
	public static final int TRIPLE_PADDING = 3 * PADDING;
	
	/**
	 * The constant QUAD_PADDING.
	 */
	public static final int QUAD_PADDING = 4 * PADDING;
	
	/**
	 * The constant BORDER.
	 */
	public static final Border BORDER = 
			BorderService.getInstance().createBorder(PADDING);
	
	/**
	 * The constant SMALL_BORDER.
	 */
	public static final Border SMALL_BORDER = 
			BorderService.getInstance().createBorder(PADDING / 2);
	
	/** The Constant DOUBLE_BORDER. */
	public static final Border DOUBLE_BORDER = 
			BorderService.getInstance().createBorder(DOUBLE_PADDING);
	
	/** The Constant TRIPLE_BORDER. */
	public static final Border TRIPLE_BORDER = 
			BorderService.getInstance().createBorder(TRIPLE_PADDING);
	
	/** The Constant QUAD_BORDER. */
	public static final Border QUAD_BORDER = 
			BorderService.getInstance().createBorder(QUAD_PADDING);

	/** The Constant LARGE_BORDER. */
	public static final Border LARGE_BORDER = DOUBLE_BORDER;
	
	
	/**
	 * The constant TOP_BORDER.
	 */
	public static final Border TOP_BORDER = 
			BorderService.getInstance().createTopBorder(PADDING);
	
	public static final Border TOP_DOUBLE_BORDER = 
			BorderService.getInstance().createTopBorder(DOUBLE_PADDING);
	
	/**
	 * The constant LEFT_BORDER.
	 */
	public static final Border LEFT_BORDER = 
			BorderService.getInstance().createLeftBorder(PADDING);
	
	/**
	 * The constant BOTTOM_BORDER.
	 */
	public static final Border BOTTOM_BORDER = 
			BorderService.getInstance().createBottomBorder(PADDING);
	
	/**
	 * The constant RIGHT_BORDER.
	 */
	public static final Border RIGHT_BORDER = 
			BorderService.getInstance().createRightBorder(PADDING);
	
	/**
	 * The constant TOP_BOTTOM_BORDER.
	 */
	public static final Border TOP_BOTTOM_BORDER = 
			BorderService.getInstance().createTopBottomBorder(PADDING);
	
	/**
	 * The constant LEFT_RIGHT_BORDER.
	 */
	public static final Border LEFT_RIGHT_BORDER = 
			BorderService.getInstance().createLeftRightBorder(PADDING);
	
	/**
	 * The member listeners.
	 */
	protected ModernComponentListeners mListeners = 
			new ModernComponentListeners();

	/** The m center. */
	private Component mCenter = null;

	/** The m line padding. */
	protected int mLinePadding;

	/** The m page padding. */
	protected int mPagePadding;
			
	

	/**
	 * The class ComponentEvents.
	 */
	private class ComponentEvents implements ComponentListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentResized(ComponentEvent e) {
			setInternalDimension();
			
			mListeners.fireComponentResized(e);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentHidden(ComponentEvent e) {
			mListeners.fireComponentHidden(e);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentMoved(ComponentEvent e) {
			mListeners.fireComponentMoved(e);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentShown(ComponentEvent e) {
			mListeners.fireComponentShown(e);
		}
	}

	/**
	 * Instantiates a new modern component.
	 */
	public ModernComponent() {
		setup();
	}

	/**
	 * Instantiates a new modern component.
	 *
	 * @param color the color
	 */
	public ModernComponent(Color color) {		
		setup();

		setBackground(color);
	}

	/**
	 * Instantiates a new modern component.
	 *
	 * @param manager the manager
	 */
	public ModernComponent(LayoutManager manager) {
		setup();
		
		setLayout(manager);
	}

	/**
	 * Instantiates a new modern component.
	 *
	 * @param c the c
	 */
	public ModernComponent(Component c) {
		setup();

		add(c);
	}
	
	/**
	 * Instantiates a new modern component.
	 *
	 * @param c the c
	 * @param border the border
	 */
	public ModernComponent(Component c, Border border) {
		this(c);
		
		setBorder(border);
	}
	
	/**
	 * Instantiates a new modern component.
	 *
	 * @param c the c
	 * @param color the color
	 * @param border the border
	 */
	public ModernComponent(Component c, Color color, Border border) {
		this(c);
		
		setBackground(color);
		setBorder(border);
	}

	/**
	 * Create a component containing a given component surrounded by a border
	 * of width {@code border} pixels.
	 *
	 * @param c the c
	 * @param border the border
	 */
	public ModernComponent(Component c, int border) {
		this(c, BorderService.getInstance().createBorder(border));
	}

	public ModernComponent(Component c, LayoutManager layout) {
		this(c);
		
		setLayout(layout);
	}

	/**
	 * Setup.
	 */
	private void setup() {
		setLayout(new BorderLayout());

		setAlignmentX(LEFT_ALIGNMENT);
		//setAlignmentY(TOP_ALIGNMENT);

		super.addComponentListener(new ComponentEvents());

		setOpaque(false);
		
		setDoubleBuffered(true);
	}

	/**
	 * Creates rectangle objects specifying the size and
	 * internal size (size minus offsets).
	 */
	private void setInternalDimension() {
		setInternalDimension(getInsets());
	}
	
	/**
	 * Sets the internal dimension.
	 *
	 * @param insets the new internal dimension
	 */
	private void setInternalDimension(Insets insets) {
		setInternalDimension(getWidth(), getHeight(), insets);
	}
	
	/**
	 * Sets the internal dimension.
	 *
	 * @param width the width
	 * @param height the height
	 */
	private void setInternalDimension(int width, int height) {
		setInternalDimension(width, height, getInsets());
	}
	
	/**
	 * Sets the internal dimension.
	 *
	 * @param width the width
	 * @param height the height
	 * @param insets the insets
	 */
	private void setInternalDimension(int width, int height, Insets insets) {
		mRect = new IntRect(0, 0, width, height);

		int x = 0;
		int y = 0;
		
		if (insets != null) {
			x = insets.left;
			y = insets.top;
			mLinePadding = insets.left + insets.right;
			mPagePadding = insets.top + insets.bottom;
		} else {
			mLinePadding = 0;
			mPagePadding = 0;
		}
		
		mInternalRect = new IntRect(x, 
				y, 
				width - mLinePadding, 
				height - mPagePadding);

		repaint();
	}
	
	/**
	 * Returns the sum of the left and right padding.
	 *
	 * @return the line padding
	 */
	public int getLinePadding() {
		return mLinePadding;
	}

	/**
	 * Returns the sum of the top and bottom padding.
	 * 
	 * @return
	 */
	public int getPagePadding() {
		return mPagePadding;
	}

	
	/**
	 * Returns the internal dimensions (excluding padding) of the widget.
	 *
	 * @return the rect
	 */
	public IntRect getRect() {
		return mRect;
	}

	/**
	 * Returns the size of the component excluding the insets.
	 *
	 * @return the internal rect
	 */
	public IntRect getInternalRect() {
		return mInternalRect;
	}

	/**
	 * Set a uniform border of {@code border} pixels.
	 *
	 * @param border the new border
	 */
	public void setBorder(int border) {
		setBorder(BorderService.getInstance().createBorder(border));
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#setBorder(javax.swing.border.Border)
	 */
	@Override
	public void setBorder(Border border) {
		if (border == null) {
			return;
		}
		
		setInternalDimension(border.getBorderInsets(this));
		
		super.setBorder(border);
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#setSize(int, int)
	 */
	@Override
	public void setSize(int width, int height) {
		setInternalDimension(width, height);
		
		super.setSize(width, height);
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#setSize(java.awt.Dimension)
	 */
	@Override
	public void setSize(Dimension dimension) {
		setSize(dimension.width, dimension.height);
	}

	/**
	 * Gets the component.
	 *
	 * @return the component
	 */
	public Component getComponent() {
		return getComponent(0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public final void paintComponent(Graphics g) {
		if (!isVisible()) {
			return;
		}
		
		//super.paintComponent(g);
		
		//Graphics2D g2 = (Graphics2D)g.create();

		draw((Graphics2D)g);
		
		//g2.dispose();
	}

	/**
	 * Separate the background and foreground rendering
	 * of components since many widgets will use the same
	 * background rendering and only change how information
	 * is displayed.
	 *
	 * @param g2 the g2
	 */
	public void draw(Graphics2D g2) {
		// Render then separately on independent
		// contexts to minimize graphic errors
		// caused by adjusting the properties
		// of g2.
		
		Graphics2D g2Temp;
		
		g2Temp = (Graphics2D)g2.create();
		drawBackground(g2Temp);
		g2Temp.dispose();
		
		g2Temp = (Graphics2D)g2.create();
		drawForeground(g2Temp);
		g2Temp.dispose();
	}

	/**
	 * Should be in charge of rendering the foreground using
	 * anti-aliasing.
	 *
	 * @param g2 the g2
	 */
	public void drawBackground(Graphics2D g2) {
		// do nothing
	}

	/**
	 * Should be in charge of rendering the foreground using
	 * anti-aliasing.
	 *
	 * @param g2 the g2
	 */
	protected void drawForeground(Graphics2D g2) {
		// do nothing
	}
	
	/**
	 * Sets the header.
	 *
	 * @param c the new header
	 */
	public void setHeader(Component c) {
		add(c, BorderLayout.PAGE_START);
	}
	
	/**
	 * Sets the body.
	 *
	 * @param c the new body
	 */
	public void setBody(Component c) {
		if (c == null) {
			return;
		}
		
		if (mCenter != null) {
			remove(mCenter);
		}
		
		mCenter = c;

		add(c, BorderLayout.CENTER);

		revalidate();
		repaint();
	}
	
	/**
	 * Sets the footer.
	 *
	 * @param c the new footer
	 */
	public void setFooter(Component c) {
		add(c, BorderLayout.PAGE_END);
	}
	
	/**
	 * Sets the left.
	 *
	 * @param c the new left
	 */
	public void setLeft(Component c) {
		add(c, BorderLayout.LINE_START);
	}
	
	/**
	 * Sets the right.
	 *
	 * @param c the new right
	 */
	public void setRight(Component c) {
		add(c, BorderLayout.LINE_END);
	}
	
	/**
	 * Draw outline.
	 *
	 * @param g2 the g2
	 * @param rect the rect
	 */
	public static void drawOutline(Graphics2D g2, Rectangle rect) {
		drawBorder(g2, OUTLINE_COLOR, rect);
	}
	
	/**
	 * Draw outline.
	 *
	 * @param g2 the g2
	 * @param rect the rect
	 */
	public static void drawOutline(Graphics2D g2, IntRect rect) {
		drawBorder(g2, OUTLINE_COLOR, rect);
	}
	
	/**
	 * Draws a standard border of a specified color. This should be used by
	 * all button like controls.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawBorder(Graphics2D g2, Color color, Rectangle rect) {
		drawRect(g2, color, rect);
	}
	
	/**
	 * Draw border.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawBorder(Graphics2D g2, Color color, IntRect rect) {
		drawRect(g2, color, rect);
	}
	
	/**
	 * Draw rect.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawRect(Graphics2D g2, Color color, Rectangle rect) {
		g2.setColor(color);
		//g2.setStroke(ModernTheme.SINGLE_LINE_STROKE);

		g2.drawRect(rect.x,
				rect.y,
				rect.width - 1,
				rect.height - 1);
	}
	
	/**
	 * Draw rect.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawRect(Graphics2D g2, Color color, IntRect rect) {
		g2.setColor(color);
		//g2.setStroke(ModernTheme.SINGLE_LINE_STROKE);

		g2.drawRect(rect.getX(),
				rect.getY(),
				rect.getW() - 1,
				rect.getH() - 1);
	}
	
	/**
	 * Draw double thick rect.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawDoubleThickRect(Graphics2D g2, Color color, IntRect rect) {
		g2.setColor(color);
		
		g2.drawRect(rect.getX(),
				rect.getY(),
				rect.getW() - 1,
				rect.getH() - 1);
		
		g2.drawRect(rect.getX() + 1,
				rect.getY() + 1,
				rect.getW() - 3,
				rect.getH() - 3);
	}
	
	/**
	 * Draw rect double stroke.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void drawRectDoubleStroke(Graphics2D g2, 
			Color color, 
			IntRect rect) {
		drawRectDoubleStroke(g2,
				color,
				rect.getX(),
				rect.getY(),
				rect.getW() - 1,
				rect.getH() - 1);
	}
	
	/**
	 * Draw rect double stroke.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 */
	public static void drawRectDoubleStroke(Graphics2D g2, 
			Color color, 
			int x,
			int y,
			int w,
			int h) {
		g2.setColor(color);
		g2.setStroke(ModernTheme.DOUBLE_LINE_STROKE);

		g2.drawRect(x + 1,
				y + 1,
				w - 2,
				h - 2);
	}
	

	
	/**
	 * Fill in with the background color.
	 *
	 * @param g2 the g2
	 */
	public void fillBackground(Graphics2D g2) {
		fillBackground(g2, getRect());
	}
	
	/**
	 * Fill in with the background color.
	 *
	 * @param g2 the g2
	 * @param rect the rect
	 */
	public void fillBackground(Graphics2D g2, Rectangle rect) {
		fill(g2, getBackground(), rect);
	}
	
	/**
	 * Fill background.
	 *
	 * @param g2 the g2
	 * @param rect the rect
	 */
	public void fillBackground(Graphics2D g2, IntRect rect) {
		fill(g2, getBackground(), rect);
	}
	
	/**
	 * Fill.
	 *
	 * @param g2 the g2
	 * @param color the color
	 */
	public void fill(Graphics2D g2, Color color) {
		fill(g2, color, getRect());
	}
	
	/**
	 * Fill.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void fill(Graphics2D g2, 
			Color color,
			Rectangle rect) {
		g2.setColor(color);

		g2.fillRect(rect.x,
				rect.y,
				rect.width,
				rect.height);
	}
	
	/**
	 * Fill in the component in the given color up to a given width.
	 *
	 * @param g2 the g 2
	 * @param color the color
	 * @param width the width
	 */
	public void fill(Graphics2D g2, 
			Color color,
			int width) {
		fill(g2, color, new IntRect(0, 0, width, mRect.getH()));
	}

	/**
	 * Fill.
	 *
	 * @param g2 the g2
	 * @param color the color
	 * @param rect the rect
	 */
	public static void fill(Graphics2D g2, 
			Color color,
			IntRect rect) {
		
		g2.setColor(color);

		g2.fillRect(rect.getX(), rect.getY(), rect.getW(), rect.getH());
	}
	
	/**
	 * Creates the h gap.
	 *
	 * @return the component
	 */
	public static Component createHGap() {
		return UI.createHGap(PADDING);
	}
	
	/**
	 * Creates the v gap.
	 *
	 * @return the component
	 */
	public static Component createVGap() {
		return UI.createVGap(PADDING);
	}

	/**
	 * Creates the large vertical gap.
	 *
	 * @return the component
	 */
	public static final Component createLargeVerticalGap() {
		return UI.createVGap(DOUBLE_PADDING);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#addComponentListener(java.awt.event.ComponentListener)
	 */
	@Override
	public void addComponentListener(ComponentListener l) {
		// We force components to use this alternative listener so that
		// component internals can be updated before parents receive
		// notification that the component has changed size etc.
		mListeners.addComponentListener(l);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#removeComponentListener(java.awt.event.ComponentListener)
	 */
	@Override
	public void removeComponentListener(ComponentListener l) {
		mListeners.removeComponentListener(l);
	}
}
