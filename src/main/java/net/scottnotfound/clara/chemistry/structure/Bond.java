package net.scottnotfound.clara.chemistry.structure;


/** Base class for representing a bond */
public class Bond {

    protected Atom atom_a;
    protected Atom atom_b;
    //todo: deal with a two-electron three-centered bond
    //todo: deal with an atom bonding to another bond


    public Bond(Atom atom_a, Atom atom_b) {
        this.atom_a = atom_a;
        this.atom_b = atom_b;
    }

    public Bond(int id_a, int id_b) {
        this.atom_a = new Atom(id_a);
        this.atom_b = new Atom(id_b);
    }

    @Override
    public int hashCode() {
        int result = atom_a.hashCode();
        result = 31 * result + atom_b.hashCode();
        result = 31 * result;
        return result;
    }

    public Atom getAtom_a() {
        return atom_a;
    }

    public Atom getAtom_b() {
        return atom_b;
    }
}
