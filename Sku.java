package com.sku;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
public class Sku {
   public static String[] str={"v11v22v31","v11v22v33",
	   "v11v22v34","v11v22v35","v11v22v36","v11v22v39",
	   "v11v23v32","v11v23v33","v11v23v34","v11v23v35",
	   "v11v23v36","v11v23v37","v11v23v39",
	   "v11v24v31", "v11v24v32", "v11v24v33", "v11v24v34",
	   "v11v24v35", "v11v24v36", "v11v24v37", "v11v24v39",
	   "v11v25v31", "v11v25v33", "v11v25v35", "v11v25v38",
	   "v11v25v39", "v11v26v31","v11v26v33","v11v26v34",
	   "v11v26v35","v11v28v31","v11v28v32","v11v28v33",
	   "v11v28v34","v11v28v35","v11v28v36","v11v28v37",
	   "v11v28v39",};
   public static int[] num={1,1,1,1,1,1,1,1,1,1,1,1,1,1,
	   1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	   };
   public static List<String> newstr1=new ArrayList<String>();
   public static List<String> newstr2=new ArrayList<String>();
   public static List<String> newstr3=new ArrayList<String>();
	public static List<String> newresult=new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date=new Date();
		process(str);
		selectSku("v35");
		Date end=new Date();
		long time=end.getTime()-date.getTime();
		for(int i=0;i<newresult.size();i++){
			System.out.println(newresult.get(i));
		}
		System.out.println(time);
	}
	public static void process(String[] str){
		for(int i=0;i<str.length;i++){
			if(num[i]!=0){
			newstr1.add(str[i].substring(0,3));	
			newstr2.add(str[i].substring(3,6));
			newstr3.add(str[i].substring(6,9));
			}
		}
 	/*	  HashSet h1  =   new  HashSet(newstr1);
		  newstr1.clear();
		  newstr1.addAll(h1);
		  HashSet h2  =   new  HashSet(newstr2);
		  newstr2.clear();
		  newstr2.addAll(h2);
		  HashSet h3  =   new  HashSet(newstr3);
		  newstr3.clear();
		  newstr3.addAll(h3); 
		  List<String>[] test=null;
		  List<String> list=new ArrayList<String>();
		  int k=0;
		  for(int j=0;j<str.length;j++)
		  {		  
			  	if(str[j].substring(0,3).equals(newstr1.get(k))){
				  for(int m=0;m<str.length;m++){
					  if(str[m].substring(0,3).equals(newstr1.get(k)))
						  list.add(str[j].substring(3,6));
					  if(str[m].substring(3,6).equals(str[j].substring(3,6)))
						  list.add(str[m].substring(6,9));
				  }
				  HashSet h4  =   new  HashSet(list);
				  list.clear();
				  list.addAll(h4); 
				  list.add("null");
			  	}
		  }*/
	}
	public static List<String> selectSku(String input){
		List<String> list=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		List<String> list3=new ArrayList<String>();
		List<String> result=new ArrayList<String>();
		String[] newinput=new String[input.length()/3];
		int[] flag=new int[input.length()/3];
		for(int i=0;i<input.length()/3;i++){
			newinput[i]=input.substring(i*3,i*3+3);
			if(input.charAt(i*3+1)=='1'){
				flag[i]=1;
			}
			if(input.charAt(i*3+1)=='2'){
				flag[i]=2;
			}
			if(input.charAt(i*3+1)=='3'){
				flag[i]=3;
			}
		}
		for(int j=0;j<newinput.length;j++){
			if(flag[j]==1){
				for(int k=0;k<newstr1.size();k++){
					if(newstr1.get(k).equals(newinput[j])){
						list.add(newstr2.get(k));
						list.add(newstr3.get(k));
					}
				}
			}
			if(flag[j]==2){
				for(int k=0;k<newstr2.size();k++){
					if(newstr2.get(k).equals(newinput[j])){
						list2.add(newstr1.get(k));
						list2.add(newstr3.get(k));
					}
				}
			}
			if(flag[j]==3){
				for(int k=0;k<newstr3.size();k++){
					if(newstr3.get(k).equals(newinput[j])){
						list3.add(newstr1.get(k));
						list3.add(newstr2.get(k));
					}
				}
			}
		}
		if(list.size()!=0){
			if(list2.size()!=0){
				for (String integer : list) {//遍历list1
		            if (list2.contains(integer)) {//如果存在这个数
		                result.add(integer);//放进一个list里面，这个list就是交集
		            }
		        }
			}
			else{
				result=list;
			}
			if(list3.size()!=0){
				for (String integer : result) {//遍历list1
		            if (list3.contains(integer)) {//如果存在这个数
		                newresult.add(integer);//放进一个list里面，这个list就是交集
		            }
		        }
			}
			else{
				newresult=result;
			}
		}
		else{
			if(list2.size()!=0){
				if(list3.size()!=0){
				for (String integer : list3) {//遍历list1
		            if (list2.contains(integer)) {//如果存在这个数
		                newresult.add(integer);//放进一个list里面，这个list就是交集
		            }
		        	}
				}
				else{
					newresult=list2;
				}
			}
			else{
				if(list3.size()!=0){
					newresult=list3;
				}
				else
					newresult=null;
			}	
		}
		  HashSet h1  =   new  HashSet(newresult);
		  newresult.clear();
		  newresult.addAll(h1);
		return newresult;
	}

}
