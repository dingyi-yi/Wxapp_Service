package com.Wxapp.utils;

import com.Wxapp.dao.merchantdao.PriceStandard;

import java.util.ArrayList;
import java.util.List;

public class AveragePriceUtil {

    public static int GainAverage(PriceStandard priceStandard)
    {
        int total=0;
        int AveragePriceStandard=0;
        List<Integer> ints=new ArrayList<>();
        if (priceStandard.getSpecialGrade()>0)
        {
            ints.add(priceStandard.getSpecialGrade());
        }
        if (priceStandard.getFirstLevel()>0)
        {
            ints.add(priceStandard.getFirstLevel());
        }
        if (priceStandard.getSecondLevel()>0)
        {
            ints.add(priceStandard.getSecondLevel());
        }
        if (priceStandard.getThirdLevel()>0)
        {
            ints.add(priceStandard.getThirdLevel());
        }
        if (priceStandard.getFourthLevel()>0)
        {
            ints.add(priceStandard.getFourthLevel());
        }
        int i=0;
        for (int a:ints)
        {
            total=total+a;
            i++;
        }
        AveragePriceStandard=(int)(total/i);
        return AveragePriceStandard;
    }
}
