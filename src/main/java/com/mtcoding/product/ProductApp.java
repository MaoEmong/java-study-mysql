package com.mtcoding.product;

public class ProductApp {
    public static void main(String[] args) {
        var repo = new ProductRepository();

        int iResult = repo.insert(1,"신발",1000,5);
        System.out.println("결과 : "+iResult);
//        iResult = repo.insert(2,"자켓",10000,2);
//        System.out.println("결과 : "+iResult);
//        iResult = repo.insert(3,"벨트",8000,7);
//        System.out.println("결과 : "+iResult);

        int uResult = repo.updateOne("가방",5000,8,2);
        System.out.println("결과 : "+uResult);

//        int dResult = repo.deleteOne(1);
//        System.out.println("결과 : "+dResult);

    }
}
