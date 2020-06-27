package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    
    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return zone[ptr-1];
    }

    public int capacite() {
        // a completer
        return zone.length;
    }

    public int taille() {
        // a completer
        return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        if (!(o instanceof Pile)) {
            return false;
        }
        
        Pile newpile = (Pile) o;
        
        if (newpile.taille() == 0 && this.taille() == 0)
            return true;

        if (newpile.taille() == 0 || this.taille() == 0)
            return false;
            
        if (this.capacite() != newpile.capacite() || this.taille() != newpile.taille()) {
            return false;
        }

        for (int i = ptr - 1; i >= 0; i--){
            if (this.zone[i] != newpile.zone[i] )
                return false;
        }
    
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}