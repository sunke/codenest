package net.codenest.asl.domain;

import lombok.Getter;
import lombok.Setter;
import net.codenest.asl.util.CompareUtil;

public class VRate implements Comparable<VRate> {

	@Getter
	@Setter
	private double value;
	
	public VRate() {
		this(0);
	}
	
	public VRate(final double value) {
		this.value = value;
	}
	
	public boolean isVoid() {
		return Math.abs(value) <= CompareUtil.epsilon;
	}
	
	public boolean isValid() {
		return !isVoid() && !Double.isFinite(value);
	}

	public int compareTo(final VRate r) {
		return CompareUtil.compare(this.value, r.value);
	}
}
