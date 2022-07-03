package com.http.zorye;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import org.apache.commons.codec.Resources;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import com.parse.zorye.jsonParsing1;

public class GetCPSLink {


    /* 누구 아이디로 생성할지 여기에서 결정한다. AN, ZO **/
	static String ID_OWNER = "";
	static String CHANNEL_ID ="";
	static int CHANNEL_ID_NUM;
	
	
	/*************************************/
	//private final static String EXCEL_FILE_NAME = "/Users/zorye/Downloads/item.json";
	static String EXCEL_FILE_NAME = "";
	static String REQUEST_METHOD = "";
	static String DOMAIN = "";
	static String URL = "";
	// Replace with your own ACCESS_KEY and SECRET_KEY
	static String ACCESS_KEY_AN = "";
	static String SECRET_KEY_AN ="";

	static String ACCESS_KEY_ZO = "";
	static String SECRET_KEY_ZO = "";

	/* 설정 정보 */
	//final static String path = "/Users/zorye/Library/CloudStorage/OneDrive-개인/[조례]/쿠파스api";
	static String path = "";//"C:\\Users\\zorye\\OneDrive\\[조례]\\쿠파스api";
    static String fileName = ""; //"CPS.xlsx";
    static String sheetName_content = ""; //"Sheet1";
    static String sheetName_adsense = ""; //"애센코드";
	static int idxOrgLink = 5; // F 열에 쿠팡검색링크 존재.
	static int idxFirstCPSLink = 12; // M 열부터 cps 링크 시작.
	static String naverClientId = "";
	static String naverClientSecret = ""; //애플리케이션 클라이언트 시크릿값"
	static String tistoryAddress = "";

	/* 사용할 키 */
	private static String SECRET_KEY = "";
	private static String ACCESS_KEY = "";

	
	
