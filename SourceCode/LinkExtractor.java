
import java.util.ArrayList;
import java.util.regex.*;
import java.net.URL;


public class LinkExtractor {
		
	public static void main(String ar[]) throws Exception {
		
		//mass of output data
		ArrayList <Histogram> histogramMass = new ArrayList <Histogram>();
		
		//creating input data
		String[] testStringMass = new String [10];
		/*testStringMass [0] = "http://myname:mypass@myhost.com:21/etc/motd";
		testStringMass [1] = " http://symfony.com/doc/current/book/installation.html " + 
		" http://symfony.com/doc/current/book/ins?tallation.html" + " gfdfmgfl " + 
		"http://symfony.com/on.html";
		testStringMass [2] = "http://www.symfony-project.org/jobeet/1_4/Doctrine/ru/16";*/
		/*testStringMass [3] = "http://www.javaportal.ru/java/articles/regexp.html";
		testStringMass [4] = "http://topcode.ru/2009/12/02/10-regulyarnyx-vyrazhenij-kotorye-budut-polezny-kazhdomu-java-programmistu/";
		testStringMass [5] = "ru.wikipedia.org";
		testStringMass [6] = "http://www.javenue.info/post/43";
		testStringMass [7] = "http://www.symfony-project.org/plugins/sfDoctrineGuardPlugin";
		testStringMass [8] = "http://www.simplecoding.org/analiz-dannyx-s-pomoshhyu-regulyarnyx-vyrazhenij-ili-bystryj-sposob-proverki-vvedennyx-dannyx.html";
		testStringMass [9] = "http://docs.oracle.com/javase/1.4.2/docs/api/java/util/regex/Matcher.html";*/
		//end of creating input data
		
		//test for linkPreprocessor 
		//testStringMass [1] = "";
		//testStringMass [1] = null;
		//testStringMass [1] = "   ";
		/*histogramMass = linkPreprocessor (testStringMass[1]);
		for (Histogram elem: histogramMass){
			System.out.println(elem.text + " " + elem.count);
		}*/
		
		//test for linksDistance
		//System.out.println(linksDistance("http://symfony.com/doc/current/book/installation.html/", "http://symfony.com/doc"));
		//System.out.println(linksDistance("http://symfony.com/doc/", "http://symfony.com/doc"));
		/*String temp = null;
		System.out.println(temp);*/
		/*String myHtmlAHttpTagPattern = "http://[a-z]+.{1}[a-z]+.{1}[a-z]+(:\\d+)?/[a-z/\\d.]*"; --old
		String myHtmlAHttpsTagPattern = "https://[a-z]+.{1}[a-z]+.{1}[a-z]+(:\\d+)?/[a-z/\\d.]*"; --old
		Pattern http_pattern = Pattern.compile(myHtmlAHttpTagPattern);
		Pattern https_pattern = Pattern.compile(myHtmlAHttpsTagPattern);*/
		/*Matcher m = html_pattern.matcher(testStringMass[0]);
		System.out.println(m.matches());*/
		//String string = "http://www.playframework.org/documentation/1.2.4/ide";
		/*int count = 3;
		int i = 0;
		String string1 = null;
		System.out.println(getClearLink(testStringMass));*/
		
		//test for compareLinks
		//System.out.println(compareLinks(string,string+"fdsfdcxc"));
		
		//test for preprocessor with three links on closest distance
		testStringMass [0] = "http://www.symfony.com/doc/current/book/";
		testStringMass [1] = "https://symfony.com";
		testStringMass [2] = "http://symfony.com/doc/current/book/installation.html";
		testStringMass [3] = "https://www.symfony.com/doc/current/book/installation.html";
		testStringMass [4] = "https://symfony.com/doc/current/book/installation.html";
		testStringMass [5] = "https://www.symfony.com:234/doc/current/book/installation.html";
		testStringMass [6] = "https://twitter.com/#!/FakeTSR";
		Histogram h = new Histogram(testStringMass[0]);
		System.out.println(h.link.toString());
		Histogram b = new Histogram(testStringMass[6]);
		System.out.println(b.link.toString());
		
		/*String urlRegexp = "(http|https|HTTP|HTTPS)://([\\w]+(:[\\w]+)?@)?([a-z]+\\.)?[a-z]+(\\.){1}[a-z]{2,3}+(:\\d+)?" +
				"/?[/\\.a-zA-Z\\d\\?%=&_\\-#!]*";
		Pattern http_pattern = Pattern.compile(urlRegexp);
		Matcher m = http_pattern.matcher(testStringMass[2]);
		System.out.println(m);*/
		/*for (int i = 0; i < 7; i++) {
			//System.out.println(testStringMass[i] + " - " + http_pattern.matcher(testStringMass[i]).matches());
			System.out.println(testStringMass[i] + " - " + getFirstAndSecondLinkDomain(testStringMass[i]));
		}*/
		/*histogramMass = linkPreprocessor (testStringMass[0] + " " + testStringMass[1] + " " + testStringMass[2] + " " 
		+ testStringMass[3] + " " + testStringMass[4] + " " + testStringMass[5] + " " + testStringMass[6], 3);
		for (Histogram elem: histogramMass){
				System.out.println(elem.text + " " + elem.count);
		}*/		
	}
	private  static ArrayList<Histogram> linkPreprocessor (String inputString, int maxLength)
	{
		String [] slicedStringMass = null;
		
		//Dividing input string into words
		slicedStringMass = separateTokens(inputString);
		//порезали входную строку на отдельные группы символов, взяв за разделители пробелы
		
		//////////////////////////////
		//It's just copied Julia code from word extractor with some refactoring
		String urlRegexp = "(http|https|HTTP|HTTPS)://([\\w]+(:[\\w]+)?@)?([a-z]+\\.)?[a-z]+(\\.){1}[a-z]{2,3}+(:\\d+)?" +
				"/?[/\\.a-zA-Z\\d\\?%=&_\\-#!;:@]*";
		Pattern urlPattern = Pattern.compile(urlRegexp);
		
		ArrayList <String> linkList = new ArrayList<String>();

		//добавление в список ссылок без протокола
		if(slicedStringMass != null) {
		    for(int i = 0; i < slicedStringMass.length; i++) {
		    	if (urlPattern.matcher(slicedStringMass[i]).matches()){
		    		linkList.add(deleteScheme(slicedStringMass [i]));
		    	}
		    }
		}
		if (linkList.size() == 0){
			ArrayList<Histogram> nullValue = null;
			return nullValue;
		}
		//загоняем в список слов только слова из порезанной строки, которые соответсвтуют html-шаблону
		
		//создаём и инициализируем первый элемент выходного массива
		ArrayList<Histogram> histogramMass = new ArrayList<Histogram>();
		Histogram elem = new Histogram(linkList.get(0).intern());
		elem.count++;
		histogramMass.add(elem);
		//удаляем первую ссылку, т.к. её уже рассмотрели
		linkList.remove(0);
		
		boolean linkAdded = false;
		for (String currentLink: linkList){
		    for (Histogram currentHistogram: histogramMass){
		        if ((currentHistogram.text == null ? currentLink== null : 
		        	(getFirstAndSecondLinkDomain(currentHistogram.link).equals(getFirstAndSecondLinkDomain(currentLink))
		        		&& linksDistance(currentLink, currentHistogram.link) <= maxLength))) {
		        	currentHistogram.count++;
		        	linkAdded = true;
		        }
		    }
		    if (!linkAdded) {
		    	Histogram newHistogramRecord = new Histogram();
		    	newHistogramRecord.count++;
		    	newHistogramRecord.text = currentLink.intern();
		        histogramMass.add(newHistogramRecord);
		    }
		    linkAdded = false;
		}
		//It's end of copied Julia code from word extractor
		return histogramMass;
	}

