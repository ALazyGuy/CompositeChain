package com.ltp.composite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Token{
    private TokenType type;

    public abstract Token get(int index);
    public abstract void remove(Token token);
    public abstract void add(Token token);

}
