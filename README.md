# Sudoku Validator

This is the repository for Data Ductus round 2 interview question solution, implemented in Java. The goal is to write a function which, given a 2D array of integers representing a Sudoku puzzle, validates the given solution.

## Background
Sudoku is a 9x9 grid puzzle. You are usually given an incomplete puzzle with only a few numbers, and based on logic, you are supposed to fill in the rest of the puzzle. See the [Wikipedia](https://en.wikipedia.org/wiki/Sudoku) article for more information.

The rules are as follows:
- All rows must contain numbers 1-9 uniquely
- All columns must contain numbers 1-9 uniquely
- All 3x3 squares at 0,0 / 0,3 / 0,6 / 3,0 / 3,3 / 3,6 / 6,0 / 6,3 / 6,6 must contain numbers 1-9 uniquely

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

One implementation could be to iterate through all rows, then all columns, then each of the squares to check for 1-9 uniqueness. If we assume for N to be the number of rows and columns, then this runtime would be O(n^2) complexity. This naive implementation can be seen on commit [e393241](https://github.com/mvxt/sudoku-validator/commit/e3932417992cc80cd390f880b4f3f0fae1bc7b5e This naive implementation can be seen on commit [e393241](https://github.com/mvxt/sudoku-validator/commit/e3932417992cc80cd390f880b4f3f0fae1bc7b5e.). 

