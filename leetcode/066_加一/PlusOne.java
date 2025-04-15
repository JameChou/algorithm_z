
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int rtnArray[];

        boolean flag = false;

        for (int i = digits.length - 1; i >= 0; i--) {
            // 从后往前取
            int number = digits[i];
            number++;

            if (number == 10) {
                // 已经查找到最前面了
                digits[i] = 0;
                if (i == 0) {
                    flag = true;
                    break;
                } else {
                    continue;
                }
            } else {
                digits[i] = number;
                break;
            }
        }

        // 表明一直加到了最前面
        if (flag) {
            rtnArray = new int[digits.length + 1];

            rtnArray[0] = 1;
            for (int i = 1; i < rtnArray.length; i++) {
                rtnArray[i] = 0;
            }
        } else {
            rtnArray = new int[digits.length];

            for (int i = 0; i < digits.length; i++) {
                rtnArray[i] = digits[i];
            }
        }

        return rtnArray;
    }

    public static void main(String[] args) {
        int array[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int rtnArray[] = new PlusOne().plusOne(array);
        for (int num : rtnArray) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
