package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.request.UserRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditContactServlet", value = "/editContact")
public class EditContactServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String contactId = request.getParameter("contactId");

        UserResponse userResponse = userDAO.findById(Integer.parseInt(userId));
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(contactId));

        request.setAttribute("user", userResponse);
        request.setAttribute("contact", contactResponse);

        RequestDispatcher rd = request.getRequestDispatcher("/editContact.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdParametro = request.getParameter("userId");
        System.out.println(userIdParametro);
        UserResponse user = userDAO.findById(Integer.parseInt(userIdParametro));
        String name = request.getParameter("name");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String idContact = request.getParameter("contactId");
        ContactResponse obj = new ContactResponse();
        obj.setId(Integer.parseInt(idContact));
        obj.setName(name);
        obj.setCpf(cpf);
        obj.setRg(rg);
        obj.setUserResponse(user);
        contactDAO.update(obj);
        response.sendRedirect("/agenda/contact?userId="+userIdParametro);

    }
}
