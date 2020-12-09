package com.Wxapp.dao;

public class ComQualification {
    String bName;
    String bAdd;
    String legalRepre;
    String ship;
    String LicenseNo;
    String Rating;
    String specialBrand;
    String scope;
    String remarks;
    double longitude;
    double latitude;
    double distance;

    public ComQualification(String bName, String bAdd, String legalRepre, String ship, String
                            licenseNo, String rating, String specialBrand,
                            String scope, String remarks, double longitude, double latitude,
                            double distance) {
        this.bName = bName;
        this.bAdd = bAdd;
        this.legalRepre = legalRepre;
        this.ship = ship;
        LicenseNo = licenseNo;
        Rating = rating;
        this.specialBrand = specialBrand;
        this.scope = scope;
        this.remarks = remarks;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance=distance;
   }

    public ComQualification(String bName, String bAdd, String legalRepre, String ship, String licenseNo,
                            String rating, String specialBrand, String scope, String remarks,
                            double longitude, double latitude) {
        this.bName = bName;
        this.bAdd = bAdd;
        this.legalRepre = legalRepre;
        this.ship = ship;
        LicenseNo = licenseNo;
        Rating = rating;
        this.specialBrand = specialBrand;
        this.scope = scope;
        this.remarks = remarks;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public ComQualification() {
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

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
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

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

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
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}