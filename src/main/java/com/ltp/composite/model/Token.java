package com.ltp.composite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public abstract class Token{

    private List<Token> content;
    @Getter
    private TokenType type;

    public abstract Token get(int index);
    public abstract void remove(Token token);
    public abstract void add(Token token);

}
