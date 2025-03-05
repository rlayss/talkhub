package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.UserDAO;

import java.io.IOException;

@WebServlet("/user/join-proceed")
public class JoinProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        int birth = Integer.parseInt(req.getParameter("birth"));
        // 검증절차가 필요하면 하면 되고,


        UserDAO userDao = new UserDAO();
        boolean r = userDao.create(id, password, nickname, gender, birth);

        //
        if(r) {
            resp.sendRedirect(req.getContextPath() + "/index");
        }else {
            req.getRequestDispatcher("/WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        }


    }
}