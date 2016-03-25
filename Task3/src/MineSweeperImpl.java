import java.util.Arrays;

/**
 * Created by tom on 25.03.16.
 */
public class MineSweeperImpl implements MineSweeper {
    private String mineField;
    private int N; // number of lines
    private int M; // number of characters
    private String[] lines;  //

    public static void main(String[] args) {
        String mineField1 = "*...\n..*.\n....";
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(mineField1);
        System.out.println(mineSweeper.getHintField());
    }


    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        if (mineField.length() == 0)
            throw new IllegalArgumentException("Mine field is empty!");

        this.mineField = mineField;
        lines = mineField.split("\n");
        M = lines[0].length();
        N = lines.length;

        if(Arrays.stream(lines).anyMatch(v -> v.length() != M))
            throw new IllegalArgumentException("Mine field is not properly formatted!");
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (mineField == null)
            throw new IllegalStateException("Mine field is not set!");

        StringBuilder output = new StringBuilder();

        int counter;
        for (int j = 0; j < N ; j++) {
            for (int i = 0; i < M; i++) {
                if (lines[j].charAt(i) == '*')
                    output.append('*');
                else {
                    counter = countMines(i, j);
                    output.append(String.valueOf(counter));
                }
            }
            output.append('\n');
        }

        return output.toString();
    }

    /**
     * Returns number of mines in neighborhood of given position (x,y)
     * */
    private int countMines(int x, int y) {
        int counter = 0;

        for (int j = -1; j < 2; j++)
            for(int i = -1; i < 2; i++) {
                if (x + i > -1 && y + j > -1 && x + i < M && y + j < N && !(i == 0 && j == 0)){
                    if(lines[y + j].charAt(x + i) == '*')
                        counter ++;
                }
            }

        return counter;
    }
}
