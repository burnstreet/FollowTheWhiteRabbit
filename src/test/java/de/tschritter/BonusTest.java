package de.tschritter;

import static de.tschritter.Bonus.add;
import static org.testng.Assert.assertEquals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

public class BonusTest {


  @Test
  public void test() {
    String s = "1";
    Integer i = 1;
    s = add(s, 1);
    assertEquals("2", s);
    s = add(s, 5);
    assertEquals("7", s);
    i = add(i, 2);
    assertEquals((Integer) 3, i);
    i = add(i, 1);
    assertEquals((Integer) 4, i);
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