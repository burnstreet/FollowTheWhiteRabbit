package de.tschritter;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

public class ArraySorterTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private ArraySorter sorter;

  /**
   * unsorted array should be sorted
   */
  @Test
  private void sortUnsorted() {
    int[] input = {1, -500, 4, 123456789, 8, 9, -50000000};
    int[] expected = {-50000000, -500, 1, 4, 8, 9, 123456789};
    assertEquals(sorter.sort(input), expected);
  }

  /**
   * unsorted array with duplicates should be sorted
   */
  @Test
  private void sortUnsortedWithDuplicates() {
    int[] input = {9, 1, 9, -500, 4, 123456789, 8, 9, -50000000, -500};
    int[] expected = {-50000000, -500, -500, 1, 4, 8, 9, 9, 9, 123456789};
    assertEquals(sorter.sort(input), expected);
  }

  /**
   * Edge case: null pointer should throw an exception
   */
  @Test(expectedExceptions = NullPointerException.class)
  private void sortNull() {
    int[] input = null;
    //noinspection ConstantConditions
    sorter.sort(input);
  }

  /**
   * Edge case: empty array should return empty array
   */
  @Test
  private void sortEmpty() {
    assertEquals(sorter.sort(new int[0]), new int[0]);
  }

  /**
   * Edge case: 1 element array should return an array with the same element
   */
  @Test
  private void sortOneElement() {
    int[] input = {1};
    assertEquals(sorter.sort(input), input);
    int[] input2 = {3597};
    assertEquals(sorter.sort(input2), input2);
  }

  /**
   * Edge Case: pre-sorted Array should stay the same
   */
  @Test
  private void sortPreSorted() {
    int[] input = {-500, 1, 4, 6, 7, 100, 14578, 123456789};
    assertEquals(sorter.sort(input), input);
  }

  /**
   * Edge Case: pre-sorted Array with duplicates should stay the same
   */
  @Test
  private void sortPreSortedWithDuplicates() {
    int[] input = {-500, -500, 1, 4, 6, 7, 7, 7, 7, 7, 100, 14578, 123456789};
    assertEquals(sorter.sort(input), input);
  }

  /**
   * Necessary for Spring DI to work
   */
  @Configuration
  public static class Config {

    @Bean
    public static ArraySorter getSorter() {
      return new ArraySorter();
    }
  }
}