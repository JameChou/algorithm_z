public class AddBinary {
    /**
     * @a 第一个二进制数
     * @b 第二个二进制数
     */
    public String addBinary(String a, String b) {

        // 现在的想法是一个指针从右向左进行处理
        int aCursor = a.length() - 1;
        int bCursor = b.length() - 1;

        String str = "";

        int forward = 0;
        while (aCursor >= 0 && bCursor >= 0) {

            int num1 = a.charAt(aCursor) - '0';
            int num2 = b.charAt(bCursor) - '0';

            if ((num1 + num2 + forward) == 2) {
                // 向前进位
                str = "0" + str;
                forward = 1;
            } else if ((num1 + num2 + forward) == 3) {
                str = "1" + str;
                forward = 1;
            } else {
                str = (num1 + num2 + forward) + str;
                forward = 0;
            }

            // 指针向左移动
            aCursor--;
            bCursor--;
        }

        if (aCursor == bCursor) {
            if (forward == 1) {
                return forward + str;
            } else {
                return str;
            }
        }

        int cursor = 0;
        String tempStr = "";
        if (aCursor >= 0 && bCursor < 0) {
            cursor = aCursor;
            tempStr = a;
        } else if (aCursor < 0 && bCursor >= 0) {
            cursor = bCursor;
            tempStr = b;
        }

        while (cursor >= 0) {

            int num = tempStr.charAt(cursor) - '0';

            if ((num + forward) == 2) {
                // 向前进位
                str = "0" + str;
                forward = 1;
            } else {
                str = (num + forward) + str;
                forward = 0;
            }

            // 指针向左移动
            cursor--;
        }

        if (forward == 1) {
            str = "1" + str;
        }

        return str;
    }

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";

        // 得到预期结果是 110
        String str = new AddBinary().addBinary(a, b);
        System.out.println(str);
    }
}
