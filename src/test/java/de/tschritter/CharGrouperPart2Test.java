package de.tschritter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CharGrouperPart2Test {

  private CharGrouper charGrouper;
  private ArraySorter sorter;
  private StringCompressor compressor;

  @BeforeTest
  public void setUp() {
    sorter = mock(ArraySorter.class);
    StringCompressor compressor = new StringCompressor();
    this.compressor = spy(compressor);
    CharGrouper charGrouper = new CharGrouper(sorter, compressor);
    this.charGrouper = spy(charGrouper);
  }

  @Test(dataProvider = "Strings")
  public void group(String input, String expected) {
    assertEquals(charGrouper.group(input), expected);
    verify(charGrouper, times(1)).group(input);
  }

  @DataProvider(name = "Strings")
  public static Object[][] primeNumbers() {
    return new Object[][]{{"xyz", ""}, {"abzuaaissna", ""}, {"hello", ""}, {"", ""},
        {"abcdef", "SUCCESS"}};
  }
}
