final class BigliettoIntegrato extends Biglietto {

    private final Biglietto bigliettoDaIntegrare;

    BigliettoIntegrato(Sito sitoDiRiferimento, Biglietto bigliettoDaIntegrare){
        super(sitoDiRiferimento);
        this.bigliettoDaIntegrare=bigliettoDaIntegrare;
        if (ApplicativoTurismo.argomenti.contains("v")){
            System.out.println("Biglietto per "+sitoDiRiferimento.getNome()+" decorato con biglietto per "+bigliettoDaIntegrare.getSitoDiRiferimento().getNome());
        }
    }

    final Biglietto getBigliettoDaIntegrare() {
        return bigliettoDaIntegrare;
    }

    @Override
    void revocaPrenotazione() {
        getSitoDiRiferimento().revocaPrenotazione(getPrenotazione());
        bigliettoDaIntegrare.revocaPrenotazione();
        setPrenotazione(null);
    }

    @Override
    float getPrezzo() {
        return (bigliettoDaIntegrare.getPrezzo()+super.getSitoDiRiferimento().getPrezzoIngresso())*(100-Tariffazione.percentualeSconto)/100;
    }
}
