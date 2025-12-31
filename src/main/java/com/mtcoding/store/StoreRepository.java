package com.mtcoding.store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 요즘은 DAO같이 안부르고 추상적인 Repository로 적음
// store Table DB 전담
public class StoreRepository {
    //  개념     =    DB  =   HTTP
    // Read(All) = Select = Get
    public List<Store> selectAll() {
        var conn = DBConnection.getConnection();
        String sql = "select * from store_tb order by id desc";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 조회해서 view로 응답 받기
            ResultSet rs = pstmt.executeQuery();

            List<Store> list = new ArrayList<>();

            // 행이 존재한다면 프로잭션한다 (열 선택하기)
            while (rs.next()) {
                // rs -> 자바오브젝트 파싱
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");

                Store store = new Store(c1,c2,c3,c4);
                list.add(store);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    // Read(One) = Select = Get
    public Store selectOne(int id) {
        var conn = DBConnection.getConnection();
        String sql = "select * from store_tb where id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // 조회해서 view로 응답 받기
            ResultSet rs = pstmt.executeQuery();

            // 커서 한칸 내리기
            boolean isRow = rs.next();

            // 행이 존재한다면 프로잭션한다 (열 선택하기)
            if (isRow) {
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");

                Store store = new Store(c1,c2,c3,c4);
                return store;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    // Delete(Write) = Delete = Delete
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
    // Update(Write) = Update = Put
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
    // Create(Write) = Insert = Post
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
