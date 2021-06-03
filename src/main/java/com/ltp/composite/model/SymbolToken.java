package com.ltp.composite.model;

import lombok.Getter;

import java.util.Iterator;

@Getter
public class SymbolToken extends Token {

    private char value;

    public SymbolToken(char value){
        super(TokenType.SYMBOL);
        this.value = value;
    }

    @Override
    public Token get(int index) {
        throw new UnsupportedOperationException("There is no operation 'get' in symbol token");
    }

    @Override
    public void remove(Token token) {
        throw new UnsupportedOperationException("There is no operation 'remove' in symbol token");
    }

    @Override
    public void add(Token token) {
        throw new UnsupportedOperationException("There is no operation 'add' in symbol token");
    }

    @Override
    public Iterator<Token> iterator() {
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
        SymbolToken current = (SymbolToken)obj;
        return current.getValue() == value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
