package org.Graph;

import java.util.Stack;

public class DepthFirstPaths extends Paths{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;//source

    public DepthFirstPaths(Graph G, int s){
        //init
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v]=true;
        for(int w: G.adj(v)){//iterate adjacent vertex
            if(!markde[w]){
                dfs(G,w);
                edgeTo[w]=v;
            }
        }
    }
    // as a result, w has marked is equal to w connected to s
    // how to continue if w is unmarked? consider dfs(G,w) and maintain DS.
    // Analyze
    // can find all vertices connected to s in constant time(see below),
    // and can find a path to s in time proportional to length
    @Override
    boolean hasPathTo(int v){
        //Is there a path from s to v
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        //opposite order to keep track of path
        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
