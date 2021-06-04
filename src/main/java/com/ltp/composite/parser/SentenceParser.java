package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.SymbolToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

public class SentenceParser extends AbstractParser{

    public SentenceParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Token token, String content) {
        String[] sentences = content.split(SENTENCE_DELIMITER);
        for(String sentence : sentences){
            Token sentence1 = new ContainerToken(TokenType.SENTENCE);
            next.parse(sentence1, sentence.replaceAll("[!.?]$", ""));
            sentence1.add(new SymbolToken(sentence.charAt(sentence.length() - 1)));
            token.add(sentence1);
        }
    }
}
