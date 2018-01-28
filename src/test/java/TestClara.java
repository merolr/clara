import net.scottnotfound.clara.chemistry.structure.*;
import net.scottnotfound.clara.chemistry.structure.element.Element;


public class TestClara {

    public static void main(String[] args) {

        attemptMethane();

    }

    public static void attemptMethane() {
        // attempt to make methane
        System.out.println("Attempting to represent methane");
        Atom h1 = new CovalentAtom(Element.HYDROGEN, 1);
        Atom h2 = new CovalentAtom(Element.HYDROGEN, 2);
        Atom h3 = new CovalentAtom(Element.HYDROGEN, 3);
        Atom h4 = new CovalentAtom(Element.HYDROGEN, 4);
        Atom c1 = new CovalentAtom(Element.CARBON, 5);
        System.out.println("Initialized atoms");
        Bond c1h1 = new CovalentBond(c1, h1);
        Bond c1h2 = new CovalentBond(c1, h2);
        Bond c1h3 = new CovalentBond(c1, h3);
        Bond c1h4 = new CovalentBond(c1, h4);
        System.out.println("Initialized bonds");
        CovalentPolyAtom methane = new CovalentPolyAtom();
        methane.addAtom((CovalentAtom) h1);
        methane.addAtom((CovalentAtom) h2);
        methane.addAtom((CovalentAtom) h3);
        methane.addAtom((CovalentAtom) h4);
        methane.addAtom((CovalentAtom) c1);
        methane.addBond((CovalentBond) c1h1);
        methane.addBond((CovalentBond) c1h2);
        methane.addBond((CovalentBond) c1h3);
        methane.addBond((CovalentBond) c1h4);
        System.out.println("Constructed methane");
        System.out.println("Bonds:");
        for (Bond bond : methane.getBonds()) {
            System.out.println(bond.getAtom_a().ELEMENT.name + " - " + bond.getAtom_b().ELEMENT.name);
        }
        System.out.println("Atoms:");
        for (Atom atom : methane.getAtoms()) {
            System.out.println(atom.ELEMENT.name);
        }
        System.out.println("Atoms connected to carbon:");
        for (Atom atom : methane.getAdjacentAtoms((CovalentAtom) c1)) {
            System.out.println(atom.ELEMENT.name);
        }
    }
}
