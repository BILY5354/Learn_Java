package com.java.learn_han.shi_xi;

import java.io.*;

public class appendQNAN {

    private static String resultFP = "D:\\WorkSpace\\Learn_Java\\myCode\\Learn_Java_code\\src\\com\\java\\learn_han\\shi_xi\\result";
    private static StringBuffer sbf;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\WorkSpace\\Learn_Java\\myCode\\Learn_Java_code\\src\\com\\java\\learn_han\\shi_xi\\text"));
            String temp = null;
            sbf = new StringBuffer();
            while ((temp = br.readLine()) != null) {

                sbf.append(temp).append(" 1.#QNAN 1.#QNAN\n");
            }
            br.close();
            System.out.println(sbf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter(resultFP);
            fWriter.write(sbf.toString());
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
    }
}
