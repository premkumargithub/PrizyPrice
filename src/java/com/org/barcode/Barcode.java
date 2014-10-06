/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.stereotype.Component;

/**
 * Class which a function get create the bar code image
 * @author Prem Baboo
 */
@Component
public class Barcode {
    
    /**
     * To create bar code image 
     * @param barcodeUrl
     * @return 
     */
    public String getBarcode(String barcodeUrl) { 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = Calendar.getInstance().getTime();
        String barcodeName = sdf.format(date)+".jpg";
        try {   
            //Create the barcode bean   
            Code39Bean bean = new Code39Bean();   
               
            final int dpi = 50;                  
            //Configure the barcode generator   
            bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar    
                                                             //width exactly one pixel   
            bean.setWideFactor(3);   
            bean.doQuietZone(false);   
          
            //Open output file   
            System.out.println("url1= "+barcodeUrl);
            File outputFile = new File(barcodeUrl+barcodeName);   
            OutputStream out = new FileOutputStream(outputFile);   
            try {   
                //Set up the canvas provider for monochrome JPEG output    
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(   
                        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);   
               
                //Generate the barcode   
                bean.generateBarcode(canvas, barcodeName);   
               
                //Signal end of generation   
                canvas.finish();   
            } finally {   
                out.close();   
            }   
        } catch (Exception e) {   
        }   
        return barcodeName;
    }
}