
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
//You can use this function to implement your manual testing
	    UrlValidator urlValNull = new UrlValidator();
      assertNotNull(UrlValidator.getInstance());
      String[] schemes = {"http", "gopher"};
      UrlValidator urlValNull02 = new UrlValidator(schemes);
      assertNotNull(urlValNull);
      UrlValidator urlValNull03 = new UrlValidator(1);
      assertNotNull(urlValNull03);

     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     //UrlValidator urlVal = new UrlValidator(null, allowAllSchemes);
     assertTrue(urlVal.isValid("http://www.google.com"));
     assertTrue(urlVal.isValid("http://www.google.com/"));
     try{
     RegexValidator authorityValidator = new RegexValidator("http");
     UrlValidator urlVal01 = new UrlValidator(authorityValidator,1);
     assertNotNull(urlVal01);
   }catch(IllegalArgumentException e){};
   }
   public void testManualTest02(){
     String[] schemes = {"http", "https", "ftp"};
     UrlValidator urlVal = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES + 1);
     //UrlValidator urlVal = new UrlValidator(null, allowAllSchemes);
     assertEquals(false, urlVal.isValid("http://www.google.com"));
     assertEquals(false, urlVal.isValid("http://www.google.com/"));
     assertFalse(urlVal.isValid("w2w.ggg.com"));
   }


   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
   UrlValidator urlVal01 = new UrlValidator();
   assertFalse(urlVal01.isValid(null));
   assertFalse(urlVal01.isValid("w2w.ggg.com"));
   String[] schemes = {"http", "https", "ftp"};
   UrlValidator urlVal02 = new UrlValidator(schemes,UrlValidator.ALLOW_ALL_SCHEMES);
   assertFalse(urlVal02.isValid(" "));
   assertFalse(urlVal02.isValid("http://www.google.com:"));
   assertFalse(urlVal01.isValid("##:"));
   assertFalse(urlVal01.isValid("qwe:++"));
   assertFalse(urlVal02.isValid("##:"));
   //assertFalse(urlVal02.isValid("ftp://www.google.com:"));
   // assertFalse(urlVal02.isValid("www.google.com"));
   // assertTrue(urlVal02.isValid("www.google.com"));
   // assertFalse(urlVal02.isValid("file:"));
   // assertFalse(urlVal02.isValid("file://www.google.com:"));
   String[] schemes01 = {"http","https"};
       UrlValidator urlValidator = new UrlValidator(schemes01, UrlValidator.NO_FRAGMENTS);
       assertFalse(urlValidator.isValid("http://www.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.logoworks.comwww.log"));
       assertTrue(urlVal02.isValid("http://www.google.com"));
       assertTrue(urlVal02.isValid("http://w2w.ggg.com"));
       assertTrue(urlVal02.isValid("http://w2w.ggg.com/html"));
       assertTrue(urlVal02.isValid("http://w2w.ggg.com"));
       assertFalse(urlVal02.isValid("http://w2w.ggg.com:80"));
       assertFalse(urlVal02.isValid("http://ggg.com:80"));
       assertFalse(urlVal02.isValid("http://w2w.ggg.com/article/html:80"));
       assertTrue(urlVal02.isValid("http://baidu"));
       assertTrue(urlVal02.isValid("http://html/"));
   }

   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     assertEquals(false, urlVal.isValidScheme(null));
     assertEquals(false, urlVal.isValidScheme("!@#$%^&*"));
     // long val = 2 & 1;
     // long val2 = 0 & 1;
     // System.out.println("2 & 1" + val);
     // System.out.println("0 & 1" + val2);
     //
     String[] schemes = {"HTTP", "https", "ftp"};
     UrlValidator urlVal2 = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES);
     assertEquals(true, urlVal2.isValidScheme("HTTP"));
     assertEquals(true, urlVal2.isValidScheme("https"));
     UrlValidator urlVal3 = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES + 1);
     urlVal3.isValidScheme("https");
     urlVal3.isValidScheme("HTTPS");
     assertEquals(false, urlVal3.isValid(null));
     String[] schemes2 = {"HTTPwww", "https", "ftp"};
     UrlValidator urlVal4 = new UrlValidator(schemes2, null, UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlVal.isValid("http://www.google.com"));
     assertEquals(false, urlVal4.isValid("HTTP"));
     assertEquals(false, urlVal4.isValid("HTTPwww"));
     assertEquals(false, urlVal4.isValid("https"));
     UrlValidator urlVal5 = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES + 1);
     urlVal5.isValidScheme("https");
     urlVal5.isValidScheme("HTTPS");
     //
     //
     UrlValidator urlVal6 = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES);
     String str = null;
     // assertEquals(false, urlVal5.isValid(null));
     // assertEquals(false, urlVal5.isValidPath(null));
     assertEquals(false, urlVal6.isValid(".."));
     assertEquals(false, urlVal6.isValid("/~"));
     int num = 1 << 1;
     System.out.println("1<<1" + num);
     UrlValidator urlVal7 = new UrlValidator(null, null, 1);
     assertEquals(false, urlVal7.isValid("^(/[-\\w:@&"));
     assertEquals(false, urlVal7.isValid("~"));
     assertEquals(false, urlVal7.isValid("/~"));
     assertEquals(false, urlVal7.isValidPath(null));
     assertEquals(false, urlVal7.isValid("http://www.google.com/~"));
     assertEquals(true, urlVal7.isValid("http://www.google.com"));
     assertEquals(true, urlVal7.isValid("http://www.google.com/"));
     assertEquals(false, urlVal7.isValidPath("http://www.google.com/../"));
     assertEquals(false, urlVal7.isValidPath("//"));
     // UrlValidator urlVal7 = new UrlValidator(null, null, 2);
     // assertEquals(false, urlVal7.isValidPath("http://www.google.com//"));
     // assertEquals(false, urlVal7.isValidPath("//"));
     UrlValidator urlVal8 = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES);
     assertEquals(true, urlVal8.isValidQuery("http://www.google.com/"));
     assertEquals(false, urlVal8.isValid("http://www.google.com/:80/test1?action=view"));
     assertEquals(false, urlVal8.isValid("http://www.google.com/:80/test1?action=edit&mode=up"));
     assertEquals(false, urlVal8.isValid("http://www.google.com/:80/test1"));
     assertEquals(true, urlVal8.isValidQuery("http://www.google.com/"));
     assertEquals(true, urlVal8.isValidFragment("http://www.google.com/"));
     assertEquals(1, urlVal8.countToken("http://www.google.com/", "http://www.google.com/"));
   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing
     boolean printStatus = true;
     if (printStatus) {
        System.out.print("\n testIsValidScheme() ");
     }
     String[] schemes = {"http", "gopher"};
     //UrlValidator urlVal = new UrlValidator(schemes,false,false,false);
     UrlValidator urlVal = new UrlValidator(schemes, 0);
     for (int sIndex = 0; sIndex < testScheme.length; sIndex++) {
        ResultPair testPair = testScheme[sIndex];
        boolean result = urlVal.isValidScheme(testPair.item);
        System.out.println("testPair.item: " + testPair.item);
        System.out.println("testPair.valid: " + testPair.valid);
        System.out.println("testPair.result: " + result);
        //assertEquals(testPair.item, testPair.valid, result);
        if (printStatus) {
           if (result == testPair.valid) {
              System.out.print('.');
           } else {
              System.out.print('X');
           }
        }
     }
     if (printStatus) {
        System.out.println();
     }
     //Unit Test without opening flag
     assertEquals(false, urlVal.isValid("http://www.google.com/:80/test1?~action=view"));
     assertEquals(false, urlVal.isValid("www.google.com/:80/test1?action=view"));
     assertEquals(false, urlVal.isValid("http://google.com/"));
     assertEquals(false, urlVal.isValid("go.com/:80/test1?action=view"));
     assertEquals(false, urlVal.isValid("go.com/"));
     assertEquals(false, urlVal.isValid("0.0.0.0"));
     assertEquals(false, urlVal.isValid("ftp://0.0.0.0"));
     assertEquals(false, urlVal.isValid("ftp://0.0.0.0/:3000/?action=edit&mode=up"));
     assertEquals(false, urlVal.isValid("file://0.0.0.0"));
     assertEquals(false, urlVal.isValid("aaa."));
     assertEquals(false, urlVal.isValid("http://aaa."));
     assertEquals(false, urlVal.isValid("ftp://aaa.:"));
   }
   ResultPair[] testScheme = {new ResultPair("http", true),
                         new ResultPair("ftp", false),
                         new ResultPair("httpd", false),
                         new ResultPair("telnet", false)};

}
