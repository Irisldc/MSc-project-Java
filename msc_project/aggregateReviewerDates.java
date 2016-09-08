package msc_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class aggregateReviewerDates {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(
				new FileReader("./reviewer_timely_behaviours.txt"));
		
		String line="";
		
		while((line=br.readLine())!=null){
						
			String[] tokens=line.split("\\t");
			
			String author=tokens[0];
			BufferedWriter bw=new BufferedWriter(
					new FileWriter("/Users/lidongchen/Documents/UCL/MSc_project/Dataset/reviewer_dates/"+author+"_dates.txt"));
			
			String[] info=tokens[1].split(";");
			
			for (String i:info){
				
				String[] temp=i.split(",|\\s");
				
				if (temp.length>=5){
					String month=temp[1];
					String day=temp[2];
					String year=temp[3];
					
					String newMonth="";
					
					switch(month){
						case "January":
							newMonth="01";
							break;
						case "February":
							newMonth="02";
							break;
						case "March":
							newMonth="03";
							break;
						case "April":
							newMonth="04";
							break;
						case "May":
							newMonth="05";
							break;
						case "June":
							newMonth="06";
							break;
						case "July":
							newMonth="07";
							break;
						case "August":
							newMonth="08";
							break;
						case "September":
							newMonth="09";
							break;
						case "October":
							newMonth="10";
							break;
						case "November":
							newMonth="11";
							break;
						case "December":
							newMonth="12";
							break;
							
					}
					
					String date=year+"-"+newMonth+"-"+day;
					
					bw.write(date);
					bw.newLine();
				}
			}
			
			bw.flush();
			bw.close();
		}
		
	}
}
