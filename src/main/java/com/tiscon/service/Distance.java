package com.tiscon.service;

/**
 * 緯度経度から距離を求めるクラス
 *
 */

public class Distance {
    public static void main(String[] args) {
        // 計算サンプル
        System.out.println(getDistance(35.1730990, 136.883466, 35.1855732, 136.899092));
        System.out.println(getDistance(35.1855732, 136.899092, 35.1730990, 136.883466));
    }

    // 球面三角法により、大円距離(メートル)を求める
    public static Integer getDistance(double lat1, double lng1, double lat2, double lng2) {

        // 緯度経度をラジアンに変換
        double rlat1 = Math.toRadians(lat1);
        double rlng1 = Math.toRadians(lng1);
        double rlat2 = Math.toRadians(lat2);
        double rlng2 = Math.toRadians(lng2);

        // 2点の中心角(ラジアン)を求める
        double a =
                Math.sin(rlat1) * Math.sin(rlat2) +
                        Math.cos(rlat1) * Math.cos(rlat2) *
                                Math.cos(rlng1 - rlng2);
        double rr = Math.acos(a);

        // 地球赤道半径(メートル)
        double earth_radius = 6378140;

        // 2点間の距離(kmメートル）
        return (int)(earth_radius * rr / 1000);
    }


}
