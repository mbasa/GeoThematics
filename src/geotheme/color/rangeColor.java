package geotheme.color;

import java.awt.Color;
import java.util.ArrayList;

public class rangeColor {
    
    public static ArrayList<String> createRangeColors(
            Color from, Color to, int range) {

        ArrayList<String> colors = new ArrayList<String>();
        int rFrom = from.getRed();
        int gFrom = from.getGreen();
        int bFrom = from.getBlue();

        int rTo = to.getRed();
        int gTo = to.getGreen();
        int bTo = to.getBlue();

        float rDiff = (rTo - rFrom) / (range - 1);
        float gDiff = (gTo - gFrom) / (range - 1);
        float bDiff = (bTo - bFrom) / (range - 1);

        float r, g, b;
        String rgb = new String();

        rgb = Integer.toHexString(from.getRGB());
        rgb = "#" + rgb.substring(2, rgb.length());

        colors.add(rgb);

        for (int i = 1; i < range - 1; i++) {
            r = rFrom + (rDiff * i);
            g = gFrom + (gDiff * i);
            b = bFrom + (bDiff * i);

            Color c = new Color((int) r, (int) g, (int) b);

            rgb = Integer.toHexString(c.getRGB());
            rgb = "#" + rgb.substring(2, rgb.length());

            colors.add(rgb);
        }

        rgb = Integer.toHexString(to.getRGB());
        rgb = "#" + rgb.substring(2, rgb.length());

        colors.add(rgb);

        return colors;
    }

}
