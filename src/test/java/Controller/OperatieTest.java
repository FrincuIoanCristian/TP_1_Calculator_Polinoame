package Controller;

import Model.Polinom;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatieTest {

    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;
    Operatie operatie = new Operatie();

    @AfterAll
    static void mesaj() {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care " + nrTesteCuSucces + " au avut succes!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @AfterEach
    void tearDown() {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    void verificarePolinom() {
        Polinom p1 = new Polinom("3ZX^2+5X^2-%");
        assertNull(p1.getPolinom());
        nrTesteCuSucces++;
    }

    @Test
    void verificarePolinom2() {
        Polinom p1 = new Polinom("3X^2+5X^6-7");
        assertNotNull(p1.getPolinom());
        nrTesteCuSucces++;
    }

    @Test
    void adunare() {
        Polinom p1 = new Polinom("4X^5-3X^4+X^2-8X+1");
        Polinom p2 = new Polinom("3X^4-X^3+X^2+2X-1");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("4X^5-X^3+2X^2-6X", operatie.adunare(p1, p2).toString());
        nrTesteCuSucces++;
    }

    @Test
    void adunare2() {
        Polinom p1 = new Polinom("4X^5-3X^4+X^2-8X+1");
        Polinom p2 = new Polinom("-4X^5+3X^4-X^2+8X-1");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("0", operatie.adunare(p1, p2).toString());
        nrTesteCuSucces++;
    }

    @Test
    void scadere() {
        Polinom p1 = new Polinom("4X^5-3X^4+X^2-8X+1");
        Polinom p2 = new Polinom("3X^4-X^3+X^2+2X-1");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("4X^5-6X^4+X^3-10X+2", operatie.scadere(p1, p2).toString());
        nrTesteCuSucces++;
    }

    @Test
    void inmultire() {
        Polinom p1 = new Polinom("3X^2-X+1");
        Polinom p2 = new Polinom("X-2");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("3X^3-7X^2+3X-2", operatie.inmultire(p1, p2).toString());
        nrTesteCuSucces++;
    }

    @Test
    void inmultire2() {
        Polinom p1 = new Polinom("3X^2-X+1");
        Polinom p2 = new Polinom("0");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("0", operatie.inmultire(p1, p2).toString());
        nrTesteCuSucces++;
    }

    @Test
    void impartire() {
        Polinom p1 = new Polinom("X^3-2X^2+6X-5");
        Polinom p2 = new Polinom("X^2-1");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        Polinom[] result = operatie.impartire(p1, p2);
        assertEquals("X-2", result[0].toString());
        assertEquals("7X-7", result[1].toString());
        nrTesteCuSucces++;
    }

    @Test
    void impartire2() {
        Polinom p1 = new Polinom("0");
        Polinom p2 = new Polinom("X^3+4X^2+5");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        Polinom[] result = operatie.impartire(p1, p2);
        assertEquals("0", result[0].toString());
        assertEquals("0", result[1].toString());
        nrTesteCuSucces++;
    }

    @Test
    void impartireLa0() {
        Polinom p1 = new Polinom("X^3+4X^2+5");
        Polinom p2 = new Polinom("0");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        Polinom[] result = operatie.impartire(p1, p2);
        assertNull(result);
        nrTesteCuSucces++;
    }

    @Test
    void derivare() {
        Polinom p = new Polinom("X^3-2X^2+6X-5");
        assertNotNull(p.getPolinom());
        assertEquals("3X^2-4X+6", operatie.derivare(p).toString());
        nrTesteCuSucces++;
    }

    @Test
    void integrare() {
        Polinom p = new Polinom("X^3+4X^2+5");
        assertNotNull(p.getPolinom());
        assertEquals("0.25X^4+1.33X^3+5X", operatie.integrare(p).toString());
        nrTesteCuSucces++;
    }

    @Test
    void testPicat1() {
        Polinom p1 = new Polinom("2X^2+5X");
        Polinom p2 = new Polinom("5X-2");
        assertNotNull(p1.getPolinom());
        assertNotNull(p2.getPolinom());
        assertEquals("5X-2", operatie.adunare(p1, p2).toString());
    }

    @Test
    void testPicat2() {
        Polinom p = new Polinom("2XX^4+5X");
        assertNotNull(p.getPolinom());
    }
}