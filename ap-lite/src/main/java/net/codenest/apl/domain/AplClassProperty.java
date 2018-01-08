package net.codenest.apl.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AplClassProperty {

	@Getter @NonNull
	private String name;
	
	@Getter
	private Double defaultValue;
}
