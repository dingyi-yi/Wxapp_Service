package com.Wxapp.utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StrJaccard {


    public static double gainStrJaccard(String str1,String str2)
    {
        //set元素不可重复
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            //将string里面的元素一个一个按索引放进set集合
            s1.add(str1.charAt(i));
        }
        for (int j = 0; j < str2.length(); j++) {
            s2.add(str2.charAt(j));
        }
        //并集元素个数
        double mergeNum = 0;
        //相同元素个数（交集）
        double commonNum = 0;

        for(Character ch1:s1) {
            for(Character ch2:s2) {
                if(ch1.equals(ch2)) {
                    commonNum++;
                }
            }
        }

        mergeNum = s1.size()+s2.size()-commonNum;

        double jaccard = commonNum/mergeNum;
        return jaccard;

    }


}