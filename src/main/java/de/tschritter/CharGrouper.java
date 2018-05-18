package de.tschritter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharGrouper {

  private final ArraySorter sorter;
  private final StringCompressor compressor;

  @Autowired
  CharGrouper(ArraySorter sorter, StringCompressor compressor) {
    this.sorter = sorter;
    this.compressor = compressor;
  }

  public String group(String input) {
    return compressor.compress(toString(sorter.sort(toIntArray(input))));
  }

  private int[] toIntArray(String input) {
    return input.codePoints().toArray();
  }

  private String toString(int[] input) {
    StringBuilder sb = new StringBuilder(input.length);

    for (int anInput : input) {
      sb.appendCodePoint(anInput);
    }
    return sb.toString();
  }
}
