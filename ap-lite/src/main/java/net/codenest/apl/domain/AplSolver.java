package net.codenest.apl.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AplSolver {

	@Getter @NonNull
	private String name;

	private Set<AplClassProperty> lockedProperties = new HashSet<AplClassProperty>();
	
	private Set<AplClassProperty> postedProperties = new HashSet<AplClassProperty>();
	
	
	public void addLockedProperty(final AplClassProperty property) {
		lockedProperties.add(property);
	}
	
	public void addPostedProperty(final AplClassProperty property){
		postedProperties.add(property);
	}
	
}
