import java.util.Set;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        Set<Character> sets = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            sets = new HashSet<Character>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (sets.contains(c)) {
                    if (max < sets.size()) {
                        max = sets.size();
                    }
                    sets = new HashSet<Character>();
                }
                sets.add(c);
            }

            if (max < sets.size()) {
                max = sets.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "au";

        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
