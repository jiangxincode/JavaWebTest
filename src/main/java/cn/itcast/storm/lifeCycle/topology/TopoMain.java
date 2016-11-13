package cn.itcast.storm.lifeCycle.topology;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import cn.itcast.storm.lifeCycle.bolt.TransferBolt;
import cn.itcast.storm.lifeCycle.bolt.WriterBolt;
import cn.itcast.storm.lifeCycle.spout.RandomWordSpout;

public class TopoMain {

	private static final Log log = LogFactory.getLog(TopoMain.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("random", new RandomWordSpout(), 2);
		builder.setBolt("transfer", new TransferBolt(), 4).shuffleGrouping("random");
		builder.setBolt("writer", new WriterBolt(), 4).fieldsGrouping("transfer", new Fields("word"));
		Config conf = new Config();
		conf.setNumWorkers(2);
		conf.setDebug(true);
		log.warn("$$$$$$$$$$$ submitting topology...");
		StormSubmitter.submitTopology("life-cycle", conf, builder.createTopology());
		log.warn("$$$$$$$4$$$ topology submitted !");
	}

}
