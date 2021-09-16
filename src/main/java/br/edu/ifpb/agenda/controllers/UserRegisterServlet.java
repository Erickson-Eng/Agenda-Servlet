package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.request.UserRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", value = "/register")
public class UserRegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/userRegister.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(request.getParameter("email"));
        userRequest.setUsername(request.getParameter("username"));
        userRequest.setUserPassword(request.getParameter("password"));
        try {
            userDAO.save(userRequest);
            response.sendRedirect("/agenda");
        } catch (Exception e){
            response.sendRedirect("/agenda/register");
        }

    }
}
