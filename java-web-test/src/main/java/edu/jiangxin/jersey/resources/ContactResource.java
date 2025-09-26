package edu.jiangxin.jersey.resources;

import java.util.ArrayList;
import java.util.Map;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.JAXBElement;

import edu.jiangxin.jersey.bean.Address;
import edu.jiangxin.jersey.bean.Contact;
import edu.jiangxin.jersey.storage.ContactStore;
import edu.jiangxin.jersey.util.ParamUtil;

public class ContactResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String contact;
	
	public ContactResource(UriInfo uriInfo, Request request, String contact) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.contact = contact;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Contact getContact() {
		Contact cont = ContactStore.getStore().get(contact);
		if(cont==null)
			throw new NotFoundException("No such Contact.");
		return cont;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putContact(JAXBElement<Contact> jaxbContact) {
		Contact c = jaxbContact.getValue();
		return putAndGetResponse(c);
	}
	
	@PUT
	public Response putContact(@Context HttpHeaders herders, byte[] in) {
		Map<String,String> params = ParamUtil.parse(new String(in));
		Contact c = new Contact(params.get("id"), params.get("name"), 
				new ArrayList<Address>());
		return putAndGetResponse(c);
	}
	
	private Response putAndGetResponse(Contact c) {
		Response res;
		if(ContactStore.getStore().containsKey(c.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		ContactStore.getStore().put(c.getId(), c);
		return res;
	}
	
	@DELETE
	public void deleteContact() {
		Contact c = ContactStore.getStore().remove(contact);
		if(c==null)
			throw new NotFoundException("No such Contact.");
	}
}