	private static String [] separateTokens (String inputString){
		String [] outputString = null;
		if (inputString != null && !inputString.equals("")){
			outputString = inputString.split("\\s");
		}
		return outputString;
	}
	
	private static String deleteScheme (String inputUrl) {
		String outputUrl = (inputUrl.matches("http://.*")?
				inputUrl.substring(7, inputUrl.length()):
					inputUrl.substring(8, inputUrl.length()));
		return outputUrl;
	}
	
	//получает строку. Если в ней есть три слеша, то возвращает все символы до третьего слеша включительно, иначе - null
	private  static String getFirstAndSecondLinkDomain (String inputString) throws Exception {
		//all work is with url as www.blablabla.com/blablabla?&*^%#$
		if (inputString != null){
			String clearLink = null;
			int lastPositionDomainSymbol;
			
			//first occurs of slash symbol
			int firstSlashOccurs = inputString.indexOf('/');
			
			//search of ":" for port number
			int positionPortColonSymbol = inputString.indexOf(':');
			if (firstSlashOccurs != -1) {
				if (positionPortColonSymbol != -1 &&
						positionPortColonSymbol > firstSlashOccurs ) {
					positionPortColonSymbol = -1;
				}
			}
			lastPositionDomainSymbol = (positionPortColonSymbol == -1 ?
					(firstSlashOccurs != -1 ?
							firstSlashOccurs :
								inputString.length()):
						positionPortColonSymbol);
			//check, that url domain contain two dots
			int positionFirstDot = inputString.indexOf('.');
			boolean twoDotsIs =
					((inputString.substring(positionFirstDot, lastPositionDomainSymbol).indexOf('.') != -1) ?
							true:
								false);
			//search of 
			clearLink = inputString.substring(0, lastPositionDomainSymbol);
			return clearLink;
		}
		return null;
		//return inputString;
	}
	private  static int linksDistance (String link1, String link2) {
		String bigLink, smallLink;
		
		/*if (link1 == null || link2 == null ||
				link1 == "" || link2 == "") {
			return -1;
		}*/
		
		if (link1.length() >= link2.length()) {
			bigLink = link1.intern();
			smallLink = link2.intern();
		}
		else {
			bigLink = link2.intern();
			smallLink = link1.intern();
		}
		//search of domain end in first and second link
		
		if (bigLink.substring(0, 4).equals("http:")) {
			bigLink = bigLink.substring(7, bigLink.length() - 1);
		}
		else {
			bigLink = bigLink.substring(8, bigLink.length() - 1);
		}
		
		if (smallLink.substring(0, 4).equals("http:")) {
			smallLink = smallLink.substring(7, smallLink.length() - 1);
		}
		else {
			smallLink = smallLink.substring(8, smallLink.length() - 1);
		}
		
		int distance = 0, linksDifferencesPosition = 0;
		//поиск позиции строки, в которой строки начинают различаться
		for (; bigLink.charAt(linksDifferencesPosition) == smallLink.charAt(linksDifferencesPosition) &&
				linksDifferencesPosition < (smallLink.length() - 1); linksDifferencesPosition++);
		
		//поиск расстояния между ссылками
		for (int curPosition = linksDifferencesPosition; curPosition < bigLink.length(); curPosition++) {
			if (bigLink.charAt(curPosition) == '/' && ((bigLink.length() - curPosition) != 1)){
				distance++;
			}
		}
		return distance;
	}
	//получает две ссылки, сравнивает их начальные домены - если до слеша их символы совпадают, то возвращает true
	private  static boolean compareLinks (String link1, String link2){
		String clearLink1 = getFirstAndSecondLinkDomain(link1), clearLink2 = getFirstAndSecondLinkDomain(link2);
		if (clearLink1.length() != clearLink2.length()){
			return false;
		}
		for (int curPosition = 0; curPosition < clearLink1.length(); curPosition++){
			if (clearLink1.charAt(curPosition) != clearLink2.charAt(curPosition)){
				return false;
			}
		}
		return true;
	}
	
