package edu.jiangxin.mess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcID {

	public static void Calculate() {
		String areaCode = ""; // 用于存放用户输入的区域编号
		String birthday = ""; // 用户存放用户输入的出生日期
		String sex = ""; // 用户存放用户输入的性别
		String idNo = ""; // 用户存放用户输入的顺序编号
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		System.out.println("说明：身份证号码生成器：目前仅能支持江苏省的新身份证号(18位)的生成，" + "\r" + "您可以用生成的身份证号去网站注册一个帐号，而不必担心真实姓名和身份证号无法对应，"
				+ "\r" + "可能无法生成和你期望的号码一致的身份证号，这是因为顺序编号和性别编号范围值导致的，" + "\r" + "比如要生成一个和您身份证一致的号码，这两个编号就必须吻合，"
				+ "顺序编号在身份证号的左起第15，16位，" + "\r" + "性别编号在身份证号的左起第17位，" + "\r"
				+ "可以按个人需要添加到省份编号，或做成读取文件的形式比较方便，这里仅仅是一个演示。" + "\r");
		System.out.println("现在请输入您所在的市/区/县的名称，格式(如南京市玄武区就输入：玄武区就行了): ");
		try {
			areaCode = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("请输入您的出生日期，格式(19891019): "); // 获取用户输入的出生日期的值
		try {
			birthday = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("请输入您的性别，格式(范围：1-9，男：奇数，女：偶数): "); // 获取用户输入的性别的值
		try {
			sex = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("请输入您希望的(两位)顺序号，格式(00-99): "); // 获取用户输入的顺序编号的值，此编号在一定程度生决定了您的身份证号不与他人重复
		try {
			idNo = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 判断输入的市/区/县的名称与之对应的编号，目前仅支持江苏省
		if (areaCode.trim().equals("玄武区")) {
			areaCode = Integer.toString(320102);
		} else if (areaCode.trim().equals("白下区")) {
			areaCode = Integer.toString(320103);
		} else if (areaCode.trim().equals("秦淮区")) {
			areaCode = Integer.toString(320104);
		} else if (areaCode.trim().equals("建邺区")) {
			areaCode = Integer.toString(320105);
		} else if (areaCode.trim().equals("鼓楼区")) {
			areaCode = Integer.toString(320106);
		} else if (areaCode.trim().equals("下关区")) {
			areaCode = Integer.toString(320107);
		} else if (areaCode.trim().equals("浦口区")) {
			areaCode = Integer.toString(320111);
		} else if (areaCode.trim().equals("栖霞区")) {
			areaCode = Integer.toString(320113);
		} else if (areaCode.equals("雨花台区")) {
			areaCode = Integer.toString(320114);
		} else if (areaCode.trim().equals("江宁区")) {
			areaCode = Integer.toString(320115);
		} else if (areaCode.trim().equals("六合区")) {
			areaCode = Integer.toString(320116);
		} else if (areaCode.trim().equals("溧水县")) {
			areaCode = Integer.toString(320124);
		} else if (areaCode.trim().equals("高淳县")) {
			areaCode = Integer.toString(320125);
		} else if (areaCode.trim().equals("崇安区")) {
			areaCode = Integer.toString(320202);
		} else if (areaCode.trim().equals("南长区")) {
			areaCode = Integer.toString(320203);
		} else if (areaCode.trim().equals("北塘区")) {
			areaCode = Integer.toString(320204);
		} else if (areaCode.trim().equals("锡山区")) {
			areaCode = Integer.toString(320205);
		} else if (areaCode.trim().equals("惠山区")) {
			areaCode = Integer.toString(320206);
		} else if (areaCode.trim().equals("滨湖区")) {
			areaCode = Integer.toString(320211);
		} else if (areaCode.trim().equals("江阴市")) {
			areaCode = Integer.toString(320281);
		} else if (areaCode.trim().equals("宜兴市")) {
			areaCode = Integer.toString(320282);
		} else if (areaCode.trim().equals("鼓楼区")) {
			areaCode = Integer.toString(320302);
		} else if (areaCode.trim().equals("云龙区")) {
			areaCode = Integer.toString(320303);
		} else if (areaCode.trim().equals("九里区")) {
			areaCode = Integer.toString(320304);
		} else if (areaCode.trim().equals("贾汪区")) {
			areaCode = Integer.toString(320305);
		} else if (areaCode.trim().equals("泉山区")) {
			areaCode = Integer.toString(320311);
		} else if (areaCode.trim().equals("丰县")) {
			areaCode = Integer.toString(320321);
		} else if (areaCode.trim().equals("沛县")) {
			areaCode = Integer.toString(320322);
		} else if (areaCode.trim().equals("铜山县")) {
			areaCode = Integer.toString(320323);
		} else if (areaCode.trim().equals("睢宁县")) {
			areaCode = Integer.toString(320324);
		} else if (areaCode.trim().equals("新沂市")) {
			areaCode = Integer.toString(320381);
		} else if (areaCode.trim().equals("邳州市")) {
			areaCode = Integer.toString(320382);
		} else if (areaCode.trim().equals("天宁区")) {
			areaCode = Integer.toString(320402);
		} else if (areaCode.trim().equals("钟楼区")) {
			areaCode = Integer.toString(320404);
		} else if (areaCode.trim().equals("戚墅堰区")) {
			areaCode = Integer.toString(320405);
		} else if (areaCode.trim().equals("新北区")) {
			areaCode = Integer.toString(320411);
		} else if (areaCode.trim().equals("武进区")) {
			areaCode = Integer.toString(320412);
		} else if (areaCode.trim().equals("溧阳市")) {
			areaCode = Integer.toString(320481);
		} else if (areaCode.trim().equals("金坛市")) {
			areaCode = Integer.toString(320482);
		} else if (areaCode.trim().equals("沧浪区")) {
			areaCode = Integer.toString(320502);
		} else if (areaCode.trim().equals("平江区")) {
			areaCode = Integer.toString(320503);
		} else if (areaCode.trim().equals("金阊区")) {
			areaCode = Integer.toString(320504);
		} else if (areaCode.trim().equals("虎丘区")) {
			areaCode = Integer.toString(320505);
		} else if (areaCode.trim().equals("吴中区")) {
			areaCode = Integer.toString(320506);
		} else if (areaCode.trim().equals("相城区")) {
			areaCode = Integer.toString(320507);
		} else if (areaCode.trim().equals("常熟市")) {
			areaCode = Integer.toString(320581);
		} else if (areaCode.trim().equals("张家港市")) {
			areaCode = Integer.toString(320582);
		} else if (areaCode.trim().equals("昆山市")) {
			areaCode = Integer.toString(320583);
		} else if (areaCode.trim().equals("吴江市")) {
			areaCode = Integer.toString(320584);
		} else if (areaCode.trim().equals("太仓市")) {
			areaCode = Integer.toString(320585);
		} else if (areaCode.trim().equals("崇川区")) {
			areaCode = Integer.toString(320602);
		} else if (areaCode.trim().equals("港闸区")) {
			areaCode = Integer.toString(320611);
		} else if (areaCode.trim().equals("通州区")) {
			areaCode = Integer.toString(320612);
		} else if (areaCode.trim().equals("海安县")) {
			areaCode = Integer.toString(320621);
		} else if (areaCode.trim().equals("如东县")) {
			areaCode = Integer.toString(320623);
		} else if (areaCode.trim().equals("启东市")) {
			areaCode = Integer.toString(320681);
		} else if (areaCode.trim().equals("如皋市")) {
			areaCode = Integer.toString(320682);
		} else if (areaCode.trim().equals("海门市")) {
			areaCode = Integer.toString(320684);
		} else if (areaCode.trim().equals("连云区")) {
			areaCode = Integer.toString(320703);
		} else if (areaCode.trim().equals("新浦区")) {
			areaCode = Integer.toString(320705);
		} else if (areaCode.trim().equals("海州区")) {
			areaCode = Integer.toString(320706);
		} else if (areaCode.trim().equals("赣榆县")) {
			areaCode = Integer.toString(320721);
		} else if (areaCode.trim().equals("东海县")) {
			areaCode = Integer.toString(320722);
		} else if (areaCode.trim().equals("灌云县")) {
			areaCode = Integer.toString(320723);
		} else if (areaCode.trim().equals("灌南县")) {
			areaCode = Integer.toString(320724);
		} else if (areaCode.trim().equals("清河区")) {
			areaCode = Integer.toString(320802);
		} else if (areaCode.trim().equals("楚州区")) {
			areaCode = Integer.toString(320803);
		} else if (areaCode.trim().equals("淮阴区")) {
			areaCode = Integer.toString(320804);
		} else if (areaCode.trim().equals("清浦区")) {
			areaCode = Integer.toString(320811);
		} else if (areaCode.trim().equals("涟水县")) {
			areaCode = Integer.toString(320826);
		} else if (areaCode.trim().equals("洪泽县")) {
			areaCode = Integer.toString(320829);
		} else if (areaCode.trim().equals("盱眙县")) {
			areaCode = Integer.toString(320830);
		} else if (areaCode.trim().equals("金湖县")) {
			areaCode = Integer.toString(320831);
		} else if (areaCode.trim().equals("亭湖区")) {
			areaCode = Integer.toString(320902);
		} else if (areaCode.trim().equals("盐都区")) {
			areaCode = Integer.toString(320903);
		} else if (areaCode.trim().equals("响水县")) {
			areaCode = Integer.toString(320921);
		} else if (areaCode.trim().equals("滨海县")) {
			areaCode = Integer.toString(320922);
		} else if (areaCode.trim().equals("阜宁县")) {
			areaCode = Integer.toString(320923);
		} else if (areaCode.trim().equals("射阳县")) {
			areaCode = Integer.toString(320924);
		} else if (areaCode.trim().equals("建湖县")) {
			areaCode = Integer.toString(320925);
		} else if (areaCode.trim().equals("东台市")) {
			areaCode = Integer.toString(320981);
		} else if (areaCode.trim().equals("大丰市")) {
			areaCode = Integer.toString(320982);
		} else if (areaCode.trim().equals("广陵区")) {
			areaCode = Integer.toString(321002);
		} else if (areaCode.trim().equals("邗江区")) {
			areaCode = Integer.toString(321003);
		} else if (areaCode.trim().equals("维扬区")) {
			areaCode = Integer.toString(321011);
		} else if (areaCode.trim().equals("宝应县")) {
			areaCode = Integer.toString(321023);
		} else if (areaCode.trim().equals("仪征市")) {
			areaCode = Integer.toString(321081);
		} else if (areaCode.trim().equals("高邮市")) {
			areaCode = Integer.toString(321084);
		} else if (areaCode.trim().equals("江都市")) {
			areaCode = Integer.toString(321088);
		} else if (areaCode.trim().equals("京口区")) {
			areaCode = Integer.toString(321102);
		} else if (areaCode.trim().equals("润州区")) {
			areaCode = Integer.toString(321111);
		} else if (areaCode.trim().equals("丹徒区")) {
			areaCode = Integer.toString(321112);
		} else if (areaCode.trim().equals("丹阳市")) {
			areaCode = Integer.toString(321181);
		} else if (areaCode.trim().equals("扬中市")) {
			areaCode = Integer.toString(321182);
		} else if (areaCode.trim().equals("句容市")) {
			areaCode = Integer.toString(321183);
		} else if (areaCode.trim().equals("海陵区")) {
			areaCode = Integer.toString(321202);
		} else if (areaCode.trim().equals("高港区")) {
			areaCode = Integer.toString(321203);
		} else if (areaCode.trim().equals("兴化市")) {
			areaCode = Integer.toString(321281);
		} else if (areaCode.trim().equals("靖江市")) {
			areaCode = Integer.toString(321282);
		} else if (areaCode.trim().equals("泰兴市")) {
			areaCode = Integer.toString(321283);
		} else if (areaCode.trim().equals("姜堰市")) {
			areaCode = Integer.toString(321284);
		} else if (areaCode.trim().equals("宿城区")) {
			areaCode = Integer.toString(321302);
		} else if (areaCode.trim().equals("宿豫区")) {
			areaCode = Integer.toString(321311);
		} else if (areaCode.trim().equals("沭阳县")) {
			areaCode = Integer.toString(321322);
		} else if (areaCode.trim().equals("泗阳县")) {
			areaCode = Integer.toString(321323);
		} else if (areaCode.trim().equals("泗洪县")) {
			areaCode = Integer.toString(321324);
		} else {
			System.err.println("抱歉身份证编号生成失败，因为没有找到您输入的市/区/县的名称与之对应的编号！");
			return;
		}
		// 前17位要除以的数：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
		int finalAreaCode = Integer.parseInt(areaCode.substring(0, 1)) * 7
				+ Integer.parseInt(areaCode.substring(1, 2)) * 9 + Integer.parseInt(areaCode.substring(2, 3)) * 10
				+ Integer.parseInt(areaCode.substring(3, 4)) * 5 + Integer.parseInt(areaCode.substring(4, 5)) * 8
				+ Integer.parseInt(areaCode.substring(5, 6)) * 4;
		int finalBirthday = Integer.parseInt(birthday.substring(0, 1)) * 2
				+ Integer.parseInt(birthday.substring(1, 2)) * 1 + Integer.parseInt(birthday.substring(2, 3)) * 6
				+ Integer.parseInt(birthday.substring(3, 4)) * 3 + Integer.parseInt(birthday.substring(4, 5)) * 7
				+ Integer.parseInt(birthday.substring(5, 6)) * 9 + Integer.parseInt(birthday.substring(6, 7)) * 10
				+ Integer.parseInt(birthday.substring(7, 8)) * 5;
		int NoIs = (Integer.parseInt(idNo.substring(0, 1))) * 8 + (Integer.parseInt(idNo.substring(1, 2))) * 4;
		int sexNo = (Integer.parseInt(sex.substring(0, 1))) * 2;
		int checkCode = (finalAreaCode + finalBirthday + NoIs + sexNo);
		int finalCheckCode = 0;
		// 余数范围： 0 1 2 3 4 5 6 7 8 9 10
		// 余数对应的数：1 0 X 9 8 7 6 5 4 3 2
		// 计算出最终的校验码：finalCheckCode
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
		System.out.println("恭喜，生成的身份证号是：" + "\r" + areaCode + birthday + idNo + sex + finalCheckCode);
		// 区域编号(6位数)+出生日期(8位数)+顺序编号(2位数)+性别号(1位数)+校验码(1位数)=身份证号(18位数)
	}

	public CalcID() {
		Calculate();
	}

	public static void main(String[] args) {
		new CalcID();
	}

}