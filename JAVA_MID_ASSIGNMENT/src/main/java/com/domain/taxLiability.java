package com.domain;

import com.TaxCal.TaxCal;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

public class taxLiability {

   public ArrayList<Integer> Tax(@ModelAttribute("user") User user){
       ArrayList<Integer> result = new ArrayList<Integer>();
       TaxCal tax = new TaxCal();
       int TotalYearlyTP =tax.Total(user);
       int j=0;
       int num=5;
       int i=0;
       while(TotalYearlyTP >0){



           if(i==0){
               if(user.getGender().equals("male")){
                   j = 300000;
               }
              else if(user.getGender().equals("female")){
                   j = 350000;
               }
               TotalYearlyTP =TotalYearlyTP- j;
               i++;


               continue;
           }
           if(i==1){
               j=100000;

               TotalYearlyTP =TotalYearlyTP- j;
               int data =(j*num)/100;
               result.add(data);
               num +=5;
               i++;
               j+=200000;
               continue;
           }
           else {

               TotalYearlyTP =TotalYearlyTP- j;
               if(TotalYearlyTP <0){
                   int value =Math.abs(TotalYearlyTP);
                   int v = j - value;
                   int data  =(v*num)/100;
                   result.add(data);
                   break;
               }

               int data  =(j*num)/100;
               result.add(data);
               num +=5;
               j+=100000;
               i++;

           }

       }

       return result;

   }
}
