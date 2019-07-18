package com.ljq;

import java.util.Scanner;

/**
 * @author LJQ
 * @date 2019/7/18 11:21
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.next();
            str = str.replace("吗", "");
            str = str.replace("?", "!");
            str = str.replace("?", "!");
            System.out.println(str);
        }
    }
}
