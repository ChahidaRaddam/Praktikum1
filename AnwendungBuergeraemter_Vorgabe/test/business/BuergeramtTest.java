package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuergeramtTest {
	private Buergeramt buergeramt;

	@BeforeEach
	 void ausfuellen() throws Exception {
        buergeramt = new Buergeramt("Burgerburo Querenburg", 9.00f, 17.00f, "Querenburg Hohe 256", new String[]{"Hauptwohnsitz", "Nebenwohnsitz"});
    }

	@AfterEach
	void tearDown() throws Exception {
		this.buergeramt = null;
	}

	@Test
	 void test() {
    	assertTrue(()->this.buergeramt.getName().equals("Burgerburo Querenburg"));
    	
    	Throwable t = assertThrows(NullPointerException.class, () -> {new Buergeramt("Burgerburo Querenburg", 9.00f, 17.00f, "Querenburger Hohe 256", null);});
    	assertEquals("Dienstleistung is null",t.getMessage());
    	
	}
	
}
