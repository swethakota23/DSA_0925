import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            int find = (int) Math.ceil((double) success / spells[i]);
            int idx = binaryS(potions, find);
            ans[i] = potions.length - idx;
        }
        
        return ans;
    }

    private int binaryS(int[] potions, int find) {
        int low = 0, high = potions.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] < find) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
