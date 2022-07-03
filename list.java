package com.eai.makeconfig.servlet;

import java.io.File;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eai.makeconfig.bean.InterfaceInfoBean;
import com.eai.makeconfig.dao.makeconfigDAO;
import com.eai.util.StringUtil;
import com.eai.db.QueryEntity;

import config._01_insertDBInterfaceInfo_tmp;
import config._02_insertDBNewInterfaceInfo;
import config._03_createNewCommonConfigFile_D;
import config._04_createFileConfig;
import config._05_createFepPutGet_D_NEW;
import config._06_createFepFtePut_D;
import config._07_createEaiGet_NEW;
import config._08_ScriptCreate;
import config._09_rcp;
import config._11_commitIntfInfo;

import config._10_executeReload;
import config_M._01_insertDBInterfaceInfo_tmp_M;

import config_M._02_insertDBNewInterfaceInfo_M;
import config_M._03_createNewCommonConfigFile_M;
import config_M._04_createFileConfig_M;
import config_M._05_createFepPutGet_M;
import config_M._06_createFepFtePut_M;
import config_M._07_createEaiGet_M;
import config_M._08_ScriptCreate_M;
import config_M._09_rcp_M;
import config_M._11_commitIntfInfo_M;

import config_M.dao._00_commonDAO_M;
import config_M.log.LogManager_M;
import config_M.sys.SystemInfo_M;
import config_T._01_insertDBInterfaceInfo_tmp_T;
import config_T._02_insertDBNewInterfaceInfo_T;
import config_T._03_createNewCommonConfigFile_T;
import config_T._04_createFileConfig_T;
import config_T._05_createFepPutGet_T;
import config_T._06_createFepFtePut_T;
import config_T._07_createEaiGet_NEW_T;
import config_T._08_ScriptCreate_T;
import config_T._09_rcp_T;
import config_T._10_executeReload_T;
import config_T._11_commitIntfInfo_T;
import config_T.dao._00_commonDAO_T;
import config_T.sys.SystemInfo_T;
import config_T.log.LogManager_T;
import config.dao._00_commonDAO;
import config.log.LogManager;

import config.sys.SystemInfo;

public class list extends com.eai.servletbase.BaseServlet{

	private static final long serialVersionUID = 1L;
	private LogManager lm = LogManager.getInstance();
	public makeconfigDAO makeconfigDAO = new makeconfigDAO();
	public InterfaceInfoBean intfInfoBean = null;
	
	@Override
	protected void performTask(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("euc-kr");		//한글 인코딩
		
		String command = StringUtil.changeNull(req.getParameter("command"));

		if ("selectRequirementList".equals(command)) {
			this.selectRequirementList(req, res);
		} else if ("selectList".equals(command)) {
			this.selectList(req, res);
			
		
	} else if ("selectListwithoutpage".equals(command)) {
		this.selectListwithoutpage(req, res);
	}
		else if ("pop_registlist".equals(command)) {
			this.pop_registlist(req, res);	
			
		} else if ("registlist".equals(command)) {
			this.registlist(req, res);		
		} else if ("deletelist".equals(command)) {
			this.deletelist(req, res);
			
		} else if ("modlist".equals(command)) {
			this.modlist(req, res);		
		} else if ("userINlist".equals(command)) {
			this.userINlist(req, res);		
		} else if ("useraddINlist".equals(command)) {
			this.useraddINlist(req, res);		
	
			
		} else if ("sysINlist".equals(command)) {
			this.sysINlist(req, res);
			
		} else if ("selectuserList2".equals(command)) {
			this.selectuserList2(req, res);		
		} else if ("sysaddINlist".equals(command)) {
			this.sysaddINlist(req, res);		
	
			
		} else if ("selectuserList".equals(command)) {
			this.selectuserList(req, res);		
		} else if ("pop_registuser".equals(command)) {
			this.pop_registuser(req, res);
		} else if ("pop_moduser".equals(command)) {
			this.pop_moduser(req, res);
		} else if ("pop_modsys".equals(command)) {
			this.pop_modsys(req, res);
			
		} else if ("pop_modlist".equals(command)) {
			this.pop_modlist(req, res);	
			
		} else if ("updateuser".equals(command)) {
			this.updateuser(req, res);
		
		} else if ("updatesystem".equals(command)) {
			this.updatesystem(req, res);
		
		} else if ("registuser".equals(command)) {
			this.registuser(req, res);
		} else if ("deluser".equals(command)) {
			this.deluser(req, res);
			
		} else if ("selectsystemList".equals(command)) {
			this.selectsystemList(req, res);		
			

		} else if ("selectsystemList2".equals(command)) {
			this.selectsystemList2(req, res);		
			
			
		} else if ("pop_registsystem".equals(command)) {
			this.pop_registsystem(req, res);
		
		} else if ("registsystem".equals(command)) {
			this.registsystem(req, res);
	
		} else if ("delsystem".equals(command)) {
			this.delsystem(req, res);
			
		} else if ("pop_deletelist".equals(command)) {
			this.pop_deletelist(req, res);
			
		}else if ("insertRequirement".equals(command)) {
			this.insertRequirement(req, res);
		}
		
		
		
		// 반영 대상 리스트 가지고 옴.
		else if ("applylist".equals(command)) {
			this.applylist(req, res);
		}else if ("applylist_T".equals(command)) {
			this.applylist_T(req, res);
		}else if ("applylist_M_PC".equals(command)) {
			this.applylist_M_PC(req, res);
		}else if("applylist_M_SERVER".equals(command)){
			this.applylist_M_SERVER(req, res);
		}
		
		
		

		// 개발환경 반영
		else if("_01_insertDBInterfaceInfo_tmp_D".equals(command)){
			this._01_insertDBInterfaceInfo_tmp_D(req, res);
		}else if("_02_insertDBNewInterfaceInfo_D".equals(command)){
			this._02_insertDBNewInterfaceInfo_D(req,res);
		}else if("_03_createConfig_D".equals(command)){
			this._03_createConfig_D(req,res);
		}else if("_04_createFileConfig".equals(command)){
			this._04_createFileConfig(req,res);
		}else if("_05_createFepPutGetConfig".equals(command)){
			this._05_createFepPutGetConfig(req,res);
		}else if("_06_createFepFtePutConfig".equals(command)){
			this._06_createFepFtePutConfig(req,res);
		}else if("_07_createEaiGetConfig".equals(command)){
			this._07_createEaiGetConfig(req,res);
		}else if("_08_createMqscScript".equals(command)){
			this._08_createMqscScript(req, res);
		}else if("_09_sendConfig".equals(command)){
			this._09_sendConfig(req,res);
		}else if("_10_executeReload".equals(command)){
			this._10_executeReload(req,res);
		}else if("_11_commitIntfInfo".equals(command)){
			this._11_commitIntfInfo(req,res);
		}
			
		// 테스트 환경 반영
		else if("_01_insertDBInterfaceInfo_tmp_T".equals(command)){
			this._01_insertDBInterfaceInfo_tmp_T(req, res);
		}else if("_02_insertDBNewInterfaceInfo_T".equals(command)){
			this._02_insertDBNewInterfaceInfo_T(req,res);
		}else if("_03_createConfig_T".equals(command)){
			this._03_createConfig_T(req,res);
		}else if("_04_createFileConfig_T".equals(command)){
			this._04_createFileConfig_T(req,res);
		}else if("_05_createFepPutGetConfig_T".equals(command)){
			this._05_createFepPutGetConfig_T(req,res);
		}else if("_06_createFepFtePutConfig_T".equals(command)){
			this._06_createFepFtePutConfig_T(req,res);
		}else if("_07_createEaiGetConfig_T".equals(command)){
			this._07_createEaiGetConfig_T(req,res);
		}else if("_08_createMqscScript_T".equals(command)){
			this._08_createMqscScript_T(req, res);
		}else if("_09_sendConfig_T".equals(command)){
			this._09_sendConfig_T(req,res);
		}else if("_10_executeReload_T".equals(command)){
			this._10_executeReload_T(req,res);
		}else if("_11_commitIntfInfo_T".equals(command)){
			this._11_commitIntfInfo_T(req,res);
		}	
		
		// 운영환경 반영
		else if("_01_insertDBInterfaceInfo_tmp_M".equals(command)){
			this._01_insertDBInterfaceInfo_tmp_M(req, res);
		}else if("_02_insertDBNewInterfaceInfo_M".equals(command)){
			this._02_insertDBNewInterfaceInfo_M(req,res);
		}else if("_03_createConfig_M".equals(command)){
			this._03_createConfig_M(req,res);
		}else if("_04_createFileConfig_M".equals(command)){
			this._04_createFileConfig_M(req,res);
		}else if("_05_createFepPutGetConfig_M".equals(command)){
			this._05_createFepPutGetConfig_M(req,res);
		}else if("_06_createFepFtePutConfig_M".equals(command)){
			this._06_createFepFtePutConfig_M(req,res);
		}else if("_07_createEaiGetConfig_M".equals(command)){
			this._07_createEaiGetConfig_M(req,res);
		}else if("_08_createMqscScript_M".equals(command)){
			this._08_createMqscScript_M(req, res);
		}else if("_09_sendConfig_M".equals(command)){
			this._09_sendConfig_M(req,res);
		}else if("_10_executeReload_M".equals(command)){
			this._10_executeReload_M(req,res);
		}else if("_11_commitIntfInfo_M".equals(command)){
			this._11_commitIntfInfo_M(req,res);
		}	
		
		
	}

	
	protected void selectRequirementList(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String IF_NO = req.getParameter("IF_NO");
		String IF_ID = req.getParameter("IF_ID");
		String RUN_DATE = req.getParameter("RUN_DATE");
		
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = insertRequirementInfoDAO.selectRequirementList(IF_NO, IF_ID, RUN_DATE, "");
		
		//req.setAttribute("intfInfoBeanList", intfInfoBeanList);

		this.printJspPage(req, res, "/confmng/selectRequirement_list.jsp");
	}

	
	

