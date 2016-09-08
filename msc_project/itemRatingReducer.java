package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class itemRatingReducer extends Reducer<Text,DoubleWritable,Text,Text>{
	
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
			throws IOException, InterruptedException {
		
		int count=0;
		double sum=0;
		
		for(DoubleWritable val:values){
			sum+=val.get();
			count++;
		}
		
		//double avg=(double)sum/count;
		
		context.write(key, new Text(sum+","+count));
	}

}
