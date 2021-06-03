package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.SymbolToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

import java.util.Arrays;

public class LexemeParser extends AbstractParser{

    public LexemeParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Token token, String content) {
        String[] lexemes = content.split(" ");
        for(String lexeme : lexemes){
            Token lexeme1 = new ContainerToken(TokenType.LEXEME);
            next.parse(lexeme1, lexeme.replaceAll(",", ""));
            if(lexeme.endsWith(",")){
                lexeme1.add(new SymbolToken(','));
            }
            token.add(lexeme1);
        }
    }
}
