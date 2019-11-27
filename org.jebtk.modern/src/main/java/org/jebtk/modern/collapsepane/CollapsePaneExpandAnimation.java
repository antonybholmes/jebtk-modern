package org.jebtk.modern.collapsepane;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.modern.animation.RotationAnimation;
import org.jebtk.modern.graphics.ImageUtils;
import org.jebtk.modern.widget.ModernWidget;

public class CollapsePaneExpandAnimation extends RotationAnimation {

  private ModernSubCollapsePane mPane;

  public CollapsePaneExpandAnimation(ModernWidget widget) {
    super(widget, 360, 180);

    mPane = (ModernSubCollapsePane) widget;

    mPane.addChangeListener(new ChangeListener() {

      @Override
      public void changed(ChangeEvent e) {
        restart();
      }
    });

    // restart();
  }

  @Override
  public void restart() {
    boolean expanded = mPane.mExpanded.get(mPane.getSelectedIndex());

    // If we are expanded then the animation must be reversed
    restart(expanded);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Object... params) {
    Rectangle r = new Rectangle(widget.getInsets().left, widget.getInsets().top,
        widget.getWidth() - widget.getInsets().left - widget.getInsets().right,
        mPane.mHeaderHeight);

    Graphics2D g2Temp = ImageUtils.clone(g2);

    int d = (mPane.mHeaderHeight - ModernCollapseNodeRenderer.ICON_SIZE) / 2;

    int xt = widget.getWidth() - widget.getInsets().right
        - ModernCollapseNodeRenderer.ICON_SIZE - d;
    int yt = r.y + d;
    int mid = ModernCollapseNodeRenderer.ICON_SIZE / 2;

    try {
      g2Temp.translate(xt, yt);

      for (int i = 0; i < mPane.mTabNames.size(); ++i) {

        Graphics2D g2Temp2 = ImageUtils.clone(g2Temp);

        try {
          g2Temp2.translate(mid, mid);

          if (i == mPane.getSelectedIndex()) {
            g2Temp2.rotate(getAngle());
          } else {
            boolean expanded = mPane.mExpanded.get(i);

            if (expanded) {
              g2Temp2.rotate(getEndAngle());
            }
          }

          g2Temp2.translate(-mid, -mid);

          ModernCollapseNodeRenderer.BRANCH_CLOSED_ICON
              .drawIcon(g2Temp2, 0, 0, ModernCollapseNodeRenderer.ICON_SIZE);

        } finally {
          g2Temp2.dispose();
        }

        g2Temp.translate(0,
            mPane.mHeaderHeight + (mPane.mExpanded.get(i)
                ? mPane.mComponents.get(i).getPreferredSize().height
                : 0));
      }
    } finally {
      g2Temp.dispose();
    }
  }

  @Override
  public void drawRotation(ModernWidget widget,
      Graphics2D g2,
      Object... params) {
    // Do nothing
  }

}
