class ServizioNotifiche {

    private static Biglietto biglietto;

    private static Posizione posizioneCorrente;


    static void attiva(Biglietto biglietto, Posizione posizioneCorrente) {
        //implementare
    }

    static void disattiva() {
        //implementare
    }

    static void updatePosizione(Posizione posizioneCorrente){
        ServizioNotifiche.posizioneCorrente =posizioneCorrente;
    }

    static Posizione getPosizioneCorrente() {
        return posizioneCorrente;
    }
}
