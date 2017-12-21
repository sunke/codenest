package net.codenest.asl.domain;

import lombok.Getter;
import lombok.Setter;

public class Batch {

	@Getter
	@Setter
	private VInterval bound = VInterval.MAX;
}