	public void getProperties() {
		
		
	    Properties properties = new Properties();
	    String resource = "config/cps.properties";
	    
	    
	    try {
	    	
	    
			InputStream reader = this.getClass().getClassLoader().getResourceAsStream(resource);

	        properties.load(reader);

	        /* 누구 아이디로 생성할지 여기에서 결정한다. AN, ZO **/
			ID_OWNER = properties.getProperty("ID_OWNER");
			CHANNEL_ID = properties.getProperty("CHANNEL_ID");
			CHANNEL_ID_NUM = Integer.parseInt(properties.getProperty("CHANNEL_ID_NUM"));
			
			
			/*************************************/
			//private final static String EXCEL_FILE_NAME = "/Users/zorye/Downloads/item.json";
			EXCEL_FILE_NAME = properties.getProperty("EXCEL_FILE_NAME");
			REQUEST_METHOD = properties.getProperty("REQUEST_METHOD");
			DOMAIN = properties.getProperty("DOMAIN");
			URL = properties.getProperty("URL");
			// Replace with your own ACCESS_KEY and SECRET_KEY
			ACCESS_KEY_AN = properties.getProperty("ACCESS_KEY_AN");
			SECRET_KEY_AN = properties.getProperty("SECRET_KEY_AN");

			ACCESS_KEY_ZO = properties.getProperty("ACCESS_KEY_ZO");
			SECRET_KEY_ZO = properties.getProperty("SECRET_KEY_ZO");
		
			/* 설정 정보 */
			//final static String path = "/Users/zorye/Library/CloudStorage/OneDrive-개인/[조례]/쿠파스api";
		    path = properties.getProperty("path"); //"C:\\Users\\zorye\\OneDrive\\[조례]\\쿠파스api";
		    fileName = properties.getProperty("fileName"); //"CPS.xlsx";
		    sheetName_content = properties.getProperty("sheetName_content");//"Sheet1";
			sheetName_adsense = properties.getProperty("sheetName_adsense"); //"애센코드";
			idxOrgLink = 5; // F 열에 쿠팡검색링크 존재.
			idxFirstCPSLink = 12; // M 열부터 cps 링크 시작.
			
			naverClientId = properties.getProperty("clientId");//"vF2Qfm50mo_v8dZ8P0uX";
			naverClientSecret = properties.getProperty("clientSecret");//"Mb9NsLHYWY"; //애플리케이션 클라이언트 시크릿값"
			tistoryAddress = properties.getProperty("tistory_URL");
			
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		   
	    
	}


	/***************************************************************************
	 * 링크 소유주 정하기
	 **************************************************************************/
	public static void setWhosId() {
		if (ID_OWNER.equals("AN")) {
			SECRET_KEY = SECRET_KEY_AN;
			ACCESS_KEY = ACCESS_KEY_AN;
		} else {
			SECRET_KEY = SECRET_KEY_ZO;
			ACCESS_KEY = ACCESS_KEY_ZO;
		}
	}

	/*****************************************************************************
	 * 파일에 링크 있는 경우 호출
	 * 
	 * @throws IOException
	 * @throws JSONException
	 ****************************************************************************/
	public static void getCPSLinksByFile() throws IOException, JSONException {

		setWhosId(); // 링크 소유주 정하기

		String[][] cpsLinks = null;
		String REQUEST_JSON = "";
		try {

			File file = new File(EXCEL_FILE_NAME); // 파일명 상단에 있음

			FileReader filereader = new FileReader(file);

			BufferedReader bufReader = new BufferedReader(filereader);
			int lineNum = 1;
			String line = "";

			while ((line = bufReader.readLine()) != null) {

				if ((lineNum % 20 == 0)) {

					REQUEST_JSON += "\"" + line + "\"]}";
					// System.out.println(REQUEST_JSON);
					getCPSLinkByChlId(REQUEST_JSON, SECRET_KEY, ACCESS_KEY);

					REQUEST_JSON = "";
				}

				else {
					// System.out.println(line);
					REQUEST_JSON += "\"" + line + "\",";

				}
				lineNum++;
			}

			REQUEST_JSON += "\"\"]}";
			// System.out.println(REQUEST_JSON);

			cpsLinks = getCPSLinkByChlId(REQUEST_JSON, SECRET_KEY, ACCESS_KEY);

			bufReader.close();
			// System.out.println(REQUEST_JSON);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}

	}

	/****************************************************************************
	 * 리스트 20개 단위로 cps링크 만들기! 20개씩 만들게는 되어있으나 보통 10개 미만 단위로 되므로 응답은 마지막에 돌은 것만 리턴을
	 * ex) 30개 -> 마지막 10개만 리턴
	 * 
	 * @param cpsOrgLinks
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 ***************************************************************************/
	public static String[][] getCPSLinksByList(List<String> cpsOrgLinks) throws IOException, JSONException {
		
		
		GetCPSLink getCPSLink = new GetCPSLink();
		getCPSLink.getProperties();
		
		
		setWhosId(); // 링크 소유주 정하기

		String[][] cpsLinks = null;
		String REQUEST_JSON = "";
		// int lineNum = 1;
		String line = "";

		// System.out.println(cpsOrgLinks.size() + " cpsOrgLinks.size()");
		for (int lineNum = 0; lineNum < cpsOrgLinks.size(); lineNum++) {
			line = cpsOrgLinks.get(lineNum).toString();

			// 20개 되면 일단 호출
			if (((lineNum + 1) % 20 == 0)) {
				if (lineNum != 0 && line != "" && line != null)
					REQUEST_JSON += "\"" + line + "\"]}";

				// System.out.println(REQUEST_JSON);
				getCPSLinkByChlId(REQUEST_JSON, SECRET_KEY, ACCESS_KEY);

				REQUEST_JSON = "";
			}

			else {
				// System.out.println(cpsOrgLinks.get(lineNum - 1).toString());
				REQUEST_JSON += "\"" + line + "\",";

			}

		}

		REQUEST_JSON += "\"\"]}";
		// System.out.println(REQUEST_JSON);

		cpsLinks = getCPSLinkByChlId(REQUEST_JSON, SECRET_KEY, ACCESS_KEY);

		return cpsLinks;
	}

	/*****************************************************************************
	 * goodGoodsArchive , tistorySw , twitter1 채널 아이디 리스트에 있는 만큼 호출한다.
	 * 
	 * @throws JSONException
	 *****************************************************************************/
	public static String[][] getCPSLinkByChlId(String REQUEST_JSON, String SECRET_KEY, String ACCESS_KEY)
			throws JSONException {

		// 채널 아이디를 , 를 기준으로 나눔
		String[][] cpsLinks = null;
		String[] chlIds = CHANNEL_ID.split(",");
		int numChlId = chlIds.length;
		cpsLinks = new String[numChlId][];

		// 채널 아이디 별로 링크 가져와서 배열에 담기
		for (int i = 0; i < numChlId; i++) {
			System.out.println();
			System.out.println(chlIds[i]); // 채널명 출력
			cpsLinks[i] = getCPSLinks(chlIds[i], REQUEST_JSON, SECRET_KEY, ACCESS_KEY);
		}

		return cpsLinks;
	}

	/*****************************************************************************
	 * 실제 호출 메소드(전문에 따라 최대 20개까지 쇼트 링크 가져옴)
	 * 
	 * @param ChannelId
	 * @param reqJson
	 * @param secretKey
	 * @param accessKey
	 * @return
	 ****************************************************************************/
	private static String[] getCPSLinks(String ChannelId, String reqJson, String secretKey, String accessKey) {
		String shortUrl[] = null;

		// Generate HMAC string
		String authorization = HmacGenerator.generate(REQUEST_METHOD, URL, secretKey, accessKey);

		String RequestJson_Header = "{\"subId\" : \"" + ChannelId + "\",  \"coupangUrls\": [";
		String RequestJson = RequestJson_Header + reqJson;

		StringEntity entity = new StringEntity(RequestJson, "UTF-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");

		org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
		org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder.post(URL).setEntity(entity)
				.addHeader("Authorization", authorization).build();

		org.apache.http.HttpResponse httpResponse;
		try {
			httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);
			String responseUrl = EntityUtils.toString(httpResponse.getEntity());

			// System.out.println("responseUrl : " + responseUrl );
			jsonParsing1 jp = new jsonParsing1();

			shortUrl = jp.getShortUrl(responseUrl);

			// System.out.println(shortUrl); // url 출력
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shortUrl;
	}
}