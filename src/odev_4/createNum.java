/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
*         ahmetgocer/ahmet.gocer@ogr.sakarya.edu.tr
* @since 9/5/2018
* <p>
*  sayilarin üretildiği sınıf
* </p>
*/  
package odev_4;

import java.util.Random;

public class createNum {
    public static int array [];
    String num="";
    Random rand = new Random();
    
     createNum(int length){
        
         for(int b=0;b<length;b++){             //birinci sayıyı parametre alarak istenilen sayıda rasgele üretmek icin kurucu fonksiyon

               num +=""+(rand.nextInt(8)+1);

            }
      
    }
    
    
     
     int [] createNum(int numLength){
         
         array  = new int[numLength];
         
         for(int b=0;b<numLength;b++){      //ikinci sayiyi istenilen sayıda üreterek dizi olarak döndüren kurucu fonksiyon
            
            array[b] = rand.nextInt(8)+1;
           
         }
            
            return array;
          
        
    }
     
}
