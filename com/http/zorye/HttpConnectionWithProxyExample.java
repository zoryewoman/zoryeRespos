package com.http.zorye;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpConnectionWithProxyExample {

	private final String PROXY_IP = "192.168.0.1";
	private final int PROXY_PORT = 8888;

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpConnectionWithProxyExample http = new HttpConnectionWithProxyExample();

		//System.out.println("GET으로 데이터 가져오기");
		//http.sendGet("http://www.naver.com");

		System.out.println("POST로 데이터 가져오기");
		String urlParameters = "access_token=69bbaf0ef4799ac01ad447be2be2a09c_d598760d80a49b4fa883465b0dff07bd\n"
				+ "  &output=xml\n"
				+ "  &blogName=anpd-info\n"
				+ "  &title=api대용량테스트\n"
				+ "  &content=<!--티스용--><p></p>2022년 5월 2일 방영된 동상이몽 244회에서 이현이와 김숙, 이지혜의 패션 정보입니다. 이현이는 스튜디오에 핑크색 스트라이프 무늬가 들어간 긴 롱 드레스를 입었어요. 허리를 큰 리본으로 여밈할 수 있게 되어 있네요. 김숙은 자주 입는 스타일인 빅 카라 블라우스를 입었고요, 이지혜는 지난 주에도 보였던 러플 블라우스를 입고 출연했어요. 이지혜는 방송에서 손목 마사지기도 사용했는데요, 출산 후에 손목이 아픈 분들에게 좋아 보여요. 손목 뿐 아니라 목이나 팔, 무릎 등 마사지가 필요한 곳에 붙여 놓으면 효과가 좋다고 하네요. 김혜수가 광고하는 제품이에요.<p></p><p></p><p></p><p>[##_Image|kage@lGMk0/btrA5beJjCL/kxWsABQBSkgeGYHlYiniF0/img.png|CDM|1.3|{\"originWidth\":1098,\"originHeight\":1104,\"style\":\"alignCenter\",\"filename\":\"image.png\"}_##]<p></p><p></p><p></p>	<!--애센--><p></p><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">김숙 블라우스</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 </p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"김숙 블라우스\" href=\"https://link.coupang.com/a/mGows\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 김숙 블라우스 브랜드 보러가기</b></span></u></span></a></p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p>[##_Image|kage@b3KlD3/btrA5smYgRo/QdGfcaKA7todYmXayKNom1/img.png|CDM|1.3|{\"originWidth\":456,\"originHeight\":510,\"style\":\"alignCenter\",\"filename\":\"batch_image-removebg-preview (2).png\",\"alt\":\"TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 \"}_##]</p><p data-ke-size=\"size16\">&nbsp;</p><p data-ke-size=\"size16\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p>	<div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"      style=\"display:block; text-align:center;\"      data-ad-layout=\"in-article\"      data-ad-format=\"fluid\"      data-ad-client=\"ca-pub-9397688686686823\"      data-ad-slot=\"2760255084\"></ins> <script>      (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><p>본 글을 통해 구매가 발생할 시 구매자에게는 아무 부담되지 않는 일정액의 수수료를 받을 수 있음을 알려드립니다.</p><!--티스용--><p></p>2022년 5월 2일 방영된 동상이몽 244회에서 이현이와 김숙, 이지혜의 패션 정보입니다. 이현이는 스튜디오에 핑크색 스트라이프 무늬가 들어간 긴 롱 드레스를 입었어요. 허리를 큰 리본으로 여밈할 수 있게 되어 있네요. 김숙은 자주 입는 스타일인 빅 카라 블라우스를 입었고요, 이지혜는 지난 주에도 보였던 러플 블라우스를 입고 출연했어요. 이지혜는 방송에서 손목 마사지기도 사용했는데요, 출산 후에 손목이 아픈 분들에게 좋아 보여요. 손목 뿐 아니라 목이나 팔, 무릎 등 마사지가 필요한 곳에 붙여 놓으면 효과가 좋다고 하네요. 김혜수가 광고하는 제품이에요.<p></p><p></p><p></p><p>[##_Image|kage@lGMk0/btrA5beJjCL/kxWsABQBSkgeGYHlYiniF0/img.png|CDM|1.3|{\"originWidth\":1098,\"originHeight\":1104,\"style\":\"alignCenter\",\"filename\":\"image.png\"}_##]<p></p><p></p><p></p>	<!--애센--><p></p><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">김숙 블라우스</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 </p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"김숙 블라우스\" href=\"https://link.coupang.com/a/mGows\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 김숙 블라우스 브랜드 보러가기</b></span></u></span></a></p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p>[##_Image|kage@b3KlD3/btrA5smYgRo/QdGfcaKA7todYmXayKNom1/img.png|CDM|1.3|{\"originWidth\":456,\"originHeight\":510,\"style\":\"alignCenter\",\"filename\":\"batch_image-removebg-preview (2).png\",\"alt\":\"TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 \"}_##]</p><p data-ke-size=\"size16\">&nbsp;</p><p data-ke-size=\"size16\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p>	<div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"      style=\"display:block; text-align:center;\"      data-ad-layout=\"in-article\"      data-ad-format=\"fluid\"      data-ad-client=\"ca-pub-9397688686686823\"      data-ad-slot=\"2760255084\"></ins> <script>      (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><p>본 글을 통해 구매가 발생할 시 구매자에게는 아무 부담되지 않는 일정액의 수수료를 받을 수 있음을 알려드립니다.</p><!--티스용--><p></p>2022년 5월 2일 방영된 동상이몽 244회에서 이현이와 김숙, 이지혜의 패션 정보입니다. 이현이는 스튜디오에 핑크색 스트라이프 무늬가 들어간 긴 롱 드레스를 입었어요. 허리를 큰 리본으로 여밈할 수 있게 되어 있네요. 김숙은 자주 입는 스타일인 빅 카라 블라우스를 입었고요, 이지혜는 지난 주에도 보였던 러플 블라우스를 입고 출연했어요. 이지혜는 방송에서 손목 마사지기도 사용했는데요, 출산 후에 손목이 아픈 분들에게 좋아 보여요. 손목 뿐 아니라 목이나 팔, 무릎 등 마사지가 필요한 곳에 붙여 놓으면 효과가 좋다고 하네요. 김혜수가 광고하는 제품이에요.<p></p><p></p><p></p><p>[##_Image|kage@lGMk0/btrA5beJjCL/kxWsABQBSkgeGYHlYiniF0/img.png|CDM|1.3|{\"originWidth\":1098,\"originHeight\":1104,\"style\":\"alignCenter\",\"filename\":\"image.png\"}_##]<p></p><p></p><p></p>	<!--애센--><p></p><br><br><br><h2 style=\"box-sizing: border-box; border-width: 4px; border-left-style: solid; border-left-color: #D5D5D5; padding: 1px 10px; letter-spacing: 1px; margin: 0px 0px; line-height: 1.2;\" data-ke-size=\"size26\"><b><span style=\"font-size: 18px; color: #ef5369;\"><b><span style=\"font-family: '이롭게바탕';\">김숙 블라우스</span></b><span style=\"font-size: 14px; font-weight: normal; color: #7e98b1;\"></span></span></b></h2><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 </p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: center;\" data-ke-size=\"size19\"><a title=\"김숙 블라우스\" href=\"https://link.coupang.com/a/mGows\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #006dd7;\"><u><span style=\"font-size: 19px; font-family: 이롭게바탕;\" class=\"half_background\"><span style=\"background-color: #f6e199;\"><b>▶ 김숙 블라우스 브랜드 보러가기</b></span></u></span></a></p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p>[##_Image|kage@b3KlD3/btrA5smYgRo/QdGfcaKA7todYmXayKNom1/img.png|CDM|1.3|{\"originWidth\":456,\"originHeight\":510,\"style\":\"alignCenter\",\"filename\":\"batch_image-removebg-preview (2).png\",\"alt\":\"TOMOTOMS 토모톰스 DB_ TI체크룸 블라우스 DTBBS3BLI057 \"}_##]</p><p data-ke-size=\"size16\">&nbsp;</p><p data-ke-size=\"size16\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size17\">&nbsp;</p>	<div><script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-9397688686686823\"     crossorigin=\"anonymous\"></script><ins class=\"adsbygoogle\"      style=\"display:block; text-align:center;\"      data-ad-layout=\"in-article\"      data-ad-format=\"fluid\"      data-ad-client=\"ca-pub-9397688686686823\"      data-ad-slot=\"2760255084\"></ins> <script>      (adsbygoogle = window.adsbygoogle || []).push({}); </script></div><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><p style=\"text-align: justify;\" data-ke-size=\"size18\">&nbsp;</p><br><br><br><p>본 글을 통해 구매가 발생할 시 구매자에게는 아무 부담되지 않는 일정액의 수수료를 받을 수 있음을 알려드립니다.</p>\n"
				+ "  &visibility=0\n"
				+ "  &category=\n"
				+ "  &published=\n"
				+ "  &slogan=\n"
				+ "  &tag=동상이몽,443회\n"
				+ "  &acceptComment=1\n"
				+ "  &password=";
		http.sendPost("https://www.tistory.com/apis/post/write/", urlParameters);
	}

	/**
	 * HTTP 프록시 생성
	 * 
	 * @param ip
	 * @param port
	 * @return
	 */
	private Proxy initProxy(String ip, int port) {
	
		return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
	}

	// HTTP GET request
	public void sendGet(String targetUrl) throws Exception {

		Proxy proxy = initProxy(PROXY_IP, PROXY_PORT);
		URL url = new URL(targetUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection(proxy);

		con.setRequestMethod("GET"); // optional default is GET
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header

		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
	}

	// HTTP POST request
	public void sendPost(String targetUrl, String parameters) throws Exception {

		Proxy proxy = initProxy(PROXY_IP, PROXY_PORT);
		URL url = new URL(targetUrl);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection(proxy);

		con.setRequestMethod("POST"); // HTTP POST 메소드 설정
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setDoOutput(true); // POST 파라미터 전달을 위한 설정

		// Send post request
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(parameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("HTTP 응답 코드 : " + responseCode);
		System.out.println("HTTP body : " + response.toString());

	}
}