package model;

public class Chessboard {
    private int i,j;
    public final Field[][] fields = new Field[8][8];

    public void make_first_chess_board(){
        for(int i = 0; i < 8;i++){
            for(int j = 0; j < 8; j++){
                if(i == 1){
                    fields[i][j] = new Field(i,j,new Pawn(true));
                }
                else if(i == 6){
                    fields[i][j] = new Field(i,j,new Pawn(false));
                }
                else
                    fields[i][j] = new Field(i,j,null);
            }
        }
        fields[0][4] = new Field(0, 4, new King(true));
        fields[7][3] = new Field(7, 3, new King(false));

        fields[0][3] = new Field(0, 3, new Queen(true));
        fields[7][4] = new Field(7, 4, new Queen(false));

        fields[0][0] = new Field(0, 0, new Rook(true));
        fields[0][7] = new Field(0, 7, new Rook(true));
        fields[7][0] = new Field(7, 0, new Rook(false));
        fields[7][7] = new Field(7, 7, new Rook(false));

        fields[0][2] = new Field(0, 2, new Bishop(true));
        fields[0][5] = new Field(0, 5, new Bishop(true));
        fields[7][5] = new Field(7, 5, new Bishop(false));
        fields[7][2] = new Field(7, 2, new Bishop(false));

        fields[0][1] = new Field(0, 1, new Knight(true));
        fields[0][6] = new Field(0, 6, new Knight(true));
        fields[7][6] = new Field(7, 6, new Knight(false));
        fields[7][1] = new Field(7, 1, new Knight(false));
    }


    public void show_chess_board(){
        System.out.println();

        for(int i = 0; i < 8; i++){
            System.out.println("------------------------------------------------");
            for(int j = 0; j < 8; j++){

                if(fields[i][j].which_piece_on_field == null){

                    if(j==0){
                        System.out.print(i);
                        System.out.print(" | ");
                    }

                    System.out.print(" \u2003 | ");

                    if(j==7){
                        System.out.println();
                    }

                }
                else {
                    if(j==0) {
                        System.out.print(i );
                        System.out.print(" |  ");
                    }

                    System.out.print(fields[i][j].which_piece_on_field.return_visual_symbol());
                    System.out.print(" |  ");



                    if(j==7){
                        System.out.println();
                    }
                }
                }

            }
        System.out.println("------------------------------------------------");
        System.out.println("    A\u2003\u2003\u2003B\u2003\u2003\u2003C\u2003\u2003\u2003D\u2003\u2003\u2003" +
                "E\u2003\u2003\u2003F\u2003\u2003\u2003G\u2003\u2003\u2003H");
        }

    public Field return_filed(int first_coordinate, int second_coordinate){
        return fields[first_coordinate][second_coordinate];
    }


    public boolean return_color_of_piece(int first_coordinate, int second_coordinate){
            return fields[first_coordinate][second_coordinate].get_color();
    }


    public ChessPieces return_piece(int first_position, int second_position){
        return fields[first_position][second_position].which_piece_on_field;
    }


    public ChessPieces get_chess_piece_on_new_field(int first_coordinate, int second_coordinate, ChessPieces figure, boolean if_white ){
        fields[first_coordinate][second_coordinate] = new Field(first_coordinate, second_coordinate, new Rook(if_white));

        return figure;
    }

}





