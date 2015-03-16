package com.digitas.automation.spellcheck.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ContentTest {

	public static void main(String[] args) throws IOException, WriteException,
			InterruptedException, BiffException {
		 //Delete all existed files on target folder.
		  File dir = new File("target");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    	child.delete();
		    }
		  } 
	
		File keywordsFile = new File("Keywords");
		if(keywordsFile.length()>0){
//			Do keywords audit
			FileInputStream in = null;
			try {
				
				in = new FileInputStream("Keywords");
				
			} catch (FileNotFoundException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
			BufferedReader br = new BufferedReader(new InputStreamReader(in));			
			String strLine=null;					
			while((strLine=br.readLine())!=null){	
				System.out.println(strLine);
			keywordsAuditTest keywordsTest=new keywordsAuditTest();
			keywordsTest.auditTesting(strLine);
			}
		}else{
//			Do Spell Check
			spellCheckTest spellCheckTest= new spellCheckTest();
			spellCheckTest.spellCheckTest();
		}



	}
}
