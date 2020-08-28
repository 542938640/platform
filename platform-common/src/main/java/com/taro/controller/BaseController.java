package com.taro.controller;import java.util.List;import java.util.Map;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestParam;import com.baomidou.mybatisplus.core.metadata.IPage;import com.taro.constant.Constants;import com.taro.constant.RequestConstants;import com.taro.entity.IdEntity;import com.taro.service.BaseService;import com.taro.utils.MyStringUtil;import com.taro.vo.dto.PageResultsDTO;import com.taro.vo.dto.ResultsDTO;public abstract class BaseController<T extends IdEntity> {	protected abstract BaseService<T> getService();	public Map<String, Object> decode(Map<String, Object> param){		return param;	}		protected void selectBefore(Map<String, Object> param){		param = decode(param);	};		protected void selectByIdBefore(String id){};	protected void insertBefore(T model){};	protected void updateBefore(T model){};		protected void saveBefore(T model){		if(MyStringUtil.isBlank(model.getId())) {			insertBefore(model);		}else {			updateBefore(model);		}	};		protected void deleteByIdBefore(String id){};		protected void deleteBatchIdsBefore(List<String> idList){};		@GetMapping(value = "/selectPage", produces = RequestConstants.JSON_UTF_8)	public String selectPage(@RequestParam Map<String, Object> param,			@RequestParam(value = Constants.PAGE_NUM, defaultValue = Constants.PAGE_NUM_DEFAULT_VALUE) int pageNum,			@RequestParam(value = Constants.PAGE_SIZE, defaultValue = Constants.PAGE_SIZE_DEFAULT_VALUE) int pageSize){		selectBefore(param);		IPage<T> iPage = getService().selectPage(pageNum, pageSize, param);		return new PageResultsDTO(iPage).toJson();	}	@GetMapping(value = "/selectList", produces = RequestConstants.JSON_UTF_8)	public String selectList(@RequestParam Map<String, Object> param){		selectBefore(param);		List<T> list = getService().selectList(param);		return new ResultsDTO(list).toJson();	}	@GetMapping(value = "/selectById", produces = RequestConstants.JSON_UTF_8)	public String selectById(@RequestParam(value = "id") String id){		selectByIdBefore(id);		T model = getService().selectById(id);		return new ResultsDTO(model).toJson();	}		@PostMapping(value = "/insert", consumes = RequestConstants.JSON_UTF_8)	public String insert(@RequestBody T model) {		insertBefore(model);		model = getService().insert(model);		return new ResultsDTO(model).toJson();	}	@PutMapping(value = "/updateById", consumes = RequestConstants.JSON_UTF_8)	public String updateById(@RequestBody T model) {		updateBefore(model);		model = getService().updateById(model);		return new ResultsDTO(model).toJson();	}	@PostMapping(value = "/save", consumes = RequestConstants.JSON_UTF_8)	public String save(@RequestBody T model) {		saveBefore(model);		model = getService().save(model);		return new ResultsDTO(model).toJson();	}		@DeleteMapping(value = "/deleteById", produces = RequestConstants.JSON_UTF_8)	public String deleteById(@RequestParam(value = "id") String id){		deleteByIdBefore(id);		getService().deleteById(id);		return new ResultsDTO("删除成功").toJson();	}		@DeleteMapping(value = "/deleteBatchIds", produces = RequestConstants.JSON_UTF_8)	public String deleteBatchIds(@RequestBody List<String> idList){		deleteBatchIdsBefore(idList);		int num = getService().deleteBatchIds(idList);		return new ResultsDTO("删除" + num + "条记录").toJson();	}}