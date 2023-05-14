package model;

public class King extends ChessPieces{
    public boolean color;
    public  boolean status;
    public String which_piece;

    public void availiable_move(){

    }


    public  King(boolean check_if_white) {
        super("King", check_if_white, check_if_white ? "♚" : "♔");
    }

    @Override
    public void make_move(int where_is_now_x,int where_is_now_y,
                          int where_to_go_x, int where_to_go_y, ChessPieces current_figure,
                          Chessboard chessboard){



    }

}
