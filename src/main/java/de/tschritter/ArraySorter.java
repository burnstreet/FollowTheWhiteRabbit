package de.tschritter;

import java.util.Arrays;


public class ArraySorter {

  public int[] sort(int[] unsorted) {
    int[] copy = Arrays.copyOf(unsorted, unsorted.length);
    Arrays.sort(copy);
    return copy;
  }
}
