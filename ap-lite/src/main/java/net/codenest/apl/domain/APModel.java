package net.codenest.apl.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class APModel {

	private Map<String, APClass> classes = new LinkedHashMap<>();
	
	private Map<String, APSolverConfig> configs = new LinkedHashMap<>();
	
	
	public void addClass(final APClass gls) {
		classes.put(gls.getName(), gls);
	}
	
	public APClass getClassByName(final String name) {
		return classes.get(name);
	}
	
	public void addSolverConfig(final APSolverConfig cfg) {
		configs.put(cfg.getName(), cfg);
	}
	
	public APSolverConfig getSolverConfigByName(final String name){
		return configs.get(name);
	}
}
