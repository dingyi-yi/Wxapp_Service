package com.Wxapp.dao.merchantdao;

import org.springframework.stereotype.Component;

@Component
public class ComQualification {
    String OpenId;
    String bName;
    String bAdd;
    String legalRepre;
    String ship;
    String LicenseNo;
    int Rating;
    String specialBrand;
    String scope;
    String remarks;
    double lon;
    double lat;
    double distance;

    public ComQualification(String openId, String bName, String bAdd, String legalRepre, String ship,
                            String licenseNo, int rating, String specialBrand,
                            String scope, String remarks, double lon, double lat, double distance) {
        OpenId = openId;
        this.bName = bName;
        this.bAdd = bAdd;
        this.legalRepre = legalRepre;
        this.ship = ship;
        LicenseNo = licenseNo;
        Rating = rating;
        this.specialBrand = specialBrand;
        this.scope = scope;
        this.remarks = remarks;
        this.lon = lon;
        this.lat = lat;
        this.distance = distance;
    }

    public ComQualification() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAdd() {
        return bAdd;
    }

    public void setbAdd(String bAdd) {
        this.bAdd = bAdd;
    }

    public String getLegalRepre() {
        return legalRepre;
    }

    public void setLegalRepre(String legalRepre) {
        this.legalRepre = legalRepre;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        LicenseNo = licenseNo;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getSpecialBrand() {
        return specialBrand;
    }

    public void setSpecialBrand(String specialBrand) {
        this.specialBrand = specialBrand;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getDistance() { return distance; }

    public void setDistance(double distance) { this.distance = distance; }

    @Override
    public String toString() {
        return "ComQualification{" +
                "bName='" + bName + '\'' +
                ", bAdd='" + bAdd + '\'' +
                ", legalRepre='" + legalRepre + '\'' +
                ", ship='" + ship + '\'' +
                ", LicenseNo='" + LicenseNo + '\'' +
                ", Rating='" + Rating + '\'' +
                ", specialBrand='" + specialBrand + '\'' +
                ", scope='" + scope + '\'' +
                ", remarks='" + remarks + '\'' +
                ", longitude='" + lon + '\'' +
                ", latitude='" + lat + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}