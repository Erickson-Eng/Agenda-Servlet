package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactServlet", value = "/contact")
public class ContactServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        List<ContactResponse> contactResponseList = contactDAO.listAll(Integer.parseInt(userId));
        UserResponse userResponse = userDAO.findById(Integer.parseInt(userId));

        request.setAttribute("user", userResponse);
        request.setAttribute("contactList", contactResponseList);
        RequestDispatcher rd = request.getRequestDispatcher("/contact.jsp");
        rd.forward(request,response);
    }
}
