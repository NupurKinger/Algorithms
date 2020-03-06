
public class DecimalToBinary {
	public static void main(String[] args) {
	  printBinary("2.9");	
	}
	
	private static void printBinary(String n) {
		int n1 = Integer.parseInt(n.substring(0, n.indexOf(".")));
		double n2 = Double.parseDouble(n.substring(n.indexOf("."), n.length()));
		
		String intPart = "";
		while (n1 > 0) {
			int r = n1 % 2;
			intPart = r + intPart;
			n1 >>= 1;
		}
		
//		String decimalPart = "";
		StringBuffer dec_string = new StringBuffer();
		while (n2 > 0) {
			if (n2 == 1) {
				dec_string.append((int)n2);
				break;
			}
			double r = n2 * 2;
			if (r >= 1) {
				dec_string.append(1);
				n2 = r - 1;
			} else {
				dec_string.append(0);
				n2 = r;
			}
		}
		
		
		System.out.println(intPart + "." + dec_string);
	}
}
