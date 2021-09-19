package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.AddressDAO;
import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.mapper.ContactMapper;
import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewAddressServlet", value = "/newAddress")
public class NewAddressServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();
    AddressDAO addressDAO = new AddressDAO();
    ContactMapper mapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserResponse userResponse = userDAO.findById(Integer.parseInt(request.getParameter("userId")));
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(request.getParameter("contactId")));

        request.setAttribute("user", userResponse);
        request.setAttribute("contact", contactResponse);

        RequestDispatcher rd = request.getRequestDispatcher("/newAddress.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactResponse contactResponse = contactDAO.findById(Integer.parseInt(request.getParameter("contactId")));
        AddressRequest addressRequest = new AddressRequest();
        ContactRequest contactRequest = mapper.INSTANCE.responseToRequest(contactResponse);

        addressRequest.setStreet(request.getParameter("street"));
        addressRequest.setNumber(Integer.parseInt(request.getParameter("number")));
        addressRequest.setComplement(request.getParameter("complement"));
        addressRequest.setDistrict(request.getParameter("district"));
        addressRequest.setCep(request.getParameter("cep"));
        addressRequest.setCity(request.getParameter("city"));
        addressRequest.setState(request.getParameter("state"));
        addressRequest.setContactRequest(contactRequest);

        addressDAO.update(addressRequest);

        response.sendRedirect("/agenda/address?" +
                "contactId="+request.getParameter("contactId")+
                "&userId="+request.getParameter("userId"));


    }
}
