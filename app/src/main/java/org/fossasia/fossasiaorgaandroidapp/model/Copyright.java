
package org.fossasia.fossasiaorgaandroidapp.model;


import com.google.gson.annotations.SerializedName;

public class Copyright {

    @SerializedName("holder")
    private String mHolder;
    @SerializedName("holder_url")
    private String mHolderUrl;
    @SerializedName("licence")
    private String mLicence;
    @SerializedName("licence_url")
    private String mLicenceUrl;
    @SerializedName("logo")
    private String mLogo;
    @SerializedName("year")
    private Long mYear;

    public String getHolder() {
        return mHolder;
    }

    public void setHolder(String holder) {
        mHolder = holder;
    }

    public String getHolderUrl() {
        return mHolderUrl;
    }

    public void setHolderUrl(String holderUrl) {
        mHolderUrl = holderUrl;
    }

    public String getLicence() {
        return mLicence;
    }

    public void setLicence(String licence) {
        mLicence = licence;
    }

    public String getLicenceUrl() {
        return mLicenceUrl;
    }

    public void setLicenceUrl(String licenceUrl) {
        mLicenceUrl = licenceUrl;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public Long getYear() {
        return mYear;
    }

    public void setYear(Long year) {
        mYear = year;
    }

}
