package net.codenest.asl.domain;

import java.util.Calendar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class VTime implements Comparable<VTime> {

	private static final int MILLISECONDS_PER_MINUTE = 60 * 1000;

	private static final int MINUTES_BETWEEN_1904_AND_1970 = 24107 * 24 * 60;

	public static final VTime MIN = new VTime(1970, 1, 1);

	public static final VTime MAX = new VTime(2038, 1, 1);

	public static final VTime INVALID = new VTime(Integer.MAX_VALUE);

	@Getter
	@Setter
	private int minutes;   // minutes since Jan 1, 1970

	public VTime(final int minutes) {
		this.minutes = minutes;
	}

	public VTime(final int year, final int month, final int day) {
		this(year, month, day, 0, 0);
	}

	public VTime(final int year, final int month, final int day, final int hour, final int minute) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute, 0);
		c.set(Calendar.MILLISECOND, 0);

		minutes = (int) c.getTimeInMillis() / MILLISECONDS_PER_MINUTE + MINUTES_BETWEEN_1904_AND_1970;
	}
	
	public boolean isValid() {
		return this.minutes >= MIN.minutes && this.minutes <= MAX.minutes;
	}

	public VDuration sub(final VTime t) {
		return new VDuration(this.minutes - t.minutes);
	}
	
	public VTime sub(final VDuration d) {
		return new VTime(this.minutes - d.getMinutes());
	}
	
	public VTime add(final VDuration d) {
		return new VTime(this.minutes + d.getMinutes());
	}

	@Override
	public int compareTo(VTime other) {
		return this.minutes - other.minutes;
	}
	
	public boolean earlierThan(final VTime other) {
		return compareTo(other) < 0;
	}
	
	public boolean laterThan(final VTime other) {
		return compareTo(other) > 0;
	}
}
