package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;
    
    /** la taille actuelle de la pile */
    private int taille;
    
    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite = taille;
        this.taille =  0;
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
        this.taille ++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        
        this.taille --;
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
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

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");

            for (int i = taille - 1; i >= 0; i--) {
                sb.append(this.stk.get(i).toString());
                if (i > 0)
                    sb.append(", ");
            }
        
            sb.append("]");
        
        return sb.toString();
    }

    public boolean equals(Object o) {
        // a completer
        if (!(o instanceof Pile2)) {
            return false;
        }
            
        Pile2 newpile = (Pile2) o;
            
        if (newpile.taille() == 0 && this.taille() == 0)
            return true;

        if (newpile.taille() == 0 || this.taille() == 0)
            return false;
            
        if (this.capacite() != newpile.capacite() || this.taille() != newpile.taille()) {
            return false;
        }

        for (int i = taille - 1; i >= 0; i--){
            if (newpile.stk.get(i) != this.stk.get(i) )
                return false;
        }
            
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return this.taille;
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }

} // Pile2.java
