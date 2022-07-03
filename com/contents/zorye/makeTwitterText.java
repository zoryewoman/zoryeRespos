package com.contents.zorye;

public class makeTwitterText {
	
	
	@SuppressWarnings("null")
	public  static String[] makeTwitterText(String[][] excelData) {
		commonText ct = new commonText();
		//String twitterText = "";
		
		
		String text_Twit[] = new String[excelData.length-1];
	
		
		// 아이템 별로 생성
		for (int i = 1; i < excelData.length; i++) {

			if (excelData[i][0] == null || excelData[i][0] == "")
				break;
			String programName = excelData[i][0];
			String programNumber = excelData[i][1];
			String starName = excelData[i][2];
			String item = excelData[i][3];
			String itemName = excelData[i][4];
			String isItemInCP = excelData[i][6];
			String link_Twitter = excelData[i][12];
			
			text_Twit[i-1] = "#" + programName + " #" + programNumber + " #" + starName + " #" + item ;
			text_Twit[i-1] += System.lineSeparator();
			//text_Twit[i-1] += starName + "이(가)" + commonText.wording(isItemInCP) + item + " ";
			text_Twit[i-1] += starName + " " + item + " ";
			text_Twit[i-1] += itemName + "제품이네요.";
			
			text_Twit[i-1] += System.lineSeparator();
			text_Twit[i-1] += System.lineSeparator();
			
			if (isItemInCP.equals("y") || isItemInCP.equals("Y")) 
				text_Twit[i-1] += "▶ 바로 보러가기 : ";
			else if(isItemInCP.equals("m") || isItemInCP.equals("M"))
				text_Twit[i-1] += "▶ " + item + " 보러가기 : ";
			else
				text_Twit[i-1] += "▶ 브랜드 보러가기 : ";
			
			text_Twit[i-1] += link_Twitter;
			text_Twit[i-1] += System.lineSeparator();
			text_Twit[i-1] += System.lineSeparator();
			text_Twit[i-1] += "파트너스 활동의 일환으로 구매자에게 부담없는 일정액의 수수료를 받을 수 있어요.";
			text_Twit[i-1] += System.lineSeparator();
			
			//System.out.println(text_Twit[i-1]);
		}		
			
		
		
		return text_Twit;
	}
}
