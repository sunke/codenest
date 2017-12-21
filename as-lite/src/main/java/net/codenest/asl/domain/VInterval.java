package net.codenest.asl.domain;

import lombok.Getter;
import lombok.Setter;

public class VInterval {

	public static final VInterval MAX = new VInterval(VTime.MIN, VTime.MAX);

	public static final VInterval NULL = new VInterval(null, null);

	@Getter
	@Setter
	private VTime start;

	@Getter
	@Setter
	private VTime stop;

	/**
	 * @param start
	 * @param stop
	 */
	public VInterval(final VTime start, final VTime stop) {
		this.start = start;
		this.stop = stop;
	}

	public boolean isValid() {
		return start.isValid() && stop.isValid() && (start.getMinutes() <= stop.getMinutes());
	}
	
	public VTime get(final VDirection dir) {
		return dir == VDirection.IN ? start : stop;
	}

	public VDuration getDuration() {
		return this.stop.sub(this.start);
	}

	public VInterval add(final VDuration offset) {
		return new VInterval(this.start.add(offset), this.stop.add(offset));
	}

	public VInterval sub(final VDuration offset) {
		return new VInterval(this.start.sub(offset), this.stop.sub(offset));
	}

	public VInterval union(final VInterval other) {
		VTime unionStart = this.start.earlierThan(other.start) ? this.start : other.start;
		VTime unionStop = this.stop.laterThan(other.stop) ? this.stop : other.stop;

		return new VInterval(unionStart, unionStop);
	}

	public static VInterval make(final VDirection dir, final VTime time, final VDuration duration) {
		return (dir == VDirection.IN) ? new VInterval(time, time.add(duration))
				: new VInterval(time.sub(duration), time);
	}
}
