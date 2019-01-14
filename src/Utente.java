class Utente {


    private Biglietto biglietto;

    private Posizione posizione;


    private float denaroAccount;

    private boolean primaIterazioneAcquisto = true;

    Utente(Posizione posizione, float denaroAccount) {
        this.posizione = posizione;
        this.denaroAccount = denaroAccount;
    }


    Biglietto getBiglietto() {
        return biglietto;
    }

    boolean compraBiglietto(Biglietto bigliettoSelezionato) {
        if (denaroAccount >= bigliettoSelezionato.getPrezzo()) {
            if (bigliettoSelezionato instanceof BigliettoOrdinario) {
                if(primaIterazioneAcquisto){
                    this.biglietto=bigliettoSelezionato;
                }
                if (bigliettoSelezionato.getSitoDiRiferimento().necessitaPrenotazione()) {
                    bigliettoSelezionato.setPrenotazione(bigliettoSelezionato.getSitoDiRiferimento().rilasciaPrenotazione());
                    return bigliettoSelezionato.getPrenotazione() != null;
                } else {
                    return true;
                }
            } else if (bigliettoSelezionato instanceof BigliettoIntegrato) {
                if(primaIterazioneAcquisto){
                    this.biglietto=bigliettoSelezionato;
                    primaIterazioneAcquisto=false;
                }
                if (compraBiglietto(((BigliettoIntegrato) bigliettoSelezionato).getBigliettoDaIntegrare())) {
                    if (bigliettoSelezionato.getSitoDiRiferimento().necessitaPrenotazione()) {
                        bigliettoSelezionato.setPrenotazione((bigliettoSelezionato.getSitoDiRiferimento().rilasciaPrenotazione()));
                        return bigliettoSelezionato.getPrenotazione() != null;
                    } else return true;
                }
            }
        }
        return false;
    }


    void revocaBiglietto() {
        if (biglietto != null) {
            biglietto.revocaPrenotazione();
            biglietto = null;
        }
    }


    Posizione getPosizione() {
        return posizione;
    }

    void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    float getDenaroAccount() {
        return denaroAccount;
    }

    void setDenaroAccount(float denaroAccount) {
        this.denaroAccount = denaroAccount;
    }

}
