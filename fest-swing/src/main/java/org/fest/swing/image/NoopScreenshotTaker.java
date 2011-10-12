package org.fest.swing.image;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Screenshot taker, which does nothing.
 * It's used in headless mode
 */
public class NoopScreenshotTaker implements IScreenshotTaker{

    private static final BufferedImage EMPTY_BUFFERED_IMAGE = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    public void saveDesktopAsPng(String imageFilePath) {
    }

    public BufferedImage takeDesktopScreenshot() {
        return EMPTY_BUFFERED_IMAGE;
    }

    public void saveComponentAsPng(Component c, String imageFilePath) {
    }

    public BufferedImage takeScreenshotOf(Component c) {
        return EMPTY_BUFFERED_IMAGE;
    }

    public void saveImage(BufferedImage image, String filePath) {
    }
}
