package javabean;

//  @ Project : web-dat-tour
//  @ File Name : ItineraryBean.java
//  @ Date : 06/11/2012
//  @ Author : An Tran
//
//




public class ItineraryBean {
        private String TourProgramId;
	private  int Day;
	private  String Detail;
	private  String Image;

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
     * @return the Day
     */
    public int getDay() {
        return Day;
    }

    /**
     * @param Day the Day to set
     */
    public void setDay(int Day) {
        this.Day = Day;
    }

    /**
     * @return the Detail
     */
    public String getDetail() {
        return Detail;
    }

    /**
     * @param Detail the Detail to set
     */
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    /**
     * @return the Image
     */
    public String getImage() {
        return Image;
    }

    /**
     * @param Image the Image to set
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

 
}
