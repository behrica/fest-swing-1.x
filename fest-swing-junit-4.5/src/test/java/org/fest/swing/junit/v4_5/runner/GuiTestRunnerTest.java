package org.fest.swing.junit.v4_5.runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;


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
        GUITestRunner guiTestRunner=new GUITestRunner(ClassUnderTest.class);
        final RunNotifier notifier = new RunNotifier();
        final List<Description> finshedTests=new ArrayList<Description>();
        notifier.addListener(new CollectingRunListener(finshedTests));
        guiTestRunner.run(notifier);
        assertTestWasRun(finshedTests);

    }

    private void assertTestWasRun(List<Description> finshedTests) {
        assertEquals(1,finshedTests.size());
        Description description=finshedTests.get(0);
        assertEquals("test(org.fest.swing.junit.v4_5.runner.ClassUnderTest)",description.getDisplayName());
    }

    private static class CollectingRunListener extends RunListener {
        private final List<Description> finishedTests;

        public CollectingRunListener(List<Description> finishedTests) {
            this.finishedTests = finishedTests;
        }

        @Override
        public void testFinished(Description description) throws Exception {
             finishedTests.add(description);
        }
    }
}
