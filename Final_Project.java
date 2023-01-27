import java.io.*;
import java.util.*;
public class Final_Project {
    //Scanner is an alternative but BR is faster for input
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    //Graph class
    static Graph graph = new Graph();
    //Converts friend name into numerical ID
    static HashMap<String, Integer> friendToID = new HashMap<>();
    //Converts ID back to friend string
    static ArrayList<String> IDtoFriend = new ArrayList<>();
    //Keeps track of total number of friends
    static int numFriends = 0;
    //BFS queue for each friend
    static Queue<Qitem>[] q;
    //Visited array to avoid re-traversing friends
    static boolean[][] visited;
    
    //Takes input and converts to ID
    //also adds edge to graph
    public static void connectFriends() throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        String friendA = st.nextToken();
        String friendB = st.nextToken();
        if (!friendToID.containsKey(friendA)) {
            numFriends++;
            friendToID.put(friendA, numFriends);
            IDtoFriend.add(friendA);
        }
        if (!friendToID.containsKey(friendB)) {
            numFriends++;
            friendToID.put(friendB, numFriends);
            IDtoFriend.add(friendB);
        }
        graph.addUndirectedEdge(friendToID.get(friendA), friendToID.get(friendB));
    }

    public static void main(String[] args) throws IOException {
        IDtoFriend.add(""); //offset 0 indexing
        StringTokenizer st = new StringTokenizer(input.readLine());
        int numConnections = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numConnections; i++) {
            connectFriends();
        }
        q = new Queue[numFriends+1];
        visited = new boolean[numFriends+1][numFriends+1];
        for (int i = 1; i <= numFriends; i++) {
            q[i] = new LinkedList<>();
            visited[i][i] = true;
            //adds neighbors of each node to its queue
            for (int j: graph.adj.get(i)) {
                q[i].add(new Qitem(j, 0));
                visited[i][j] = true;
            }
        }
        for (int i = 0; i < numQueries; i++) {
            String friend = input.readLine();
            if (!friendToID.containsKey(friend)) {
                throw new RuntimeException(friend + " does not exist");
            }
            int id = friendToID.get(friend);
            if (q[id].isEmpty()) {
                System.out.println(friend + " has no more friends to recommend");
                continue;
            }
            int thisdist = q[id].peek().dist;//make sure we're not traversing entire graph
            ArrayList<Integer> popped = new ArrayList<>();
            //Breadth-First-Search
            while (!q[id].isEmpty() && q[id].peek().dist == thisdist) {
                Qitem curr = q[id].poll();
                popped.add(curr.node);
                for (int j: graph.adj.get(curr.node)) {
                    if (!visited[id][j]) {
                        q[id].add(new Qitem(j, curr.dist+1));
                        visited[id][j] = true;
                    }
                 }
            }
            System.out.print("Recommended friends are: ");
            for (int j: popped) {
                System.out.print(IDtoFriend.get(j)+" ");
            }
            System.out.println();
        }
        input.close();
    }
}
