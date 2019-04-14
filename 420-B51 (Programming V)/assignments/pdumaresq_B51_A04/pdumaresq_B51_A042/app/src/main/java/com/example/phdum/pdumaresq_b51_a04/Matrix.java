package com.example.phdum.pdumaresq_b51_a04;

import java.io.Serializable;

public class Matrix implements Serializable {
    private int id;
    private int rows;
    private int columns;
    private double[][] matrix;

    public Matrix() {
        this.id = -1;
        this.rows = 2;
        this.columns = 2;

        this.matrix = new double[rows()][columns()];
    }

    public Matrix(int x, int y) {
        this.id = -1;
        this.rows = x;
        this.columns = y;

        this.matrix = new double[rows()][columns()];
    }

    public Matrix(double[][] matrix) {
        this.id = -1;
        this.rows = matrix.length;
        this.columns = matrix[0].length;

        this.matrix = matrix;
    }

    public Matrix(int x, int y, double[][] matrix) throws MalformedMatrixException {
        this.id = -1;
        this.rows = x;
        this.columns = y;

        this.matrix = matrix;

        if (this.matrix.length != rows)
            throw new MalformedMatrixException();

        for (double[] r : this.matrix) {
            if (r.length != columns)
                throw new MalformedMatrixException();
        }
    }

    public Matrix(int x, int y, int id) {
        this.id = id;
        this.rows = x;
        this.columns = y;

        this.matrix = new double[rows()][columns()];
    }

    public Matrix(double[][] matrix, int id) {
        this.id = id;
        this.rows = matrix.length;
        this.columns = matrix[0].length;

        this.matrix = matrix;
    }

    private double round(double input, int precision) {
        return Math.round(input * Math.pow(10,precision)) / Math.pow(10,precision);
    }

    public double getDeterminant() throws NoDeterminantException {
        if (rows != columns)
            throw new NoDeterminantException("Cannot find determinant of a non-square matrix");

        return calculateDeterminant(this.matrix);
    }

    private double calculateDeterminant(double[][] matrix) {
        if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        double det = 0;
        double[][] cofactor = new double[matrix.length-1][matrix[0].length-1];

        //Loop through the columns in my matrix
        for (int c = 0 ; c < matrix[0].length ; c++) {
            //Loop through rows below my first row
            for (int cr = 1 ; cr < matrix.length ; cr++) {
                //Loop through the columns to include in my cofactor
                for (int cc = 0 ; cc < matrix[0].length ; cc++) {
                    if (cc != c) { //Ignore the column I'm currently at in the cofactor
                        //add the index to my cofactor matrix
                        cofactor[cr-1][cc > c ? cc-1 : c-1] = matrix[cr][cc];
                    }
                }
            }

            det += c % 2 == 0 ? calculateDeterminant(cofactor) : -1 * calculateDeterminant(cofactor);
        }

        return det;
    }

    public Matrix getInverse() throws NoInverseException, NoDeterminantException {
        Matrix matrix = new Matrix(matrix());

        if (getDeterminant() == -1)
            throw new NoDeterminantException("The Matrix has no Determinant.");
        if (getDeterminant() == 0)
            throw new NoInverseException("The Matrix has no inverse.");

        for (int c = 0 ; c < columns() ; c++) {
            matrix.addColumn();
        }

        for (int r = 0; r < rows() ; r++) {
            for (int c = columns() ; c < matrix.columns ; c++) {
                if (r == c-columns()) {
                    matrix.setCoordinate(r, c, 1);
                }
            }
        }

        matrix = matrix.getRREF();
        double[][] inverse = new double[rows()][columns()];
        for (int r = 0 ; r < rows() ; r++) {
            for (int c = columns() ; c < matrix.columns ; c++) {
                inverse[r][c-columns()] = matrix.get(r, c);
            }
        }

        return new Matrix(inverse);
    }

