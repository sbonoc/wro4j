/*
 * Copyright (c) 2008. All rights reserved.
 */
package ro.isdc.wro.model.resource.locator;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if {@link ClasspathUriLocator} works properly.
 *
 * @author Alex Objelean
 * @created Created on Nov 3, 2008
 */
public class TestUrlUriLocator {
  /**
   * UriLocator to test.
   */
  private UriLocator uriLocator;

  @Before
  public void init() {
    uriLocator = new UrlUriLocator();
  }

  @Test(expected=IllegalArgumentException.class)
  public void cannotAcceptNullUri() throws IOException {
    uriLocator.locate(null);
  }

  @Test(expected=MalformedURLException.class)
  public void cannotLocateMalformedUrl()
    throws IOException {
    uriLocator.locate("/someInvalidUri.html");
  }

  @Test
  public void testValidUrl()
    throws IOException {
    uriLocator.locate("http://www.google.com");
  }
}