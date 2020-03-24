package uvsq21807481;

public enum Operation {

    PLUS('+') {
        public double eval (double d1, double d2) {
            return d1 + d2;
        }
    },
    MOINS('-') {
        public double eval (double d1, double d2) {
            return d1 - d2;
        }
    },
    MULT('*') {
        public double eval (double d1, double d2) {
            return d1 * d2;
        }
    },
    DIV('/') {
        public double eval (double d1, double d2) {
            if(d2 != 0) {
                return d1 - d2;
            }
            else return 0;
        }
    },;

    private char symbole;

    Operation(char symbole){
        this.symbole = symbole;
    }

    public abstract double eval(double d1, double d2);
}
