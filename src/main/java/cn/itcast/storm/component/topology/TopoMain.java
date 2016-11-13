package cn.itcast.storm.component.topology;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import cn.itcast.storm.component.bolt.TransferBolt;
import cn.itcast.storm.component.bolt.WriterBolt;
import cn.itcast.storm.component.spout.RandomWordSpout;

//cn.itcast.storm.topology.TopoMain
public class TopoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("random", new RandomWordSpout(), 2);
		builder.setBolt("transfer", new TransferBolt(), 4).shuffleGrouping("random");//.setNumTasks(8);
		builder.setBolt("writer", new WriterBolt(), 4).fieldsGrouping("transfer", new Fields("word"));
		Config conf = new Config();
		conf.setNumWorkers(4);
		conf.setNumAckers(0);
		conf.setDebug(false);
		StormSubmitter.submitTopology("comp-test-1", conf, builder.createTopology());
	}

}
