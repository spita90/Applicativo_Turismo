import java.util.ArrayList;
import java.util.Arrays;

class Applicativo_Turismo {

    static final ArrayList<String> argomenti = new ArrayList<>();

    public static void main(String[] args) {

        if (args.length > 0) {
            argomenti.addAll(Arrays.asList(args));
        }

        argomenti.add("v");              //uncomment for verbose output

        Sito torreDiPisa = new Sito("Torre di Pisa", new Posizione(43.416, 10.716), new IndirizzoWeb("www.torredipisa.com"), 15, 8, 20, 100, true);
        Sito cattedraleDiPisa = new Sito("Cattedrale di Pisa", new Posizione(43.415, 10.715), new IndirizzoWeb("www.torrepisa.com/cattedrale-pisa"), 5, 8, 22, 500, false);
        Sito battisteroSGiovanni = new Sito("Battistero di San Giovanni", new Posizione(43.414, 10.716), new IndirizzoWeb("www.visittuscany.com/it/attrazioni/il-battistero-di-pisa"), 35, 15, 18, 10, true);
        AltroLuogoDiInteresse negozioDiSouvenirPiazzaDeiMiracoli = new AltroLuogoDiInteresse("Souvenir dei Miracoli", new Posizione(43.413, 10.715), null);

        Sito ortoBotanicoDiPisa = new Sito("Orto Botanico di Pisa", new Posizione(43.420, 10.720), new IndirizzoWeb("www.ortomuseobot.sma.unipi.it"), 5, 10, 18, 1000, false);
        AltroLuogoDiInteresse paninaroAccantoAllOrtoBotanico = new AltroLuogoDiInteresse("Da Ciccio il Lampredottaro", new Posizione(43.421, 10.721), null);


        Percorso percorso1 = new Percorso("Percorso Piazza dei Miracoli");
        percorso1.addLuogo(torreDiPisa);
        percorso1.addLuogo(cattedraleDiPisa);
        percorso1.addLuogo(battisteroSGiovanni);
        percorso1.addLuogo(negozioDiSouvenirPiazzaDeiMiracoli);

        Percorso percorso2 = new Percorso("Percorso Botanico");
        percorso2.addLuogo(ortoBotanicoDiPisa);
        percorso2.addLuogo(paninaroAccantoAllOrtoBotanico);

        GestoreSuggerimenti.addPercorso(percorso1);
        GestoreSuggerimenti.addPercorso(percorso2);


        Biglietto bigliettoPiazzaDeiMiracoli = new BigliettoIntegrato(torreDiPisa, new BigliettoIntegrato(cattedraleDiPisa, new BigliettoOrdinario(battisteroSGiovanni)));
        //Biglietto bigliettoTorreDiPisa = new BigliettoOrdinario(torreDiPisa);

        Posizione posPippo = new Posizione(43.880, 11.096);
        Utente pippo = new Utente(posPippo, 100);

        if (pippo.compraBiglietto(bigliettoPiazzaDeiMiracoli)) {
            pippo.setDenaroAccount(pippo.getDenaroAccount() - bigliettoPiazzaDeiMiracoli.getPrezzo());
            System.out.println("Biglietto OK\n");
            System.out.println(GestoreSuggerimenti.ottieniSuggerimenti(bigliettoPiazzaDeiMiracoli, posPippo));
        } else {
            System.out.println("Biglietto FAIL\n");
            pippo.revocaBiglietto();
        }
    }
}
