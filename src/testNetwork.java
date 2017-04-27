import java.util.LinkedList;

/**
 * Created by Giulia on 18/04/2017.
 */
public class testNetwork {
    public static void main(String[] args){

        MyNetwork network = new MyNetwork();

        T node0 = new T<String>("s");
        T node1 = new T<String>("1");
        T node2 = new T<String>("2");
        T node3 = new T<String>("3");
        T node4 = new T<String>("4");
        T node5 = new T<String>("t");
        T node6 = new T<String>("x");
        T node7 = new T<String>(".");
        network.addNode(node0);
        network.addNode(node1);
        network.addNode(node2);
        network.addNode(node3);
        network.addNode(node4);
        network.addNode(node5);
        network.addNode(node6);
        network.addNode(node7);
        try {
            network.addEdge(node0, node1);
            network.addEdge(node0, node2);
            network.addEdge(node0, node3);
            network.addEdge(node0, node4);
            network.addEdge(node1, node5);
            network.addEdge(node1, node6);
            network.addEdge(node1, node7);
            network.addEdge(node2, node6);
            network.addEdge(node4, node7);
            network.setSource(node0);
            network.setTarget(node6);
            LinkedList<T> path = (LinkedList<T>) network.shortestPath();
            for (T node : path){
                System.out.println(node.label);
            }
        } catch (NoSuchNodeException e) {

            e.printStackTrace();
        } catch (NoSuchPathException e) {
            e.printStackTrace();
        }

    }
}
