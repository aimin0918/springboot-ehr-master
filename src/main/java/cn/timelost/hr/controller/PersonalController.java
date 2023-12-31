package cn.timelost.hr.controller;

import cn.timelost.hr.service.PersonalService;
import cn.timelost.hr.vo.PersonalSelectVo;
import cn.timelost.hr.vo.PersonalVo;
import cn.timelost.hr.vo.ResultVo;
import cn.timelost.hr.vo.input.PersonalForm;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/personal/list")
    public PageInfo<PersonalVo> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "departmentId", defaultValue = "0") Integer departmentId,
                                     @RequestParam(value = "personalName", required = false) String personalName,
                                     @RequestParam(value = "workStatus", defaultValue = "0") Integer workStatus) {
        return personalService.findAll(page, size, departmentId, personalName, workStatus);
    }

    @GetMapping("/personal/all")
    public List<PersonalVo> all() {
        return personalService.All();
    }
    
    @GetMapping("/personal/select")
    public List<PersonalSelectVo> findSelect() {
        return personalService.findSelect();
    }

    @GetMapping("/personal/{id}")
    public PersonalVo findById(@PathVariable Integer id) {
        return personalService.find(id);
    }

    @PostMapping("/personal")
    @RequiresRoles("admin")
    public ResultVo insert(@RequestBody @Valid PersonalForm personalForm) {
        personalService.insert(personalForm);
        return ResultVo.success();
    }

    @PutMapping("/personal/{id}")
    @RequiresRoles("admin")
    public ResultVo update(@RequestBody PersonalForm personalForm, @PathVariable Integer id) {
        personalService.updateById(id, personalForm);
        return ResultVo.success();
    }

    @DeleteMapping("/personal/{id}")
    @RequiresRoles("admin")
    public ResultVo delete(@PathVariable Integer id) {
        personalService.deleteById(id);
        return ResultVo.success();
    }

    @DeleteMapping("/personal")
    @RequiresRoles("admin")
    public ResultVo deleteIdIn(@RequestBody Set<Integer> id) {
        personalService.deleteByIdIn(id);
        return ResultVo.success();
    }
}
