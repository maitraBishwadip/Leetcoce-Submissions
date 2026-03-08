class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

// Step 1 : Setting up the adjacency list and the indegree map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();
//Initializing all course with 0 dependency so that dep with 0 does not get ignored
        for(int i=0; i<numCourses;i++)
        {
            inDegree.put(i,0);
        }
        
    

//Step:2 Creating The Adjacency List and then updating the number of dependencies in the inDegree map


for(int[] edge : prerequisites)
{
    int course = edge[0]; //u
    int prereq = edge[1]; //v  Is is given that the first member is course and the next is dependency

// I need pre req to course [pre] : [0,1,2,3...]
    graph.computeIfAbsent(prereq, k-> new ArrayList<>()).add(course); // Graph Created

    //Now I need to increase ( Update ) the indegree of course that is added 
    inDegree.put(course , inDegree.get(course)+1);
    // say [0,1] [0,2] intitially the in degree was 0 then 1 and then 2
}

//Step: 3 starting the Kahn's Algorithm I will add the courses with 0 dependency to the queue and process the queue and for each neighbour (dependent) of the node I will reduce the InDegree and add the node to result array

ArrayDeque<Integer>     queue = new ArrayDeque<>(); 

for(int key : inDegree.keySet()) // keySet() returns a set of the key that is hold by key variable one each time. Like [0]:[....] [1]:[.....] the set returned is [0,1] and key is 0,1 and so on
{
    if(inDegree.get(key) == 0)
    {
        queue.add(key); // The without dependency ones will be put in the queue to be processed.
    }
}

//Step : 4 The result Array

int[] result = new int[numCourses];
int idx = 0;


//Step: 5 Doing the standard DFS where remove each last queue element from queue and add them to the result array and reduce the inDegree of the dependent courses

while(!queue.isEmpty())
{
    int node = queue.poll();

    result[idx++] = node;


    // Now of the node is present in graph then I am reducing it s neighbours inDEGree
     // Note that the graph stores one key and list of nodes thet are  dependent on it
     // so for nodes that are with out any outgoing edge then it will have no edges then it will return the initialised value
    if(graph.containsKey(node))
    {
       for(int neighbour: graph.get(node)) // all dependents of node are stored in neighbour TODO: check why getOrDefault can not be used 
       {
        inDegree.put(neighbour, inDegree.get(neighbour) -1); // IN inDegree updating the neighbour and reducing it s indegree dependency by 1

        if(inDegree.get(neighbour) == 0)
        {
            queue.add(neighbour); //If after reducing the neighbor has 0 dependencies adding it in the queue so that it will be processed next and added to the result array
        }
       }
    }

    // if the  idx is equal to the number of courses then returning the result array as there is no cycle but if not then there is a cycle in the graph and so returning the empty array.
}


    return idx==numCourses ? result : new int[0] ;
    }



}