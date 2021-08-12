package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Piece;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			 catch (ChessException ex) {
				System.out.println(ex.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException ex) {
				System.out.println(ex.getMessage());
				sc.nextLine();
			}
			
		}
		
	}

}
