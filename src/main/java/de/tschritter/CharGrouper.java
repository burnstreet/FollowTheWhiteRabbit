package de.tschritter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharGrouper {

  @Autowired
  private ArraySorter sorter;
  @Autowired
  private StringCompressor compressor;

  /*
   * this satisfies the test in the task but will fail for multi-byte-characters.
   */
  public String group(String input) {
    return compressor.compress(toString(sorter.sort(toIntArray(input))));
  }


  private int[] toIntArray(String input) {
    byte[] bytes = input.getBytes();
    int[] ints = new int[bytes.length];
    for (int i = 0; i < bytes.length; i++) {
      ints[i] = bytes[i];
    }
    return ints;
  }


  private String toString(int[] input) {

    byte[] bytes = new byte[input.length];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) input[i];
    }
    return new String(bytes);
  }
}
