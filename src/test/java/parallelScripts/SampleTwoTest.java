package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
	 @Test
	  public void testOne() {
		  long id = Thread.currentThread().getId();
		  System.out.println("testOne in SampleTwoTest...." + id);
	  }
	  
	  @Test
	  public void testTwo() {
		  long id = Thread.currentThread().getId();
		  System.out.println("testTwo in SampleTwoTest...."+ id);
	  }
	  
	  @Test
	  public void testThree() {
		  long id = Thread.currentThread().getId();
		  System.out.println("testThree in SampleTwoTest....."+id);
	  }
	  
	  @Test
	  public void testFour() {
		  long id = Thread.currentThread().getId();
		  System.out.println("testFour in SampleTwoTest...."+id);
	  }
}
