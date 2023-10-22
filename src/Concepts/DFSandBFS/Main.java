package Concepts.DFSandBFS;

import java.util.*;

public class Main { // DFS and BFS Simple Implementation
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(4, 3, 2));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(7, 6));

        depthFirstSearch(graph, 1);
        breadthFirstSearch(graph, 1);
    }

    static void depthFirstSearch(Map<Integer, List<Integer>> map, int v) {

        List<Integer> discovered = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(!discovered.contains(pop)){
                discovered.add(pop);
                System.out.println("pop = " + pop);
                if(map.get(pop) == null) {continue;} // if there is no child node.
                for(int w : map.get(pop)){
                    stack.push(w);
                }
            }
        }
    }

    static void breadthFirstSearch(Map<Integer, List<Integer>> map, int v){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> discovered = new ArrayList<>();

        queue.add(v);

        while(!queue.isEmpty()){
            Integer removed = queue.remove();
            if(!discovered.contains(removed)){
                System.out.println("removed = " + removed);
                discovered.add(removed);
                if(map.get(removed) == null) {continue;}
                for(int w : map.get(removed)){
                    queue.add(w);
                }
            }
        }
    }
}
