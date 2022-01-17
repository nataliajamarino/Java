package ie.gmit.dip;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ApplicationTests {
    @Test
    public void testCypherEncryption() {
        Cypher c = new Cypher();

        assertEquals(c.encrypt("object"), "GAVXFGFXGVDX");
        assertEquals(c.encrypt("attack"), "GGVGGDDXGXDG");
    }

    @Test
    public void testCypherDecryption() {
        Cypher c = new Cypher();

        assertEquals(c.decrypt("GAVXFGFXGVDX"), "OBJECT");
        assertEquals(c.decrypt("GGVGGDDXGXDG"), "ATTACK");
    }
}
