package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.model.PartType;

public class TextParser {

    private static SymbolParser symbolParser = new SymbolParser();
    private static WordParser wordParser = new WordParser(symbolParser);
    private static LexemeParser lexemeParser = new LexemeParser(wordParser);
    private static SentenceParser sentenceParser = new SentenceParser(lexemeParser);
    private static ParagraphParser parser = new ParagraphParser(sentenceParser);

    public static Part parse(String content){
        Part text = new ContainerPart(PartType.TEXT);
        parser.parse(text, content);
        return text;
    }

}
