abstract class Biglietto {

    private final Sito sitoDiRiferimento;


    private Prenotazione prenotazione;

    Biglietto(Sito sitoDiRiferimento) {
        this.sitoDiRiferimento = sitoDiRiferimento;
    }


    Sito getSitoDiRiferimento() {
        return sitoDiRiferimento;
    }

    Prenotazione getPrenotazione() {
        return prenotazione;
    }

    void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    abstract void revocaPrenotazione();

    abstract float getPrezzo();


}
