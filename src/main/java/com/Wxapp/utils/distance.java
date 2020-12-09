package com.Wxapp.utils;

public class distance{

    private static final  double EARTH_RADIUS = 6371000;//赤道半径(单位m)
    private static final  double INTEGR_NUM = 10000;
    /**
     * 基于googleMap中的算法得到两经纬度之间的距离,误差 <= 0.2m
     * @param lat1 第一点的精度
     * @param lng1 第一点的纬度
     * @param lat2 第二点的精度
     * @param lng2 第二点的纬度
     * @return 返回的距离，单位m
     * */

    public static double distance(double lat1, double lng1, double lat2, double lng2) {
        double x1 = Math.cos(lat1) * Math.cos(lng1);
        double y1 = Math.cos(lat1) * Math.sin(lng1);
        double z1 = Math.sin(lat1);
        double x2 = Math.cos(lat2) * Math.cos(lng2);
        double y2 = Math.cos(lat2) * Math.sin(lng2);
        double z2 = Math.sin(lat2);
        double lineDistance =
                Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
        double s = EARTH_RADIUS * Math.PI * 2 * Math.asin(0.5 * lineDistance) / 180;
        return Math.round(s * INTEGR_NUM) / INTEGR_NUM;
    }

}