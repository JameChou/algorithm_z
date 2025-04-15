import java.util.List;
import java.util.ArrayList;

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        String rtn = "";
        boolean breakFlag = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= rtn.length()) {
                    breakFlag = true;
                    break;
                }
                // 表明并不相等这时候就应该跳出
                if (strs[j].charAt(i) != c) {
                    breakFlag = true;
                    break;
                }
            }

            if (breakFlag) {
                break;
            }
            rtn += c;
        }

        return rtn;
    }

    public static void main(String[] args) {
        String strs[] = { "flower", "flow", "flow" };

        String prefix = new LongestPrefix().longestCommonPrefix(strs);
        System.out.println(prefix);

    }
}
