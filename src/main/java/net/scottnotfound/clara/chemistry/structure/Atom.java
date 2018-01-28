package net.scottnotfound.clara.chemistry.structure;

import net.scottnotfound.clara.chemistry.structure.element.Element;

/** Base class for representing an atom */
public class Atom {

    /** The type of element an atom is, this should never change */
    public final Element ELEMENT;
    /** unique identifier to tell atoms of the same type apart */
    private int uniqueID;

    public Atom() {
        this.ELEMENT = Element.INVALID;
    }

    public Atom(Element element) {
        this.ELEMENT = element;
    }

    public Atom(int uniqueID) {
        //todo: deal with invalid atom creation
        this.ELEMENT = Element.INVALID;
        this.uniqueID = uniqueID;
    }

    public Atom(Element element, int uniqueID) {
        this.ELEMENT = element;
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    private int setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
        return this.uniqueID;
    }

    @Override
    public int hashCode() {
        return uniqueID;
    }
}
