/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class UploadFile {
    public void uploadFile(InputStream is, String path) {
        try {
            byte[] byt = new byte[is.available()];
            is.read(byt);
            try (OutputStream fops = new FileOutputStream(path)) {
                fops.write(byt);
                fops.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void deleteImage(String path){
        File f= new File(path);  
        f.delete();
    }
}
