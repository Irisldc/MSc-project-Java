package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class behaviourReducer extends Reducer<Text,Text,Text,Text>{
	
	public void reduce(Text key, Iterable<Text> values, Context context) 
			throws IOException, InterruptedException {
		
		String info="";
		//int cnt=0;
		for(Text val:values){
			
			//dates+=val.toString()+"///";
			info+=val.toString()+";";
		}
		
		context.write(key, new Text(info));
	}
}
