package com.example.phdum.pdumaresq_b51_a04;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Matrices";
    private static final String TABLE_MATRIX = "matrix";

    private static final String KEY_ID = "id";
    private static final String KEY_ROWS = "rows";
    private static final String KEY_COLS = "columns";
    private static final String KEY_EQUATION = "equation";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_MATRIX + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ROWS + " TEXT,"
                + KEY_COLS + " TEXT," + KEY_EQUATION + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATRIX);
        onCreate(db);
    }

    public void resetDatabase() {
        SQLiteDatabase db = this.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(TABLE_MATRIX, null, null);
    }

    int createMatrix(Matrix matrix, Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        if (getNumMatrices() >= settings.getInt("maxEntries", 15)) {
            return -1;
        }

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROWS, matrix.rows());
        values.put(KEY_COLS, matrix.columns());
        values.put(KEY_EQUATION, matrix.toString());
        db.insert(TABLE_MATRIX, null, values);

        int id = 0;
        Cursor cursor = db.rawQuery("SELECT last_insert_rowid()", null);
        if (cursor.moveToFirst()) {
            do {
                id = Integer.parseInt(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return id;
    }

    void removeOldRows(int n) {
        String selectQuery = "SELECT  * FROM " + TABLE_MATRIX;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                if (n > 0) {
                    int id = Integer.parseInt(cursor.getString(0));
                    deleteMatrix(id);
                    n--;
                }
                else {
                    break;
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
    }

    int removeLargeMatrices(int r, int c) {
        int numDeleted = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_MATRIX;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                Matrix matrix = new Matrix(Matrix.stringToMatrix(cursor.getString(3)).toArray());
                if (matrix.rows() > r || matrix.columns() > c) {
                    deleteMatrix(id);
                    numDeleted++;
                }

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return numDeleted;
    }

    Matrix retrieveMatrix(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MATRIX, new String[] { KEY_ID,
                        KEY_ROWS, KEY_COLS, KEY_EQUATION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Matrix matrix = new Matrix(Matrix.stringToMatrix(cursor.getString(3)).toArray());
        matrix.setId(Integer.parseInt(cursor.getString(0)));

        cursor.close();
        db.close();
        return matrix;
    }

    public List<Matrix> retrieveMatrices() {
        List<Matrix> matrices = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_MATRIX;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                Matrix matrix = new Matrix(Matrix.stringToMatrix(cursor.getString(3)).toArray());
                matrix.setId(id);

                matrices.add(matrix);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return matrices;
    }

    public int updateMatrix(Matrix matrix) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROWS, matrix.rows());
        values.put(KEY_COLS, matrix.columns());
        values.put(KEY_EQUATION, matrix.toString());

        int ret = db.update(TABLE_MATRIX, values, KEY_ID + " = ?",
                new String[] { String.valueOf(matrix.getId()) });
        db.close();
        return ret;
    }

    public void deleteMatrix(Matrix matrix) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MATRIX, KEY_ID + " = ?",
                new String[] { String.valueOf(matrix.getId()) });
        db.close();
    }

    public void deleteMatrix(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MATRIX, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    public int getNumMatrices() {
        String countQuery = "SELECT  * FROM " + TABLE_MATRIX;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count;
    }
}
