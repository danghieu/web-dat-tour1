package javabean;

//  @ Project : web-dat-tour

import java.util.Date;

//  @ File Name : TravellerBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TravellerBean {
        private String TravellerId;
	private String Name;
	private Date Birthday;
	private String Gender;
	private String Address;
        private boolean SingleRoom;
        private String ClientType;

    /**
     * @return the TravellerId
     */
    public String getTravellerId() {
        return TravellerId;
    }

    /**
     * @param TravellerId the TravellerId to set
     */
    public void setTravellerId(String TravellerId) {
        this.TravellerId = TravellerId;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Birthday
     */
    public Date getBirthday() {
        return Birthday;
    }

    /**
     * @param Birthday the Birthday to set
     */
    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the SingleRoom
     */
    public boolean isSingleRoom() {
        return SingleRoom;
    }

    /**
     * @param SingleRoom the SingleRoom to set
     */
    public void setSingleRoom(boolean SingleRoom) {
        this.SingleRoom = SingleRoom;
    }

    /**
     * @return the ClientType
     */
    public String getClientType() {
        return ClientType;
    }

    /**
     * @param ClientType the ClientType to set
     */
    public void setClientType(String ClientType) {
        this.ClientType = ClientType;
    }

 }
