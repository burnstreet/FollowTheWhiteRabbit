package de.tschritter;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Field;
import org.testng.annotations.Test;

public class BonusBTest {

  @Test
  public void testChangeFooBar() {
    TestClass testClass = new TestClass();
    assertEquals(testClass.getFoobar(), "test");
    try {
      Field field = TestClass.class.getDeclaredField("foobar");
      field.setAccessible(true);
      field.set(testClass, "SUCCESS");
    } catch (IllegalAccessException | NoSuchFieldException e) {
      e.printStackTrace();
    }
    assertEquals(testClass.getFoobar(), "SUCCESS");
  }
}

class TestClass {

  private String foobar = "test";

  public String getFoobar() {
    return foobar;
  }
}

