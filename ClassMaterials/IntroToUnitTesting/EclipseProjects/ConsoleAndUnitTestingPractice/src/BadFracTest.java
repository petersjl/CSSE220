import static org.junit.Assert.*;

import org.junit.Test;

public class BadFracTest {

	@Test
	public void testIsReduced() {
		BadFrac b1 = new BadFrac(1,2);
		BadFrac b2 = new BadFrac(2,4);
		BadFrac b3 = new BadFrac(5,1);
		BadFrac b4 = new BadFrac(1,0);
		BadFrac b5 = new BadFrac(5,0);
		assertEquals(true,b1.isReduced());
		assertEquals(false,b2.isReduced());
		assertEquals(true,b3.isReduced());
		assertEquals(false,b4.isReduced());
		assertEquals(false,b5.isReduced());
	}

	@Test
	public void testAddBadFrac() {
		BadFrac b1 = new BadFrac(1,2);
		BadFrac b2 = new BadFrac(1,3);
		BadFrac b3 = b1.add(b2);
		assertEquals(5,b3.getNum());
		assertEquals(6,b3.getDen());
		
	}

}
