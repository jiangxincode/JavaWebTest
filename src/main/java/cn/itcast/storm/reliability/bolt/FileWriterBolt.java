package cn.itcast.storm.reliability.bolt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class FileWriterBolt implements IRichBolt {

	private static final long serialVersionUID = -8619029556495402143L;

	private FileWriter writer;

	private OutputCollector collector;

	
	private int count = 0;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		try {
			writer = new FileWriter("e://reliability.txt");
		} catch (IOException e) {
		}
	}

	@Override
	public void execute(Tuple input) {
		String word = input.getString(0);
		if (count == 5) {
			collector.fail(input);
		} else {
			try {
				writer.write(word);
				writer.write("\r\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			collector.emit(input, new Values(word));
			collector.ack(input);
		}
		count++;
	}

	@Override
	public void cleanup() {

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
