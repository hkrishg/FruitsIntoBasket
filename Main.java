import java.util.*;

class Main {


//   Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

// You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

// Write a function to return the maximum number of fruits in both the baskets.

// Example 1:

// Input: Fruit=['A', 'B', 'C', 'A', 'C']
// Output: 3
// Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
// Example 2:

// Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
// Output: 5
// Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
// This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']



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

    public static void main(String[] args) {
    int result = Main.maxFruitCountOf2Types(new char[] { 'A', 'B', 'C', 'A', 'C' });
    System.out.println("----" + result);
  }
}