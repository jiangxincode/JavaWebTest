package edu.leetcode;
import java.util.Arrays;
//ע��. Arrays.toString(char) �᷵�ش����źͶ��ŵ�������ʽ��string ����Ҫ��������һ������string
//s = new String(temp);

//���һ��string�ǲ���number
//��Ŀ���õ�һλ������.����������e
//��Ŀ�������һλ����.����������e
//string|����|�������пո�
//".e1"  "1e."����Ҳ������ .��e��������һ��
//"+.8" ����
// 	"6e6.5" ������  e���治����С���� �� ����e��������б�����

public class IsNumber {

	public boolean isNumber(String s) {
		                                              //����double.valueOf���ǿ��Ե� �������ⲻ���� ������ǰȥ��
				if (s == null || "".equals(s) || s.endsWith("f") || s.endsWith("D")|| s.endsWith("d")|| s.endsWith("F")) {
					return false;
				}
				String source = s.trim();
				try {
					Double.valueOf(source);
					return true;
				} catch (Exception e) {
					return false;
				}
			}



	public static void main(String[] args) {
		System.out.print((new IsNumber().isNumber(" 005047e+6")));

	}

}


// ���������İ��Ʒ ����wrong answer �����Ҿ��������ܳ�ҵ�˼�����Ѿ�����ˡ�
//˭�п�˭�����о���������Ĵ�
//
//public boolean isNumber(String s) {
//	s = s.trim();
//	boolean hasnumber = false;
//	boolean already1e = false;
//	boolean alreadyDot = false;
//	if (s.equals("")) {
//		return false;
//	}
//
//	if (s.charAt(s.length() - 1) != '.') {
//		if (s.charAt(s.length() - 1) < '0'
//				|| s.charAt(s.length() - 1) > '9') {
//
//			return false;
//		}
//	}
//	for (int i = 0; i < s.length(); i++) {
//		// һ������û�п϶���
//		if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
//			hasnumber = true;
//		}
//
//		if (s.charAt(i) == (' ')) {
//			return false;
//		} // �������пո�
//			// �ڵ�һλ��״̬���ȴ����һλ ע������д�� ������ �߼�������
//		if ((i == 0)
//				&& (s.charAt(i) == 'e' || s.charAt(i) == '.'
//						|| s.charAt(i) == '-' || s.charAt(i) == '+')) {
//
//			if (s.charAt(i) == 'e') {
//				return false;
//			}
//			if (s.charAt(i) == '.') {
//
//				if (s.length() == 1 || s.charAt(i + 1) == 'e') {
//					return false;
//				}// rule out ֻ��һ��������
//				alreadyDot = true;
//				char[] temp = s.toCharArray();
//				temp[i] = '0';
//				s = new String(temp);
//
//				// continue;
//			}
//			if (s.charAt(i) == '-') {
//
//				if (s.length() == 1) {
//					return false;
//				}// rule out ֻ��һ��'-'�����
//				if (s.charAt(i + 1) != '.') {
//					if (s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9') {
//						return false;
//					}
//				}
//
//				char[] temp = s.toCharArray();
//				temp[i] = '0';
//				s = new String(temp);
//
//				// continue;
//			}
//			if (s.charAt(i) == '+') {
//
//				if (s.length() == 1) {
//					return false;
//				}// rule out ֻ��һ��'+'�����
//				if (s.charAt(i + 1) != '.') {
//					if (s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9') {
//						return false;
//					}
//				}
//
//				char[] temp = s.toCharArray();
//				temp[i] = '0';
//				s = new String(temp);
//
//				// continue;
//			}
//
//		}
//
//		if (i == 0 && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
//			return false;
//		}
//		// e��.ֻ�ܳ���1�� (���һλ�Ѿ���֮ǰ�������)
//		if (i != 0 && s.charAt(i) == 'e') {
//			if (already1e == true || s.charAt(i + 1) == '.') {
//				return false;
//			} else {
//				already1e = true;
//				alreadyDot = true;
//				char[] temp = s.toCharArray();
//				temp[i] = '0';
//				s = new String(temp);
//			}
//
//		}
//		if (i != 0 && s.charAt(i) == '.') {
//			if (alreadyDot == true) {
//
//				return false;
//			} else {
//
//				alreadyDot = true;
//				char[] temp = s.toCharArray();
//				temp[i] = '0';
//				s = new String(temp);
//
//			}
//		}
//
//		if (s.charAt(i) < '0' || s.charAt(i) > '9') {
//			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
//				if (s.charAt(i - 1) == 'e') {
//					continue;
//				}
//			}
//			return false;
//		}
//	}
//	System.err.print(s);
//	if (hasnumber == false) {
//		return false;
//	}
//	return true;
//}
