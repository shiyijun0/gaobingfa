package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.Util.PageParams;
import cn.bdqn.gaobingfa.aop.RoleService;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;
import cn.bdqn.gaobingfa.view.ExcelExportService;
import cn.bdqn.gaobingfa.view.ExcelView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/view")
public class ViewController {

	@Autowired
	private BehaviorRecordSyncMapperService behaviorRecordSyncMapperService;


	@Autowired
	private RoleService roleService = null;
	
	@RequestMapping("/showRoleJsonInfo")
	public ModelAndView showRoleJsonInfo(Long id, String roleName, String note) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("id", id);
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		return mv;
	}
	
	@RequestMapping("/addRole")
	//Model为重定向数据模型，Spring MVC会自动初始化它
	public String addRole(Model model, String roleName, String note) {
		/*Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		//插入角色后，会回填角色编号
		roleService.insertRole(role);*/
		//绑定重定向数据模型
		model.addAttribute("roleName", roleName);
		model.addAttribute("note", note);
		//model.addAttribute("id", role.getId());
		return "redirect:./showRoleJsonInfo.do";
	}
	
	@RequestMapping("/addRole2")
	//ModelAndView对象Spring MVC会自定初始化它
	public ModelAndView addRole2(ModelAndView mv, String roleName, String note) {
		/*Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		//插入角色后，会回填角色编号
		roleService.insertRole(role);*/
		//绑定重定向数据模型
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		//mv.addObject("id", role.getId());
		mv.setViewName("redirect:./showRoleJsonInfo.do");
		return mv;
	}
	
	
	/*@RequestMapping("/showRoleJsonInfo2")
	public ModelAndView showRoleJsonInfo(Role role) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}*/
	
	@RequestMapping("/addRole3")
	//RedirectAttribute对象Spring MVC会自动初始化它
	public String addRole3(RedirectAttributes ra, BehaviorRecordSync role) {
		//插入角色后，会回填角色编号
		//roleService.insertRole(role);
		//绑定重定向数据模型
		ra.addFlashAttribute("role", role);
		return "redirect:./showRoleJsonInfo2.do";
	}
	
	
	@RequestMapping("/getRole")
	public ModelAndView getRole(Long id) {
		//Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
	//	mv.addObject("role", role);
		return mv;
	}
	
	


	@RequestMapping(value = "/getRoleByModel", method = RequestMethod.GET)
	public ModelAndView getRoleByModel(@RequestParam("id") Long id, Model model) {
	    //Role role = roleService.getRole(id);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("roleDetails");
	    //model.addAttribute("role", role);
	    return mv;
	}

	@RequestMapping(value = "/getRoleByMv", method = RequestMethod.GET)
	public ModelAndView getRoleByMv(@RequestParam("id") Long id, ModelAndView mv) {
	    //Role role = roleService.getRole(id);
	    mv.setViewName("roleDetails");
	  //  mv.addObject("role", role);
	    return mv;
	}
	
	
	@RequestMapping(value = "/getRoleForJson", method = RequestMethod.GET)
	public ModelAndView getRoleForJson(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		//Role role = roleService.getRole(id);
		mv.setView(new MappingJackson2JsonView());
		//mv.addObject("role", role);
		return mv;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam("id") Long id, ModelMap model) {
	   // Role role = roleService.getRole(id);
	   // model.addAttribute("role", role);
	    return "roleDetails";
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView export() {
		//模型和视图
		ModelAndView mv = new ModelAndView();
		//Excel视图，并设置自定义导出接口
		ExcelView ev = new ExcelView(exportService());
		//文件名
		ev.setFileName("所有行为记录.xlsx");
		//设置SQL后台参数
		BehaviorRecordSync behaviorRecordSync = new BehaviorRecordSync();
		behaviorRecordSync.setCode("in");
		//限制1万条
		PageParams page = new PageParams();
		page.setStart(0);
		page.setLimit(100);
		behaviorRecordSync.setPageParams(page);
		//查询
		List<BehaviorRecordSync> list = behaviorRecordSyncMapperService.select(behaviorRecordSync);
		//加入数据模型
		mv.addObject("list", list);
		mv.setView(ev);
		return mv;
	}

	@SuppressWarnings({ "unchecked"})
	private ExcelExportService exportService() {
		//使用Lambda表达式自定义导出excel规则
		return (Map<String, Object> model, Workbook workbook) -> {
			//获取用户列表
			List<BehaviorRecordSync> roleList = (List<BehaviorRecordSync>) model.get("list");
			//生成Sheet
			Sheet sheet= workbook.createSheet("所有行为记录");
			//加载标题

			Row title = sheet.createRow(0);
			title.createCell(0).setCellValue("编号");
			title.createCell(1).setCellValue("编码");
			title.createCell(2).setCellValue("备注");
			//便利角色列表，生成一行行的数据
			for (int i=0; i<roleList.size(); i++) {
				BehaviorRecordSync role = roleList.get(i);
				int rowIdx = i + 1;
				Row row = sheet.createRow(rowIdx);
				row.createCell(0).setCellValue(role.getId());
				row.createCell(1).setCellValue(role.getCode());
				row.createCell(2).setCellValue(role.getNote());
			}
	    };
	}
}
