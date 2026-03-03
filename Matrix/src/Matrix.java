
import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * stelt een matrix voor 
 * @immutable 
 
 */
public class Matrix {
	

/***
 * @pre rijen en kolommen zijn positieve getallen 
 * 		| 0 <= row && 0 <= column
 * @pre rijen en kolommen vallen binnen grenzen
 * 		| row < getRows() && column < getColumns()
 * @post |result == getRowArray()[row][column]
 * 
 */
public double getElement(int row, int column)
{return elements[row*columns + column];}

/**
 * @post| 0< result 
 */
public int getRows()
{return rows;}

/**
 * @post| 0< result 
 */
public int getColumns()
{return columns;}

/**
 * @creates |result
 * @post| result != null  
 * @post| result.length == getRows()*getColumns()
 */
public double [] getElementsRowMajor() 
{return elements.clone();}

/**
 * @creates |result
 * @post| result != null  
 * @post| result.length == getRows() *  getColumns()
 */
public double[] getElementsColumnMajor() {
    double[] result = new double[elements.length];
    for (int row = 0; row < rows ; row++) {
        for (int col = 0; col < columns; col++) {
            // (row, col) in column-major komt op index col*rows + row
            result[col * rows + row] =
                elements[row * columns + col]; // row-major index
        }
    }
    return result;
}


/** 
 * @creates |result, ... result
 *@post |result != null
 *@post |result.length == getRows()
  @post | IntStream.range(0, getRows()).allMatch(r -> result[r].length == getColumns())
 * 
 */
public double[][] getRowArray() {
double elementen [][] = new double [rows][columns];
for (int i = 0; i<rows; i++) {
	for(int j = 0; j< columns; j++) {
		elementen[i][j] = elements[columns*i + j];
	}}
return elementen;
		
		
}



/**
 * CONSTRUCTOR 
 * @post |getRows() == rowsinput
 * @post |getColumns() == columnsinput
 * @post |getElementsRowMajor().length == elementsinput.length
 * @post |getElementsColumnMajor().length == elementsinput.length
 * @post |Arrays.equals(elementsinput, getElementsRowMajor())
 */
public Matrix(int rowsinput, int columnsinput, double [] elementsinput) {
	
if (rowsinput<= 0) 
	throw new IllegalArgumentException("rows need to be greater than 0");
if (columnsinput <= 0) 
	throw new IllegalArgumentException("columns need to be greater than 0");
if (elementsinput == null)
	throw new IllegalArgumentException("elements needs to be a list");

if (elementsinput.length != rowsinput*columnsinput)
	throw new IllegalArgumentException("matrix needs to be filled");

rows = rowsinput;
columns = columnsinput;
elements = elementsinput.clone();

}



/**
 * @pre |other != null
 * @pre | getRows() == other.getRows()
 * @pre | getColumns() == other.getColumns()
 * 
 * @post| getRows() == result.getRows()
 * @post| getColumns() == result.getColumns()
 * @post| IntStream.range(0,getElementsRowMajor().length).allMatch(i -> result.getElementsRowMajor()[i] == getElementsRowMajor()[i] + other.getElementsRowMajor()[i])
 */
public Matrix plus(Matrix other) {
	double [] elementsnieuw = new double [elements.length];
	for (int i = 0; i < rows; i++)
	{for (int j = 0; j < columns; j++)
		elementsnieuw[i* columns + j] = elements[i* columns + j] + other.elements[i* columns + j];
		
	}
	return new Matrix(rows,columns,elementsnieuw);

}



/**
 * 
 * 
 * @post| getRows() == result.getRows()
 * @post| getColumns() == result.getColumns()
 * @post| IntStream.range(0,getElementsRowMajor().length).allMatch(i -> result.getElementsRowMajor()[i] == scalar* getElementsRowMajor()[i])
 */
public Matrix scaled(double scalar) {
	double [] elementsnieuw = new double [elements.length];
	for (int i = 0; i < rows; i++)
	{for (int j = 0; j < columns; j++)
		elementsnieuw[i* columns + j] = scalar* elements[i* columns + j];
		
	}
	return new Matrix(rows,columns,elementsnieuw);
}



/**
 
 * @invar elements != null
 * @invar rows > 0
 * @invar columns >  0 
 * @invar elements.length == rows * columns
 * @representationObject
 */

private double [] elements;
private int rows ;
private int columns ;

		


}



