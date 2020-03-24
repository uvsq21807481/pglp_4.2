package uvsq21807481;

import org.junit.Test;
import static org.junit.Assert.*;

public class testMoteurRPN {

    @Test
    public void testEnregistrement() {
        MoteurRPN mrpn = new MoteurRPN();
        mrpn.enregistrement(25);
        assertTrue(mrpn.pile.pop() == 25);
    }

    @Test
    public void testSave() {
        MoteurRPN mrpn = new MoteurRPN();
        Enregistrement e = new Enregistrement(mrpn, 25);
        e.apply();
        assertTrue(mrpn.pile.pop() == 25);
    }

    @Test
    public void testCalcul() {
        MoteurRPN mrpn = new MoteurRPN();
        mrpn.enregistrement(25);
        mrpn.enregistrement(25);
        mrpn.calcul(Operation.PLUS);
        assertTrue(mrpn.pile.pop() == 50);
    }

    @Test
    public void testCompute() {
        MoteurRPN mrpn = new MoteurRPN();
        mrpn.enregistrement(25);
        mrpn.enregistrement(25);
        Calcul c = new Calcul(mrpn, Operation.PLUS);
        c.apply();
        assertTrue(mrpn.pile.pop() == 50);
    }
}
