package com.post.zorye;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.parse.zorye.jsonParsing1;

public class Post_JSON_tistory {

	public static void main(String[] args) {
		// Post_JSON_tistory.Post_JSON();
	}

	public static String Post_JSON(String[] tis_item) {
		String tisUrl = "";
		String title = tis_item[0];
		String html_tis = tis_item[1].replace("\"", "\\\"");
		String tag = tis_item[2];

		String query_url = "https://www.tistory.com/apis/post/write";
		String sample_content = "<p>[##_Image|kage@bROSBm/btrBCr3m76U/KAyztpmnR6y3gKxacOJ1K1/img.png|CDM|1.3|"
				+ "{\\\"originWidth\\\":457,\\\"originHeight\\\":546,"
				+ "\\\"style\\\":\\\"alignCenter\\\",\\\"filename\\\":"
				+ "\\\"batch_image-removebg-preview(60).png\\\"}_##]";

		String json = "  {\"access_token\":\"69bbaf0ef4799ac01ad447be2be2a09c_d598760d80a49b4fa883465b0dff07bd\""
				+ "  ,\"output\":\"json\"" + "  ,\"blogName\":\"anpd-info\"" + "  ,\"title\":\"" + title + "\""
				+ "  ,\"content\":\"" + html_tis + "\"" + "  ,\"visibility\":\"0\"" + "  ,\"category\":\"\""
				+ "  ,\"published\":\"\"" + "  ,\"slogan\":\"\"" + "  ,\"tag\":\"" + tag + "\""
				+ "  ,\"acceptComment\":\"1\"" + "  ,\"password\":\"\"}";
		System.out.println(json);

		try {

			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();

			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");

			System.out.println(result);
			tisUrl = jsonParsing1.getTistoryResponse(result);

			in.close();
			conn.disconnect();

		} catch (Exception e) {
			System.out.print(e);

		}
		return tisUrl;
	}


}
