package com.simple4j.gen.mapstruct;

import java.util.List;

import com.simple4j.gen.entity.Code;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.simple4j.gen.request.CodeAddRequest;
import com.simple4j.gen.request.CodeAddOrUpdateRequest;
import com.simple4j.gen.request.CodeUpdateRequest;
import com.simple4j.gen.response.CodeDetailResponse;
import com.simple4j.api.base.Page;
/**
 * 代码生成表数据转换类
 *
 * @author Blade
 * @since 2020-09-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CodeMapStruct {

	/**
	 * VO转PO
	 *
	 * @param vo
	 * @return
	 */
	Code toPo(CodeAddRequest vo);

	/**
	 * VO转PO
	 *
	 * @param vo
	 * @return
	 */
	Code toPo(CodeAddOrUpdateRequest vo);

	/**
	 * VO转PO
	 *
	 * @vo vo
	 * @return
	 */
	Code toPo(CodeUpdateRequest vo);

	/**
	* PO转VO
	*
	* @param po
	* @return
	*/
	CodeDetailResponse toVo(Code po);

	/**
	* PO转VO
	*
	* @param po
	* @return
	*/
	List<CodeDetailResponse> toVo(List<Code> po);


	/**
	* 分页转换PO转VO
	* @param po
	* @return
	*/
	Page<CodeDetailResponse> toVo(Page<Code> po);
}