package com.linjia.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.Tags;
import com.linjia.web.query.TagsQuery;
import com.linjia.web.service.TagsService;

/**
 * 标签模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/tags")
public class TagsController extends BaseController {

	@Autowired
	private TagsService tagsService;

	/**
	 * 取得标签列表
	 * lixinling 
	 * 2016年11月23 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getTagsList(TagsQuery query, Model model) {
		if(!Tools.isEmpty(query.getName())){
			query.setNameQuery("%"+query.getName()+"%");
		}
		List<Tags> tagsList = tagsService.selectAllTagsByPage(query);
		
		//查询列表总数量
		Long pnums = tagsService.countByExample(query);
		model.addAttribute("query",query);
		model.addAttribute(tagsList);
		model.addAttribute("pnums",pnums);

		return "tags/tags_list";
	}

	/**
	 * 添加标签
	 * lixinling 
	 * 2016年11月23日 下午2:23:04
	 * @param tags
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addTagsInfo(Tags tags, Model model) {
		if (tags == null || Tools.isEmpty(tags.getName()) || Tools.isEmpty(tags.getType())) {
			model.addAttribute("message", "请填写正确的标签名称和类型");
			return "tags/tags_add";
		}
		try {
			tags.setDeleted(false);
			tagsService.insert(tags);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "tags/tags_add";
		}
		return "redirect:/tags/select";
	}

	/**
	 * 跳转到添加标签页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param tags
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "tags/tags_add";
	}

	/**
	 * 删除标签
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param tags
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteTags")
	public String deleteTags(String tagsIds, Model model) {
		if (tagsIds == null) {
			model.addAttribute("message", "请选择要删除的标签");
			return "tags/tags_list";
		}
		try {
			String[] tagsIdArray = tagsIds.split(",");
			for (String tagsId : tagsIdArray) {
				tagsService.delete(Long.valueOf(tagsId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "tags/tags_list";
		}
		return "redirect:/tags/select";
	}

	/**
	 * 跳转到编辑标签页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param tags
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "tags/tags_list";
		}
		Tags tags = tagsService.selectById(id);
		model.addAttribute("tags", tags);
		return "tags/tags_edit";
	}

	/**
	 * 编辑标签
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param tags
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editTagsInfo(Tags tags, Model model) {
		if (tags == null || Tools.isEmpty(tags.getName()) || Tools.isEmpty(tags.getType())) {
			model.addAttribute("message", "请填写正确的标签名称和类型");
			return "tags/tags_edit";
		}
		try {
			tagsService.update(tags);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "tags/tags_edit";
		}
		return "redirect:/tags/select";
	}
}
