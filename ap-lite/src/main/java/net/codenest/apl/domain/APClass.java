package net.codenest.apl.domain;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class APClass {

	@Getter @NonNull
	private String name;
	
	private Map<String, APClassProperty> properties = new LinkedHashMap<>();
	
	private Set<String> attributes = new HashSet<String>();
	

	public void addProperty(final APClassProperty property) {
		properties.put(property.getName(), property);
	}
	
	public void addAttribute(final String attribute) {
		attributes.add(attribute);
	}
}
