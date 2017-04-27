import java.util.*;

/**
 * Created by giuli on 06/04/2017.
 */
public class MyNetwork implements Network<T>{

    Set<T> Nodes;
    int NumbNodes;
    T s;
    T t;

    MyNetwork(){
        NumbNodes = 0;
        s = null;
        t = null;
        Nodes = new HashSet<T>();
    }

    public T source() {
        return s;
    }

    public T target() {
        return t;
    }

    public void setSource(T newsource) throws NoSuchNodeException {
        if(!Nodes.contains(newsource)) throw  new NoSuchNodeException();
        s = newsource;
    }

    public void setTarget(T newtarget) throws NoSuchNodeException {
        if(!Nodes.contains(newtarget)) throw  new NoSuchNodeException();
        t = newtarget;
    }

    public void addNode(T v) {
        if (!Nodes.contains(v)){
            Nodes.add(v);
            NumbNodes++;
        }
    }

    public void addEdge(T p, T a) throws NoSuchNodeException {
        if (!Nodes.contains(p) || !Nodes.contains(a)) throw new NoSuchNodeException();
        p.adj.add(a);
    }
    public void bfsForShortestPath(){
        for (T node : Nodes){
            node.discovered = false;
            node.rootDistance = -1;
            node.pi = null;
        }
        Queue<T> Q = new LinkedList<T>();
        Q.add(s);
        T current;
        s.rootDistance = 0;
        LinkedList<T> adjs;
        while(!Q.isEmpty()){
            current = Q.poll();
            adjs = current.getAdj();
            for (T adj : adjs){
                if(!adj.discovered){
                    adj.discovered = true;
                    adj.rootDistance = current.rootDistance + 1;
                    adj.pi = current;
                    Q.add(adj);
                }
            }
        }

    }

    public LinkedList<T> shortestPath () throws NoSuchPathException {
        LinkedList<T> p = new LinkedList<T>();
        bfsForShortestPath();
        if (t.pi == null) throw new NullPointerException();

        T current = t;
        while (current != s){
            p.add(current);
            current = current.pi;
        }
        p.add(s);

        Collections.reverse(p);

        return p;
    }
}


class T <E>{
    E label;
    boolean discovered;
    int rootDistance;
    T pi;
    LinkedList<T> adj;

    T(E label){
        this.label = label;
        discovered = false;
        adj = new LinkedList<T>();
        rootDistance = -1;
        pi = null;
    }
    public LinkedList<T> getAdj(){
        return adj;
    }
}
class NoSuchNodeException extends Exception {}
class NoSuchPathException extends Exception {}