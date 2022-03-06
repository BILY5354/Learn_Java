package com.java.learn_han.shi_xi;

import java.io.*;

public class DeleteEnter {

    private static String resultFP = "D:\\WorkSpace\\Learn_Java\\myCode\\Learn_Java_code\\src\\com\\java\\learn_han\\shi_xi\\result";
    private static StringBuffer sbf;
    private static int i = 0;

    public static String textToString(File file) {

        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                i++;
                result = result + " " + s;
                if (i == 3) {
                    i = 0;
                    result += "\n";
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter(resultFP);
            fWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        File file = new File("D:\\WorkSpace\\Learn_Java\\myCode\\Learn_Java_code\\src\\com\\java\\learn_han\\shi_xi\\text");
        System.out.println(textToString(file));
    }
}
