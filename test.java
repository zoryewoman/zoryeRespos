import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;

import com.http.zorye.getNaverShortLink;


public class test {
	
	// 대용량은 등록이 안
	 public static void main(String[] args) throws IOException, JSONException {
		 
		 String clientId = "vF2Qfm50mo_v8dZ8P0uX";
	     String clientSecret = "Mb9NsLHYWY"; //애플리케이션 클라이언트 시크릿값"
	     String originUrl = "https://anpd-info.tistory.com/244";//"https://anpd-info.tistory.com/entry/%EC%A0%84%EC%B0%B8%EC%8B%9C-%EC%96%91%EC%84%B8%ED%98%95-%EC%98%B7-%EC%A1%B0%EB%81%BC-%EB%B2%A0%EC%8A%A4%ED%8A%B8-%EC%86%A1%EC%9D%80%EC%9D%B4-%EC%86%A1%EA%B0%80%EC%9D%B8-%ED%95%91%ED%81%AC%EC%BA%90%EB%AF%B8%EC%86%94-%EC%9D%B4%EC%98%81%EC%9E%90-%ED%8B%B0%EC%85%94%EC%B8%A0-%EC%A0%84%ED%98%84%EB%AC%B4-%EC%B9%B4%EB%A6%AC%EB%82%98-%ED%8A%B8%EC%9C%84%EB%93%9C%EC%9E%90%EC%BC%93-%ED%8C%A8%EC%85%98-206%ED%9A%8C";
	     
		 getNaverShortLink.getNaverShortLink(originUrl,clientId,clientSecret);
		 
	 }

	 
	 
    /**
     * @param pURL : 요청 URL 
     * @param pList : 파라미터 객체 (HashMap<String,String>)
     *
     * Created by 닢향
     * http://niphyang.tistory.com
     */
    public static String postRequest(String pURL, HashMap < String, String > pList) {

        String myResult = "";

        try {
            //   URL 설정하고 접속하기 
            URL url = new URL(pURL); // URL 설정 

            HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속 
            //-------------------------- 
            //   전송 모드 설정 - 기본적인 설정 
            //-------------------------- 
            http.setDefaultUseCaches(false);
            http.setDoInput(true); // 서버에서 읽기 모드 지정 
            http.setDoOutput(true); // 서버로 쓰기 모드 지정  
            http.setRequestMethod("POST"); // 전송 방식은 POST



            //--------------------------
            // 헤더 세팅
            //--------------------------
            // 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다 
            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");


            //-------------------------- 
            //   서버로 값 전송 
            //-------------------------- 
            StringBuffer buffer = new StringBuffer();

            //HashMap으로 전달받은 파라미터가 null이 아닌경우 버퍼에 넣어준다
            if (pList != null) {

                Set key = pList.keySet();

                for (Iterator iterator = key.iterator(); iterator.hasNext();) {
                    String keyName = (String) iterator.next();
                    String valueName = pList.get(keyName);
                    buffer.append(keyName).append("=").append(valueName).append("&");
                }
            }

            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
           System.out.println(buffer.toString());
            writer.flush();


            //--------------------------
            //   Response Code
            //--------------------------
            //http.getResponseCode();


            //-------------------------- 
            //   서버에서 전송받기 
            //-------------------------- 
            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str + "\n");
            }
            myResult = builder.toString();
            return myResult;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myResult;
    }

}