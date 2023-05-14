package model;

public abstract class ChessPieces {
    private boolean  check_if_white;
    private String  piece_name;
    private String  visual_symbol;


    public ChessPieces(String name, boolean color, String visual_symbol){
        this.piece_name = name;
        this.check_if_white = color;
        this.visual_symbol = visual_symbol;
    }

    public boolean return_color(){
        return this.check_if_white;
    }

    public String return_piece_name(){
        return this.piece_name;
    }

    public String  return_visual_symbol(){
        return visual_symbol;
    }


    abstract public boolean make_move(int where_is_now_x,int where_is_now_y,
                                   int where_to_go_x, int where_to_go_y, ChessPieces current_figure,
                                   Chessboard chessboard);

}