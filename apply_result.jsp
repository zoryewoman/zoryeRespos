<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="com.eai.makeconfig.bean.InterfaceInfoBean"%>
<%@ page import="com.eai.db.QueryEntity"%>
<%
	request.setCharacterEncoding("euc-kr");
%>

<html>

<head>
<title>Interface Information Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../js/default.js"></script>

</head>

<body>
<!-- Result Block Start -->
<div id="resultDiv" style="display:inline">
<!-- Result Table : begin -->
<table width="740" cellspacing="0" border="1" class="tbl02" cellpadding="0" bordercolorlight="#B5B5B5" bordercolordark="#FFFFFF" frame="below" >
	
<%
QueryEntity queryEntity = (QueryEntity)request.getAttribute("intfInfoBeanList");
	
int currPage=1;
int total_size=0;//데이터 카운트
if(queryEntity!=null)
    total_size=queryEntity.dataCnt;

int pageSize=100;//데이터 카운트 -- 한페이지내
int blockSize=10; //페이지 카운트 -- 한 블록내

try{
	currPage=Integer.parseInt((String)request.getAttribute("pageNo"));
} catch(Exception e){}
if(currPage<1) currPage=1;

try{
	total_size=Integer.parseInt((String)request.getAttribute("total_size"));
} catch(Exception e){}

int totalpage = total_size/pageSize + ( (total_size%pageSize)>0? 1:0 );

int blockStartPage = ((currPage-1)/blockSize)*blockSize+1;
int currentBlock = ((currPage-1)/blockSize)+1;  // block
int a=0;
int c=0;

    for ( int idx = 0; idx<queryEntity.getRowCnt(); idx++) {
    	
    	//a=Integer.parseInt(queryEntity.getValue(idx, "ROWNUM").toString());
    	//if(c<a){c=a;}
    	
	}%>
&nbsp;&nbsp;Total : <%=total_size%>
<% %>
  <tr>
  	 <td nowrap class="tt02" width="10">
	  <input type="checkbox" name="chkallmonitor" 
	onclick="checkAll()" class="chkbx" onFocus="blur()">
	</td>
  	<td nowrap class="tt02" width="50">IF_NO</td>
    <td nowrap class="tt02" width="300">IF_ID</TD>
    <td nowrap class="tt02" width="100">송신 시스템</TD>
    <td nowrap class="tt02" width="100">수신 시스템</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(송신/개발)</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(수신/개발)</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(송신/테스트)</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(수신/테스트)</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(송신/운영)</TD>
    <td nowrap class="tt02" width="150">최종 수정 날짜<BR>(수신/운영)</TD>
  </tr>
  
  <%
	
	//QueryEntity queryEntity = (QueryEntity)request.getAttribute("intfInfoBeanList");
	if (queryEntity != null && queryEntity.getRowCnt() > 0)
		{
			for (int idx = 0; idx < queryEntity.getRowCnt(); idx++)
			{

  %>
  <tr onMouseOver="this.style.background='#F5F5F5'" onMouseOut="this.style.background=''">
  	<td align="center" class="td02" style="text-align:left;" >
  	<!-- <td align="center" class="td02" style="text-align:left;" ><a href="/eai/confmng/reflectionIntf_ifmgr.jsp?IF_NO=<%=queryEntity.getValue(idx, "IF_NO") %>&BIZ_IF_ID=<%=queryEntity.getValue(idx, "IF_ID") %>" target="_blank"><%=queryEntity.getValue(idx, "IF_NO") %></a></td>     
     -->
     	<input type="checkbox" name="chk" value="<%=idx%>" onFocus="blur()" onClick="javascript:chkCnt(this)">
  	 <input  type="hidden" name="IF_NO_RESULT" value="<%=queryEntity.getValue(idx, "IF_NO")%>">
	      <input type="hidden" name="IF_ID_RESULT" value="<%=queryEntity.getValue(idx, "IF_ID")%>">
	       	 <input  type="hidden" name="SNDSYS_CODE" value="<%=queryEntity.getValue(idx, "SNDSYS_CODE")%>">
	      <input type="hidden" name="RCVSYS_CODE" value="<%=queryEntity.getValue(idx, "RCVSYS_CODE")%>">
	      <input type="hidden" name="SNDSVC" value="<%=queryEntity.getValue(idx, "SNDSVC")%>">
	      <input type="hidden" name="RCVSVC" value="<%=queryEntity.getValue(idx, "RCVSVC")%>">
  	</td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "IF_NO")%></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "IF_ID") %></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "SNDSYS_CODE") %></td>
    
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "RCVSYS_CODE")%></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "SNDSET_EAI_DEV")==null?"":queryEntity.getValue(idx, "SNDSET_EAI_DEV")%></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "RRCVSET_EAI_DEV")==null?"":queryEntity.getValue(idx, "RRCVSET_EAI_DEV") %></td>
    
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "SNDSET_EAI_TEST")==null?"":queryEntity.getValue(idx, "SNDSET_EAI_TEST")%></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "RRCVSET_EAI_TEST")==null?"":queryEntity.getValue(idx, "RRCVSET_EAI_TEST") %></td>
        <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "SNDSET_EAI_REAL")==null?"":queryEntity.getValue(idx, "SNDSET_EAI_REAL")%></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "RCVSET_EAI_REAL")==null?"":queryEntity.getValue(idx, "RCVSET_EAI_REAL") %></td>
    
