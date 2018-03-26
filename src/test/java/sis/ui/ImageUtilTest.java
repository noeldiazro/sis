package sis.ui;

import junit.framework.TestCase;

public class ImageUtilTest extends TestCase {
    public void testLoadImage_NotFound() {
	assertNull(ImageUtil.create("/images/bogusFilename.gif"));
    }

    public void testLoadImage_Found() {
	assertNotNull(ImageUtil.create("/images/courses.gif"));
    }
}
