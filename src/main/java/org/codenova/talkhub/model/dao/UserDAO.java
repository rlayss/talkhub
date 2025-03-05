package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.User;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/*
    user 테이블에 관련된 DB 작업을 처리하게 될거임.
 */
public class UserDAO {

    // 1. 데이터 등록
    // insert into users values(?, ?, ?, ?, ?, now() )
    public boolean create(String id, String password, String nickname, String gender, int birth) {
        boolean result = false;
        try {

            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, now())");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true;  // r값을 확인안하고 result 를 true 로 설정한 이유?

            conn.close();
        }catch(Exception e) {
            System.out.println("UserDAO.create : "+ e.toString() );
        }

        return result;
    } // end boolean create(String id, String password, .... ) ================================================

    // id로 유저정보 찾기
    // select * from users where id=?
    public User findById(String specificId) {
        User one = null;
        try {
            Connection conn = ConnectionFactory.open();
            PreparedStatement ps = conn.prepareStatement("select * from users where id=?");
            ps.setString(1, specificId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                one = new User();

                one.setId(rs.getString("id"));
                one.setPassword(rs.getString("password"));
                one.setNickname(rs.getString("nickname"));
                one.setGender(rs.getString("gender"));
                one.setBirth(rs.getInt("birth"));
                one.setCreatedAt(rs.getDate("created_at"));
            }
            conn.close();
        }catch(Exception e) {
            System.out.println("UserDAO.findById : "+ e.toString() );
        }
        return one;
    } // end User findById(String specificId) =====================================



}
