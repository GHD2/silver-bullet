package com.silverbullet.auth.controller;

import com.silverbullet.auth.domain.SysAuthActionTree;
import com.silverbullet.auth.service.ISysAuthActionTreeService;
import com.silverbullet.utils.BaseDataResult;
import com.silverbullet.core.validate.AddValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限定义 控制器
 * Created by jeffyuan on 2018/2/11.
 */
@Controller
@RequestMapping(value = "/auth/sysauthactiontree")
public class SysAuthActionTreeController {

    @Autowired
    private ISysAuthActionTreeService sysAuthActionTreeService;

    @RequestMapping(value = "/list/pub.html", method = RequestMethod.GET)
    public ModelAndView index(){
        int nCurPage = 1;

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/SysAuthActionTree/list");

        BaseDataResult<SysAuthActionTree> results = sysAuthActionTreeService.list(nCurPage, 5);

        modelAndView.addObject("results", results);
        modelAndView.addObject("curPage", nCurPage);

        return modelAndView;
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.POST)
    public ModelAndView listData(String curpage){
        int nCurPage = 1;
        if (curpage != null) {
            nCurPage = Integer.valueOf(curpage);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/SysAuthActionTree/listContent");

        BaseDataResult<SysAuthActionTree> results = sysAuthActionTreeService.list(nCurPage, 5);

        modelAndView.addObject("results", results);
        modelAndView.addObject("curPage", nCurPage);

        return modelAndView;
     }

    @RequestMapping(value = "/add.html", method = RequestMethod.POST)
    public String add(Model model) {
        return "/SysAuthActionTree/model";
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.POST)
    public String edit(Model model, String id) {
        SysAuthActionTree sysAuthActionTree = sysAuthActionTreeService.getOneById(id);
        model.addAttribute("obj", sysAuthActionTree);

        return "/SysAuthActionTree/model";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        Map<String,Object> mapRet = new HashMap<String, Object>();
        if (ids == null || ids.isEmpty()) {
            mapRet.put("result", false);
            return mapRet;
        }

        boolean bRet = sysAuthActionTreeService.delete(ids);

        mapRet.put("result", bRet);
        return mapRet;
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@Validated({AddValidate.class}) SysAuthActionTree sysAuthActionTree,
                                    BindingResult result) {
        Map<String,Object> mapRet = new HashMap<String, Object>();
        if (result.hasErrors()) {
            mapRet.put("result", false);
            mapRet.put("errors", result.getFieldErrors());
            return mapRet;
        }

        boolean bTrue = false;
        String message = "";
        if (sysAuthActionTree.getId().isEmpty()) {
            bTrue = sysAuthActionTreeService.Insert(sysAuthActionTree);
            message = bTrue ? "添加成功！" : "添加失败！";
        } else {
            bTrue = sysAuthActionTreeService.Update(sysAuthActionTree);
            message = bTrue ? "修改成功！" : "修改失败！";
        }

        mapRet.put("result", bTrue);
        mapRet.put("message", message);

        return mapRet;
    }
}
