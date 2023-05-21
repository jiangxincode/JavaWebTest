package cn.itcast.storm.component.bolt;

import java.util.Map;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

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