	protected void selectList(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectList(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList=="+selectList);
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/list_result.jsp");
	}

	
	
	protected void selectListwithoutpage(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectListwithoutpage(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList=="+selectList);
		req.setAttribute("pageNo", 1);
		this.printJspPage(req, res, "/makeconfig/list_result.jsp");
	}
	protected void pop_registlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		{
			this.printJspPage(req, res, "/makeconfig/list_insert.jsp");
		}
	}
	
	protected void pop_deletelist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		{
			String[] chkList = req.getParameterValues("chk");
			System.out.println("chkList=="+chkList);
			req.setAttribute("chkList", chkList);
			
			this.printJspPage(req, res, "/makeconfig/list_delete.jsp");
		}
	}
	
	protected void selectuserList(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectuserList(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList=="+selectList);
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/user_result.jsp");
	}
	
	protected void selectuserList2(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectuserList(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList====="+selectList);
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/user_popup_result.jsp");
	}
	
	protected void userINlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		//String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		//QueryEntity selectList = makeconfigDAO.userINlist(req);	
		//req.setAttribute("intfInfoBeanList", selectList);
		//System.out.println("intfInfoBeanList=="+selectList);
		//req.setAttribute("pageNo", req.getParameter("pageNo"));
		String NUMX=req.getParameter("NUMX");
		System.out.println("NUMX+=========="+NUMX);
		req.setAttribute("NUMX", NUMX);
		req.setAttribute("SND", req.getParameter("SND"));
		this.printJspPage(req, res, "/makeconfig/user_popup.jsp");
	}
	
	
	protected void sysINlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		//String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		//QueryEntity selectList = makeconfigDAO.userINlist(req);	
		//req.setAttribute("intfInfoBeanList", selectList);
		//System.out.println("intfInfoBeanList=="+selectList);
		//req.setAttribute("pageNo", req.getParameter("pageNo"));
		String NUMX=req.getParameter("NUMX");
		System.out.println("NUMX+=========="+NUMX);
		req.setAttribute("NUMX", NUMX);
		req.setAttribute("SND", req.getParameter("SND"));
		this.printJspPage(req, res, "/makeconfig/sys_popup.jsp");
	}
	
	
	protected void useraddINlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		//String checkedid = req.getParameter("checkedid");
		
		String NUMX =  req.getParameter("NUMX");
		String SND =  req.getParameter("SND");

		String checkedid = req.getParameter("checkedid").split("/EMP_NAME/")[0].toString() ;
		//String checkedid = req.getParameter("checkedid");
		