    public Matrix getTranspose() {
        double[][] matrix = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < columns; i1++) {
                matrix[i1][i] = this.matrix[i][i1];
            }
        }

        return arrayToMatrix(matrix);
    }

    public Matrix getREF() {
        double[][] matrix = this.toArray();

        double reduce;
        for (int r = 0; r < matrix.length; r++) {
            try {
                reduce = matrix[r][r];
                if (reduce != 0) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        matrix[r][c] = matrix[r][c] / reduce;
                    }
                }

                for (int r2 = r+1 ; r2 < matrix.length ; r2++) {
                    reduce = matrix[r2][r];
                    for (int c = 0; c < matrix[r2].length ; c++) {
                        matrix[r2][c] = matrix[r2][c] - (matrix[r][c] * reduce);
                    }
                }
            }
            catch (IndexOutOfBoundsException e) {}
        }

        return arrayToMatrix(matrix);
    }

    public Matrix getRREF() {
        double[][] matrix = getREF().toArray();

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = 0 ; c < matrix.length ; c++) {
                try {
                    if (matrix[r][c] == 1) {
                        for (int r2 = r - 1; r2 >= 0; r2--) {
                            double reduce = 0 - matrix[r2][c];
                            for (int c2 = c; c2 < matrix[r2].length; c2++) {
                                matrix[r2][c2] = matrix[r2][c2] + (matrix[r][c2] * reduce);
                            }
                        }
                        break;
                    }
                }
                catch (IndexOutOfBoundsException e) {}
            }
        }

        return new Matrix(matrix);
    }

    public double get(int x, int y) {
        return round(this.matrix[x][y], 5);
    }

    public Matrix addRow() {
        double[][] newMatrix = new double[++rows][columns];
        for (int r = 0 ; r < matrix.length ; r++) {
            for (int c = 0 ; c < matrix[0].length ; c++) {
                newMatrix[r][c] = this.matrix[r][c];
            }
        }

        matrix = newMatrix;
        return this;
    }

    public Matrix addColumn() {
        double[][] tmp = matrix;
        double[][] newMatrix = new double[rows][++columns];
        for (int r = 0 ; r < tmp.length ; r++) {
            for (int c = 0 ; c < tmp[r].length ; c++) {
                newMatrix[r][c] = tmp[r][c];
            }
        }

        matrix = newMatrix;
        return this;
    }

    public String getSize() {
        return this.rows + " x " + this.columns;
    }

    public double[][] matrix() {
        return this.matrix;
    }

    public int rows() {
        return this.rows;
    }

    //TODO - Unit Test
    public double[][] row(int n) {
        double[][] row = new double[1][columns()];
        for (int c = 0; c < columns() ; c++) {
            row[n][c] = matrix[n][c];
        }

        return row;
    }

    //TODO - Unit Test
    public double[][] column(int n) {
        double[][] col = new double[rows()][1];
        for (int r = 0; r < rows() ; r++) {
            col[r][n] = matrix[r][n];
        }

        return col;
    }

    public int columns() {
        return this.columns;
    }

    public Matrix setCoordinate(int x, int y, double n) {
        this.matrix[x][y] = n;
        return this;
    }

    //NOT INCLUDED IN APP
    public Matrix addMatrix(Matrix m2) throws IncompatibleMatricesException {
        if (matrix.length != m2.toArray().length || matrix[0].length != m2.toArray()[0].length)
            throw new IncompatibleMatricesException("The matrices must be of the same size to add.");

        for (int i = 0; i < this.matrix.length; i++) {
            for (int i1 = 0; i1 < this.matrix[i].length; i1++) {
                this.matrix[i][i1] += m2.toArray()[i][i1];
            }
        }

        return this;
    }

    //NOT INCLUDED IN APP
    public Matrix multiplyMatrix(Matrix m2) throws IncompatibleMatricesException {
        if (columns() != m2.columns())
            throw new IncompatibleMatricesException();
        return this;
    }

    public static Matrix arrayToMatrix(double[][] matrix) {
        return new Matrix(matrix);
    }

    public static Matrix stringToMatrix(String jString) {
        jString = jString.replaceAll("\\[|]", "");
        int x = jString.length() - jString.replaceAll("\\s", "").length() + 1;
        int y = (jString.length() - jString.replaceAll(",", "").length()) / x + 1 ;

        String[] json = jString.split("\\s");
        double[][] matrix = new double[x][y];
        for (int r = 0 ; r < json.length ; r++) {
            String[] nums = json[r].split(",");
            for (int c = 0 ; c < nums.length ; c++) {
                matrix[r][c] = Double.parseDouble(nums[c]);
            }
        }

        return new Matrix(matrix);
    }

    public double[][] toArray() {
        return this.matrix;
    }

    public String toString() {
        String jString = "[";
        for (int r = 0 ; r < matrix.length ; r++) {
            jString += "[";
            for (int c = 0 ; c < matrix[r].length ; c++) {
                String num = String.valueOf(round(matrix[r][c], 3));
                jString += num.contains(".") ?
                        num.replaceAll("0+$", "").replaceAll("\\.+$","") + "," : num;
            }
            jString = jString.replaceAll(",+$", "") + "] ";
        }

        return jString.replaceAll("\\s+$", "") + "]";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix))
            return false;

        Matrix input = (Matrix) obj;

        boolean equals = true;
        equals = equals && this.rows() == input.rows();
        equals = equals && this.columns() == input.columns();

        if (equals) {
            for (int r = 0 ; r < this.rows() ; r++) {
                for (int c = 0 ; c < this.columns() ; c++) {
                    equals = equals && this.get(r, c) == input.get(r, c);
                }
            }
        }

        return equals;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public int getId() {
        return this.id;
    }
}