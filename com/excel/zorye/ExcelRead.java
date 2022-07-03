package com.excel.zorye;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.print.zorye.PrintObjects;

public class ExcelRead {

	/***************************************************************************
	 * 엑셀에서 데이터 읽어와 String[][] 에 저장
	 * 
	 * @param excelData
	 ****************************************************************************/
	public String[][] read(String path, String fileName, String sheetName) throws IOException {

		String[][] excelData = null; // 엑셀 데이터 저장하는 String 2차원 배열
		
		FileInputStream fis = new FileInputStream(path + File.separator + fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();

		Iterator<Row> iter = sheet.rowIterator();

		int numRow = 1;
		int numCell = 0;	// 220619 기준 열 14개(제목 줄에 있는 만큼 가져옴)
		excelData = new String[rows][]; // 2차배열 초기화(상품 갯수만큼)
		// 행
		while (iter.hasNext()) {
			Row r = iter.next();

			// 프로그램[0] 회차[1] 사람[2] 종류[3] 제품명(제목)[4] 상품페이지[5] 링크프라이스[6] 멘트[7]

			if(numRow == 1) numCell = r.getLastCellNum(); // 제목줄 마지막 데이터가 있는 cell 수 가져오기

			String[] data = new String[numCell]; // 열 데이터 배열 선언/초기화

			/* String[][]에 엑셀 데이터 넣기 */
			for (int i = 0; i < numCell; i++) {
				if (r.getCell(i) == null) {
					data[i] = "";
				}
				else {
					data[i] = r.getCell(i).toString();
				}
			}
			excelData[numRow - 1] = data;
			numRow++;
		}
		workbook.close();

		/* 엑셀데이터 출력 확인 */
		//PrintObjects.printArrangement(excelData);

		return excelData;
	}

	/***************************************************************************
	 * 엑셀 데이터 중 쿠팡 검색 링크만 List에 추가! 첫 줄은 제목이므로 2번째 줄부터 List에 추가됩니다.
	 **************************************************************************/
	public List<String> putOrgLinksToList(String[][] excelData, int idxOrgLink) {
		List<String> orgLinks = new ArrayList<String>();
		for (int i = 0; i < excelData.length - 1; i++) {

			orgLinks.add(excelData[i + 1][idxOrgLink]);

		}
		return orgLinks;

	}
}