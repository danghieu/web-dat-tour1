package javabean;

import java.util.Date;

//  @ Project : web-dat-tour
//  @ File Name : TourContact.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourContact {
	private  Date assigndate;
        private Traveller traveller;
        private ContactPerson contactperson;

    /**
     * @return the assigndate
     */
    public Date getAssigndate() {
        return assigndate;
    }

    /**
     * @param assigndate the assigndate to set
     */
    public void setAssigndate(Date assigndate) {
        this.assigndate = assigndate;
    }

    /**
     * @return the traveller
     */
    public Traveller getTraveller() {
        return traveller;
    }

    /**
     * @param traveller the traveller to set
     */
    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    /**
     * @return the contactperson
     */
    public ContactPerson getContactperson() {
        return contactperson;
    }

    /**
     * @param contactperson the contactperson to set
     */
    public void setContactperson(ContactPerson contactperson) {
        this.contactperson = contactperson;
    }
}
