package com.example.bts_details;

import java.util.ArrayList;

public class BTSDetailData {
    public static String[][] data = new String[][]{
            {"rm", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-01_profil-member-bts_rap-monster_800x450_ccpdm-min.jpg"},
            {"jin", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-02_profil-member-bts_jin_800x450_ccpdm-min.jpg"},
            {"suga", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-03_profil-member-bts_suga_800x450_ccpdm-min.jpg"},
            {"j-Hope", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-04_profil-member-bts_j-hope_800x450_ccpdm-min.jpg"},
            {"jimin", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-05_profil-member-bts_jimin_800x450_ccpdm-min.jpg"},
            {"v", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-06_profil-member-bts_v_800x450_ccpdm-min.jpg"},
            {"Jungkook", "https://www.kepogaul.com/wp-content/uploads/2017/09/bts-07_profil-member-bts_jungkook_800x450_ccpdm-min.jpg"}
    };

    public static ArrayList<BTS> getListData(){
        BTS bts = null;
        ArrayList<BTS> list = new ArrayList<>();
        for (String[] aData : data) {
            bts = new BTS();
            bts.setName(aData[0]);
            bts.setPhoto(aData[1]);

            list.add(bts);
        }

        return list;
    }
}
