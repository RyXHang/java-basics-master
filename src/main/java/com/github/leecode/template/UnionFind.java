package com.github.leecode.template;
import java.util.*;

public class UnionFind {
    static int n, m;
    static int N = 100010;
    static int[] p = new int[N];

    public static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]); // 路径压缩
        return p[x];
    }

    public static void merge(int index1, int index2) {
        int parent1 = find(index1);
        int parent2 = find(index2);
        if (parent1 != parent2) {
            p[parent1] = parent2; // 合并两个集合
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) p[i] = i;

        String opt;
        int a, b;
        while (m-- > 0) {
            opt = sc.next();
            a = sc.nextInt();
            b = sc.nextInt();
            if (opt.equals("M")) {
                merge(a, b);
            } else {
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
