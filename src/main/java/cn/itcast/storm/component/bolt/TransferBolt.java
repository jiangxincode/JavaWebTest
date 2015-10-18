package cn.itcast.storm.component.bolt;

import java.util.Map;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * 将数据做简单的 传递的Bolt
 * @author Administrator
 *
 */
public class TransferBolt extends BaseBasicBolt {

	private static final long serialVersionUID = 4223708336037089125L;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context) {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		String word = input.getStringByField("str");
		collector.emit(new Values(word));
	}

}
