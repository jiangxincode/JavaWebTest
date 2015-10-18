package cn.itcast.storm.storm.bolt;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class WordCounter extends BaseBasicBolt {

	private static final long serialVersionUID = 5683648523524179434L;

	private HashMap<String, Integer> counters = new HashMap<String, Integer>();

	@Override
	@SuppressWarnings("rawtypes")
	public void prepare(Map stormConf, TopologyContext context) {
		final long timeOffset = Long.parseLong(stormConf.get("TIME_OFFSET").toString());
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					for (Entry<String, Integer> entry : counters.entrySet()) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
					}
					System.out.println("---------------------------------------");
					try {
						Thread.sleep(timeOffset * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		String str = input.getString(0);
		if (!counters.containsKey(str)) {
			counters.put(str, 1);
		} else {
			Integer c = counters.get(str) + 1;
			counters.put(str, c);
		}

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
