package com.kodilla.sudoku.game;

import com.kodilla.sudoku.board.Board;
import com.kodilla.sudoku.ioservice.IOService;
import com.kodilla.sudoku.solver.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Radosław Żerek
 */

public class Game {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);

    public boolean resolve() {
        board.createBoard();
        fillSudoku();
        solveSudoku();
        return true;
    }

    private void fillSudoku() {
        System.out.println("Welcome to SUDOKU");
        System.out.println(board);
        List<String> inputList = IOService.getInput();
        for(String input: inputList){
            board.addInputToSudoku(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1))
                    ,Character.getNumericValue(input.charAt(2)));
            System.out.println(board);
        }
    }

    private void solveSudoku() {
        do {
            System.out.println("Write 'SUDOKU' to get a solution");
        } while (!scanner.nextLine().equals("SUDOKU"));

        try {
            Solver solver = new Solver(board);
            Board result = solver.solve();
            System.out.println(result);
        } catch (CloneNotSupportedException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
