package javabean;

import java.util.Date;

//  @ Project : web-dat-tour
//  @ File Name : TourContactBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourContactBean {
        private String TourContactId;
	private Date AssignDate;
        private TravellerBean Traveller;
        private UserBean UserName;
        private TourBean Tour;

    /**
     * @return the TourContactId
     */
    public String getTourContactId() {
        return TourContactId;
    }

    /**
     * @param TourContactId the TourContactId to set
     */
    public void setTourContactId(String TourContactId) {
        this.TourContactId = TourContactId;
    }

    /**
     * @return the AssignDate
     */
    public Date getAssignDate() {
        return AssignDate;
    }

    /**
     * @param AssignDate the AssignDate to set
     */
    public void setAssignDate(Date AssignDate) {
        this.AssignDate = AssignDate;
    }

    /**
     * @return the Traveller
     */
    public TravellerBean getTraveller() {
        return Traveller;
    }

    /**
     * @param Traveller the Traveller to set
     */
    public void setTraveller(TravellerBean Traveller) {
        this.Traveller = Traveller;
    }

    /**
     * @return the UserName
     */
    public UserBean getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(UserBean UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the TourId
     */
    public TourBean getTour() {
        return Tour;
    }

    /**
     * @param TourId the TourId to set
     */
    public void setTour(TourBean Tour) {
        this.Tour = Tour;
    }

}
