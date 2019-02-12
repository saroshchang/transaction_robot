import java.net.*;
import java.io.*;

public class ReadWebPageTest {

	public static void main(String[] arg) throws Exception {
		// String web1 = "https://www.mobile01.com/topicdetail.php?f=651&t=4237447"
		// ;//UTF-8
		// String web2 = "https://www.mobile01.com/topicdetail.php?f=651&t=4237447";
		// //Big5
		// String web3 = "https://www.mobile01.com/topicdetail.php?f=651&t=4237447";
		//
		// read1(web1);
		// read2(web1);
		// read3(web1);

	}

	// 以這個方法取出來的檔案內容格式，最合適，不會亂掉，也不用管網頁編碼
	public static void read1(String strURL) {
		int chunksize = 4096;
		byte[] chunk = new byte[chunksize];
		int count;
		try {
			URL pageUrl = new URL(strURL);

			// 讀入網頁(位元串流)
			BufferedInputStream bis = new BufferedInputStream(pageUrl.openStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("URL1.txt", false));
			System.out.println("read1() running ");
			while ((count = bis.read(chunk, 0, chunksize)) != -1) {
				bos.write(chunk, 0, count); // 寫入檔案
			}
			bos.close();
			bis.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *******************************************************************************************
	/// 以這個方法取出來的檔案內容格式，變成一行，不易閱讀，需注意網頁編碼
	public static void read2(String strURL) {
		System.out.println("read2() running");

		try {
			URL url_address = new URL(strURL);

			// 讀入網頁(字元串流)
			BufferedReader br = new BufferedReader(new InputStreamReader(url_address.openStream(), "UTF-8"));
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(url_address.openStream(), "Big5"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("URL2.txt", false));
			String oneLine = null;

			while ((oneLine = br.readLine()) != null) {
				bw.write(oneLine);
			}
			bw.close();
			br.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}

	// *******************************************************************************************
	// 以這個方法取出來的檔案內容格式，變成一行，不易閱讀，需注意網頁編碼
	public static void read3(String strURL) {
		System.out.println("read3() running");
		try {
			String line = null;
			// 另一種連接網頁的方式
			URL url = new URL(strURL);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.connect();
			InputStream is = uc.getInputStream();

			/// 讀入網頁(字元串流)
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(url_address.openStream(), "Big5"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("URL3.txt", false));

			while ((line = br.readLine()) != null) {
				bw.write(line);
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			System.out.println("發生了" + e + "例外");
		}
		System.out.println("Done");
	}

	/*
	 * 以下這是前輩的說明，由於還沒有機會用，所以先放在這裡留念一下
	 * 
	 * 若是讀取靜態的檔案, 且要知道該檔案之內定字元編碼, 唯一的方法就是 以 ByteArrayInputStream 去讀該檔案,
	 * 並且辨別該檔案檔頭之位元組為何 辨別檔案的方法, 先讀完全部檔案, 再區別 utf-8 前三bytes 分別為 -17,-65,-69 ---->
	 * offset=3 utf-16le 前二bytes 分別為 -1,-2 ----> offset=2 utf-16be 前二bytes 分別為 -2,-1
	 * ----> offset=2 MS950, BIG5, .... 無 ----> offset=0; 讀完後再呼叫 new
	 * String(全部bytes,offset,全部bytes長度,"編碼方式") 轉成字串
	 */
}