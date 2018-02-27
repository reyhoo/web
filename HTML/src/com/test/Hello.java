package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Hello {

	
	public static void main(String[] args) {
//		decompression("C:\\Users\\dell\\Desktop\\项目相关\\react-native\\decompression\\android2");
		decompression("C:\\Users\\dell\\Desktop\\项目相关\\react-native\\android2.zip","C:\\Users\\dell\\Desktop\\项目相关\\react-native\\decompression\\android2");
//		System.out.println(new File("C:\\Users\\dell\\Desktop\\项目相关\\react-native\\android.zip").getName());
//		System.out.println("1.zip".substring(0,"1.zip".lastIndexOf(".")));
		
//		File file = new File("C:\\Users\\dell\\Desktop\\项目相关\\react-native\\decompression","android\\index.bundle.meta");
//		delFile(file);
	}
	

	public static void delFile(File file){
		if(file == null)return;
		if(!file.exists())return;
		if(file.isFile())file.delete();
		File[] listFiles = file.listFiles();
		if(listFiles == null || listFiles.length == 0){
			file.delete();
			return;
		}
		for (File f :
				listFiles) {
			delFile(f);
		}
		file.delete();
	}
	/**
     * 解压 ZIP 包
     */
    public static void decompression(String zipFilePath,String filePath) {
    	File file = new File(filePath);
    	if(!file.exists()){
    		file.mkdirs();
    	}
        try {
            ZipInputStream inZip = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry zipEntry;
            String szName;
            try {

                while((zipEntry = inZip.getNextEntry()) != null) {

                    szName = zipEntry.getName();
                    if(zipEntry.isDirectory()) {
                        szName = szName.substring(0,szName.length()-1);
                        File folder = new File(filePath + File.separator + szName);
                        folder.mkdirs();
                    }else{
                        File file1 = new File(filePath + File.separator + szName);
                        file1.createNewFile();
                        FileOutputStream fos = new FileOutputStream(file1);
                        int len;
                        byte[] buffer = new byte[1024];
                        while((len = inZip.read(buffer)) != -1) {
                            fos.write(buffer, 0 , len);
                            fos.flush();
                        }
                        fos.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            inZip.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
