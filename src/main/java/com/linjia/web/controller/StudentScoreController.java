package com.linjia.web.controller;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.Specialty;
import com.linjia.web.model.StudentScore;
import com.linjia.web.poi.Common;
import com.linjia.web.poi.ReadExcel;
import com.linjia.web.query.SpecialtyQuery;
import com.linjia.web.query.StudentScoreQuery;
import com.linjia.web.service.SpecialtyService;
import com.linjia.web.service.StudentScoreService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 学生成绩模块
 *
 * @author lixinling
 */
@Controller
@RequestMapping("/studentScore")
public class StudentScoreController extends BaseController {

    @Autowired
    private StudentScoreService studentScoreService;

    /**
     * 取得科目列表
     * lixinling
     * 2016年8月22日 下午2:23:04
     *
     * @param query
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/select")
    public String getStudentScoreList(StudentScoreQuery query, Model model, String message) throws UnsupportedEncodingException {

        List<StudentScore> studentScoreList = studentScoreService.selectBySerach(query);

        //查询列表总数量
        int pnums = studentScoreService.countByExample(query);
        model.addAttribute("query", query);
        model.addAttribute(studentScoreList);
        model.addAttribute("pnums", pnums);
        if (!Tools.isEmpty(message))
            model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

        return "student_score/student_score_list";
    }

    /**
     * 导入学生成绩信息
     * lixinling
     * 2016年10月21日 下午10:23:04
     * @param file
     * @return
     */
    @RequestMapping(value = "/importStudentScore")
    @ResponseBody
    public Object importStudentScore(HttpServletRequest request, MultipartFile file) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        if (file != null) {

            // 文件名
            String fileName = file.getOriginalFilename();

            // 后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(Common.POINT) + 1);
            if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {
                try {
                    StringBuilder repeatData = new StringBuilder();
                    List<StudentScore> list = readXls(file.getInputStream(),repeatData);
                    if (list != null && list.size() > 0) {
                        studentScoreService.insertBatch(list);
                    }

                    String repeatStr = ", 发现重复数据信息：";
                    if (repeatData.length() > 0) {
                        String tempStr = repeatData.toString().substring(0, repeatData.lastIndexOf(","));
                        repeatStr += tempStr;
                    }
                    resMap.put("message", "导入成功" + list.size() + "条" + repeatStr);
                } catch (Exception e) {
                    resMap.put("message", "导入失败  ");
                    logger.info("导入失败。");
                    e.printStackTrace();
                }
            } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(suffix)) {
                resMap.put("message", "请下载模板进行导入，暂不支持xlsx类型文件导入。");
                logger.info("导入失败。请下载模板进行导入，暂不支持xlsx类型文件导入。");
                // 预留
                // readXlsx(file.getInputStream());
            } else {
                resMap.put("message", "导入失败。选择的文件格式不正确。");
                logger.info("导入失败。选择的文件格式不正确。");
            }

        } else {
            resMap.put("message", "导入失败。请选择正确的文件进行导入。");
            logger.info("导入失败。请选择正确的文件进行导入。");
        }

        return resMap;
    }

    public List<StudentScore> readXls(InputStream is, StringBuilder repeatData) throws Exception {
        List<StudentScore> list = new ArrayList<StudentScore>();
        if (is == null) {
            logger.info("==========》导入文件流为空。");
            return list;
        } else {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

            // 读取sheet
            for (int sheetNum = 0; sheetNum < hssfWorkbook.getNumberOfSheets(); sheetNum++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNum);
                if (hssfSheet == null)
                    continue;

                // 读取Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow == null || hssfRow.getCell(0) == null) {
                        continue;
                    } else {
                        HSSFCell candidateNumCell = hssfRow.getCell(0);
                        HSSFCell candidateNameCell = hssfRow.getCell(1);
                        HSSFCell sexCell = hssfRow.getCell(2);
                        HSSFCell collegeNameCell = hssfRow.getCell(3);
                        HSSFCell specialtyNameCell = hssfRow.getCell(4);
                        HSSFCell scoreCell = hssfRow.getCell(5);

                        String candidateNum = candidateNumCell == null ? null : String.valueOf(ReadExcel.getValue(candidateNumCell)) ;
                        String collegeName = collegeNameCell == null ? null : String.valueOf(ReadExcel.getValue(collegeNameCell)) ;
                        String specialtyName = specialtyNameCell == null ? null : String.valueOf(ReadExcel.getValue(specialtyNameCell)) ;

                        if(Tools.isEmpty(candidateNum))
                            continue;

                        // 验证此考号candidateNum在此学校此专业是否已经存在
                        int count = studentScoreService.checkSameData(Long.valueOf(candidateNum),collegeName,specialtyName);
                        if (count > 0) {
                            repeatData.append(candidateNum).append(":").append(collegeName).append(":").append(specialtyName).append(",");
                            continue;
                        }
                        String candidateName = candidateNameCell == null ? null :  ReadExcel.getValue(candidateNameCell)+"";
                        String sex = sexCell == null ? null : ReadExcel.getValue(sexCell)+"";
                        BigDecimal score = scoreCell == null ? null : new BigDecimal(ReadExcel.getValue(scoreCell)+"");

                        StudentScore studentScore = new StudentScore();
                        studentScore.setCandidateNum(Long.valueOf(candidateNum));
                        studentScore.setCandidateName(candidateName == null ? null : candidateName.trim());
                        studentScore.setSex(sex == null ? null : (sex.equals("女") ? 1 : 0));
                        studentScore.setCollegeName(collegeName == null ? null : collegeName.trim());
                        studentScore.setSpecialtyName(specialtyName == null ? null : specialtyName.trim());
                        studentScore.setScore(score);

                        list.add(studentScore);
                    }
                }
            }

            return list;
        }

    }


}
