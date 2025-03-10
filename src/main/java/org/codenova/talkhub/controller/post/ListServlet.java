package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.vo.Post;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO dao = new PostDAO();
        List<Post> posts = dao.findAll();
        req.setAttribute("posts", posts);

        req.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(req, resp);
    }
}

