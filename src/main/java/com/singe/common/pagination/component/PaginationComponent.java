package com.singe.common.pagination.component;

import java.io.IOException;
import java.io.Writer;

/**
 * 分页组件接口
 * @author Singe
 *
 */
public interface PaginationComponent {

	void render(Writer writer) throws IOException;

}
