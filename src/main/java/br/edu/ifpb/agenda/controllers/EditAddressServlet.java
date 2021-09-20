package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.AddressDAO;
import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.mapper.ContactMapper;
import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.response.AddressResponse;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAddressServlet", value = "/editAddress")
public class EditAddressServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();
    AddressDAO addressDAO = new AddressDAO();
    ContactMapper mapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserResponse userResponse = userDAO.findById(Integer.parseInt(request.getParameter("userId")));
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(request.getParameter("contactId")));
        AddressResponse addressResponse = addressDAO.findById(Integer.parseInt(request.getParameter("addressId")));

        request.setAttribute("user", userResponse);
        request.setAttribute("contact", contactResponse);
        request.setAttribute("address", addressResponse);

        RequestDispatcher rd = request.getRequestDispatcher("/editAddress.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddressRequest obj = new AddressRequest();
        String userId = request.getParameter("userId");
        String contactId = request.getParameter("contactId");
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(contactId));


        obj.setStreet(request.getParameter("street"));
        obj.setNumber(Integer.parseInt(request.getParameter("number")));
        obj.setComplement(request.getParameter("complement"));
        obj.setDistrict(request.getParameter("district"));
        obj.setCep(request.getParameter("cep"));
        obj.setCity(request.getParameter("city"));
        obj.setState(request.getParameter("state"));
        obj.setId(Integer.parseInt(request.getParameter("addressId")));
        obj.setContactRequest(mapper.INSTANCE.responseToRequest(contactResponse));
        addressDAO.update(obj);

        response.sendRedirect("/agenda/address?" +
                "contactId="+request.getParameter("contactId")+
                "&userId="+request.getParameter("userId"));
    }
}