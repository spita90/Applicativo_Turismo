import java.util.ArrayList;
import java.util.HashMap;

class GestoreSuggerimenti {

    private final static ArrayList<Percorso> percorsiDisponibili = new ArrayList<>();
    private static HashMap<Double, Sito> sitiDaBigliettoConDistanze = new HashMap<Double, Sito>() {
    };

    static void addPercorso(Percorso percorso) {
        percorsiDisponibili.add(percorso);
    }

    static String ottieniSuggerimenti(Biglietto biglietto, Posizione posizioneAttuale) {
        //controlla se biglietto ha siti contenuti in percorsi disponibili
        //e restituisci il percorso che contiene il sito più vicino (calcolaDistanzaLineaDAria)

        //vedo quali siti ho compresi nel biglietto e ne memorizzo le distanze
        popolaSitiDaBigliettoConDistanze(biglietto, posizioneAttuale);

        //sceglie sito più vicino
        Sito sitoPiuVicino = null;
        Double distanzaMinima = 99999999.0;
        for (HashMap.Entry sito :
                sitiDaBigliettoConDistanze.entrySet()) {
            if ((Double) sito.getKey() < distanzaMinima) {
                distanzaMinima = (Double) sito.getKey();
                sitoPiuVicino = (Sito) sito.getValue();
            }
        }
        if (ApplicativoTurismo.argomenti.contains("v")) {
            if (sitoPiuVicino != null) {
                System.out.println("Il sito (incluso nel biglietto) più vicino è: " + sitoPiuVicino.getNome());
            }
        }

        Percorso percorsoProponibile = null;
        for (Percorso percorso :
                percorsiDisponibili) {
            if (percorso.getLuoghiAttraversati().contains(sitoPiuVicino)) {
                percorsoProponibile = percorso;
                if(ApplicativoTurismo.argomenti.contains("v")){
                    System.out.println("il quale è contenuto nel percorso: "+percorsoProponibile.getNomePercorso());
                }
                break;
            }
        }
        sitiDaBigliettoConDistanze = null;

        if (percorsoProponibile != null) {
            StringBuilder risultato = new StringBuilder("Il percorso consigliato in base al suo biglietto e alla sua posizione è il seguente:\n");
            risultato.append(percorsoProponibile.getNomePercorso()).append("\n");
            risultato.append("il quale attraversa i seguenti luoghi:\n");
            for (Luogo luogo :
                    percorsoProponibile.getLuoghiAttraversati()) {
                risultato.append(luogo.getNome()).append("\n");
            }
            return risultato.toString();
        } else {
            return "Nessun percorso trovato";
        }
    }

    private static void popolaSitiDaBigliettoConDistanze(Biglietto biglietto, Posizione posizioneAttuale) {
        if (biglietto instanceof BigliettoIntegrato) {
            popolaSitiDaBigliettoConDistanze(((BigliettoIntegrato) biglietto).getBigliettoDaIntegrare(), posizioneAttuale);
            sitiDaBigliettoConDistanze.put(calcolaDistanzaLineaDAria(biglietto.getSitoDiRiferimento().getPosizione(), posizioneAttuale), biglietto.getSitoDiRiferimento());
        } else if (biglietto instanceof BigliettoOrdinario) {
            sitiDaBigliettoConDistanze.put(calcolaDistanzaLineaDAria(biglietto.getSitoDiRiferimento().getPosizione(), posizioneAttuale), biglietto.getSitoDiRiferimento());
        }
    }

    private static double calcolaDistanzaLineaDAria(Posizione pos1, Posizione pos2) {
        double diffLat = Math.abs(pos1.getLat() - pos2.getLat());
        double diffLon = Math.abs(pos1.getLon() - pos2.getLon());
        return Math.sqrt(diffLat * diffLat + diffLon * diffLon);
    }

}
