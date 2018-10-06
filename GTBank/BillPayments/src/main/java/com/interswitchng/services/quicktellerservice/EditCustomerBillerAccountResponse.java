
package com.interswitchng.services.quicktellerservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EditCustomerBillerAccountResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "editCustomerBillerAccountResult"
})
@XmlRootElement(name = "EditCustomerBillerAccountResponse")
public class EditCustomerBillerAccountResponse {

    @XmlElementRef(name = "EditCustomerBillerAccountResult", namespace = "http://services.interswitchng.com/quicktellerservice/", type = JAXBElement.class)
    protected JAXBElement<String> editCustomerBillerAccountResult;

    /**
     * Gets the value of the editCustomerBillerAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEditCustomerBillerAccountResult() {
        return editCustomerBillerAccountResult;
    }

    /**
     * Sets the value of the editCustomerBillerAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEditCustomerBillerAccountResult(JAXBElement<String> value) {
        this.editCustomerBillerAccountResult = ((JAXBElement<String> ) value);
    }

}
