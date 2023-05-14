package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Queen extends ChessPieces {
    public boolean color;
    public  boolean status;
    public String wchich_piece;
    List<String> available_moves = new ArrayList<String>();

    public void availiable_move(){

    }


    public  Queen(boolean check_if_white) {
        super("Queen", check_if_white, check_if_white ? "♛" : "♕");
    }

    @Override
    public boolean make_move(int where_is_now_x,int where_is_now_y,
                          int where_to_go_x, int where_to_go_y, ChessPieces current_figure, Chessboard chessboard){

        this.check_available_moves(where_is_now_x,where_is_now_y,where_to_go_x,where_to_go_y, chessboard);
        String wanted_move = where_to_go_x +"" + where_to_go_y;
        System.out.println("wanteed move "+wanted_move);

        System.out.println("size of list "+this.available_moves.size());
        if(this.available_moves.size() == 0){
            System.out.print("Nie ma dostepnych ruchow dla tej figury");
        }
        for(int i=0; i< this.available_moves.size();i++){

            System.out.println(i);
            if(Objects.equals(this.available_moves.get(i), wanted_move)){
                System.out.println("wykona sie ruch");
                chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field = current_figure;
                chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field = null;
                this.available_moves.clear();
                return true;


            }else {
                System.out.println("Ten ruch nie jest dostępny dla tej figury ");
            }
        } return false;


    }

    public void check_available_moves(int where_is_now_x,int where_is_now_y,int where_to_go_x,
                                      int where_to_go_y, Chessboard chessboard){
        int i = 1;
        //wyszukiwanie wszystkich ruchów do góry
        while(where_is_now_x+i<9 && chessboard.fields[where_is_now_x+i][where_is_now_y].which_piece_on_field == null){
            String available_move = (where_is_now_x +i) + ""+(where_is_now_y) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x+i<9 && chessboard.fields[where_is_now_x+i][where_is_now_y].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x+i][where_is_now_y].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x +i) + ""+(where_is_now_y) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchow w dol
        i = 1;
        while(where_is_now_x-i>-1 && chessboard.fields[where_is_now_x-i][where_is_now_y].which_piece_on_field == null){
            String available_move = (where_is_now_x -i) + ""+(where_is_now_y) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x-i>-1 && chessboard.fields[where_is_now_x-i][where_is_now_y].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x-i][where_is_now_y].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x -i) + ""+(where_is_now_y) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchow w prawo
        i= 1;
        while(where_is_now_y+i<9 && chessboard.fields[where_is_now_x][where_is_now_y+i].which_piece_on_field == null){
            String available_move = (where_is_now_x) + ""+(where_is_now_y+i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_y+i<9 && chessboard.fields[where_is_now_x][where_is_now_y+i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x][where_is_now_y+i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x) + ""+(where_is_now_y+i) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchow w lewo
        i= 1;
        while(where_is_now_y-i>-1 && chessboard.fields[where_is_now_x][where_is_now_y-i].which_piece_on_field == null){
            String available_move = (where_is_now_x) + ""+(where_is_now_y-i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_y-i>-1 && chessboard.fields[where_is_now_x][where_is_now_y-i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x][where_is_now_y-i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x) + ""+(where_is_now_y-i) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchow prawy gorny rog
        i= 1;
        while(where_is_now_x+i<9 && where_is_now_y+i<9 &&
                chessboard.fields[where_is_now_x+i][where_is_now_y+i].which_piece_on_field == null){
            String available_move = (where_is_now_x +i) + ""+(where_is_now_y+i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x+i<9 && where_is_now_y+i<9 &&
                chessboard.fields[where_is_now_x+i][where_is_now_y+i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x+i][where_is_now_y+i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){                       //iiiiiiii
                String available_move = (where_is_now_x +i) + ""+(where_is_now_y+i) ;
                available_moves.add(available_move);
            }
        }

        // wyszukiwanie wszystkich ruchow prawy dolny rog
        i= 1;
        while(where_is_now_x-i>-1 && where_is_now_y+i<9 &&
                chessboard.fields[where_is_now_x-i][where_is_now_y+i].which_piece_on_field == null){
            String available_move = (where_is_now_x -i) + ""+(where_is_now_y+i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x-i>-1 && where_is_now_y+i<9 &&
                chessboard.fields[where_is_now_x-i][where_is_now_y+i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x-i][where_is_now_y+i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x -i) + ""+(where_is_now_y+i) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchow lewy gorny
        i= 1;
        while(where_is_now_x+i<9 && where_is_now_y-i>-1 &&
                chessboard.fields[where_is_now_x+i][where_is_now_y-i].which_piece_on_field == null){
            String available_move = (where_is_now_x +i) + ""+(where_is_now_y-i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x+i<9 && where_is_now_y-i>-1 &&
                chessboard.fields[where_is_now_x+i][where_is_now_y-i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x+i][where_is_now_y-i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x +i) + ""+(where_is_now_y-i) ;
                available_moves.add(available_move);
            }
        }


        //wyszukiwanie wszystkich ruchów lewy dolny
        i= 1;
        while(where_is_now_x-i>-1 && where_is_now_y-i>-1 &&
                chessboard.fields[where_is_now_x-i][where_is_now_y-i].which_piece_on_field == null){
            String available_move = (where_is_now_x -i) + ""+(where_is_now_y-i) ;
            available_moves.add(available_move);
            i++;
        }
        if(where_is_now_x-i>-1 && where_is_now_y-i>-1 &&
                chessboard.fields[where_is_now_x-i][where_is_now_y-i].which_piece_on_field != null){
            if(chessboard.fields[where_is_now_x-i][where_is_now_y-i].which_piece_on_field.return_color() !=
                    chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                String available_move = (where_is_now_x -i) + ""+(where_is_now_y-i) ;
                available_moves.add(available_move);
            }
        }

    }

}
