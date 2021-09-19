package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.AddressDAO;
import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.response.AddressResponse;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddressServlet", value = "/address")
public class AddressServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();
    AddressDAO addressDAO = new AddressDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactId = request.getParameter("contactId");
        String userId = request.getParameter("userId");

        UserResponse userResponse = userDAO.findById(Integer.parseInt(userId));
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(contactId));
        List<AddressResponse> addressResponseList = addressDAO.findByIdUContact(contactResponse.getId());


        request.setAttribute("user", userResponse);
        request.setAttribute("contact", contactResponse);
        request.setAttribute("addressList", addressResponseList);
        RequestDispatcher rd = request.getRequestDispatcher("/address.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String contactId = request.getParameter("contactId");
        String addressId = request.getParameter("addressId");
        addressDAO.deleteById(Integer.parseInt(addressId));
        response.sendRedirect("/agenda/address?contactId="+contactId+"&userId="+userId);

    }
}
