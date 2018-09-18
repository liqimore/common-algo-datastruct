import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input_Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("读取一行数字：");
        String oneLine = sc.nextLine();
        String[] cs = oneLine.split(" ");
        for (String x : cs) {
            int intValue = Integer.valueOf(x);
            System.out.print(intValue + " ");
        }

        System.out.println("读取n行数字：");
        int lines = 3;
        String[] mutiLines = new String[3];
        int i = 0;
        while (i < lines) {
            mutiLines[i++] = sc.nextLine();
        }
        for (String s : mutiLines) {
            System.out.println(s);
        }

        System.out.println("输入多行数字：");
        List<String> list = new ArrayList<>();

        String input = "";
        while (true) {
            input = sc.nextLine();
            if (!input.equals("q")) {
                list.add(input);
            }else {
                break;
            }
        }
        for (String s : list) {
            //只能转换一行一个数字，多个数字需要额外同上的操作
            //int intValue = Integer.valueOf(s);
            System.out.println(s);
        }



    }

}