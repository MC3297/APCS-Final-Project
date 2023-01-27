//Struct to pass in queue
public class Qitem {
    public int node, dist;
    public Qitem(int anode, int adist) {
        this.node = anode;
        this.dist = adist;
    }
    public String toString() {
        return "("+node+","+dist+")";
    }
}