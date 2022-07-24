class Solution {
    
    
    Set<Float> visited;
    int result;
    char [][]grid;

    // the coordinate (x, y) is 1, and it should be added to visited.
    // now we need to check if any of its neigbor is also island.
    private void visit(int x, int y) {
        // check above
        visited.add(transform(x, y));
        if (x != 0 && this.grid[x-1][y] == '1' && !visited.contains(transform(x-1, y))) {
            visit(x-1, y);
        }
        // check left
        if (y != 0 && this.grid[x][y-1] == '1' && !visited.contains(transform(x, y-1))) {
            visit(x, y-1);
        }
        // check below
        if (x != grid.length-1 && grid[x+1][y] == '1' && !visited.contains(transform(x+1, y))) {
            visit(x+1, y);
        }
        //check right
        if (y != grid[0].length-1 && grid[x][y+1] == '1' && !visited.contains(transform(x, y+1))) {
            visit(x, y+1);
        }
    }


    // convert an coordinate to a floating point;
    private float transform(int x, int y) {
        StringBuilder sb = new StringBuilder("0.");
        sb.append(String.valueOf(y));
        return (float)x + Float.parseFloat(sb.toString());
    }

    public int numIslands(char[][] grid) {
        this.visited = new HashSet();
        this.grid = grid;
        this.result=0;
        for (int i = 0; i < grid.legnth; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(transform(i, j))) {
                    this.result++;
                    visit(i, j);
                }
            }
        }
        return this.result;
    }
}