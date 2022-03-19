package com.java.learn_han.chapter14.homework;

import java.util.ArrayList;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧"));
        arrayList.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            //System.out.println(arrayList.get(i));
            News news = (News)arrayList.get(i);
            System.out.println(processTitle(news.getTitle()));
        }

    }
    //专门写一个方法，处理现实新闻标题 process处理
    public static String processTitle(String title) {

        if(title == null) {
            return "";
        }

        if(title.length() > 15) {
            return title.substring(0, 15) + "..."; //[0,15)
        } else {
            return title;
        }

    }
}


class News {
    private String title;
    private String contend;

    public News(String title) {
        this.title = title;
        this.contend = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContend() {
        return contend;
    }

    public void setContend(String contend) {
        this.contend = contend;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}