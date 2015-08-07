/**
 * Plugin json2form 
 * version: 1.00
 * author: sunny
 */
jQuery.Json2form = {     
	
	/**
	 * 将 json 数据渲染成表单
	 * @param data
	 */
	render:function(data) {          
		$("body").append('<span class="wth6"><label for="">名单明细编号</label></span>'
		      +'<input type="text" value="" />');
	}         
}; 
