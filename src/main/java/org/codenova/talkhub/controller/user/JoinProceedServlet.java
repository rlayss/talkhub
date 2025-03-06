package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/user/join-proceed")
public class JoinProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        boolean hasError = false;
        // 검증절차가 필요하면 하면 되고,
        String id = req.getParameter("id");
        if (id.length() <= 4) {
            hasError = true;
            req.setAttribute("idError", "아이디는 4글자 이상입니다.");
        }
        String password = req.getParameter("password");
        if (password.length() < 6) {
            hasError = true;
            req.setAttribute("passwordError", "비밀번호는 4글자 이상입니다.");
        }
        String nickname = req.getParameter("nickname");
        if (nickname.length() < 3) {
            hasError = true;
            req.setAttribute("nicknameError", "활동명은 3글자 이상입니다.");
        }
        String gender = req.getParameter("gender");

        int birth = Integer.parseInt(req.getParameter("birth"));

        UserDAO userDao = new UserDAO();
        User found = userDao.findById(id);
        if (found != null) {
            hasError = true;
            req.setAttribute("idDuplicatedError", "해당아이디는 사용중입니다.");
        }

        // userDao.findByNickname(nickname);

        //============================================================]

        if (hasError) {
            req.getRequestDispatcher("/WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        } else {
            boolean r = userDao.create(id, password, nickname, gender, birth);
            //
            if (r) {
                resp.sendRedirect(req.getContextPath() + "/user/login");
            } else {
                req.setAttribute("dbError", "데이터베이스 연동에 장애가 발생하였습니다.");
                req.getRequestDispatcher("/WEB-INF/views/user/join-fail.jsp").forward(req, resp);
            }
        }
    }
}
