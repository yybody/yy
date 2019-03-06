package com.yy.Util;

import com.yy.POJO.BuyerItem;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/11 0011-下午 8:34
 */
public class jsonUtil {

    public static List<BuyerItem> jsons(JSONArray j, ArrayList<BuyerItem> a){

        String str = j.toString();


        BuyerItem[] buyerItems = (BuyerItem[]) JSONArray.toArray(j,BuyerItem.class);
        for (BuyerItem b :buyerItems){
            a.add(b);

            System.out.println(b.getAmount()+"www");}


         return a;



    }

}
