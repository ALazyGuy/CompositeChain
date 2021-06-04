package com.ltp.composite.model;

import lombok.Getter;

import java.util.Iterator;

@Getter
public class SymbolPart extends Part {

    private char value;

    public SymbolPart(char value){
        super(PartType.SYMBOL);
        this.value = value;
    }

    @Override
    public Part get(int index) {
        throw new UnsupportedOperationException("There is no operation 'get' in symbol token");
    }

    @Override
    public void remove(Part part) {
        throw new UnsupportedOperationException("There is no operation 'remove' in symbol token");
    }

    @Override
    public void add(Part part) {
        throw new UnsupportedOperationException("There is no operation 'add' in symbol token");
    }

    @Override
    public Iterator<Part> iterator() {
        throw new UnsupportedOperationException("There is no iterator in symbol token");
    }

    @Override
    public int hashCode() {
        return (int)value * 17;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != getClass()) return false;
        SymbolPart current = (SymbolPart)obj;
        return current.getValue() == value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
