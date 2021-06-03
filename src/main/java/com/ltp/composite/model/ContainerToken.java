package com.ltp.composite.model;

import com.ltp.composite.parser.SymbolParser;

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
        String result = "";
        switch (getType()){
            case PARAGRAPH:
                result = String.format("\t%s\n", tokens.stream().map(Token::toString).collect(Collectors.joining(" ")));
                break;
            case SENTENCE:
            case LEXEME:
                result = String.format("%s%s",
                        tokens.stream()
                                .limit(tokens.size() - 1)
                                .map(Token::toString)
                                .collect(Collectors.joining(" ")),
                        tokens.get(tokens.size() - 1).toString());
                break;
            case TEXT:
            case WORD:
                result = tokens.stream().map(Token::toString).collect(Collectors.joining());
                break;
        }
        return result;
    }
}
