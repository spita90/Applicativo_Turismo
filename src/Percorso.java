import java.util.ArrayList;

class Percorso {

    private final ArrayList<Luogo> luoghiAttraversati = new ArrayList<>();
    private final String nomePercorso;

    Percorso(String nomePercorso) {
        if (nomePercorso != null) {
            this.nomePercorso = nomePercorso;
        }else{
            this.nomePercorso = "Percorso senza nome";
        }
    }

    void addLuogo(Luogo luogo) {
        if (luogo != null) {
            luoghiAttraversati.add(luogo);
        }
    }

    void removeLuogo(Luogo luogo) {
        if (luogo != null) {
            luoghiAttraversati.remove(luogo);
        }
    }


    ArrayList<Luogo> getLuoghiAttraversati() {
        return luoghiAttraversati;
    }


    String getNomePercorso() {
        return nomePercorso;
    }
}
