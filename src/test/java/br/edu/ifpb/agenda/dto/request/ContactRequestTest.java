package br.edu.ifpb.agenda.dto.request;

import junit.framework.TestCase;
import org.junit.Assert;

public class ContactRequestTest extends TestCase {

    public void testName() {
        ContactRequest contactRequest = new ContactRequest();
        ContactRequest contactRequestNull = new ContactRequest();

        contactRequest.setName("Erickson Túlio Rodrigues Azêvedo");
        Assert.assertEquals("Erickson Túlio Rodrigues Azêvedo",contactRequest.getName());

        contactRequestNull.setName("123Erickson");
        Assert.assertNull(contactRequestNull.getName());

    }

    public void testCPF() {

        ContactRequest contactRequest = new ContactRequest();
        ContactRequest contactRequestNull = new ContactRequest();

        contactRequest.setCpf("123.313.321-44");
        Assert.assertEquals("123.313.321-44", contactRequest.getCpf());

        contactRequestNull.setCpf("131.313.3333-41");
        Assert.assertNull(contactRequestNull.getCpf());
    }

    public void testRG() {
        ContactRequest contactRequest = new ContactRequest();
        ContactRequest contactRequestNull = new ContactRequest();

        contactRequest.setRg("3.123.132");
        contactRequestNull.setRg("31231234");
        Assert.assertEquals("3.123.132",contactRequest.getRg());
        Assert.assertNull(contactRequestNull.getRg());
    }
}
