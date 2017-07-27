package com.sigal.common.pagination.component;

import java.io.IOException;
import java.io.Writer;

/**
 * 分页组件接口
 * @author LOMI
 *
 */
public interface PaginationComponent {

	void render(Writer writer) throws IOException;

}
