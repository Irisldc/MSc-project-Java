package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class getScoreReducer extends Reducer<Text,Text,Text,Text>{
	
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		
		String scores="";
		
		for(Text val:values){
			
			scores+=val.toString()+",";
			
		}
		
		context.write(key, new Text(scores));
		
	}
}
