import java.io.IOException;

import org.json.JSONException;

import com.http.zorye.GetCPSLink;

/*****************************************************************************
 * 파일 읽어 쿠팡 링크 생성
 * 
 * @author zorye
 *
 ****************************************************************************/
public class callFileCpsLinks {

	public static void main(String[] args) throws IOException, JSONException {

		GetCPSLink.getCPSLinksByFile();
	}

}