<!--    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "DATA_LENGTH") %></td>
    <td align="center" class="td02" style="text-align:left;" ><%=queryEntity.getValue(idx, "ETC")==null?"":queryEntity.getValue(idx, "ETC")%></td>
     -->
    
    
  	
  </tr>

  <%
		}
	}
  %>
</table>
<!-- Result Table : end -->


<!-- Page : start -->
<div class="page" style="width: 740px;">
<% 
   

    if(currentBlock > 1) {
%>
    <a href="javascript:search(<%=(blockStartPage - blockSize)%>)"><img src="../images/btn_begin.gif" width="16" height="13" hspace="3" border="0" align="absmiddle"></a>
<% 
    }

    if(currPage > 1) {
%>
    <a href="javascript:search(<%=(currPage-1)%>)"><img src="../images/btn_prev.gif" width="13" height="13" hspace="3" border="0" align="absmiddle"></a>&nbsp;&nbsp;
<% 
    }

    if( totalpage>1) {
        for(int idx=blockStartPage; (idx < blockStartPage+blockSize ) && (idx <= totalpage)  ; idx++){
            if(idx>blockStartPage) out.print(" | ");
            if(idx == currPage){
                out.print(idx );
            } else {
                out.print("<a href='javascript:search("+idx+")'>"+ idx +"</a>");
            }
        }
    }

    if(currPage < totalpage) { //nextPage
%>
    &nbsp;&nbsp;
    <a href="javascript:search(<%=(currPage+1)%>)"><img src="../images/btn_next.gif" width="13" height="13" hspace="3" border="0" align="absmiddle"></a>
<% 
    }

    int blockLastPage = blockStartPage+blockSize-1;
    if(blockLastPage < totalpage) { //nextBlock
%>
    <a href="javascript:search(<%=(blockStartPage + blockSize)%>)"><img src="../images/btn_end.gif" width="16" height="13" hspace="3" border="0" align="absmiddle"></a>
<% 
    }
%>
</div>
<!-- Page : end -->
<div class="div_btn" style="width: 740px;">

<%
	//if(intfInfoBeanList.size()>0) {
%>
  <table height="20" border="0" cellpadding="0" cellspacing="0">
    <tr>     
    <!-- <td height="20"></td>
      <td height="20">개발 반영 날짜&nbsp;&nbsp;&nbsp;<input name="RUN_DATE" type="text" value="" style="width:100px;height:20px;">&nbsp;&nbsp;&nbsp;</td>
      <td height="20"></td>
      
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:reflectionToTMP();">개발 반영</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      -->
      
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_01_insertDBInterfaceInfo_tmp_D();">01.TMP테이블에 반영</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
     
      <td width="3"></td>
      
      
   
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_02_insertDBNewInterfaceInfo_D();">02.MNG테이블에 반영</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
 		
 	  <td width="3"></td>    
  
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_03_createConfig_D();">03.전문 컨피그 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
  	
	</tr>
	
	<tr>
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_04_createFileConfig();">04.파일 컨피그 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
      <td width="3"></td>
         
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_05_createFepPutGetConfig();">05.대외계 전문 컨피그 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
      <td width="3"></td>
         
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_06_createFepFtePutConfig();">06.fepfteput.xml 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
    </tr>
    
	
	<tr>
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_07_createEaiGetConfig();">07.eai_get.xml 컨피그 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
       <td width="3"></td>
         
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_08_createMqscScript();">08.큐 스크립트 파일 생성</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
      <td width="3"></td>
      
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_09_sendConfig();">09.컨피그 파일 전송</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
    </tr>
    <tr height="20"></tr>
    <tr>
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_10_executeReload();">10.컨피그리로딩(큐,제타,McCube)</a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
      
      <td width="3"></td>
         
      <td width="16" height="20" nowrap><img src="../img/btn_search01.gif" width="21" height="20"></td>
      <td class="btnc_com1"><a href="javascript:_11_commitIntfInfo();">11.반영 날짜 업데이트 </a></td>
      <td><img src="../img/btn_com02.gif" width="14" height="20"></td>
    
    </tr>
  </table>
<%
	//}
%>

</div>
</div><!-- Result Block End -->
  <form name="frm">
  <input name="pageNo" type="hidden" value="">
  </form>

</body>
</html>

<SCRIPT LANGUAGE="JavaScript">






function search(pgNo){
    frm.pageNo.value=pgNo;
    f = document.frm ;
    f.action = "/eai/servlet/OnlineStatus?command=getInterfaceStatus";
    f.target = '_self';
    f.method = 'post';
    f.submit();

}





parent.document.all.resultDiv.innerHTML=document.all.resultDiv.innerHTML;
parent.document.all.resultDiv.style.display="";

try{
parent.loading.style.visibility = "hidden";
}catch(ex){}

<%
    if(queryEntity!=null && queryEntity.getRowCnt()==0) {
%>
    alert("해당 데이터가 없습니다");
<%
}%>


//-->
</SCRIPT>