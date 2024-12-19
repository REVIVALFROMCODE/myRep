package org.Graph;

//For decouple graph and data-processing
//Create a Graph object
//Pass the Graph to graph-processing routine
//Query routine for information
public abstract class Paths {
    abstract boolean hasPathTo(int v);
        //Is there a path from s to v

    abstract Iterable<Integer> pathTo(int v);
}
