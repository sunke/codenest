package net.codenest.apl.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class AplModel {

	private Map<String, AplClass> classes = new LinkedHashMap<>();
	
	
	public void addClass(final AplClass gls) {
		classes.put(gls.getName(), gls);
	}
	
	public AplClass getClassByName(final String name) {
		return classes.get(name);
	}
}
