
import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * stelt een matrix voor 
 * @immutable 
 * @invar |getColumns() >= 0
 * @invar |getRows() >= 0
 * 
 */
public class matrix {
	

/***
 * @pre| this != null 
 * @pre rijen en kolommen zijn positieve getallen 
 * 		| 0 < row && 0 < column
 * @pre rijen en kolommen vallen binnen grenzen
 * 		| row <= getRows() && column <= getColumns()
 * 
 */
public double getElement(int row, int column)
{return 0;}

/**
 * @pre| this != null 
 * @post| 0< result 
 */
public int getRows()
{return 0;}

/**
 * @pre| this != null 
 * @post| 0< result 
 */
public int getColumns()
{return 0;}

/**
 * @pre| this != null 
 * @post| result != null  
 * @post| result.length == getRows()*getColumns()
 */
public double [] getElementsRowMajor() 
{double [] elements = new double [0];
return elements;
}

/**
 * @pre| this != null 
 * @post| result != null  
 * @post| result.length == getRows() *  getColumns()
 */
public double[] getElementsColumMajor() 
{double [] elements = new double[0];
return elements;}


/**
 * 
 * 
 */
public double[][] getRowArray() {
double elements [][] = new double [0][0];
return elements;
}
 
 
}
