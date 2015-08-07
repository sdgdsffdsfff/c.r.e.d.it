package com.ztx.selenium.uitl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	
	
	public static void main(String[] args) {
		File folder=new File("src/main/resources/批量测试报告");
		File test=new File("src/main/resources/test");
		if(!test.exists()){
			test.mkdir();
		}
		if(folder.isDirectory()){
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++) {
				boolean is=files[i].getName().endsWith(".htm");
				if(is){
					try {
						FileUtils.copyFile(files[i], new File("src/main/resources/test/"+(i+1)+".htm"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void AppendContent(String fileName, String content) {

		
		
		BufferedWriter bw = null;
		try {

			bw = new BufferedWriter(new FileWriter(fileName, true));

			bw.write(content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
