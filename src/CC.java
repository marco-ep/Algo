/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class CC {



        private static ArrayList<String> inData;

        public static void main(String[] args) throws IOException {
            loadFile(new File("/Users/marcopalacios/Desktop/algo/src/data.txt"));
            String[] nodeEdgeNum = inData.get(0).split(" ");
            int nodeNum = Integer.parseInt(nodeEdgeNum[0]);
            Graph graph = new Graph((nodeNum + 1));

            for (int i = 1; i < inData.size(); i++) {
                String[] edgeLine = inData.get(i).split(" ");
                int from = Integer.parseInt(edgeLine[0]);
                int to = Integer.parseInt(edgeLine[1]);
                graph.addEdge(from, to, false);
            }

            Stack<Integer> nodeStack = new Stack<Integer>();
            int count = 0;

            for (int i = 1; i <= nodeNum; i++) {
                if (graph.isVisited(i) == false) {
                    graph.setVisited(i);
                    nodeStack.push(i);

                    while (nodeStack.isEmpty() == false) {
                        int v = graph.getUnvisitedAdjNode(nodeStack.peek());

                        if (v == -1) {
                            nodeStack.pop();
                        } else {
                            graph.setVisited(v);
                            nodeStack.push(v);
                        }
                    }

                    count++;
                }
            }

            System.out.println(count);
        }

        private static void loadFile(File aFile) throws IOException {
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            String line = null;
            inData = new ArrayList<String>();

            while ((line = input.readLine()) != null) {
                inData.add(line);
            }

            input.close();
        }
    }

    class Graph {
        private int adjMat[][];
        private int nVert;
        private boolean wasVisited[];

        public Graph(int N) {
            nVert = N;
            adjMat = new int[N][N];
            wasVisited = new boolean[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjMat[i][j] = 0;
                }

                wasVisited[i] = false;
            }
        }

        public void addEdge(int i, int j, boolean directed) {
            adjMat[i][j] = 1;

            if (directed == false) {
                adjMat[j][i] = 1;
            }
        }

        public int[] getAdjNodes(int i) {
            int d = degree(i);
            int nodes[] = new int[d];
            int idx = 0;

            for (int j = 0; j < nVert; j++) {
                if (adjMat[i][j] == 1) {
                    nodes[idx] = j;
                    idx++;
                }
            }

            return nodes;
        }

        public int getUnvisitedAdjNode(int i) {
            int[] nodes = this.getAdjNodes(i);

            for (int j = 0; j < nodes.length; j++) {
                if (wasVisited[nodes[j]] == false) {
                    return nodes[j];
                }
            }

            return -1;
        }

        public void setVisited(int i) {
            wasVisited[i] = true;
        }

        public boolean isVisited(int i) {
            return wasVisited[i];
        }

        public int degree(int i) {
            int d = 0;

            for (int j = 0; j < nVert; j++) {
                d += adjMat[i][j];
            }

            return d;
        }
    }
//}
*/