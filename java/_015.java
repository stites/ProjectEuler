/*
 * Lattice paths
 * Problem 15
 * Starting in the top left corner of a 2×2 grid, and only being able to
 * move to the right and down, there are exactly 6 routes to the bottom
 * right corner.
 *
 * see: https://projecteuler.net/project/images/p_015.gif
 *
 * How many such routes are there through a 20×20 grid?
 */

// first stab at recursion in java!

public class _015 {
  private static int pathCount = 0;
  private static int latticeSize;

  public static void walkLattice(int x, int y) {
    if ((x == latticeSize) && (y == latticeSize)) {
      pathCount++;
      System.out.println(pathCount);
      return;
    }
    if (x < latticeSize) walkLattice(x + 1, y);
    if (y < latticeSize) walkLattice(x, y + 1);
  }

  public static void main(String[] args){
    latticeSize = Integer.parseInt(args[0]);
    walkLattice(0, 0);
    System.out.println(pathCount);
  }
}

