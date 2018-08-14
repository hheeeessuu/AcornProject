import java.util.ArrayList;

import com.common.DataParsing;
import com.common.Util;
import com.dto.BithumbDTO;
import com.dto.UpbitDTO;
import com.service.MyBatisService;

public class CryptocurrencyMain {

	public static void main(String[] args) {
		DataParsing dataParsing = new DataParsing();
		MyBatisService service = new MyBatisService();
		BithumbDTO tempBithumbDTO = null;
		UpbitDTO tempUpbitDTO = null;
		
		while(true) {
			ArrayList<BithumbDTO> listBithumbDTO = new ArrayList<>();
			ArrayList<UpbitDTO> listUpbitDTO = new ArrayList<>();

			for(int i = 0; i < Util.CURRENCY.length; ++i) {
				System.out.println(Util.CURRENCY[i]);
				// BithumbDTO를 얻는다.
				tempBithumbDTO = dataParsing.parseBithumbData(dataParsing.connectURL(Util.BITHUMB_TICKER, Util.CURRENCY[i]), Util.CURRENCY[i]);
				if(tempBithumbDTO != null) {
//					System.out.println(tempBithumbDTO);
					listBithumbDTO.add(tempBithumbDTO);
				
				}
				
				// UpbitDTO를 얻는다.
				tempUpbitDTO = dataParsing.parseUpbitData(dataParsing.connectURL(Util.UPBIT_TICKER, "KRW-" + Util.CURRENCY[i]));
				if(tempUpbitDTO != null) {
//					System.out.println(tempUpbitDTO);
					listUpbitDTO.add(tempUpbitDTO);
				}
			}
			
			service.bithumbInsert(listBithumbDTO);
			service.upbitInsert(listUpbitDTO);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
