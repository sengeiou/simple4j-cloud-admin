package com.simple4j.system.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 客户端表删除请求实体类
 *
 * @author hyc
 * @since 2020-08-26
 */
@Data
@ApiModel(value = "客户端表删除请求实体类", description = "客户端表删除请求实体类")
public class ClientRemoveRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 客户端表删除编号列表
	 */
	@ApiModelProperty(value = "客户端表删除编号列表", name = "ids")
	@JsonProperty("ids")
	private List<String> ids;
}
