/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

/**
 *
 * @author AT
 */
public class AdsBean {
    private String AdsID;
    private String Link;
    private String Image;
    private String Caption;

    /**
     * @return the Link
     */
    public String getLink() {
        return Link;
    }

    /**
     * @param Link the Link to set
     */
    public void setLink(String Link) {
        this.Link = Link;
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

    /**
     * @return the Caption
     */
    public String getCaption() {
        return Caption;
    }

    /**
     * @param Caption the Caption to set
     */
    public void setCaption(String Caption) {
        this.Caption = Caption;
    }

    /**
     * @return the AdsID
     */
    public String getAdsID() {
        return AdsID;
    }

    /**
     * @param AdsID the AdsID to set
     */
    public void setAdsID(String AdsID) {
        this.AdsID = AdsID;
    }
}
