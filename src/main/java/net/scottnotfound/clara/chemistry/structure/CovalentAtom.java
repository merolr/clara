package net.scottnotfound.clara.chemistry.structure;


import net.scottnotfound.clara.chemistry.structure.element.Element;
import net.scottnotfound.clara.chemistry.structure.element.IElement;

/** Represents an atom participating in a covalent bond */
public class CovalentAtom extends Atom implements IElement {

    public CovalentAtom(Element element) {
        super(element);
    }

    public CovalentAtom(int uniqueID) {
        super(uniqueID);
    }

    public CovalentAtom(Element element, int uniqueID) {
        super(element, uniqueID);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CovalentAtom)) return false;

        CovalentAtom n_object = (CovalentAtom) object;
        return n_object.hashCode() == this.hashCode();
    }

}
