package com.nf147.controller;


import com.nf147.dao.PersonnelMapper;
import com.nf147.entity.Personnel;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Excle {


    @Autowired
    private PersonnelMapper staffMapper;

    @GetMapping("/Export")
    public String Export() throws IOException {
        List<Personnel> staffs = new ArrayList<>();
        FileInputStream file = new FileInputStream("e:/员工.xls");
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        HSSFRow hssfRow = null;

        for(int i=1;i<=lastRowNum ;i++){
            hssfRow = (HSSFRow) sheet.getRow(i);

            staffs.add(new Personnel(
                    (int)hssfRow.getCell(0).getNumericCellValue(),
                    hssfRow.getCell(1).toString(),
                    hssfRow.getCell(2).toString(),
                    hssfRow.getCell(3).toString(),
                    hssfRow.getCell(4).getNumericCellValue()
            ));
        }
        staffMapper.add(staffs);
        file.close();
        return "redirect:/";
    }
    @GetMapping("/Import")
    public String Import() throws IOException {
        // 计数
        int count = 0;
        // 查询数据库的数据
        List<Personnel> staffs = staffMapper.selectAll();
        // 在内存中创建一个Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 创建工作簿
        HSSFSheet sheet = hssfWorkbook.createSheet();
        // 创建标题行表
        HSSFRow titlerRow = sheet.createRow(count);
        titlerRow.createCell(0).setCellValue("员工编号");
        titlerRow.createCell(1).setCellValue("员工姓名");
        titlerRow.createCell(2).setCellValue("员工性别");
        titlerRow.createCell(3).setCellValue("员工学历");
        titlerRow.createCell(4).setCellValue("员工薪资");
        //创建数据行
        for (Personnel staff : staffs){
            count++;
            HSSFRow titlerow = sheet.createRow(count);
            titlerow.createCell(0).setCellValue(staff.getId());
            titlerow.createCell(1).setCellValue(staff.getName());
            titlerow.createCell(2).setCellValue(staff.getSex());
            titlerow.createCell(3).setCellValue(staff.getEducation());
            titlerow.createCell(4).setCellValue(staff.getWages());
        }
        //获取输出流对象
        File file = new File("e:/员工.xls");
        file.createNewFile();
        FileOutputStream stream = FileUtils.openOutputStream(file);
        //写出文件，关闭流
        hssfWorkbook.write(stream);
        hssfWorkbook.close();

        return "redirect:/";
    }

}
