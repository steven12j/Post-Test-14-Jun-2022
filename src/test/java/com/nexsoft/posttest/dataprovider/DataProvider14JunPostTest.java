package com.nexsoft.posttest.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import com.github.hemanthsridhar.ExcelUtils;

public class DataProvider14JunPostTest {

	@DataProvider(parallel = false)
    public Object[][] getPostTestData() throws Exception {
        ExtUtils ext = new CSVUtils(getPathOfTheFile("dataPostTestBiodata.csv"),true);
        return ext.parseData();
    }
	
	/**
     * Excel workbook name with the TestNG test method names which will be fetched during runtime where the sheetname is by default Sheet1
     */
    @DataProvider
    public Object[][] excelSheetDataRead(Method methodName) throws Exception {
        ExtUtils ext = new ExcelUtils(getPathOfTheFile(methodName.getName() + ".xlsx"));
        return ext.parseData();
    }

    /**
     * Sheet names with the TestNG test method names which will be fetched during runtime.
     */
    @DataProvider(parallel = true)
    public Object[][] singleExcelMultipleSheets(Method methodName) throws Exception {
        ExtUtils ext = new ExcelUtils(getPathOfTheFile("GoogleTestData.xlsx"),methodName.getName());
        return ext.parseData();
    }

    /**
     * Read data from a CSV file.
     */
    @DataProvider(parallel = true)
    public Object[][] csvDataReadWithColumnHeaders() throws Exception {
        ExtUtils ext = new CSVUtils(getPathOfTheFile("random_comma_seperated_value.csv"), true);
        return ext.parseData();
    }


    @DataProvider(parallel = true)
    public Object[][] csvDataReadWithoutColumnHeaders() throws Exception {
        ExtUtils ext = new CSVUtils(getPathOfTheFile("random_csv_no_headers.csv"));
        return ext.parseData();
    }

    /**
     * Get file from src/test/resources
     */
    String getPathOfTheFile(String fileName) throws Exception {
        String path;
        try {
            path = getClass().getClassLoader().getResource(fileName).getPath();
        } catch (NullPointerException e) {
            throw new Exception("External TestNG dataprovider file not found");
        }
        return path;
    }
	
}
