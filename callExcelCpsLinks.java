import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Properties;

import org.json.JSONException;

import com.contents.zorye.makeNaverBlogHtml;
import com.contents.zorye.makeTistoryHtml;
import com.contents.zorye.makeTwitterText;
import com.excel.zorye.ExcelRead;
import com.http.zorye.GetCPSLink;
import com.http.zorye.getNaverShortLink;
import com.post.zorye.Post_JSON_tistory;
import com.print.zorye.PrintObjects;


/**
 * 티스토리에 자동으로 올리는 코드 
 * @author zorye
 *
 */
public class callExcelCpsLinks {
	
	

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
	
	public void getProperties() {
		
	
    Properties properties = new Properties();
    String resource = "config/CPS.properties";
    
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
		
		naverClientId = properties.getProperty("naverClientId");//"vF2Qfm50mo_v8dZ8P0uX";
		naverClientSecret = properties.getProperty("naverClientSecret");//"Mb9NsLHYWY"; //애플리케이션 클라이언트 시크릿값"
		tistoryAddress = properties.getProperty("tistoryAddress");
		
    } catch (IOException e) {
        e.printStackTrace();
    }
	   
    
}
    
    
	

	private String getProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}




	public static void main(String[] args) throws IOException, JSONException {
		
		
		// 프로퍼티 로드
		callExcelCpsLinks callExcelCpsLinks = new callExcelCpsLinks();
		callExcelCpsLinks.getProperties();
		
		ExcelRead excel = new ExcelRead();
		String[][] excelData = null;
		String[][] adsenseData = null;

		// 엑셀 데이터 읽어와 배열에 저장
		//excelData = excel.read("C:\\Users\\zorye\\OneDrive\\문서", "디지털노가다실적_220619.xlsx", "업로드");
		excelData = excel.read(path, fileName, sheetName_content);
		adsenseData = excel.read(path, fileName, sheetName_adsense);
		// PrintObjects.printArrangement(adsenseData); // 엑셀 데이터 출력

		// 쿠팡 검색링크 list에 저장
		List<String> orgLinks = excel.putOrgLinksToList(excelData, idxOrgLink);
		// PrintObjects.printList(orgLinks); // 쿠팡 검색링크 List 출력

		// 쿠팡수익링크 생성해오기
		String CPSLinks[][] = GetCPSLink.getCPSLinksByList(orgLinks);
		// PrintObjects.printArrangement(CPSLinks);
		
		// 쿠팡수익링크 엑셀 데이터에 추가. (link가 시작되는 열부터, 채널 아이디 갯수만큼 돌리며 링크 넣기)
		for (int i = 0; i < excelData.length - 1; i++) {

			for (int j = 0; j < CHANNEL_ID_NUM; j++) {
							excelData[i + 1][idxFirstCPSLink + j] = CPSLinks[j][i]; // 2번째 줄부터, 11열부터 링크 채우기
				
			}
		}
		// PrintObjects.printArrangement(excelData);
		
	
		
		
				
		/* 티스토리 HTML 작성 및 게시 */
		System.out.println();
		System.out.println("------------- Tistory Html ----------------");
		String tis_item[] = makeTistoryHtml.makeTistoryHtml(excelData, adsenseData);
		PrintObjects.printArrangement(tis_item);
		
		/* 티스토리 게시 (비공개) : postUrl 리턴 */
		String tisUrl = Post_JSON_tistory.Post_JSON(tis_item);
		
				
		/* 트위터 문구 작성 */
		System.out.println();
		System.out.println("------------- Twitter Text ----------------");
		String twitter_Text[] = makeTwitterText.makeTwitterText(excelData);
		PrintObjects.printArrangement(twitter_Text);		
		
		
		
		
		/* 티스토리 단축 url 생성 */
		System.out.println();
		System.out.println("------------- Tistory Short Link ----------------");
		//String tisUrl = URLEncoder.encode(tistoryAddress + tis_item[0].replace(" ", "-"),"UTF-8");
		System.out.println(tis_item[0]);
		String tisShortUrl = getNaverShortLink.getNaverShortLink(tisUrl, naverClientId, naverClientSecret);		
		System.out.println(tisShortUrl);
		
		/* 네이버 HTML 작성 */
		String naver_item[] = makeNaverBlogHtml.makeNaverBlogHtml(excelData);
		System.out.println();
		System.out.println("------------- Naver Html ----------------");
		PrintObjects.printArrangement(naver_item);
		
		
	}

}
