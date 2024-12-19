package org.Graph;

public class Graph {
    private final int V;
    private Bag<Integer>[] adj;//each vertex associate with a bag to store adjacent vertices
    //We implement with such way , because in real world, graphs tend to be sparse rather dense
    //huge number of vertices. small average vertex degree.
    public Graph(int V){
        this.V=V;
        adj=(Bag<Integer>[])new Bag[V];//
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>();
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Intger> adj(int v){
        return adj[v];
    }

    void dfs(){
        // Goal
        // To find path between two vertices, we can find all vertices connected to s(and a corresponding path)
        // Algorithm
        // mark vertex v as visited, recursively visit all unmarked vertices w adjacent to v
        // return when no unvisited options ,finally keep track of edge taken to visit it
        // Data Structure
        // boolean[] marked to mark visited vertices
        // int[] edgeTo to keep tree of paths, edgeTo[w]==v means reach w from v, skip if there is already a value
    }
}
