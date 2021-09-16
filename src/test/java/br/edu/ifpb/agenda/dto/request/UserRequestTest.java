package br.edu.ifpb.agenda.dto.request;

import org.junit.Assert;
import org.junit.Test;


public class UserRequestTest {
    @Test
    public void userTest(){
        UserRequest request = new UserRequest();
        UserRequest request1 = new UserRequest();
        UserRequest request2 = new UserRequest();

        //valores validos
        request.setUsername("erickson");
        request.setUserPassword("1546*Eri");
        request.setEmail("Erickson.tulio_rodrigues@gmail.com");
        Assert.assertEquals("erickson",request.getUsername());
        Assert.assertEquals("Erickson.tulio_rodrigues@gmail.com",request.getEmail());
        Assert.assertEquals("1546*Eri", request.getUserPassword());


        //valores invalidos

        //valores para primeira requisição
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request1.setUsername("Erickson!");
        });
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request1.setEmail("erickson@@gmail.com");
        });
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request1.setUserPassword("erick23");
        });

        //valor para segunda requisição
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request2.setUsername("123erickson");
        });
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request2.setEmail("erick!son@gmail.com");
        });
        Assert.assertThrows(IllegalArgumentException.class, () ->{
            request2.setUserPassword("erick123");
        });


    }
}
