package Day3;

import java.util.ArrayList;

public class Grid2D<T> {
    private final ArrayList<ArrayList<T>> grid = new ArrayList<>();

    public void addLine(ArrayList<T> line) {
        grid.add(line);
    }

    public ArrayList<T> getNeighbors(int row, int column) {
        ArrayList<T> neighbors = new ArrayList<>();
        /* Loop between row +- 1 and column +- 1 */
        for (int y = row - 1; y <= row + 1; y++) {
            for (int x = column - 1; x <= column + 1; x++) {
                try {
                    neighbors.add(grid.get(y).get(x));
                } catch (IndexOutOfBoundsException e) {
                    neighbors.add(null);
                }
            }
        }
        return neighbors;
    }

    public T getElement(int row, int column) {
        return grid.get(row).get(column);
    }

    public int getNumRows() {
        return grid.size();
    }

    public int getNumColumns() {
        return grid.get(0).size();
    }

    public int getNumColumns(int row) {
        return grid.get(row).size();
    }

    public ArrayList<T> getRow(int row) {
        return grid.get(row);
    }

    public boolean neighborsContains(int row, int column, Object toCompare) {
        for (T element : getNeighbors(row, column)) {
            /* Manual null checks */
            if (element == null && toCompare == null) {
                return true;
            }
            /* Only element null */
            if (element == null) {
                continue;
            }
            if (element.equals(toCompare)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Grid2D = {\n");
        for (ArrayList<T> ts : grid) {
            for (T t : ts) {
                stringBuilder.append(t);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
