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
package org.jebtk.modern.theme;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

// TODO: Auto-generated Javadoc
/**
 * The Class ModernRoundedWidgetRenderer.
 */
public class ModernRoundedWidgetRenderer extends ModernWidgetRenderer {

	/** The Constant ROUNDING. */
	public static final int ROUNDING = 6; //4; //6;

	/** The Constant PRIMARY_DIALOG_BUTTON_FILL_COLOR_1. */
	public static final Color PRIMARY_DIALOG_BUTTON_FILL_COLOR_1 =
			ThemeService.getInstance().colors().getColorHighlight32(14);

	/** The Constant PRIMARY_DIALOG_BUTTON_FILL_COLOR_2. */
	public static final Color PRIMARY_DIALOG_BUTTON_FILL_COLOR_2 =
			ThemeService.getInstance().colors().getColorHighlight32(16);

	/** The Constant PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_1. */
	public static final Color PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_1 =
			ThemeService.getInstance().colors().getColorHighlight32(16);

	/** The Constant PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_2. */
	public static final Color PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_2 =
			ThemeService.getInstance().colors().getColorHighlight32(18);

	/** The Constant DIALOG_BUTTON_FILL_COLOR_1. */
	public static final Color DIALOG_BUTTON_FILL_COLOR_1 =
			ThemeService.getInstance().colors().getHighlight32(4);

	/** The Constant DIALOG_BUTTON_FILL_COLOR_2. */
	public static final Color DIALOG_BUTTON_FILL_COLOR_2 =
			ThemeService.getInstance().colors().getHighlight32(6);

	/** The Constant DIALOG_BUTTON_SELECTED_FILL_COLOR_1. */
	public static final Color DIALOG_BUTTON_SELECTED_FILL_COLOR_1 =
			ThemeService.getInstance().colors().getHighlight32(6);

	/** The Constant DIALOG_BUTTON_SELECTED_FILL_COLOR_2. */
	public static final Color DIALOG_BUTTON_SELECTED_FILL_COLOR_2 =
			ThemeService.getInstance().colors().getHighlight32(8);

	/** The Constant HIGHLIGHTED_FILL_COLOR_1. */
	private static final Color HIGHLIGHTED_FILL_COLOR_1 =
			ThemeService.getInstance().colors().getColorHighlight32(6);

	/** The Constant HIGHLIGHTED_FILL_COLOR_2. */
	private static final Color HIGHLIGHTED_FILL_COLOR_2 =
			ThemeService.getInstance().colors().getColorHighlight32(8);
	
	/** The Constant HIGHLIGHTED_FILL_1. */
	private static final Color HIGHLIGHTED_FILL_1 =
			ThemeService.getInstance().colors().getHighlight32(6);

	private static final double ROUNDING_FACTOR = 0.15;

	private static final int MIN_ROUNDING = 4;

	/**
	 *  The Constant HIGHLIGHTED_FILL_COLOR_2.
	 *
	 * @param g2 the g 2
	 * @param x the x
	 * @param y the y
	 * @param w the w
	 * @param h the h
	 * @param mode the mode
	 * @param hasFocus the has focus
	 */
	//private static final Color HIGHLIGHTED_FILL_2 =
	//		ThemeService.getInstance().colors().getHighlight32(6);


	//public static final Color DIALOG_BUTTON_OUTLINE_COLOR =
	//		ThemeService.getInstance().colors().getHighlight(8);


	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#buttonHighlightedFillPaint(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void buttonFillPaint(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		if (mode == RenderMode.NONE) {
			return;
		}

		//GradientPaint paint;

		switch (mode) {
		case SELECTED:
			/*
			paint = new GradientPaint(0, 
					y, 
					HIGHLIGHTED_FILL_COLOR, 
					0, 
					y + h, 
					SELECTED_FILL_COLOR);

			g2.setPaint(paint);
			*/
			
			g2.setColor(SELECTED_FILL_COLOR);
			
			break;
		default:
			// disabled
			g2.setColor(HIGHLIGHTED_FILL_COLOR);
		}

		
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#drawPrimaryDialogButtonFill(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void drawPrimaryDialogButtonFill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {

		primaryDialogButtonFillPaint(g2, x, y, w, h, mode, hasFocus);

		fill(g2, x, y, w, h);

		//fill(g2, DIALOG_BUTTON_FILL_COLOR_1, x, y, w, h);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#primaryDialogButtonFillPaint(java.awt.Graphics2D, int, int, int, int, org.abh.common.ui.theme.RenderMode, boolean)
	 */
	@Override
	public void primaryDialogButtonFillPaint(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {

		GradientPaint paint = null;

		if (mode != RenderMode.NONE) {
			paint = new GradientPaint(0, 
					y, 
					PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_1, 
					0, 
					y + h, 
					PRIMARY_DIALOG_BUTTON_SELECTED_FILL_COLOR_2);
		} else {
			paint = new GradientPaint(0, 
					y, 
					PRIMARY_DIALOG_BUTTON_FILL_COLOR_1, 
					0, 
					y + h, 
					PRIMARY_DIALOG_BUTTON_FILL_COLOR_2);
		}

		g2.setPaint(paint);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#drawDialogButtonFill(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void drawDialogButtonFill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		GradientPaint paint;

		if (mode != RenderMode.NONE) {
			paint = new GradientPaint(0, 
					y, 
					DIALOG_BUTTON_SELECTED_FILL_COLOR_1, 
					0, 
					y + h, 
					DIALOG_BUTTON_SELECTED_FILL_COLOR_2);
		} else {
			paint = new GradientPaint(0, 
					y, 
					DIALOG_BUTTON_FILL_COLOR_1, 
					0, 
					y + h, 
					DIALOG_BUTTON_FILL_COLOR_2);
		}

		g2.setPaint(paint);

		fill(g2, x, y, w, h);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#drawRibbonButtonSelectedFill(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void drawRibbonButtonFill(Graphics2D g2, 
			int x, 
			int y, 
			int w, 
			int h,
			RenderMode mode,
			boolean hasFocus) {
		if (mode == RenderMode.NONE) {
			return;
		}

		/*
		GradientPaint paint = new GradientPaint(0, 
				y, 
				RIBBON_HIGHLIGHT_FILL_COLOR, 
				0, 
				y + h, 
				RIBBON_SELECTED_FILL_COLOR);
		g2.setPaint(paint);	
		*/
		
		g2.setColor(RIBBON_SELECTED_FILL_COLOR);

		fill(g2, x, y, w, h);

		//fill(g2, RIBBON_SELECTED_HIGHLIGHT_COLOR, x, y, w, h);
	}


	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#fill(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void fill(Graphics2D g2, int x, int y, int w, int h) {
		
		int r = getRounding(h);
		
		g2.fillRoundRect(x, y, w, h, r, r);
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.theme.ModernWidgetRenderer#outline(java.awt.Graphics2D, int, int, int, int)
	 */
	@Override
	public void outline(Graphics2D g2, int x, int y, int w, int h) {
		int r = getRounding(h);
		
		g2.drawRoundRect(x, y, w - 1, h - 1, r, r);
	}
	
	public int getRounding(int h) {
		return ROUNDING; //Math.max(MIN_ROUNDING, (int)Math.round(h * ROUNDING_FACTOR));
	}
}
