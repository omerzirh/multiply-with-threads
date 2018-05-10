/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
*         ahmetgocer/ahmet.gocer@ogr.sakarya.edu.tr
* @since 9/5/2018
* <p>
*  thread sinifi, paralel olarak toplama yapılan sınıf
* </p>
*/    
package odev_4;

import java.math.BigInteger;

public class ThreadSum implements Runnable {
    private int index;                                      
    private BigInteger num1;                    //buyuk sayiyi tutan degisken        
    int [] array;                               //parametre ile gelecek ikinci sayinin her bir basamagintutan dizi
    SumWrite mult = new SumWrite();             //yazma ve seri toplama islemlerinin yapıldıgi sınıftan nesne olusturuldu
    static BigInteger res=BigInteger.ZERO;         //baslangic degeri sıfır olan sonuc degiskeni
    public ThreadSum(int x,BigInteger sayi1, int [] array){     // parametre olarak aldigi degerleri atayan kurucu fonksiyon
      this.num1=sayi1;
     this.array = array;
        this.index = x;
     
    }
    
    
    @Override
    public void run() {
       res=res.add(num1.multiply(BigInteger.valueOf(array[index])));        //Toplama islemini yapan run metodu  icindeki kod parcacigi
  
       
        
    }
    
    
    
    
    
}
