$.getScript("../includes/js/validation-script.js", function(){
	});


$('form').submit(function(event){
	
	  event.preventDefault();
	  var form = $(this);
	  var action=form.attr("action");
	  var formId=form.attr("id");
	  var req = $("#"+formId).serialize();
		$.ajax({type:'POST',
	        dataType:'json',
	        url:action+"Action.action",
			cache:false,
			data:req,
			success:function(data){
				var json=eval(data);       //Untested, but should give an idea - JSON
			    alert(json.message);
			    },
			});
	});

function resetForm(formID) {
    document.getElementById(formID).reset();
}

function resetExamForm(formID) {
	location.reload();
}

$(document).ready(function() {
	
	$("#topic").change(function() {
		
		$("#subTopic").html("");
		$("#questioncount").html("");
		var topicId=$("#topic").val();
		var items="";
		$.ajax({
			type:'POST',
	        dataType:'json',
	        url:"getSubTopicByTopicAction.action",
			cache:false,
			data:"topicId="+topicId,
			success:function(data){
				var json=eval(data);       //Untested, but should give an idea - JSON
				items+= '<option value=-1>' + '-Select-' + '</option>';
				for ( var i = 0; i < json.subTopicList.length; i++) {
					items+= '<option value=' + json.subTopicList[i].id + '>' + json.subTopicList[i].name + '</option>';
	           }
				$("#subTopic").html(items); 
			},
		});
	});
	
	$("#subTopic").change(function() {
		
		var subTopicId=$("#subTopic").val();
		if(subTopicId!=-1){
			var items="";
			$.ajax({
				type:'POST',
		        dataType:'json',
		        url:"getQuestionCountBySubTopicAction.action",
				cache:false,
				data:"subTopicId="+subTopicId,
				success:function(data){
					$("#questioncount").html("Total questions avaialble:"+data.questionCount);
				},
			});
		}
	});
	
	if(window.location.href.indexOf("editQuestionAction") > -1)
	{
		$("#subTopic").html("");
		var topicId=$("#topic").val();
		var items="";
		$.ajax({
			type:'POST',
	        dataType:'json',
	        url:"getSubTopicByTopicAction.action",
			cache:false,
			data:"topicId="+topicId,
			success:function(data){
				var json=eval(data);       //Untested, but should give an idea - JSON
				for ( var i = 0; i < json.subTopicList.length; i++) {
					items+= '<option value=' + json.subTopicList[i].id + '>' + json.subTopicList[i].name + '</option>';
	           }
				$("#subTopic").html(items); 
			},
		});
	}
	
	$("#addButton").click(function () {

		var subTopicName= $("#subTopic option:selected").text();
		var id = subTopicName.replace(/ /g,'');
		var subTopicId=$("#subTopic").val();
		var questionCountText = $("#questioncount").text().split(":");
		var questions = $("#question").val();
		var subTopicQuestionMapping = subTopicId+"-"+questions;
		var pattern = /^[1-9][0-9]*$/;
		if(subTopicName!=="" && subTopicName!=="-Select-"){
			if (pattern.test(questions)) {
				if(parseInt(questions)<=parseInt(questionCountText[1])){
				  if(($("#"+id).val())==subTopicName){
			            $("#n"+id).val(questions);
			        } else{
			            $("#TextBoxContainer").append('<input type="text" class="text-field" id="'+id+'" value="'+subTopicName+'" readonly="readonly"/> '+
			            '<input type="text" id="n'+id+'" class="questions" value="'+questions+'" readonly="readonly"/>'+
			            '<input type="text" id="i'+id+'" name="subTopicQuestionMappings" value="'+subTopicQuestionMapping+'" /><br/>');
			            $('#btn_submitexam').prop('disabled', false);
			        }
				} else{
					alert("Questions must not be more than total questions available!");
				}
	        } else{
	        	alert("Enter valid question value");
	        }
		} else{
        	alert("Select valid topic & subtopic value");
        }
	});
	
	$('#previous').hide();
	var item1 = document.getElementById('questions');
	var totalQuestions = $('.questions').size();
	var currentQuestion = 0;
	var previousQuestion = 1;
	$questions = $('.questions');
	$questions.hide();
	$($questions.get(currentQuestion)).fadeIn();
	$('#next').click(function(){
		$('#previous').show();
	    $($questions.get(currentQuestion)).fadeOut(function(){
	        currentQuestion = currentQuestion + 1;
	        if(currentQuestion == totalQuestions-1){
	        	$('#next').hide();
	        	$($questions.get(currentQuestion)).fadeIn();
	        }else{
	        	$($questions.get(currentQuestion)).fadeIn();
	        }
	    });
	});
	$('#previous').click(function(){
		$('#next').show();
		$($questions.get(currentQuestion)).fadeOut(function(){
	        currentQuestion = currentQuestion - 1;
	        if(currentQuestion == 0){
	        	$('#previous').hide();
	        	$($questions.get(currentQuestion)).fadeIn();
	        }else{
	        	$($questions.get(currentQuestion)).fadeIn();
	        }
	    });
    });
	
	$('#btn_saveexam').click(function(){
		submitExam();
	});
});

