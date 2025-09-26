package cn.itcast.storm.component.spout;

import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;
/**
 * 随机从String数组当中读取一个单词发送给下一个bolt
 * @author Administrator
 *
 */
public class RandomWordSpout extends BaseRichSpout {

	private static final long serialVersionUID = -4287209449750623371L;

	private SpoutOutputCollector collector;

	private String[] words = new String[]{"storm", "hadoop", "hive", "flume"};

	private Random random = new Random();

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("str"));
	}

	@Override
	public void nextTuple() {
		Utils.sleep(500);
		String str = words[random.nextInt(words.length)];
		collector.emit(new Values(str));
	}

}
