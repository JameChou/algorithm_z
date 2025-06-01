public class Test {
    // 判断这个字符串是否为回文字符串
    public boolean judge(String str) {
        int left = 0, right = str.length() - 1;

        while (left <= right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        char c = 'A' + 32;

        System.out.println(c);
    }
}
