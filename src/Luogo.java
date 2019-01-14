abstract class Luogo {

    private String nome;
    private Posizione posizione;
    private IndirizzoWeb indirizzoWeb;


    Luogo(String nome, Posizione posizione, IndirizzoWeb indirizzoWeb){
        this.nome = nome;
        this.posizione=posizione;
        this.indirizzoWeb=indirizzoWeb;
    }


    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }


    Posizione getPosizione() {
        return posizione;
    }

    void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }


    IndirizzoWeb getIndirizzoWeb() {
        return indirizzoWeb;
    }

    void setIndirizzoWeb(IndirizzoWeb indirizzoWeb) {
        this.indirizzoWeb = indirizzoWeb;
    }
}
