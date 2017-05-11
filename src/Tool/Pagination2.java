package Tool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Pagination2 {
	static int renum;//数据库中所有数据
	static int pagenow;//当前页
	static int pagesize;//每页显示数据数
	static int pagenum;//总页数
	public static int Renum(List list){
		int i=0;
		for(;i<list.size();i++);
		renum=i;
		return renum;
	}
	public static int Pagenum(int pagesize,int renum){
		pagenum=renum%pagesize==0?renum/pagesize:renum/pagesize+1;
		return pagenum;
	}
	public static String Page(int pagenow,int pagenum){
		int i;
		String page="<script type='text/javascript'> function jump(){var jump=document.getElementById('jump');alert(jump.value);if(jump.value>0&&jump.value<="+pagenum+"){location.href='test?pagenow='+jump.value}else{alert('请输入正确的页数')}}</script><table> <tr> <td><input type='text' name='jump' id='jump'><input type='button' value='跳转' onclick='jump()'>当前页 "+pagenow+"/总页数"+pagenum+"";
		if(pagenow>1){
			page=page+"&nbsp<a href='test?pagenow="+(pagenow-1)+"'>上一页</a>";
		}
		String page2="";
		if(pagenow<=pagenum-2){
			int j=pagenow+3;
			i=pagenow;
			do{		
			page2=page2+"&nbsp;&nbsp<a href='test?pagenow="+i+"'>"+i+"</a>";
			i++;
			}while(i<j&&i<=pagenum);
		}else{
			for(i=pagenum-2;i<=pagenum;i++){
			page2=page2+"&nbsp;&nbsp<a href='test?pagenow="+i+"'>"+i+"</a>";
			}
		}
		page=page+page2;
		if(pagenow<pagenum){
			page=page+"&nbsp<a href='test?pagenow="+(pagenow+1)+"'>下一页</a></td></tr></table>";
		}
		return page;
	}
	public static List dateList(int pagenow,List list,int pagesize){
		List list2=new ArrayList();
		for(int i=(pagenow-1)*pagesize;i<pagenow*pagesize&&i<list.size();i++){	
			list2.add(list.get(i));
		}
		return list2;
	}
}
