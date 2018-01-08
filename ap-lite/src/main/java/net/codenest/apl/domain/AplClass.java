package net.codenest.apl.domain;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AplClass {

	@Getter @NonNull
	private String name;
	
	private Set<AplClass> children = new HashSet<AplClass>();

	private Map<String, AplClassProperty> properties = new LinkedHashMap<>();
	
	private Set<String> attributes = new HashSet<String>();
	
	private Set<AplClass> components = new HashSet<AplClass>();
	
	private Map<String, String> auxiliaries = new LinkedHashMap<>();
	

	public void addProperty(final AplClassProperty property) {
		properties.put(property.getName(), property);
	}
	
	public void addAttribute(final String attribute) {
		attributes.add(attribute);
	}
}
