public class Grid {

    private Cell[][] grid;
    private final int RESOLUTION = 100;

    public Grid(){
        grid = new Cell[RESOLUTION][RESOLUTION];

        for (int i = 0; i < RESOLUTION; i++){
            for (int j = 0; j < RESOLUTION; j++){
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void copyGrid(Grid copy){

        for (int i = 0; i < RESOLUTION; i++) {
            for (int j = 0; j < RESOLUTION; j++) {
                copy.getGrid()[i][j].setStatus(this.getGrid()[i][j].getStatus());
            }
        }
    }
}
