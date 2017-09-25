package org.jebtk.modern.io;

import java.awt.Graphics2D;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import org.jebtk.core.io.PathUtils;
import org.jebtk.modern.UI;
import org.jebtk.modern.UIService;
import org.jebtk.modern.graphics.icons.CheveronRightVectorIcon;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.widget.ModernWidget;

public class ModernFileCrumb extends ModernWidget {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private Path mFile;

	private ArrayList<String> mParts;
	
	private static final int ICON_SIZE = 12;
	
	private ModernIcon CRUMB_ICON =
			UIService.getInstance().loadIcon(CheveronRightVectorIcon.class, ICON_SIZE);

	
	/**
	 * Instantiates a new modern text border panel.
	 *
	 * @param textField the text field
	 * @param color the color
	 */
	public ModernFileCrumb(Path file) {
		

		setup();
		
		setFile(file);
	}

	

	/**
	 * Setup.
	 */
	private final void setup() {
		//mComponent.setBorder(SMALL_BORDER);
		
		
		
		//setMinimumSize(mComponent.getMinimumSize());
		//setMaximumSize(mComponent.getMaximumSize());
		
		UI.setSize(this, STANDARD_SIZE);
		
		setBorder(SMALL_BORDER);
		
		setBackgroundAnimations("text-border");
		
	}
	
	public void setFile(Path file) {
		mFile = file.toAbsolutePath();
		
		Deque<Path> stack = new ArrayDeque<Path>();
		
		Path p = mFile;
		
		while (p != null) {
			Path f = p.getFileName();
			
			if (f != null) {
				//System.err.println("crumb " + p.getFileName() + " " + p);
				stack.push(f);
			}
			
			p = p.getParent();
		}
		
		mParts = new ArrayList<String>(stack.size());
		
		while (!stack.isEmpty()) {
			mParts.add(PathUtils.getName(stack.pop()));
		}
	}
	
	
	@Override
	public void drawAnimatedBackground(Graphics2D g2) {
		getWidgetRenderer().drawContentBox(g2, mRect);
		
		super.drawAnimatedBackground(g2);
	}
	
	@Override
	public void drawForegroundAA(Graphics2D g2) {
		int x = PADDING;
		
		int y1 = getTextYPosCenter(g2, getHeight());
		int y2 = (getHeight() - CRUMB_ICON.getHeight()) / 2;
		
		g2.setColor(TEXT_COLOR);
		
		for (String part : mParts) {
			CRUMB_ICON.drawIcon(g2, x, y2, ICON_SIZE);
			
			x += ICON_SIZE + PADDING;
			
			g2.drawString(part, x, y1);
			
			x += PADDING;
		}
	}
}