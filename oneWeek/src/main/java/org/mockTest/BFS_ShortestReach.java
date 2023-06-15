package org.mockTest;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        if(n < 1 || edges == null || edges.size() < 1 || s < 1) return null;

        //Step 1
        Set<Integer> [] tree = new Set[n];
        for(List<Integer> edge : edges){
            int a = edge.get(0);
            int b = edge.get(1);

            if(tree[a-1] == null){
                tree[a-1] = new HashSet<Integer>();
            }
            tree[a-1].add(b);

            if(tree[b-1] == null){
                tree[b-1] = new HashSet<Integer>();
            }
            tree[b-1].add(a);
        }

        //Step 2
        List<Integer> res = new ArrayList<>();

        //start from S
        for(int i = 0; i < n-1; i++){
            res.add(-1);
        }

        Set<Integer> root = tree[s-1]; //tree[s-1] = HashSet
        if(root == null) return res;

        Queue<Integer> queue = new LinkedList<Integer>();
        for(Integer r : root){
            queue.add(r);
        }

        int height = 1;

        boolean[] visited = new boolean[n];
        visited[s-1] = true;

        while(!queue.isEmpty()){
            Deque<Integer> queuen = new LinkedList<>();

            while(!queue.isEmpty()){
                int v = queue.poll();
                if(!visited[v-1]){
                    visited[v-1] = true;
                    //update distances
                    if(v > s){
                        res.set(v-2, height * 6);
                    }
                    else{
                        res.set(v-1, height * 6);
                    }

                    if(tree[v-1] != null){
                        for(Integer r : tree[v-1]){
                            queuen.add(r);
                        }
                    }
                }
            }
            queue = queuen;
            height++;
        }

        return res;

    }

}
public class BFS_ShortestReach {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
