import java.util.*;

class Main {
  public static void main(String[] args) {
    // Array =['A', 'B', 'C', 'A', 'C'], K=2 ------- > output = 3
    int result = Main.maxFruitCountOf2Types(new char[] { 'A', 'B', 'C', 'A', 'C' });
    System.out.println("----" + result);
  }

  private static int maxFruitCountOf2Types(char[] input) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
      map.put(input[windowEnd], map.getOrDefault(input[windowEnd], 0) + 1);

      while (map.size() > 2) { // start Shrinking
        map.put(input[windowStart], map.getOrDefault(input[windowStart], 0) - 1);
        if (map.get(input[windowStart]) == 0) {
          map.remove(input[windowStart]);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
}