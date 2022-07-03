package com.parse.zorye;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonParsing1 {

	@SuppressWarnings("null")
	public String[] getShortUrl(String jsonString) throws org.json.JSONException {
		/*
		 * String jsonString = "{" + "\"post1\": {" +
		 * "\"title\": \"how to get stroage size\"," +
		 * "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
		 * + "\"draft\": false" +"  }," + "\"post2\": {" +
		 * "\"title\": \"Android Q, Scoped Storage\"," +
		 * "\"url\": \"https://codechacha.com/ko/android-q-scoped-storage/\"," +
		 * "\"draft\": false" + "}" +"}";
		 * "{\"coupangUrls\": [\"https://www.coupang.com/np/search?component=&q=good&channel=user\"
		 * , \"https://www.coupang.com/np/coupangglobal\"]}";
		 * 
		 * 
		 * 
		 * { "rCode": "0", "rMessage": "", "data": [ { "originalUrl":
		 * "https://www.coupang.com/vp/products/184614775", "shortenUrl":
		 * "https://coupa.ng/blE0dT", "landingUrl":
		 * "https://link.coupang.com/re/AFFSDP?lptag=AF1234567&pageKey=319834306&itemId=1023216541&vendorItemId=70064597513&traceid=V0-183-5fddb21eaffbb2ef"
		 * } ] }
		 */

		// String originalUrl = null;
		// String shortenUrl = null;
		// String landingUrl = null;
		String[] shortUrl = null;
		JSONObject jObject;

		try {
			jObject = new JSONObject(jsonString);

			JSONArray post1Object = jObject.getJSONArray("data");
			int numData = post1Object.length();
			shortUrl = new String[numData];

			for (int i = 0; i < numData; i++) {

				try {

					// originalUrl = post1Object.getJSONObject(i).getString("originalUrl");
					// landingUrl = post1Object.getJSONObject(i).getString("landingUrl");
					shortUrl[i] = post1Object.getJSONObject(i).getString("shortenUrl");

					// System.out.println(originalUrl);

					// 단축링크 출력
					System.out.println(shortUrl[i]);

				} catch (JSONException e) {

				}

			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return shortUrl;
	}
	
	/**
	 * 
	 * 티스토리 응답값 변환
	 * {"access_token":"69bbaf0ef4799ac01ad447be2be2a09c_d598760d80a49b4fa883465b0dff07bd"  ,"output":"json"  ,"blogName":"anpd-info"  ,"title":"전참시 양세형 옷 조끼 베스트 송은이 송가인 핑크캐미솔 이영자 티셔츠 전현무 카리나 트위드자켓 패션 206회"  ,"content":"<br><br><br><br>티스 설명<br><br><br><br><p><p>[##_Image|kage@woDOK/btrGg4bbC1d/s6W8ECAVquKkj8hcaEkxIK/img.png|CDM|1.3|{\"originWidth\":1141,\"originHeight\":1146,\"style\":\"alignCenter\",\"alt\":\"전참시 206회에 나온 패션 및 상품 정보\"}_##]</p><br><!--인피드--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block; text-align:center;\"     data-ad-layout=\"in-article\"     data-ad-format=\"fluid\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"5832835437\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script><br><p>▼ </p><br><!--인피드--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block; text-align:center;\"     data-ad-layout=\"in-article\"     data-ad-format=\"fluid\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"5832835437\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">양세형 조끼</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">화이트박스갤러리 Flower Vest </p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"조끼 브랜드 보러가기 \" href=\"https://link.coupang.com/a/ryE8x\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 조끼 브랜드 보러가기 </b></span></span></u></span></a></p><br><p>  [##_Image|kage@xBsHO/btrGlhNpTiI/jLh68kT6WTIGppCHK0DsKk/img.png|CDM|1.3|{\"originWidth\":454,\"originHeight\":549,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T021517.133.png\",\"alt\":\"화이트박스갤러리 Flower Vest \"}_##]</p><br><br><!--인피드--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"      style=\"display:block; text-align:center;\"      data-ad-layout=\"in-article\"      data-ad-format=\"fluid\"      data-ad-client=\"ca-pub-9397688686686823\"      data-ad-slot=\"2760255084\"></ins> <script>      (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">송은이 조끼</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">비욘드클로젯  SIGNATURE WAPPEN LOGO SUMMER KNIT VEST BLACK[A]</p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"송은이 조끼 보러가기\" href=\"https://link.coupang.com/a/ryE8z\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 송은이 조끼 보러가기</b></span></span></u></span></a></p><br><p>  [##_Image|kage@rP24P/btrGiumE0aD/sPk8MRqky7iMHhqKwKhisk/img.png|CDM|1.3|{\"originWidth\":497,\"originHeight\":503,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T021316.957.png\",\"alt\":\"비욘드클로젯  SIGNATURE WAPPEN LOGO SUMMER KNIT VEST BLACK[A]\"}_##]</p><br><br><!--인피드--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block; text-align:center;\"     data-ad-layout=\"in-article\"     data-ad-format=\"fluid\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"2185540010\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">송가인 핑크캐미솔(비슷한 상품)</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">마제 maje Madeny braided-trim stretch-jersey cami top</p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"핑크캐미솔 보러가기\" href=\"https://link.coupang.com/a/ryE8A\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 핑크캐미솔 보러가기</b></span></span></u></span></a></p><br><p>  [##_Image|kage@crGRNj/btrGkdEeP57/FGXv9MzVO6XI5BR6DK7q91/img.png|CDM|1.3|{\"originWidth\":480,\"originHeight\":520,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T013813.136.png\",\"alt\":\"마제 maje Madeny braided-trim stretch-jersey cami top\"}_##]</p><br><br><!--인피드--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block; text-align:center;\"     data-ad-layout=\"in-article\"     data-ad-format=\"fluid\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"4071985682\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">이영자 티셔츠</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">21SS 파일렛베어 루즈핏티셔츠 PMAA041S21JER006 0101</p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"이영자 티셔츠 보러가기\" href=\"https://link.coupang.com/a/ryE8B\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 이영자 티셔츠 보러가기</b></span></span></u></span></a></p><br><p>  [##_Image|kage@buag51/btrGhWReRyQ/AnueIH0NKQBxndb2Rzvjq0/img.png|CDM|1.3|{\"originWidth\":466,\"originHeight\":535,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T013810.193.png\",\"alt\":\"21SS 파일렛베어 루즈핏티셔츠 PMAA041S21JER006 0101\"}_##]</p><br><br><!--멀티광고--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block\"     data-ad-format=\"autorelaxed\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"5337968884\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">전현무 티셔츠(비슷한 상품)</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">인사일런스 Big Stripe Oversize Tee (Black)</p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"티셔츠 보러가기\" href=\"https://link.coupang.com/a/ryE8C\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 티셔츠 보러가기</b></span></span></u></span></a></p><br><p>  [##_Image|kage@TGGbv/btrGlf9Utvn/QaAkE20d7Qh7D81i3Co8Xk/img.png|CDM|1.3|{\"originWidth\":490,\"originHeight\":509,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T014722.672.png\",\"alt\":\"인사일런스 Big Stripe Oversize Tee (Black)\"}_##]</p><br><br><!--디스플레이--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><!-- 디스플레이1 --><ins class=\"adsbygoogle\"      style=\"display:block\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"1610824940\"     data-ad-format=\"auto\"     data-full-width-responsive=\"true\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">카리나 트위드자켓</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><br><p style=\"text-align: justify;\" data-ke-size=\"size17\">OZLANA 블루 트위드 숏탑 스커트 슬림 하이웨이스트 A라인 숏스커트 스위트 리틀 프레그랑스 슈트</p><p style=\"text-align: justify;\" data-ke-size=\"size17\"></p><br><br><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"트위드자켓 브랜드 보러가기 \" href=\"https://link.coupang.com/a/ryE8D\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 트위드자켓 브랜드 보러가기 </b></span></span></u></span></a></p><br><p>  [##_Image|kage@rDpdF/btrGjEWFtMo/tHaiH0YJ9j7DvrwJWmSokk/img.png|CDM|1.3|{\"originWidth\":341,\"originHeight\":386,\"style\":\"alignCenter\",\"filename\":\"image-removebg-preview - 2022-07-03T015343.819.png\"</p>,\"alt\":\"OZLANA 블루 트위드 숏탑 스커트 슬림 하이웨이스트 A라인 숏스커트 스위트 리틀 프레그랑스 슈트\"}_##]</p><br><br><!--디스플레이--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><!-- 디스플레이2 --><ins class=\"adsbygoogle\"     style=\"display:block\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"7793089910\"     data-ad-format=\"auto\"     data-full-width-responsive=\"true\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><p>▼ </p><br><p>▼ </p><br><p>▼ </p><br><br><!--멀티광고--><div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"     style=\"display:block\"     data-ad-format=\"autorelaxed\"     data-ad-client=\"ca-pub-9397688686686823\"     data-ad-slot=\"4040805877\"></ins><script>     (adsbygoogle = window.adsbygoogle || []).push({});</script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><br><p>본 글을 통해 구매가 발생할 시 구매자에게는 아무 부담되지 않는 일정액의 수수료를 받을 수 있음을 알려드립니다.</p><br><br>"  ,"visibility":"0"  ,"category":""  ,"published":""  ,"slogan":""  ,"tag":"전참시, 양세형조끼, 송은이조끼, 송가인핑크캐미솔, 이영자티셔츠, 전현무티셔츠, 카리나트위드자켓, 전참시206회"  ,"acceptComment":"1"  ,"password":""}
{"tistory":{"status":"200","postId":"242","url":"https:\/\/anpd-info.tistory.com\/242"}}	
	 * @param jsonString
	 * @return
	 * @throws org.json.JSONException
	 */
	@SuppressWarnings("null")
	public static String getTistoryResponse(String jsonString) throws org.json.JSONException {
		
		String url = "";
		JSONObject jObject;

		try {
			jObject = new JSONObject(jsonString);

			JSONObject post1Object = jObject.getJSONObject("tistory");
			url = (String) post1Object.get("url");

			
		} catch (JSONException e) {
			e.printStackTrace();
		}


		return url;
	}

	/**
	 * 
	 * 네이버 단축링크 반환
	 * {"result":{"url":"https://me2.do/F4rZxiGO","hash":"F4rZxiGO","orgUrl":"https://anpd-info.tistory.com/entry/전참시-양세형-옷-조끼-베스트-송은이-송가인-핑크캐미솔-이영자-티셔츠-전현무-카리나-트위드자켓-패션-206회"},"message":"ok","code":"200"}
	 * @param jsonString
	 * @return
	 * @throws org.json.JSONException
	 */
	@SuppressWarnings("null")
	public static String getNaverShortUrl(String jsonString) throws org.json.JSONException {
		
		String shortUrl = "";
		JSONObject jObject;

		try {
			jObject = new JSONObject(jsonString);

			JSONObject post1Object = jObject.getJSONObject("result");
			shortUrl = (String) post1Object.get("url");

			
		} catch (JSONException e) {
			e.printStackTrace();
		}


		return shortUrl;
	}

	

}
