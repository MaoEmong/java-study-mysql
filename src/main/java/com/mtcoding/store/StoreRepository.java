package com.mtcoding.store;

import java.sql.PreparedStatement;
import java.sql.SQLException;

// 요즘은 DAO같이 안부르고 추상적인 Repository로 적음
// store Table DB 전담
public class StoreRepository {

    public int deleteOne(int id) {
        // 1. DBMS와 연결된 소켓
        var conn = DBConnection.getConnection();

        String sql = "delete from store_tb where id=?";
        try {
            // 2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // 3. 쿼리 전송
            int result = pstmt.executeUpdate();

            // 결과값 반환
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int updateOne(int id, String name, int price, int qty) {
        // 1. DBMS와 연결된 소켓
        var conn = DBConnection.getConnection();

        String sql = "update store_tb set name=?, price=?,qty=? where id=?";
        try {
            // 2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);

            // 3. 쿼리 전송
            int result = pstmt.executeUpdate();

            // 결과값 반환
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int insert(int id, String name, int price, int qty) {
        // 1. DBMS와 연결된 소켓
        var conn = DBConnection.getConnection();

        String sql = "insert into store_tb(id, name, price, qty) values(?,?,?,?)";
        try {
            // 2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.setInt(4, qty);

            // 3. 쿼리 전송
            int result = pstmt.executeUpdate();

            // 결과값 반환
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

}
