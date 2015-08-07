package com.ctc.credit.util.readPbc.util;

import java.io.File;
import java.io.FileFilter;

public class FileFilterUtil implements FileFilter{
	  @Override  
	    public boolean accept(File file) {  
	        // TODO Auto-generated method stub  
//	      return false;  
	          
	        if(file.isDirectory())  
	            return true;  
	        else  
	        {  
	            String name = file.getName();  
	            if(name.endsWith(".html") || name.endsWith(".htm") || name.endsWith("mht"))  
	                return true;  
	            else  
	                return false;  
	        }  
	          
	    }  
}
