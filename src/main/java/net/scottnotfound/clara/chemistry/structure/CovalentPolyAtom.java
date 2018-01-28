package net.scottnotfound.clara.chemistry.structure;


import net.scottnotfound.clara.chemistry.structure.element.Element;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is essentially a Graph data structure consisting of Atoms (vertices) and Bonds (edges).
 * It is used to represent covalent substances.
 */
public class CovalentPolyAtom {

    /** Graph data */
    private Set<CovalentAtom> atoms;
    private Set<CovalentBond> bonds;
    private Map<CovalentAtom, Set<CovalentBond>> adjacentList;


    public CovalentPolyAtom() {
        this.atoms = new HashSet<>();
        this.bonds = new HashSet<>();
        this.adjacentList = new HashMap<>();
    }

    public boolean addAtom(CovalentAtom atom) {
        return this.atoms.add(atom);
    }

    public boolean addAtom(Element element, int id) {
        return addAtom(new CovalentAtom(element, id));
    }

    public boolean addAtoms(Collection<CovalentAtom> atoms) {
        return this.atoms.addAll(atoms);
    }

    public boolean removeAtom(int label) {
        return this.atoms.remove(new CovalentAtom(label));
    }

    public boolean removeAtom(CovalentAtom atom) {
        return this.atoms.remove(atom);
    }

    public boolean removeAtoms(Collection<CovalentAtom> atoms) {
        return this.atoms.removeAll(atoms);
    }

    public boolean addBond(CovalentBond bond) {
        if (!bonds.add(bond)) return false;

        adjacentList.putIfAbsent(bond.atom_a, new HashSet<>());
        adjacentList.putIfAbsent(bond.atom_b, new HashSet<>());

        adjacentList.get(bond.atom_a).add(bond);
        adjacentList.get(bond.atom_b).add(bond);

        return true;
    }

    public boolean addBond(CovalentAtom atom_a, CovalentAtom atom_b) {
        return addBond(new CovalentBond(atom_a, atom_b));
    }

    public boolean removeBond(CovalentBond bond) {
        if (!bonds.remove(bond)) return false;
        Set<CovalentBond> bondsAtomA = adjacentList.get(bond.atom_a);
        Set<CovalentBond> bondsAtomB = adjacentList.get(bond.atom_b);

        if (bondsAtomA != null) bondsAtomA.remove(bond);
        if (bondsAtomB != null) bondsAtomB.remove(bond);

        return true;
    }

    public boolean removeBond(int atomLabelA, int atomLabelB) {
        return removeBond(new CovalentBond(atomLabelA, atomLabelB));
    }

    public Collection<CovalentAtom> getAdjacentAtoms(CovalentAtom atom) {
        return adjacentList.get(atom).stream().map(bond -> bond.atom_a.equals(atom) ? bond.atom_b : bond.atom_a).collect(Collectors.toSet());
    }

    public Collection<CovalentAtom> getAtoms() {
        return Collections.unmodifiableCollection(atoms);
    }

    public Collection<CovalentBond> getBonds() {
        return Collections.unmodifiableCollection(bonds);
    }

    public Map<CovalentAtom, Collection<CovalentBond>> getAdjacentList() {
        return Collections.unmodifiableMap(adjacentList);
    }

}
