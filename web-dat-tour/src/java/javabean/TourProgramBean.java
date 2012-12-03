package javabean;

//  @ Project : web-dat-tour

import java.util.*;

//  @ File Name : TourProgramBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourProgramBean {
        private  String TourProgramId;
	private  String TourProgramName;
	private  String Notice;
	private  String Transportation;
	private  String Include;
	private  String Exclude;
	private  String PaymentCondition;
        private ArrayList<ItineraryBean> Itineraries;

    /**
     * @return the TourProgramId
     */
    public String getTourProgramId() {
        return TourProgramId;
    }

    /**
     * @param TourProgramId the TourProgramId to set
     */
    public void setTourProgramId(String TourProgramId) {
        this.TourProgramId = TourProgramId;
    }

    /**
     * @return the TourProgramName
     */
    public String getTourProgramName() {
        return TourProgramName;
    }

    /**
     * @param TourProgramName the TourProgramName to set
     */
    public void setTourProgramName(String TourProgramName) {
        this.TourProgramName = TourProgramName;
    }

    /**
     * @return the Notice
     */
    public String getNotice() {
        return Notice;
    }

    /**
     * @param Notice the Notice to set
     */
    public void setNotice(String Notice) {
        this.Notice = Notice;
    }

    /**
     * @return the Transportation
     */
    public String getTransportation() {
        return Transportation;
    }

    /**
     * @param Transportation the Transportation to set
     */
    public void setTransportation(String Transportation) {
        this.Transportation = Transportation;
    }

    /**
     * @return the Include
     */
    public String getInclude() {
        return Include;
    }

    /**
     * @param Include the Include to set
     */
    public void setInclude(String Include) {
        this.Include = Include;
    }

    /**
     * @return the Exclude
     */
    public String getExclude() {
        return Exclude;
    }

    /**
     * @param Exclude the Exclude to set
     */
    public void setExclude(String Exclude) {
        this.Exclude = Exclude;
    }

    /**
     * @return the PaymentCondition
     */
    public String getPaymentCondition() {
        return PaymentCondition;
    }

    /**
     * @param PaymentCondition the PaymentCondition to set
     */
    public void setPaymentCondition(String PaymentCondition) {
        this.PaymentCondition = PaymentCondition;
    }

    /**
     * @return the Itineraries
     */
    public List<ItineraryBean> getItineraries() {
        return Itineraries;
    }

    /**
     * @param Itineraries the Itineraries to set
     */
    public void setItineraries(ArrayList<ItineraryBean> Itineraries) {
        this.Itineraries = Itineraries;
    }

}
