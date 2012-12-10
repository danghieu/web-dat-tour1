/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

import java.util.Date;

/**
 *
 * @author AT
 */
public class SearchBean {
    private String TourName;
    private Date StartDate;
    private String StartPlace;
    private String EndPlace;
    private long ChargeFrom;
    private long ChargeTo;

    /**
     * @return the TourName
     */
    public String getTourName() {
        return TourName;
    }

    /**
     * @param TourName the TourName to set
     */
    public void setTourName(String TourName) {
        this.TourName = TourName;
    }

    /**
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the StartPlace
     */
    public String getStartPlace() {
        return StartPlace;
    }

    /**
     * @param StartPlace the StartPlace to set
     */
    public void setStartPlace(String StartPlace) {
        this.StartPlace = StartPlace;
    }


    /**
     * @return the ChargeFrom
     */
    public long getChargeFrom() {
        return ChargeFrom;
    }

    /**
     * @param ChargeFrom the ChargeFrom to set
     */
    public void setChargeFrom(long ChargeFrom) {
        this.ChargeFrom = ChargeFrom;
    }

    /**
     * @return the ChargeTo
     */
    public long getChargeTo() {
        return ChargeTo;
    }

    /**
     * @param ChargeTo the ChargeTo to set
     */
    public void setChargeTo(long ChargeTo) {
        this.ChargeTo = ChargeTo;
    }

    /**
     * @return the EndPlace
     */
    public String getEndPlace() {
        return EndPlace;
    }

    /**
     * @param EndPlace the EndPlace to set
     */
    public void setEndPlace(String EndPlace) {
        this.EndPlace = EndPlace;
    }
}
