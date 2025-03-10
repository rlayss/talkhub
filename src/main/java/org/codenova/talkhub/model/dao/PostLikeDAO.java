package org.codenova.talkhub.model.dao;


import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostLikeDAO {
    public boolean create(PostLike one) {
        boolean result = false;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into post_likes values(null, ?, ?,  now() )");

            ps.setString(1, one.getUserId());
            ps.setInt(2, one.getPostId());

            int r = ps.executeUpdate();
            result = true;  // r값을 확인안하고 result 를 true 로 설정한 이유?

            conn.close();
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;
    }

    // 데이터 찾기 (등록된 전부)
    public List<PostLike> findByUserId(String userId) {
        List<PostLike> result = new ArrayList<>();
        try (Connection conn = ConnectionFactory.open()){
            PreparedStatement ps = conn.prepareStatement("select * from post_likes where user_id = ? order by created_at desc\n");
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostLike one = new PostLike();

                one.setId(rs.getInt("id"));
                one.setUserId(rs.getString("userId"));
                one.setPostId(rs.getInt("postId"));
                one.setCreatedAt(rs.getDate("createdAt"));

                result.add(one);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("UserDAO.create : " + e.toString());
        }
        return result;
    }
}