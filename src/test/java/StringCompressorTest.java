import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

public class StringCompressorTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private StringCompressor stringCompressor;

  @Test
  public void compress_oneCharacter_shouldNotCompress() {
    String uncompressed = "a";
    String compressed = stringCompressor.compress(uncompressed);
    assertEquals("a", compressed);
  }

  @Test
  public void compress_moreCharacters_shouldCompress() {
    String uncompressed = "aaa";
    String compressed = stringCompressor.compress(uncompressed);
    assertEquals("a3", compressed);
  }

  @Test
  public void compress_repeatingSameCharacter_shouldCompressEachOccurenceIndependent() {

    String uncompressed = "aabbbbcaaddddddd";
    String compressed = stringCompressor.compress(uncompressed);
    assertEquals("a2b4ca2d7", compressed);
  }

  @Test
  public void compress_resultHasSameLengthAsInput_shouldNotCompress() {
    String uncompressed = "hello";
    String compressed = stringCompressor.compress(uncompressed);
    assertEquals(uncompressed, compressed);
  }

  /**
   * Necessary for Spring DI to work
   */
  @Configuration
  public static class Config {

    @Bean
    public static StringCompressor getCompressor() {
      return new StringCompressor();
    }
  }
}