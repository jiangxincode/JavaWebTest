package cn.itcast.storm.reliability.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class SpliterBolt implements IRichBolt {

	private static final long serialVersionUID = 6266473268990329206L;

	private OutputCollector collector;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}
	
	@Override
	public void execute(Tuple input) {
		String line = input.getString(0);
		String[] words = line.split(",");
		for (String word : words) {
			collector.emit(input, new Values(word));
		}
		collector.ack(input);
	}

	@Override
	public void cleanup() {

	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
