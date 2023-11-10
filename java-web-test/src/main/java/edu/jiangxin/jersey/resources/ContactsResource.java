package edu.jiangxin.jersey.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import edu.jiangxin.jersey.bean.Address;
import edu.jiangxin.jersey.bean.Contact;
import edu.jiangxin.jersey.storage.ContactStore;


@Path("/contacts")
public class ContactsResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Contact> getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll( ContactStore.getStore().values() );
		return contacts;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ContactStore.getStore().size();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newContact(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		Contact c = new Contact(id,name,new ArrayList<Address>());
		ContactStore.getStore().put(id, c);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		Response.created(uri).build();
		
		servletResponse.sendRedirect("../pages/new_contact.html");
	}
	
	@Path("{contact}")
	public ContactResource getContact(
			@PathParam("contact") String contact) {
		return new ContactResource(uriInfo, request, contact);
	}
	
}
