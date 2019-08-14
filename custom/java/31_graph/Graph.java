

//无向图
public class Graph{
	private int v; //顶点个数
	//数组链表
	private LinkedList<Integer> adj[]; //邻接表

	public Graph(int v){
		this.v = v;
		adj = new LinkedList<Integer>[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList<>();
		}
	}

	//s：start, t:target
	public void addEdge(int s,int t){ //无向图，一条边存两次
		adj[s].add[t];
		adj[t].add[s];
	}


	//广度优先搜索BFS （Breadth-First-Search）
	//visited 用来记录已经被访问的顶点，用来避免顶点被重复访问；
	//queue，队列。用来存储已经被访问，但相连顶点还没有访问的顶点。
	//       因为BFS是逐层访问的。只有把第k层的顶点访问--》(k+1)
	//prev,用来记录搜索路径，不过，这路径是反向存储的。
	//     prev[w]存储的是，顶点w是从哪个前驱节点访问过来的。
	public void bfs(int s,int t){
		if(s == t) return;
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		int[] prev = new int[v];
		for (int i = 0;i < v ; i++ ) {
			prev[i] = -1;
		}
		while(queue.size() != 0){
			int w = queue.poll();// 出队
			for (int i = 0; adj[w].size() ;i++ ) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					if (q == t) {
						print(prev,s,t);
						return;
					}
				}
				visited[q] = true;
				queue.add(q);
			}
		}

	}

	//递归打印s-->t的路径
	private void print(int[] prev,int s,int t){
		if(prev[t] != -1 && t!= s){
			print(prev,s,prev[t]);
		}
		System.out.println(t + " ");
	}

	//***********************深度优先算法*****************************//

	boolean found = false;

	public void dfs(int s, int t){
		found = false;
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0;i < v ;i++ ) {
			prev[i] = -1;
		}
		recurDfs(s,t,visited,prev);
		print(prev,s,t);
	}

	private void recurDfs(int w, int t, boolean[] visited,int[] prev){
		if(found == true) return;
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i  = 0; i < adj[w].size() ; i++ ) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q,t,visited,prev);
			}
		}
	}
}

