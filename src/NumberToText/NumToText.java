package NumberToText;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.*;
public class NumToText {
	private int num;
	private String NumToText[] = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười"};
	private int l_devider[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, Integer.MAX_VALUE};
	private String text_devider[] = {"mươi", "trăm", "ngàn", "mươi", "trăm", "triệu", "mươi","trăm", "tỷ"};
	public NumToText() {}
	
	public NumToText(int num)
	{
		this.setNum(num);
	}
	public int getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTextFromNum()
	{
		
		int index = -1;
		for (int i = 0; i < l_devider.length; i++)
		{
			if (num < l_devider[i])
			{
				index = i - 1;
				break;
			}
		}
		if (index == -1) {
			return NumToText[num];
		}
		else {
			String result = "";
			while (num != 0 && index != -1)
			{
				int devider = l_devider[index];
				int quotient = num / devider;
				int remainder = num % devider;
				result += NumToText[quotient] + " " + text_devider[index] + " ";
				num = remainder;
				index--;
//				System.out.println(result);
//				System.out.println(num);
			}
			if (num != 0 ) {
				result += NumToText[num];
			}
			Map<String, String> exceptions = new HashMap<String, String>();
			exceptions.put("không trăm không mươi không (ngàn|triệu|tỷ)", "");
			exceptions.put("không mươi", "linh");
			exceptions.put("một mươi", "mười");
			exceptions.put("không triệu", "triệu");
			exceptions.put("không ngàn", "ngàn");
			exceptions.put("\\s+", " ");
			exceptions.put("mươi một", "mươi mốt");
			for (Entry<String, String> entry : exceptions.entrySet()){
				result = result.replaceAll(entry.getKey(), entry.getValue());
			}
			
			return result.trim();
		}
		//return null;
	}
}
