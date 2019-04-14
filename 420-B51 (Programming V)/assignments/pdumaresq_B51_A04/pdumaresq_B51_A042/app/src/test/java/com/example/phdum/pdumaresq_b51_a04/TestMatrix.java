package com.example.phdum.pdumaresq_b51_a04;

import org.junit.Assert;
import org.junit.Test;

public class TestMatrix {
    private double round(double num) {
        return Math.round(num*100000)/100000;
    }

    @Test
    public void testConstructors() {
        class TestConstructors {
            private void testDefault() {
                Matrix input = new Matrix();
                double[][] outputE1 = {{0,0},{0,0}};
                int outputE2 = 2;
                int outputE3 = 2;

                Assert.assertArrayEquals("Test that the matrices are the same", outputE1, input.toArray());
                Assert.assertEquals("Check same # rows", outputE2, input.rows());
                Assert.assertEquals("Check same # columns", outputE3, input.columns());
            }

            private void testRowsAndCols() {
                Matrix input = new Matrix(2,2);
                double[][] outputE1 = {{0,0},{0,0}};
                int outputE2 = 2;
                int outputE3 = 2;

                Assert.assertArrayEquals("Test that the matrices are the same", outputE1, input.toArray());
                Assert.assertEquals("Check same # rows", outputE2, input.rows());
                Assert.assertEquals("Check same # columns", outputE3, input.columns());
            }

            private void testMatrix() {
                Matrix input = new Matrix(new double[][] {{1,2},{3,4}});
                double[][] outputE1 = {{1,2},{3,4}};
                int outputE2 = 2;
                int outputE3 = 2;

                Assert.assertArrayEquals("Test that the matrices are the same", outputE1, input.toArray());
                Assert.assertEquals("Check same # rows", outputE2, input.rows());
                Assert.assertEquals("Check same # columns", outputE3, input.columns());
            }

            private void testMatrixRowsAndCols() {
                try {
                    Matrix input = new Matrix(2,2,new double[][] {{1,2},{3,4}});
                    double[][] outputE1 = {{1,2},{3,4}};
                    int outputE2 = 2;
                    int outputE3 = 2;

                    Assert.assertArrayEquals("Test that the matrices are the same", outputE1, input.toArray());
                    Assert.assertEquals("Check same # rows", outputE2, input.rows());
                    Assert.assertEquals("Check same # columns", outputE3, input.columns());
                }
                catch (InvalidMatrixException e) {
                    Assert.assertTrue("testMatrixRowsAndCols this exception should not be thrown.", false);
                }
            }

            private void testInvalidMatrix() {
                try {
                    new Matrix(3,3,new double[][] {{1,2},{3,4}});
                    Assert.assertTrue("Exception was not thrown properly", false);
                }
                catch (MalformedMatrixException e) {
                    Assert.assertTrue("Test that the exception was thrown", true);
                }
            }
        }

        TestConstructors test = new TestConstructors();
        test.testDefault();
        test.testRowsAndCols();
        test.testMatrix();
        test.testMatrixRowsAndCols();
        test.testInvalidMatrix();
    }

