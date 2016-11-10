package com.natasha.sourceit.task11;

/**
 * Created by Stas on 09.11.2016.
 */
public class OverLoadException extends Exception{
    private Samosval samosval;

    public OverLoadException(Samosval samosval) {
        this.samosval = samosval;
    }

    public String toString(){
        return "Samosval overloaded " + (samosval.checkGrus() - samosval.getMaxLiftWeight());
    }

}
