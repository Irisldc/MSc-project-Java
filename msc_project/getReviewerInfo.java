package msc_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class getReviewerInfo {
	
	public static void main(String[] args) throws IOException{
		
		ArrayList<String> authorList=new ArrayList<String>();
		
		BufferedReader br=new BufferedReader(
				new FileReader("/Users/lidongchen/Documents/UCL/MSc_project/Dataset/reviewer_spamicity_raw.txt"));
		
		BufferedWriter bw=new BufferedWriter(
				new FileWriter("./reviewer_spamicity.txt"));
		
		String line="";
		
		while((line=br.readLine())!=null){
			
			//System.out.println(line);
			
			String[] tokens=line.split("\\t");
			
			String author=tokens[0];
			
			String[] scores=tokens[1].split(",");
			
			authorList.add(author);
			
			int cnt=0;
			double sum=0;
			for(String s:scores){
				
				sum+=Double.parseDouble(s);
				cnt+=1;
			}
			
			double avg=(double)sum/cnt;
			
			bw.write(author+":"+avg);
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		BufferedReader br1=new BufferedReader(
				new FileReader("/Users/lidongchen/Documents/UCL/MSc_project/Dataset/A.Mukherjee_Amazon/reviewsNew.txt"));
		
		BufferedWriter bw1=new BufferedWriter(
				new FileWriter("./labelled_reviewer_info.txt"));
		
		String line1="";
		
		Set set=new HashSet();
		
		while((line1=br1.readLine())!=null){
			
			String[] tokens=line1.split("\\t");
			
			String reviewer=tokens[0];
			
			if (authorList.contains(reviewer)){
				bw1.write(line1);
				bw1.newLine();
				
				set.add(reviewer);
				
				//System.out.println("match");
			}
			
		}
		
		System.out.println("complete. num of reviewers found:"+set.size());
		br1.close();
		bw1.flush();
		bw1.close();
	}
		
}
