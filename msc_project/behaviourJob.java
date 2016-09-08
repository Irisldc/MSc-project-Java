package msc_project;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class behaviourJob {
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
	    
	    Job job1 = new Job(conf, "get behaviour infor");
	    job1.setJarByClass(behaviourJob.class);
	    
	    job1.setMapperClass(behaviourMapper.class);    
	    job1.setReducerClass(behaviourReducer.class);
	    //job.setCombinerClass(MyReducer.class);
	    
	    job1.setInputFormatClass(TextInputFormat.class);
	    job1.setOutputFormatClass(TextOutputFormat.class);
	    
	    //设置有多少个reducer
	    //job1.setNumReduceTasks(3);
	    //设置排序规则
	    //job.setSortComparatorClass(DecreasingComparator.class);
	    
	    job1.setMapOutputKeyClass(Text.class);
	    job1.setMapOutputValueClass(Text.class);
	    
	    //set partitioner
	    //job1.setPartitionerClass(Partition.class);
	    
	    job1.setOutputKeyClass(Text.class);
	    job1.setOutputValueClass(IntWritable.class);
	    
	    FileInputFormat.addInputPath(job1, new Path("./labelled_reviewer_info/reviewer_simple_weighted_edge.txt"));
	    FileOutputFormat.setOutputPath(job1, new Path("./labelled_reviewer_simple_projection_summary.txt"));

	    //System.exit(job1.waitForCompletion(true) ? 0 : 1);
	    //return job1.waitForCompletion(true) ? 0 : 1;
	    job1.waitForCompletion(true);
	}

}
