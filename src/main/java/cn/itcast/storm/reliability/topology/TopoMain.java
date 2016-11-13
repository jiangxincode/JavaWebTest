package cn.itcast.storm.reliability.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import cn.itcast.storm.reliability.bolt.FileWriterBolt;
import cn.itcast.storm.reliability.bolt.SpliterBolt;
import cn.itcast.storm.reliability.spout.MessageSpout;

public class TopoMain {
	
	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new MessageSpout());
		builder.setBolt("bolt-1", new SpliterBolt()).shuffleGrouping("spout");
		builder.setBolt("bolt-2", new FileWriterBolt()).shuffleGrouping("bolt-1");
		Config conf = new Config();
		conf.setDebug(false);
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("reliability", conf, builder.createTopology());
	}
}
