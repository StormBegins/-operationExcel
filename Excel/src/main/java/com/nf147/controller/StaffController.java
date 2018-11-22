package com.nf147.controller;

import com.nf147.dao.PersonnelMapper;
import com.nf147.entity.Personnel;
import com.nf147.entity.PersonnelList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class StaffController {

    @Autowired
    private PersonnelMapper personnelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String getFan(Model model, Personnel personnel, Locale locale) {
        personnel = new Personnel();
        List<Personnel> mappers = personnelMapper.selectAll();
        model.addAttribute("mappers", mappers);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(PersonnelList personnelList) {
        List<Personnel> personnels = personnelList.getPersonnels();
        for (Personnel personnel : personnels) {
            personnelMapper.insert(personnel);
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        personnelMapper.deleteByPrimaryKey(id);
        return "redirect:/";
    }
/*
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void excleFile(PersonnelList personnelList) throws IOException {

        personnelList.getPersonnels();

       */
/* HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("职工表");


        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = row.createCell(0);

        cell.setCellValue("hello sheet");

        FileOutputStream fos = new FileOutputStream(new File(""));

        try {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        workbook.close();

        fos.close();

        return "";*//*

    };
*/

    @RequestMapping(value = "/out",method = RequestMethod.POST)
    public String outExcleFile(String src){
        personnelMapper.selectby(src);
        return "redirect:/";
    };

    @RequestMapping(value = "/in",method = RequestMethod.POST)
    public String inExcleFile(String src){
      personnelMapper.daoru(src);
      return "redirect:/";
    };
}
