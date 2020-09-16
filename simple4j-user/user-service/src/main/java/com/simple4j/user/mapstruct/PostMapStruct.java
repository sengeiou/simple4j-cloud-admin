package com.simple4j.user.mapstruct;

import java.util.List;

import com.simple4j.user.base.Page;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.simple4j.user.entity.Post;
import com.simple4j.user.request.PostAddRequest;
import com.simple4j.user.request.PostUpdateRequest;
import com.simple4j.user.response.PostDetailResponse;

/**
 * 岗位表数据转换类
 *
 * @author Blade
 * @since 2020-08-25
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapStruct {

	/**
	 * VO转PO
	 *
	 * @param vo
	 * @return
	 */
	Post toPo(PostAddRequest vo);

	/**
	 * VO转PO
	 *
	 * @return
	 * @vo vo
	 */
	Post toPo(PostUpdateRequest vo);

	/**
	 * PO转VO
	 *
	 * @param po
	 * @return
	 */
	PostDetailResponse toVo(Post po);

	/**
	 * PO转VO
	 *
	 * @param po
	 * @return
	 */
	List<PostDetailResponse> toVo(List<Post> po);


	/**
	 * 分页转换PO转VO
	 *
	 * @param po
	 * @return
	 */
	Page<PostDetailResponse> toVo(Page<Post> po);
}