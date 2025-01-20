/*
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
*/
//Solution1 recursive DFS
class Solution {
    boolean[] isVisited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        isVisited = new boolean[rooms.size()];
        dfs(rooms,0);
        for(boolean check:isVisited) if(!check) return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int curNo){
        if(isVisited[curNo]) return;
        isVisited[curNo]=true;
        for(Integer roomNo:rooms.get(curNo)){
            dfs(rooms,roomNo);
        }
        return;
    }
}

//Solution2 Iterative DFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Start from room 0
        stack.push(0);
        isVisited[0] = true;
        int visitedCount = 1;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for (int key : rooms.get(currentRoom)) {
                if (!isVisited[key]) {
                    stack.push(key);
                    isVisited[key] = true;
                    visitedCount++;
                }
            }
        }
        return visitedCount == n;
    }
}
