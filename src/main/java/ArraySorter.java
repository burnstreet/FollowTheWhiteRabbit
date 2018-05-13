import java.util.Arrays;
import org.springframework.context.annotation.Bean;


public class ArraySorter {

  public int[] sort(int[] unsorted) {
    int[] copy = Arrays.copyOf(unsorted, unsorted.length);
    Arrays.sort(copy);
    return copy;
  }
}
