package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

public class WordParser extends AbstractParser{

    public WordParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Token token, String content) {
        String[] words = content.split("\\s");
        for(String word : words){
            Token token1 = new ContainerToken(Character.isLetter(word.charAt(0)) ? TokenType.WORD : TokenType.EXPRESSION);
            next.parse(token1, word);
            token.add(token1);
        }
    }
}
