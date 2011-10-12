package org.fest.swing.image;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: carsten
 * Date: 10/12/11
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IScreenshotTaker {
    void saveDesktopAsPng(String imageFilePath);

    BufferedImage takeDesktopScreenshot();

    void saveComponentAsPng(Component c, String imageFilePath);

    BufferedImage takeScreenshotOf(Component c);

    void saveImage(BufferedImage image, String filePath);
}
