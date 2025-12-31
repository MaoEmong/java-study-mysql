package com.mtcoding.store;

import java.util.ArrayList;
import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
        StoreRepository repo = new StoreRepository();
//        int result = repo.insert(3,"감자",1000,2);
//        System.out.println("결과 : " + result);

//        int result = repo.updateOne(1,"고구마",2000,100);
//        System.out.println("결과 : " + result);

//        int result = repo.deleteOne(1);
//        System.out.println("결과 : " + result);

//        Store store = repo.selectOne(2);
//        System.out.println(store);  // 객체의 레퍼런스 변수를 호출하면 toString()이 자동 호출된다

        List<Store> list = new ArrayList<>();
        list = repo.selectAll();
        for(var n : list)
            System.out.println(n);
    }
}
