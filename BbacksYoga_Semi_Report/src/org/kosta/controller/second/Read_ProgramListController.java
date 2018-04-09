package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.ProgramDAO;
import org.kosta.model.VO.ListVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.etc.PagingBean;

public class Read_ProgramListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int count = ProgramDAO.getInstance().getProgramListTotal();
		String pno = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if(pno==null) {
			pagingBean = new PagingBean(count);
		}
		else {
			pagingBean = new PagingBean(count, Integer.parseInt(pno));
		}
		ArrayList<ProgramVO> list = ProgramDAO.getInstance().getProgramList(pagingBean);
		ListVO listVO = new ListVO(list, pagingBean);
		request.setAttribute("lvo", listVO);
		request.setAttribute("url", "/Class/ProgramList.jsp");
		return  "Template/layout.jsp";
	}

}
