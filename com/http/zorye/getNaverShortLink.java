package com.http.zorye;

// 네이버 검색 API 예제 - 단축 URL - GET

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import com.parse.zorye.jsonParsing1;

public class getNaverShortLink {

    public static String getNaverShortLink(String url, String naverClientId, String naverSecretKey) throws JSONException{
        

        //String originalURL = "https://anpd-info.tistory.com/entry/전참시-양세형-옷-조끼-베스트-송은이-송가인-핑크캐미솔-이영자-티셔츠-전현무-카리나-트위드자켓-패션-206회";
        //String originalURL ="https://anpd-info.tistory.com/entry/%EC%A0%84%EC%B0%B8%EC%8B%9C-%EC%96%91%EC%84%B8%ED%98%95-%EC%98%B7-%EC%A1%B0%EB%81%BC-%EB%B2%A0%EC%8A%A4%ED%8A%B8-%EC%86%A1%EC%9D%80%EC%9D%B4-%EC%86%A1%EA%B0%80%EC%9D%B8-%ED%95%91%ED%81%AC%EC%BA%90%EB%AF%B8%EC%86%94-%EC%9D%B4%EC%98%81%EC%9E%90-%ED%8B%B0%EC%85%94%EC%B8%A0-%EC%A0%84%ED%98%84%EB%AC%B4-%EC%B9%B4%EB%A6%AC%EB%82%98-%ED%8A%B8%EC%9C%84%EB%93%9C%EC%9E%90%EC%BC%93-%ED%8C%A8%EC%85%98-206%ED%9A%8C";
        String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + url;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", naverClientId);
        requestHeaders.put("X-Naver-Client-Secret", naverSecretKey);
        String responseBody = get(apiURL,requestHeaders);

        //System.out.println(responseBody);
        String shortUrl = jsonParsing1.getNaverShortUrl(responseBody);
        
        return shortUrl;
        
    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}