    @Test
    public void testDeterminant() {
        class TestDeterminant {
            private void test1x1() {
                try {
                    Matrix input = new Matrix(new double[][]{{1}});
                    double outputE = 1;
                    double outputA = input.getDeterminant();

                    Assert.assertTrue("Test the determinant of a 1x1", outputE == outputA);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("testMatrixRowsAndCols this exception should not be thrown.", false);
                }

            }

            private void test2x2() {
                try {
                    Matrix input1 = new Matrix(new double[][]{{1,2},{3,4}});
                    double outputE1 = -2;
                    double outputA1 = input1.getDeterminant();

                    Assert.assertTrue("Test the determinant of a 2x2", outputE1 == outputA1);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("testDeterminant 2x2 this exception should not be thrown.", false);
                }

                try {
                    Matrix input2 = new Matrix(new double[][]{{1,2},{4,5}});
                    double outputE2 = -3;
                    double outputA2 = input2.getDeterminant();

                    Assert.assertTrue("Test the determinant of a 2x2", outputE2 == outputA2);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("testDeterminant 2x2 this exception should not be thrown.", false);
                }
            }

            private void test3x3() {
                try {
                    Matrix input = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
                    double outputE = 0;
                    double outputA = input.getDeterminant();

                    Assert.assertTrue("Test the determinant of a 3x3: " + outputA + ", " + outputE, outputE == outputA);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("testDeterminant 3x3 this exception should not be thrown.", false);
                }
            }

            private void test4x4() {
                try {
                    Matrix input = new Matrix(new double[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
                    double outputE = 0;
                    double outputA = input.getDeterminant();

                    Assert.assertTrue("Test the determinant of a 4x4: " + outputA + ", " + outputE, outputE == outputA);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("testDeterminant 4x4 this exception should not be thrown.", false);
                }
            }

            private void test3x2() {
                try {
                    Matrix input = new Matrix(new double[][]{{1,2,3},{4,5,6}});
                    input.getDeterminant();
                    Assert.assertTrue("Exception was not thrown", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("Exception was properly thrown", true);
                }
            }
        }

        TestDeterminant test = new TestDeterminant();
        test.test1x1();
        test.test2x2();
        test.test3x3();
        test.test4x4();
        test.test3x2();
    }

    @Test
    public void testInverse() {
        class TestInverse {
            private void Test1x1Matrix() {
                try {
                    double[][] input1 = {{1}};
                    double[][] outputE1 = {{1}};
                    double[][] outputA1 = Matrix.arrayToMatrix(input1).getInverse().toArray();

                    for (int i = 0; i < outputA1.length; i++) {
                        for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                            Assert.assertEquals(
                                    "Check that the inverse works 1x1: " + i + " x " + i1,
                                    round(outputE1[i][i1]), round(outputA1[i][i1]), 0
                            );
                        }
                    }
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoInverse 1x1", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoDeterminant 1x1", false);
                }

            }

            private void Test2x2Matrix() {
                try {
                    double[][] input = {{1,2},{3,4}};
                    double[][] outputE = {{-2,1},{3.0/2.0,-1.0/2.0}};
                    double[][] outputA = Matrix.arrayToMatrix(input).getInverse().toArray();

                    for (int i = 0; i < outputA.length; i++) {
                        for (int i1 = 0; i1 < outputA[i].length; i1++) {
                            Assert.assertEquals(
                                    "Check that the inverse works 2x2: " + i + " x " + i1,
                                    round(outputA[i][i1]), round(outputE[i][i1]), 0
                            );
                        }
                    }
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoInverse 2x2", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoDeterminant 2x2", false);
                }
            }

            private void Test3x3Matrix() {
                try {
                    double[][] input = {{1,2,3},{4,5,6},{7,8,10}};
                    double[][] outputE = {{-2.0/3.0,-4.0/3.0,1},{-2.0/3.0,11.0/3.0,-2},{1,-2,1}};
                    double[][] outputA = Matrix.arrayToMatrix(input).getInverse().toArray();

                    for (int i = 0; i < outputA.length; i++) {
                        for (int i1 = 0; i1 < outputA[i].length; i1++) {
                            Assert.assertEquals(
                                    "Check that the inverse works 3x3: " + i + " x " + i1,
                                    round(outputA[i][i1]), round(outputE[i][i1]), 0
                            );
                        }
                    }
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoInverse 3x3", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoDeterminant 3x3", false);
                }

                try {
                    double[][] input = {{1,2,3},{4,5,6},{7,8,9}};
                    Matrix.arrayToMatrix(input).getInverse().toArray();
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception should be throw - NoInverse 3x3", true);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoDeterminant 3x3", false);
                }
            }

