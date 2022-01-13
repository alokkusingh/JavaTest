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
                if (exploreGrid(i, j, visitedGrid))
                    ++count;
            }
        }

        return count;
    }

    private boolean exploreGrid(int i, int j, Set<String> visitedGrid) {
        if (i < 0 || i >= numberOfRows || j < 0 || j >= numberOfCols)
            return false;

        String gridIndex = i + "," + j;
        if (visitedGrid.contains(gridIndex) || !matrix[i][j].equals(landValue)) {
            return false;
        }

        visitedGrid.add(gridIndex);
        // now mark all the connected node with land as visited node
        exploreGrid(i-1,j, visitedGrid);
        exploreGrid(i+1,j, visitedGrid);
        exploreGrid(i,j-1, visitedGrid);
        exploreGrid(i,j+1, visitedGrid);

        return true;
    }

    public int findSmallestIseland() {
        Set<String> visitedGrid = new HashSet<>();

        int smallestSize = 0;

        for (int i = 0; i < numberOfRows; ++i) {
            for (int j = 0; j < numberOfCols; ++j) {
                int size = exploreSize(i, j, visitedGrid);
                if (smallestSize == 0 || (size > 0 && size < smallestSize))
                    smallestSize = size;
            }
        }

        return smallestSize;
    }

    private int exploreSize(int i, int j, Set<String> visitedGrid) {
        if (i < 0 || i >= numberOfRows || j < 0 || j >= numberOfCols)
            return 0;

        String gridIndex = i + "," + j;
        if (visitedGrid.contains(gridIndex) || !matrix[i][j].equals(landValue)) {
            return 0;
        }

        int size = 1;
        visitedGrid.add(gridIndex);
        // now mark all the connected node with land as visited node
        size += exploreSize(i-1,j, visitedGrid);
        size += exploreSize(i+1,j, visitedGrid);
        size += exploreSize(i,j-1, visitedGrid);
        size += exploreSize(i,j+1, visitedGrid);

        return size;
    }

}
