/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
*         ahmetgocer/ahmet.gocer@ogr.sakarya.edu.tr
* @since 9/5/2018
* <p>
*  olusturdugumuz siniflardan nesneler olusturularak metodlar kullanilarak test edilen sınıf
* </p>
*/  
package odev_4;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Odev_4 {
   
    
    
     
    static BigInteger num1 ;
    
    
    public static void main(String[] args) {
        int numLeng=100000;                          //basamak sayilarinin atandigi degisken
        createNum cr =new createNum(numLeng);       //sayi uretmek icin nesne olusturuldu
        num1 = new BigInteger(cr.num);              //uretme sinifindan ilk sayı olusturuldu
        int [] array = cr.createNum(numLeng);       //ikinci sayi dizi olarak cekildi
        long begin_serial = System.nanoTime();      //seri hesaplama icin sure olcumu baslangıcı
                SumWrite is = new SumWrite();   
                is.multiplyBigs(numLeng,num1,array);    //seri hesaplama ivin degerler gonderildi
        long finish_serial = System.nanoTime();     ////seri hesaplama icin sure olcumu bitisi
      ExecutorService pool = Executors.newFixedThreadPool(5); //thread havuzu olusturuldu
       
        long begin_parallel = System.nanoTime();        ////paralel hesaplama icin sure olcumu baslangıcı
        for(int i=0;i<numLeng;i++){                     
        pool.execute(new ThreadSum(i,num1,array));   //run metodu calistirilmasi icin kurucu fonksiyona degerler gonderildi ve execute basamak sayisinca donguye alinarak gerçeklendi
                                                        //threadler sayesinde dizinin elemanlarinin ayni anda fazladan eleman hesaplanmasiyla süre kısaltıldı
        }
        
             pool.shutdown();           //havuz kapatıldı

        while(!pool.isTerminated()){}
        long finish_parallel = System.nanoTime();   //paralel hesaplama icin sure olcumu bitisi
        
        double time = (finish_serial - begin_serial)/10000000.0;
                  System.out.println("\nSeri Hesaplama Süresi: "+String.format("%.2f",time)+"milisaniye");
        double time2 = (finish_parallel - begin_parallel)/10000000.0;                                          // gerekli cıktıların yapıldıgı kod parcacığı
                  System.out.println("Paralel Hesaplama Süresi: "+String.format("%.2f",time2)+"milisaniye");
        is.WriteToFile(ThreadSum.res);
                  System.out.println("Sonuc dosyaya yazıldı.");
    
    
}
}