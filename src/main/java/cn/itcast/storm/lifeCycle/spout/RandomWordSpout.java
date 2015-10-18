package cn.itcast.storm.lifeCycle.spout;

import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
/**
 * 随机从String数组当中读取一个单词发送给下一个bolt
 * @author Administrator
 *
 */
public class RandomWordSpout extends BaseRichSpout {

	private static final long serialVersionUID = -4287209449750623371L;
	
	private static final Log log = LogFactory.getLog(RandomWordSpout.class);

	private SpoutOutputCollector collector;
	
	private String[] words = new String[]{"storm", "hadoop", "hive", "flume"};
	
	private Random random = new Random();
	
	public RandomWordSpout() {
		log.warn("&&&&&&&&&&&&&&&&& RandomWordSpout constructor method invoked");
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		log.warn("################# RandomWordSpout open() method invoked");
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		log.warn("################# RandomWordSpout declareOutputFields() method invoked");
		declarer.declare(new Fields("str"));
	}

	@Override
	public void nextTuple() {
		log.warn("################# RandomWordSpout nextTuple() method invoked");
		Utils.sleep(500);
		String str = words[random.nextInt(words.length)];
		collector.emit(new Values(str));
	}


	@Override
	public void activate() {
		log.warn("################# RandomWordSpout activate() method invoked");
	}

	@Override
	public void deactivate() {
		log.warn("################# RandomWordSpout deactivate() method invoked");
	}
	
	

}