		System.out.println("checkedid=="+checkedid);
		
		
		String checkedname = new String(req.getParameter("checkedid").split("/EMP_NAME/")[1].getBytes("8859_1")) ;
		//String checkedname ="ddd";
		System.out.println("checkedname=="+checkedname);
		

		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		//QueryEntity selectList = makeconfigDAO.userINlist(req);	
		//req.setAttribute("intfInfoBeanList", selectList);
		//System.out.println("intfInfoBeanList=="+selectList);
		//req.setAttribute("pageNo", req.getParameter("pageNo"));
		//this.printJspPage(req, res, "/makeconfig/user_popup.jsp");
		System.out.println("checkedid=="+checkedid);
		System.out.println("NUMX=="+NUMX);
		System.out.println("SND=="+SND);
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		System.out.println("SND==="+SND);
		if(SND.equals("SND"))
		{
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		//out.println("parent.GOBACK("+checkedid+");");
		
		//out.println("parent.opener.GOBACK("+checkedid+","+NUMX+");");

		out.println("parent.opener.GOBACK('"+checkedid+"','"+checkedname+"','"+NUMX+"');");
		//out.println("alert(parent.opener.frm.getElementById(SND));");
	//	out.println("parent.opener.document.getElementById(SND"+NUMX+").value="+checkedid+";");
		
		//oo = document.getElementById("SND"+NUMX);
		//oo.value=checkedid;
		
		
		//out.println("parent.opener.GOBACK();");
		out.println("parent.close();");
		out.println("</script>");	
		}
		else{
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			//out.println("parent.GOBACK("+checkedid+");");
			//out.println("parent.opener.GOBACKR("+checkedid+","+NUMX+");");
			out.println("parent.opener.GOBACKR('"+checkedid+"','"+checkedname+"','"+NUMX+"');");
			//out.println("parent.opener.GOBACK();");
			out.println("parent.close();");
			out.println("</script>");	
		}
	}
	
	
	
	
	
	
	protected void sysaddINlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		//String checkedid = req.getParameter("checkedid");
		String NUMX =  req.getParameter("NUMX");
		String SND =  req.getParameter("SND");
		
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		//QueryEntity selectList = makeconfigDAO.userINlist(req);	
		//req.setAttribute("intfInfoBeanList", selectList);
		//System.out.println("intfInfoBeanList=="+selectList);
		//req.setAttribute("pageNo", req.getParameter("pageNo"));
		//this.printJspPage(req, res, "/makeconfig/user_popup.jsp");
		

		String checkedid = req.getParameter("checkedid").split("/SYS_NAME/")[0].toString() ;
		//String checkedid = req.getParameter("checkedid");
		
		System.out.println("checkedid=="+checkedid);
		
		
		//String checkedname = new String(req.getParameter("checkedid").split("/SYS_NAME/")[1].getBytes("8859_1")) ;
		

		String checkedname = new String(req.getParameter("checkedid").split("/SYS_NAME/")[1].split("/PRJ_TYPE/")[0].getBytes("8859_1")) ;
		
		String prjtype = new String(req.getParameter("checkedid").split("/SYS_NAME/")[1].split("/PRJ_TYPE/")[1].split("/SYS_TYPE/")[0].getBytes("8859_1")) ;
		
		
		String systype = new String(req.getParameter("checkedid").split("/SYS_NAME/")[1].split("/PRJ_TYPE/")[1].split("/SYS_TYPE/")[1].getBytes("8859_1")) ;
		
		
		//String checkedname ="ddd";
		System.out.println("checkedname=="+checkedname);
		
		System.out.println("prjtype=="+prjtype);
		System.out.println("systype=="+systype);
		
		System.out.println("checkedid=="+checkedid);
		System.out.println("NUMX=="+NUMX);
		System.out.println("SND=="+SND);
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		if(SND.equals("SNDSYS"))
		{
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		//out.println("parent.GOBACK("+checkedid+");");
		out.println("parent.opener.GOBACKSYS('"+checkedid+"','"+checkedname+"','"+NUMX+"','"+prjtype+"','"+systype+"');");
		
		//out.println("parent.opener.GOBACK();");
		out.println("parent.close();");
		out.println("</script>");	
		}
		else if(SND.equals("RCVSYS")){
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			//out.println("parent.GOBACK("+checkedid+");");
			out.println("parent.opener.GOBACKSYSR('"+checkedid+"','"+checkedname+"','"+NUMX+"','"+prjtype+"','"+systype+"');");
			
			//out.println("parent.opener.GOBACK();");
			out.println("parent.close();");
			out.println("</script>");	
		}
	}
	
	protected void selectsystemList(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectsystemList(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList=="+selectList);
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/system_result.jsp");
	}
	
	
	protected void selectsystemList2(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");
		//System.out.println("SEQUENCE..." + SEQUENCE);
		// 인터페이스 정보 가져오기.
		//intfInfoBeanList = makeconfigDAO.selectList("", "", "", SEQUENCE);
		//intfInfoBeanList = makeconfigDAO.selectList(req);	
		QueryEntity selectList = makeconfigDAO.selectsystemList2(req);	
		
		req.setAttribute("intfInfoBeanList", selectList);
		System.out.println("intfInfoBeanList=="+selectList);
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/sys_popup_result.jsp");
	}
	protected void pop_registuser(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		this.printJspPage(req, res, "/makeconfig/user_insert.jsp");
	}
	
	protected void 	pop_moduser(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
		
		String user_info = new String(req.getParameter("checkedid").getBytes("8859_1"));
		
		System.out.println("userinfo==="+user_info);
		QueryEntity queryEntity = new makeconfigDAO().getuser(user_info);	
		
		req.setAttribute("userInfoList", queryEntity);
		
		System.out.println("userinfo queryentity ==="+queryEntity);
		
		this.printJspPage(req, res, "/makeconfig/user_mod.jsp");
	}

	
	
	
	protected void 	pop_modsys(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
		
		String sys_info = new String(req.getParameter("checkedid").getBytes("8859_1"));
		
		System.out.println("sys_info==="+sys_info);
		QueryEntity queryEntity = new makeconfigDAO().getsys(sys_info);	
		
		req.setAttribute("sysInfoList", queryEntity);
		
		System.out.println("getsys queryentity ==="+queryEntity);
		
		this.printJspPage(req, res, "/makeconfig/system_mod.jsp");
	}
	
	
	
	
	protected void 	pop_modlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
		
		String if_info = new String(req.getParameter("checkedid").getBytes("8859_1"));
		
		System.out.println("if_info==="+if_info);
		QueryEntity queryEntity = new makeconfigDAO().getlist(if_info);	
		
		req.setAttribute("listInfoList", queryEntity);
		
		QueryEntity queryEntity2 = new makeconfigDAO().getlistdetail(if_info);	
		
		
		req.setAttribute("SNDInfoList", queryEntity2);
		System.out.println("SNDInfoList==="+queryEntity2);
		
		QueryEntity queryEntity3 = new makeconfigDAO().getlistdetail2(if_info);	
		
		req.setAttribute("RCVInfoList", queryEntity3);
		System.out.println("RCVInfoList==="+queryEntity3);
		
		this.printJspPage(req, res, "/makeconfig/list_mod.jsp");
	}
	protected void updateuser(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int trCnt = 0;
		String EMP_NO = req.getParameter("EMP_NO");
		String team = req.getParameter("team");
		String name = req.getParameter("name");
		
		
		System.out.println("EMP_NO==="+EMP_NO);
		
		//trCnt = new InterfaceStatusDAO().updateNodeInfo( HOST_NAME, IP_ADDRESS, OS, BIZ_NAME ,QMGR_NM, QMGR_PORT, BIZ_CODE);
		//System.out.println("trCnt...... " + trCnt);
		trCnt = new makeconfigDAO().updateuser(EMP_NO, team, name);
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		
		
		
	

		if (trCnt == 1) {
			out.println("alert('담당자 정보가 수정되었습니다.')");
			//out.println("parent.opener.linkMng();");
			out.println("parent.opener.makeconfiglist();");
			out.println("parent.close();");
		}
		else {
			out.println("alert('담당자  정보 수정이 실패했습니다.')");
		}
		out.println("</script>");
		//this.pop_registNodeInfo(req, res);
		//this.printJspPage(req, res, "/intfmng/pop_registNodeInfo.jsp");
		//this.printJspPage(req, res, "/intfmng/pop_updateNodeInfo.jsp");
	}
	
	
	
	
	
	protected void updatesystem(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int trCnt = 0;
		String SYS_NO = req.getParameter("SYS_NO");
		String sys_name = req.getParameter("sys_name");
		String sys_code = req.getParameter("sys_code");
		String sys_type = req.getParameter("sys_type");
		String dbyn = req.getParameter("dbyn");
		String fep_no = req.getParameter("fep_no");
		String trlen = req.getParameter("trlen");
		String prj_type = req.getParameter("prj_type");
		String viewyn = req.getParameter("viewyn");
		String note = req.getParameter("note");
		
		
		
		//trCnt = new InterfaceStatusDAO().updateNodeInfo( HOST_NAME, IP_ADDRESS, OS, BIZ_NAME ,QMGR_NM, QMGR_PORT, BIZ_CODE);
		//System.out.println("trCnt...... " + trCnt);
		
		
		QueryEntity queryEntity = new makeconfigDAO().dup_sys_code(sys_code);	
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
	
		if(queryEntity.getRowCnt()==0)
		{
		trCnt = new makeconfigDAO().updatesystem(SYS_NO, sys_name, sys_code, sys_type, dbyn, fep_no, trlen, prj_type, viewyn, note);
		
		
		}
		else
		{
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
				out.println("alert('시스템 코드가 이미 등록되어 있습니다.')");
				//out.println("parent.back();");
				out.println("</script>");
		}
		
		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		
		if (trCnt == 1) {
			out.println("alert('시스템 정보가 수정되었습니다.')");
			//out.println("parent.opener.linkMng();");
			out.println("parent.opener.makeconfiglist();");
			out.println("parent.close();");
		}
		else {
			out.println("alert('시스템  정보 수정이 실패했습니다.')");
			out.println("history.back()");
		}
		out.println("</script>");
		//this.pop_registNodeInfo(req, res);
		//this.printJspPage(req, res, "/intfmng/pop_registNodeInfo.jsp");
		//this.printJspPage(req, res, "/intfmng/pop_updateNodeInfo.jsp");
	}
	
	protected void pop_registsystem(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		this.printJspPage(req, res, "/makeconfig/system_insert.jsp");
	}
	protected void registuser(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
			int trCnt = 0;
			int chkCnt = 0;
			res.setContentType("text/html;charset=euc-kr");
			PrintWriter out = res.getWriter();
			//String[] prods = req.getParameterValues("prod_name");
			//System.out.println("is it work? ok?"+prods[0]);

			int nodeYebu=0;
			String inserted_nodeid;
			String name = req.getParameter("name");		
			String team = req.getParameter("team");
			String EMP_NO="";
			//String EMP_NO = req.getParameter("EMP_NO");
			System.out.println("name===="+name);
			System.out.println("teatm=="+team);	
			//System.out.println("EMP_NO=="+EMP_NO);	
			
			//chkCnt = new makeconfigDAO().checkempno(EMP_NO);
			
			//QueryEntity chkuser = makeconfigDAO.checkempno(req);	
			
			/*if(chkuser.getRowCnt()>0)
			{
				out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
					out.println("alert('이미 등록된 EMP_NO입니다.')");
					out.println("history.back()");
					out.println("</script>");	
			}*/
			
			/*else
				{*/
				trCnt = new makeconfigDAO().registuser(name,team,EMP_NO);
						
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			if (trCnt == 1) {
				out.println("alert('담당자가 등록되었습니다.')");
				out.println("parent.opener.makeconfiglist();");
				out.println("parent.close();");
			}

			else {
				out.println("alert('담당자 등록이 실패했습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");	
			//}
		}
	protected void registsystem(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
			int trCnt = 0;
			res.setContentType("text/html;charset=euc-kr");
			PrintWriter out = res.getWriter();
			//String[] prods = req.getParameterValues("prod_name");
			//System.out.println("is it work? ok?"+prods[0]);

			int nodeYebu=0;
			String inserted_nodeid;
			//String SYS_NO = req.getParameter("SYS_NO");
			String sys_name = req.getParameter("sys_name");		
			String sys_code = req.getParameter("sys_code");
			String sys_type = req.getParameter("sys_type");
			
			String dbyn = req.getParameter("dbyn");
			String fepno = req.getParameter("fep_no");
			String trlen = req.getParameter("trlen");
			String note = req.getParameter("note");
			String prj_type=req.getParameter("prj_type");
			String viewyn=req.getParameter("viewyn");
			
			QueryEntity queryEntity = new makeconfigDAO().dup_sys_code(sys_code);	
			//trCnt = new InterfaceStatusDAO().registNodeInfo(HOST_NAME, IP_ADDRESS, OS, BIZ_NAME,QMGR_NM,QMGR_PORT,BIZ_CODE);
			if(queryEntity.getRowCnt()==0)
			{
			trCnt = new makeconfigDAO().registsystem(sys_name,sys_code,sys_type,dbyn,fepno,trlen,note,prj_type,viewyn);
			
			}
			else
			{
				out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
					out.println("alert('시스템 코드가 이미 등록되어 있습니다.')");
					out.println("</script>");
			}
						
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			if (trCnt == 1) {
				out.println("alert('시스템이 등록되었습니다.')");
				out.println("parent.opener.makeconfiglist();");
				out.println("parent.close();");
			}

			else {
				out.println("alert('시스템 등록이 실패했습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");	
		}
	
	protected void registlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
			int trCnt = 0;
			res.setContentType("text/html;charset=euc-kr");
			PrintWriter out = res.getWriter();
			//String[] prods = req.getParameterValues("prod_name");
			//System.out.println("is it work? ok?"+prods[0]);

			int nodeYebu=0;
			String inserted_nodeid;
			String IF_ID = req.getParameter("IF_ID");		
			String IF_NAME = req.getParameter("IF_NAME");
			String IN_EX = req.getParameter("IN_EX");
			String ASIS_SVC = req.getParameter("ASIS_SVC");
			
			String ONEWAY_TWOWAY = req.getParameter("ONEWAY_TWOWAY");
			String SYNC_ASYN = req.getParameter("SYNC_ASYN");
			
			String BATCH_ONLINE = req.getParameter("BATCH_ONLINE");
			String DATA_LEN = req.getParameter("DATA_LEN");
			String NOTE = req.getParameter("NOTE");
			String NOTE2= req.getParameter("NOTE2");
			String plusnum = req.getParameter("plusnum");
			String plusnumR = req.getParameter("plusnumR");
			
			System.out.println("plusnum=============================="+plusnum);
			System.out.println("plusnumR=============================="+plusnumR);
			
			
			
//		
			int plusnumint= Integer.parseInt(plusnum) - 90;
			
			String SND2[] = new String[plusnumint];
			String SND3[] = new String[plusnumint];
		    for (int i = 0; i < plusnumint; i++) {
		    	int j = i+91;
		    	SND2[i] = req.getParameter("SND"+j); 
		    	SND3[i] =  req.getParameter("SNDSYS"+j); 
		    }

		    
		    int plusnumintR= Integer.parseInt(plusnumR) - 90;
			
			String RCV2[] = new String[plusnumintR];
			String RCV3[] = new String[plusnumintR];
			   
		    for (int i = 0; i < plusnumintR; i++) {
		    	int j = i+91;
		    	RCV2[i] = req.getParameter("RCV"+j); 
		    	RCV3[i] =  req.getParameter("RCVSYS"+j); 
		    }
		    
		    
		    String SND4[] = new String[plusnumint];
		    String SND5[] = new String[plusnumint];
		    String SND6[] = new String[plusnumint];
		    String SND7[] = new String[plusnumint];
		    for (int i = 0; i < plusnumint; i++) {
		    	int j = i+91;
		    	SND4[i] = req.getParameter("SND4"+j); 
		    	SND5[i] =  req.getParameter("SND5"+j);
		    	SND6[i] =  req.getParameter("SND6"+j);
		    	SND7[i] =  req.getParameter("SND7"+j);
		    }
		 
		    
			
			/*	for (int i = 0; i < SND2.length; i++){	
				
				System.out.println("SND2==="+SND2[i]);
				
				}*/
			
		
			
			String[] SND1 = req.getParameterValues("SND1");
			//String[] SND2 = req.getParameterValues("SND2");
			//String[] SND3 = req.getParameterValues("SND3");
			//String[] SND4 = req.getParameterValues("SND4");
//			String[] SND5 = req.getParameterValues("SND5");
//			String[] SND6 = req.getParameterValues("SND6");
//			String[] SND7 = req.getParameterValues("SND7");
			
			String[] RCV1 = req.getParameterValues("RCV1");
			//String[] RCV2 = req.getParameterValues("RCV2");
			//String[] RCV3 = req.getParameterValues("RCV3");
			String[] RCV4 = req.getParameterValues("RCV4");
			String[] RCV5 = req.getParameterValues("RCV5");
			String[] RCV6 = req.getParameterValues("RCV6");
			String[] RCV7 = req.getParameterValues("RCV7");
			String[] RCV8 = req.getParameterValues("RCV8");
			
//			System.out.println("SND5.length=="+SND5.length);
//			System.out.println("SND5[0].toString()=="+SND5[0].toString());
//			
			

//			System.out.println("ㅕ기=====111111111111111====================");
//			for(int i=0; i<SND5.length; i++)
//			{
//				System.out.println("SND5=="+SND5[i].toString());	
//				if (SND5[i].toString().equals("")) {
//					out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
//					out.println("alert('서비스 또는 TR_CODE를 입력해주세요')");
//					out.println("</script>");	
//					//out.println("location.replace('about:blank')");
//					//out.println("history.back(req)");
//					
//				}
//			}
			
			//trCnt = new InterfaceStatusDAO().registNodeInfo(HOST_NAME, IP_ADDRESS, OS, BIZ_NAME,QMGR_NM,QMGR_PORT,BIZ_CODE);
			
			
			
			//요거
			trCnt = new makeconfigDAO().registlist(IF_ID,IF_NAME,IN_EX,ASIS_SVC,ONEWAY_TWOWAY,SYNC_ASYN,DATA_LEN,NOTE,NOTE2, SND1, SND2, SND3, SND4, SND5, SND6, SND7,RCV1,RCV2,RCV3,RCV4,RCV5,RCV6,RCV7,RCV8,BATCH_ONLINE);
	
			
			
		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			if (trCnt == 1) {
				//out.println("alert('인터페이스가 등록되었습니다.')");
////////				out.println("location.replace('about:blank')");
			out.println("alert('인터페이스가 등록되었습니다.')");
					out.println("parent.opener.makeconfiglist();");
					out.println("parent.close();");
					out.println("</script>");
				}
			else if (trCnt == 2) {
					out.println("alert('인터페이스ID가 중복되었습니다.')");
					out.println("location.replace('about:blank')");
					out.println("</script>");
				}
			else if (trCnt == 3) {
				out.println("alert('송신시스템코드 + TR코드가 중복입니다.')");
				out.println("location.replace('about:blank')");
				out.println("</script>");
			}
			else {
		out.println("alert('인터페이스 등록이 실패했습니다.');");
		//out.println("history.back();");
				out.println("location.replace('about:blank')");
				out.println("</script>");
			}
			
			
			
			System.out.println("ㅕ기=========333================");
		}
	
	protected void modlist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
			int trCnt = 0;
			res.setContentType("text/html;charset=euc-kr");
			PrintWriter out = res.getWriter();
			//String[] prods = req.getParameterValues("prod_name");
			//System.out.println("is it work? ok?"+prods[0]);

			int nodeYebu=0;
			String inserted_nodeid;
			String IF_NO = req.getParameter("IF_NO");
			String IF_ID = req.getParameter("IF_ID");		
			String IF_NAME = req.getParameter("IF_NAME");
			String IN_EX = req.getParameter("IN_EX");
			String ASIS_SVC = req.getParameter("ASIS_SVC");
			
			String ONEWAY_TWOWAY = req.getParameter("ONEWAY_TWOWAY");
			String SYNC_ASYN = req.getParameter("SYNC_ASYN");
			
			//String BATCH_ONLINE = req.getParameter("BATCH_ONLINE");
			String DATA_LEN = req.getParameter("DATA_LEN");
			String NOTE = req.getParameter("NOTE");
			String NOTE2= req.getParameter("NOTE2");
			String plusnum = req.getParameter("plusnum");
			String plusnumR = req.getParameter("plusnumR");
			String BATCH_ONLINE = req.getParameter("BATCH_ONLINE");
			
			
			String IF_ID_ORG = req.getParameter("IF_ID_ORG");		
			String IN_EX_ORG = req.getParameter("IN_EX_ORG");
			String ONEWAY_TWOWAY_ORG = req.getParameter("ONEWAY_TWOWAY_ORG");
			String SYNC_ASYN_ORG = req.getParameter("SYNC_ASYN_ORG");
			String BATCH_ONLINE_ORG = req.getParameter("BATCH_ONLINE_ORG");
			

			
			System.out.println("BATCH_ONLINE=============================="+BATCH_ONLINE);
			
			System.out.println("plusnum=============================="+plusnum);
			System.out.println("plusnumR=============================="+plusnumR);
			
			
			
//		

			int nowcntr= Integer.parseInt(req.getParameter("nowcntr"));
			int nowcnts= Integer.parseInt(req.getParameter("nowcnts"));
			int plusnumint= Integer.parseInt(plusnum) - 90;
			
		
			System.out.println("nowcnts=============="+nowcnts);
			
			
			String SND2[] = new String[plusnumint];
			String SND3[] = new String[plusnumint];
		    for (int i = 0; i < plusnumint; i++) {
		    	int j = i+91;
		    	SND2[i] = req.getParameter("SND"+j); 
		    	SND3[i] =  req.getParameter("SNDSYS"+j); 
		    }

		    
		    String SND4[] = new String[plusnumint];
		    String SND5[] = new String[plusnumint];
		    String SND6[] = new String[plusnumint];
		    String SND7[] = new String[plusnumint];
		    for (int i = 0; i < plusnumint; i++) {
		    	int j = i+91;
		    	SND4[i] = req.getParameter("SND4"+j); 
		    	SND5[i] =  req.getParameter("SND5"+j);
		    	SND6[i] =  req.getParameter("SND6"+j);
		    	SND7[i] =  req.getParameter("SND7"+j);
		    }
		    
		    
		    String SND2ORG[] = new String[nowcnts];
			String SND3ORG[] = new String[nowcnts];
		    for (int i = 0; i < nowcnts; i++) {
		    	int j = i+91;
		    	SND2ORG[i] = req.getParameter("SNDORG"+j); 
		    	SND3ORG[i] =  req.getParameter("SNDSYSORG"+j); 
		    }

		    
		    String SND4ORG[] = new String[nowcnts];
		    String SND5ORG[] = new String[nowcnts];
		    String SND6ORG[] = new String[nowcnts];
		    String SND7ORG[] = new String[nowcnts];
		    for (int i = 0; i < nowcnts; i++) {
		    	int j = i+91;
		    	SND4ORG[i] = req.getParameter("SND4ORG"+j); 
		    	SND5ORG[i] =  req.getParameter("SND5ORG"+j);
		    	SND6ORG[i] =  req.getParameter("SND6ORG"+j);
		    	SND7ORG[i] =  req.getParameter("SND7ORG"+j);
		    }
		    
		    
		    int plusnumintR= Integer.parseInt(plusnumR) - 90;
			
			String RCV2[] = new String[plusnumintR];
			String RCV3[] = new String[plusnumintR];
			   
		    for (int i = 0; i < plusnumintR; i++) {
		    	int j = i+91;
		    	RCV2[i] = req.getParameter("RCV"+j); 
		    	RCV3[i] =  req.getParameter("RCVSYS"+j); 
		    }
		    
		    
		    String RCV2ORG[] = new String[plusnumintR];
			String RCV3ORG[] = new String[plusnumintR];
		    for (int i = 0; i < plusnumintR; i++) {
		    	int j = i+91;
		    	RCV2ORG[i] = req.getParameter("RCVORG"+j); 
		    	RCV3ORG[i] =  req.getParameter("RCVSYSORG"+j); 
		    }
		    
		    
			
			/*	for (int i = 0; i < SND2.length; i++){	
				
				System.out.println("SND2==="+SND2[i]);
				
				}*/

			//String nowcntr = req.getParameter("nowcntr");
			//String nowcnts = req.getParameter("nowcnts");
			
			String[] SND1 = req.getParameterValues("SND1");
			//String[] SND2 = req.getParameterValues("SND2");
			//String[] SND3 = req.getParameterValues("SND3");
//			String[] SND4 = req.getParameterValues("SND4");
//			String[] SND5 = req.getParameterValues("SND5");
//			String[] SND6 = req.getParameterValues("SND6");
//			String[] SND7 = req.getParameterValues("SND7");
//			
			String[] SND10 = req.getParameterValues("SND10");
			String[] SND11 = req.getParameterValues("SND11");
			String[] SND12 = req.getParameterValues("SND12");
			
			
			String[] RCV1 = req.getParameterValues("RCV1");
			//String[] RCV2 = req.getParameterValues("RCV2");
			//String[] RCV3 = req.getParameterValues("RCV3");
			String[] RCV4 = req.getParameterValues("RCV4");
			String[] RCV5 = req.getParameterValues("RCV5");
			String[] RCV6 = req.getParameterValues("RCV6");
			String[] RCV7 = req.getParameterValues("RCV7");
			String[] RCV8 = req.getParameterValues("RCV8");
			
			String[] RCV10 = req.getParameterValues("RCV10");
			String[] RCV11 = req.getParameterValues("RCV11");
			String[] RCV12 = req.getParameterValues("RCV12");
			
			
			String[] RCV1ORG = req.getParameterValues("RCV1ORG");
			//String[] RCV2 = req.getParameterValues("RCV2");
			//String[] RCV3 = req.getParameterValues("RCV3");
			String[] RCV4ORG = req.getParameterValues("RCV4ORG");
			String[] RCV5ORG = req.getParameterValues("RCV5ORG");
			String[] RCV6ORG = req.getParameterValues("RCV6ORG");
			String[] RCV7ORG = req.getParameterValues("RCV7ORG");
			String[] RCV8ORG = req.getParameterValues("RCV8ORG");
			String[] RCV10ORG = req.getParameterValues("RCV10ORG");
			String[] RCV11ORG = req.getParameterValues("RCV11ORG");
			String[] RCV12ORG = req.getParameterValues("RCV12ORG");
			
			
		
			//trCnt = new InterfaceStatusDAO().registNodeInfo(HOST_NAME, IP_ADDRESS, OS, BIZ_NAME,QMGR_NM,QMGR_PORT,BIZ_CODE);
			
			
			System.out.println("IF_NO=========="+IF_NO);
			//요거
			//trCnt = new makeconfigDAO().registlist(IF_ID,IF_NAME,IN_EX,ASIS_SVC,ONEWAY_TWOWAY,SYNC_ASYN,DATA_LEN,NOTE,NOTE2, SND1, SND2, SND3, SND4, SND5, SND6, SND7,RCV1,RCV2,RCV3,RCV4,RCV5,RCV6,RCV7,RCV8);
	
			trCnt = new makeconfigDAO().modlist(IF_ID,IF_NAME,IN_EX,ASIS_SVC,ONEWAY_TWOWAY,SYNC_ASYN,DATA_LEN,NOTE,NOTE2, SND1, SND2, SND3, SND4, SND5, SND6, SND7,RCV1,RCV2,RCV3,RCV4,RCV5,RCV6,RCV7,RCV8,IF_NO, nowcnts, nowcntr, plusnumint, plusnumintR, SND10, SND11, SND12, RCV10, RCV11, RCV12, BATCH_ONLINE, SND2ORG, SND3ORG, SND4ORG, SND5ORG, SND6ORG, SND7ORG, RCV2ORG, RCV3ORG, RCV4ORG, RCV5ORG, RCV6ORG, RCV7ORG, RCV8ORG, IF_ID_ORG, IN_EX_ORG, ONEWAY_TWOWAY_ORG, SYNC_ASYN_ORG, BATCH_ONLINE_ORG);
			
			
			/*	for (int i = 0; i < SND1.length; i++){	
			System.out.println("SND1=="+StringUtil.toKorean(SND1[i]).trim());
			}
		*/	
			
			
			
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			if (trCnt == 1) {
				out.println("alert('인터페이스가 등록되었습니다.')");
				out.println("parent.opener.makeconfiglist();");
				out.println("parent.close();");
			}
			
			else if (trCnt == 2) {
				out.println("alert('인터페이스ID가 중복되었습니다.')");
				out.println("location.replace('about:blank')");
				out.println("</script>");
			}
			
			else if (trCnt == 3) {
			out.println("alert('송신시스템코드 + TR코드가 중복입니다.')");
			out.println("location.replace('about:blank')");
			out.println("</script>");
			}
			
			else {
				out.println("alert('인터페이스 등록이 실패했습니다.')");
				out.println("location.replace('about:blank')");
//				out.println("history.back()");
				//out.println("parent.close();");
			}
			out.println("</script>");	
		}
	
	protected void deluser(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String[] chkList = req.getParameterValues("chk");
		//String gid = new String(req.getParameter("checklist").getBytes("8859_1"));
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid);
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		//trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		System.out.println("chkList=="+chkList);
		//System.out.println("gid=="+gid);
		String gid="";
		int trCnt = new makeconfigDAO().deltuser(gid,chkList);
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		if (trCnt == 1)
		{
			out.println("alert('담당자 정보를 삭제 하였습니다.')");
			//out.println("parent.opener.getIntfInfoMngStatus();");
			//out.println("parent.close();");
		}
		else
		{
			out.println("alert('담당자 정보 삭제에 실패했습니다.')");	
			//out.println("parent.opener.getIntfInfoMngStatus();");
		}
		out.println("parent.makeconfiglist();");
		out.println("</script>");	
			
		}
	protected void deletelist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String[] chkList = req.getParameterValues("chk");
		//String gid = new String(req.getParameter("checklist").getBytes("8859_1"));
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid);
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		//trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		System.out.println("chkList=="+chkList);

		String[] comment=req.getParameterValues("comment"); 
		String[] checkedid=req.getParameterValues("checkedid"); 
		
		//System.out.println("gid=="+gid);
		String gid="";
		
		int trCnt = new makeconfigDAO().dellistandReason(comment,checkedid);
		
		
		//int trCnt = new makeconfigDAO().dellist(gid,chkList);
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		if (trCnt == 1)
		{
			
			out.println("alert('인터페이스 목록을 삭제 하였습니다.'); parent.close();");
			
			//out.println("parent.opener.getIntfInfoMngStatus();");
			out.println("parent.opener.makeconfiglist();");
		
//			out.println("parent.makeconfiglist();");
		}
		else
		{
			out.println("alert('인터페이스 목록 삭제에 실패했습니다.')");	
			//out.println("parent.opener.getIntfInfoMngStatus();");
		}
		//out.println("parent.close();");
		out.println("</script>");	
			
		}
	
	protected void delsystem(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String[] chkList = req.getParameterValues("chk");
		//String gid = new String(req.getParameter("checklist").getBytes("8859_1"));
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid);
		//int trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		//trCnt = new InterfaceManagementDAO().delIntfInfoMngById(gid,chkList);
		System.out.println("chkList=="+chkList);
		//System.out.println("gid=="+gid);
		String gid="";
		//int trCnt = new makeconfigDAO().deltuser(gid,chkList);
		int trCnt = new makeconfigDAO().deltsystem(gid,chkList);
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		if (trCnt == 1)
		{
			out.println("alert('시스템 정보를 삭제 하였습니다.')");
			out.println("parent.opener.getIntfInfoMngStatus();");
			//out.println("parent.close();");
		}
		else
		{
			out.println("alert('시스템 정보 삭제에 실패했습니다.')");	
			//out.println("parent.opener.getIntfInfoMngStatus();");
		}
		out.println("parent.makeconfiglist();");
		out.println("</script>");	
			
		}
	/*****************************************************************************************
	 *  개발 : 반영대상 인터페이스 select.
	 * @param req
	 * @param res
	 * @throws Exception
	 ******************************************************************************************/
	protected void applylist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		getProperties_D();
		
		QueryEntity applylist =null;		
		
		// 반영대상 인터페이스 select.
		applylist = makeconfigDAO.applylist(req);	
		
		req.setAttribute("intfInfoBeanList", applylist);		
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/apply_result.jsp");
	}
	
	
	/*****************************************************************************************
	 *  테스트 : 반영대상 인터페이스 select.
	 * @param req
	 * @param res
	 * @throws Exception
	 ******************************************************************************************/
	protected void applylist_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
		getProperties_T();
		
		QueryEntity applylist =null;		
		
		// 반영대상 인터페이스 select.
		applylist = makeconfigDAO.applylist_T(req);			
		req.setAttribute("intfInfoBeanList", applylist);		
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/apply_t_result.jsp");		
		
	}
	
	/*****************************************************************************************
	 *  운영 : 반영대상 인터페이스 select.
	 * @param req
	 * @param res
	 * @throws Exception
	 ******************************************************************************************/
	protected void applylist_M_PC(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		getProperties_M_PC();
		
		QueryEntity applylist =null;		
		
		// 반영대상 인터페이스 select.
		/**************************************************************/
		/** PC 버전 **/
		applylist = makeconfigDAO.applylist_M_pc(req);
		
		/** 서버 버전 **/
		//applylist = makeconfigDAO.applylist_M_server(req);
		/**************************************************************/
		
		
		req.setAttribute("intfInfoBeanList", applylist);		
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/apply_m_result.jsp");
	}
	
	/*****************************************************************************************
	 *  운영 : 반영대상 인터페이스 select.
	 * @param req
	 * @param res
	 * @throws Exception
	 ******************************************************************************************/
	protected void applylist_M_SERVER(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		getProperties_M();
		
		QueryEntity applylist =null;		
		
		// 반영대상 인터페이스 select.
		/**************************************************************/
		/** PC 버전 **/
		//applylist = makeconfigDAO.applylist_M_pc(req);
		
		/** 서버 버전 **/
		applylist = makeconfigDAO.applylist_M_server(req);
		/**************************************************************/
		
		
		req.setAttribute("intfInfoBeanList", applylist);		
		req.setAttribute("pageNo", req.getParameter("pageNo"));
		this.printJspPage(req, res, "/makeconfig/apply_m_result.jsp");
	}
	
	
	protected void insertRequirement(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String SEQUENCE = req.getParameter("SEQUENCE");

		System.out.println("SEQUENCE..." + SEQUENCE);
		
		int resCnt = 0;
		intfInfoBean = new InterfaceInfoBean();

		intfInfoBean.setGROUP_NM(req.getParameter("GROUP_NM"));
		intfInfoBean.setDY_IF_ID(req.getParameter("DY_IF_ID"));
		intfInfoBean.setBIZ_IF_ID(req.getParameter("BIZ_IF_ID"));
		intfInfoBean.setEAI_NM(req.getParameter("EAI_NM"));	
		intfInfoBean.setDIRECT_TEAM_SEND(req.getParameter("DIRECT_TEAM"));	
		
		intfInfoBean.setDIRECTOR_SEND(req.getParameter("DIRECTOR_SEND"));	
		intfInfoBean.setDIRECT_TEAM_RECV(req.getParameter("DIRECT_TEAM_RECV"));	
		intfInfoBean.setDIRECTOR_RECV(req.getParameter("DIRECTOR_RECV"));	
		intfInfoBean.setCONNECT_DIV(req.getParameter("CONNECT_DIV"));	
		intfInfoBean.setDIRECTION(req.getParameter("DIRECTION"));	
		
		intfInfoBean.setSEND_GBN(req.getParameter("SEND_GBN"));	
		intfInfoBean.setSEND_HOST(req.getParameter("SEND_HOST"));	
		intfInfoBean.setSEND_MEDIA(req.getParameter("SEND_MEDIA"));
		intfInfoBean.setSEND_IP(req.getParameter("SEND_IP"));	
		intfInfoBean.setSEND_PORT(req.getParameter("SEND_PORT"));	
		
		intfInfoBean.setSEND_SYS_ID(req.getParameter("SEND_SYS_ID"));	
		intfInfoBean.setRECV_GBN(req.getParameter("RECV_GBN"));
		intfInfoBean.setRECV_HOST(req.getParameter("RECV_HOST"));	
		intfInfoBean.setRECV_MEDIA(req.getParameter("RECV_MEDIA"));
		intfInfoBean.setRECV_IP(req.getParameter("RECV_IP"));
		
		intfInfoBean.setRECV_PORT(req.getParameter("RECV_PORT"));
		intfInfoBean.setRECV_SYS_ID(req.getParameter("RECV_SYS_ID"));	
		intfInfoBean.setBUSI_ID(req.getParameter("BUSI_ID"));
		intfInfoBean.setTRANS_MODE(req.getParameter("TRANS_MODE"));	
		intfInfoBean.setINTERVAL(req.getParameter("INTERVAL"));
		
		intfInfoBean.setTRANS_GUBUN(req.getParameter("TRANS_GUBUN"));
		intfInfoBean.setBIZ_NAME(req.getParameter("BIZ_NAME"));
		intfInfoBean.setCONDITION(req.getParameter("CONDITION"));
		intfInfoBean.setSEND_DATA(req.getParameter("SEND_DATA"));	
		intfInfoBean.setRECV_DATA(req.getParameter("RECV_DATA"));
		
		intfInfoBean.setSEND_TOBE(req.getParameter("SEND_TOBE"));
		intfInfoBean.setRECV_TOBE(req.getParameter("RECV_TOBE"));
		intfInfoBean.setSEND_SERVICE(req.getParameter("SEND_SERVICE"));
		intfInfoBean.setSEND_REWARD(req.getParameter("SEND_REWARD"));
		intfInfoBean.setRECV_SERVICE(req.getParameter("RECV_SERVOCE"));
		
		intfInfoBean.setRECV_REWARD(req.getParameter("RECV_REWARD"));
		intfInfoBean.setETC(req.getParameter("ETC"));
		intfInfoBean.setIF_NO(req.getParameter("IF_NO"));
		intfInfoBean.setID(req.getParameter("ID"));
		intfInfoBean.setFILE_NAME(req.getParameter("FILE_NAME"));
		
		intfInfoBean.setPEAK_NUM(req.getParameter("PEAK_NUM"));
		intfInfoBean.setPEAK_STAND(req.getParameter("PEAK_STAND"));
		intfInfoBean.setPEAK_TIME(req.getParameter("PEAK_TIME"));
		intfInfoBean.setDATA_LENGTH(req.getParameter("DATA_LENGTH"));
		intfInfoBean.setPLAN_TIME(req.getParameter("PLAN_TIME"));
		
		intfInfoBean.setSEND_RQ(req.getParameter("SEND_RQ"));
		intfInfoBean.setSEND_LQ(req.getParameter("SEND_LQ"));
		intfInfoBean.setSEND_ERQ(req.getParameter("SEND_ERQ"));
		intfInfoBean.setEAI_IN_Q_1(req.getParameter("EAI_IN_Q_1"));
		intfInfoBean.setEAI_IN_ERQ_1(req.getParameter("EAI_IN_ERQ_1"));
		
		intfInfoBean.setEAI_OUT_Q_1(req.getParameter("EAI_OUT_Q_1"));
		intfInfoBean.setEAI_IN_Q_2(req.getParameter("EAI_IN_Q_2"));
		intfInfoBean.setEAI_IN_ERQ_2(req.getParameter("EAI_IN_ERQ_2"));
		intfInfoBean.setEAI_OUT_Q_2(req.getParameter("EAI_OUT_Q_2"));
		intfInfoBean.setRECV_LQ(req.getParameter("RECV_LQ"));
		
		intfInfoBean.setRECV_ERQ(req.getParameter("RECV_ERQ"));
		intfInfoBean.setRECV_RQ(req.getParameter("RECV_RQ"));
		intfInfoBean.setRUN_DATE("");
		
		if(SEQUENCE==null)
		{
		// 인터페이스 정보 입력
			System.out.println("sequence=null");
		//resCnt = insertRequirementInfoDAO.insertRequirement(intfInfoBean);
		}
		else
		{
			System.out.println("update필요");
					//update
			//resCnt = insertRequirementInfoDAO.updateRequirement(intfInfoBean,SEQUENCE);
		}
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		if (resCnt > 0)
		{
			out.println("alert('인터페이스 요건이 등록되었습니다!')");
			out.print("window.open('about:blank','_self').close();");
		}
		else {
			out.println("alert('인터페이스 요건등록을 실패했습니다.')");
		}
			
		out.println("</script>");
	}

	/**********************************************************
	 * 개발 : 쿼리, 설정 파일 읽어오기
	 ***********************************************************/
	public void getProperties_D() {

		// property 파일과 sql 파일이 있을 디렉토리 지정. 
		String dir_prop = "/var/mte/ConfigCheck_D/";
		/*
		 * "D:" + File.separator + "DongYang" + File.separator + "Workspace1" +
		 * File.separator + "ConfigCheck_D" + File.separator + "src" +
		 * File.separator ;
		 */

		String PROPERTIES_FILE = dir_prop + "conf.properties";
		String SQL_FILE = dir_prop + "getInterfaceInfo.sql";
		SystemInfo.getInstance(SQL_FILE, PROPERTIES_FILE);
	}

	/**********************************************************
	 * 테스트 : 쿼리, 설정 파일 읽어오기
	 ***********************************************************/	
	public void getProperties_T() {

		// property 파일과 sql 파일이 있을 디렉토리 지정. 
		String dir_prop = "/var/mte/ConfigCheck_T/";
		/*
		 * "D:" + File.separator + "DongYang" + File.separator + "Workspace1" +
		 * File.separator + "ConfigCheck_D" + File.separator + "src" +
		 * File.separator ;
		 */

		String PROPERTIES_FILE = dir_prop + "conf.properties";
		String SQL_FILE = dir_prop + "getInterfaceInfo.sql";
		SystemInfo_T.getInstance(SQL_FILE, PROPERTIES_FILE);		
		
	}

	
	/**********************************************************
	 * 운영 : 쿼리, 설정 파일 읽어오기
	 * 운영은 테스트 환경/개발환경과 연동이 불가능하여, DB관련한 0,1,2,11번은 
	 * 인터페이스 관리 시스템에서 씀.
	 * 컨피그 파일이 위치한 디렉토리명을 바꿔주어야함.
	 ***********************************************************/	
	public void getProperties_M() {

		// property 파일과 sql 파일이 있을 디렉토리 지정.
		
		/** 서버 버전 **/
		String dir_prop = "/var/mte/ConfigCheck_M/";
		
		
		/** PC 버전 **/
		/*String dir_prop = "C:" + File.separator + "WAS" + File.separator + "Tomcat50" +
		File.separator + "webapps" + File.separator + "IFM" + File.separator ;
		*/
		
		String PROPERTIES_FILE = dir_prop + "conf.properties";
		String SQL_FILE = dir_prop + "getInterfaceInfo.sql";
		SystemInfo_M.getInstance(SQL_FILE, PROPERTIES_FILE);
	}
	
	/**********************************************************
	 * 운영 : 쿼리, 설정 파일 읽어오기
	 * 운영은 테스트 환경/개발환경과 연동이 불가능하여, DB관련한 0,1,2,11번은 
	 * 인터페이스 관리 시스템에서 씀.
	 * 컨피그 파일이 위치한 디렉토리명을 바꿔주어야함.
	 ***********************************************************/	
	public void getProperties_M_PC() {

		// property 파일과 sql 파일이 있을 디렉토리 지정.
		
		/** 서버 버전 **/
		//String dir_prop = "/var/mte/ConfigCheck_M/";
		
		
		/** PC 버전 **/
		String dir_prop = "C:" + File.separator + "WAS" + File.separator + "Tomcat50" +
		File.separator + "webapps" + File.separator + "IFM" + File.separator ;
		
		
		String PROPERTIES_FILE = dir_prop + "conf.properties";
		String SQL_FILE = dir_prop + "getInterfaceInfo.sql";
		SystemInfo_M.getInstance(SQL_FILE, PROPERTIES_FILE);
	}


	/*************************************************************************************
	 * 개발 : 01_IM_INTERFACE_MNG_TMP 테이블에 반영
	 * @param req
	 * @param res
	 * @throws Exception
	 **************************************************************************************/
	public void _01_insertDBInterfaceInfo_tmp_D(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			// 임시 테이블에 반영.	
			_01_insertDBInterfaceInfo_tmp insertDBInterfaceInfo_tmp = new _01_insertDBInterfaceInfo_tmp();
			insertDBInterfaceInfo_tmp.insertDBInterfaceInfo_tmp(true);
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has succeeded(TMP).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has failed(TMP). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
		
		
	}


	/*************************************************************************************
	 * 개발 : 02_IM_INTERFACE_MNG 테이블에 반영
	 * @param req
	 * @param res
	 * @throws Exception
	 **************************************************************************************/
	public void _02_insertDBNewInterfaceInfo_D(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			// 임시 테이블에 반영.	
			_02_insertDBNewInterfaceInfo insertDBNewInterfaceInfo = new _02_insertDBNewInterfaceInfo();
			insertDBNewInterfaceInfo.insertDBNewInterfaceInfo(); 
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has succeeded(MNG).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has failed(MNG). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
		
		
	}


	public void _03_createConfig_D(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);	
		
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "03_createConfig.log";
			
			lm.writeLog("===================================================================");
			lm.writeLog("반영날짜 : " + SystemInfo.date);
			lm.writeLog("===================================================================");
			
			System.out.println("===================================================================");
			System.out.println("반영날짜 : " + SystemInfo.date);			
			
			
			String configWhere = "and " + SystemInfo.not_mng +
			" and run_date like '" + SystemInfo.date + "%' \n";
			_03_createNewCommonConfigFile_D createNewCommonConfigFile_D = new _03_createNewCommonConfigFile_D();
			createNewCommonConfigFile_D.doCreate(configWhere);
			System.out.println("03_전문 인터페이스 컨피그 생성이 완료되었습니다.");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config file creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config file creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _04_createFileConfig(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
	
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "04_createFileConfig.log";
			String fileWhere = " and \n " + SystemInfo.not_mng +
			"	and RUN_DATE like '" + SystemInfo.date + "%'\n" ;		
			_04_createFileConfig createFileConfig = new _04_createFileConfig();
			createFileConfig.createFileConfig(fileWhere);
			System.out.println("04_파일 인터페이스 컨피그 생성이 완료되었습니다.");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('File Config file creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('File Config file creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _05_createFepPutGetConfig(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "05_createFepPutGetConfig.log";
			_05_createFepPutGet_D_NEW createFepPutGet_D_NEW = new _05_createFepPutGet_D_NEW();
			createFepPutGet_D_NEW.createFepPutGet_D_NEW();
			System.out.println("05_대외계 전문 컨피그 생성이 완료되었습니다(fep_put.xml, fep_get.xml).");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP Config file creation succeeded(fep_put.xml, fep_get.xml).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP Config file creation failed(fep_put.xml, fep_get.xml). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _06_createFepFtePutConfig(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "06_createFepFtePutConfig.log";
			_06_createFepFtePut_D createFepFtePut_D = new _06_createFepFtePut_D();
			createFepFtePut_D.createFepFtePut_D();
			
			System.out.println("06_대외계 파일 컨피그 생성이 완료되었습니다(fepfteput.xml).");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP FILE Config file creation succeeded(fepfteput.xml).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP FILE Config file creation failed(fepfteput.xml). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _07_createEaiGetConfig(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "07_createEaiGetConfig.log";
			String eaigetWhere = "and " + SystemInfo.not_mng + " \n" +
								"and run_date like '" + SystemInfo.date + "'	\n" ;
			_07_createEaiGet_NEW createEaiGet_NEW = new _07_createEaiGet_NEW();
			createEaiGet_NEW.createEaiGet_NEW(eaigetWhere);
			
			System.out.println("07_eai_get.xml 생성이 완료되었습니다.");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('eai_get.xml creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('eai_get.xml creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _08_createMqscScript(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "08_createMqscScript.log";
			String mqscWhere = "where run_date like '" + SystemInfo.date + "%' \n" +
								"and \n" +
								SystemInfo.not_mng ;
								
			_08_ScriptCreate ScriptCreate = new _08_ScriptCreate();
			ScriptCreate.ScriptCreate(mqscWhere);
			
			System.out.println("08_큐 스크립트 생성이 완료되었습니다.");
			System.out.println("===================================================================");
			
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('MQSC script creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('MQSC script creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _09_sendConfig(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "09_sendConfig.log";		
			_09_rcp rcp = new _09_rcp();
			rcp.rcp();
			
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config File distribution has been completed')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config File Distribution failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _10_executeReload(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "10_reloadProcess.log";
			_10_executeReload executeReload = new _10_executeReload();
			executeReload.executeReload();
			
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config reloading was successful.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Reloading config failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	public void _11_commitIntfInfo(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_D();
				
			_00_commonDAO commonDAO = new _00_commonDAO();
			SystemInfo.date = commonDAO.getRealReflectDate(SystemInfo.table_mng);
			SystemInfo.dir_config_daily = SystemInfo.dir_config + File.separator + SystemInfo.date + File.separator;
			SystemInfo.dir_log_daily = SystemInfo.dir_log + File.separator + SystemInfo.date + File.separator + "11_commitIntfInfo.log";
			_11_commitIntfInfo commitIntfInfo = new _11_commitIntfInfo();
			commitIntfInfo.commitIntfInfo();
			
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Reflect the date has been updated.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Failed to reflect the date. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	

	/*************************************************************************************
	 * 테스트 : 01_IM_INTERFACE_MNG_TMP 테이블에 반영
	 * @param req
	 * @param res
	 * @throws Exception
	 **************************************************************************************/
	public void _01_insertDBInterfaceInfo_tmp_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			// 임시 테이블에 반영.
			_01_insertDBInterfaceInfo_tmp_T insertDBInterfaceInfo_tmp_T = new _01_insertDBInterfaceInfo_tmp_T();
			insertDBInterfaceInfo_tmp_T.insertDBInterfaceInfo_tmp_T(true);
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has succeeded(TMP).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			e.printStackTrace();
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has failed(TMP). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
		
		
	}


	/*************************************************************************************
	 * 테스트 : 02_IM_INTERFACE_MNG 테이블에 반영
	 * @param req
	 * @param res
	 * @throws Exception
	 **************************************************************************************/
	public void _02_insertDBNewInterfaceInfo_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			// 임시 테이블에 반영.	
			_02_insertDBNewInterfaceInfo_T insertDBNewInterfaceInfo = new _02_insertDBNewInterfaceInfo_T();
			insertDBNewInterfaceInfo.insertDBNewInterfaceInfo_T(); 
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has succeeded(MNG).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			e.printStackTrace();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Interface reflection has failed(MNG). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
		
		
	}

	public void _03_createConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);			
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "03_createConfig.log";
			
			
			LogManager_T lm = LogManager_T.getInstance();
			lm.writeLog("===================================================================");
			lm.writeLog("반영날짜 : " + SystemInfo_T.date);
			lm.writeLog("===================================================================");
			
			System.out.println("===================================================================");
			System.out.println("반영날짜 : " + SystemInfo_T.date);			
			
			
			String configWhere = " and run_date like '" + SystemInfo_T.date + "%' \n" 
					 				+ SystemInfo_T.notStg_mng;
			_03_createNewCommonConfigFile_T createNewCommonConfigFile_T = new _03_createNewCommonConfigFile_T();
			createNewCommonConfigFile_T.doCreate(configWhere);
			
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config file creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config file creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	
	/********************************************************************************************
	 * 테스트 환경 : 파일 인터페이스 컨피그 파일 생성.
	 * @param req
	 * @param res
	 * @throws Exception
	 *********************************************************************************************/
	public void _04_createFileConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "04_createFileConfig.log";
			
			
			String fileWhere = "	and run_date like '" + SystemInfo_T.date + "%'\n" 
								+ SystemInfo_T.notStg_mng;			
			_04_createFileConfig_T createFileConfig = new _04_createFileConfig_T();
			createFileConfig.createFileConfig_T(fileWhere);
				
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('File Config file creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			e.printStackTrace();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('File Config file creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	
	/******************************************************************************************************
	 * 테스트 : fep_put.xml, fep_get.xml 작성
	 * @param req
	 * @param res
	 * @throws Exception
	 *******************************************************************************************************/
	public void _05_createFepPutGetConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "05_createFepPutGetConfig.log";
			_05_createFepPutGet_T createFepPutGet_T = new _05_createFepPutGet_T();
			createFepPutGet_T.createFepPutGet_T();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP Config file creation succeeded(fep_put.xml, fep_get.xml).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			e.printStackTrace();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP Config file creation failed(fep_put.xml, fep_get.xml). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	/**********************************************************************************************************
	 * 테스트 : fepfteput.xml 작성
	 * @param req
	 * @param res
	 * @throws Exception
	 ***********************************************************************************************************/
	public void _06_createFepFtePutConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "06_createFepFtePutConfig.log";
			_06_createFepFtePut_T createFepFtePut_T = new _06_createFepFtePut_T();
			createFepFtePut_T.createFepFtePut_T();
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP FILE Config file creation succeeded(fepfteput.xml).')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('FEP FILE Config file creation failed(fepfteput.xml). Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	
	/******************************************************************************************************
	 * 테스트 : eai_get.xml 파일 작성
	 * @param req
	 * @param res
	 * @throws Exception
	 *******************************************************************************************************/
	public void _07_createEaiGetConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "07_createEaiGetConfig.log";
			String eaigetWhere = "	and run_date like '" + SystemInfo_T.date + "'	\n" 
									+ SystemInfo_T.notStg_mng;								
			_07_createEaiGet_NEW_T createEaiGet_NEW_T = new _07_createEaiGet_NEW_T();
			createEaiGet_NEW_T.createEaiGet_NEW_T(eaigetWhere);
		
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('eai_get.xml creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('eai_get.xml creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	/****************************************************************************************************
	 * 테스트 : mqsc 스크립트 파일 생성
	 * @param req
	 * @param res
	 * @throws Exception
	 *****************************************************************************************************/
	public void _08_createMqscScript_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "08_createMqscScript.log";
			String mqscWhere = "	where run_date like '" + SystemInfo_T.date + "%' \n"  +
									SystemInfo_T.notStg_mng;								
								
			_08_ScriptCreate_T ScriptCreate_T = new _08_ScriptCreate_T();
			ScriptCreate_T.ScriptCreate(mqscWhere);
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('MQSC script creation succeeded.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('MQSC script creation failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	/********************************************************************************************
	 * 테스트 : 컨피그 파일 전송
	 * @param req
	 * @param res
	 * @throws Exception
	 *********************************************************************************************/
	public void _09_sendConfig_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "09_sendConfig.log";		
			_09_rcp_T rcp = new _09_rcp_T();
			rcp.rcp();
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config File distribution has been completed')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config File Distribution failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	
	/********************************************************************************************
	 * mqsc 실행, 제타 재기동, mccube 컨피그 리로딩.
	 * @param req
	 * @param res
	 * @throws Exception
	 *********************************************************************************************/
	public void _10_executeReload_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "10_reloadProcess.log";
			_10_executeReload_T executeReload = new _10_executeReload_T();
			executeReload.executeReload();
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Config reloading was successful.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Reloading config failed. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}

	
	/************************************************************************
	 * 테스트 : 인터페이스 정보 DB(IFMGR) 에 반영 날짜 UPDATE.
	 * @param req
	 * @param res
	 * @throws Exception
	 *************************************************************************/
	public void _11_commitIntfInfo_T(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		PrintWriter out = res.getWriter();
		try{
			// 설정 파일 읽어오기.	
			getProperties_T();
				
			_00_commonDAO_T commonDAO = new _00_commonDAO_T();
			SystemInfo_T.date = commonDAO.getRealReflectDate(SystemInfo_T.table_mng);
			SystemInfo_T.dir_config_daily = SystemInfo_T.dir_config + File.separator + SystemInfo_T.date + File.separator;
			SystemInfo_T.dir_log_daily = SystemInfo_T.dir_log + File.separator + SystemInfo_T.date + File.separator + "11_commitIntfInfo.log";
			_11_commitIntfInfo_T commitIntfInfo = new _11_commitIntfInfo_T();
			commitIntfInfo.commitIntfInfo();
			
			
			
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Reflect the date has been updated.')");
			out.println("parent.close();");		
			out.println("</script>");
			
		}catch(Exception e){
			
			// 반영 후 메시지 박스.		
			out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
			out.println("alert('Failed to reflect the date. Please check the log.')");
			out.println("parent.close();");		
			out.println("</script>");
		}
	}


	

/*************************************************************************************
 * 운영 : 01_IM_INTERFACE_MNG_TMP 테이블에 반영
 * @param req
 * @param res
 * @throws Exception
 **************************************************************************************/
public void _01_insertDBInterfaceInfo_tmp_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		
		
		// 설정 파일 읽어오기.	
		getProperties_M_PC();
			
		
		
		// 임시 테이블에 반영.	
		_01_insertDBInterfaceInfo_tmp_M insertDBInterfaceInfo_tmp = new _01_insertDBInterfaceInfo_tmp_M();
		insertDBInterfaceInfo_tmp.insertDBInterfaceInfo_tmp();
		
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Interface reflection has succeeded(TMP).')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Interface reflection has failed(TMP). Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
	
	
}


/*************************************************************************************
 * 운영 : 02_IM_INTERFACE_MNG 테이블에 반영
 * @param req
 * @param res
 * @throws Exception
 **************************************************************************************/
public void _02_insertDBNewInterfaceInfo_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M_PC();
			
		// 임시 테이블에 반영.	
		_02_insertDBNewInterfaceInfo_M insertDBNewInterfaceInfo = new _02_insertDBNewInterfaceInfo_M();
		insertDBNewInterfaceInfo.insertDBNewInterfaceInfo(); 
	
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Interface reflection has succeeded(MNG).')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Interface reflection has failed(MNG). Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
	
	
}

public void _03_createConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
		LogManager_M lm = LogManager_M.getInstance();
		
		
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);	
	
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "03_createConfig.log";
		
		lm.writeLog("===================================================================");
		lm.writeLog("반영날짜 : " + SystemInfo_M.date);
		lm.writeLog("===================================================================");
		
		System.out.println("===================================================================");
		System.out.println("반영날짜 : " + SystemInfo_M.date);			
		System.out.println("===================================================================");
		
		String configWhere = SystemInfo_M.not_mng +
		" and run_date like '" + SystemInfo_M.date + "%' \n";
		_03_createNewCommonConfigFile_M createNewCommonConfigFile = new _03_createNewCommonConfigFile_M();
		createNewCommonConfigFile.doCreate(configWhere);
		
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Config file creation succeeded.')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Config file creation failed. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/*********************************************************************
 * 운영 : 04_파일인터페이스 컨피그 생성
 * @param req
 * @param res
 * @throws Exception
 **********************************************************************/
public void _04_createFileConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;

		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "04_createFileConfig.log";
		String fileWhere = "	where RUN_DATE like '" + SystemInfo_M.date + "%'\n" +
							SystemInfo_M.not_mng;		
		_04_createFileConfig_M createFileConfig = new _04_createFileConfig_M();
		createFileConfig.createFileConfig(fileWhere);
		
				
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('File Config file creation succeeded.')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('File Config file creation failed. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/***********************************************************************
 * 05_fep_put.xml , fep_get.xml 생성
 * @param req
 * @param res
 * @throws Exception
 **********************************************************************/
public void _05_createFepPutGetConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "05_createFepPutGetConfig.log";
		
		_05_createFepPutGet_M createFepPutGet = new _05_createFepPutGet_M();
		createFepPutGet.createFepPutGet();
				
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('FEP Config file creation succeeded(fep_put.xml, fep_get.xml).')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('FEP Config file creation failed(fep_put.xml, fep_get.xml). Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/*******************************************************************************
 * fepfteput.xml 파일 작성
 * @param req
 * @param res
 * @throws Exception
 ********************************************************************************/
public void _06_createFepFtePutConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "06_createFepFtePutConfig.log";
		_06_createFepFtePut_M createFepFtePut = new _06_createFepFtePut_M();
		createFepFtePut.createFepFtePut();
		
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('FEP FILE Config file creation succeeded(fepfteput.xml).')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('FEP FILE Config file creation failed(fepfteput.xml). Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/******************************************************************************************************
 * eai_get.xml 파일을 생성합니다.
 * @param req
 * @param res
 * @throws Exception
 *******************************************************************************************************/
public void _07_createEaiGetConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "07_createEaiGetConfig.log";
		String eaigetWhere = SystemInfo_M.not_mng + " \n" +
							"and run_date like '" + SystemInfo_M.date + "'	\n" ;
		_07_createEaiGet_M createEaiGet = new _07_createEaiGet_M();
		createEaiGet.createEaiGet(eaigetWhere);
	
	
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('eai_get.xml creation succeeded.')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('eai_get.xml creation failed. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/*****************************************************************************************
 * 운영 : 08_큐 스크립트 생성.
 * @param req
 * @param res
 * @throws Exception
 ****************************************************************************************/
public void _08_createMqscScript_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "08_createMqscScript.log";
		String mqscWhere = "where run_date like '" + SystemInfo_M.date + "%' \n" +							
							SystemInfo_M.not_mng ;
							
		_08_ScriptCreate_M ScriptCreate = new _08_ScriptCreate_M();
		ScriptCreate.ScriptCreate(mqscWhere);
		
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('MQSC script creation succeeded.')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('MQSC script creation failed. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/*****************************************************************************************
 * 운영 : 컨피그 배포 : PC 수행
 * @param req
 * @param res
 * @throws Exception
 ****************************************************************************************/
public void _09_sendConfig_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "09_sendConfig.log";		
		_09_rcp_M rcp = new _09_rcp_M();
		rcp.rcp();
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Config File distribution has been completed')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Config File Distribution failed. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/***************************************************************
 * 자동 리로드 : 운영환경은 안함.
 * @param req
 * @param res
 * @throws Exception
 *****************************************************************/
public void _10_executeReload_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('In the operating environment can not be automatic reloading')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('In the operating environment can not be automatic reloading')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}

/************************************************************************
 * 운영 : 개발 환경 디비에 반영 날짜 입력 : PC 수행
 * @param req
 * @param res
 * @throws Exception
 *************************************************************************/
public void _11_commitIntfInfo_M(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
	try{
		// 설정 파일 읽어오기.	
		getProperties_M_PC();
			
		_00_commonDAO_M commonDAO = new _00_commonDAO_M();
		SystemInfo_M.date = commonDAO.getRealReflectDate(SystemInfo_M.table_mng);
		SystemInfo_M.dir_config_daily = SystemInfo_M.dir_config + File.separator + SystemInfo_M.date + File.separator;
		SystemInfo_M.dir_log_daily = SystemInfo_M.dir_log + File.separator + SystemInfo_M.date + File.separator + "11_commitIntfInfo.log";
		_11_commitIntfInfo_M commitIntfInfo = new _11_commitIntfInfo_M();
		commitIntfInfo.commitIntfInfo();
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Reflect the date has been updated.')");
		out.println("parent.close();");		
		out.println("</script>");
		
	}catch(Exception e){
		
		// 반영 후 메시지 박스.		
		out.println("<script language=\"JavaScript\" type=\"text/JavaScript\">");
		out.println("alert('Failed to reflect the date. Please check the log.')");
		out.println("parent.close();");		
		out.println("</script>");
	}
}




}


