package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Pawn extends ChessPieces{
    List<String> available_moves = new ArrayList<String>();
    boolean if_did_move = false;

    public  Pawn(boolean check_if_white){
        super("Pawn",check_if_white,check_if_white ? "♟" : "♙");
    }


    public void check_available_moves(int where_is_now_x,int where_is_now_y,int where_to_go_x,
                                      int where_to_go_y, Chessboard chessboard){
        //ruchy dla bialych
        if(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
            //sprawdzenie ruchu do przodu
            if(where_is_now_x + 1 < 7 && chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field == null){
                String available_move = (where_is_now_x +1) + ""+where_is_now_y ;
                System.out.println("available move "+available_move);
                available_moves.add(available_move);
            }
            //sprawdzenie ruch o dwa na start
            if(where_is_now_x + 2 == 3 && chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field == null){
                String available_move = (where_is_now_x +2) + ""+where_is_now_y ;
                System.out.println("available move "+available_move);
                available_moves.add(available_move);
            }

            //sprawdzenie czy nie wyjdzie poza szachownice
            if((where_is_now_y-1 != -1) && (where_is_now_y+1 != 8)){

                //sprawdzanie bicia w lewo
                if(chessboard.fields[where_is_now_x+1][where_is_now_y-1].
                        which_piece_on_field != null){
                    if(chessboard.fields[where_is_now_x+1][where_is_now_y-1].which_piece_on_field.return_color() !=
                            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                        String available_move = (where_is_now_x +1) + ""+(where_is_now_y -1) ;
                        System.out.println("available move "+available_move);
                        available_moves.add(available_move);
                    }
                }


                //spraawdzenie bicia na prawo
                if(chessboard.fields[where_is_now_x+1][where_is_now_y+1].which_piece_on_field != null){
                    if(chessboard.fields[where_is_now_x+1][where_is_now_y+1].which_piece_on_field.return_color() !=
                            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                        String available_move = (where_is_now_x +1) + ""+(where_is_now_y +1) ;
                        System.out.println("available move "+available_move);
                        available_moves.add(available_move);
                    }
                }

            }

            System.out.println(available_moves);
            System.out.println("czemu sie kurwa nie wiykonuje"+where_is_now_x);
            if(where_is_now_x == 6){
                System.out.println("czemu sie kurwa nie wiykonuje");
                change_pawn(where_is_now_x,where_is_now_y,chessboard);
            }

        }



        //ruchy dla czarnych
        if(!chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
            //sprawdzenie ruchu do przodu
            if(where_is_now_x - 1 > -1 && chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field == null){
                String available_move = (where_is_now_x -1) + ""+where_is_now_y ;
                System.out.println("available move "+available_move);
                available_moves.add(available_move);
            }
            //sprawdzenie ruch o dwa na start
            if(where_is_now_x - 2 == 4 && chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field == null){
                String available_move = (where_is_now_x -2) + ""+where_is_now_y ;
                System.out.println("available move "+available_move);
                available_moves.add(available_move);
            }

            //sprawdzenie czy nie wyjdzie poza szachownice
            if((where_is_now_y-1 != -1) && (where_is_now_y+1 != 8) ){

                //sprawdzanie bicia w lewo
                if((chessboard.fields[where_is_now_x-1][where_is_now_y-1].
                        which_piece_on_field != null)){
                    if(chessboard.fields[where_is_now_x-1][where_is_now_y-1].which_piece_on_field.return_color() !=
                            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                        String available_move = (where_is_now_x -1) + ""+(where_is_now_y -1) ;
                        System.out.println("available move "+available_move);
                        available_moves.add(available_move);
                    }
                }



                //spraawdzenie bicia na prawo
                if(chessboard.fields[where_is_now_x-1][where_is_now_y+1].which_piece_on_field != null){
                    if(chessboard.fields[where_is_now_x-1][where_is_now_y+1].which_piece_on_field.return_color() !=
                            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_color()){
                        String available_move = (where_is_now_x -1) + ""+(where_is_now_y +1) ;
                        System.out.println("available move "+available_move);
                        available_moves.add(available_move);
                    }
                }

        }

            System.out.println(available_moves);
            System.out.println("czemu sie  nie wiykonuje"+where_is_now_x);
            if(where_is_now_x == 2){
                System.out.println("czemu sie  nie wiykonuje");
                change_pawn(where_is_now_x,where_is_now_y,chessboard);
            }

        }


    }
    public void change_pawn(int where_is_now_x, int where_is_now_y, Chessboard chessboard){
        Scanner input = new Scanner(System.in);
        System.out.println("Na jaką figurę chcesz zamienic piona? wpisz liczbę:" +
                " 1.Królowa 2.Skoczek 3.wieza 4.goniec");
        int what_figure = input.nextInt();

        if(what_figure == 1){
            System.out.print("wybrało krowlowa");
            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field =
                    new Queen(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.                                                           //nie wyswietla symbolu zamienionego
                            return_color());
            System.out.print(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.return_visual_symbol());
        }

        if(what_figure == 2){
            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field =
                    new Knight(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.
                            return_color());
        }

        if(what_figure == 3){
            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field =
                    new Rook(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.
                            return_color());
        }

        if(what_figure == 4){
            chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field =
                    new Bishop(chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field.
                            return_color());
        }

    }

    @Override
    public void make_move(int where_is_now_x,int where_is_now_y,
                             int where_to_go_x, int where_to_go_y, ChessPieces current_figure, Chessboard chessboard){

        this.check_available_moves(where_is_now_x,where_is_now_y,where_to_go_x,where_to_go_y, chessboard);
        String wanted_move = where_to_go_x +"" + where_to_go_y;
        System.out.println("wanteed move "+wanted_move);

        System.out.println("size of list "+this.available_moves.size());
        for(int i=0; i< this.available_moves.size();i++){

            System.out.println(i);
            if(Objects.equals(this.available_moves.get(i), wanted_move)){
                System.out.println("wykona sie ruch");
                chessboard.fields[where_to_go_x][where_to_go_y].which_piece_on_field = current_figure;
                chessboard.fields[where_is_now_x][where_is_now_y].which_piece_on_field = null;
                this.if_did_move = true;
                this.available_moves.clear();


            }
            if(if_did_move == false){
                System.out.println("Ten ruch nie jest dostepny dla figury");

            }
        }


    }
}


