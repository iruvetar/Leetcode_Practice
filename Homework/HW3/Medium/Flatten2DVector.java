import java.util.NoSuchElementException;
public class Vector2D implements Iterator<Integer> {
    int rowPointer, colPointer;
    List<List<Integer>> vector;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vector = vec2d;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return vector.get(rowPointer).get(colPointer++);
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        while (rowPointer < vector.size()) {
            if (colPointer < vector.get(rowPointer).size()){
                return true;
            }
            //when the bottom of current row is reached
            //skip to next row
            colPointer = 0;
            rowPointer++;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */