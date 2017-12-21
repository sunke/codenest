package net.codenest.asl.domain;

import lombok.Getter;

public enum VDirection {

	IN(1), OUT(2);
	
	@Getter
	private int value;
	
	private VDirection(final int value) {
		this.value = value;
	}
	
	public VDirection reverse() {
		return this == IN ? OUT : IN;
	}
}
