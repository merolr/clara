package net.scottnotfound.clara.chemistry.structure;

/** Represents a bond that is mostly covalent in nature */
public class CovalentBond extends Bond {

    protected CovalentAtom atom_a;
    protected CovalentAtom atom_b;

    public CovalentBond(Atom atom_a, Atom atom_b) {
        super(atom_a, atom_b);
        this.atom_a = (CovalentAtom) atom_a;
        this.atom_b = (CovalentAtom) atom_b;
    }

    public CovalentBond(int id_a, int id_b) {
        super(id_a, id_b);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CovalentBond)) return false;

        CovalentBond n_object = (CovalentBond) object;
        return n_object.atom_a.equals(this.atom_a) && n_object.atom_b.equals(this.atom_b);
    }



}
