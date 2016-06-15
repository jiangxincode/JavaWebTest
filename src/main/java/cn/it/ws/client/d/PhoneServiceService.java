
package cn.it.ws.client.d;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PhoneServiceService", targetNamespace = "http://d.ws.it.cn/", wsdlLocation = "http://127.0.0.1:8888/ws/phoneService?WSDL")
public class PhoneServiceService
    extends Service
{

    private final static URL PHONESERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException PHONESERVICESERVICE_EXCEPTION;
    private final static QName PHONESERVICESERVICE_QNAME = new QName("http://d.ws.it.cn/", "PhoneServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8888/ws/phoneService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PHONESERVICESERVICE_WSDL_LOCATION = url;
        PHONESERVICESERVICE_EXCEPTION = e;
    }

    public PhoneServiceService() {
        super(__getWsdlLocation(), PHONESERVICESERVICE_QNAME);
    }

    public PhoneServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PHONESERVICESERVICE_QNAME, features);
    }

    public PhoneServiceService(URL wsdlLocation) {
        super(wsdlLocation, PHONESERVICESERVICE_QNAME);
    }

    public PhoneServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PHONESERVICESERVICE_QNAME, features);
    }

    public PhoneServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PhoneServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PhoneService
     */
    @WebEndpoint(name = "PhoneServicePort")
    public PhoneService getPhoneServicePort() {
        return super.getPort(new QName("http://d.ws.it.cn/", "PhoneServicePort"), PhoneService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PhoneService
     */
    @WebEndpoint(name = "PhoneServicePort")
    public PhoneService getPhoneServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://d.ws.it.cn/", "PhoneServicePort"), PhoneService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PHONESERVICESERVICE_EXCEPTION!= null) {
            throw PHONESERVICESERVICE_EXCEPTION;
        }
        return PHONESERVICESERVICE_WSDL_LOCATION;
    }

}
