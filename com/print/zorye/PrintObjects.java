package com.print.zorye;

import java.util.List;

public class PrintObjects {

	/***************************************************************************
	 * List<String> 출력해보는 함수
	 * 
	 * @param excelData
	 ****************************************************************************/
	public static void printList(List<String> list) {

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/***************************************************************************
	 * String[][] 출력해보는 함수
	 * 
	 * @param array2
	 ****************************************************************************/
	public static void printArrangement(String[][] array2) {

		for (int i = 0; i < array2.length; i++) {

			System.out.println(i + "+++++++++++++++++");
			for (int j = 0; j < array2[i].length; j++) {
				System.out.println(array2[i][j]);
			}
		}
	}
	
	
	/***************************************************************************
	 * String[] 출력해보는 함수
	 * null 이면 빈값 출력
	 * 
	 * @param array
	 ****************************************************************************/
	public static void printArrangement(String[] array) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null )System.out.println(array[i]);
			
		}
	}

}
