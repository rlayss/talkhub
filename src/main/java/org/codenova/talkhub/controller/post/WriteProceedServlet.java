package org.codenova.talkhub.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/post/write-proceed")
public class WriteProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User)req.getSession().getAttribute("user");

        String writerId = currentUser.getId();
        String title= req.getParameter("title");
        String category = req.getParameter("category");
        String content = req.getParameter("content");

        Post post = new Post();
        post.setTitle(title);
        post.setCategory(category);
        post.setContent(content);
        post.setWriterId(writerId);

        PostDAO postDAO = new PostDAO();
        boolean result = postDAO.create(post);

        if(result) {
            resp.sendRedirect(req.getContextPath() + "/post/list");
        }else {
            req.getRequestDispatcher("/WEB-INF/view/post/write-error.jsp").forward(req, resp);
        }

    }
}

