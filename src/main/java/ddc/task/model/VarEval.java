package ddc.task.model;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import ddc.support.util.Chronometer;
import ddc.support.util.FormatUtils;

public class VarEval {
	private Map<String, String> map = new TreeMap<>();
	
	public VarEval() {
		map.put("${UUID}", UUID.randomUUID().toString());
		map.put("${Timestamp}", String.valueOf(Chronometer.getNowMillis()));
		map.put("${DateTime}", FormatUtils.formatForFilename(new Date()));
		for (Map.Entry<String, String> e : System.getenv().entrySet()) {
			String key = "${" + e.getKey() + "}";
			String value = e.getValue();
			map.put(key, value);
		}
		for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
			String key = "${" + e.getKey() + "}";
			String value = String.valueOf(e.getValue());
			map.put(key, value);
		}		
	}
		
	public static String evaluate(String source) {
		VarEval ve = new VarEval();
		return ve.eval(source);
	}	
	
	public VarEval evalAndAddVar(String name, String source) {		
		map.put(name, eval(source));
		return this;
	}
	
	public VarEval addVar(String name, String value) {
		map.put(name, value);
		return this;
	}
	
	public String eval(String source) {
		for (Map.Entry<String, String> e : map.entrySet()) {
			source = StringUtils.replace(source, e.getKey(), e.getValue());
		}
		return source;
	}
	
	public String get(String name) {
		return map.get(name); 
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (Map.Entry<String, String> e : System.getenv().entrySet()) {
			System.out.println("sys-env: " + e.getKey() + " =\t " + e.getValue());
		}
		for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
			System.out.println("sys-prop: " + String.valueOf(e.getKey()) + " =\t " + String.valueOf(e.getValue()));
		}
	}
}
