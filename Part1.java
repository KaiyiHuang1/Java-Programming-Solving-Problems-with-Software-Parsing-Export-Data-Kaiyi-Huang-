
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public String countryInfo(CSVParser parser, String country){
        String Info="NOT FOUND";
        for(CSVRecord record : parser){
            String countryFinder = record.get("Country");
            if(countryFinder.contains(country)){
                System.out.print(record.get("Country") + ": ");
                System.out.print(record.get("Exports") + ": ");
                System.out.println(record.get("Value (dollars)"));
                Info = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                return Info;
            }
        }
        return Info;
    }
    
    public void countryInfo(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String exportFinder = record.get("Exports");
            if(exportFinder.contains(exportItem1) && exportFinder.contains(exportItem2)){
                System.out.println(record.get("Country") +"have "+ exportItem1 + exportItem2);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int exportCount = 0;
        for(CSVRecord record : parser){
            String exportFinder = record.get("Exports");
            if(exportFinder.contains(exportItem)){
                exportCount ++;
                System.out.println("exportCount: " + exportCount);
            }
        }
        return exportCount;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String exportAmount = record.get("Value (dollars)");
            if(exportAmount.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country + exportAmount);
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //String Info = countryInfo(parser, "Nauru");
        //System.out.println(Info);
        String exportItem1 = "gold";
        String exportItem2 = "diamonds";
        countryInfo(parser, exportItem1,exportItem2);
        //int numberofexports = numberOfExporters(parser, exportItem1);
        //System.out.println("There are " + numberofexports+ " countries export " + exportItem1);
        //bigExporters(parser, "$999,999,999,999");
    }

}
