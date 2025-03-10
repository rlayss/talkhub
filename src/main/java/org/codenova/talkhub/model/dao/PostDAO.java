package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    // 데이터 추가
    public boolean create(Post one) {
        boolean result = false;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into posts values(null, ?, ?, ?, ?, 0, 0, now(), now())");

            ps.setString(1, one.getWriterId());
            ps.setString(2, one.getCategory());
            ps.setString(3, one.getTitle());
            ps.setString(4, one.getContent());

            int r = ps.executeUpdate();
            result = true;  // r값을 확인안하고 result 를 true 로 설정한 이유?

            conn.close();
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;
    }
    // 데이터 찾기 (by Id)
    public Post findById(int postId) {
        Post one = null;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts where id = ?");
            ps.setInt(1, postId);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                one = new Post();
                one.setId(rs.getInt("id"));
                one.setWriterId(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setLikes(rs.getInt("likes"));
                one.setViews(rs.getInt("views"));
                one.setWritedAt(rs.getDate("writed_at"));
                one.setModifiedAt(rs.getDate("modified_at"));
            }
            conn.close();
        }catch(Exception e) {
            System.out.println("UserDAO.create : "+ e.toString() );
        }
        return one;
    }

    // 데이터 찾기 (등록된 전부)
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<Post>();
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts order by id desc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post one = new Post();

                one.setId(rs.getInt("id"));
                one.setWriterId(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setLikes(rs.getInt("likes"));
                one.setViews(rs.getInt("views"));
                one.setWritedAt(rs.getDate("writed_at"));
                one.setModifiedAt(rs.getDate("modified_at"));

                posts.add(one);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("UserDAO.create : " + e.toString());
        }
        return posts;
    }

    // 조회수 증가 (by Id)
    public boolean increaseViewsById(int postId) {
        boolean result = false;
        /*
            try with resources statement
             closable 한 객체를 try 와 함께 생성하면, try 종료시 자동 close()
        */
        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("update posts set views = views + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;
    }

    // 좋아요 증가 (by Id)
    public boolean increaseLikesById(int postId) {
        boolean result = false;
        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("update posts set likes = likes + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;
    }
}



