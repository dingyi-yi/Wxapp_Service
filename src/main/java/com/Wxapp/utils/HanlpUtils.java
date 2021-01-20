package com.Wxapp.utils;


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;


import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HanlpUtils {
    public static double hanlpUtis(String content1, String content2)  {

        /*
        //获取关键词
        List<String> keywordList1 = getSplitWords(content1);
        List<String> keywordList2 = getSplitWords(content2);


        //合并关键词
        List<String> total = mergeList(keywordList1, keywordList2);
        //计算词频
        int[] list1 = statistic(total, keywordList1);
        int[] list2 = statistic(total, keywordList2);
        System.out.print("[");
        for (int i = 0; i < list1.length; i++) {

        }

        for (int i = 0; i < list2.length; i++) {

        }

        Double num = getSimilarity(list1, list2);
        return num;
        *
         */
        return CoreSynonymDictionary.similarity(content1,content2);
    }

    private static List<String> getSplitWords(String sentence) {
        return HanLP.extractKeyword(sentence, 5);
    }


    private static List<String> mergeList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<String>();
        result.addAll(list1);
        result.addAll(list2);
        System.out.println(result);
        //去掉重复元素
        for  ( int  i  =   0 ; i  <  result.size()  -   1 ; i ++ )  {
            for  ( int  j  =  result.size()  -   1 ; j  >  i; j -- )  {
                if  (result.get(j).equals(result.get(i)))  {
                    result.remove(j);
                }
            }
        }
        System.out.println(result);
        return result;
        //return result.stream().distinct().collect(Collectors.toList());
    }

    private static int[] statistic(List<String> allWords, List<String> sentWords) {
        int[] result = new int[allWords.size()];
        for (int i = 0; i < allWords.size(); i++) {
            result[i] = Collections.frequency(sentWords, allWords.get(i));
        }
        return result;
    }


    //计算余弦值
    public static double getSimilarity(int[] statistic1, int[] statistic2) {
        double dividend = 0;
        double divisor1 = 0;
        double divisor2 = 0;
        for (int i = 0; i < statistic1.length; i++) {
            dividend += statistic1[i] * statistic2[i];
            divisor1 += Math.pow(statistic1[i], 2);
            divisor2 += Math.pow(statistic2[i], 2);
        }

        return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));
    }
    //转换为百分比
    public String toNumber(double num){
        NumberFormat number = NumberFormat.getPercentInstance();
        number.setMaximumIntegerDigits(3);
        number.setMaximumFractionDigits(2);
        return number.format(num);
    }



}
