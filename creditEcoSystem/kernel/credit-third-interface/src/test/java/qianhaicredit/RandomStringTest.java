//package qianhaicredit;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.ArrayList;
//import java.util.List;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.lang.RandomStringUtils;
//
//import com.ctc.credit.constant.ConfigsContant;
//import com.ctc.credit.kernel.util.DataSecurityUtil;
//import com.ctc.credit.kernel.util.DateUtil;
//import com.ctc.credit.kernel.util.KeystoreUtil;
//import com.ctc.credit.qianhai.api.dto.BlkListRequestBusiData;
//import com.ctc.credit.qianhai.api.dto.BlkListRequestBusiDataRecord;
//import com.ctc.credit.qianhai.api.dto.BlkListRequestDto;
//import com.ctc.credit.qianhai.api.dto.BlkListRequestHead;
//import com.ctc.credit.qianhai.api.dto.BlkListRequestSecurityInfo;
//import com.ctc.credit.qianhai.api.service.impl.QianHaiCreditApiServiceImpl;
//
//public class RandomStringTest {
//	
//	public static void main(String[] args) {
//		List<String> strList = new ArrayList<>();
//		Boolean flag = false;
//		for (int i = 0; i < 1000000; i++) {
//			String string =RandomStringUtils.randomAlphanumeric(8);
//			for (String se : strList) {
//				if(se.equals(string)){
//					flag = true;
//					System.out.println("index :"+i+"出现重复。"+"str:"+se);
//					break;
//				}
//			}
//			strList.add(string);
//			if(flag)
//				break;
//		}
//		if(flag)
//			System.out.println("------------发现重复----------end---------");
//		else {
//			System.out.println("------------未发现重复！");
//		}
//	}
//	
//	public static void main1(String[] args) {
//		QianHaiCreditApiServiceImpl service = new QianHaiCreditApiServiceImpl();
//		BlkListRequestDto blkListRequestDto = new BlkListRequestDto();
//		BlkListRequestHead blkListRequestHead = new BlkListRequestHead();
//		blkListRequestHead.setTransNo("test00001");
//		blkListRequestHead.setTransDate(DateUtil.getNowTime());
//		blkListRequestHead.setAuthCode("P2P0013XX_1234561234567658");
//		blkListRequestHead.setAuthDate(DateUtil.getNowTime());
//		BlkListRequestBusiData blkListRequestBusiData = new BlkListRequestBusiData();
//		blkListRequestBusiData.setBatchNo("b1160.0");
//		List<BlkListRequestBusiDataRecord> resords = new ArrayList<BlkListRequestBusiDataRecord>();
//		BlkListRequestBusiDataRecord recored = new BlkListRequestBusiDataRecord();
//		recored.setReasonCode("04");
//		recored.setIdNo("210202195901160032");
//		recored.setIdType("0");
//		recored.setSeqNo("1");
//		recored.setName("褚宝刚");
//		resords.add(recored);
//		BlkListRequestBusiDataRecord recored1 = new BlkListRequestBusiDataRecord();
//		recored1.setReasonCode("04");
//		recored1.setIdNo("210202195903245427");
//		recored1.setIdType("0");
//		recored1.setSeqNo("2");
//		recored1.setName("丛爱民");
//		resords.add(recored1);
//		BlkListRequestBusiDataRecord recored2 = new BlkListRequestBusiDataRecord();
//		recored2.setReasonCode("04");
//		recored2.setIdNo("210202195903181718");
//		recored2.setIdType("0");
//		recored2.setSeqNo("3");
//		recored2.setName("孙德成");
//		resords.add(recored2);
//		BlkListRequestBusiDataRecord recored3 = new BlkListRequestBusiDataRecord();
//		recored3.setReasonCode("04");
//		recored3.setIdNo("210202195901160032");
//		recored3.setIdType("0");
//		recored3.setSeqNo("4");
//		recored3.setName("刘慧娟");
//		resords.add(recored3);
//		BlkListRequestSecurityInfo blkListRequestSecurityInfo = new BlkListRequestSecurityInfo();
//		blkListRequestSecurityInfo.setUserName("ctcfusopr");
//		try {
//			blkListRequestSecurityInfo.setUserPassword(DataSecurityUtil.encodePwd("weblogic1"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		blkListRequestBusiData.setRecords(resords);
//		blkListRequestDto.setHeader(blkListRequestHead);
//		String buString = JSONObject.fromObject(blkListRequestBusiData).toString();
//		try {
//			String busiData = DataSecurityUtil.encodeBase64(DataSecurityUtil.encryptMode(ConfigsContant.QIANHAI_3DES_KEY.getBytes("utf-8"), buString.getBytes()));
//			PrivateKey prikey = KeystoreUtil.getPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFG4eG8wdXdr98zWVPPR6qUTmPVfkncSn8V2Fvtw2/new/5uNf804M8hUQB2RJlPOQMQXoItLPYwpDV+Tx3/fjNDVxpxfwuqlv9Ih/xZGQ6fpZqueCfhj4OsZxAcP/j/VTP+M/8p/HVWUgqtlBrb8i6VdbzGCtbR5LpvCc8QFX/N89gnlMRo2r7+ZrORShbUv/5j/svsy34uVxPEzGeazgfnF6WJhJiyEiivy+Ev681CqUHrMBG5/gy72VpyBoh4xtW3JDDdsu5AhoelB9HloqeK6xFuo2TAMHmITXWM2Ik5XAGhFiJotMqUn45tW9GKpyO/jOEERpCVpCZEoaScdjAgMBAAECggEBALLPN5Jf1DAvRKV2O0q3+qKtjtcOOjniuiD2MClFWc6T+Cc8UNbRhOPPlPX2jq8F1jLflikxtiZ3BW90Q/h8oodV7InO+LPk0iMDJfUriNN6vycrGFxUAljmEPGhlWm48ef01DZF51bQjC4nb3HaqcOFBT/811Nc4xfkOPFW3U4wO8fl/zOFU68yGAGp+lZX8aKiJkRcSixwxn2yc6cFP9shD5x7BpB2WEttU5hDb+0eLGnr3lPVqOFgrG+NVYzaUDziH46e3/34p7J0fyb7k/Ck7QZVM93ujFHvDpbQDpPAQTITn/glrl58Xqf6SsN25HaCJb/ouxIslF0te35UfEkCgYEA44UPJ0u1PDO4wE+A0io0in+uYOK3REuz7S4kx9VSJUPbXIKSLYjfTNHFsKY/OxK7bHUH9xJrJrL/sNS5FDksSYk9jnKFOz8bIsZleNAIz8uzCbIHhe95cfUnaQ90olxgmWTp9QLtC0jhgdt8e1zeMq9nejwpEhcPvpmzV7s2CQ8CgYEA3cfmrPDp0SWET2PkMn96sDBFZ7p+Cccowsw21s3eKEgLEjAvKIrrt6XNJrGPuKf2/Hq56iHEKUhHyR1/5J8R5qGswRNUYNwgHE8riDZqAX0ADS1QOIckgd68FLuLHb5JczK/WxJNAgo8cQJHnSy6C0NUPczNP8kFuhXsq9vBVG0CgYBTZ97jP+zDkg5jaYHHCbPTJfVuDQ60GbBu/WB8ZWZExPhwlGk0Ch4aEjiPhpJdfIN6wfhWickAGdSEJadnk4H5vzbytmbDDmJLQEHIpTLlwj3zCvGZFu4FaaK17/WI46aB9S2TJSxy25fXu/eJXcUS/ZxIgi9oM04RSFUnjzjC3wKBgHnJ7bXosi3FEWxbaZQFh0U7rNFyiwYplQusAy1gbe/m6BV72lnEN/9okEkAVvFLY4lwh6m4EzWsWKdriLDuXXEuNWTtjXeHSibhnwE1CG96yk1yJcx1AipDOzuTZajWtxUIuCZ13U4SevCAFP2N8zh+J8OsNMYjSP7QTWBu1DLdAoGATNB5Tii6nbbX0Gx1sgeMaJruzW5DByY4WIoEe6JMxXV2chJ5JHmMBlmvE+7xipcXGcfGPii2Nvb+jaSHZx9zMG2Y4Rt2ZHOZyCwXWberqvvRd84Z5iWKyU3QWuE61WH73ugB28NemI4UDsNc7XTEPjBpz3NvOF8IYMneLzTe2GY=");
//			String signStr = DataSecurityUtil.signData(busiData, prikey);
//			blkListRequestSecurityInfo.setSignatureValue(signStr);
//			System.out.println("busiData:"+busiData);
//			blkListRequestDto.setBusiData(busiData);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		blkListRequestDto.setSecurityInfo(blkListRequestSecurityInfo);
//		try {
//			service.getQianhaiCreditData(blkListRequestDto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		verifySignature();
//	}
//	
//	public static void verifySignature() {
//		String data ="D/aeooDAENGtIhGldD6vXmdRXYe1R1/kKtArG7dWpnToIRI4vAPwzQVBUmA9g81AHIotS/nRnAkH\nrODs9tSTAF9GrAjMRu2xqKRwzcUOO4ifI1R7M954aHT2RDGwwD6rUH0+XEF1qN509kQxsMA+q8MY\nuj/UJ2Cl2XYBPM5yB1ImDQ5KkaTw7DPRne0/5kiffVTxQyzVuTJa9XpWKmnaXCe/NukbD5Tapynx\nkCOIsWdlM/XHkKllXDW1gGdaJPdZaUTrzgfDG9Y1zYczHtfVFFct0tNVxn5kVsdThWKK7KL6ascy\nGnGcSWTX+LG4yoN3nplCUCAYhqvkh5wWOTBGc1bHU4ViiuyijGys3C9+w2hk1/ixuMqDd56ZQlAg\nGIarKcHFcVEVAJhWx1OFYorsooT7zgPJIqNlv2LXbu0ZypbNt2istFyh3zbd8sFpaw8r1oy24ql3\nmZRT3s05XA7S6zGQ2VXkJ49BWnlKHZFZA2d6f7qnASvUvw3afxbpds+O2Ojwyv/ESpOafIHOT06Y\nY8aWzDuRDHiE/RfRif0dx1pu2tM6Klb6rUySWysLji8drx5lEvr5oJlmzvDZpzAC4NFYSkX+M5wz\nziJSBuyMGkOeFDDZLyJE4hOO8tYVjIPDFnLK0gjJNv3/jKsHD+AX6UKfdVZu5LCJEONH5twD1vh+\nSA5vKSFxww8Z9Af7E8k5HtrvvIRvonnuMFvIQx0Mj5Pwoyf7R5W9X3vg0b08K9ulaznhjO/I6B7a\n77yEb6J54+REYXDfbZuT8KMn+0eVvbLjsOxf7sGfpWs54YzvyOge2u+8hG+iefr4x7m+eOrwTBmk\n2taDt2uPalgVO/nnxTK+4DespR9x32GdyQ/BMNyg8GThLXUHnCbeZYCaLKVu6qlTELM0kk9Tx9oQ\ngRhExRLt4jifJq83/ELu+SuXX46T4xLc7RE8hjGpH2425Y2dCCpj6KgHlGvW0NKERJ3zco0ePPkp\nzEuP1tDShESd83KqBtng5cuTBn2aXw8xJVFP2Ba2B3jJ1VDDhAjF7arIzMjhyL7GDjB7GZ1mqav5\nskxuF/XnOK2RnSYeJIDm8aafShVLSh1MNdoArpf93+wdI5wUE24hkvW/lDknvJbdSIlrujOOHTLA\nH/ctpCo9Efmmwu84KpmotN/yG+LWw0q67PBVYwxhsfUZTnsQ4eYUL0L3LaQqPRH5pktt84hTArbh\n8hvi1sNKuuzwVWMMYbH1GTmdNuEbwi6S9y2kKj0R+aYADByE7XaAKd0nVfdH9ShLQWRz/mhT68JH\nirtNoZFLEU5YhDHbpslcJy89L207HIF7SJS4/7kvMmsOLjip2dmTetrRUAc7bahBmzFQeL+3va76\ntrpsad7EMoiTjH4N+Mft2J1fJmCoUcs/LejXvuOw8Bi7g8Z3b3NFsLZ5gAGqbtl2ATzOcgdS2Nx0\nRI5a8VMz0Z3tP+ZIn31U8UMs1bkyvvJb1PvX3XPh32Q2mvpaKacp8ZAjiLFnZTP1x5CpZVw1tYBn\nWiT3WWlE684HwxvWBJd6Du+Xr3g6VLVX0fPDylbHU4Viiuyi+mrHMhpxnElk1/ixuMqDd56ZQlAg\nGIar5IecFjkwRnNWx1OFYorsooxsrNwvfsNoZNf4sbjKg3eemUJQIBiGqynBxXFRFQCYVsdThWKK\n7KKE+84DySKjZb9i127tGcqWXhluy23p/AU23fLBaWsPK9aMtuKpd5mUU97NOVwO0usxkNlV5CeP\nQYdOIAaOUT5E+BCJ6QkmdK8N2n8W6XbPjtjo8Mr/xEqTmnyBzk9OmGPGlsw7kQx4hP0X0Yn9Hcda\nbtrTOipW+q1CUT3MV2T5w7trVJDEwl+4anEUfXrcFV80BVeTlC9BNovE4hMRDrI+zdQiUJkRsW9T\nl9sPwZInZqHdffvaqzePNKcwRcW9UUEt+clOtt/eOacHqm9zfjg2Ya5u300dZ41GA+Sk379yXYyW\n37qKmE8LL5YIZUnKs9rEB+AbOLvMKcz4oFKrBHy12kkeKkGzSvTvQtzghjz4W1T8v7BvAwlVxAfg\nGzi7zCmM9HjQU5YUBdpJHipBs0r070Lc4IY8+FvY5RyvLIfP0cQH4Bs4u8wpxf2WYCmp1ZBE7B2r\nYR9cpeyonFIw6taYNS/oNooLwK+j4U+mWyyVgODDhg6Uk1QqF9CX1mJTCyMf+WO2U+0Me3pRGYVE\nPebr0Mgqjjtag3jNjCbqt/TqgxuZV6HLA8VVkvPfDAtRmLeOtO8ivj1jtHz1M+cUFbVy02rk+gLu\nnWV9ml8PMSVRT7NBAI2fNbh2w4QIxe2qyMzI4ci+xg4we5lzqSctJHmCc6vBedKHz98mHiSA5vGm\nn0oVS0odTDXaAK6X/d/sHSOcFBNuIZL1v607zUUvo8rurxXZliUO7gL3LaQqPRH5psLvOCqZqLTf\n8hvi1sNKuuzwVWMMYbH1GU57EOHmFC9C9y2kKj0R+aZLbfOIUwK24fIb4tbDSrrs8FVjDGGx9Rk5\nnTbhG8IukvctpCo9EfmmAAwchO12gCndJ1X3R/UoSz01vbCdynmdR4q7TaGRSxFOWIQx26bJXCcv\nPS9tOxyBe0iUuP+5LzLOnwqIdN8YFBLt4jifJq830/2PC91M8llfRqwIzEbtsX2cM6OPor0QnyNU\nezPeeGhWBZNzgon2kHCPzKZegFJ9sQqrwsvh6VV6hgDSBohy91CZReoa2OzvvhWk32oUKUwVW68z\nGeP+bhjZbXhgWOq52YfWio8dm0eqeejGyFpGG5/84o/XqzcIKInubOo6LlZPgUQJuMnsXlYMtkUo\nsOVMCa0lFAGmujBVQH3titu9Z2TX+LG4yoN3nplCUCAYhqvaMZBwfFfVxlbHU4Viiuyifl5kw5zY\nYOlk1/ixuMqDd56ZQlAgGIarNlnHooC59zBWx1OFYorsornNtax6LT3sZNf4sbjKg3eemUJQIBiG\nqxeDQQKkz9gq5jUMT15vXk1oA2YZhzOX1qeDi08l4rjiB3FSqdGkKGpI6q5AK7IKvA==";
//		String signValue = "EvlUsTttN+E1MSTFD7DbwXcnf747PJaCXS72gutFFCxhCyz9hbRjPK/CnjdAs2EJg/roZ3wg7Tjd\nxxiFVMUgOV4AtCirG8la6oNxj2NBUawIMVshlpH8yTbHKBaJuO1daqa7jRDxgWcvAytCSf7bo0gO\nMHD6EgjFNNcDch0GAfo=\n";
//		PublicKey publicKey = KeystoreUtil.getPubKey(ConfigsContant.QIANHAI_KEYSTORE_PATH, ConfigsContant.QIANHAI_KEYSTORE_PWD, "credoo_test");
//		try {
//			Boolean flBoolean = DataSecurityUtil.verifyData(data, publicKey, signValue);
//			if (flBoolean) {
//				System.out.println("=================通过验证！");
//				String busiDataString = new String(DataSecurityUtil.decryptMode(ConfigsContant.QIANHAI_3DES_KEY.getBytes("utf-8"), DataSecurityUtil.decodeBase64(data.getBytes())));
//				System.out.println(busiDataString);
//			}else {
//				System.out.println("=================验证失败！");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
