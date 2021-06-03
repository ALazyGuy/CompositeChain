package com.ltp.composite.parser;

import com.ltp.composite.model.SymbolToken;
import com.ltp.composite.model.Token;

public class SymbolParser extends AbstractParser {

    public SymbolParser(){
        super(null);
    }

    @Override
    public void parse(Token token, String content) {
        char[] symbols = content.toCharArray();
        for(char c : symbols){
            token.add(new SymbolToken(c));
        }
    }
}
