package Model;

public class Case {
    public enum TypeCase{
        rien,
        un,
        deux,
        trois,
        quatre,
        cinq,
        six,
        sept,
        huit,
        mine
    }

    public enum EtatCase{
        normal,
        revele,
        drapeau,
        interrogation
    }

    private TypeCase type;


    private EtatCase etat;

    public EtatCase getEtat() {
        return etat;
    }

    public void setEtat(EtatCase etat) {
        this.etat = etat;
    }


    public TypeCase getType() {
        return type;
    }

    public void setType(TypeCase type) {
        this.type = type;
    }
}
