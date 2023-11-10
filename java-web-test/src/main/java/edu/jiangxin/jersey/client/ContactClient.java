package edu.jiangxin.jersey.client;

import edu.jiangxin.jersey.bean.Address;
import edu.jiangxin.jersey.bean.Contact;
import edu.jiangxin.utils.PropertyUtils;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import java.util.Arrays;
import java.util.List;

public class ContactClient {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(PropertyUtils.getProperty("http.url") + "/rest/contacts");
		
		System.out.println("===== Get huangyim =====");
		getOneContact(webTarget, "huangyim");
		
		System.out.println("===== Create foo =====");
		postForm(webTarget, "foo", "bar");
		
		Address[] addresses = {
			new Address("Shanghai", "Ke Yuan Street")
		};
		Contact cnt = new Contact("guoqing", "Guo Qing", Arrays.asList(addresses));
		
		System.out.println("===== Create guoqing =====");
		putOneContact(webTarget, cnt);
		
		System.out.println("===== All Contacts =====");
		getContacts(webTarget);
		
		System.out.println("===== Delete foo =====");
		deleteOneContact(webTarget, "foo");
		
		System.out.println("===== All Contacts =====");
		getContacts(webTarget);
	}
	
	public static void getContacts(WebTarget webTarget) {
		
		// 1, get response as plain text
		String jsonRes = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(jsonRes);
		
		String xmlRes = webTarget.request(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlRes);
		
		// 2, get response and headers etc, wrapped in ClientResponse
		Response response = webTarget.request().get(Response.class);
		System.out.println( response.getStatus() );
		System.out.println( response.getMetadata().get("Content-Type") );
		Object entity = response.getEntity();
		System.out.println(entity);

		// 3, get JAXB response
		GenericType<List<Contact>> genericType = new GenericType<List<Contact>>() {};
		List<Contact> contacts = webTarget.request(MediaType.APPLICATION_XML).get(genericType);
		System.out.println("No. of Contacts: " + contacts.size());
		Contact contact = contacts.get(0);
		System.out.println(contact.getId() + ": " + contact.getName());
	}
	
	public static void getOneContact(WebTarget webTarget, String id) {
		GenericType<JAXBElement<Contact>> generic = new GenericType<JAXBElement<Contact>>() {};
		JAXBElement<Contact> jaxbContact = webTarget.path(id).request(MediaType.APPLICATION_XML).get(generic);
		Contact contact = jaxbContact.getValue();
		System.out.println(contact.getId() + ": " + contact.getName());
	}
	
	public static void postForm(WebTarget r, String id, String name) {
		Form form = new Form();
		form.param("id", id);
		form.param("name", name);
		Response response = r.request(MediaType.APPLICATION_FORM_URLENCODED)
								   .post(Entity.form(form), Response.class);
		Object entity = response.getEntity();
		System.out.println(entity);
	}
	
	public static void putOneContact(WebTarget r, Contact c) {
		Response response = r.path(c.getId()).request(MediaType.APPLICATION_XML)
								   .put(Entity.entity(c, MediaType.APPLICATION_XML), Response.class);
		System.out.println(response.getStatus());
	}
	
	public static void deleteOneContact(WebTarget r, String id) {
		Response response = r.path(id).request().delete(Response.class);
		System.out.println(response.getStatus());
	}
}
