package com.ltp.composite.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TextToken extends Token {

    private List<Token> tokens;

    public TextToken(){
        super(TokenType.TEXT);
        tokens = new LinkedList<>();
    }

    public Token get(int index) {
        return tokens.get(index);
    }

    public void remove(Token token) {
        tokens.remove(token);
    }

    public void add(Token token) {
        if(token.getType() != TokenType.SENTENCE) return;
        tokens.add(token);
    }

    @Override
    public int hashCode() {
        return 17 * tokens.stream().mapToInt(Token::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        TextToken current = (TextToken)obj;
        return current.hashCode() == hashCode();
    }

    @Override
    public String toString() {
        return String.format("TEXT [%s]", tokens.stream().map(Token::toString).collect(Collectors.joining(", ")));
    }
}
