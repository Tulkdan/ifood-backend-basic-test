package com.ifood.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AboutTest {

  @Test
  public void shouldReturnAnStringToTestServerIsWorking() {
    String expected = "This service is working as it should";
    About about = new About();

    assertEquals(expected, about.index());
  }
}