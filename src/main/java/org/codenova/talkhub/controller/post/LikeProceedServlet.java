package org.codenova.talkhub.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.dao.PostLikeDAO;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/like-proceed")
public class LikeProceedServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));  // 좋아요를 하고 싶은 포스트 아이디
        PostLikeDAO postLikeDAO = new PostLikeDAO();

        User requester = (User) req.getSession().getAttribute("user");   // 현재 요청자의 아이디를 뽑아서
        List<PostLike> likes = postLikeDAO.findByUserId(requester.getId()); // 이 유저가 등록한 좋아요 목록을 가지고 온후

        // 이 포스트아이디를 좋아요 한적이 있는지 찾아야 됨.
        boolean alreadyLiked = false;
        for (PostLike like : likes) {
            if (like.getPostId() == id) {
                alreadyLiked = true;
            }
        }

        // 반복처리가 끝나고 나면, 이미 한적이 있으면 true, 아니면 false 일꺼임
        if (!alreadyLiked) {    // false 라면 좋아요 처리되게 if 처리를 했음.
            PostDAO dao = new PostDAO();
            dao.increaseLikesById(id);  // 좋아요가 올라감.
            /*
            PostLike log = new PostLike();
            log.setPostId(id);
            log.setUserId(requester.getId());
            */
            /*
            PostLike log = new PostLike(-1, requester.getId(), id, null);
            */
            PostLike log = PostLike.builder().postId(id).userId(requester.getId()).build();
            postLikeDAO.create(log);

        }
        resp.sendRedirect(req.getContextPath() + "/post/view?id=" + id);

    }
}



