
/*
 * 
 */

package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.2.10
 * Fri Jun 28 15:52:13 IST 2013
 * Generated source version: 2.2.10
 * 
 */


@WebServiceClient(name = "Service", 
                  wsdlLocation = "file:/D:/MFinoWorkspace/main/Fortis/FRSCFines/src/main/resources/wsdl/FRSCFinesCollection.wsdl",
                  targetNamespace = "http://tempuri.org/") 
public class Service extends javax.xml.ws.Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://tempuri.org/", "Service");
    public final static QName BasicHttpBindingIService = new QName("http://tempuri.org/", "BasicHttpBinding_IService");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/MFinoWorkspace/main/Fortis/FRSCFines/src/main/resources/wsdl/FRSCFinesCollection.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/MFinoWorkspace/main/Fortis/FRSCFines/src/main/resources/wsdl/FRSCFinesCollection.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns IService
     */
    @WebEndpoint(name = "BasicHttpBinding_IService")
    public IService getBasicHttpBindingIService() {
        return super.getPort(BasicHttpBindingIService, IService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IService
     */
    @WebEndpoint(name = "BasicHttpBinding_IService")
    public IService getBasicHttpBindingIService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIService, IService.class, features);
    }

}
