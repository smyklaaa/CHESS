package model;

public class Field {
    public boolean color;
    public boolean is_taken = false;
    public ChessPieces which_piece_on_field;
    public int x_position;
    public int y_position;

    public Field(int x_position, int y_position, ChessPieces which_piece_on_field){
        this.x_position = x_position;
        this.y_position = y_position;
        this.which_piece_on_field = which_piece_on_field;

    }


    //metoda przypisująca figurę do szachownicy
    public void assign_chess_piece(ChessPieces chess_piece, boolean is_taken){
        if(is_taken){
            this.which_piece_on_field = chess_piece;
        }//i kolor jest inny jezeli kolor bedzize ten sam to nie bedzie mozna ustawic

    }

    // funkcja ustawiajaca pozycję x pola
    public void set_x(int x){
        this.x_position = x;
    }

    //funkcja zwracajaca pozycje x pola
    public int get_x(){
        return this.x_position;
    }

    // funkcja ustawiajaca pozycję y pola
    public void set_y(int y){
        this.y_position = y;
    }

    // funkcja zwracajaca pozycję y pola
    public int get_y(){
        return this.y_position;
    }

    public boolean get_color(){
        return this.which_piece_on_field.return_color();
    }

}
