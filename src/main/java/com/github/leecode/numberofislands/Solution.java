package com.github.leecode.numberofislands;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        // 定义答案
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        // 减枝
        if (n == 0 || m == 0) return ans;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return ans;
    }

    void dfs(char[][] grid, int x, int y, int n, int m) {
        // 减枝非法枝
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int xNew = x + dx[i];
            int yNew = y + dy[i];
            dfs(grid, xNew, yNew, n, m);
        }
    }

}