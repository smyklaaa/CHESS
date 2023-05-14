package model;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private String player1;
    private String player2;
    private Chessboard chessboard;
    private boolean is_game_on = true;
    private int turn = 0;


    public Game(){
        Chessboard chessboard = new Chessboard();
        this.chessboard = chessboard;
        this.chessboard.make_first_chess_board();


    }

    public void play(){
        while(this.is_game_on){

            chessboard.show_chess_board();

            if(turn%2 == 0){
                System.out.println();
                System.out.println("Ruch białych");
                where_to_go(this.choosing_figure(true));

            }
            else {
                System.out.println();
                System.out.println("Ruch czarnych");
                System.out.println("Podaj jaki ruch chcesz wykonac: ");
                where_to_go(this.choosing_figure(false));
            }

            turn++;
        }

    }

    //funkcja wyznaczajaca na jakie pole ma ruszyc sie pionek
    public void where_to_go(Field current_field){
        Scanner input = new Scanner(System.in);
        Scanner input_letter = new Scanner((System.in));

        System.out.println("Podaj na jakie pole chcesz wykownac ruch ");
        System.out.print("liczba : ");
        int first_position_where_to_go = input.nextInt();

        System.out.print("Litera: ");
        String second_position = input_letter.next().toUpperCase(Locale.ROOT);
        int second_position_where_to_go_int = this.leter_on_int(second_position);

        first_position_where_to_go = this.check_if_number_not_out_range(first_position_where_to_go);
        second_position_where_to_go_int = this.check_if_letter_not_out_range(second_position_where_to_go_int);

        int x_current_position = current_field.x_position;
        int y_current_position = current_field.y_position;
        ChessPieces current_piece = current_field.which_piece_on_field;
        current_piece.make_move(x_current_position,y_current_position,
                first_position_where_to_go,second_position_where_to_go_int, current_piece,chessboard);








    }

    // metoda wyznaczająca którą figurrą chce się ruszyć gracz

    public Field choosing_figure(boolean player_color){

        Scanner input = new Scanner(System.in);
        Scanner input_letter = new Scanner((System.in));

        System.out.println("Podaj jaką figurą chcesz wykonać ruch ");
        System.out.print("liczba : ");
        int first_position = input.nextInt();

        System.out.print("Litera: ");
        String second_position = input_letter.next().toUpperCase(Locale.ROOT);
        int second_position_int = this.leter_on_int(second_position);

        first_position = check_if_number_not_out_range(first_position);       //sprawdzenie czy nie sa poza szachownica
        second_position_int = check_if_letter_not_out_range(second_position_int);

        //sprawdza czy jest figura na polu
        while (chessboard.return_piece(first_position,second_position_int) == null){
            System.out.println("podałeś puste pole , podaj poprawne koordynaty");
            input = new Scanner(System.in);
            input_letter = new Scanner((System.in));

            System.out.print("liczba : ");
            first_position = input.nextInt();
            System.out.print("Litera: ");
            second_position = input_letter.next().toUpperCase(Locale.ROOT);

            second_position_int = this.leter_on_int(second_position);

            first_position = this.check_if_number_not_out_range(first_position);
            second_position_int = this.check_if_letter_not_out_range(second_position_int);


        }
        boolean what_color_have_chosen_figure = chessboard.return_color_of_piece(first_position,second_position_int);


        //sprawdza czy osoba chce poruszyc swwoja figura
        while (!what_color_have_chosen_figure && player_color == true){
            System.out.println("podałeś figurę przeciwnika, podaj koordynaty jeszcze raz:  ");
            System.out.print("liczba : ");
            first_position = input.nextInt();
            System.out.print("litera : ");
            second_position = input_letter.next().toUpperCase(Locale.ROOT);
            second_position_int = this.leter_on_int(second_position);
            first_position = check_if_number_not_out_range(first_position);
            second_position_int = check_if_letter_not_out_range(second_position_int);
            what_color_have_chosen_figure = chessboard.return_color_of_piece(first_position,second_position_int);
        }
        while (what_color_have_chosen_figure && player_color == false){
            System.out.println("podałeś figurę przeciwnika, podaj koordynaty jeszcze raz:  ");
            System.out.print("liczba : ");
            first_position = input.nextInt();
            System.out.print("litera : ");
            second_position = input_letter.next().toUpperCase(Locale.ROOT);
            second_position_int = this.leter_on_int(second_position);
            first_position = check_if_number_not_out_range(first_position);
            second_position_int = check_if_letter_not_out_range(second_position_int);
            what_color_have_chosen_figure = chessboard.return_color_of_piece(first_position,second_position_int);
        }
        return chessboard.return_filed(first_position,second_position_int);
    }


    public int check_if_number_not_out_range(int first_position){
        Scanner input = new Scanner(System.in);
        while(first_position <0 || first_position >7 ){           //sprawdzam czy ruch jest w szachownicy
            System.out.println("podałeś liczbę poza szachownicą podaj jeszcza rez:  ");
            System.out.print("liczba : ");
            first_position = input.nextInt();
        }
        return first_position;
    }


    public int check_if_letter_not_out_range(int second_position_int){
        Scanner input_letter = new Scanner((System.in));
        while(second_position_int == -1 ){                       //sprawdzam czy ruch jest w szachownicy
            System.out.println("podałeś literę poza szachownicą podaj jeszcza rez:  ");
            System.out.print("litera : ");
            String second_position = input_letter.next().toUpperCase(Locale.ROOT);
            second_position_int = this.leter_on_int(second_position);

        }
        return second_position_int;
    }



    //funkcja zamieniajaca litere na liczbe
    public int leter_on_int(String letter) {
        switch (letter) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;

            default:
                return -1;
        }
        
    }
}
