package br.edu.ifpb.agenda.controllers;



import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/index")
public class LoginServlet extends HttpServlet {

    private final UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserResponse userEmail;
        try{
            userEmail = dao.authorizeAccessByEmail(login, password);
            if (userEmail.getId() != null){
                response.sendRedirect("/agenda/contact?userId="+userEmail.getId());
            }
        }catch (Exception e){
            response.sendRedirect("/agenda/");
        }
    }
}
