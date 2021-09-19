package br.edu.ifpb.agenda.controllers;

import br.edu.ifpb.agenda.dao.AddressDAO;
import br.edu.ifpb.agenda.dao.ContactDAO;
import br.edu.ifpb.agenda.dao.UserDAO;
import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewContactServlet", value = "/newContact")
public class NewContactServlet extends HttpServlet {

    ContactDAO contactDAO = new ContactDAO();
    UserDAO userDAO = new UserDAO();
    AddressDAO addressDAO = new AddressDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        UserResponse userResponse = userDAO.findById(Integer.parseInt(userId));
        request.setAttribute("user", userResponse);
        RequestDispatcher rd = request.getRequestDispatcher("/newContact.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserResponse userResponse = userDAO.findById(Integer.parseInt(request.getParameter("userId")));
        AddressRequest addressRequest = new AddressRequest();
        ContactRequest contactRequest = new ContactRequest();

        String name = request.getParameter("name");
        String rg =  request.getParameter("rg");
        String cpf =request.getParameter("cpf");
        //address
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String complement = request.getParameter("complement");
        String district = request.getParameter("district");
        String cep = request.getParameter("cep");
        String city = request.getParameter("city");
        String state = request.getParameter("state");


        contactRequest.setName(name);
        contactRequest.setRg(rg);
        contactRequest.setCpf(cpf);
        contactRequest.setUserResponse(userResponse);
        // address
        addressRequest.setContactRequest(contactRequest);
        addressRequest.setStreet(street);
        addressRequest.setNumber(Integer.parseInt(number));
        addressRequest.setComplement(complement);
        addressRequest.setDistrict(district);
        addressRequest.setCep(cep);
        addressRequest.setCity(city);
        addressRequest.setState(state);
        //save
        addressDAO.save(addressRequest);
        response.sendRedirect("/agenda/contact?userId="+userResponse.getId());
    }
}
