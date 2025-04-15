import java.util.List;
import java.util.ArrayList;

public class Palindrome {
    public boolean isPalindrome(int x) {
        // 当一个数是小数的时候肯定不是一个回文数
        if (x < 0) {
            return false;
        }

        int index = x;
        int result = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (index > 0) {
            list.add(index % 10);
            index = index / 10;
        }

        for (int i = 1; i <= list.size(); i++) {
            result = result + ((int) Math.pow(10, list.size() - i)) * list.get(i - 1);
        }

        return (result == x);
    }

    public static void main(String[] args) {
        int x = 121;

        boolean result = new Palindrome().isPalindrome(x);
        System.out.println(result);
    }
}
