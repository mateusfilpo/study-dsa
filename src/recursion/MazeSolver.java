package recursion;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolver {

    private static final int[][] DIRECTIONS = {
            {1, 0},  // top
            {0, 1},  // right
            {0, -1}, // bottom
            {-1, 0}  // left
    };

    public static boolean walk(
            String[] maze,
            char wall,
            Point curr,
            Point end,
            boolean[][] seen,
            List<Point> path
    ) {
        // BASE CASE
        // 1. If the location is off the map
        if (curr.x < 0 || curr.x >= maze[0].length() || curr.y < 0 || curr.y >= maze.length) {
            return false;
        }

        // 2. If we meet a wall
        if (maze[curr.y].charAt(curr.x) == wall) {
            return false;
        }

        // 3. If the end is reached
        if (curr.x == end.x && curr.y == end.y) {
            path.add(end);
            return true;
        }

        // 4. If an old step is reached
        if (seen[curr.y][curr.x]) {
            return false;
        }

        // ------------------------------
        // RECURSIVE CASES
        // PRE
        seen[curr.y][curr.x] = true;
        path.add(curr);

        // DURING
        for (int[] direction : DIRECTIONS) {
            int newX = curr.x + direction[0];
            int newY = curr.y + direction[1];
            Point newCurr = new Point(newX, newY);

            if (walk(maze, wall, newCurr, end, seen, path)) {
                return true;
            }
        }

        // POST
        path.remove(path.size() - 1);

        return false;
    }

    public static List<Point> mazeSolver(String[] maze, char wall, Point start, Point end) {
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        List<Point> path = new ArrayList<>();

        walk(maze, wall, start, end, seen, path);

        return path;
    }

    public static void main(String[] args) {
        String[] maze = {
        		"xxxxxxxxxx x",
                "x        x x",
                "x        x x",
                "x xxxxxxxx x",
                "x          x",
                "x xxxxxxxxxx",
        };
        char wall = 'x';
        Point start = new Point(10, 0);
        Point end = new Point(1, 5);

        List<Point> path = mazeSolver(maze, wall, start, end);

        for (Point p : path) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
