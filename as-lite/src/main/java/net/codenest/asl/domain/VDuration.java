package net.codenest.asl.domain;

import lombok.Getter;
import lombok.Setter;

public class VDuration implements Comparable<VDuration> {
	
	public final static VDuration ZERO = new VDuration(0);
	
	public final static VDuration MIN = new VDuration(1);
	
	@Getter
	@Setter
	private int minutes;
	
	public VDuration() {
		this(0);
	}
	
	public VDuration(final int value) {
		this.minutes = value;
	}
	
	
	public int compareTo(VDuration d) {
		return this.minutes - d.minutes;
	}
	
	public VDuration add(final VDuration d) {
		return new VDuration(minutes + d.minutes);
	}

	public VDuration sub(final VDuration d) {
		return new VDuration(minutes - d.minutes);
	}

	public VDuration neg() {
		return new VDuration(-minutes);
	}

	public VQuantity mul(final VRate rate) {
		return new VQuantity(minutes * rate.getValue());
	}

	public VDuration mul(final double factor) {
		return new VDuration((int) (minutes * factor));
	}
}
