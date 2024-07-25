package com.github.generic;





import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 许章雨航
 * @version 1.0
 * @since 2024-07-14
 */
public class TestGeneric {

    /**
     * @param coll 无法覆盖所有场景
     */
    public static void m2(Collection coll) {
        for (Object o : coll) {
            System.out.println("o = " + o);
        }
    }

    @Test
    public void test() {
        // 编译看左边，左边泛型擦除，此时泛型按照 Object 处理，右边泛型指定也没有用
        m2(new ArrayList<Object>()); // 相当于 Collection coll = new ArrayList<Object>();
        m2(new ArrayList<>()); // 相当于 Collection coll = new ArrayList<>(); 和上面的是等价的
        m2(new ArrayList()); // 相当于 Collection coll = new ArrayList(); 泛型擦除
        m2(new ArrayList<String>()); // 相当于 Collection coll = new ArrayList<String>();
    }
}