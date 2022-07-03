package com.contents.zorye;

public class makeNaverBlogHtml {
	
	
	
	public static String[] makeNaverBlogHtml(String[][] excelData) {
		
		
		commonText mth = new commonText();
		
		
		String naver_item[] = new String[3];
		String html_Naver = "";
		String title = "";
		String tag = "";
		
		String programName = excelData[1][0];
		String programNumber = excelData[1][1];
		String description = excelData[0][8];
		String thumbnail = excelData[0][7];
		

		title = programName + " ";
		tag = "#"+ programName + " ";
		tag += "#"+ programName + programNumber + " ";
		tag += "#" + mth.anotherProgramName(programName)+ " ";
		tag += "#"+ mth.anotherProgramName(programName) + programNumber + " ";
		
		html_Naver += mth.putEnter(3);
		html_Naver += description; // 설명

		html_Naver += mth.putEnter(3);
		//html_Naver += mth.setImage_Naver(thumbnail, programName + " " + programNumber + "에 나온 패션 및 상품 정보"); // 대표 이미지
		html_Naver += mth.putEnter(1);
			
		// 아이템 별로 생성
		for (int i = 1; i < excelData.length; i++) {

			if (excelData[i][0] == null || excelData[i][0] == "")
				break;
			String starName = excelData[i][2];
			String item = excelData[i][3];
			String itemName = excelData[i][4];
			String isItemInCP = excelData[i][6];
			String imageAddress = excelData[i][7];
			String itemText = excelData[i][8];
			String link_Naver = excelData[i][13];

			html_Naver += mth.h2Tag(starName + " " + item, isItemInCP); // h2 태그 만들기

			html_Naver += mth.putEnter(1);
			html_Naver += mth.p(itemName); // 제품명
			html_Naver += mth.p(itemText); // 제품설명

			html_Naver += mth.putEnter(2);
			html_Naver += mth.linkText_Naver(link_Naver, starName, item, isItemInCP); // 링크 바로가기 만들기
			
			
			// 이미지는 일단 제외..
			//html_Naver += mth.putEnter(1);
			//html_Naver += mth.setImage_Naver(imageAddress, itemName); // 이미지 올리기


			html_Naver += mth.putEnter(3);

			// 제목에 아이템 추가
			//title += i > 1 ? " " : "";
			title += title.contains(starName) ? "" : starName + " ";
			// System.out.println(title);
			if (mth.isCloth(item) && !title.contains("옷"))
				title += "옷 ";
			title += title.contains(item) ? "" : item + " ";
			title += title.contains(mth.getSameWord(item)) ? "" : mth.getSameWord(item) + " ";

			// 태그 추가
			tag += tag.contains(programName+starName) ? "" : "#"+programName+starName + " ";
			tag += "#"+ starName + item + " ";
			
		}
		
		
		/*
		html_Naver += "<p>▼ </p>";
		html_Naver += mth.putEnter(2);
		html_Naver += "<p>▼ </p>";
		html_Naver += mth.putEnter(2);
		html_Naver += "<p>▼ </p>";
		html_Naver += mth.putEnter(2);
		*/


		title += "패션 " + programNumber;
		

		naver_item[0] = title;
		naver_item[1] = html_Naver;
		naver_item[2] = tag;
		
		return naver_item;
		
	}
	
	
	

}
