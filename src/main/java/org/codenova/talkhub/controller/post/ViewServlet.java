package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.dao.PostLikeDAO;
import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));  // 글번호 뽑고

        PostDAO dao = new PostDAO();

        boolean r = dao.increaseViewsById(id);  // 조회수 증가시키고
        Post one = dao.findById(id);    // Post 찾아오고

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



        if(one == null) {
            resp.sendRedirect(req.getContextPath()+"/post/list");
        }else {
            req.setAttribute("post", one);
            req.setAttribute("alreadyLiked", alreadyLiked);
            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req, resp);
        }


    }
}