	private static int getFirstPositionDomainSymbol (String inputString, int lastPositionPortSymbol) {
		int firstPositionDomainSymbol;
		for (firstPositionDomainSymbol = lastPositionPortSymbol;
				inputString.charAt(firstPositionDomainSymbol) != '@' 
						&& inputString.charAt(firstPositionDomainSymbol) != '/';
				firstPositionDomainSymbol--);
		return ++firstPositionDomainSymbol;
	}	
	private static int getLastPositionDomainSymbol (String inputString, int lastPositionPortSymbol) {
		//search of position first port symbol position
		int firstPositionPortSymbol = getFirstPositionPortSymbol (inputString, lastPositionPortSymbol);
		
		return /*lastPositionDomainSymbol = */firstPositionPortSymbol - 1;
	}
	
	private static int getFirstPositionPortSymbol (String inputString, int lastPositionPortSymbol) {
		int firstPositionPortSymbol;
		for (firstPositionPortSymbol = lastPositionPortSymbol;
				String.valueOf(inputString.charAt(firstPositionPortSymbol)).matches("[0-9]");
				firstPositionPortSymbol--);
		return firstPositionPortSymbol;
	}
	
	private static int getLastPositionPortSymbol (String inputString) {
		int firstSlashOccurs = inputString.indexOf('/');
		String str = (inputString.matches("http://")?
				inputString.substring(7, inputString.length() - 1):
					inputString.substring(8, inputString.length() - 1));
		//search of ":" for port number
		int firstPositionPortSymbol;
		for (firstPositionPortSymbol = firstSlashOccurs + 3;
				firstPositionPortSymbol < inputString.length()
				&& inputString.charAt(firstPositionPortSymbol) != '/'
				&& inputString.charAt(firstPositionPortSymbol) != ':';
				firstPositionPortSymbol++);
		//search of domain or port end symbol position
		int lastPositionPortSymbol;
		for (lastPositionPortSymbol = firstSlashOccurs + 3;
				lastPositionPortSymbol < inputString.length()
						&& inputString.charAt(lastPositionPortSymbol) != '/';
				lastPositionPortSymbol++);
		return ((lastPositionPortSymbol < inputString.length() || inputString.charAt(lastPositionPortSymbol) != '/')
				?
						-1
						:
							--lastPositionPortSymbol);
	}

}