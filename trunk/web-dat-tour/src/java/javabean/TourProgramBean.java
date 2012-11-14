package javabean;

//  @ Project : web-dat-tour

import java.util.*;

//  @ File Name : TourProgramBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourProgramBean {
        private String tourprogramid;
	private  String tourname;
	private  String description;
	private  String destination;
	private  String hotel;
	private  String transportation;
	private  String include;
	private  String exclude;
	private  String notice;
	private  String normailcancel;
	private  String specialcancel;
	private  String paymentcondition;
        private List<Iterable> iterable;
        private List<TourBean> tour;

    /**
     * @return the tourname
     */
    public String getTourname() {
        return tourname;
    }

    /**
     * @param tourname the tourname to set
     */
    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * @return the transportation
     */
    public String getTransportation() {
        return transportation;
    }

    /**
     * @param transportation the transportation to set
     */
    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    /**
     * @return the include
     */
    public String getInclude() {
        return include;
    }

    /**
     * @param include the include to set
     */
    public void setInclude(String include) {
        this.include = include;
    }

    /**
     * @return the exclude
     */
    public String getExclude() {
        return exclude;
    }

    /**
     * @param exclude the exclude to set
     */
    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    /**
     * @return the notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     * @param notice the notice to set
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * @return the normailcancel
     */
    public String getNormailcancel() {
        return normailcancel;
    }

    /**
     * @param normailcancel the normailcancel to set
     */
    public void setNormailcancel(String normailcancel) {
        this.normailcancel = normailcancel;
    }

    /**
     * @return the specialcancel
     */
    public String getSpecialcancel() {
        return specialcancel;
    }

    /**
     * @param specialcancel the specialcancel to set
     */
    public void setSpecialcancel(String specialcancel) {
        this.specialcancel = specialcancel;
    }

    /**
     * @return the paymentcondition
     */
    public String getPaymentcondition() {
        return paymentcondition;
    }

    /**
     * @param paymentcondition the paymentcondition to set
     */
    public void setPaymentcondition(String paymentcondition) {
        this.paymentcondition = paymentcondition;
    }

    /**
     * @return the iterable
     */
    public List<Iterable> getIterable() {
        return iterable;
    }

    /**
     * @param iterable the iterable to set
     */
    public void setIterable(List<Iterable> iterable) {
        this.iterable = iterable;
    }

    /**
     * @return the tour
     */
    public List<TourBean> getTour() {
        return tour;
    }

    /**
     * @param tour the tour to set
     */
    public void setTour(List<TourBean> tour) {
        this.tour = tour;
    }

    /**
     * @return the tourprogramid
     */
    public String getTourprogramid() {
        return tourprogramid;
    }

    /**
     * @param tourprogramid the tourprogramid to set
     */
    public void setTourprogramid(String tourprogramid) {
        this.tourprogramid = tourprogramid;
    }
}
