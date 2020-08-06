import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Graphs {
	public static class graph{
		int v;
		LinkedList<Integer>[] adjList;
		LinkedList<Integer[]>[] adjList1;
		graph(int no){
			v = no;
			adjList = new LinkedList[no];
			adjList1 = new LinkedList[no];
			for(int i=0;i<v;i++){
				adjList[i]= new LinkedList<Integer>();
				adjList1[i] = new LinkedList<Integer[]>();			}
		}
	}
	public static void addUndirectedEdge(graph g,int s ,int w){
		g.adjList[s].add(w);
		g.adjList[w].add(s);
	}
	public static void adddirectedEdge(graph g,int s ,int w){
		g.adjList[s].add(w);
	}
	public static void printAdjencyList(graph g){
		for(int i=0;i<g.adjList.length;i++){
			System.out.println(i+"  for the edge");
			for(int j=0;j<g.adjList[i].size();j++){
				System.out.println(g.adjList[i].get(j)+" is an edges");
			}
			System.out.println('\n');
		}
	}
	public static void BFS(graph g,int n){
		boolean visited[] = new boolean[g.v];
		Queue q = new LinkedList();
		visited[n] = true;
		q.add(n);
		while(!q.isEmpty()){
			int node = (int) q.poll();
			System.out.println(node + "linked with");
			for(int i=0;i<g.adjList[node].size();i++){
				if(visited[g.adjList[node].get(i)]==false){
					q.add(g.adjList[node].get(i));
					visited[g.adjList[node].get(i)] = true;
				}
			}
		}
	}
	public static void DFS(graph g,int n){
		boolean visited[] = new boolean[g.v];
		Stack q = new Stack();
		visited[n] = true;
		q.add(n);
		while(!q.isEmpty()){
			int node = (int) q.pop();
			System.out.println(node + "linked with");
			for(int i=0;i<g.adjList[node].size();i++){
				if(visited[g.adjList[node].get(i)]==false){
					q.add(g.adjList[node].get(i));
					visited[g.adjList[node].get(i)] = true;
				}
			}
		}
	}
	public static void recursiveDFS(graph g,int n){
		boolean visited[] = new boolean[g.v];
		for(int i=0;i<g.v;i++){
			if(visited[i] == false){
				recursiveUtilDFS(g,i,visited);
			}
		}
	}
	public static void recursiveUtilDFS(graph g,int n,boolean[] visited){
		visited[n] = true;
		System.out.println(n+"node");
		for(int i=0;i<g.adjList[n].size();i++){
			if(visited[g.adjList[n].get(i)] == false){
				recursiveUtilDFS(g, g.adjList[n].get(i), visited);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph g = new graph(5);
		addUndirectedEdge(g, 0, 1);
		addUndirectedEdge(g, 0, 2);
		addUndirectedEdge(g, 1, 2);
		addUndirectedEdge(g, 1, 3);
		addUndirectedEdge(g, 2, 3);
		addUndirectedEdge(g, 3, 4);
		//printAdjencyList(g);
		//BFS(g,0);
		//DFS(g,0);
		recursiveDFS(g,0);
	}

}
