package recursion;

import java.util.List;
import java.util.Stack;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MazeSoluer {
	
	public static String[] maze = {"##### #", 
									"#     #", 
									"# #####"};
	
	private static int[][] dir = {
		    {-1, 0},
		    {1, 0},
		    {0, -1},
		    {0, 1}
		};
	
	public static boolean walk(String[] maze, String wall, Point curr, Point end, boolean[][] seen, Stack<Point> path) {
		
		// 1. Base Case
		// off the map
		if (curr.x < 0 || curr.x >= maze[0].length() ||
			curr.y < 0 || curr.y >= maze.length) {
			
			return false;
		}
		
		// on a wall
		if (String.valueOf(maze[curr.y].charAt(curr.x)) == wall) {
			return false;
		}
		
		// its the end
		if (curr.x == end.x && curr.y == end.y) {
			path.push(end);
			return true;
		}
		
		// if we have seen it
		if (seen[curr.y][curr.x]) {
			return false;
		}
		
		// 3 recurse
		// pre
		path.add(curr);
		
		// recurse
		for (int i = 0; i < dir.length; i++) {
			int x = dir[i][0];
			int y = dir[i][1];
			if (walk(maze, wall, new Point(x, y), end, seen, path)) {
				return true;
			}
		}
		
		// post
		path.pop();
		
		return false;
		
	}
	
	public static List<Point> solve(String[] maze, String wall, Point start, Point end) {
		
		boolean[][] seen = new boolean[maze.length][maze[0].length()];
		Stack<Point> path = new Stack<>();
		
		for (int i = 0; i < maze.length; i++) {
			seen[i] = new boolean[maze[0].length()];
	    }
		
		walk(maze, wall, start, end, seen, path);
		
		return path;
	}
	
	public static void main(String[] args) {
		List<Point> result = MazeSoluer.solve(MazeSoluer.maze, "#", new Point(2, 1), new Point(0, 5));
		for(Point p : result) {
			System.out.println(p.x + " " + p.y);
		}
	}

}
