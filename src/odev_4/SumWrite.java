/**
*
* @author omerzirh/omer.zirh@ogr.sakarya.edu.tr
*         ahmetgocer/ahmet.gocer@ogr.sakarya.edu.tr
* @since 9/5/2018
* <p>
* seri toplama ve yazdırma fonksiyonlarının bulundugu sınıf
* </p>
*/  
package odev_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Random;

public class SumWrite {

  static BigInteger resIslem = BigInteger.ZERO;
    void multiplyBigs(int outNum, BigInteger steadyNum, int [] array){  

        for(int i=0;i<outNum;i++)
        resIslem=resIslem.add(steadyNum.multiply(BigInteger.valueOf(array[i])));        //basamak sayisinca donen toplama islemini seri olarak yapan fonksiyon

    }
    void WriteToFile(BigInteger numero){            //sayiyi alıp dosyaya yazdıran fonksiyon
        try{
                  File dosya = new File("Sonuc.txt");                         
                  FileWriter yazici = new FileWriter(dosya);       //dosya olusturuluyor, varsa yazmaya devam ediliyor
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  yaz.write(numero.toString());  //her bir eleman icin fonksiyon kullanilarak dosyaya yaziliyor
                  yaz.newLine();        //her yazimdan sonra yeni satira geciliyor
                  yaz.close();
                  
                 
            }
            catch (Exception e){            //try - catch blogu sayesinde hatalar yakalniyor
                  e.printStackTrace();
            }
    
    }
}
