package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
        /** la capacite de la pile */
        private int capacite;
        
        /** la taille actuelle de la pile */
        private int taille;
    
    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>(taille);
        this.capacite = taille;
        this.taille =  0;
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.v.addElement(o);
        this.taille ++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        
        this.taille --;
        return this.v.remove(taille);
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.v.lastElement();
    }

    public int taille() {
        // à compléter
        return this.taille;
    }

    public int capacite() {
        // à compléter
        return this.capacite;
    }

    public boolean estVide() {
        // a completer
        return taille==0;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        return taille==capacite;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");

        for (int i = taille - 1; i >= 0; i--) {
            sb.append(this.v.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        
        sb.append("]");
        
        return sb.toString();
    }

   public boolean equals(Object o) {
        // a completer
        if (!(o instanceof Pile3)) {
            return false;
        }
        
        Pile3 newpile = (Pile3) o;
        
        if (newpile.taille() == 0 && this.taille() == 0)
            return true;

        if (newpile.taille() == 0 || this.taille() == 0)
            return false;
            
        if (this.capacite() != newpile.capacite() 
            || this.taille() != newpile.taille()) {
                return false;
        }
        
        for (int i = taille - 1; i >= 0; i--){
            if (newpile.v.get(i) != this.v.get(i) )
                return false;
        }
  
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
