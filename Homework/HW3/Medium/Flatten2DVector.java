public class Vector2D implements Iterator<Integer> {
    int rowPointer;
    int colPointer;
    List<List<Integer>> vector;
    
    public Vector2D(List<List<Integer>> vec2d) {
        rowPointer = 0;
        colPointer = 0;
        vector = vec2d;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int value = vector.get(rowPointer).get(colPointer);
            if (colPointer + 1 >= vector.get(rowPointer).size()) {
                rowPointer++;
                colPointer = 0;
            } else {
                colPointer++;
            }
            return value;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (rowPointer < vector.size()) {
            if (vector.get(rowPointer).size() == 0) {
                //skip to next list(row)
                rowPointer++;
            } else if (colPointer < vector.get(rowPointer).size()){
                return true;
            }
        }
        return false;

    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */