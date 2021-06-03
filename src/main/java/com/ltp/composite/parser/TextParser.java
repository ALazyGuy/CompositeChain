package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

public class TextParser {

    private static SymbolParser symbolParser = new SymbolParser();
    private static WordParser wordParser = new WordParser(symbolParser);
    private static LexemeParser lexemeParser = new LexemeParser(wordParser);
    private static SentenceParser sentenceParser = new SentenceParser(lexemeParser);
    private static ParagraphParser parser = new ParagraphParser(sentenceParser);

    public static Token parse(String content){
        Token text = new ContainerToken(TokenType.TEXT);
        parser.parse(text, content);
        return text;
    }

}
