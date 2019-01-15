final class FasciaOraria {


    private final int oraInizio;
    private final int oraFine;
    private int personeInCoda;

    FasciaOraria(int oraInizio, int oraFine) {
        if (oraInizio >= 0 && oraFine > 0 && oraFine <= 24 && oraInizio < oraFine) {
            this.oraInizio = oraInizio;
            this.oraFine = oraFine;
        } else {
            this.oraInizio=0;
            this.oraFine=1;
        }
    }


    int getOraInizio() {
        return oraInizio;
    }

    int getOraFine() {
        return oraFine;
    }

    int getPersoneInCoda() {
        return personeInCoda;
    }

    void setPersoneInCoda(int personeInCoda) {
        this.personeInCoda = personeInCoda;
    }
}
