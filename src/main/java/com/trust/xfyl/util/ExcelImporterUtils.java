package com.trust.xfyl.util;

import com.trust.xfyl.dao.FoodSugarMapper;
import com.trust.xfyl.model.po.FoodSugar;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 控糖饮食数据导入到数据库，读取Excel文件
 *
 * @author Bay-max
 * @date 2024/5/16 12:13
 */
public class ExcelImporterUtils {
    private static final Logger LOGGER = Logger.getLogger(ExcelImporterUtils.class.getName());

    private static FoodSugarMapper foodSugarMapper;
    private static SqlSessionFactory factory;

    /**
     * ExcelImporter 构造函数
     *
     * @param factory SqlSessionFactory对象，用于操作MyBatis的会话工厂
     * @param foodSugarMapper FoodSugarMapper对象，用于操作数据库的接口
     */
    public ExcelImporterUtils(SqlSessionFactory factory, FoodSugarMapper foodSugarMapper) {
        ExcelImporterUtils.factory = factory;
        ExcelImporterUtils.foodSugarMapper = foodSugarMapper;
    }

    /**
     * 从指定的文件路径导入控糖饮食数据到数据库
     *
     * @param filePath 要导入的Excel文件的路径
     * @return 返回导入的数据列表，如果发生错误则返回空列表
     */
    public static List<FoodSugar> importData(String filePath) {
        List<FoodSugar> foodSugars = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheetAt(0);

            // 从第三行开始读取数据，跳过标题行
            for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                // 忽略空行
                if (row == null) {
                    continue;
                }
                FoodSugar foodSugar = new FoodSugar();
                populateFoodSugar(row, foodSugar);
                foodSugars.add(foodSugar);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error reading Excel file: " + filePath, e);
            return new ArrayList<>();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error occurred during Excel import: " + filePath, e);
            return new ArrayList<>();
        }
        return foodSugars;
    }

    /**
     * 根据Excel表格的行数据填充FoodSugar对象
     *
     * @param row Excel表格的一行数据
     * @param foodSugar 要填充数据的FoodSugar对象
     */
    private static void populateFoodSugar(Row row, FoodSugar foodSugar) {
        // 填充FoodSugar对象的属性值
        foodSugar.setFoodName(safeGetStringValue(row.getCell(1)));
        foodSugar.setEdiblePart(safeGetStringValue(row.getCell(2)));
        foodSugar.setEnergy(safeGetStringFromNumeric(row.getCell(3)));
        foodSugar.setWater(safeGetStringFromNumeric(row.getCell(4)));
        foodSugar.setProtein(safeGetStringFromNumeric(row.getCell(5)));
        foodSugar.setFat(safeGetStringFromNumeric(row.getCell(6)));
        foodSugar.setDietaryFiber(safeGetStringFromNumeric(row.getCell(7)));
        foodSugar.setCarbohydrate(safeGetStringFromNumeric(row.getCell(8)));
        foodSugar.setVitaminA(safeGetStringFromNumeric(row.getCell(9)));
        foodSugar.setVitaminB1(safeGetStringFromNumeric(row.getCell(10)));
        foodSugar.setVitaminB2(safeGetStringFromNumeric(row.getCell(11)));
        foodSugar.setNiacin(safeGetStringFromNumeric(row.getCell(12)));
        foodSugar.setVitaminE(safeGetStringFromNumeric(row.getCell(13)));
        foodSugar.setSodium(safeGetStringFromNumeric(row.getCell(14)));
        foodSugar.setCalcium(safeGetStringFromNumeric(row.getCell(15)));
        foodSugar.setIron(safeGetStringFromNumeric(row.getCell(16)));
        foodSugar.setCategory(safeGetStringValue(row.getCell(17)));
        foodSugar.setVitaminC(safeGetStringFromNumeric(row.getCell(18)));
        foodSugar.setCholesterol(safeGetStringFromNumeric(row.getCell(19)));
        foodSugar.setIsDelete("0");
        foodSugar.setCreateTime(new Date());
    }


    /*
     * TODO // 从单元格安全获取字符串值
     *
     * @Description
     * @author Bay-max
     * @date 2024/5/20 10:00
     **/

    private static String safeGetStringValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.STRING) {
            return "";
        }
        return cell.getStringCellValue();
    }
    /*
     * TODO // 从单元格安全获取数字并转换为字符串
     *
     * @Description
     * @author Bay-max
     * @date 2024/5/20 10:00
     **/

    private static String safeGetStringFromNumeric(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return "";
        }
        BigDecimal value = BigDecimal.valueOf(cell.getNumericCellValue());
        // 保留两位小数
        String s = value.setScale(2, RoundingMode.HALF_UP).toString();

        return s;
    }
}
