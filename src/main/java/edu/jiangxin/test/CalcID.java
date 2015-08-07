package edu.jiangxin.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 韬唤璇佸彿鐮佺敓鎴愮殑绫?
 * 
 * @author Guanweili
 * @since 2011-04-29
 */
public class CalcID {

	/**
	 * 璁＄畻骞惰緭鍑鸿韩浠借瘉鍙风殑涓昏鏂规硶 鍐欑殑姣旇緝绱禈姣旇緝绗紝浣嗘潯鐞嗗簲璇ユ瘮杈冩竻鏅般??
	 */
	public static void Calculate() {

		String areaCode = ""; // 鐢ㄤ簬瀛樻斁鐢ㄦ埛杈撳叆鐨勫尯鍩熺紪鍙?
		String birthday = ""; // 鐢ㄦ埛瀛樻斁鐢ㄦ埛杈撳叆鐨勫嚭鐢熸棩鏈?
		String sex = ""; // 鐢ㄦ埛瀛樻斁鐢ㄦ埛杈撳叆鐨勬?у埆
		String idNo = ""; // 鐢ㄦ埛瀛樻斁鐢ㄦ埛杈撳叆鐨勯『搴忕紪鍙?

		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("璇存槑锛氳韩浠借瘉鍙风爜鐢熸垚鍣細鐩墠浠呰兘鏀寔姹熻嫃鐪佺殑鏂拌韩浠借瘉鍙?(18浣?)鐨勭敓鎴愶紝" + "\r"
				+ "鎮ㄥ彲浠ョ敤鐢熸垚鐨勮韩浠借瘉鍙峰幓缃戠珯娉ㄥ唽涓?涓笎鍙凤紝鑰屼笉蹇呮媴蹇冪湡瀹炲鍚嶅拰韬唤璇佸彿鏃犳硶瀵瑰簲锛?" + "\r"
				+ "鍙兘鏃犳硶鐢熸垚鍜屼綘鏈熸湜鐨勫彿鐮佷竴鑷寸殑韬唤璇佸彿锛岃繖鏄洜涓洪『搴忕紪鍙峰拰鎬у埆缂栧彿鑼冨洿鍊煎鑷寸殑锛?" + "\r"
				+ "姣斿瑕佺敓鎴愪竴涓拰鎮ㄨ韩浠借瘉涓?鑷寸殑鍙风爜锛岃繖涓や釜缂栧彿灏卞繀椤诲惢鍚堬紝" + "椤哄簭缂栧彿鍦ㄨ韩浠借瘉鍙风殑宸﹁捣绗?15锛?16浣嶏紝"
				+ "\r" + "鎬у埆缂栧彿鍦ㄨ韩浠借瘉鍙风殑宸﹁捣绗?17浣嶏紝" + "\r"
				+ "鍙互鎸変釜浜洪渶瑕佹坊鍔犲埌鐪佷唤缂栧彿锛屾垨鍋氭垚璇诲彇鏂囦欢鐨勫舰寮忔瘮杈冩柟渚匡紝杩欓噷浠呬粎鏄竴涓紨绀恒??" + "\r");

		System.out.println("鐜板湪璇疯緭鍏ユ偍鎵?鍦ㄧ殑甯?/鍖?/鍘跨殑鍚嶇О锛屾牸寮?(濡傚崡浜競鐜勬鍖哄氨杈撳叆锛氱巹姝﹀尯灏辫浜?): ");

		try {
			areaCode = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("璇疯緭鍏ユ偍鐨勫嚭鐢熸棩鏈燂紝鏍煎紡(19891019): "); // 鑾峰彇鐢ㄦ埛杈撳叆鐨勫嚭鐢熸棩鏈熺殑鍊?
		try {
			birthday = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("璇疯緭鍏ユ偍鐨勬?у埆锛屾牸寮?(鑼冨洿锛?1-9锛岀敺锛氬鏁帮紝濂筹細鍋舵暟): "); // 鑾峰彇鐢ㄦ埛杈撳叆鐨勬?у埆鐨勫??
		try {
			sex = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("璇疯緭鍏ユ偍甯屾湜鐨?(涓や綅)椤哄簭鍙凤紝鏍煎紡(00-99): "); // 鑾峰彇鐢ㄦ埛杈撳叆鐨勯『搴忕紪鍙风殑鍊硷紝姝ょ紪鍙峰湪涓?瀹氱▼搴︾敓鍐冲畾浜嗘偍鐨勮韩浠借瘉鍙蜂笉涓庝粬浜洪噸澶?
		try {
			idNo = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 鍒ゆ柇杈撳叆鐨勫競/鍖?/鍘跨殑鍚嶇О涓庝箣瀵瑰簲鐨勭紪鍙凤紝鐩墠浠呮敮鎸佹睙鑻忕渷
		if (areaCode.trim().equals("鐜勬鍖?")) {
			areaCode = Integer.toString(320102);
		} else if (areaCode.trim().equals("鐧戒笅鍖?")) {
			areaCode = Integer.toString(320103);
		} else if (areaCode.trim().equals("绉︽樊鍖?")) {
			areaCode = Integer.toString(320104);
		} else if (areaCode.trim().equals("寤洪偤鍖?")) {
			areaCode = Integer.toString(320105);
		} else if (areaCode.trim().equals("榧撴ゼ鍖?")) {
			areaCode = Integer.toString(320106);
		} else if (areaCode.trim().equals("涓嬪叧鍖?")) {
			areaCode = Integer.toString(320107);
		} else if (areaCode.trim().equals("娴﹀彛鍖?")) {
			areaCode = Integer.toString(320111);
		} else if (areaCode.trim().equals("鏍栭湠鍖?")) {
			areaCode = Integer.toString(320113);
		} else if (areaCode.equals("闆ㄨ姳鍙板尯")) {
			areaCode = Integer.toString(320114);
		} else if (areaCode.trim().equals("姹熷畞鍖?")) {
			areaCode = Integer.toString(320115);
		} else if (areaCode.trim().equals("鍏悎鍖?")) {
			areaCode = Integer.toString(320116);
		} else if (areaCode.trim().equals("婧ф按鍘?")) {
			areaCode = Integer.toString(320124);
		} else if (areaCode.trim().equals("楂樻烦鍘?")) {
			areaCode = Integer.toString(320125);
		} else if (areaCode.trim().equals("宕囧畨鍖?")) {
			areaCode = Integer.toString(320202);
		} else if (areaCode.trim().equals("鍗楅暱鍖?")) {
			areaCode = Integer.toString(320203);
		} else if (areaCode.trim().equals("鍖楀鍖?")) {
			areaCode = Integer.toString(320204);
		} else if (areaCode.trim().equals("閿″北鍖?")) {
			areaCode = Integer.toString(320205);
		} else if (areaCode.trim().equals("鎯犲北鍖?")) {
			areaCode = Integer.toString(320206);
		} else if (areaCode.trim().equals("婊ㄦ箹鍖?")) {
			areaCode = Integer.toString(320211);
		} else if (areaCode.trim().equals("姹熼槾甯?")) {
			areaCode = Integer.toString(320281);
		} else if (areaCode.trim().equals("瀹滃叴甯?")) {
			areaCode = Integer.toString(320282);
		} else if (areaCode.trim().equals("榧撴ゼ鍖?")) {
			areaCode = Integer.toString(320302);
		} else if (areaCode.trim().equals("浜戦緳鍖?")) {
			areaCode = Integer.toString(320303);
		} else if (areaCode.trim().equals("涔濋噷鍖?")) {
			areaCode = Integer.toString(320304);
		} else if (areaCode.trim().equals("璐炬豹鍖?")) {
			areaCode = Integer.toString(320305);
		} else if (areaCode.trim().equals("娉夊北鍖?")) {
			areaCode = Integer.toString(320311);
		} else if (areaCode.trim().equals("涓板幙")) {
			areaCode = Integer.toString(320321);
		} else if (areaCode.trim().equals("娌涘幙")) {
			areaCode = Integer.toString(320322);
		} else if (areaCode.trim().equals("閾滃北鍘?")) {
			areaCode = Integer.toString(320323);
		} else if (areaCode.trim().equals("鐫㈠畞鍘?")) {
			areaCode = Integer.toString(320324);
		} else if (areaCode.trim().equals("鏂版矀甯?")) {
			areaCode = Integer.toString(320381);
		} else if (areaCode.trim().equals("閭冲窞甯?")) {
			areaCode = Integer.toString(320382);
		} else if (areaCode.trim().equals("澶╁畞鍖?")) {
			areaCode = Integer.toString(320402);
		} else if (areaCode.trim().equals("閽熸ゼ鍖?")) {
			areaCode = Integer.toString(320404);
		} else if (areaCode.trim().equals("鎴氬鍫板尯")) {
			areaCode = Integer.toString(320405);
		} else if (areaCode.trim().equals("鏂板寳鍖?")) {
			areaCode = Integer.toString(320411);
		} else if (areaCode.trim().equals("姝﹁繘鍖?")) {
			areaCode = Integer.toString(320412);
		} else if (areaCode.trim().equals("婧ч槼甯?")) {
			areaCode = Integer.toString(320481);
		} else if (areaCode.trim().equals("閲戝潧甯?")) {
			areaCode = Integer.toString(320482);
		} else if (areaCode.trim().equals("娌ф氮鍖?")) {
			areaCode = Integer.toString(320502);
		} else if (areaCode.trim().equals("骞虫睙鍖?")) {
			areaCode = Integer.toString(320503);
		} else if (areaCode.trim().equals("閲戦槉鍖?")) {
			areaCode = Integer.toString(320504);
		} else if (areaCode.trim().equals("铏庝笜鍖?")) {
			areaCode = Integer.toString(320505);
		} else if (areaCode.trim().equals("鍚翠腑鍖?")) {
			areaCode = Integer.toString(320506);
		} else if (areaCode.trim().equals("鐩稿煄鍖?")) {
			areaCode = Integer.toString(320507);
		} else if (areaCode.trim().equals("甯哥啛甯?")) {
			areaCode = Integer.toString(320581);
		} else if (areaCode.trim().equals("寮犲娓競")) {
			areaCode = Integer.toString(320582);
		} else if (areaCode.trim().equals("鏄嗗北甯?")) {
			areaCode = Integer.toString(320583);
		} else if (areaCode.trim().equals("鍚存睙甯?")) {
			areaCode = Integer.toString(320584);
		} else if (areaCode.trim().equals("澶粨甯?")) {
			areaCode = Integer.toString(320585);
		} else if (areaCode.trim().equals("宕囧窛鍖?")) {
			areaCode = Integer.toString(320602);
		} else if (areaCode.trim().equals("娓椄鍖?")) {
			areaCode = Integer.toString(320611);
		} else if (areaCode.trim().equals("閫氬窞鍖?")) {
			areaCode = Integer.toString(320612);
		} else if (areaCode.trim().equals("娴峰畨鍘?")) {
			areaCode = Integer.toString(320621);
		} else if (areaCode.trim().equals("濡備笢鍘?")) {
			areaCode = Integer.toString(320623);
		} else if (areaCode.trim().equals("鍚笢甯?")) {
			areaCode = Integer.toString(320681);
		} else if (areaCode.trim().equals("濡傜殝甯?")) {
			areaCode = Integer.toString(320682);
		} else if (areaCode.trim().equals("娴烽棬甯?")) {
			areaCode = Integer.toString(320684);
		} else if (areaCode.trim().equals("杩炰簯鍖?")) {
			areaCode = Integer.toString(320703);
		} else if (areaCode.trim().equals("鏂版郸鍖?")) {
			areaCode = Integer.toString(320705);
		} else if (areaCode.trim().equals("娴峰窞鍖?")) {
			areaCode = Integer.toString(320706);
		} else if (areaCode.trim().equals("璧ｆ鍘?")) {
			areaCode = Integer.toString(320721);
		} else if (areaCode.trim().equals("涓滄捣鍘?")) {
			areaCode = Integer.toString(320722);
		} else if (areaCode.trim().equals("鐏屼簯鍘?")) {
			areaCode = Integer.toString(320723);
		} else if (areaCode.trim().equals("鐏屽崡鍘?")) {
			areaCode = Integer.toString(320724);
		} else if (areaCode.trim().equals("娓呮渤鍖?")) {
			areaCode = Integer.toString(320802);
		} else if (areaCode.trim().equals("妤氬窞鍖?")) {
			areaCode = Integer.toString(320803);
		} else if (areaCode.trim().equals("娣槾鍖?")) {
			areaCode = Integer.toString(320804);
		} else if (areaCode.trim().equals("娓呮郸鍖?")) {
			areaCode = Integer.toString(320811);
		} else if (areaCode.trim().equals("娑熸按鍘?")) {
			areaCode = Integer.toString(320826);
		} else if (areaCode.trim().equals("娲辰鍘?")) {
			areaCode = Integer.toString(320829);
		} else if (areaCode.trim().equals("鐩辩湙鍘?")) {
			areaCode = Integer.toString(320830);
		} else if (areaCode.trim().equals("閲戞箹鍘?")) {
			areaCode = Integer.toString(320831);
		} else if (areaCode.trim().equals("浜箹鍖?")) {
			areaCode = Integer.toString(320902);
		} else if (areaCode.trim().equals("鐩愰兘鍖?")) {
			areaCode = Integer.toString(320903);
		} else if (areaCode.trim().equals("鍝嶆按鍘?")) {
			areaCode = Integer.toString(320921);
		} else if (areaCode.trim().equals("婊ㄦ捣鍘?")) {
			areaCode = Integer.toString(320922);
		} else if (areaCode.trim().equals("闃滃畞鍘?")) {
			areaCode = Integer.toString(320923);
		} else if (areaCode.trim().equals("灏勯槼鍘?")) {
			areaCode = Integer.toString(320924);
		} else if (areaCode.trim().equals("寤烘箹鍘?")) {
			areaCode = Integer.toString(320925);
		} else if (areaCode.trim().equals("涓滃彴甯?")) {
			areaCode = Integer.toString(320981);
		} else if (areaCode.trim().equals("澶т赴甯?")) {
			areaCode = Integer.toString(320982);
		} else if (areaCode.trim().equals("骞块櫟鍖?")) {
			areaCode = Integer.toString(321002);
		} else if (areaCode.trim().equals("閭楁睙鍖?")) {
			areaCode = Integer.toString(321003);
		} else if (areaCode.trim().equals("缁存壃鍖?")) {
			areaCode = Integer.toString(321011);
		} else if (areaCode.trim().equals("瀹濆簲鍘?")) {
			areaCode = Integer.toString(321023);
		} else if (areaCode.trim().equals("浠緛甯?")) {
			areaCode = Integer.toString(321081);
		} else if (areaCode.trim().equals("楂橀偖甯?")) {
			areaCode = Integer.toString(321084);
		} else if (areaCode.trim().equals("姹熼兘甯?")) {
			areaCode = Integer.toString(321088);
		} else if (areaCode.trim().equals("浜彛鍖?")) {
			areaCode = Integer.toString(321102);
		} else if (areaCode.trim().equals("娑﹀窞鍖?")) {
			areaCode = Integer.toString(321111);
		} else if (areaCode.trim().equals("涓瑰緬鍖?")) {
			areaCode = Integer.toString(321112);
		} else if (areaCode.trim().equals("涓归槼甯?")) {
			areaCode = Integer.toString(321181);
		} else if (areaCode.trim().equals("鎵腑甯?")) {
			areaCode = Integer.toString(321182);
		} else if (areaCode.trim().equals("鍙ュ甯?")) {
			areaCode = Integer.toString(321183);
		} else if (areaCode.trim().equals("娴烽櫟鍖?")) {
			areaCode = Integer.toString(321202);
		} else if (areaCode.trim().equals("楂樻腐鍖?")) {
			areaCode = Integer.toString(321203);
		} else if (areaCode.trim().equals("鍏村寲甯?")) {
			areaCode = Integer.toString(321281);
		} else if (areaCode.trim().equals("闈栨睙甯?")) {
			areaCode = Integer.toString(321282);
		} else if (areaCode.trim().equals("娉板叴甯?")) {
			areaCode = Integer.toString(321283);
		} else if (areaCode.trim().equals("濮滃牥甯?")) {
			areaCode = Integer.toString(321284);
		} else if (areaCode.trim().equals("瀹垮煄鍖?")) {
			areaCode = Integer.toString(321302);
		} else if (areaCode.trim().equals("瀹胯鲍鍖?")) {
			areaCode = Integer.toString(321311);
		} else if (areaCode.trim().equals("娌槼鍘?")) {
			areaCode = Integer.toString(321322);
		} else if (areaCode.trim().equals("娉楅槼鍘?")) {
			areaCode = Integer.toString(321323);
		} else if (areaCode.trim().equals("娉楁椽鍘?")) {
			areaCode = Integer.toString(321324);
		} else {
			System.err.println("鎶辨瓑韬唤璇佺紪鍙风敓鎴愬け璐ワ紝鍥犱负娌℃湁鎵惧埌鎮ㄨ緭鍏ョ殑甯?/鍖?/鍘跨殑鍚嶇О涓庝箣瀵瑰簲鐨勭紪鍙凤紒");
			return;
		}

		// 鍓?17浣嶈闄や互鐨勬暟锛?7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
		int finalAreaCode = Integer.parseInt(areaCode.substring(0, 1)) * 7
				+ Integer.parseInt(areaCode.substring(1, 2)) * 9
				+ Integer.parseInt(areaCode.substring(2, 3)) * 10
				+ Integer.parseInt(areaCode.substring(3, 4)) * 5
				+ Integer.parseInt(areaCode.substring(4, 5)) * 8
				+ Integer.parseInt(areaCode.substring(5, 6)) * 4;

		int finalBirthday = Integer.parseInt(birthday.substring(0, 1)) * 2
				+ Integer.parseInt(birthday.substring(1, 2)) * 1
				+ Integer.parseInt(birthday.substring(2, 3)) * 6
				+ Integer.parseInt(birthday.substring(3, 4)) * 3
				+ Integer.parseInt(birthday.substring(4, 5)) * 7
				+ Integer.parseInt(birthday.substring(5, 6)) * 9
				+ Integer.parseInt(birthday.substring(6, 7)) * 10
				+ Integer.parseInt(birthday.substring(7, 8)) * 5;

		int NoIs = (Integer.parseInt(idNo.substring(0, 1))) * 8
				+ (Integer.parseInt(idNo.substring(1, 2))) * 4;

		int sexNo = (Integer.parseInt(sex.substring(0, 1))) * 2;

		int checkCode = (finalAreaCode + finalBirthday + NoIs + sexNo) % 11;
		int finalCheckCode = 0;

		// 浣欐暟鑼冨洿锛? 0 1 2 3 4 5 6 7 8 9 10
		// 浣欐暟瀵瑰簲鐨勬暟锛?1 0 X 9 8 7 6 5 4 3 2
		// 璁＄畻鍑烘渶缁堢殑鏍￠獙鐮侊細finalCheckCode
		switch (checkCode) {
		case 0:
			finalCheckCode = 1;
			break;
		case 1:
			finalCheckCode = 0;
			break;
		case 2:
			finalCheckCode = -3;
			break;
		case 3:
			finalCheckCode = 9;
			break;
		case 4:
			finalCheckCode = 8;
			break;
		case 5:
			finalCheckCode = 7;
			break;
		case 6:
			finalCheckCode = 6;
			break;
		case 7:
			finalCheckCode = 5;
			break;
		case 8:
			finalCheckCode = 4;
			break;
		case 9:
			finalCheckCode = 3;
			break;
		case 10:
			finalCheckCode = 2;
			break;
		default:
			break;
		}
		System.out.println("鎭枩锛岀敓鎴愮殑韬唤璇佸彿鏄細" + "\r" + areaCode + birthday + idNo
				+ sex + finalCheckCode);
		// 鍖哄煙缂栧彿(6浣嶆暟)+鍑虹敓鏃ユ湡(8浣嶆暟)+椤哄簭缂栧彿(2浣嶆暟)+鎬у埆鍙?(1浣嶆暟)+鏍￠獙鐮?(1浣嶆暟)=韬唤璇佸彿(18浣嶆暟)

	}

	/**
	 * CalcID绫荤殑鏃犲弬鏋勯?犳柟娉曪紝璋冪敤姝ゆ柟娉曞嵆鍙皟鐢ㄥ叾鏂规硶銆?
	 */
	public CalcID() {
		Calculate();
	}

	public static void main(String[] args) {
		new CalcID();
	}

}