package com.example.bts_details;

import java.util.ArrayList;

public class BTSData {
    public static String[][] data = new String[][]{
            {"RM", "Leader, Main Rapper", "https://kprofiles.com/wp-content/uploads/2016/04/60455707_127766391752521_8012074291378253404_n-800x800.jpg"},
            {"Jin", "Vocalist, Visual", "https://kprofiles.com/wp-content/uploads/2016/04/61192916_458178384945031_6594293821862247950_n-800x800.jpg"},
            {"Suga", "Lead Rapper", "https://kprofiles.com/wp-content/uploads/2016/04/61247380_358841088322329_2834285147617155982_n-800x800.jpg"},
            {"J-Hope", "Rapper, Sub Vocalist", "https://kprofiles.com/wp-content/uploads/2016/04/60966589_114581619774693_1723860498095699390_n-800x800.jpg"},
            {"Jimin", "Main Dancer, Lead Vocalist", "https://kprofiles.com/wp-content/uploads/2016/04/60915577_135079684339430_5668053873970009278_n-800x800.jpg"},
            {"V", "Lead Dancer, Vocalist", "https://kprofiles.com/wp-content/uploads/2016/04/60060167_2445047042382826_3461446397192836949_n-800x800.jpg"},
            {"Jungkook", "Center, Maknae", "https://kprofiles.com/wp-content/uploads/2016/04/60051433_2026494394312603_1202753138946712320_n-800x800.jpg"}
    };

    public static ArrayList<BTS> getListData(){
        BTS bts = null;
        ArrayList<BTS> list = new ArrayList<>();
        for (String[] aData : data) {
            bts = new BTS();
            bts.setName(aData[0]);
            bts.setRemarks(aData[1]);
            bts.setPhoto(aData[2]);

            list.add(bts);
        }

        return list;
    }
}
