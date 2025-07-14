package algorithm;

public class RabinKarp {
    /**
     * Rabin-Karp 算法，这个算法主要是为了找寻 str 这个字符串是否含有 subText这个子串
     * 
     * @param str     父串
     * @param subText 子串
     * @return 返回找到子串的第一个字符所在位置
     */
    public static int rabinKarp(String str, String subText) {
        int R = 256;
        int L = subText.length();
        // 较大的素数进行取模操作，防止int溢出
        int Q = 1658598167;
        int RL = 1;
        // 算出RL值，也需要进行取模操作
        for (int i = 1; i <= L - 1; i++) {
            RL = (RL * R) % Q;
        }

        // 下一步计算需要查找的字符串hash值
        long subTextHash = 0;
        for (int i = 0; i < subText.length(); i++) {
            subTextHash = (R * subTextHash + subText.charAt(i)) % Q;
        }

        long windowHash = 0;

        int left = 0, right = 0;
        while (right < str.length()) {
            windowHash = ((R * windowHash) % Q + str.charAt(right)) % Q;
            right++;
            if (right - left == L) {
                // 根据哈希值判断是否匹配模式串
                if (windowHash == subTextHash) {
                    // 当前窗口中的子串哈希值等于模式串的哈希值
                    // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                    if (subText.equals(str.substring(left, right))) {
                        return left;
                    }
                }

                // 缩小窗口，移出字符
                windowHash = (windowHash - (str.charAt(left) * RL) % Q + Q) % Q;

                // X % Q == (X + Q) % Q 是一个模运算法则
                // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
                // 所以额外再加一个 Q，保证 windowHash 不会是负数

                left++;
            }
        }
        // 没有找到模式串
        return -1;

    }

    public static void main(String[] args) {
        String str = "abcZZZddef";

        int index = rabinKarp(str, "dd");
        System.out.println(index);

    }

}
