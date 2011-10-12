package org.fest.swing.junit.v4_5.runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.InitializationError;

import static junit.framework.Assert.assertEquals;


public class GuiTestRunnerTest {

    private String javaAwtHeadlessBefore;

    @Before
    public void saveProperty() {
        javaAwtHeadlessBefore=System.getProperty("java.awt.headless");
    }

    @After
    public void resetProperty() {
        if (javaAwtHeadlessBefore!=null)
            System.setProperty("java.awt.headless",javaAwtHeadlessBefore);
    }

    @Test
    public void testRunner() throws Exception {
        System.setProperty("java.awt.headless","true");

        try {
            GUITestRunner guiTestRunner=new GUITestRunner(ClassUnderTest.class);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("org.fest.swing.image.ImageException: Unable to create AWT Robot",e.toString());
        }
    }
}
