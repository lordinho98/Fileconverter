package com.fileconverter;

import java.io.File;

import javax.swing.JOptionPane;

import com.aspose.asposecloudpdf.api.*;
import com.aspose.asposecloudpdf.model.DocumentResponse;


public class Converter {
    public  void setConverter(String converter) {
      try {
    String clientId = "bbf94a2c-6d7e-4020-b4d2-b9809741374e";
    String clientSecret = "1c9379bb7d701c26cc87e741a29987bb";
    


    PdfApi pdfApi = new PdfApi(clientSecret,clientId);

    String imageFile = converter;
    String resultantPDF = "Resultant.pdf";
    DocumentResponse document = pdfApi.putCreateDocument(resultantPDF, "Internal",null);
    

    document.getDocument();
    File file = new File(imageFile);

    int pageNumber = 1;

    double llx = 10.0;
    double lly = 850;
    double urx = 580.0;
    double ury = 650.0;
    
    pdfApi.postInsertImage(resultantPDF, pageNumber, llx, lly, urx, ury, null,"Internal",null,file);

         JOptionPane.showInputDialog("JPG to PDF Conversion sucessfull !");

      } catch (Exception e) {
            JOptionPane.showInputDialog("Falha ao converter ", e);
      }
    }


   



    
    
}
