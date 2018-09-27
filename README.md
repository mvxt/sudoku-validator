# Sudoku Validator

This is the repository for Data Ductus round 2 interview question solution, implemented in Java. The goal is to write a function which, given a 2D array of integers representing a Sudoku puzzle, validates whether the given solution was valid or not.

## Setup
You must have minimum Java 7 installed.

1. Clone the repository and `cd` into it.
```
$ git clone https://github.com/mvxt/sudoku-validator && cd sudoku-validator
```

2. Build the project.
```
$ make
```

3. Run the project.
```
$ java SudokuValidator
```

## Overview of Solution
Sudoku has the following rules: 

- All rows must contain numbers 1-9 uniquely
- All columns must contain numbers 1-9 uniquely
- All 3x3 squares at 0,0 / 0,3 / 0,6 / 3,0 / 3,3 / 3,6 / 6,0 / 6,3 / 6,6 must contain numbers 1-9 uniquely

One implementation could be to iterate through all rows, then all columns, then each of the squares to check for 1-9 uniqueness. If we assume for N to be the number of rows and columns, then this runtime would be O(n^2) since we would be iterating through every item in the row for every row.

