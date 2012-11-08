package javabean;

import java.util.Date;

//  @ Project : web-dat-tour
//  @ File Name : TourContactBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourContactBean {
	private  Date assigndate;
        private TravellerBean traveller;
        private ContactPersonBean contactperson;

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
    public TravellerBean getTraveller() {
        return traveller;
    }

    /**
     * @param traveller the traveller to set
     */
    public void setTraveller(TravellerBean traveller) {
        this.traveller = traveller;
    }

    /**
     * @return the contactperson
     */
    public ContactPersonBean getContactperson() {
        return contactperson;
    }

    /**
     * @param contactperson the contactperson to set
     */
    public void setContactperson(ContactPersonBean contactperson) {
        this.contactperson = contactperson;
    }
}
