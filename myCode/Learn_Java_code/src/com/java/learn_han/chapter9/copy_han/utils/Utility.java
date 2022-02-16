package com.java.learn_han.chapter9.copy_han.utils;

import java.util.Scanner;

/**
 * 工具类的作用:
 * 处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入。
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 功能： 读取一个字符串
     *
     * @param limit       读取的长度
     * @param blankReturn 如果为true ,表示 可以读空字符串。
     *                    如果为false表示 不能读空字符串。
     *                    如果输入为空，或者输入大于limit的长度，就会提示重新输入。
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {

        String line = "";

        while (scanner.hasNextLine()) { //判断是否有下一行
            line = scanner.nextLine();//读取这一行

            if (line.length() == 0) {//如果line.length=0, 即用户没有输入任何内容，直接回车
                if (blankReturn) return line;//如果blankReturn=true,可以返回空串
                else continue;//如果blankReturn=false,不接受空串，必须输入内容
            }

            //如果用户输入的内容大于了 limit，就提示重写输入，符合则接收
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不可大于" + limit + "）错误：请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

    /**
     * 功能：读取键盘输入的整型，长度小于2位
     * @return 整数
     */
    public static int readInt() {
        int n;
        for (;;) {
            String str = readKeyBoard(10,false);
            try {
                n = Integer.parseInt(str);//将字符串转换成整数
                break;
            }catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 功能：读取键盘输入的 整数或默认值，如果直接回车，则返回默认值，否则返回输入的整数
     * @param defaultValue 指定的默认值
     * @return 整数或默认值
     */
    public static int readInt(int defaultValue) {
        int n;
        for (;;) {
            String str = readKeyBoard(10,true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }


    /**
     * 功能：读取键盘输入的指定长度的字符串
     *
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     *
     * @param limit        限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;//如果没有输入任何东西（直接回车）则默认值
    }
}
