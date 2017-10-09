<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Exam
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Exams</a></li>
        <li class="active">Exam</li>
      </ol>
    </section>
     
     <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-12">
        <div class="box">
            <div class="box-header with-border">
              <div id="clockdiv">Time Left : <span id="time"><s:property value="duration" />:00</span> mins</div>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body"><div class="examid" style="display: none"><s:property value="id" /></div>
                <s:iterator value="questionList" status="status">
                	<div class="questions" style="margin-top: 2%; font-size: 18px;">
                	<div class="qid" style="display: none"><s:property value="id" /></div>
                		<s:property value="#status.count" />. <s:property value="question" />
                		<br/><br/><input type="radio" name="<s:property value="id" />" value="<s:property value="answer1" />"><s:property value="answer1" /> 
                		<br/><input type="radio" name="<s:property value="id" />" value="<s:property value="answer2" />"><s:property value="answer2" />
                		<br/><input type="radio" name="<s:property value="id" />" value="<s:property value="answer3" />"><s:property value="answer3" /> 
                		<br/><input type="radio" name="<s:property value="id" />" value="<s:property value="answer4" />"><s:property value="answer4" />
                	</div>
                </s:iterator>
                <div style="margin-top: 2%;">
	                <input type="button" id='previous' value="Previous Question" class="btn btn-default">
	                <input type="button" id='next' value="Next Question" class="btn btn-default">
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              	<div class="pull-right">
          			<input type="submit" id="btn_saveexam" value="Submit Exam" class="btn btn-success"/>
                </div>
              </div>
              <!-- /.box-footer -->
          </div>
        </div>
        </div>
     </section>
    </div>
    <style type="text/css">
    #clockdiv{
	font-family: sans-serif;
	
	font-weight: 100;
	text-align: center;
	font-size: 25px;
}
	div.required-field::before{ 
	    color: red;
	    content: "*";
	    float: right;
	    margin-bottom: -20px;
	    position: relative;
	    right: -8px;
	}
	</style>
	