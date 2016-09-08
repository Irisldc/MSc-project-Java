package msc_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class extractInfo {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(
				new FileReader("/Users/lidongchen/Documents/UCL/MSc_project/Dataset/A.Mukherjee_Amazon/reviewsNew.txt"));
		
		String line="";
		while((line=br.readLine())!=null){
			
			String[] tokens=line.split("\\t");
			if (tokens.length>5){
				System.out.println(tokens[1]+tokens[5]) ;
			}
			
		}
	}
	
}
