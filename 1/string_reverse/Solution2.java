public class Solution2 {

    /**
     * 三步反转
     * @param args
     */
    public static void main(String[] args) {
        String str = "hello world!";
        System.out.println(rotateString(str,4));

    }

    /**
     * 把字符串m到n的位置反转
     * @param string
     * @return
     */
    public static String reverseString(String string,int m, int n) {
        char[] cString = string.toCharArray();

        while (m < n) {
            char temp = cString[m];
            //第一个值被最后一个覆盖，然后移动m到下一个值
            cString[m++] = cString[n];
            //最后一个值被第一个覆盖，向前移动
            cString[n--] = temp;
        }
        return String.valueOf(cString);
    }

    public static String rotateString(String str, int m) {
        //m = m % length, 如果移动的位置数量超过长度，则相当于一个环旋转
        // 3 % 5 = 3， 小于字符串长度则没有问题
        m %= str.length();
        //反转第一部分
        str = reverseString(str,0, m);
        //反转第二部分
        str = reverseString(str, m, str.length() - 1);
        //整体反转
        str = reverseString(str, 0, str.length() - 1);

        return str;

    }
}