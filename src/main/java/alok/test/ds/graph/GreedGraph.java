package alok.test.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class GreedGraph<T> {

    private int numberOfRows, numberOfCols;
    private T landValue;
    private T[][] matrix;

    public GreedGraph(T[][] matrix, T landValue) {
        this.matrix = matrix;
        this.landValue = landValue;

        if (matrix != null) {
            numberOfRows = matrix.length;
            numberOfCols = matrix[0].length;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (T[] row: matrix) {
            for (T col: row) {
                string.append(col).append(" ");
            }
            string.append("\n");
        }
        return string.toString();
    }

    public int findNumberOfIseland() {
        Set<String> visitedGrid = new HashSet<>();

        int count = 0;

        for (int i = 0; i < numberOfRows; ++i) {
            for (int j = 0; j < numberOfCols; ++j) {
                count += exploreGrid(i, j, visitedGrid);
            }
        }

        return count;
    }

    private int exploreGrid(int i, int j, Set<String> visitedGrid) {
        if (i < 0 || i >= numberOfRows || j < 0 || j >= numberOfCols)
            return 0;

        String gridIndex = i + "," + j;
        if (visitedGrid.contains(gridIndex) || !matrix[i][j].equals(landValue)) {
            return 0;
        }

        visitedGrid.add(gridIndex);
        // now mark all the connected node with land as visited node
        exploreGrid(i-1,j, visitedGrid);
        exploreGrid(i+1,j, visitedGrid);
        exploreGrid(i,j-1, visitedGrid);
        exploreGrid(i,j+1, visitedGrid);

        return 1;
    }
}
