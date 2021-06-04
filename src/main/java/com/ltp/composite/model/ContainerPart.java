package com.ltp.composite.model;

import lombok.Getter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerPart extends Part {

    @Getter
    private List<Part> parts;
    @Getter
    private int length = 0;

    public ContainerPart(PartType type){
        super(type);
        parts = new LinkedList<>();
    }

    public Part get(int index) {
        return parts.get(index);
    }

    public void remove(Part part) {
        parts.remove(part);
        if(part.getType() == PartType.SYMBOL){
            length--;
        }else{
            calculateLength();
        }
    }

    public void add(Part part) {
        parts.add(part);
        if(part.getType() == PartType.SYMBOL) {
            length++;
        }else{
            calculateLength();
        }
    }

    public void calculateLength(){
        length = parts.stream().mapToInt(token -> ((ContainerPart)token).getLength()).max().orElse(0);
    }

    @Override
    public Iterator<Part> iterator() {
        return parts.iterator();
    }

    @Override
    public int hashCode() {
        return 17 * parts.stream().mapToInt(Part::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        ContainerPart current = (ContainerPart)obj;
        return current.hashCode() == hashCode() && getType() == current.getType();
    }

    @Override
    public String toString() {
        String result = "";
        switch (getType()){
            case PARAGRAPH:
                result = String.format("\t%s", parts.stream().map(Part::toString).collect(Collectors.joining(" ")));
                break;
            case SENTENCE:
            case LEXEME:
                result = String.format("%s%s",
                        parts.stream()
                                .limit(parts.size() - 1)
                                .map(Part::toString)
                                .collect(Collectors.joining(" ")),
                        parts.get(parts.size() - 1).toString());
                break;
            case TEXT:
                result = parts.stream().map(Part::toString).collect(Collectors.joining("\n"));
                break;
            case WORD:
                result = parts.stream().map(Part::toString).collect(Collectors.joining());
                break;
        }
        return result;
    }
}
