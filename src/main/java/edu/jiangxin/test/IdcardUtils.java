package edu.jiangxin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
/////
 // 韬唤璇佸伐鍏风被
 //
 // @author June
 // @version 1.0, 2010-06-17
 ///
public class IdcardUtils extends StringUtils {
    ///// 涓浗鍏皯韬唤璇佸彿鐮佹渶灏忛暱搴︺?? ///
    public static final int CHINA_ID_MIN_LENGTH = 15;
    ///// 涓浗鍏皯韬唤璇佸彿鐮佹渶澶ч暱搴︺?? ///
    public static final int CHINA_ID_MAX_LENGTH = 18;
    ///// 鐪併?佺洿杈栧競浠ｇ爜琛? ///
    public static final String cityCode[] = {
            "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41",
            "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
            "81", "82", "91"
    };
    ///// 姣忎綅鍔犳潈鍥犲瓙 ///
    public static final int power[] = {
            7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2
    };
    ///// 绗?18浣嶆牎妫?鐮? ///
    public static final String verifyCode[] = {
            "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"
    };
    ///// 鏈?浣庡勾闄? ///
    public static final int MIN = 1930;
    public static Map<String, String> cityCodes = new HashMap<String, String>();
    ///// 鍙版咕韬唤棣栧瓧姣嶅搴旀暟瀛? ///
    public static Map<String, Integer> twFirstCode = new HashMap<String, Integer>();
    ///// 棣欐腐韬唤棣栧瓧姣嶅搴旀暟瀛? ///
    public static Map<String, Integer> hkFirstCode = new HashMap<String, Integer>();
    static {
        cityCodes.put("11", "鍖椾含");
        cityCodes.put("12", "澶╂触");
        cityCodes.put("13", "娌冲寳");
        cityCodes.put("14", "灞辫タ");
        cityCodes.put("15", "鍐呰挋鍙?");
        cityCodes.put("21", "杈藉畞");
        cityCodes.put("22", "鍚夋灄");
        cityCodes.put("23", "榛戦緳姹?");
        cityCodes.put("31", "涓婃捣");
        cityCodes.put("32", "姹熻嫃");
        cityCodes.put("33", "娴欐睙");
        cityCodes.put("34", "瀹夊窘");
        cityCodes.put("35", "绂忓缓");
        cityCodes.put("36", "姹熻タ");
        cityCodes.put("37", "灞变笢");
        cityCodes.put("41", "娌冲崡");
        cityCodes.put("42", "婀栧寳");
        cityCodes.put("43", "婀栧崡");
        cityCodes.put("44", "骞夸笢");
        cityCodes.put("45", "骞胯タ");
        cityCodes.put("46", "娴峰崡");
        cityCodes.put("50", "閲嶅簡");
        cityCodes.put("51", "鍥涘窛");
        cityCodes.put("52", "璐靛窞");
        cityCodes.put("53", "浜戝崡");
        cityCodes.put("54", "瑗胯棌");
        cityCodes.put("61", "闄曡タ");
        cityCodes.put("62", "鐢樿們");
        cityCodes.put("63", "闈掓捣");
        cityCodes.put("64", "瀹佸");
        cityCodes.put("65", "鏂扮枂");
        cityCodes.put("71", "鍙版咕");
        cityCodes.put("81", "棣欐腐");
        cityCodes.put("82", "婢抽棬");
        cityCodes.put("91", "鍥藉");
        twFirstCode.put("A", 10);
        twFirstCode.put("B", 11);
        twFirstCode.put("C", 12);
        twFirstCode.put("D", 13);
        twFirstCode.put("E", 14);
        twFirstCode.put("F", 15);
        twFirstCode.put("G", 16);
        twFirstCode.put("H", 17);
        twFirstCode.put("J", 18);
        twFirstCode.put("K", 19);
        twFirstCode.put("L", 20);
        twFirstCode.put("M", 21);
        twFirstCode.put("N", 22);
        twFirstCode.put("P", 23);
        twFirstCode.put("Q", 24);
        twFirstCode.put("R", 25);
        twFirstCode.put("S", 26);
        twFirstCode.put("T", 27);
        twFirstCode.put("U", 28);
        twFirstCode.put("V", 29);
        twFirstCode.put("X", 30);
        twFirstCode.put("Y", 31);
        twFirstCode.put("W", 32);
        twFirstCode.put("Z", 33);
        twFirstCode.put("I", 34);
        twFirstCode.put("O", 35);
        hkFirstCode.put("A", 1);
        hkFirstCode.put("B", 2);
        hkFirstCode.put("C", 3);
        hkFirstCode.put("R", 18);
        hkFirstCode.put("U", 21);
        hkFirstCode.put("Z", 26);
        hkFirstCode.put("X", 24);
        hkFirstCode.put("W", 23);
        hkFirstCode.put("O", 15);
        hkFirstCode.put("N", 14);
    }
    /////
     // 灏?15浣嶈韩浠借瘉鍙风爜杞崲涓?18浣?
     //
     // @param idCard
     //            15浣嶈韩浠界紪鐮?
     // @return 18浣嶈韩浠界紪鐮?
     ///
    public static String conver15CardTo18(String idCard) {
        String idCard18 = "";
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return null;
        }
        if (isNum(idCard)) {
            // 鑾峰彇鍑虹敓骞存湀鏃?
            String birthday = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yyMMdd").parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            // 鑾峰彇鍑虹敓骞?(瀹屽叏琛ㄧ幇褰㈠紡,濡傦細2010)
            String sYear = String.valueOf(cal.get(Calendar.YEAR));
            idCard18 = idCard.substring(0, 6) + sYear + idCard.substring(8);
            // 杞崲瀛楃鏁扮粍
            char[] cArr = idCard18.toCharArray();
            if (cArr != null) {
                int[] iCard = converCharToInt(cArr);
                int iSum17 = getPowerSum(iCard);
                // 鑾峰彇鏍￠獙浣?
                String sVal = getCheckCode18(iSum17);
                if (sVal.length() > 0) {
                    idCard18 += sVal;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
        return idCard18;
    }
    /////
     // 楠岃瘉韬唤璇佹槸鍚﹀悎娉?
     ///
    public static boolean validateCard(String idCard) {
        String card = idCard.trim();
        if (validateIdCard18(card)) {
            return true;
        }
        if (validateIdCard15(card)) {
            return true;
        }
        String[] cardval = validateIdCard10(card);
        if (cardval != null) {
            if (cardval[2].equals("true")) {
                return true;
            }
        }
        return false;
    }
    /////
     // 楠岃瘉18浣嶈韩浠界紪鐮佹槸鍚﹀悎娉?
     //
     // @param idCard 韬唤缂栫爜
     // @return 鏄惁鍚堟硶
     ///
    public static boolean validateIdCard18(String idCard) {
        boolean bTrue = false;
        if (idCard.length() == CHINA_ID_MAX_LENGTH) {
            // 鍓?17浣?
            String code17 = idCard.substring(0, 17);
            // 绗?18浣?
            String code18 = idCard.substring(17, CHINA_ID_MAX_LENGTH);
            if (isNum(code17)) {
                char[] cArr = code17.toCharArray();
                if (cArr != null) {
                    int[] iCard = converCharToInt(cArr);
                    int iSum17 = getPowerSum(iCard);
                    // 鑾峰彇鏍￠獙浣?
                    String val = getCheckCode18(iSum17);
                    if (val.length() > 0) {
                        if (val.equalsIgnoreCase(code18)) {
                            bTrue = true;
                        }
                    }
                }
            }
        }
        return bTrue;
    }
    /////
     // 楠岃瘉15浣嶈韩浠界紪鐮佹槸鍚﹀悎娉?
     //
     // @param idCard
     //            韬唤缂栫爜
     // @return 鏄惁鍚堟硶
     ///
    public static boolean validateIdCard15(String idCard) {
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return false;
        }
        if (isNum(idCard)) {
            String proCode = idCard.substring(0, 2);
            if (cityCodes.get(proCode) == null) {
                return false;
            }
            String birthCode = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yy").parse(birthCode.substring(0, 2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            if (!valiDate(cal.get(Calendar.YEAR), Integer.valueOf(birthCode.substring(2, 4)),
                    Integer.valueOf(birthCode.substring(4, 6)))) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    /////
     // 楠岃瘉10浣嶈韩浠界紪鐮佹槸鍚﹀悎娉?
     //
     // @param idCard 韬唤缂栫爜
     // @return 韬唤璇佷俊鎭暟缁?
     //         <p>
     //         [0] - 鍙版咕銆佹境闂ㄣ?侀娓? [1] - 鎬у埆(鐢稭,濂矲,鏈煡N) [2] - 鏄惁鍚堟硶(鍚堟硶true,涓嶅悎娉昮alse)
     //         鑻ヤ笉鏄韩浠借瘉浠跺彿鐮佸垯杩斿洖null
     //         </p>
     ///
    public static String[] validateIdCard10(String idCard) {
        String[] info = new String[3];
        //String card = idCard.replaceAll("[\(|\)]", "");
        String card = idCard.replaceAll("[(|)]", "");
        if (card.length() != 8 && card.length() != 9 && idCard.length() != 10) {
            return null;
        }
        if (idCard.matches("^[a-zA-Z][0-9]{9}$")) { // 鍙版咕
            info[0] = "鍙版咕";
            System.out.println("11111");
            String char2 = idCard.substring(1, 2);
            if (char2.equals("1")) {
                info[1] = "M";
                System.out.println("MMMMMMM");
            } else if (char2.equals("2")) {
                info[1] = "F";
                System.out.println("FFFFFFF");
            } else {
                info[1] = "N";
                info[2] = "false";
                System.out.println("NNNN");
                return info;
            }
            info[2] = validateTWCard(idCard) ? "true" : "false";
       // } else if (idCard.matches("^[1|5|7][0-9]{6}\(?[0-9A-Z]\)?$")) { // 婢抽棬
        } else if (idCard.matches("^[1|5|7][0-9]{6}(?[0-9A-Z])?$")) { // 婢抽棬
            info[0] = "婢抽棬";
            info[1] = "N";
            // TODO
       // } else if (idCard.matches("^[A-Z]{1,2}[0-9]{6}\(?[0-9A]\)?$")) { // 棣欐腐
        } else if (idCard.matches("^[A-Z]{1,2}[0-9]{6}(?[0-9A])?$")) { // 棣欐腐
            info[0] = "棣欐腐";
            info[1] = "N";
            info[2] = validateHKCard(idCard) ? "true" : "false";
        } else {
            return null;
        }
        return info;
    }
    /////
     // 楠岃瘉鍙版咕韬唤璇佸彿鐮?
     //
     // @param idCard
     //            韬唤璇佸彿鐮?
     // @return 楠岃瘉鐮佹槸鍚︾鍚?
     ///
    public static boolean validateTWCard(String idCard) {
        String start = idCard.substring(0, 1);
        String mid = idCard.substring(1, 9);
        String end = idCard.substring(9, 10);
        Integer iStart = twFirstCode.get(start);
        Integer sum = iStart / 10 + (iStart % 10); // 9;
        char[] chars = mid.toCharArray();
        Integer iflag = 8;
        for (char c : chars) {
            sum = sum + Integer.valueOf(c + ""); // iflag;
            iflag--;
        }
        return (sum % 10 == 0 ? 0 : (10 - sum % 10)) == Integer.valueOf(end) ? true : false;
    }
    /////
     // 楠岃瘉棣欐腐韬唤璇佸彿鐮?(瀛樺湪Bug锛岄儴浠界壒娈婅韩浠借瘉鏃犳硶妫?鏌?)
     // <p>
     // 韬唤璇佸墠2浣嶄负鑻辨枃瀛楃锛屽鏋滃彧鍑虹幇涓?涓嫳鏂囧瓧绗﹀垯琛ㄧず绗竴浣嶆槸绌烘牸锛屽搴旀暟瀛?58 鍓?2浣嶈嫳鏂囧瓧绗-Z鍒嗗埆瀵瑰簲鏁板瓧10-35
     // 鏈?鍚庝竴浣嶆牎楠岀爜涓?0-9鐨勬暟瀛楀姞涓婂瓧绗?"A"锛?"A"浠ｈ〃10
     // </p>
     // <p>
     // 灏嗚韩浠借瘉鍙风爜鍏ㄩ儴杞崲涓烘暟瀛楋紝鍒嗗埆瀵瑰簲涔?9-1鐩稿姞鐨勬?诲拰锛屾暣闄?11鍒欒瘉浠跺彿鐮佹湁鏁?
     // </p>
     //
     // @param idCard 韬唤璇佸彿鐮?
     // @return 楠岃瘉鐮佹槸鍚︾鍚?
     ///
    public static boolean validateHKCard(String idCard) {
        //String card = idCard.replaceAll("[\(|\)]", "");
    	String card = idCard.replaceAll("[(|)]", "");
        Integer sum = 0;
        if (card.length() == 9) {
            sum = (Integer.valueOf(card.substring(0, 1).toUpperCase().toCharArray()[0]) - 55) // 9
                    + (Integer.valueOf(card.substring(1, 2).toUpperCase().toCharArray()[0]) - 55); // 8;
            card = card.substring(1, 9);
        } else {
            sum = 522 + (Integer.valueOf(card.substring(0, 1).toUpperCase().toCharArray()[0]) - 55); // 8;
        }
        String mid = card.substring(1, 7);
        String end = card.substring(7, 8);
        char[] chars = mid.toCharArray();
        Integer iflag = 7;
        for (char c : chars) {
            sum = sum + Integer.valueOf(c + ""); // iflag;
            iflag--;
        }
        if (end.toUpperCase().equals("A")) {
            sum = sum + 10;
        } else {
            sum = sum + Integer.valueOf(end);
        }
        return (sum % 11 == 0) ? true : false;
    }
    /////
     // 灏嗗瓧绗︽暟缁勮浆鎹㈡垚鏁板瓧鏁扮粍
     //
     // @param ca
     //            瀛楃鏁扮粍
     // @return 鏁板瓧鏁扮粍
     ///
    public static int[] converCharToInt(char[] ca) {
        int len = ca.length;
        int[] iArr = new int[len];
        try {
            for (int i = 0; i < len; i++) {
                iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return iArr;
    }
    /////
     // 灏嗚韩浠借瘉鐨勬瘡浣嶅拰瀵瑰簲浣嶇殑鍔犳潈鍥犲瓙鐩镐箻涔嬪悗锛屽啀寰楀埌鍜屽??
     //
     // @param iArr
     // @return 韬唤璇佺紪鐮併??
     ///
    public static int getPowerSum(int[] iArr) {
        int iSum = 0;
        if (power.length == iArr.length) {
            for (int i = 0; i < iArr.length; i++) {
                for (int j = 0; j < power.length; j++) {
                    if (i == j) {
                        iSum = iSum + iArr[i]; // power[j];
                    }
                }
            }
        }
        return iSum;
    }
    /////
     // 灏唒ower鍜屽?间笌11鍙栨ā鑾峰緱浣欐暟杩涜鏍￠獙鐮佸垽鏂?
     //
     // @param iSum
     // @return 鏍￠獙浣?
     ///
    public static String getCheckCode18(int iSum) {
        String sCode = "";
        switch (iSum % 11) {
        case 10:
            sCode = "2";
            break;
        case 9:
            sCode = "3";
            break;
        case 8:
            sCode = "4";
            break;
        case 7:
            sCode = "5";
            break;
        case 6:
            sCode = "6";
            break;
        case 5:
            sCode = "7";
            break;
        case 4:
            sCode = "8";
            break;
        case 3:
            sCode = "9";
            break;
        case 2:
            sCode = "x";
            break;
        case 1:
            sCode = "0";
            break;
        case 0:
            sCode = "1";
            break;
        }
        return sCode;
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇骞撮緞
     //
     // @param idCard
     //            韬唤缂栧彿
     // @return 骞撮緞
     ///
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        if (idCard.length() == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        String year = idCard.substring(6, 10);
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鐢熸棩
     //
     // @param idCard 韬唤缂栧彿
     // @return 鐢熸棩(yyyyMMdd)
     ///
    public static String getBirthByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return idCard.substring(6, 14);
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鐢熸棩骞?
     //
     // @param idCard 韬唤缂栧彿
     // @return 鐢熸棩(yyyy)
     ///
    public static Short getYearByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return Short.valueOf(idCard.substring(6, 10));
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鐢熸棩鏈?
     //
     // @param idCard
     //            韬唤缂栧彿
     // @return 鐢熸棩(MM)
     ///
    public static Short getMonthByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return Short.valueOf(idCard.substring(10, 12));
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鐢熸棩澶?
     //
     // @param idCard
     //            韬唤缂栧彿
     // @return 鐢熸棩(dd)
     ///
    public static Short getDateByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return Short.valueOf(idCard.substring(12, 14));
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鎬у埆
     //
     // @param idCard 韬唤缂栧彿
     // @return 鎬у埆(M-鐢凤紝F-濂筹紝N-鏈煡)
     ///
    public static String getGenderByIdCard(String idCard) {
        String sGender = "N";
        if (idCard.length() == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "M";
        } else {
            sGender = "F";
        }
        return sGender;
    }
    /////
     // 鏍规嵁韬唤缂栧彿鑾峰彇鎴风睄鐪佷唤
     //
     // @param idCard 韬唤缂栫爜
     // @return 鐪佺骇缂栫爜銆?
     ///
    public static String getProvinceByIdCard(String idCard) {
        int len = idCard.length();
        String sProvince = null;
        String sProvinNum = "";
        if (len == CHINA_ID_MIN_LENGTH || len == CHINA_ID_MAX_LENGTH) {
            sProvinNum = idCard.substring(0, 2);
        }
        sProvince = cityCodes.get(sProvinNum);
        return sProvince;
    }
    /////
     // 鏁板瓧楠岃瘉
     //
     // @param val
     // @return 鎻愬彇鐨勬暟瀛椼??
     ///
    public static boolean isNum(String val) {
        return val == null || "".equals(val) ? false : val.matches("^[0-9]//$");
    }
    /////
     // 楠岃瘉灏忎簬褰撳墠鏃ユ湡 鏄惁鏈夋晥
     //
     // @param iYear
     //            寰呴獙璇佹棩鏈?(骞?)
     // @param iMonth
     //            寰呴獙璇佹棩鏈?(鏈? 1-12)
     // @param iDate
     //            寰呴獙璇佹棩鏈?(鏃?)
     // @return 鏄惁鏈夋晥
     ///
    public static boolean valiDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < MIN || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
        case 4:
        case 6:
        case 9:
        case 11:
            datePerMonth = 30;
            break;
        case 2:
            boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0))
                    && (iYear > MIN && iYear < year);
            datePerMonth = dm ? 29 : 28;
            break;
        default:
            datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }
}
