package org.example;

import BaseLayer.AndroidBaseClass;
import com.google.common.primitives.Ints;
import io.appium.java_client.MobileElement;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

public class locatorsAndMethods extends AndroidBaseClass {

    public String googleNewsTitle = "//android.widget.FrameLayout[@resource-id=\"com.google.android.apps.magazines:id/header_bar_logo\"]";
    public String search="//*[@content-desc=\"Search\"]";
    public String searchBar="com.google.android.apps.magazines:id/open_search_view_edit_text";
    public String test="//*[contains(@text,\"5th Test, Dhar\")]";
    public String scorecard="//*[@content-desc=\"Scorecard\"]";
    public String text="Proteas win by innings and 32 runs";

    String notification="//*[@text='Allow Google News to send you notifications?']";

    public void clickElements(String Locator)
    {
        driver.findElement(By.xpath(Locator)).click();
        System.out.println("Click on element");
    }
//    public void clickWebElements(String Locator)
//    {
//        WebElement element=driver.findElement(By.xpath(Locator));
//        element.click();
//        System.out.println("Click on web element");
//    }

    public boolean isElementDisplay(String locator)
    {
//        System.out.println("Element is displayed");
        boolean present=driver.findElement(By.xpath(locator)).isDisplayed();
       return present;

    }
    public boolean isElementPresent(String locator){

        try{
            //return WebDriverUtils.get().getWebDriver().client.isElementFound("NATIVE", xpath, 0);
            return driver.findElement(By.xpath(locator)).isDisplayed();
        }
        catch (InternalException e){
            log.info("Exception in \"isElementPresent\": " + e.getMessage());
            return false;
        }
    }
    public void clickNotification()
    {
//        boolean notificationDisplay=isElementDisplay("//*[@text='Allow']");
        System.out.println(isElementDisplay("//*[@text='Allow Google News to send you notifications?']"));
        if(isElementPresent("//*[@text='Allow Google News to send you notifications?']")==true)
        {
            log.info("ENter in for loop");
            driver.switchTo().alert().accept();
            log.info("Click on alert massage");
        }
        else
        {
            System.out.println("Alert not present");
        }
    }
    public void sendkeys(String xpath, String text)
    {
        WebElement e=driver.findElement(By.id(xpath));
        e.sendKeys(text);
        wait(1000);
//        e.sendKeys(Keys.ENTER);
    }
    public void scrollAndClickOnElement(String Text)
    {
        MobileElement scrollableElement = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+Text+"\").instance(0))");
        scrollableElement.click();
    }
    public void scrollWhileElementNotVisible(String Text)
    {
        MobileElement scrollableElement = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+Text+"\").instance(0))");

    }
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            log.info("ALERT IS PRESENT !! ");
            return true;
        } catch (Exception e) {
            log.info("ALERT IS NOT PRESENT !! ");
            return false;
        }
    }

    public void mobileAlertHandle() {
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
        else
        {
            log.info("ALERT IS NOT PRESENT !!");
        }
    }


    @Test
    public void program()
    {

           int [] a={1,1100,45,20,56,89,20,2,58,89};

           for(int i=1;i<a.length;i=i+2)
           {
               System.out.println(a[i]);
           }
    }
    public static int removeDuplicateElements(int arr[], int n){

        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }

    @Test
    public static void main () {
        String s="Geeksforgeeks";
        String a=s.toLowerCase();

        String [] r=a.split("");
        Map<String , Integer> map=new HashMap<String , Integer>();

        for(String c:r)
        {
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            if(entry.getValue()==1) {
                System.out.println(entry.getKey());
            }
        }

    }
    @Test
    public static void removeDuplicateElement(){

        int a[] = {10,20,20,20,30,30,40,50,50};
        int n = a.length;
        int j = 0;//for next element
        for (int i=0; i < n-1; i++){
            if (a[i] != a[i+1]){
                a[j++] = a[i];
            }
        }
        a[j++] = a[n-1];
        for (int i=0; i<j; i++)
        {
            System.out.print(a[i]+" ");
    }
    }
@Test
    public void programArray()
{
    int a[]={1,2,2,3,4,5,5,6,8,9,9,10};
    int n=a.length;
    int j=0;
    for(int i=0;i<n-1;i++)
    {
        for(int t=i+1;t<n-1;t++) {
            if (a[i] != a[t]) {
                a[j++] = a[i];
            }
        }
    }
    a[j++]=a[n-1];
    for(int i=0;i<j;i++)
    {
        System.out.println(a[i]+",");
    }
}

