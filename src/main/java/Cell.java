import java.awt.*;

public class Cell {
    private int status;

    public Cell() {
        if(Math.random() > 0.9){
            this.status = 1;
        } else {
            this.status = 0;
        }

        System.out.println("creado");

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
