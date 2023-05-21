package cn.itcast.storm.reliability.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

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
