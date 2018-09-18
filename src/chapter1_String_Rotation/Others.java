package chapter1_String_Rotation;

/**
 * @Author: codefog
 * @email: at20s@sina.com
 * @Date: 2018/9/18 1:50 PM
 */
public class Others {

    /**
     * 反转句子中的单词
     * @param args
     */
    public static void main(String[] args) {
        String str = "i am quite a student.";
        System.out.println(rotateString(str));

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

    public static String rotateString(String str) {
        //以空格分割，正则表达
        String[] spString = str.split("\\s+");
        str = "";
        //分别反转分割后的字符串
        if (spString.length > 0) {
            for (int i = 0; i < spString.length; ++i) {
                spString[i] = reverseString(spString[i],0,spString[i].length() - 1);
                //拼接完整字符串
                str += " " + spString[i];
            }
        }
        //总体旋转
        str = reverseString(str, 0, str.length() - 1);

        return str;
    }

}