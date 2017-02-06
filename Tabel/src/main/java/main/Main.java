package main;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


public class Main {
    public static void main (String [] args){
        String FILE_NAME = getProperty("path_to_file");

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            int day = 1000 * 60 * 60 * 24;
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
            SimpleDateFormat week = new SimpleDateFormat("E");
            Date curDate = new Date();
            String curDateStr = format.format(curDate);
            Date prevDate;
            if(week.format(curDate).equals("пн")){
                prevDate = new Date(curDate.getTime() - 3*day);
            }
            else {
                prevDate = new Date(curDate.getTime() - day);
            }
            String prevDateStr = format.format(prevDate);

            boolean previousDay = false;
            boolean currentDay = false;

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                int column = 0;

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if(currentDay && column==1 && currentCell.toString().equals("")){
                        currentCell.setCellValue(generateCurrentTime());
                    }

                    if(previousDay && column==2 && currentCell.toString().equals("")){
                        currentCell.setCellValue(generateEndTime());
                    }

                    if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {

                        System.out.print(currentCell.getStringCellValue() + " | ");
                    } else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        String xlsDateStr = format.format(currentCell.getDateCellValue());
                        if(xlsDateStr.equals(prevDateStr)) {
                            previousDay = true;
                        }
                        else previousDay = false;
                        if(xlsDateStr.equals(curDateStr)) {
                            currentDay = true;
                        }
                        System.out.print(currentCell.getNumericCellValue() + " | ");
                    }
                    column++;
                }
                System.out.println();
                if(currentDay)
                    break;
            }
            FileOutputStream out = new FileOutputStream(new File(FILE_NAME));

            workbook.write(out);
            out.close();
            System.out.println(FILE_NAME + " written successfully on disk.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("H:mm");
        Date curDate =  new Date();
        String curDateStr = format.format(curDate);
        double curDateD = Double.parseDouble(curDateStr.split(":")[0])*12 + Double.parseDouble(curDateStr.split(":")[1])/5;
        int hours = (int) (curDateD/12);
        int minutes = (int) (curDateD - 12 * hours)*5;
        curDateStr = Integer.toString(hours) + ":" +
                (Integer.toString(minutes).length()==1?
                        "0" + Integer.toString(minutes):
                        Integer.toString(minutes));
        return curDateStr;
    }

    private static String generateEndTime(){
        double rand = Math.random();
        if(rand<0.4) return "18:00";
        else if(rand<0.6) return "18:15";
        else if(rand<0.8) return "18:10";
        else if(rand<0.9) return "18:05";
        else if(rand<0.95) return "18:20";
        else if(rand<0.99) return "18:25";
        else return "18:30";
    }

    public static String getProperty(String propName){
        FileInputStream fileInputStream;
        java.util.Properties prop = new java.util.Properties();

        try {
            fileInputStream = new FileInputStream("data.ini");
            prop.load(fileInputStream);
            return prop.getProperty(propName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
