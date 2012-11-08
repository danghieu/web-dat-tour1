package javabean;

import java.util.*;

//  @ Project : web-dat-tour
//  @ File Name : TourBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class TourBean {
	private  Date startdate;
	private  double time;
	private  int maxpeople;
	private  long cost;
	private  long childrencost;
        private List<TourContactBean> tourcontact;

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
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
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
     * @return the cost
     */
    public long getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(long cost) {
        this.cost = cost;
    }

    /**
     * @return the childrencost
     */
    public long getChildrencost() {
        return childrencost;
    }

    /**
     * @param childrencost the childrencost to set
     */
    public void setChildrencost(long childrencost) {
        this.childrencost = childrencost;
    }

    /**
     * @return the tourcontact
     */
    public List<TourContactBean> getTourcontact() {
        return tourcontact;
    }

    /**
     * @param tourcontact the tourcontact to set
     */
    public void setTourcontact(List<TourContactBean> tourcontact) {
        this.tourcontact = tourcontact;
    }
}
