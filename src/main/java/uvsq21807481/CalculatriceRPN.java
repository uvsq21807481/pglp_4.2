package uvsq21807481;

public class CalculatriceRPN {

    public static void main(String[] args) {
        MoteurRPN mrpn = new MoteurRPN();
        SaisieRPN srpn = new SaisieRPN(mrpn);
        while(true) {
            srpn.saisie();
            System.out.print(mrpn.getStack());
        }
    }
}
