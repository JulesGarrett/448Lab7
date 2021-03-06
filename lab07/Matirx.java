//Julia Garrett
//Last Work on: 3/26/17
//Matirx calculation files
package eecs448_lab7;

import java.lang.Math;
import java.io.*;
import java.util.Scanner;


public class Matirx {
static int MaxSize=10;
static int n;
static double[][] mdata=new double[MaxSize][MaxSize];

	public Matirx(int size){
		n=size;
		MaxSize=size;
	}
	
	public void setMat(double[][] arr){
		mdata=arr;
	}
	
	public double getValue(int x, int y){
		return mdata[x][y];
	}

	public static double determinant(){
		double det = 0.0;
		
		if (n == 1)
		{
			det = mdata[0][0];
		}
		else if (n == 2)
		{
			det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
		}
		else
		{
			for (int i = 0; i < n; ++i)
			{
				det += Math.pow(-1.0, (double)i) * mdata[0][i] * subMatrix(0, i).determinant();
			}
		}
		
		return det;
	}
	public static Matirx inverse(){
		Matirx inv =new Matirx(n);
		double det = determinant();
		
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				inv.mdata[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
			}
		}
		
		return inv;
	}
	public static Matirx subMatrix(int r, int c){
		
		Matirx sub=new Matirx(n-1);
		int row = 0; 
		for (int i = 0; i < n; ++i)
		{
			if (i == r) continue;
			
			int col = 0;
			for (int j = 0; j < n; ++j)
			{
				if (j == c) continue;
				
				sub.mdata[row][col] = mdata[i][j];
				++col;
			}
			
			++row;
		}
		
		return sub;
	}

}
