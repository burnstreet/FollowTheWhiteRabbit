package de.tschritter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharGrouper {

  @Autowired
  private ArraySorter sorter;
  @Autowired
  private StringCompressor compressor;

  public String group(String input) {
    return compressor.compress(toString(sorter.sort(toIntArray(input))));
  }

  private int[] toIntArray(String input) {
    int[] ints = new int[input.length()];
    for (int i = 0; i < input.length(); i++) {
      ints[i] = (int) input.charAt(i);
    }
    return ints;
  }

  private String toString(int[] input) {
    StringBuilder sb = new StringBuilder(input.length);

    for (int anInput : input) {
      sb.append((char) anInput);
    }
    return sb.toString();
  }
}
