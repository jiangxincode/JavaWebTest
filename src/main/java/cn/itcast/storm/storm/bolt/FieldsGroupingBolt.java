package cn.itcast.storm.storm.bolt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import cn.itcast.storm.storm.utils.PropertyUtil;

public class FieldsGroupingBolt extends BaseBasicBolt {

	private static final long serialVersionUID = -3176498679732038154L;
	
	private String separator = ",";
	private List<String> fieldsList;
	private String target;
	
	@Override
	@SuppressWarnings("rawtypes")
	public void prepare(Map stormConf, TopologyContext context) {
		String scheme = PropertyUtil.getProperty("scheme");
		separator = PropertyUtil.getProperty("separator");
		target = PropertyUtil.getProperty("target");
		fieldsList = Arrays.asList(scheme.split(","));
		
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		String data = input.getString(0);
		if(data != null){
			String[] lines = data.split(System.getProperty("line.separator"));
			for(String line : lines){
				String[] fields = line.split(separator);
				int index = fieldsList.indexOf(target);
				String fieldVal = fields[index];
				collector.emit(new Values(fieldVal, line));
			}
		}

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("partition", "line"));
	}

}
