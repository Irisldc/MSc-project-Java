package msc_project;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class getItemInfoMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	public void map(LongWritable key, Text value, Context context
            ) throws IOException, InterruptedException {
		
		String[] tokens=value.toString().split("\\t");
		
		String reviewer=tokens[0];
		String item=tokens[1].toUpperCase();
		String date=tokens[2];
		String rating=tokens[5];
			
		context.write(new Text(item), new Text(reviewer+";"+date+";"+rating));
		
	}
}