@Test
public void removeDupliacte()
{
    int [] a={1,1,2,3,3,4,3,4,5,6,7,7,8,8,9,10,11,11};
    String s="GeeksforGeeks";
    char [] c=s.toCharArray();
    char temp;
    for(int i=0;i<c.length;i++)
    {
        for(int t=i+1;t<c.length;t++)
        {
            if(c[i]>c[t])
            {
                temp=c[i];
                c[i]=c[t];
                c[t]=temp;
            }
        }
        System.out.println(c[i]);
    }
    int n=c.length;
    int j=0;

    for(int i=0;i<n-1;i++)
    {
        if(c[i]!=c[i+1])
        {
            c[j++]=c[i];
        }
    }
    c[j++]=c[n-1];
    for(int i=0;i<j;i++)
    {
        System.out.print(c[i]+",");
    }
}
@Test
    public void duplicateArray()
    {
        int a[]= {1,2,3,4,5,6,7,8,9,10,1,3,4,6,7,9,10,11,1,2,12,13,14,15,16,17,18,19,11,14,16,17,19};
        int temp;
        for(int i=0;i<a.length;i++)
        {
            for(int b=i+1;b<a.length;b++)
            {
                if(a[i]>a[b])
                {
                    temp=a[i];
                    a[i]=a[b];
                    a[b]=temp;
                }
            }
            System.out.print(a[i]+",");
        }
        System.out.println("\n After Remove duplicate ");

        int n=a.length;
        int j=0;

        for(int i=0;i<n-1;i++)
        {
            if(a[i]!=a[i+1])
            {
                a[j++]=a[i];
            }
        }
        a[j++]=a[n-1];
        for(int i=0;i<j;i++)
        {
            System.out.print(a[i]+",");
        }
    }

    @Test
    public void countPuntuation()
    {
        String s = "He said, 'The mailman loves you.' I heard it with my own ears.";
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==','||s.charAt(i)=='.'||s.charAt(i)=='\"'||s.charAt(i)=='\''||s.charAt(i)=='?'||s.charAt(i)==';')
            {

                count++;
            }
        }
        System.out.println("Total pun in given string is --> "+count);
    }

    @Test
    public void duplicateCharInSTring()
    {
//        String s="duplicateCharInSTring";
        String s="Rohit Rahul rahul Parag Hardik parag";
//        String r=s.toLowerCase();

//        char [] c=r.toCharArray();

        String [] c=s.split(" ");
        for(int i=0;i<c.length;i++)
        {
            for(int j=i+1;j<c.length;j++)
            {
                if(c[i].equalsIgnoreCase(c[j]))
                {
                    System.out.println(c[i]);
                }
            }
        }
    }

    @Test
    public void countCharInAllString()
    {
        String s = "Hardships often prepare ordinary people for an extraordinary destiny";
        String [] r=s.split(" ");
        for(String a:r)
        {
            int count=0;
//            char [] c=a.toCharArray();
            for(int i=0;i<a.length();i++)
            {
                if(a.charAt(i)!=' ')
                {
                    count++;
                }
            }
            System.out.println("Count of char in  "+a+" --> "+count);
        }
    }
@Test
    public void wordReverseByString()
    {
        String s = "Hardships often prepare ordinary people for an extraordinary destiny";
        String [] r=s.split(" ");
        for(String a:r)
        {
//            int count=0;
            char [] c=a.toCharArray();
            for(int i=c.length-1;i>=0;i--)
            {
                System.out.print(c[i]);
            }
            System.out.print(" ");
        }
    }

    @Test
    public void palindromeString()
    {
        String s="madam";
        String r=s;
//        String [] c=s.split("");

        char[] c=s.toCharArray();

        for(int i=c.length-1;i>=0;i--)
        {
            System.out.print(c[i]);
        }
        System.out.println(c);
        String t= Arrays.toString(c);

        if(s.equals(c))
        {
            System.out.println("This is palindrome string");
        }
        else System.out.println("This is not palindrome string");
    }
    @Test
    public void convertArrayIntoList()
    {
        int [] a={2,3,4,5,6,7,8,9};
        String [] s={"Rohit","Rahul", "Parag","Hardik"};

        ArrayList ar=new ArrayList(Arrays.asList(s));

       List arr=Arrays.asList(s);

           System.out.println(ar);
           ar.add("Gajya");
        ar.add("Kakya");
        System.out.println(ar);

        int[] intArray = {13, 17, 21, 23};
        ArrayList c=new ArrayList(Ints.asList(intArray));

        List<Integer> integerArray = Ints.asList(intArray);

        System.out.println(c);
    }

    @Test
   public void removeDUplicatesFromUnsortedArray()
   {
       int a[]={1,2,3,4,5,6,7,8,9,1,2,3,4,6,7,9};
       int n=a.length;
       
       int [] temp=new int [n];
       int j=0;
       
       for(int i=0;i<n-1;i++)
       {
           if(a[i]!=a[i+1])
           {
               temp[j++]=a[i];
           }
       }
       temp[j++]=a[n-1];

       for(int i=0;i<j;i++)
       {
           a[i]=temp[i];
       }

       for(int i=0;i<j;i++)
       {
           System.out.println(a[i]);
       }
   }
   @Test
    public static void removeDuplicateElements1()
    {
        int [] a={1,1,2,2,3,4,4,5,6,6,7,7,7,8,8,9,10,1,2,3,4,5,6};
        int temp;

        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        int n=a.length;
        int j=0;

        for(int i=0;i<n-1;i++)
        {
            if (a[i] != a[i+1])
            {
                a[j++]=a[i];
            }
        }
        a[j++]=a[n-1];
        for(int i=0;i<j;i++)
        {
            System.out.print(a[i]+" ");
        }

    }
    @Test
    public void copyArray()
    {
        int [] a={1,2,3,45,6,7,8};

        Map <Integer, Integer> map=new HashMap<Integer,Integer>();
        for(int c:a)
        {
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(entry.getValue()>=1)
            {
                System.out.println(entry.getKey()+ " --> "+entry.getValue());
            }
        }

    }
    @Test
    public void reverseArray()
    {
        int a[]={89,2,48,45,56,78,96,48,56,0,45,63};
        int n=a.length;
        int temp;
        for(int i=0;i<n;i++)
        {
            for(int t=i+1;t<n;t++)
            {
                if(a[i]>a[t])
                {
                    temp=a[i];
                    a[i]=a[t];
                    a[t]=temp;
                }
            }
        }
        int j=0;

        for(int i=0;i<n-1;i++)
        {
            if(a[i]!=a[i+1])
            {
                a[j++]=a[i];
            }
        }
        a[j++]=a[n-1];
        for(int i=0;i<j;i++)
        {
            System.out.print(a[i]+",");
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]%2==0)
            {
                System.out.println("This is even no -->"+a[i]);
            }
            else
            {
                System.out.println("This is odd no --> "+a[i]);
            }
        }
    }

}
