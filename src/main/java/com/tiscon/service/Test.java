package com.tiscon.service;

import java.io.IOException;


/**
 * 郵便番号の検索APIクラスであるPostalCodeServiceの使い方
 *
 */

public class Test {
    public static void main(String[] args){
        PostalCodeService pcs = new PostalCodeService();
        Response response1;
        Response response2;


        try {
            // 埼玉県さいたま市の住所を取得
            response1 = pcs.getResponse("3300854");
            System.out.println(response1.getPrefecture());
            System.out.println(response1.getCity());
            System.out.println(response1.getLatitude());
            System.out.println(response1.getLongitude());

            // 埼玉県所沢市の住所を取得
            response2 = pcs.getResponse("3590000");

            int dis = Distance.getDistance(response1.getLatitude(), response1.getLongitude(), response2.getLatitude(), response2.getLongitude());
            System.out.println(dis);
        } catch (IOException e) {
            // networkによるエラー発生時
            e.printStackTrace();
        } catch (Exception e) {
            // 存在しない郵便番号が入力された時
            System.out.println("存在しない郵便番号です！");
        }
    }
}