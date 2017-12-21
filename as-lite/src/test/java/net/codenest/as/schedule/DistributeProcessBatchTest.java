package net.codenest.as.schedule;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import net.codenest.asl.domain.Batch;
import net.codenest.asl.domain.VDirection;
import net.codenest.asl.domain.VInterval;
import net.codenest.asl.domain.VTime;
import net.codenest.asl.schedule.DistributeProcessBatch.Config;

public class DistributeProcessBatchTest {

//	@Test
//	public void placeOneBatchAtStartOfWorkArea() {
//		Config config = new Config();
//		config.workarea = new VInterval(new VTime(2017, 1, 1), new VTime(2017, 3, 1));
//
//		Batch batch = new Batch();
//
//		assertEquals(new VTime(1), batch.getBound().get(VDirection.IN));
//	}
	
	@Test
	public void test() {
		ArrayList list = new ArrayList<Object>();
		Object x = new Integer((int) 1L);
		list.add("x");
		list.add("y");
		list.add(x);
		
		
		System.out.println(list.toString());
	}
}
