package com.wzs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodApplicationTests {

    @Test
    void contextLoads() {

        System.out.println((32 >>> 4));

       /*
        32 1  16   /2    2的1
        32 2  8    /4    4的2
        32 3  4    /8+
        */

    }

}
