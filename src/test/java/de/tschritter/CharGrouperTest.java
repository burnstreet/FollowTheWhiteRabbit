package de.tschritter;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

public class CharGrouperTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private CharGrouper charGrouper;

  @Test
  public void groupUnsortedWithDuplicates() {
    String input = "abzuaaissna";
    String expected = "a4bins2uz";
    assertEquals(charGrouper.group(input), expected);
  }

  @Test
  public void groupUnsorted() {
    String input = "zyx";
    String expected = "xyz";
    assertEquals(charGrouper.group(input), expected);
  }

  @Test
  public void groupDuplicates() {
    String input = "aaaa";
    String expected = "a4";
    assertEquals(charGrouper.group(input), expected);
  }

  @Test
  public void groupHello() {
    String input = "hello";
    String expected = "ehl2o";
    assertEquals(charGrouper.group(input), expected);
  }

  @Test
  public void groupEmpty() {
    String input = "";
    assertEquals(charGrouper.group(input), input);
  }

  @Test(expectedExceptions = NullPointerException.class)
  public void groupNull() {
    String input = null;
    //noinspection ConstantConditions
    charGrouper.group(input);
  }

  /**
   * Necessary for Spring DI to work
   */
  @Configuration
  public static class Config {

    @Bean
    public static CharGrouper getCharGrouper() {
      return new CharGrouper();
    }

    @Bean
    public static StringCompressor getCompressor() {
      return new StringCompressor();
    }

    @Bean
    public static ArraySorter getSorter() {
      return new ArraySorter();
    }
  }
}