package javabean;

import java.util.*;

//  @ Project : web-dat-tour
//  @ File Name : TourBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourBean {
        private String TourId;
        private TourProgramBean TourProgram;
	private  Date startdate;
        private String startplace;
        private String endplace;
	private  int maxpeople;
	private  long basiccharge;
	private  long surcharge;
        private long airportcharge;
        private long singleroomsurcharge;
        private long visasurcharge;
        private long kidcharge;
        private long infantcharge;

    /**
     * @return the TourId
     */
    public String getTourId() {
        return TourId;
    }

    /**
     * @param TourId the TourId to set
     */
    public void setTourId(String TourId) {
        this.TourId = TourId;
    }

    /**
     * @return the TourProgram
     */
    public TourProgramBean getTourProgram() {
        return TourProgram;
    }

    /**
     * @param TourProgram the TourProgram to set
     */
    public void setTourProgram(TourProgramBean TourProgram) {
        this.TourProgram = TourProgram;
    }

    /**
     * @return the startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return the startplace
     */
    public String getStartplace() {
        return startplace;
    }

    /**
     * @param startplace the startplace to set
     */
    public void setStartplace(String startplace) {
        this.startplace = startplace;
    }

    /**
     * @return the endplace
     */
    public String getEndplace() {
        return endplace;
    }

    /**
     * @param endplace the endplace to set
     */
    public void setEndplace(String endplace) {
        this.endplace = endplace;
    }

    /**
     * @return the maxpeople
     */
    public int getMaxpeople() {
        return maxpeople;
    }

    /**
     * @param maxpeople the maxpeople to set
     */
    public void setMaxpeople(int maxpeople) {
        this.maxpeople = maxpeople;
    }

    /**
     * @return the basiccharge
     */
    public long getBasiccharge() {
        return basiccharge;
    }

    /**
     * @param basiccharge the basiccharge to set
     */
    public void setBasiccharge(long basiccharge) {
        this.basiccharge = basiccharge;
    }

    /**
     * @return the surcharge
     */
    public long getSurcharge() {
        return surcharge;
    }

    /**
     * @param surcharge the surcharge to set
     */
    public void setSurcharge(long surcharge) {
        this.surcharge = surcharge;
    }

    /**
     * @return the airportcharge
     */
    public long getAirportcharge() {
        return airportcharge;
    }

    /**
     * @param airportcharge the airportcharge to set
     */
    public void setAirportcharge(long airportcharge) {
        this.airportcharge = airportcharge;
    }

    /**
     * @return the singleroomsurcharge
     */
    public long getSingleroomsurcharge() {
        return singleroomsurcharge;
    }

    /**
     * @param singleroomsurcharge the singleroomsurcharge to set
     */
    public void setSingleroomsurcharge(long singleroomsurcharge) {
        this.singleroomsurcharge = singleroomsurcharge;
    }

    /**
     * @return the visasurcharge
     */
    public long getVisasurcharge() {
        return visasurcharge;
    }

    /**
     * @param visasurcharge the visasurcharge to set
     */
    public void setVisasurcharge(long visasurcharge) {
        this.visasurcharge = visasurcharge;
    }

    /**
     * @return the kidcharge
     */
    public long getKidcharge() {
        return kidcharge;
    }

    /**
     * @param kidcharge the kidcharge to set
     */
    public void setKidcharge(long kidcharge) {
        this.kidcharge = kidcharge;
    }

    /**
     * @return the infantcharge
     */
    public long getInfantcharge() {
        return infantcharge;
    }

    /**
     * @param infantcharge the infantcharge to set
     */
    public void setInfantcharge(long infantcharge) {
        this.infantcharge = infantcharge;
    }


    
}
