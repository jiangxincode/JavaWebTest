package cn.itcast.storm.lifeCycle.bolt;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

	private static final Log log = LogFactory.getLog(TransferBolt.class);
	
	public TransferBolt() {
		log.warn("&&&&&&&&&&&&&&&&& TransferBolt constructor method invoked");
	}
	
	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		log.warn("################# TransferBolt prepare() method invoked");
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		log.warn("################# TransferBolt declareOutputFields() method invoked");
		declarer.declare(new Fields("word"));
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		log.warn("################# TransferBolt execute() method invoked");
		String word = input.getStringByField("str");
		collector.emit(new Values(word));
	}

}
