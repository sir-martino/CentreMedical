package Code;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Patient {
    public String nom;
    public String prenom;
    public String nbSS;
    public String dateNaissance;
    public ArrayList<Consultation> consultations;
    public ArrayList<Pathologie> pathologies;

    public Patient() {

    }

    public Patient(String nom, String prenom, String nbSS, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        if(!verif(nbSS)){
            throw new NbSecuriteSocialeException("numero de securité sociale invalide "+ nbSS.toString());
        }
        this.nbSS = nbSS;
        this.dateNaissance = dateNaissance;
        // le patient est associe a une liste de patient et une liiste de consultation,
        this.pathologies = new ArrayList<Pathologie>();
        this.consultations = new ArrayList<Consultation>();
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNbSS() {
        return this.nbSS;
    }

    public void setNbSS(String nbSS) {
        this.nbSS = nbSS;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaisssance) {
        this.dateNaissance = dateNaisssance;
    }

    public void ajouterConsultation(Consultation consultation) {
        if (!this.consultations.contains(consultation)) {
            this.consultations.add(consultation);
        } else
            throw new InputMismatchException("cette concultation existe déjà");

    }

    public void ajouterPathologie(Pathologie pathologie) {
        // appeler sous la forme ajouterPathologie.COUDE (tout ce qui se trouve dans enum)
        this.pathologies.add(pathologie);
    }

    public String toString() {
        return this.getNom() + "/" + this.getPrenom() + "/" + this.getNbSS() + "/" + this.getDateNaissance() + "\n";
    }

    private boolean verif(String NbSS) {
        // = numero seciurite sociale
        // verification nombre si c'est des chiffres //si il y en a 13 pil
        char Chiffre = ' ';
        if (NbSS.length() != 13) {
            return false;
        }
        // initialisation du tableau de l'alphabet
        char Alphabet[] = new char[26];
        for (int i = 0; i < NbSS.length(); i++) {
            Chiffre = NbSS.charAt(i);
            // utilisation ascii
            for (int j = 97; j < 122; j++) {
                if (Chiffre == (Alphabet[i])) {
                    return false;
                }
            }
        }
        return  true;
    }
}