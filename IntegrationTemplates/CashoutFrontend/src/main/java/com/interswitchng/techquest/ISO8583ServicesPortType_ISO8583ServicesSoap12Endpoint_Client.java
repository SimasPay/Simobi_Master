
package com.interswitchng.techquest;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2012-07-27T12:41:42.517+05:30
 * Generated source version: 2.6.1
 * 
 */
public final class ISO8583ServicesPortType_ISO8583ServicesSoap12Endpoint_Client {

    private static final QName SERVICE_NAME = new QName("http://techquest.interswitchng.com/", "InterswitchServices");

    private ISO8583ServicesPortType_ISO8583ServicesSoap12Endpoint_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = InterswitchServices.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        InterswitchServices ss = new InterswitchServices(wsdlURL, SERVICE_NAME);
        ISO8583ServicesPortType port = ss.getISO8583ServicesSoap12Endpoint();  
        
        {
        System.out.println("Invoking iso8583PostXml...");
        com.interswitchng.techquest.Iso8583PostXml _iso8583PostXml_parametersVal = null;
        javax.xml.ws.Holder<com.interswitchng.techquest.Iso8583PostXml> _iso8583PostXml_parameters = new javax.xml.ws.Holder<com.interswitchng.techquest.Iso8583PostXml>(_iso8583PostXml_parametersVal);
        port.iso8583PostXml(_iso8583PostXml_parameters);

        System.out.println("iso8583PostXml._iso8583PostXml_parameters=" + _iso8583PostXml_parameters.value);

        }

        System.exit(0);
    }

}
