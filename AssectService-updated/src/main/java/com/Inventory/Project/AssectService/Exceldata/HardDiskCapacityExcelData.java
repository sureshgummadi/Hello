package com.Inventory.Project.AssectService.Exceldata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.Inventory.Project.AssectService.Dao.HardDiskCapacityDao;
import com.Inventory.Project.AssectService.Dao.HardDiskTypeMasterDao;
import com.Inventory.Project.AssectService.Exception.HardDiskCapacityNotFoundException;
import com.Inventory.Project.AssectService.Model.HardDiskCapacity;
import com.Inventory.Project.AssectService.Model.HardDiskTypeMaster;

@Component
public class HardDiskCapacityExcelData {

	@Autowired
	private Environment environment;
	@Autowired
	private HardDiskTypeMasterDao hardDiskTypeMasterDao;
	@Autowired
	private HardDiskCapacityDao hardDiskCapacityDao;

	@SuppressWarnings("resource")
	public ByteArrayInputStream exportingHardDiskCapacityDataToExcelFile(List<HardDiskCapacity> harddiskcapacity)
			throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("HardDiskCapacity");

		XSSFCellStyle headercellstyle = workbook.createCellStyle();
		headercellstyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headercellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headercellstyle.setAlignment(HorizontalAlignment.GENERAL.CENTER);

		Row row = sheet.createRow(0);

		/* SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy"); */

		String string = environment.getProperty("harddiskcapacity.table.columns");
		String[] split = string.split(",");
		Cell cell = null;
		for (int i = 0; i < split.length; i++) {

			cell = row.createCell(i);
			cell.setCellStyle(headercellstyle);
			cell.setCellValue(split[i]);
		}
		for (int i = 0; i < harddiskcapacity.size(); i++) {

			Row datarow = sheet.createRow(i + 1);

			datarow.createCell(0).setCellValue(harddiskcapacity.get(i).isHarddiskCapacityStatus());
			datarow.createCell(1).setCellValue(harddiskcapacity.get(i).getHarddiskCapacityType());

		}

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		/*
		 * sheet.autoSizeColumn(2); sheet.autoSizeColumn(3); sheet.autoSizeColumn(4);
		 */

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		return new ByteArrayInputStream(outputStream.toByteArray());

	}

	public String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	String SHEET = "HardDiskCapacityt";

	public boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public List<HardDiskCapacity> readingHarddiskDataFromExcel(InputStream is)
			throws HardDiskCapacityNotFoundException {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet("HardDiskCapacity");
			Iterator<Row> rows = sheet.iterator();

			ArrayList<HardDiskCapacity> brands = new ArrayList<HardDiskCapacity>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				java.util.Iterator<Cell> cellsInRow = currentRow.iterator();

				HardDiskCapacity harddisk1 = new HardDiskCapacity();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						String stringCellValue = currentCell.getStringCellValue();
						HardDiskTypeMaster harddisk = hardDiskTypeMasterDao.findByHardDiskType(stringCellValue);
						if (harddisk == null) {
							throw new HardDiskCapacityNotFoundException("Hrad disk capacity not found");
						}
						Set<HardDiskTypeMaster> harddisktype = new HashSet<>();
						harddisktype.add(harddisk);
						harddisk1.setCapacities(harddisktype);

						break;

					case 1:
						harddisk1.setHarddiskCapacityType(currentCell.getStringCellValue());
						break;
					

					default:
						break;
					}
					cellIdx++;
				}
				brands.add(harddisk1);
			}

			workbook.close();
			return brands;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}

	}

	public ByteArrayInputStream dummyHardDiskCapcityExcelFile() throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("HardDiskCapacity");

		XSSFCellStyle headercellstyle = workbook.createCellStyle();
		headercellstyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headercellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headercellstyle.setAlignment(HorizontalAlignment.GENERAL.CENTER);
		CreationHelper creationHelper = workbook.getCreationHelper();
		Row row = sheet.createRow(0);

		String string = environment.getProperty("harddiskcapacity.table.columns");
		String[] split = string.split(",");
		Cell cell = null;
		for (int i = 0; i < split.length; i++) {

			cell = row.createCell(i);
			cell.setCellStyle(headercellstyle);
			cell.setCellValue(split[i]);
		}
		DataValidation dataValidation = null;
		DataValidationConstraint constraint = null;
		DataValidationHelper validationHelper = null;

		List<HardDiskTypeMaster> list = hardDiskTypeMasterDao.findAll();

		String[] array = list.stream().map(harddisk -> harddisk.getHardDiskType()).toArray(String[]::new);
		validationHelper = new XSSFDataValidationHelper(sheet);
		CellRangeAddressList addressList = new CellRangeAddressList(1, 1, 0, 0);
		constraint = validationHelper.createExplicitListConstraint(array);
		dataValidation = validationHelper.createValidation(constraint, addressList);
		dataValidation.setSuppressDropDownArrow(true);
		sheet.addValidationData(dataValidation);

		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return new ByteArrayInputStream(outputStream.toByteArray());

	}

	public ByteArrayInputStream dummyHardDiskCapacityExcelFile1() throws IOException {
		DataValidation dataValidation = null;
		DataValidationConstraint constraint = null;
		DataValidationHelper validationHelper = null;

		List<HardDiskTypeMaster> harddisktypes = hardDiskTypeMasterDao.findAll();

		String[] hardDiskTypesArray = harddisktypes.stream().map(hardDiskType -> hardDiskType.getHardDiskType())
				.toArray(String[]::new);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = (XSSFSheet) workbook.createSheet("hard Disk Capacity");

		XSSFCellStyle headercellstyle = workbook.createCellStyle();
		headercellstyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headercellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headercellstyle.setAlignment(HorizontalAlignment.GENERAL.CENTER);

		validationHelper = new XSSFDataValidationHelper(sheet);
		String string = environment.getProperty("harddiskcapacity.table.columns");
		String[] split = string.split(",");
		Cell cell = null;
		Row row = sheet.createRow(0);
		for (int i = 0; i < split.length; i++) {

			cell = row.createCell(i);
			cell.setCellStyle(headercellstyle);
			cell.setCellValue(split[i]);
			sheet.autoSizeColumn(i);
		}

		CellRangeAddressList addressList = new CellRangeAddressList(1, 100, 0, 0);
		constraint = validationHelper.createExplicitListConstraint(hardDiskTypesArray);
		dataValidation = validationHelper.createValidation(constraint, addressList);
		dataValidation.setSuppressDropDownArrow(true);
		sheet.addValidationData(dataValidation);

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);

		Row createRow = sheet.createRow(1);
		Cell cell2 = createRow.createCell(4);
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		cell2.setCellValue(date);

		Cell cell3 = createRow.createCell(6);
		String pattern1 = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
		String date1 = simpleDateFormat1.format(new Date());
		cell3.setCellValue(date1);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		return new ByteArrayInputStream(outputStream.toByteArray());

	}
}