            private void Test3x4Matrix() {
                try {
                    double[][] input1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                    Matrix.arrayToMatrix(input1).getInverse().toArray();
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoInverse 3x4", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception should be throw - NoDeterminant 3x4", true);
                }
            }

            private void Test4x3Matrix() {
                try {
                    double[][] input1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                    Matrix.arrayToMatrix(input1).getInverse().toArray();
                }
                catch (NoInverseException e) {
                    Assert.assertTrue("This exception shouldn't be throw - NoInverse 4x3", false);
                }
                catch (NoDeterminantException e) {
                    Assert.assertTrue("This exception should be throw - NoDeterminant 4x3", true);
                }
            }
        }

        TestInverse test = new TestInverse();
        test.Test1x1Matrix();
        test.Test2x2Matrix();
        test.Test3x3Matrix();
        test.Test3x4Matrix();
        test.Test4x3Matrix();
    }

    @Test
    public void testTranspose() {
        class TestTranspose {
            private void Test1x1Matrix() {
                double[][] input1 = {{1}};
                double[][] outputE1 = {{1}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getTranspose().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the transpose works 1x1: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test2x2Matrix() {
                double[][] input1 = {{1,2},{3,4}};
                double[][] outputE1 = {{1,3},{2,4}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getTranspose().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the transpose works 2x2: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
                double[][] outputE1 = {{1,4,7},{2,5,8},{3,6,9}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getTranspose().toArray();



                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the transpose works 3x3: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x4Matrix() {
                double[][] input1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                double[][] outputE1 = {{1,5,9},{2,6,10},{3,7,11},{4,8,12}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getTranspose().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the transpose works 3x4: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test4x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                double[][] outputE1 = {{1,4,7,10},{2,5,8,11},{3,6,9,12}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getTranspose().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the transpose works 4x3: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }
        }

        TestTranspose test = new TestTranspose();
        test.Test1x1Matrix();
        test.Test2x2Matrix();
        test.Test3x3Matrix();
        test.Test3x4Matrix();
        test.Test4x3Matrix();
    }

    @Test
    public void testGetREF() {
        class TestGetREF {
            private void Test1x1Matrix() {
                double[][] input1 = {{1}};
                double[][] outputE1 = {{1}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the ref works" + i + " x " + i1, outputA1[i][i1], outputE1[i][i1], 0);
                    }
                }
            }

            private void Test2x2Matrix() {
                double[][] input1 = {{1,2},{3,4}};
                double[][] outputE1 = {{1,2},{0,1}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the ref works" + i + " x " + i1, outputA1[i][i1], outputE1[i][i1], 0);
                    }
                }
            }

            private void Test3x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
                double[][] outputE1 = {{1,2,3},{0,1,2},{0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the ref works" + i + " x " + i1, outputA1[i][i1], outputE1[i][i1], 0);
                    }
                }
            }

            private void Test3x4Matrix() {
                double[][] input1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                double[][] outputE1 = {{1,2,3,4},{0,1,2,3},{0,0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the ref works" + i + " x " + i1, outputA1[i][i1], outputE1[i][i1], 0);
                    }
                }
            }

            private void Test4x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                double[][] outputE1 = {{1,2,3},{0,1,2},{0,0,0},{0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 4x3: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x7AllDecimals() {
                double[][] input = {
                        {-1.0/314.0, 2.0/879.0, 0, 16.0/28.0, 0, 19.0/19.0, -19.0/20.0},
                        {19.0/1000000.0, 13.0/218.0, -16.0/21.0, 17.0/3631.0, 1.0/73578.0, 0, 0},
                        {7.0/6383235.0, -1.0/1000000.0, 1.0/10000000.0, 14.0/5862.0, 1, -4.0/41.0, 18.0/91287.0}
                };
                double[][] outputE = {
                        {1, -628.0/879.0, 0, -1256.0/7.0, 0, -314, 2983.0/10.0 },
                        {0, 1, -127748000000.0/10000901029.0,4925887444806.0/36313271636299.0,3992125000.0/17520149902661.0,285804213.0/2857400294.0,-5430280047.0/57148005880.0},
                        {0,0,4.59953831400275e15/4599538314002755.0,-2.65716801795481e18/2740109779297801.0, -2.11301369962042e21/5632764358937507.0,1.6419575149378e20/4502364936091455.0 ,1.05492604360061e16/216382569850851.0}
                };

                double[][] outputA = Matrix.arrayToMatrix(input).getREF().toArray();

                try {
                    for (int i = 0; i < outputA.length; i++) {
                        for (int i1 = 0; i1 < outputA[i].length; i1++) {
                            Assert.assertEquals("Check that the REF works 3x7: " + i + " x " + i1, round(outputE[i][i1]), round(outputA[i][i1]), 0);
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    Assert.fail("Testing REF 3x7 decimal - Exception should not be thrown.");
                }
            }
        }

        TestGetREF test = new TestGetREF();
        test.Test1x1Matrix();
        test.Test2x2Matrix();
        test.Test3x3Matrix();
        test.Test3x4Matrix();
        test.Test4x3Matrix();
        test.Test3x7AllDecimals();
    }

    @Test
    public void testGetRREF() {
        class TestGetRREF {
            private void Test1x1Matrix() {
                double[][] input1 = {{1}};
                double[][] outputE1 = {{1}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getRREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 1x1: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test2x2Matrix() {
                double[][] input1 = {{1,2},{3,4}};
                double[][] outputE1 = {{1,0},{0,1}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getRREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 2x2: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
                double[][] outputE1 = {{1,0,-1},{0,1,2},{0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getRREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 3x3: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x4Matrix() {
                double[][] input1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                double[][] outputE1 = {{1,0,-1,-2},{0,1,2,3},{0,0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getRREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 3x4: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test4x3Matrix() {
                double[][] input1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                double[][] outputE1 = {{1,0,-1},{0,1,2},{0,0,0},{0,0,0}};
                double[][] outputA1 = Matrix.arrayToMatrix(input1).getRREF().toArray();

                for (int i = 0; i < outputA1.length; i++) {
                    for (int i1 = 0; i1 < outputA1[i].length; i1++) {
                        Assert.assertEquals("Check that the rref works 4x3: " + i + " x " + i1, outputE1[i][i1], outputA1[i][i1], 0);
                    }
                }
            }

            private void Test3x7AllDecimals() {
                double[][] input = {
                        {-1.0/314.0, 2.0/879.0, 0, 16.0/28.0, 0, 19.0/19.0, -19.0/20.0},
                        {19.0/1000000.0, 13.0/218.0, -16.0/21.0, 17.0/3631.0, 1.0/73578.0, 0, 0},
                        {7.0/6383235.0, -1.0/1000000.0, 1.0/10000000.0, 14.0/5862.0, 1, -4.0/41.0, 18.0/91287.0}
                };

                double[][] outputE = {
                        {1, 0, 0, -9029.19985, -3423469.61991, 332504.19758, 743.15576 },
                        {0, 1, 0, -12386.86140, -4791767.19092, 465839.48355, 622.65639 },
                        {0, 0, 1, -969.73050, -375129.07781, 36468.77892, 48.75282 }
                };

                double[][] outputA = Matrix.arrayToMatrix(input).getRREF().toArray();

                try {
                    for (int i = 0; i < outputA.length; i++) {
                        for (int i1 = 0; i1 < outputA[i].length; i1++) {
                            Assert.assertEquals("Check that the RREF works 3x7: " + i + " x " + i1, round(outputE[i][i1]), round(outputA[i][i1]), 0);
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    Assert.fail("Testing RREF 3x7 decimal - Exception should not be thrown.");
                }
            }
        }

        TestGetRREF test = new TestGetRREF();
        test.Test1x1Matrix();
        test.Test2x2Matrix();
        test.Test3x3Matrix();
        test.Test3x4Matrix();
        test.Test4x3Matrix();
        test.Test3x7AllDecimals();
    }

    @Test
    public void testGetIndex() {
        class TestGetIndex {
            private void testGetIndex1x1() {
                Matrix input = new Matrix(new double[][]{{1}});
                double outputE1 = 1;
                double outputA1 = input.get(0,0);

                Assert.assertEquals("E", outputE1, outputA1, 0);
            }

            private void testGetIndex2x2() {
                Matrix input = new Matrix(new double[][]{{1,2},{3,4}});
                double outputE1 = 1;
                double outputE2 = 2;
                double outputE3 = 3;
                double outputE4 = 4;

                Assert.assertEquals("", outputE1, input.get(0,0), 0);
                Assert.assertEquals("", outputE2, input.get(0,1), 0);
                Assert.assertEquals("", outputE3, input.get(1,0), 0);
                Assert.assertEquals("", outputE4, input.get(1,1), 0);
            }

            private void testGetIndex2x3() {
                Matrix input = new Matrix(new double[][]{{1,2,3},{4,5,6}});
                double outputE1 = 1;
                double outputE2 = 2;
                double outputE3 = 3;
                double outputE4 = 4;
                double outputE5 = 5;
                double outputE6 = 6;

                Assert.assertEquals("", outputE1, input.get(0,0), 0);
                Assert.assertEquals("", outputE2, input.get(0,1), 0);
                Assert.assertEquals("", outputE3, input.get(0,2), 0);
                Assert.assertEquals("", outputE4, input.get(1,0), 0);
                Assert.assertEquals("", outputE5, input.get(1,1), 0);
                Assert.assertEquals("", outputE6, input.get(1,2), 0);
            }

            private void testGetIndex3x2() {
                Matrix input = new Matrix(new double[][]{{1,2},{3,4},{5,6}});
                double outputE1 = 1;
                double outputE2 = 2;
                double outputE3 = 3;
                double outputE4 = 4;
                double outputE5 = 5;
                double outputE6 = 6;

                Assert.assertEquals("", outputE1, input.get(0,0), 0);
                Assert.assertEquals("", outputE2, input.get(0,1), 0);
                Assert.assertEquals("", outputE3, input.get(1,0), 0);
                Assert.assertEquals("", outputE4, input.get(1,1), 0);
                Assert.assertEquals("", outputE5, input.get(2,0), 0);
                Assert.assertEquals("", outputE6, input.get(2,1), 0);
            }
        }

        TestGetIndex test = new TestGetIndex();
        test.testGetIndex1x1();
        test.testGetIndex2x2();
        test.testGetIndex2x3();
        test.testGetIndex3x2();
    }

    @Test
    public void testAddRow() {
        class TestAddRow {
            private void testAddRow1x1() {
                Matrix input = new Matrix(1,1);
                Matrix outputE = new Matrix(2,1);
                Matrix outputA = input.addRow();

                Assert.assertEquals("add row: 1x1, rows aren't equal", outputE.rows(), outputA.rows(), 0);
                Assert.assertEquals("add row: 1x1, cols aren't equal", outputE.columns(), outputA.columns(), 0);
                Assert.assertArrayEquals("add row: 1x1, matrices aren't equal", outputE.matrix(), outputA.matrix());
            }

            private void testAddRow2x2() {
                Matrix input = new Matrix(2,2);
                Matrix outputE = new Matrix(3,2);
                Matrix outputA = input.addRow();

                Assert.assertTrue("", outputE.rows() == outputA.rows());
                Assert.assertTrue("", outputE.columns() == outputA.columns());
                Assert.assertArrayEquals("", outputE.matrix(), outputA.matrix());
            }

            private void testAddRow2x3() {
                Matrix input = new Matrix(2,3);
                Matrix outputE = new Matrix(3,3);
                Matrix outputA = input.addRow();

                Assert.assertTrue("", outputE.rows() == outputA.rows());
                Assert.assertTrue("", outputE.columns() == outputA.columns());
                Assert.assertArrayEquals("", outputE.matrix(), outputA.matrix());
            }
        }

        TestAddRow test = new TestAddRow();
        test.testAddRow1x1();
        test.testAddRow2x2();
        test.testAddRow2x3();
    }

    @Test
    public void testAddColumn() {
        class TestAddColumn {
            private void testAddRow1x1() {
                Matrix input = new Matrix(1,1);
                Matrix outputE = new Matrix(1,2);
                Matrix outputA = input.addColumn();

                Assert.assertEquals("add col: 1x1, rows aren't equal", outputE.rows(), outputA.rows(), 0);
                Assert.assertEquals("add col: 1x1, cols aren't equal", outputE.columns(), outputA.columns(), 0);
                Assert.assertArrayEquals("add col: 1x1, matrices aren't equal", outputE.matrix(), outputA.matrix());
            }

            private void testAddRow2x2() {
                Matrix input = new Matrix(2,2);
                Matrix outputE = new Matrix(2,3);
                Matrix outputA = input.addColumn();

                Assert.assertEquals("add col: 2x2, rows aren't equal", outputE.rows(), outputA.rows(), 0);
                Assert.assertEquals("add col: 2x2, cols aren't equal", outputE.columns(), outputA.columns(), 0);
                Assert.assertArrayEquals("add col: 2x2, matrices aren't equal", outputE.matrix(), outputA.matrix());
            }

            private void testAddRow3x2() {
                Matrix input = new Matrix(3,2);
                Matrix outputE = new Matrix(3,3);
                Matrix outputA = input.addColumn();

                Assert.assertEquals("add col: 3x2, rows aren't equal", outputE.rows(), outputA.rows(), 0);
                Assert.assertEquals("add col: 3x2, cols aren't equal", outputE.columns(), outputA.columns(), 0);
                Assert.assertArrayEquals("add col: 3x2, matrices aren't equal", outputE.matrix(), outputA.matrix());
            }
        }

        TestAddColumn test = new TestAddColumn();
        test.testAddRow1x1();
        test.testAddRow2x2();
        test.testAddRow3x2();
    }

    @Test
    public void testGetSize() {
        class TestGetSize {
            private void testGetSize1x1() {
                Matrix input = new Matrix(1,1);
                String outputE = "1 x 1";
                String outputA = input.getSize();

                Assert.assertEquals("testGetSize1x1", outputE, outputA);
            }

            private void testGetSize2x2() {
                Matrix input = new Matrix(2,2);
                String outputE = "2 x 2";
                String outputA = input.getSize();

                Assert.assertEquals("testGetSize2x2", outputE, outputA);
            }

            private void testGetSize3x9() {
                Matrix input = new Matrix(3,9);
                String outputE = "3 x 9";
                String outputA = input.getSize();

                Assert.assertEquals("testGetSize3x9", outputE, outputA);
            }

            private void testGetSize26x13() {
                Matrix input = new Matrix(26,13);
                String outputE = "26 x 13";
                String outputA = input.getSize();

                Assert.assertEquals("testGetSize26x13", outputE, outputA);
            }
        }

        TestGetSize test = new TestGetSize();
        test.testGetSize1x1();
        test.testGetSize2x2();
        test.testGetSize3x9();
        test.testGetSize26x13();
    }

    @Test
    public void testGetRows() {
        class TestGetSize {
            private void testGetRows1x1() {
                Matrix input = new Matrix(1,1);
                int outputE = 1;
                int outputA = input.rows();

                Assert.assertEquals("testGetRows1x1", outputE, outputA);
            }

            private void testGetRows2x2() {
                Matrix input = new Matrix(2,2);
                int outputE = 2;
                int outputA = input.rows();

                Assert.assertEquals("testGetRows2x2", outputE, outputA);
            }

            private void testGetRows13x26() {
                Matrix input = new Matrix(13,26);
                int outputE = 13;
                int outputA = input.rows();

                Assert.assertEquals("testGetRows13x26", outputE, outputA);
            }
        }

        TestGetSize test = new TestGetSize();
        test.testGetRows1x1();
        test.testGetRows2x2();
        test.testGetRows13x26();
    }

    @Test
    public void testGetColumns() {
        class TestGetColumns {
            private void testGetColumns1x1() {
                Matrix input = new Matrix(1,1);
                int outputE = 1;
                int outputA = input.columns();

                Assert.assertEquals("testGetColumns1x1", outputE, outputA);
            }

            private void testGetColumns2x2() {
                Matrix input = new Matrix(2,2);
                int outputE = 2;
                int outputA = input.columns();

                Assert.assertEquals("testGetColumns2x2", outputE, outputA);
            }

            private void testGetColumns13x26() {
                Matrix input = new Matrix(13,26);
                int outputE = 26;
                int outputA = input.columns();

                Assert.assertEquals("testGetColumns13x26", outputE, outputA);
            }
        }

        TestGetColumns test = new TestGetColumns();
        test.testGetColumns1x1();
        test.testGetColumns2x2();
        test.testGetColumns13x26();
    }

    @Test
    public void testSetCoordinate() {
        class TestSetCoordinate {
            private void testSetCoordinate1x1() {
                Matrix input = new Matrix(new double[][]{{1}});
                Matrix outputE = new Matrix(new double[][]{{5}});
                Matrix outputA = input.setCoordinate(0,0,5.0);

                Assert.assertTrue("testSetCoordinate1x1 - Matrices are equal", outputE.equals(outputA));
            }

            private void testSetCoordinate2x2() {
                Matrix input = new Matrix(new double[][]{{1,2},{3,4}});
                Matrix outputE = new Matrix(new double[][]{{5,6},{7,8}});

                Matrix outputA = input;
                for (int r = 0 ; r < input.rows() ; r++) {
                    for (int c = 0 ; c < input.columns() ; c++) {
                        outputA = input.setCoordinate(r, c, input.get(r,c)+4);
                    }
                }

                Assert.assertTrue("testSetCoordinate2x2 - Matrices are equal", outputE.equals(outputA));
            }

            private void testSetCoordinate3x3() {
                Matrix input = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
                Matrix outputE = new Matrix(new double[][]{{10,11,12},{13,14,15},{16,17,18}});

                Matrix outputA = input;
                for (int r = 0 ; r < input.rows() ; r++) {
                    for (int c = 0 ; c < input.columns() ; c++) {
                        outputA = input.setCoordinate(r, c, input.get(r,c)+9);
                    }
                }

                Assert.assertTrue("testSetCoordinate3x3 - Matrices are equal", outputE.equals(outputA));
            }

            private void testSetCoordinate2x3() {
                Matrix input = new Matrix(new double[][]{{1,2,3},{4,5,6}});
                Matrix outputE = new Matrix(new double[][]{{7,8,9},{10,11,12}});

                Matrix outputA = input;
                for (int r = 0 ; r < input.rows() ; r++) {
                    for (int c = 0 ; c < input.columns() ; c++) {
                        outputA = input.setCoordinate(r, c, input.get(r,c)+6);
                    }
                }

                Assert.assertTrue("testSetCoordinate2x3 - Matrices are equal", outputE.equals(outputA));
            }
        }

        TestSetCoordinate test = new TestSetCoordinate();
        test.testSetCoordinate1x1();
        test.testSetCoordinate2x2();
        test.testSetCoordinate3x3();
        test.testSetCoordinate2x3();
    }

    @Test //NOT GETTING IMPLEMENTED - NOT WRITING TESTS
    public void testAddMatrices() {
        class TestAddMatrices {
            private void testAddMatrices1z1() {

            }
        }

        TestAddMatrices test = new TestAddMatrices();
        test.testAddMatrices1z1();
    }

    @Test
    public void testArrayToMatrix() {
        class TestArrayToMatrix {
            private void testArrayToMatrix1x1() {
                try {
                    double[][] input = {{1}};
                    Matrix outputE = new Matrix(1, 1, new double[][]{{1}});
                    Matrix outputA = Matrix.arrayToMatrix(input);

                    Assert.assertTrue("testArrayToMatrix1x1 - Matrices are equal", outputE.equals(outputA));
                }
                catch (MalformedMatrixException e) {
                    Assert.fail("testArrayToMatrix1x1 - exception should not be thrown.");
                }
            }

            private void testArrayToMatrix2x2() {
                try {
                    double[][] input = {{1,2},{3,4}};
                    Matrix outputE = new Matrix(2, 2, new double[][]{{1,2},{3,4}});
                    Matrix outputA = Matrix.arrayToMatrix(input);

                    Assert.assertTrue("testArrayToMatrix2x2 - Matrices are equal", outputE.equals(outputA));
                }
                catch (MalformedMatrixException e) {
                    Assert.fail("testArrayToMatrix2x2 - exception should not be thrown.");
                }
            }

            private void testArrayToMatrix2x3() {
                try {
                    double[][] input = {{1,2,3},{4,5,6}};
                    Matrix outputE = new Matrix(2, 3, new double[][]{{1,2,3},{4,5,6}});
                    Matrix outputA = Matrix.arrayToMatrix(input);

                    Assert.assertTrue("testArrayToMatrix2x3 - Matrices are equal", outputE.equals(outputA));
                }
                catch (MalformedMatrixException e) {
                    Assert.fail("testArrayToMatrix2x3 - exception should not be thrown.");
                }
            }
        }

        TestArrayToMatrix test = new TestArrayToMatrix();
        test.testArrayToMatrix1x1();
        test.testArrayToMatrix2x2();
        test.testArrayToMatrix2x3();
    }

    @Test
    public void testStringToMatrix() {
        class TestParseMatrix {
            private void test1x1() {
                String input = "[[1]]";
                double[][] outputE = {{1}};
                double[][] outputA = Matrix.stringToMatrix(input).toArray();

                for (int i = 0; i < outputA.length; i++) {
                    for (int i1 = 0; i1 < outputA[i].length; i1++) {
                        Assert.assertEquals("Check that the parsing from string works 1x1: " + i + " x " + i1, outputE[i][i1], outputA[i][i1], 0);
                    }
                }
            }

            private void test2x2() {
                String input = "[[1,2] [3,4]]";
                double[][] outputE = {{1,2},{3,4}};
                double[][] outputA = Matrix.stringToMatrix(input).toArray();

                for (int i = 0; i < outputA.length; i++) {
                    for (int i1 = 0; i1 < outputA[i].length; i1++) {
                        Assert.assertEquals("Check that the parsing from string works 2x2: " + i + " x " + i1, outputE[i][i1], outputA[i][i1], 0);
                    }
                }
            }

            private void test3x3() {
                String input = "[[1,2,3] [4,5,6] [7,8,9]]";
                double[][] outputE = {{1,2,3},{4,5,6},{7,8,9}};
                double[][] outputA = Matrix.stringToMatrix(input).toArray();

                for (int i = 0; i < outputA.length; i++) {
                    for (int i1 = 0; i1 < outputA[i].length; i1++) {
                        Assert.assertEquals("Check that the parsing from string works 3x3: " + i + " x " + i1, outputE[i][i1], outputA[i][i1], 0);
                    }
                }
            }

            private void test4x3() {
                String input = "[[1,2,3] [4,5,6] [7,8,9] [10,11,12]]";
                double[][] outputE = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                double[][] outputA = Matrix.stringToMatrix(input).toArray();

                for (int i = 0; i < outputA.length; i++) {
                    for (int i1 = 0; i1 < outputA[i].length; i1++) {
                        Assert.assertEquals("Check that the parsing from string works 4x3: " + i + " x " + i1, outputE[i][i1], outputA[i][i1], 0);
                    }
                }
            }

            private void test3x4() {
                String input = "[[1,2,3,4] [5,6,7,8] [9,10,11,12]]";
                double[][] outputE = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                double[][] outputA = Matrix.stringToMatrix(input).toArray();

                for (int i = 0; i < outputA.length; i++) {
                    for (int i1 = 0; i1 < outputA[i].length; i1++) {
                        Assert.assertEquals("Check that the parsing from string works 3x4: " + i + " x " + i1, outputE[i][i1], outputA[i][i1], 0);
                    }
                }
            }
        }

        TestParseMatrix test = new TestParseMatrix();
        test.test1x1();
        test.test2x2();
        test.test3x3();
        test.test4x3();
        test.test3x4();
    }

    @Test
    public void testToArray() {
        class TestToArray {
            private void testToArray1x1() {
                Matrix input = new Matrix(1,1);
                double[][] outputE = {{0}};
                double[][] outputA = input.toArray();

                Assert.assertArrayEquals("Test to array 1x1: output doesn't match", outputE, outputA);
            }

            private void testToArray2x2() {
                Matrix input = new Matrix(2,2);
                double[][] outputE = {{0,0},{0,0}};
                double[][] outputA = input.toArray();

                Assert.assertArrayEquals("Test to array 2x2: output doesn't match", outputE, outputA);
            }

            private void testToArray3x3() {
                Matrix input = new Matrix(3,3);
                double[][] outputE = {{0,0,0},{0,0,0},{0,0,0}};
                double[][] outputA = input.toArray();

                Assert.assertArrayEquals("Test to array 3x3: output doesn't match", outputE, outputA);
            }

            private void testToArray3x2() {
                Matrix input = new Matrix(3,2);
                double[][] outputE = {{0,0},{0,0},{0,0}};
                double[][] outputA = input.toArray();

                Assert.assertArrayEquals("Test to array 3x2: output doesn't match", outputE, outputA);
            }

            private void testToArray2x3() {
                Matrix input = new Matrix(2,3);
                double[][] outputE = {{0,0,0},{0,0,0}};
                double[][] outputA = input.toArray();

                Assert.assertArrayEquals("Test to array 2x3: output doesn't match", outputE, outputA);
            }
        }

        TestToArray test = new TestToArray();
        test.testToArray1x1();
        test.testToArray2x2();
        test.testToArray3x3();
        test.testToArray3x2();
        test.testToArray2x3();
    }

    @Test
    public void testToString() {
        class TestToString {
            private void test1x1() {
                double[][] input = {{1}};
                String outputE = "[[1]]";
                String outputA = Matrix.arrayToMatrix(input).toString();

                Assert.assertTrue("Testing the toString method 1x1", outputA.equals(outputE));
            }

            private void test2x2() {
                double[][] input = {{1,2},{3,4}};
                String outputE = "[[1,2] [3,4]]";
                String outputA = Matrix.arrayToMatrix(input).toString();

                Assert.assertTrue("Testing the toString method 2x2", outputA.equals(outputE));
            }

            private void test3x3() {
                double[][] input = {{1,2,3},{4,5,6},{7,8,9}};
                String outputE = "[[1,2,3] [4,5,6] [7,8,9]]";
                String outputA = Matrix.arrayToMatrix(input).toString();

                Assert.assertTrue("Testing the toString method 3x3", outputA.equals(outputE));
            }

            private void test4x3() {
                double[][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
                String outputE = "[[1,2,3] [4,5,6] [7,8,9] [10,11,12]]";
                String outputA = Matrix.arrayToMatrix(input).toString();

                Assert.assertTrue("Testing the toString method 4x3", outputA.equals(outputE));
            }

            private void test3x4() {
                double[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                String outputE = "[[1,2,3,4] [5,6,7,8] [9,10,11,12]]";
                String outputA = Matrix.arrayToMatrix(input).toString();

                Assert.assertTrue("Testing the toString method 3x4", outputA.equals(outputE));
            }
        }

        TestToString test = new TestToString();
        test.test1x1();
        test.test2x2();
        test.test3x3();
        test.test4x3();
        test.test3x4();
    }
}