<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

"${no}"
"${vo.no }"
${vo.no };

xcxzcxzcxzcxzcxz
PrintWriter out = res.getWriter();
			String json = "";
			json += "[";
			json += "	{";
			json += "		'no': "+"'"+					vo.getNo()						+"'"+", ";
			json += "		'importance': "+"'"+ 	vo.getImportance()		+"'"+", ";
			json += "		'title': "+"'"+ 				vo.getTitle()						+"'"+", ";
			json += "		'content': "+"'"+ 		vo.getContent()				+"'"+", ";
			json += " 		'place' :"+"'"+				vo.getPlace()					+"'"+",";
			json += "		'start_date' :"+"'"+		vo.getStartDate()			+"'"+",";  
			json += "		'end_date' :"+"'"+		vo.getEndDate()				+"'"+","; 
			json += "		'importance' :"+"'"+	vo.getImportance()		+"'"+",";
			json += "		'latitude' :"+"'"+			vo.getLatitude()				+"'"+",";
			json += "		'longitude' :"+"'"+		vo.getLongitude()			+"'"+",";			
			json += "	}";
			json += "]";

			out.println(json);
			out.close();