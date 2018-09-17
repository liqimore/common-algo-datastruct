package string_reverse;

/**
 * @Author: codefog
 * @email: at20s@sina.com
 * @Date: 2018/9/17 10:44 PM
 */
public class Solution1 {


    /**
     * 暴力一次一个字符的移动
     * 时间复杂度O(nm),空间O(1) (长度为n，移动m个字符）
     * @param args
     */
    public static void main(String[] args) {
        String str = "hello world!";
        System.out.println(rotateString(str,3));

    }

    public static String shifting(String str) {

        char[] strs = str.toCharArray();
        char temp = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            //从第一个开始，一次被后一个字符覆盖
            strs[i - 1] = strs[i];
        }
        strs[strs.length - 1] = temp;
        return String.valueOf(strs);
    }

    public static String rotateString(String string, int m) {
        while (m > 0) {
            string = shifting(string);
            m--;
        }
        return string;
    }



}
