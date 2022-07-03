package com.contents.zorye;

public class commonText {
	// 옷 여부
		public static boolean isCloth(String item) {
			String fashion = "";
			fashion += "티셔츠 맨투맨 반팔티 긴팔티 카라 러플 레이스 블라우스 세일러 하프집업 집업 셔츠 쭉티 남방 재킷 자켓 ";
			fashion += "가디건 볼레로 니트 스웨터 조끼 베스트 바람막이 코트 점퍼 돕바 잠바 트랙탑 나시 슬리브리스 ";
			fashion += "잠옷 파자마 가운 골프웨어 앞치마 에이프런 ";
			fashion += "바지 팬츠 반바지 스커트 치마 레깅스 원피스 투피스 ";

			return fashion.contains(item) ? true : false;
		}

		// 패션 아이템 여부
		public static boolean isFashionItem(String item) {

			String fashion = "";
			fashion += "모자 비니 볼캡 선캡 베래모 배래모 베레모 버킷햇 ";
			fashion += "목걸이 반지 귀걸이 팔찌 벨트 ";
			fashion += "신발 운동화 구두 나이키운동화 ";

			return fashion.contains(item) ? true : false;
		}

		public String getSameWord(String item) {

			String sameWord = "";

			if (item.contains("치마"))
				sameWord = "스커트";
			if (item.contains("스커트"))
				sameWord = "치마";
			if (item.contains("바지"))
				sameWord = "팬츠";
			if (item.contains("팬츠"))
				sameWord = "바지";
			if (item.contains("운동화"))
				sameWord = "신발";
			if (item.contains("신발"))
				sameWord = "운동화";
			if (item.contains("조끼"))
				sameWord = "베스트";
			if (item.contains("베스트"))
				sameWord = "조끼";
			if (item.contains("청"))
				sameWord = "데님";
			if (item.contains("데님"))
				sameWord = "청";
			if (item.contains("데님셔츠"))
				sameWord = "청남방";

			return sameWord;
		}

		public String setImage(String imageAddress, String itemName) {

			String html = "<p>";
			html += imageAddress.replace("}_##]", "");
			html += ",\"alt\":\"";
			html += itemName;
			html += "\"}_##]</p>";
			return html;
		}

		public String linkText(String link, String starName, String item, String isItemInCP) {

			// 아이템에 따라 워딩 변경
			String wording = wording(item);

			// 쿠팡에 있으면 스타가 사용한 아이템 보러가기, 없으면 브랜드 보러가기, 비슷한 제품은 아이템 보러가기
			String goText = (isItemInCP.contains("y") || isItemInCP.contains("Y")) ? starName + " " + item + " 보러가기"
					: item + " 브랜드 보러가기 ";
			goText = (isItemInCP.contains("m") || isItemInCP.contains("M")) ? item + " 보러가기" : goText;

			// 링크 html 만들기
			String linkTag = "<p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"";
			linkTag += goText;
			linkTag += "\" href=\"" + link;
			linkTag += "\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u>"
					+ "<span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\">"
					+ "<span style=\"background-color: #f6e199;\"><b>▶ ";
			linkTag += goText;
			linkTag += "</b></span></span></u></span></a></p>";
			return linkTag;
		}

		public static String wording(String item) {
			String wording = " 착용한 ";
			if (isCloth(item) || isFashionItem(item))
				wording = " 사용한 ";
			return wording;

		}
		public static String anotherProgramName(String programName) {
			String proName = "";
			if(programName.equals("나혼자산다")) proName = "나혼산";
			if(programName.equals("나혼산")) proName = "나혼자산다";
			if(programName.equals("전지적참견시점")) proName = "전참시";
			if(programName.equals("전참시")) proName = "전지적참견시점";
			if(programName.equals("미운우리새끼")) proName = "미우새";
			if(programName.equals("미우새")) proName = "미운우리새끼";
			if(programName.equals("라디오스타")) proName = "라스";
			if(programName.equals("라스")) proName = "라디오스타";
			if(programName.equals("놀라운토요일")) proName = "놀토";
			if(programName.equals("놀토")) proName = "놀라운토요일";
			if(programName.equals("옥탑방의문제아들")) proName = "옥문아";
			if(programName.equals("옥문아")) proName = "옥탑방의문제아들";
			
			
			return proName;
			
			
		}
		public String p(String text) {
			String p = "<p style=\"text-align: justify;\" data-ke-size=\"size17\">";
			p += text;
			p += "</p>";

			return p;
		}

		public String h2Tag(String h2, String isItemInCP) {
			String h2Text = "";
			boolean isAvailItem = isItemInCP.contains("m") || isItemInCP.contains("M") ? true : false;
			h2Text = "<h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; "
					+ "border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; "
					+ "line-height: 1.2;\" data-ke-size=\"size26\">"
					+ "<b><span style=\"font-size: 18px; color: #ef5369;\">" + "<b><span style=\"font-family: '이롭게바탕';\">";
			h2Text += h2;
			h2Text += isAvailItem ? "(비슷한 상품)" : "";
			h2Text += "</span></b><span style=\"font-size: 14px; "
					+ "font-weight: normal; color: #7e98b1;\"></span></span></b></h2>";

			return h2Text;
		}

		public String putEnter(int num) {
			// String enter = "<p data-ke-size=\"size16\">&nbsp;</p>";
			String enter = "<br>";
			for (int i = 0; i < num - 1; i++) {
				enter += enter;
			}
			return enter;
		}
		
		
		
		public static String setImage_Naver(String imageAddress, String itemName) {
			/*
			String html = "<p style=\"text-align: center;\" data-ke-size=\"size19\">"
					+ "<img class=\"fit-picture\" src=\"";
			html += imageAddress;
			html += "\" alt=\"";
			html += itemName;
			html += "\"/></p>";*/
			String html = "<p style=\"text-align: center;\" data-ke-size=\"size19\">";
			html += imageAddress + "</p>";
			return html;
		}
		
		public static String linkText_Naver(String link, String starName, String item, String isItemInCP) {

			// 아이템에 따라 워딩 변경
			String wording = wording(item);

			// 쿠팡에 있으면 스타가 사용한 아이템 보러가기, 없으면 브랜드 보러가기, 비슷한 제품은 아이템 보러가기
			String goText = (isItemInCP.contains("y") || isItemInCP.contains("Y")) ? starName + wording + item + " 보러가기"
					: item + " 브랜드 보러가기 ";
			goText = (isItemInCP.contains("m") || isItemInCP.contains("M")) ? item + " 보러가기" : goText;

			// 링크 html 만들기
			String linkTag = "<p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"";
			linkTag += goText;
			linkTag += "\" href=\"https://zoryewoman.github.io/zoryeRespos/zoryeGo_new.html?id=" + link.substring(link.length()-6);
			linkTag += "\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u>"
					+ "<span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\">"
					+ "<span style=\"background-color: #f6e199;\"><b>▶ ";
			linkTag += goText;
			linkTag += "</b></span></span></u></span></a></p>";
			return linkTag;
		}
}
