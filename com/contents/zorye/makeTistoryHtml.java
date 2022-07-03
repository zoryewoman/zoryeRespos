package com.contents.zorye;

public class makeTistoryHtml {

	public static String[] makeTistoryHtml(String[][] excelData, String[][] adsenseData) {
		commonText ct = new commonText();
		String tis_item[] = new String[3];
		String html_Tis = "";
		String title = "";
		String tag = "";

		String programName = excelData[1][0];
		String programNumber = excelData[1][1];
		String description = excelData[0][10];
		String thumbnail = excelData[0][9];

		title = programName + " ";
		tag = programName + ", ";

		html_Tis += ct.putEnter(3);
		html_Tis += description; // 티스토리 설명

		html_Tis += ct.putEnter(3);
		html_Tis += ct.setImage(thumbnail, programName + " " + programNumber + "에 나온 패션 및 상품 정보"); // 대표 이미지
		html_Tis += ct.putEnter(1);
		html_Tis += adsenseData[0][0];
		html_Tis += ct.putEnter(1);
		html_Tis += "<p>▼ </p>";
		html_Tis += ct.putEnter(1);
		html_Tis += adsenseData[0][0];
		html_Tis += ct.putEnter(3);

		// 아이템 별로 생성
		for (int i = 1; i < excelData.length; i++) {

			if (excelData[i][0] == null || excelData[i][0] == "")
				break;
			String starName = excelData[i][2];
			String item = excelData[i][3];
			String itemName = excelData[i][4];
			String isItemInCP = excelData[i][6];
			String imageAddress = excelData[i][9];
			String itemText = excelData[i][10];
			String link_Tistory = excelData[i][14];

			html_Tis += ct.h2Tag(starName + " " + item, isItemInCP); // h2 태그 만들기

			html_Tis += ct.putEnter(1);
			html_Tis += ct.p(itemName); // 제품명
			html_Tis += ct.p(itemText); // 제품설명

			html_Tis += ct.putEnter(2);
			html_Tis += ct.linkText(link_Tistory, starName, item, isItemInCP); // 링크 바로가기 만들기

			html_Tis += ct.putEnter(1);
			html_Tis += ct.setImage(imageAddress, itemName); // 이미지 올리기

			html_Tis += ct.putEnter(2);
			html_Tis += adsenseData[i][0]; // 애드센스 달기

			html_Tis += ct.putEnter(3);

			// 제목에 아이템 추가
			//title += i > 1 ? " " : "";
			title += title.contains(starName) ? "" : starName + " ";
			// System.out.println(title);
			if (ct.isCloth(item) && !title.contains("옷"))
				title += "옷 ";
			title += title.contains(item) ? "" : item + " ";
			title += title.contains(ct.getSameWord(item)) ? "" :ct.getSameWord(item) + " ";

			// 태그 추가
			tag += starName + item + ", ";
		}

		html_Tis += "<p>▼ </p>";
		html_Tis += ct.putEnter(1);
		html_Tis += "<p>▼ </p>";
		html_Tis += ct.putEnter(1);
		html_Tis += "<p>▼ </p>";
		html_Tis += ct.putEnter(2);

		// 마지막에 애드센스 멀티 광고 추가
		html_Tis += adsenseData[8][0];
		html_Tis += ct.putEnter(3);
		html_Tis += "<p>본 글을 통해 구매가 발생할 시 구매자에게는 아무 부담되지 않는 일정액의 수수료를 받을 수 있음을 알려드립니다.</p>";
		html_Tis += ct.putEnter(2);

		title += "패션 " + programNumber;
		tag += programName + programNumber;

//		System.out.println(title);
//		System.out.println(html_Tis);

		tis_item[0] = title;
		tis_item[1] = html_Tis;
		tis_item[2] = tag;
		return tis_item;
	}

	
}
