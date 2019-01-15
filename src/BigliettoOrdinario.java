final class BigliettoOrdinario extends Biglietto {

    BigliettoOrdinario(Sito sitoDiRiferimento) {
        super(sitoDiRiferimento);
    }

    @Override
    void revocaPrenotazione() {
        getSitoDiRiferimento().revocaPrenotazione(getPrenotazione());
        setPrenotazione(null);
    }

    @Override
    float getPrezzo() {
        return super.getSitoDiRiferimento().getPrezzoIngresso();
    }
}
