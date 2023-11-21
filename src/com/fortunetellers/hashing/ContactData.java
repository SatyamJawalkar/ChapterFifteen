package com.fortunetellers.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
	private static final String phoneData = """
			Charlie Brown, 3334445555
			Maid Marion, 1234567890
			Mickey Mouse, 9998887777
			Mickey Mouse, 1247489758
			Minnie Mouse, 4567805666
			Robin Hood, 5647893000
			Robin Hood, 7899028222
			Lucy Van Pelt, 5642086852
			Mickey Mouse, 9998887777
			""";

	private static final String emailData = """
			Mickey Mouse, mckmouse@gmail.com
			Mickey Mouse, micky1@aws.com
			Minnie Mouse, minnie@verizon.net
			Robin Hood, rhood@gmail.com
			Linus Van Pelt, lvpelt2015@gmail.com
			Daffy Duck, daffy@google.com
			""";

	public static List<Contacts> getData(String type) {
		List<Contacts> dataList = new ArrayList<>();

		Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
		while (scanner.hasNext()) {
			String[] dataString = scanner.nextLine().split(",");
			Arrays.asList(dataString).replaceAll(String::trim);
			if (type.equals("phone")) {
				dataList.add(new Contacts(dataString[0], Long.parseLong(dataString[1])));
			}
			else if(type.equals("email")){
				dataList.add(new Contacts(dataString[0],dataString[1])); 
			}
		}
		return dataList;
	}
}
