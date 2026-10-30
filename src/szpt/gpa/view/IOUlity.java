package szpt.gpa.view;
import java.util.Scanner;

public class IOUlity {
    public static Scanner input=new Scanner(System.in);

    public static int readMainMenu() {
        int menu = 0;
        while (true) {
            if (input.hasNextInt()) {
                menu = input.nextInt();
                if (menu >= 1 && menu <= 5)
                    return menu;
                else
                    System.out.println("请输入1~5:");
            } else {
                System.out.println("请输入数字选项:");
                input.next(); // 清除无效输入
            }
        }
    }

    public static int readCourseMenu() {
        int menu = 0;
        while (true) {
            if (input.hasNextInt()) {
                menu = input.nextInt();
                if (menu >= 1 && menu <= 3)
                    return menu;
                else
                    System.out.println("请输入1~3:");
            } else {
                System.out.println("请输入数字选项:");
                input.next(); // 清除无效输入
            }
        }
    }


    public static int readIndex() {
        int index = -1;
        index = input.nextInt();
        return index;
    }

    public static String readStudentData() {
        String str = input.next();
        return str;
    }

    public static double readScore() {
        return input.nextDouble();
    }
    public static String readlevel() {
        return input.next();
    }
}
