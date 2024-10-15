package com.github.programs.interview;

import java.util.Scanner;

public class PrintDiamond {
    public static void main(String[] args) {
        // 例子
        // n = 1
        //   *

        // n = 2
        //   *
        //  * *
        //   *

        // n = 3
        //   *
        //  * *
        // * * *
        //  * *
        //   *


        // System.out.println("请输入n的值");
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int n = 3;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // 打印奇数个"* "即可
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }

            System.out.println(" ");
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 打印奇数个"* "即可
            for (int k = n - i; k > 0; k--) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}
