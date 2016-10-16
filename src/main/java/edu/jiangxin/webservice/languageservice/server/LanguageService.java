package edu.jiangxin.webservice.languageservice.server;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="languageManager", targetNamespace="languageservice.webservice.jiangxin.edu")
public interface LanguageService {
	public @WebResult(name="language")String getLanguage(@WebParam(name="position")int position);

}