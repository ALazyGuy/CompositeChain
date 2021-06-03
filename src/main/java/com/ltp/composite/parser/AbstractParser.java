package com.ltp.composite.parser;

import com.ltp.composite.model.Token;

public abstract class AbstractParser {

    protected final String SENTENCE_DELIMITER = "(?<=[!?.])\\s";

    protected AbstractParser next;

    public AbstractParser(AbstractParser abstractParser){
        this.next = abstractParser;
    }

    public abstract void parse(Token token, String content);
}
