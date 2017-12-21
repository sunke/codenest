package net.codenest.apl.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class APSolverConfig {

	@Getter @NonNull
	private String name;

	private Set<APClassProperty> lockedProperties = new HashSet<APClassProperty>();
	
	private Set<APClassProperty> postedProperties = new HashSet<APClassProperty>();
	
	
	public void addLockedProperty(final APClassProperty property) {
		lockedProperties.add(property);
	}
	
	public void addPostedProperty(final APClassProperty property){
		postedProperties.add(property);
	}
	
}
