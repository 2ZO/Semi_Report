
	var sel_files=[];
	var path=getContextPath();
	
	$(document).ready(function() {
		// iframe에 글을 쓸 수 있음
		dhtmlframe.document.designMode = "On";	
		
		//a link로 input
		$("#input_imgs").on("change", handleImgFileSelect);				
		
	});
		
	
	// iframe에 editor 기능들 적용
	function htmledit(execute,values)
	{
	        if(values==null)
	        {
	                dhtmlframe.document.execCommand(execute);
	        }
	        else	        	
	        {
	                dhtmlframe.document.execCommand(execute,"",values);
	        }
	}
	
	//글 등록 확인
	function datasubmit()
	{
		form.content.value = dhtmlframe.document.body.innerHTML;
		return confirm('글을 등록하겠음?');		
	}
    
	
	var sel_files = [];
	 
    function fileUploadAction() {
        console.log("fileUploadAction");
        $("#input_imgs").trigger('click');
    }

    function handleImgFileSelect(e) {


        var files = e.target.files;
        var filesArr = Array.prototype.slice.call(files);

        var index = 0;
        filesArr.forEach(function(f) {
        	sel_files = [];
        
            $(".imgs_wrap").empty();

        	
        	if(!f.type.match("image.*")) {
                alert("확장자는 이미지 확장자만 가능합니다.");
                return;
            }

            sel_files.push(f);
            var reader = new FileReader();
            reader.onload = function(e) {
            	var html = "<a href=\"javascript:void(0);\" onclick=\"inputImag("+index+")\"  id=\"putImg\"><img src=\"" + e.target.result + "\" data-file='"+f.name+"' class='selProductFile' title='Click to remove'></a>";
                $(".imgs_wrap").append(html);
                index++;
            }
            reader.readAsDataURL(f);
            
        });
    }
    
    
    
    function inputImag(i) {
    	var formData = new FormData(); 
		formData.append("postImg", $("#input_imgs")[0].files[i]);
		var img_path=null;
	$.ajax({
		type:"post",
		processData: false, 
		contentType: false,
		dataType:"json", 
		data: formData, 
		url:path+"/DispatcherServlet?command=addPostImg",
		success:function(data){
			img_path=path+"/Image/postImg/"+data.fileName;
			$("#dhtmlframe").contents().find("body").append("<img src=\""+img_path+"\">");
			}
		});//ajax
		
	}
    
    function getContextPath(){
        var offset=location.href.indexOf(location.host)+location.host.length;
        var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
        return ctxPath;
    }

    
    function submitAction() {
        console.log("submitAction()");
        $("#submit_post").trigger('click');
    }
    function cancelAction() {
        console.log("CancelAction()");
        $("#cancel_post").trigger('click');
    }

    function fileUploadAction() {
        console.log("fileUploadAction");
        $("#input_imgs").trigger('click');
    }


  