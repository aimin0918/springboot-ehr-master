package cn.timelost.hr.controller;

import cn.timelost.hr.pojo.PersonalSalary;
import cn.timelost.hr.service.PersonalSalaryService;
import cn.timelost.hr.vo.ResultVo;
import cn.timelost.hr.vo.input.PersonalSalaryForm;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
public class PersonalSalaryController {

    @Resource
    PersonalSalaryService personalSalaryService;

    @GetMapping("/salary/list")
    public PageInfo<PersonalSalary> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "departmentName", required = false) String departmentName,
                                         @RequestParam(value = "year", defaultValue = "0") Integer year,
                                         @RequestParam(value = "month", defaultValue = "0") Integer month,
                                         @RequestParam(value = "personalId", defaultValue = "0") Integer personalId) {
        return personalSalaryService.findAll(year, month, departmentName, personalId, page, size);
    }
    @GetMapping("/salary/all")
    public List<PersonalSalary> all() {
        return personalSalaryService.all();
    }

    @GetMapping("/salary/{id}")
    public PersonalSalary findById(@PathVariable Integer id) {
        return personalSalaryService.find(id);
    }

    @PostMapping("/salary")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid PersonalSalaryForm personalSalaryForm) {
        personalSalaryService.insert(personalSalaryForm);
        return ResultVo.success();
    }

    @PutMapping("/salary/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody @Valid PersonalSalaryForm personalSalaryForm, @PathVariable Integer id) {
        personalSalaryService.updateById(id, personalSalaryForm);
        return ResultVo.success();
    }

    @DeleteMapping("/salary/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        personalSalaryService.deleteById(id);
        return ResultVo.success();
    }

    @DeleteMapping("/salary")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        personalSalaryService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
