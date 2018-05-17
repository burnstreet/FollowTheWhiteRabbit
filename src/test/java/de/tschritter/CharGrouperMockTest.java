package de.tschritter;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CharGrouperMockTest {

  private CharGrouper charGrouper;
  private ArraySorter sorter;
  private StringCompressor compressor;

  @BeforeTest
  public void setUp() {
    sorter = mock(ArraySorter.class);
    StringCompressor original = new StringCompressor();
    compressor = spy(original);
    charGrouper = new CharGrouper(sorter, compressor);
  }

  @Test
  public void groupUnsortedWithDuplicates() {
    String input = "abzuaaissna";
    String expected = "a4bins2uz";
    String sorted = "aaaabinssuz";
    int[] intInput = {97, 98, 122, 117, 97, 97, 105, 115, 115, 110, 97};
    int[] intOutput = {97, 97, 97, 97, 98, 105, 110, 115, 115, 117, 122};
    when(sorter.sort(intInput)).thenReturn(intOutput);
    assertEquals(charGrouper.group(input), expected);
    verify(sorter, times(1)).sort(eq(intInput));
    verify(compressor, times(1)).compress(eq(sorted));
  }

  @Test
  public void groupUnsorted() {
    String input = "zyx";
    String expected = "xyz";
    String sorted = "xyz";
    int[] intInput = {122, 121, 120};
    int[] intOutput = {120, 121, 122};
    when(sorter.sort(intInput)).thenReturn(intOutput);
    assertEquals(charGrouper.group(input), expected);
    verify(sorter, times(1)).sort(eq(intInput));
    verify(compressor, times(1)).compress(eq(sorted));
  }
}
