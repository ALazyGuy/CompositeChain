package com.ltp.composite.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerToken extends Token {

    private List<Token> tokens;

    public ContainerToken(TokenType type){
        super(type);
        tokens = new LinkedList<>();
    }

    public Token get(int index) {
        return tokens.get(index);
    }

    public void remove(Token token) {
        tokens.remove(token);
    }

    public void add(Token token) {
        tokens.add(token);
    }

    @Override
    public Iterator<Token> iterator() {
        return tokens.iterator();
    }

    @Override
    public int hashCode() {
        return 17 * tokens.stream().mapToInt(Token::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        ContainerToken current = (ContainerToken)obj;
        return current.hashCode() == hashCode() && getType() == current.getType();
    }

    @Override
    public String toString() {
        return String.format("{ %s -> %s }", getType().name(), tokens.stream().map(Token::toString).collect(Collectors.joining(", ")));
    }
}