function submitExam(){
	var examId=$('.examid').text();
	jsonObj = [];
	$('.qid').each(function() {
		
		var questionId = $(this).text();
		if($('input[name="'+questionId+'"]').is(':checked')){
			var selectedAnswer = $('input[name="'+questionId+'"]:checked').val();
			item = {}
			item["questionId"] = questionId;
			item["isSelected"] = "yes";
			item["selectedAnswer"] = selectedAnswer;
			jsonObj.push(item);
		} else{
			item = {}
			item["questionId"] = questionId;
			item["isSelected"] = "no";
			jsonObj.push(item);
		}
	});
	
	var dataObj = {
		    "examSubmissionDetails": jsonObj , "id": examId
		};
	var data1 = JSON.stringify(dataObj);
	$.ajax({
		type:'POST',
        dataType:'json',
        url:"saveExamResult.action",
		cache:false,
		data:data1,
		contentType:"application/json;charset=utf-8",
		async: true,
		success:function(data){
			var json=eval(data);       //Untested, but should give an idea - JSON
		    alert(json.message);
		    window.location = "getExamsAction";
		},
	});  
}

if(window.location.href.indexOf("loadExamAction") > -1){
	var time=$('#time').text();
	var duration = time.split(":");
	var totalDuration = 60 * duration[0], //in seconds
	display = document.querySelector('#time');
	 
	 startTimer(totalDuration, display);
}

function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    var interVal=setInterval(function () {
        minutes = parseInt(timer/60, 10)
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            //submitExam();
        	clearInterval(interVal)
        }
    }, 1000);
}
function getUser(userID)
{
	$.ajax({url:"userDetailsAction.action",
		cache:false,
		data:"userID="+userID,
		success:function(data){$("#dynamic_div").html(data);},
		type:"post"
		});
}

function saveEntity(formId,formName,actionName)
{
//	var res= validateForm(formName);
//	if(!res)
//		{return false;}
	if($("#formId")[0].checkValidity()) {
	var req = $("#"+formId).serialize();
	$.ajax({type:'POST',
        dataType:'json',
        url:actionName+"Action.action",
		cache:false,
		data:req,
		success:function(data){
			var json=eval(data);       //Untested, but should give an idea - JSON
		    alert(json.message);
		    window.location.reload();},
		});
	}
}

function deleteEntity(id,actionName)
{
	var result = confirm("Are you sure to delete?");
	if (result) {
		$.ajax({type:'POST',
	        dataType:'json',
	        url: actionName+"Action.action",
			cache:false,
			data:"id="+id,
			success:function(data){
				var json=eval(data);       //Untested, but should give an idea - JSON
			    alert(json.message); 
			    window.location.reload();},
		});
	}
}

function saveCategory()
{
	var res= validateCategoryForm();
	if(!res)
		{return false;}
	var req = $("#add_category_id").serialize();
	$.ajax({url:"createCategoryAction.action",
		cache:false,
		data:req,
		success:function(data){$("#category_dynamic_div").html(data);},
		type:"post"
		});
}

function updateCategory()
{
	var res= validateCategoryForm();
	if(!res)
		{return false;}
	var req = $("#add_category_id").serialize();
	$.ajax({url:"updateCategoryAction.action",
		cache:false,
		data:req,
		success:function(data){$("#category_dynamic_div").html(data);},
		type:"post"
		});
}

function saveProduct()
{
	var res= validateProductForm();
	if(!res)
	{return false;}
	var req = $("#add_product_id").serialize();
	$.ajax({url:"createProductAction.action",
		cache:false,
		data:req,
		success:function(data){$("#product_dynamic_div").html(data);},
		type:"post"
		});
}

function updateProduct()
{
	var res= validateProductForm();
	if(!res)
	{return false;}
	var req = $("#add_product_id").serialize();
	$.ajax({url:"updateProductAction.action",
		cache:false,
		data:req,
		success:function(data){$("#product_dynamic_div").html(data);},
		type:"post"
		});
}
