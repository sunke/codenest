package net.codenest.asl.domain;

import lombok.Getter;
import lombok.Setter;
import net.codenest.asl.util.CompareUtil;

public class VQuantity implements Comparable<VQuantity> {

	public static VQuantity VOID = new VQuantity(0.05D);

	public static VQuantity ZERO = new VQuantity(0);

	@Getter
	@Setter
	private double value;

	public VQuantity() {
		this(0);
	}

	public VQuantity(final double value) {
		this.value = value;
	}

	public boolean isVoid() {
		return CompareUtil.lessEqual(Math.abs(value), VOID.value);
	}

	public boolean isValid() {
		return !isVoid();
	}

	public VQuantity abs() {
		return value > 0 ? this : new VQuantity(-value);
	}

	public VQuantity add(final VQuantity q) {
		return q.value == 0 ? this : new VQuantity(q.value + this.value);
	}

	public VQuantity sub(final VQuantity q) {
		return q.value == 0 ? this : new VQuantity(this.value - q.value);
	}

	public double div(final VQuantity q) {
		return this.value / q.value;
	}

	public VRate div(final VDuration d) {
		return new VRate(this.value / d.getMinutes());
	}

	public VDuration div(final VRate r) {
		return new VDuration((int) (this.value / r.getValue()));
	}

	public VQuantity mul(final double v) {
		return v == 1 ? this : new VQuantity(this.value * v);
	}

	public VQuantity div(final double v) {
		return v == 1 ? this : new VQuantity(this.value / v);
	}

	public VQuantity neg() {
		return new VQuantity(-this.value);
	}

	public int compareTo(VQuantity q) {
		return CompareUtil.compare(this.value, q.value);
	}
}
