package com.ltp.composite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Part implements Iterable<Part>{
    private PartType type;

    public abstract Part get(int index);
    public abstract void remove(Part part);
    public abstract void add(Part part);

}
