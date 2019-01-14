import java.util.ArrayList;

class Sito extends Luogo {

    private final float prezzoIngresso;
    private final boolean necessitaPrenotazione;
    private final ArrayList<FasciaOraria> fasceOrarie = new ArrayList<>();
    private final int capienza;


    Sito(String nome, Posizione posizione, IndirizzoWeb indirizzoWeb, float prezzoIngresso, int oraApertura, int oraChiusura, int capienza, boolean necessitaPrenotazione) {
        super(nome, posizione, indirizzoWeb);
        if (oraApertura >= 0 && oraChiusura > 0 && oraChiusura <= 24 && oraApertura < oraChiusura) {
            for (int i = oraApertura; i < oraChiusura; i++) {
                fasceOrarie.add(new FasciaOraria(i, i + 1));
            }
            this.prezzoIngresso = prezzoIngresso;
            this.capienza = capienza;
            this.necessitaPrenotazione = necessitaPrenotazione;
        } else {
            this.prezzoIngresso = 0;
            this.capienza = 0;
            this.necessitaPrenotazione = false;
        }
    }


    Prenotazione rilasciaPrenotazione() {
        boolean success = false;
        FasciaOraria orarioPrenotazione = null;
        for (FasciaOraria orario :
                fasceOrarie) {
            if (orario.getPersoneInCoda() < capienza) {
                orario.setPersoneInCoda(orario.getPersoneInCoda() + 1);
                orarioPrenotazione = orario;
                success = true;
                break;
            }
        }
        if (success) {
            if (ApplicativoTurismo.argomenti.contains("v")) {
                System.out.println("Prenotazione riuscita per " + getNome() + " alle ore " + orarioPrenotazione.getOraInizio());
            }
            return new Prenotazione(orarioPrenotazione);
        } else {
            if (ApplicativoTurismo.argomenti.contains("v")) {
                System.out.println("Prenotazione fallita per " + getNome());
            }
            return null;
        }
    }

    void revocaPrenotazione(Prenotazione prenotazioneDaRevocare) {
        if (necessitaPrenotazione && prenotazioneDaRevocare != null) {
            prenotazioneDaRevocare.getOrario().setPersoneInCoda(prenotazioneDaRevocare.getOrario().getPersoneInCoda() - 1);
            if(ApplicativoTurismo.argomenti.contains("v")){
                System.out.println("Prenotazione per "+getNome()+" alle ore "+prenotazioneDaRevocare.getOrario().getOraInizio()+" revocata");
            }
        }
    }


    float getPrezzoIngresso() {
        return prezzoIngresso;
    }

    boolean necessitaPrenotazione() {
        return necessitaPrenotazione;
    }
}
