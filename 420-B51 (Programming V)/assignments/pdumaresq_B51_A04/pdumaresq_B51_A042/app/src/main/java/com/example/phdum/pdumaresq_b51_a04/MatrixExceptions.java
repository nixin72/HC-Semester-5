package com.example.phdum.pdumaresq_b51_a04;

class InvalidMatrixException extends Exception {
    public InvalidMatrixException() {
        super();
    }

    public InvalidMatrixException(String message) {
        super(message);
    }
}

class MalformedMatrixException extends InvalidMatrixException {
    public MalformedMatrixException() {
        super();
    }

    public MalformedMatrixException(String message) {
        super(message);
    }
}

class InvalidMatrixOperationException extends InvalidMatrixException {
    public InvalidMatrixOperationException() {
        super();
    }

    public InvalidMatrixOperationException(String message) {
        super(message);
    }
}

class IncompatibleMatricesException extends InvalidMatrixOperationException {
    public IncompatibleMatricesException() {
        super();
    }

    public IncompatibleMatricesException(String message) {
        super(message);
    }
}

class NoDeterminantException extends InvalidMatrixOperationException {
    public NoDeterminantException() {
        super();
    }

    public NoDeterminantException(String message) {
        super(message);
    }
}

class NoInverseException extends InvalidMatrixOperationException {
    public NoInverseException() {
        super();
    }

    public NoInverseException(String message) {
        super(message);
    }
}

