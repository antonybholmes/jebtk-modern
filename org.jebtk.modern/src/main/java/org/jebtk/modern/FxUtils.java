package org.jebtk.modern;

import org.jebtk.core.sys.SysUtils;
import org.jebtk.core.text.TextUtils;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;

public class FxUtils {
  public static final Color TRANS_COLOR = Color.rgb(0, 0, 0, 0);

  private FxUtils() {

  }

  public static StringBinding cssColorBinding(final String css,
      final ObjectProperty<Color> color) {
    System.err.println(String.format(css + ": rgba(%d, %d, %d, %f);",
            (int) (255 * color.get().getRed()),
            (int) (255 * color.get().getGreen()),
            (int) (255 * color.get().getBlue()),
            color.get().getOpacity()));
    
    return Bindings.createStringBinding(() -> String.format(css + ": rgba(%d, %d, %d, %f);",
            (int) (255 * color.get().getRed()),
            (int) (255 * color.get().getGreen()),
            (int) (255 * color.get().getBlue()),
            color.get().getOpacity()), 
        color);
  }
  
  public static StringBinding cssLinGradBinding(final ObjectProperty<Color> color1, final ObjectProperty<Color> color2) {
    return Bindings.createStringBinding(() -> String.format("-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, rgb(%d, %d, %d) 0%, rgb(%d, %d, %d) 100%)",
        (int) (255 * color1.get().getRed()),
        (int) (255 * color1.get().getGreen()),
        (int) (255 * color1.get().getBlue()), 
        (int) (255 * color2.get().getRed()),
        (int) (255 * color2.get().getGreen()),
        (int) (255 * color2.get().getBlue())), 
    color1,
    color2);
  }
  
  public static String cssLinearGradient(final Color color1, final Color color2) {
    SysUtils.err().println(color1, color2, TextUtils.format("-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, {} 0%, {} 100%);",
        webRGB(color1), webRGB(color2)));
    
    return TextUtils.format("-fx-background-color: linear-gradient(from 0% 0% to 0% 100%, {} 0%, {} 100%);",
        webRGB(color1), webRGB(color2));
  }

  private static String webValue(Color color) {
    return "#" + Integer.toHexString(color.hashCode()); 
  }
  
  private static String webRGB(Color color) {
    return String.format("rgba(%d, %d, %d, %d)",
        (int) (255 * color.getRed()),
        (int) (255 * color.getGreen()),
        (int) (255 * color.getBlue()),
        (int) (255 * color.getOpacity()));
  }

  public static StringBinding cssFillColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-background-color", color);
  }
  
  public static StringBinding cssStrokeColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-stroke", color);
  }
  
  public static StringBinding cssTextColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-text-fill", color);
  }

  public static StringBinding cssBorderColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-border-color", color);
  }

  public static java.awt.Color convert(Color color) {
    return new java.awt.Color((float) color.getRed(), (float) color.getGreen(),
        (float) color.getBlue(), (float) color.getOpacity());
  }

  public static Color convert(java.awt.Color color) {
    return new Color(color.getRed() / 255.0, color.getGreen() / 255.0,
        color.getBlue() / 255.0, color.getAlpha() / 255.0);
  }
  
  public static SimpleStringProperty propBGColor() {
    return new SimpleStringProperty("-fx-background-color");
  }
  
  public static Color toFxColor(java.awt.Color color) {
    int r = color.getRed();
    int g = color.getGreen();
    int b = color.getBlue();
    
    return Color.rgb(r, g, b, color.getAlpha() / 255.0);
  }
}
